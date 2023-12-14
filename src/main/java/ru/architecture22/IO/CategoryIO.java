package ru.architecture22.IO;

import java.util.UUID;

public class CategoryIO {
    UUID id;
    String name;

    public CategoryIO() {
    }

    public CategoryIO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
