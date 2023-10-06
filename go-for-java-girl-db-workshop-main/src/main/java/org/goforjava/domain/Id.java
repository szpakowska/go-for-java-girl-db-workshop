package org.goforjava.domain;

import java.util.Objects;

public class Id {
    private final String key;

    public Id(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Id of(String key) {
        return new Id(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(key, id.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
