package com.example.denis.androidfinal.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.denis.androidfinal.Database.UserDatabase;
import com.example.denis.androidfinal.Entities.Task;
import com.example.denis.androidfinal.Repository.TaskRepository;
import com.example.denis.androidfinal.Repository.UserRepository;
import com.example.denis.androidfinal.vo.GetTasksRequest;
import com.example.denis.androidfinal.vo.TaskRequest;

import java.util.List;

public class TaskViewModel extends ViewModel
{

    private LiveData<List<Task>> taskLiveData;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskViewModel(Context context)
    {
        userRepository= UserRepository.getInstance(UserDatabase.getDatabase(context).getUserDao());
        taskRepository=TaskRepository.getInstance(UserDatabase.getDatabase(context).getTaskDao());
        taskLiveData = taskRepository.getCacheTasks();

    }

    public LiveData<List<Task>> getTasksLiveData() {
        return taskLiveData;
    }
    public void addTask(Task task){
        taskRepository.addTask(task);
    }

    public void deleteAll(){
        taskRepository.deleteAll();
    }
    public boolean getTasks(GetTasksRequest getTasksRequest)
    {
        return taskRepository.getTasks(getTasksRequest);
    }

    public void editTask(int id, String desc, String token) {
        TaskRequest taskRequest=new TaskRequest(desc, id);
        taskRequest.setToken(token);
        taskRepository.update(taskRequest);
    }

    public void updateTask(Task task){
        taskRepository.updateTask(task);
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        public Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new TaskViewModel(ctxt));
        }
    }
}

