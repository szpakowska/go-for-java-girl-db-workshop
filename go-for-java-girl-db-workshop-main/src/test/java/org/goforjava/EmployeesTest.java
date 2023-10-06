package org.goforjava;

import org.goforjava.db.DB;
import org.goforjava.db.DepartmentDB;
import org.goforjava.db.EmployeeDB;
import org.goforjava.domain.Department;
import org.goforjava.domain.Employee;
import org.junit.jupiter.api.BeforeEach;

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
