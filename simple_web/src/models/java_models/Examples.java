package models.java_models;

public class Examples {
	long id;
	long docTopicId; //  this field is in relation from topics.json field Id.
	String title;
	String description; //this field is changed from "BodyMarkdown" in DTO

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDocTopicId() {
		return docTopicId;
	}

	public void setDocTopicId(long docTopicId) {
		this.docTopicId = docTopicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Examples{" +
				"id=" + id +
				", docTopicId=" + docTopicId +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
