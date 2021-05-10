package com.aizhixin.examination.answerrecord.dto;

import java.util.Date;
import java.util.List;

import com.aizhixin.examination.question.dto.QuestionOptionDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "答题详细记录实体")
@NoArgsConstructor
@Data
public class RecordQuestionDTO {
	@ApiModelProperty(dataType = "Int",name = "id",value = "试题题目id")
	private String id;
	
	@ApiModelProperty(dataType = "String",name = "CONTENT",value = "试题题干")
	private String content;
	
	@ApiModelProperty(dataType = "String",name = "ANSWER",value = "试题的正确答案")
	private String answer;
	
	@ApiModelProperty(dataType = "String",name = "KNOWLEDGE_AREA",value = "知识领域")
	private String knowledgeArea;
	
	@ApiModelProperty(dataType = "Date",name = "answer_time",value = "答题时间")
	private Date answerTime;
	
	@ApiModelProperty(dataType = "String",name = "submit_Answers",value = "用户选择的选项")
	private String submitAnswers;
	
	@ApiModelProperty(name = "questionOptions",value = "试题选项")
	private List<QuestionOptionDTO> questionOptions;

}
