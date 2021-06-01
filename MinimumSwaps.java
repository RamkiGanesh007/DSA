// Swaps to Sort an Array by following conditions of swaps
// 1. get the pair of indices which are less indexed .
// until the array is sort.

import java.util.*;

public class MinimumSwaps {
    static int[] swaphelper(int arr[])
    {
        int idx=Integer.MAX_VALUE;
        int jidx=Integer.MAX_VALUE;
        int i=0; int j=arr.length-1;
        while(i<j)
        {
            if(arr[i]>arr[j])
            {
                idx=Math.min(idx,i);
                jidx=Math.min(jidx,j);
                j--;
                continue;
            }
            else
            i++;
        }
        if(idx==Integer.MAX_VALUE){ idx=-1;  jidx=-1;    }
        return new int[]{idx,jidx};
    }
    static long howManySwaps(List <Integer> arr)
    {
        int arr1[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            arr1[i]=arr.get(i);
        }
        long cnt=0;
        int pair[]=swaphelper(arr1);
        while(pair[0]!=-1 && pair[1]!=-1)
        {
            int i=pair[0];
            int j=pair[1];
            arr1[i]=(arr1[i]+arr1[j])-(arr1[j]=arr1[i]);
            cnt++;
            pair=swaphelper(arr1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(howManySwaps(new ArrayList<>(Arrays.asList(1,2,3))));
    }
}
