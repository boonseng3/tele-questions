package com.obs.q1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CombinationTest {

    @Test
    public void combin() {
        assertThat(Combination.combination(new int[]{1, 2, 3, 4, 5}, 1))
                .containsExactlyInAnyOrder(
                        new int[]{1},
                        new int[]{2},
                        new int[]{3},
                        new int[]{4},
                        new int[]{5}
                );
        assertThat(Combination.combination(new int[]{1, 2, 3, 4, 5}, 5))
                .containsExactlyInAnyOrder(
                        new int[]{1,2,3,4,5}
                );
        assertThat(Combination.combination(new int[]{1, 2, 3, 4, 5}, 2))
                .containsExactlyInAnyOrder(
                        new int[]{1,2},
                        new int[]{1,3},
                        new int[]{1,4},
                        new int[]{1,5},
                        new int[]{2,3},
                        new int[]{2,4},
                        new int[]{2,5},
                        new int[]{3,4},
                        new int[]{3,5},
                        new int[]{4,5}
                );

        assertThat(Combination.combination(new int[]{1, 2, 3, 4, 5}, 3))
                .containsExactlyInAnyOrder(
                        new int[]{1,2,3},
                        new int[]{1,2,4},
                        new int[]{1,2,5},
                        new int[]{1,3,4},
                        new int[]{1,3,5},
                        new int[]{1,4,5},
                        new int[]{2,3,4},
                        new int[]{2,3,5},
                        new int[]{2,4,5},
                        new int[]{3,4,5}
                );

        assertThat(Combination.combination(new int[]{1, 2, 3, 4, 5}, 4))
                .containsExactlyInAnyOrder(
                        new int[]{2,3,4,5},
                        new int[]{1,3,4,5},
                        new int[]{1,2,4,5},
                        new int[]{1,2,3,5},
                        new int[]{1,2,3,4}
                );

        assertThat(Combination.combination(new int[]{1, 2, 3, 4, 5}, 0))
                .isNull();
    }
}