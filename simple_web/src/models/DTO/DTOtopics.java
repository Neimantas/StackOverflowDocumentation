package models.DTO;

import java.sql.Date;

public class DTOtopics {
	long Id;
    long DocTagId;
    boolean IsHelloWorldTopic;
    String Title;
    String CreationDate;
    long ViewCount;
    String LastEditDate;
    long LastEditUserId;
    long ContributorCount;
    long ExampleCount;
    long ExampleScore;
    String SyntaxHtml;
    String ParametersHtml;
    String RemarksHtml;
    String IntroductionMarkdown;
    String SyntaxMarkdown;
    String ParametersMarkdown;
    String RemarksMarkdown;
    String HelloWorldVersionsHtml;

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

    public boolean isHelloWorldTopic() {
        return IsHelloWorldTopic;
    }

    public void setHelloWorldTopic(boolean helloWorldTopic) {
        IsHelloWorldTopic = helloWorldTopic;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public long getViewCount() {
        return ViewCount;
    }

    public void setViewCount(long viewCount) {
        ViewCount = viewCount;
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

    public long getContributorCount() {
        return ContributorCount;
    }

    public void setContributorCount(long contributorCount) {
        ContributorCount = contributorCount;
    }

    public long getExampleCount() {
        return ExampleCount;
    }

    public void setExampleCount(long exampleCount) {
        ExampleCount = exampleCount;
    }

    public long getExampleScore() {
        return ExampleScore;
    }

    public void setExampleScore(long exampleScore) {
        ExampleScore = exampleScore;
    }

    public String getSyntaxHtml() {
        return SyntaxHtml;
    }

    public void setSyntaxHtml(String syntaxHtml) {
        SyntaxHtml = syntaxHtml;
    }

    public String getParametersHtml() {
        return ParametersHtml;
    }

    public void setParametersHtml(String parametersHtml) {
        ParametersHtml = parametersHtml;
    }

    public String getRemarksHtml() {
        return RemarksHtml;
    }

    public void setRemarksHtml(String remarksHtml) {
        RemarksHtml = remarksHtml;
    }

    public String getIntroductionMarkdown() {
        return IntroductionMarkdown;
    }

    public void setIntroductionMarkdown(String introductionMarkdown) {
        IntroductionMarkdown = introductionMarkdown;
    }

    public String getSyntaxMarkdown() {
        return SyntaxMarkdown;
    }

    public void setSyntaxMarkdown(String syntaxMarkdown) {
        SyntaxMarkdown = syntaxMarkdown;
    }

    public String getParametersMarkdown() {
        return ParametersMarkdown;
    }

    public void setParametersMarkdown(String parametersMarkdown) {
        ParametersMarkdown = parametersMarkdown;
    }

    public String getRemarksMarkdown() {
        return RemarksMarkdown;
    }

    public void setRemarksMarkdown(String remarksMarkdown) {
        RemarksMarkdown = remarksMarkdown;
    }

    public String getHelloWorldVersionsHtml() {
        return HelloWorldVersionsHtml;
    }

    public void setHelloWorldVersionsHtml(String helloWorldVersionsHtml) {
        HelloWorldVersionsHtml = helloWorldVersionsHtml;
    }

    @Override
    public String toString() {
        return "DTOtopics{" +
                "Id=" + Id +
                ", DocTagId=" + DocTagId +
                ", IsHelloWorldTopic=" + IsHelloWorldTopic +
                ", Title='" + Title + '\'' +
                ", CreationDate='" + CreationDate + '\'' +
                ", ViewCount=" + ViewCount +
                ", LastEditDate='" + LastEditDate + '\'' +
                ", LastEditUserId=" + LastEditUserId +
                ", ContributorCount=" + ContributorCount +
                ", ExampleCount=" + ExampleCount +
                ", ExampleScore=" + ExampleScore +
                ", SyntaxHtml='" + SyntaxHtml + '\'' +
                ", ParametersHtml='" + ParametersHtml + '\'' +
                ", RemarksHtml='" + RemarksHtml + '\'' +
                ", IntroductionMarkdown='" + IntroductionMarkdown + '\'' +
                ", SyntaxMarkdown='" + SyntaxMarkdown + '\'' +
                ", ParametersMarkdown='" + ParametersMarkdown + '\'' +
                ", RemarksMarkdown='" + RemarksMarkdown + '\'' +
                ", HelloWorldVersionsHtml='" + HelloWorldVersionsHtml + '\'' +
                '}';
    }
}
