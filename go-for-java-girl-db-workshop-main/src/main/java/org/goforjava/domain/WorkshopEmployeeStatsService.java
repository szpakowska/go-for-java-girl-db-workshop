package org.goforjava.domain;

import org.goforjava.db.DB;
import org.goforjava.db.EmployeeDB;
import java.util.Optional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class WorkshopEmployeeStatsService implements EmployeeStatsService{

    private final DB<Employee> employeeDB;
    private final DB<Department> departmentDB;

    public WorkshopEmployeeStatsService(DB<Employee> employeeDB, DB<Department> departmentDB) {
        this.employeeDB = employeeDB;
        this.departmentDB = departmentDB;
    }

    @Override
    public List<Employee> findEmployeesOlderThen(long years) {
        List<Employee> listOfEmployeesOlderThen = employeeDB.findAll()
                .stream()
                .filter(employee -> employee.getBirthDate().getYear() - LocalDate.now().getYear() >= years)
                .toList();

        return listOfEmployeesOlderThen;
    }

    @Override
    public List<Employee> findThreeTopCompensatedEmployees() {
        List<Employee> listOfThreeTopCompensatedEmployees = employeeDB.findAll()
                .stream()
                .sorted(Comparator.comparingLong(Employee::getGrossSalary).reversed())
                //.sorted((employee1, employee2) -> Long.compare(employee1.getGrossSalary(), employee2.getGrossSalary
                .limit(3)
                .toList();
        return listOfThreeTopCompensatedEmployees;
    }

    @Override
    public Optional<Department> findDepartmentWithLowestCompensationAverage() {
        // Obliczanie średniej wynagrodzeń w każdym departamencie
        Map<Id, Double> departmentAverageCompensation = employeeDB.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId,
                        Collectors.averagingDouble(employee -> employee.getGrossSalary().doubleValue())));

        // Znajdowanie ID departamentu z najniższą średnią wynagrodzeń
        Map.Entry<Id, Double> minAverage = departmentAverageCompensation.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        if (minAverage != null) {
            return departmentDB.findById(minAverage.getKey());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Employee> findEmployeesBasedIn(Localtion localtion) {
        List<Department> departmentsInLocation = departmentDB.findAll().stream()
                .filter(department -> department.getLocation().equals(localtion))
                .toList();

        List<Employee> employeesBasedInLocation = new ArrayList<>();

        for (Department department : departmentsInLocation) {
            List<Employee> employeesInDepartment = employeeDB.findAll().stream()
                    .filter(employee -> employee.getDepartmentId().equals(department.getId()))
                    .toList();

            employeesBasedInLocation.addAll(employeesInDepartment);
        }

        return employeesBasedInLocation;
    }

    @Override
    public Map<Integer, Long> countEmployeesByHireYear() {
        return employeeDB.findAll().stream()
                .collect(Collectors.groupingBy(employee -> employee.getHireDate().getYear(), Collectors.counting()));
    }

    @Override
    public Map<Localtion, Long> countEmployeesByLocation() {
        return employeeDB.findAll().stream()
                .map(employee -> departmentDB.findById(employee.getDepartmentId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.groupingBy(Department::getLocation, Collectors.counting()));
    }
}
