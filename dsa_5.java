import java.util.*;

class dsa_5 {
    static int[] sortWithoutAlgo(int arr[], int n) {
        int midx = 0;
        for (int i = n; i > midx; i--) {
            if (arr[i] < 0) {
                arr[i] = (arr[i] + arr[midx]) - (arr[midx] = arr[i]);
                midx++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int res[] = sortWithoutAlgo(new int[] { 5, 3, 2, 1, 4, 6, 7 }, 6);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
        scn.close();
    }
}