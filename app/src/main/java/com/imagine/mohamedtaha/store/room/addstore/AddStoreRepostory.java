package com.imagine.mohamedtaha.store.room.addstore;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.room.StoreAppDatabase;
import com.imagine.mohamedtaha.store.room.StoreDao;

public class AddStoreRepostory {
    private static AddStoreRepostory addStoreRepostory;
    private StoreDao storeDao;


   public AddStoreRepostory(Application application) {
        StoreAppDatabase appDatabase = StoreAppDatabase.getInstance(application);
        storeDao = appDatabase.storeDao();
    }

    public static AddStoreRepostory getInstance(Application application){
        if (addStoreRepostory != null){
            synchronized (AddStoreRepostory.class){
                if (addStoreRepostory != null){
                    addStoreRepostory = new AddStoreRepostory(application);
                }
            }
        }
        return addStoreRepostory;
    }
    public LiveData<PagedList<TableJobs>> getAllJobs(){
       PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
               .setEnablePlaceholders(true)
               .setPrefetchDistance(10)
               .setPageSize(20).build();
       return new LivePagedListBuilder<>(storeDao.getAllJobs(),pagedListConfig).build();

    }
    public void insertJob(final TableJobs tableJobs){
       StoreAppDatabase.writeExecuter.execute(new Runnable() {
           @Override
           public void run() {
               storeDao.insertJobs(tableJobs);
           }
       });

    }
}
