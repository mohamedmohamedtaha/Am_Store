package com.imagine.mohamedtaha.store.model.relationships;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.imagine.mohamedtaha.store.model.TableEmployees;
import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.model.TablePermission;

import java.util.List;

public class EmployeesWithJobs {
    @Embedded
    public TableJobs tableJobs;
    @Relation(parentColumn = "id_jobs", entityColumn = "id_employee")
    public List<TableEmployees> tableEmployeesList;
}
