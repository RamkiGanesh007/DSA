import java.util.*;

class dsa_6
{
    static int[] union(int arr1[],int []arr2)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int res[]=new int[arr1.length+arr2.length];
        int iidx=0;
        int jidx=0;
        int oidx=0;
        while(iidx<arr1.length || jidx<arr2.length)
        {
            if(iidx==arr1.length)
            {
                while(jidx<arr2.length)
                {
                    res[oidx++]=arr2[jidx];
                    jidx++;
                }
                break;
            }
            if(jidx==arr2.length)
            {
                while(iidx<arr1.length)
                {
                    res[oidx++]=arr1[iidx];
                    iidx++;
                }
                break;
            }

            if(arr1[iidx]<arr2[jidx])
            {
                res[oidx++]=arr1[iidx];
                iidx++;
            }
            else if(arr1[iidx]==arr2[jidx])
            {
                res[oidx++]=arr1[iidx];
                iidx++;
                jidx++;
            }
        }
        return res;
    }

    static int[] intersection(int arr1[],int arr2[])
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int res[]=new int[arr1.length+arr2.length];
        int iidx=0;
        int jidx=0;
        int oidx=0;
        while(iidx<arr1.length&&jidx<arr2.length)
        {
            if(arr1[iidx]==arr2[jidx])
            {
                res[oidx++]=arr1[iidx];
                iidx++;
                jidx++;
            }
            else if(arr1[iidx]<arr2[jidx])
            {
            iidx++;
            }
            else
            {
                jidx++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);

        int res[]= union(new int[]{-1,-2,0,1,2},new int[]{5,6,7,2,1});
        System.out.println("Union: ");
        for(int i=0;i<res.length;i++)    
        System.out.print(res[i]+" ");
        System.out.println();
        res= intersection(new int[]{5,6,7,1,2},new int[]{5,6,7,2,1});
        System.out.println("Intersection: ");
        for(int i=0;i<res.length;i++)    
        System.out.print(res[i]+" ");
        scn.close();
    }
}