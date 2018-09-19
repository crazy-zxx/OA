package com.oa.action;

import java.util.Date;

import com.oa.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oa.entity.Reply;
import com.oa.entity.Topic;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	private Long topicId;

	/** 发表新回复页面 */
	public String addUI() throws Exception {
		// 准备数据：topic
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "addUI";
	}

	/** 发表新回复 */
	public String add() throws Exception {
		// 1，封装（已经封装了title, content, faceIcon）
		model.setTopic(topicService.getById(topicId));

		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());

		// 2，保存
		replyService.save(model);

		return "toTopicShow"; // 转到新回复所属主题的显示页面
	}

	// ------

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}
