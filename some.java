public class some {
     
    static int ans =Integer.MAX_VALUE;
   private static int solve(int n , int[] heights, int k, int dp[] ){
        if( n== 0)return 0;
        if(dp[n]!=-1)return dp[n];
        for(int i =1; i<=k; i++){
            int left = solve(n-i, heights, k, dp) + Math.abs(heights[n] - heights[n-i]);
           return dp[n] = Math.min(dp[n], left);
        }

       

   }
    
    public static void main(String[] args) {
        int heights[] = {10, 20, 30, 10};
        int k = 3;
        int n = 4;
        int dp[] = new int[n];
        for(int i =0; i<n; i++)dp[i] = -1; 
        System.out.println(solve( n , heights, k, dp));
    }
}
