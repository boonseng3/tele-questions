package com.obs.q1;

public class Combination {

    public static int[][] combination(int[] n, int r) {

        if (r == 0) {
            return null;
        }
        // n choose 1 returns all the individual items
        else if (r == 1) {
            int[][] result = new int[n.length][1];
            for (int i = 0; i < n.length; i++) {
                result[i][0] = n[i];
            }
            return result;

        } else if (r == n.length) {
            // when n==r, return back the same array
            int[][] result = new int[1][n.length];
            result[0] = n;
            return result;
        } else {
            for (int i = 0; i < n.length; i++) {
                int firstItem = n[i];
                // assume first item, generate the combination (n without first item) choose r-1
                int[] remainingItems = new int[n.length - 1];
                System.arraycopy(n, i + 1, remainingItems, 0, n.length - 1);
                int[][] partialResult = combination(remainingItems, (r - 1));

                // add first item to the partial result
                for (int j = 0; j < partialResult.length; j++) {
                    int[] oldItems = partialResult[j];
                    int[] newItems = new int[oldItems.length + 1];
                    System.arraycopy(oldItems, 0, newItems, 1, oldItems.length);
                    newItems[0] = firstItem;
                    partialResult[j] = newItems;

                }
                // skip first item and generate the combination (n without first item) choose r
                int[][] partialResult2 = combination(remainingItems, r);
                int[][] result = new int[partialResult.length + partialResult2.length][];

                // merge the partial results
                System.arraycopy(partialResult, 0, result, 0, partialResult.length);
                System.arraycopy(partialResult2, 0, result, partialResult.length, partialResult2.length);

                return result;
            }
        }
        return null;
    }

}
