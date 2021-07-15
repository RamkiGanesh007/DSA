import java.util.ArrayList;
import java.util.Arrays;

public class SumofSubsetsSumSWithoutKnapsack {
    static int m;

    static void SumofSubsets(int w[], ArrayList<Integer> res, int target, int n) {
        for (int i = 0; i < n; i++) {
            if (!res.contains(w[i])) {
                if (w[i] == target) {
                    res.add(w[i]);
                    System.out.println(res);
                    res.remove(new Integer(w[i]));
                    return;
                }
                if (w[i] < target) {
                    res.add(w[i]);
                    SumofSubsets(w, res, target - w[i], n);
                    res.remove(new Integer(w[i]));
                }
            }
        }
    }

    static boolean subsetsum_DP(int a[], int n, int sum) {
        // boolean matrix to store results
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // dp[i][j]=whethere there is a subset of sum j in subarray //a[0....i-1]
        int i, j;
        // initialization
        // for sum=0, there is always a subset possible ie., the empty set
        for (i = 0; i <= n; i++)
            dp[i][0] = true;
        // if there are no elements in the array, no subset is possible //for a non-zero
        // sum
        for (j = 1; j <= sum; j++)
            dp[0][j] = false;
        // i represents the no. of elements of array considered
        for (i = 1; i <= n; i++) {
            // j represents the sum of subset being searched for
            for (j = 1; j <= sum; j++) {
                // if using i-1 elements, there is a subset of desired sum
                // no need to search further
                // the result is true
                if (dp[i - 1][j] == true)
                    dp[i][j] = true;
                // otherwise, we will inspect
                else {
                    // if value of current element is greater than the //required sum
                    // this element cannot be considered
                    if (a[i - 1] > j)
                        dp[i][j] = false;
                    // check that after including this element, Is there //any subset present for
                    // the remaining sum ie., j-a[i-1]
                    else
                        dp[i][j] = dp[i - 1][j - a[i - 1]];
                }
            }
        }
        System.out.print("    ");
        for (int l = 0; l <= sum + 1; l++) {
            System.out.print("000" + l + " ");
        }
        System.out.println();
        for (int k = 0; k <= n; k++) {
            System.out.print(a[k] + ":  ");
            for (int l = 0; l <= sum; l++) {
                System.out.print(dp[k][l] + " ");
            }
            System.out.println();
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] w = { 4, 3, 5, 3, 7 };
        m = 7;
        subsetsum_DP(w, 4, 7);
        // SumofSubsets(w, new ArrayList<Integer>(Arrays.asList()), m, 4);
    }
}
