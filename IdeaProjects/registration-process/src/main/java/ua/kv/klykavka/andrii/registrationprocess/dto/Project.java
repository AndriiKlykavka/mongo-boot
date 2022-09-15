package ua.kv.klykavka.andrii.registrationprocess.dto;

public class Project {
    private String projectName;
    private String timestamp;
    private String compilationTime;
    private String result;


    public Project(String project, String timestamp, String compilationTime, String result) {
        this.projectName = project;
        this.timestamp = timestamp;
        this.compilationTime = compilationTime;
        this.result = result;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCompilationTime() {
        return compilationTime;
    }

    public void setCompilationTime(String compilationTime) {
        this.compilationTime = compilationTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toString(){

        return this.getProjectName() +", "+ this.getResult();
    }
}
