import java.util.*;
class dsa_1
{
    static int[] reverseArray(int arr[])
    {
        int len=arr.length-1;
    
        for(int i=0;i<arr.length/2;i++)
        {
            arr[i]=(arr[i]+arr[len-i])-(arr[len-i]=arr[i]);
        }

        return arr;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int res[]=reverseArray(new int[]{1,2,3,4,5});
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }

        scn.close();
    }
}