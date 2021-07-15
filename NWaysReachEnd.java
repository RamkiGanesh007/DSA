
public class NWaysReachEnd {
    public static int Nways(char[][] c, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            if (c[i][0] == '#')
                break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (c[0][j] == '#')
                break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (c[i][j] == '#') {
                    continue;
                }
                int a = 0, b = 0, d = 0;
                if (c[i][j - 1] != '#') {
                    a = dp[i][j - 1];
                }
                if (c[i - 1][j] != '#') {
                    b = dp[i - 1][j];
                }

                if (c[i - 1][j] != '#') {
                    d = dp[i - 1][j - 1];
                }

                dp[i][j] += (a + b + d) % 1000000007;
            }
        }

        return (dp[n - 1][m - 1] > 0) ? dp[n - 1][m - 1] : 0;
    }

    public static void main(String[] args) {
        System.out.println(Nways(new char[][] { { '.', '.' }, { '.', '.' } }, 2, 2));
    }
}
