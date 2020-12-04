package com.imagine.mohamedtaha.store.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.imagine.mohamedtaha.store.model.TableAds;
import com.imagine.mohamedtaha.store.model.TableColors;
import com.imagine.mohamedtaha.store.model.TableEmployees;
import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.model.TablePermission;
import com.imagine.mohamedtaha.store.model.relationships.EmployeesWithJobs;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StoreDao {
    //--------------------- Start Table Permission ------------------------------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPermission(TablePermission... tablePermissions);

    @Query("UPDATE TablePermission SET  name_permission = :name_permission, notes = :notes WHERE id_permission = :id_permission")
    void updatePermission(String name_permission, String notes, int id_permission);

    @Query("SELECT * FROM TablePermission")
    LiveData<List<TablePermission>> getAllPermission();

    @Query("DELETE FROM TablePermission WHERE id_permission = :id_permission")
    void deletePermissionById(int id_permission);
    //--------------------- End Table Permission ------------------------------

    //--------------------- Start Table Jobs ------------------------------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertJobs(TableJobs... tableJobs);

    @Query("UPDATE TableJobs SET title_position = :title_position, notes = :notes WHERE id_jobs = :id_jobs")
    void updateJobs(int id_jobs, String title_position, String notes);

//    @Query("SELECT * FROM TableJobs")
//    LiveData<List<TableJobs>> getAllJobs();

    @Query("SELECT * FROM TableJobs")
    DataSource.Factory<Integer,TableJobs> getAllJobs();


    @Query("DELETE FROM TableJobs WHERE id_jobs = :id_jobs")
    void deleteJobsById(int id_jobs);

    //--------------------- End Table Jobs ------------------------------

    //--------------------- Start Table Employees ------------------------------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployees(TableEmployees... tableEmployees);

    @Query("UPDATE TableEmployees SET id_permission = :id_permission, id_jobs = :id_jobs, name_employee = :name_employee," +
            "phone_employee = :phone_employee ,address_employee = :address_employee ,email_employees = :email_employees," +
            " notes = :notes WHERE id_employee = :id_employee")
    void updateEmployees( int id_permission, int id_jobs, String name_employee, String phone_employee,
                         String address_employee, String email_employees, String notes,int id_employee);

    @Query("SELECT * FROM TableEmployees")
    LiveData<List<TableEmployees>> getAllEmployees();

    @Query("DELETE FROM TableEmployees WHERE id_employee = :id_employee")
    void deleteEmployeesById(int id_employee);
    //--------------------- Relationship TableEmployees with TableJobs ------------------------------
    @Transaction
    @Query("SELECT * FROM TableEmployees")
    public LiveData<List<EmployeesWithJobs>> getEmployeesWithJobs();
    //--------------------- End Table Employees ------------------------------


    //--------------------- Start Table Ads ------------------------------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAds(TableAds... tableAds);

    @Query("UPDATE TableAds SET id_employee = :id_employee, id_target_ads = :id_target_ads,id_platform_ads = :id_platform_ads," +
            "name_ads = :name_ads ,total_ads = :total_ads, total_target = :total_target,start_date_ads = :start_date_ads," +
            "end_date_ads = :end_date_ads WHERE id_ads = :id_ads")
    void updateAds(int id_employee, int id_target_ads, int id_platform_ads, String name_ads, String total_ads, String total_target,
                   String start_date_ads, String end_date_ads, int id_ads);

    @Query("SELECT * FROM TableAds")
    LiveData<List<TableAds>> getallTableAds();

    @Query("DELETE FROM TableAds WHERE id_ads = :id_ads")
    void deleteAdsById(int id_ads);

    //--------------------- End Table Ads ------------------------------

    //--------------------- Start Table colors ------------------------------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertColor(TableColors... tableColors);

    @Query("UPDATE TableColors SET  name_color = :name_color, createdDate = :createdDate, createdTime = :createdTime,notes = :notes WHERE id_color = :id_color")
    int updateColor(String name_color, String notes,String createdDate,String createdTime, int id_color);
//
//    @Query("UPDATE TableColors SET  name_color = :name_color, notes = :notes WHERE id_color = :id_color")
//    void updateColor(String name_color, String notes, int id_color);

//    @Query("SELECT * FROM TableColors")
//    LiveData<List<TableColors>> getAllColors();
//
//    @Query("DELETE FROM TableColors WHERE id_color = :id_color")
//    void deleteColorById(int id_color);

    @Query("SELECT * FROM TableColors")
    List<TableColors> getAllColors();

    @Query("DELETE FROM TableColors WHERE id_color = :id_color")
    int deleteColorById(int id_color);
    //--------------------- End Table colors ------------------------------


}
