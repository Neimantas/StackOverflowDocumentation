package models.java_models.mock;

public class TopicMock {
	public long id=1;
	public DocTagsMock docTagId=new DocTagsMock(1,"test") ; // this field is in relation from doctags.json field Id.
	public String title="Java title";
	public String answer="Java java java answer"; //  this field is changed from "RemarksMarkdown" in DTO
	
	
}
