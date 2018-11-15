package com.obs.q1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    Plan plan4 = new Plan("plan 4", 1, new Feature[]{featureD});
    Plan plan5 = new Plan("plan 5", 5, new Feature[]{featureA, featureB, featureC, featureD});
    Plan plan6 = new Plan("plan 5", 4, new Feature[]{featureA, featureB, featureC, featureD});
    private Plan[] allPlans = new Plan[]{plan1, plan2, plan3, plan4, plan5, plan6};


    @Test
    public void getCheapest() {
        Feature[] selectedFeatures = new Feature[]{featureA, featureB, featureC, featureD};
        List<List<Plan>> result = selector.getCheaptest(allPlans, selectedFeatures);
        assertThat(result).containsExactlyInAnyOrder(Arrays.asList(new Plan[]{plan3, plan4}),
                Arrays.asList(new Plan[]{plan6}));

        result = selector.getCheaptest(allPlans, new Feature[]{featureA});
        assertThat(result).containsExactlyInAnyOrder(Arrays.asList(new Plan[]{plan1}));

        result = selector.getCheaptest(allPlans, new Feature[]{featureA, featureB});
        assertThat(result).containsExactlyInAnyOrder(Arrays.asList(new Plan[]{plan2}));

        result = selector.getCheaptest(allPlans, new Feature[]{featureA, featureD});
        assertThat(result).containsExactlyInAnyOrder(Arrays.asList(new Plan[]{plan1, plan4}));


        result = selector.getCheaptest(allPlans, new Feature[]{featureA, featureC});
        assertThat(result).containsExactlyInAnyOrder(Arrays.asList(new Plan[]{plan3}));
    }

    @Test
    public void planContainsAnyFeature() {
        // Test plan with single feature
        assertThat(selector.planContainsAnyFeature(plan1, new Feature[]{featureA})).isTrue();
        assertThat(selector.planContainsAnyFeature(plan1, new Feature[]{featureB})).isFalse();

        // Test plan with multiple features
        assertThat(selector.planContainsAnyFeature(plan3, new Feature[]{featureA})).isTrue();
        assertThat(selector.planContainsAnyFeature(plan3, new Feature[]{featureB})).isTrue();
        assertThat(selector.planContainsAnyFeature(plan3, new Feature[]{featureC})).isTrue();
        assertThat(selector.planContainsAnyFeature(plan3, new Feature[]{featureD})).isFalse();
    }

    @Test
    public void plansContainsAllFeature() {
        assertThat(selector.plansContainsAllFeature(new Plan[]{plan1}, new Feature[]{featureA})).isTrue();
        assertThat(selector.plansContainsAllFeature(new Plan[]{plan1}, new Feature[]{featureA, featureB})).isFalse();


        assertThat(selector.plansContainsAllFeature(new Plan[]{plan1, plan2}, new Feature[]{featureA})).isTrue();
        assertThat(selector.plansContainsAllFeature(new Plan[]{plan1, plan2}, new Feature[]{featureA, featureB})).isTrue();
        assertThat(selector.plansContainsAllFeature(new Plan[]{plan1, plan2}, new Feature[]{featureA, featureB, featureC})).isFalse();
        assertThat(selector.plansContainsAllFeature(new Plan[]{plan1, plan2}, new Feature[]{featureA, featureB, featureC, featureD})).isFalse();

        assertThat(selector.plansContainsAllFeature(new Plan[]{plan3, plan4}, new Feature[]{featureA, featureB, featureC, featureD})).isTrue();
        assertThat(selector.plansContainsAllFeature(new Plan[]{plan2, plan4}, new Feature[]{featureA, featureB, featureC, featureD})).isFalse();
    }

}