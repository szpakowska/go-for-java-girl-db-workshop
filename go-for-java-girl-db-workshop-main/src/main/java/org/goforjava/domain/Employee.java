package org.goforjava.domain;

import java.time.LocalDate;

public class Employee {
    private final Id id;
    private final String fullName;
    private final LocalDate birthDate;
    private final LocalDate hireDate;
    private final Long grossSalary;
    private final String positionName;
    private final Id departmentId;

    public Employee(Id id, String fullName, LocalDate birthDate, LocalDate hireDate, Long grossSalary, String positionName, Id departmentId) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.grossSalary = grossSalary;
        this.positionName = positionName;
        this.departmentId = departmentId;
    }

    public Id getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Long getGrossSalary() {
        return grossSalary;
    }

    public String getPositionName() {
        return positionName;
    }

    public Id getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", grossSalary=" + grossSalary +
                ", positionName='" + positionName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
