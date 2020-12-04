package com.imagine.mohamedtaha.store.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.imagine.mohamedtaha.store.model.TableAds;
import com.imagine.mohamedtaha.store.model.TableColors;
import com.imagine.mohamedtaha.store.model.TableEmployees;
import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.model.TablePermission;
import com.imagine.mohamedtaha.store.model.relationships.EmployeesWithJobs;

import java.util.List;

public class StoreRepostory {
    private static StoreRepostory storeRepostory;
    private static StoreDao storeDao;
    private LiveData<List<TableJobs>> listLiveDataTableJobs;
    private LiveData<List<TablePermission>> listLiveDataTablePermission;
    private LiveData<List<TableEmployees>> listLiveDataTableEmployees;
    private LiveData<List<EmployeesWithJobs>> listLiveDataTableEmployeesWithJobs;

    public StoreRepostory(Application application) {
        StoreAppDatabase database = StoreAppDatabase.getInstance(application);
        storeDao = database.storeDao();
        //listLiveDataTableJobs = storeDao.getAllJobs();
        listLiveDataTablePermission = storeDao.getAllPermission();
        listLiveDataTableEmployees = storeDao.getAllEmployees();
        listLiveDataTableEmployeesWithJobs = storeDao.getEmployeesWithJobs();
    }

    public static StoreRepostory getInstance(Application application) {
        if (storeRepostory == null) {
            synchronized (StoreRepostory.class) {
                if (storeRepostory == null) {
                    storeRepostory = new StoreRepostory(application);
                }
            }
        }
        return storeRepostory;
    }

    public LiveData<List<TableJobs>> getallTableAJobs() {
        return listLiveDataTableJobs;
    }

    public LiveData<List<TablePermission>> getallTablePermission() {
        return listLiveDataTablePermission;
    }
    public LiveData<List<TableEmployees>> getallTableEmployees() {
        return listLiveDataTableEmployees;
    } public LiveData<List<EmployeesWithJobs>> getallTableAEmployeesWithJobs() {
        return listLiveDataTableEmployeesWithJobs;
    }
}
