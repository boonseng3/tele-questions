package com.obs.q1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlanSelectorTest {

    private PlanSelector selector = new PlanSelector();


    Feature featureA = new Feature("a");
    Feature featureB = new Feature("b");
    Feature featureC = new Feature("c");
    Feature featureD = new Feature("d");

    Plan plan1 = new Plan("plan 1", 1, new Feature[]{featureA});
    Plan plan2 = new Plan("plan 2", 2, new Feature[]{featureA, featureB});
    Plan plan3 = new Plan("plan 3", 3, new Feature[]{featureA, featureB, featureC});
    Plan plan4 = new Plan("plan 3", 1, new Feature[]{featureD});
    Plan plan5 = new Plan("plan 4", 5, new Feature[]{featureA, featureB, featureC, featureD});
    private Plan[] allPlans = new Plan[]{plan1, plan2, plan3, plan4, plan5};


    @Test
    public void getCheaptest() {
        Feature[] selectedFeatures = new Feature[]{featureA, featureB, featureC, featureD};
        Plan[][] result = selector.getCheaptest(allPlans, selectedFeatures);
        assertThat(result).containsExactlyInAnyOrder(new Plan[]{plan3, plan4});

    }
}