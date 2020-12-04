package com.imagine.mohamedtaha.store.room.addstore;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;

import com.imagine.mohamedtaha.store.model.TableJobs;

public class AddStoreViewModel extends AndroidViewModel {
    private AddStoreRepostory addStoreRepostory;
    private LiveData<PagedList<TableJobs>> getAllJobs;

    public AddStoreViewModel(@NonNull Application application) {
        super(application);
        addStoreRepostory = new AddStoreRepostory(application);
        getAllJobs = addStoreRepostory.getAllJobs();
    }

    public LiveData<PagedList<TableJobs>> getAllJobs(){
        return getAllJobs;
    }
   // public static class Factory extends
    public void insertJob(final  TableJobs tableJobs){
        addStoreRepostory.insertJob(tableJobs);
    }
    public static class Factory extends ViewModelProvider.NewInstanceFactory{
        private final Application application;

        public Factory(Application application) {
            this.application = application;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //    return super.create(modelClass);
            return (T) new AddStoreViewModel(application);
        }
    }

}
