package models.java_models.mock;

public class ExamplesMock {
	public long id = 2;
	public TopicMock docTopicId = new TopicMock(1, new DocTagsMock(3,"Java Test"),"java Klausimas", "java atsakymas"); //  this field is in relation from topics.json field Id.
	public String title = "example title";
	public String description = "example description"; //this field is changed from "BodyMarkdown" in DTO

}
