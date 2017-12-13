package models.java_models;

import java.util.Date;

public class DocTags {
	public long id;
	public String title;
	Date creationDate;
	
	
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "DocTags{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}
