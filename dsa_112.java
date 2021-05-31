import java.util.*;
class dsa_112
{
    static int maximumsumnoadjacent(int arr[])
    {
        if (arr.length == 0) return 0;
        arr[0] = Math.max(0, arr[0]);
        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
          arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);
        return arr[arr.length-1];
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int []arr=new int[]{-3,-5,-7,-8,10};
        System.out.println(maximumsumnoadjacent(arr));
        scn.close();
    }
}