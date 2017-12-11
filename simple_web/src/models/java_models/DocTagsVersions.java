package models.java_models;

public class DocTagsVersions {
	public long id;
	public long doctagid; //this field is in relation from doctags.json field Id.
	public String title; //this field is changed from "Name" in DTO

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDoctagid() {
		return doctagid;
	}

	public void setDoctagid(long doctagid) {
		this.doctagid = doctagid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "DocTagsVersions{" +
				"id=" + id +
				", doctagid=" + doctagid +
				", title='" + title + '\'' +
				'}';
	}
}
