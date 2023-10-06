package org.goforjava.db;

import org.goforjava.domain.Department;
import org.goforjava.domain.Id;

import java.util.*;

public class DepartmentDB implements DB<Department> {

    private final Map<Id, Department> departmentMap = new HashMap<>();

    @Override
    public List<Department> findAll() {
        return List.of();
    }

    @Override
    public Optional<Department> findById(Id id) {
        return Optional.empty();
    }

    @Override
    public void put(Id id, Department toPut) {
        departmentMap.put(id, toPut);
    }
}
