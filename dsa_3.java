import java.util.*;
class dsa_3
{
    static int kthmax(int arr[],int k)
    {
        //Sort
        int len=arr.length;
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(arr[i]<arr[j])
                {
                    arr[i]=(arr[i]+arr[j])-(arr[j]=arr[i]);
                }
            }
        }
        return arr[len-k];
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int res=kthmax(new int[]{1,2,3,4,5},3);
            System.out.print(res+" ");
        scn.close();
    }
}