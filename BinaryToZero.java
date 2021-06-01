public class BinaryToZero {
    public static long minimumOneBitOperations(long n) {
        
        String strn = Long.toBinaryString(n);
        int len = strn.length();
        
        long[] cost = new long[len];
        cost[len-1] = 1;
        for(int i = len-2; i >= 0; i--)
            cost[i] = 2*cost[i+1]+1;
        
        long[] toZero = new long[len];
        long[] toOne = new long[len];
        if(strn.charAt(len-1) == '0')
            toOne[len-1] = 1;
        else
            toZero[len-1] = 1;
        
        for(int i = len-2; i >=0; i--)
        {
            char c = strn.charAt(i);
            if(c == '0')
            {
                 toZero[i] = Math.min(toZero[i+1], toOne[i+1]+cost[i+1]);
                toOne[i] = Math.min(toOne[i+1]+1+cost[i+1], toZero[i]+cost[i]);
            }
            else
            {
                toZero[i] = Math.min(toZero[i+1]+cost[i], toOne[i+1]+1+cost[i+1]);
                toOne[i] = Math.min(toOne[i+1]+cost[i+1], toZero[i+1]);
            }
        }
        
        return toZero[0];
    }
    public static void main(String[] args) {
        System.out.println(minimumOneBitOperations(11));
    }
}
