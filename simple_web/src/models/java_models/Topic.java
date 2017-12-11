package models.java_models;

public class Topic {
	public long id;
	public DocTags docTagId; // this field is in relation from doctags.json field Id.
	public String title;
	public String answer; //  this field is changed from "RemarksMarkdown" in DTO
}
