import java.util.*;
class dsa_2
{
    static int[] maxminArray(int arr[])
    {
        int len=arr.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len;i++)
        {
            if(min>arr[i])
            min=arr[i];

            if(max<arr[i])
            max=arr[i];

        }

        return new int[]{max,min};
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int res[]=maxminArray(new int[]{1,2,3,4,5});
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }

        scn.close();
    }
}