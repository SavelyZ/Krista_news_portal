package ru.architecture22.DO;

import java.util.UUID;

public class CategoryDO {
    UUID id;
    String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
