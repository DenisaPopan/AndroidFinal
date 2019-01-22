package com.example.denis.androidfinal.vo;

import com.example.denis.androidfinal.Entities.Task;

import java.util.List;

public class RequestObject {
    private String requestType;
    private List<Task> tasks;
    private String token;

    public RequestObject(String requestType, List<Task> tasks, String token) {
        this.requestType = requestType;
        this.tasks = tasks;
        this.token = token;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
