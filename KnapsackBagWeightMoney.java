import java.util.Arrays;

public class KnapsackBagWeightMoney {
    static int dp[][];
    static int dprecursivemax(int weight[],int money[],int w,int n)
    {
        if(n==0||w==0)
        return 0;

        if(dp[n][w]!=-1)
        {
            return dp[n][w];
        }
        if(weight[n-1]<=w)
        {
            dp[n][w]= Math.max(money[n-1]+dprecursivemax(weight,money,w-weight[n-1],n-1),dprecursivemax(weight,money,w,n-1));
        }
        else if(weight[n-1]>w){
            dp[n][w]=dprecursivemax(weight, money, w, n-1);
        }
        return dp[n][w];
    }
    static int dpiterationmax(int weight[],int money[],int w,int n)
    {
        //Initialization of row-0 and col =0 as break condition of recursion

        for(int i=0;i<=w;i++)
        {
            dp[0][i]=0;
        }
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=0;
        }

        //for loop i-1 j-1 to n and w   
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                if(weight[i-1]<=j)
                {
                    dp[i][j]=Math.max(money[i-1]+dp[i-1][j-weight[i-1]],dp[i-1][j]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        int n=5;
        int w=9;
        dp=new int[n+1][w+1];
        int weight[]=new int[]{1,2,3,4,5};
        int money[]=new int[]{2,3,4,5,1};
        
        for(int i=0;i<=n;i++)
        // Arrays.fill(dp[i],-1);
        System.out.println(dpiterationmax(weight, money, w, n));

        for(int i=0;i<=n;i++){
        for(int j=0;j<=w;j++)
        System.out.print(dp[i][j]+" "); 
        System.out.println();}

    }
}
