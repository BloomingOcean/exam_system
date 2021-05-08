package com.aizhixin.examination.question.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author null
 *
 */
public class IdQuestonUtil {

	/**
	 * 随机获取一个0-13717之间的随机数（作为limit的下标）
	 * 
	 * @return
	 */
	public static int getQuestionId() {
		ThreadLocalRandom r = ThreadLocalRandom.current();
		return r.nextInt(13717);
	}
}
