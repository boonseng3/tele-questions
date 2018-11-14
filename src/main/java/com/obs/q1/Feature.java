package com.obs.q1;

public class Feature {
    private String name;

    public Feature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Feature setName(String name) {
        this.name = name;
        return this;
    }
}
