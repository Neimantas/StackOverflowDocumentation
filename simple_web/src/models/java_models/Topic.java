package models.java_models;

import java.util.Date;

public class Topic {
	long id;
	long docTagId; // this field is in relation from doctags.json field Id.
	String title;
	String answer; //  this field is changed from "RemarksMarkdown" in DTO
	Date creationDate;
	Date lastEditDate;
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDocTagId() {
		return docTagId;
	}

	public void setDocTagId(long docTagId) {
		this.docTagId = docTagId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Topic{" +
				"id=" + id +
				", docTagId=" + docTagId +
				", title='" + title + '\'' +
				", answer='" + answer + '\'' +
				'}';
	}
}
