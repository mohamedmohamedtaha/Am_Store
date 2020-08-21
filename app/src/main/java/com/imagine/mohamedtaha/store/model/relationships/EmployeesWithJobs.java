package com.imagine.mohamedtaha.store.model.relationships;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.imagine.mohamedtaha.store.model.TableEmployees;
import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.model.TablePermission;

import java.util.List;

public class EmployeesWithJobs {
    @Embedded public TableEmployees tableEmployees;
    @Relation( parentColumn = "id_employee", entityColumn = "id_jobs")
    public List<TableJobs>tableJobsList;
    @Relation( parentColumn = "id_employee", entityColumn = "id_permission")
    public List<TablePermission>tablePermissionList;
}
