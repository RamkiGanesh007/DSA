import java.util.*;

public class dsa_7 {
    static int[] RotateByK(int arr[],int k)
    {
        int n=arr.length;
        for(int i=0;i<k;i++)
        {
            int temp=arr[n-1];
            for(int j=n-2;j>=0;j--)
            {
                arr[j+1]=arr[j];
            }
            arr[0]=temp;
        }
        return arr;
    }
    public static void main(String[] args) {
     int arr[]=RotateByK(new int[]{1,2,3,4,5},3);
     for(int i=0;i<5;i++)
     System.out.println(arr[i]);
    }
}
