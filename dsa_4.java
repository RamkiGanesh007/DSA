import java.util.*;
class dsa_4
{
    static int[] sortWithoutAlgo(int arr[],int n)
    {
        int low=0,hi=n-1,mid=0;
        while(mid<=hi)
        {
            switch(arr[mid])
            {
                case 0:
                arr[mid]=(arr[mid]+arr[low])-(arr[low]=arr[mid]);
                low++;
                mid++;
                break;
                case 1:
                mid++;
                break;
                case 2:
                arr[mid]=(arr[mid]+arr[hi])-(arr[hi]=arr[mid]);
                hi--;
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int res[]=sortWithoutAlgo(new int[]{2,2,2,1,1,0,0},7);
        for(int i=0;i<res.length;i++)    
        System.out.print(res[i]+" ");
        scn.close();
    }
}