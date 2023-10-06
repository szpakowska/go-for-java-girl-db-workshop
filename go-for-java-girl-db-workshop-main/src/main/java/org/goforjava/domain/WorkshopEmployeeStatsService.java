package org.goforjava.domain;

import org.goforjava.db.DB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WorkshopEmployeeStatsService implements EmployeeStatsService{

    private final DB<Employee> employeeDB;
    private final DB<Department> departmentDB;

    public WorkshopEmployeeStatsService(DB<Employee> employeeDB, DB<Department> departmentDB) {
        this.employeeDB = employeeDB;
        this.departmentDB = departmentDB;
    }

    @Override
    public List<Employee> findEmployeesOlderThen(long years) {
        return List.of();
    }

    @Override
    public List<Employee> findThreeTopCompensatedEmployees() {
        return List.of();
    }

    @Override
    public Optional<Department> findDepartmentWithLowestCompensationAverage() {
        return Optional.empty();
    }

    @Override
    public List<Employee> findEmployeesBasedIn(Localtion localtion) {
        return List.of();
    }

    @Override
    public Map<Integer, Long> countEmployeesByHireYear() {
        return Map.of();
    }

    @Override
    public Map<Localtion, Long> countEmployeesByLocation() {
        return Map.of();
    }
}
