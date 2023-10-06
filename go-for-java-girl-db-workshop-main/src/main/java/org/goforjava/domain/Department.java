package org.goforjava.domain;

public class Department {
    private final Id id;
    private final String name;
    private final Localtion location;

    public Department(Id id, String name, Localtion location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Localtion getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }

}
