
public class SumofSubsetsSumS {
    static int m;

    static void SumofSubsets(int x[], int w[], int s, int k, int r) {
        if (k == -1) {
            return;
        }
        x[k] = 1;
        if (s + w[k] == m) {
            for (int i = 0; i < 5; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        } else if (s + w[k] <= m) {
            SumofSubsets(x, w, s + w[k], k - 1, r - w[k]);
        } else if ((s + w[k] > m)) {
            x[k] = 0;
            SumofSubsets(x, w, s, k - 1, r);
        }
        x[k] = 0;
        SumofSubsets(x, w, s, k - 1, r);
    }

    public static void main(String[] args) {
        int[] w = new int[] { 3, 4, 4, 3, 7 };
        int[] x = new int[] { 0, 0, 0, 0, 0 };
        m = 7;
        SumofSubsets(x, w, 0, 4, m);
    }
}
