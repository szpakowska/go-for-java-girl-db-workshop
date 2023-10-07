package org.goforjava;

import org.goforjava.db.DB;
import org.goforjava.db.DepartmentDB;
import org.goforjava.db.EmployeeDB;
import org.goforjava.domain.Department;
import org.goforjava.domain.Employee;
import org.goforjava.domain.Localtion;
import org.goforjava.domain.WorkshopEmployeeStatsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class EmployeesTest {
    public DB<Employee> employeeDB = new EmployeeDB();
    public DB<Department> departmentDB = new DepartmentDB();

    MockDataFactory mockDataFactory = new MockDataFactory(employeeDB, departmentDB);

    @BeforeEach
    void setupTests() {
      mockDataFactory.populateDepartments();
      mockDataFactory.populateEmployees();
    }



    }

