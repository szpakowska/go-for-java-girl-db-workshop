package org.goforjava.db;

import org.goforjava.domain.Employee;
import org.goforjava.domain.Id;

import java.util.*;

public class EmployeeDB implements DB<Employee> {

    private final Map<Id, Employee> employeeMap = new HashMap<>();

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Optional<Employee> findById(Id id) {
        return Optional.empty();
    }

    @Override
    public void put(Id id, Employee toPut) {
        employeeMap.put(id, toPut);
    }
}
