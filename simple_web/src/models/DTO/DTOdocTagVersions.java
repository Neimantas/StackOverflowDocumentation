package models.DTO;

import java.sql.Date;

public class DTOdocTagVersions {
	long Id;
    long DocTagId;
    String Name;
    String  CreationDate;
    String  LastEditDate;
    long LastEditUserId;
    String ReleaseDate;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getDocTagId() {
        return DocTagId;
    }

    public void setDocTagId(long docTagId) {
        DocTagId = docTagId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getLastEditDate() {
        return LastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        LastEditDate = lastEditDate;
    }

    public long getLastEditUserId() {
        return LastEditUserId;
    }

    public void setLastEditUserId(long lastEditUserId) {
        LastEditUserId = lastEditUserId;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }
}
