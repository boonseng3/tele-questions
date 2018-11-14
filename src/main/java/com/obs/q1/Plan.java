package com.obs.q1;

import java.util.Arrays;
import java.util.Objects;

public class Plan {
    private String name;
    private double cost;
    private Feature[] features;

    public Plan(String name, double cost, Feature[] features) {
        this.name = name;
        this.cost = cost;
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public Plan setName(String name) {
        this.name = name;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Plan setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public Plan setFeatures(Feature[] features) {
        this.features = features;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Double.compare(plan.cost, cost) == 0 &&
                Objects.equals(name, plan.name) &&
                Arrays.equals(features, plan.features);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, cost);
        result = 31 * result + Arrays.hashCode(features);
        return result;
    }
}
