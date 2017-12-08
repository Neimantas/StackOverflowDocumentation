package models.java_models;

public class Topic {
	long id;
	DocTags docTagId; // this field is in relation from doctags.json field Id.
	String title;
	String answer; //  this field is changed from "RemarksMarkdown" in DTO
}
