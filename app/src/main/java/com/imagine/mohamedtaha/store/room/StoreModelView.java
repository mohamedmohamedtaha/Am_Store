package com.imagine.mohamedtaha.store.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.imagine.mohamedtaha.store.model.TableEmployees;
import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.model.TablePermission;
import com.imagine.mohamedtaha.store.model.relationships.EmployeesWithJobs;

import java.util.List;

public class StoreModelView extends AndroidViewModel {
    private StoreRepostory storeRepostory;
    private LiveData<List<TableJobs>> listLiveDataTableJobs;
    private LiveData<List<TablePermission>> listLiveDataTablePermission;
    private LiveData<List<TableEmployees>> listLiveDataTableEmployees;
    private LiveData<List<EmployeesWithJobs>> listLiveDataTableEmployeesWithJobs;
    public StoreModelView(@NonNull Application application) {
        super(application);
        storeRepostory = StoreRepostory.getInstance(application);
        listLiveDataTableJobs = storeRepostory.getallTableAJobs();
        listLiveDataTablePermission = storeRepostory.getallTablePermission();
        listLiveDataTableEmployees = storeRepostory.getallTableEmployees();
        listLiveDataTableEmployeesWithJobs = storeRepostory.getallTableAEmployeesWithJobs();
    }
}
