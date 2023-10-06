package org.goforjava.db;

import org.goforjava.domain.Employee;
import org.goforjava.domain.Id;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeDBTest {
    DB<Employee> employeeDB = new EmployeeDB();

    @Test
    void shouldFindEmployeeById() {
        //given
        Id id = Id.of("id-1");
        employeeDB.put(id, getTestEmployee(id));

        //when
        var employee = employeeDB.findById(id);

        //then
        assertTrue(employee.isPresent());
        assertEquals(id, employee.get().getId());
    }

    @Test
    void shouldFindAll() {
        //given
        employeeDB.put(Id.of("id-1"), getTestEmployee(Id.of("id-1")));
        employeeDB.put(Id.of("id-2"), getTestEmployee(Id.of("id-2")));
        employeeDB.put(Id.of("id-3"), getTestEmployee(Id.of("id-3")));

        //when
        var employees = employeeDB.findAll();

        //then
        assertEquals(3, employees.size());
    }

    private static Employee getTestEmployee(Id id) {
        return new Employee(id, "full-name",
                LocalDate.of(1995, 1, 1),
                LocalDate.of(2020, 1, 1),
                1234L,
                "test-position", Id.of("department-1"));
    }

}
