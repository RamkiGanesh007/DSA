package AtcoderSolutions;

public class Frog1 {
    public static int minCost(int n, int a[]) {
        int dp[] = new int[n + 1];
        dp[0] = 0;

        dp[1] = Math.abs(a[1] - a[0]);
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + Math.abs(a[i] - a[i - 2]), dp[i - 1] + Math.abs(a[i] - a[i - 1]));
        }
        // DP VIEW
        // for (int i = 0; i < n + 1; i++)
        // System.out.print(dp[i] + " ");
        return dp[n];
    }

    // Not Working
    public static int minCostRecursive(int n, int a[]) {
        if (n == 0)
            return 0;
        return Math.min(minCostRecursive(n - 1, a) + Math.abs(a[n] - a[n - 1]),
                minCostRecursive(n - 2, a) + Math.abs(a[n] - a[n - 2]));
    }

    public static void main(String[] args) {
        int n = 4;
        int a[] = new int[] { 10, 30, 40, 20 };
        System.out.println(minCostRecursive(n - 1, a));
    }
}
