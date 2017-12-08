package models.java_models.mock;



public class DocTagsVersionsMock {
	public long id=1;
	public DocTagsMock doctagid= new DocTagsMock(1,"test") ; //this field is in relation from doctags.json field Id.
	public String title="test1"; //this field is changed from "Name" in DTO
}
