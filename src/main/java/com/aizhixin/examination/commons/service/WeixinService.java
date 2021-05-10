package com.aizhixin.examination.commons.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * weixin 登录凭证校验
 * openId 用户唯一标识，还有一个unionid(同一个企业下的多个服务号、公众号、小程序同一个用户的标识)，也是用户唯一标识，这两个都不是微信号。各种服务号、公众号、小程序等等微信三方服务，都是获取不到用户微信号的。
 * RestTemplate spring 提供的http访问的方便的工具(网络爬虫，其实就是http各种访问)。
 * JAVA做http请求的工具很多，一般最基础的是HttpURLConnection（java自身携带的）、apache HTTP组件(commons-httpclient和HttpClient(使用广泛，功能完备))、netty（高效）、spring RestTemplate
 * jsckson(FasterXML) json数据格式处理库，系统框架缺省包含，不需要在引入其他包（也能处理xml、yaml）。第三方包引入是有风险的，尽量使用现有的第三方工具。 很方便对json数据和java的pojo对象进行转换
 * https://developers.weixin.qq.com/miniprogram/dev/api-backend/auth.code2Session.html
 * @author zhen.pan
 *
 */
@Component
@Transactional
@Slf4j
public class WeixinService {
    private String weixinUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=";

    @Value("${wx.appId}")
    private String appId = "wx8f615bc611845df9";

    @Value("${wx.appSecret}")
    private String appSecurity = "4920c1f93f4a5d8747a4d1fb0df7d383";
    
    //{"errcode":40163,"errmsg":"code been used, hints: [ req_id: hanENa0300th50 ]"}
    //{"session_key":"EBheKA10Xdg3nWOqA4UsqA==","openid":"o8OrG5RUasGr18b6o7tLVOBkwUFY"}
    /**
     * 
     * @param code 微信授权码
     * @return openid码
     */
    public String getWeixinOpenInfo(String code) {
        RestTemplate rest = new RestTemplate();
        StringBuilder sb = new StringBuilder(weixinUrl);
        sb.append(appId).append("&secret=").append(appSecurity);
        sb.append("&js_code=").append(code).append("&grant_type=authorization_code");
        //GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        String json = rest.getForObject(sb.toString(), String.class);//用户所有信息
        System.out.println("微信传过来的用户数据：" + json);
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();//解析json的工具
        try {
            JsonNode root = mapper.readTree(json);//开始解析json
            if (root.has("errcode")) {
                log.warn("获取OpenId失败，code:{},errcode:{}, errmsg:{}", code, root.get("errcode").intValue(), root.get("errmsg").textValue());
            } else {
                JsonNode node = root.get("openid");
                root.get("country");
                root.get("sex");
                root.get("city");
                root.get("nickname");
                if (null != node) {
                	//可以用一个变量来获取openid在另一个程序使用
                    return node.textValue();
                }
            }

        } catch (Exception e) {
            log.warn("调用微信小程序获取openid失败：{}", e);
        }
        return null;
    }
    //
//  public static void main(String[] args) {
//      WeixinService t = new WeixinService ();
////      System.out.println(t.getWeixinOpenInfo("071FV75x1TDHFa07FD3x1KT65x1FV75p"));
//      System.out.println(t.getWeixinOpenInfo("1234567"));
//  }
}
