import java.util.*;

class dsa_8 {
    static int maximumSumContigious(int arr[], int n) {
        if (n == 0)
            return 0;
        int res = arr[0];
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            temp = Math.max(arr[i], temp + arr[i]);
            res = Math.max(temp, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int res = maximumSumContigious(new int[] { 2, 2, -8, 1, 1, 0, 0 }, 7);
        // for(int i=0;i<res.length;i++)
        System.out.print(res + " ");
        scn.close();
    }
}