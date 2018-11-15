package com.obs.q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlanSelector {

    public List<List<Plan>> getCheaptest(Plan[] allPlans, Feature[] selectedFeatures) {
        // filter plans that do not have any of the selected features
        List<Plan> filteredPlans = Arrays.asList(allPlans).stream().filter(plan -> planContainsAnyFeature(plan, selectedFeatures))
                .collect(Collectors.toList());
        int[] n = IntStream.range(0, filteredPlans.size())
                .toArray();

        List<List<Plan>> possiblePlans = new ArrayList<>();
        for (int r = 1; r <= n.length; r++) {
            // combination of all the plans, using the index as plan
            int[][] plansCombination = Combination.combination(n, r);

            for (int[] plansIndex : plansCombination) {
                List<Plan> plans = new ArrayList<>();
                for (int planIndex : plansIndex) {
                    plans.add(filteredPlans.get(planIndex));
                }
                possiblePlans.add(plans);
            }
        }
        // plans that contains all the selected features
        possiblePlans = possiblePlans.stream()
                .filter(plans -> plansContainsAllFeature(plans.toArray(new Plan[plans.size()]), selectedFeatures))
                .collect(Collectors.toList());

        // get the cheapest plans
        List<List<Plan>> cheapest = new ArrayList();
        for (List<Plan> plans : possiblePlans) {
            double totalCost = plans.stream().map(plan -> plan.getCost())
                    .reduce((aDouble, aDouble2) -> aDouble + aDouble2).get();
            if (cheapest.isEmpty()) {
                cheapest.add(plans);
            } else {
                double currentCheapest = cheapest.get(0).stream().map(plan -> plan.getCost())
                        .reduce((aDouble, aDouble2) -> aDouble + aDouble2).get();
                if (currentCheapest > totalCost) {
                    cheapest.clear();
                    cheapest.add(plans);
                } else if (currentCheapest == totalCost) {
                    cheapest.add(plans);
                }
            }
        }
        return cheapest;


    }

    public boolean planContainsAnyFeature(Plan plan, Feature[] selectedFeatures) {
        for (int i = 0; i < selectedFeatures.length; i++) {
            for (int j = 0; j < plan.getFeatures().length; j++) {
                if (selectedFeatures[i].equals(plan.getFeatures()[j])) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean plansContainsAllFeature(Plan[] plans, Feature[] selectedFeatures) {
        int featuresSize = 0;
        for (Plan plan : plans) {
            featuresSize += plan.getFeatures().length;
        }

        Feature[] mergedFeatures = new Feature[featuresSize];
        int index = 0;
        for (Plan plan : plans) {
            System.arraycopy(plan.getFeatures(), 0, mergedFeatures, index, plan.getFeatures().length);
            index += plan.getFeatures().length;
        }
        for (Feature selectedFeature : selectedFeatures) {
            boolean containsSelectedFeature = false;
            for (Feature planFeature : mergedFeatures) {
                if (selectedFeature.equals(planFeature)) {
                    containsSelectedFeature = true;
                }
            }
            if (!containsSelectedFeature)
                return false;
        }

        return true;

    }
}


