import java.awt.*;
import java.util.*;
import java.util.List;
class Solution {
    public long maxPoints(int[][] points) {
		int n = points.length;
		int m = (n == 0) ? 0 : points[0].length;

		long dp[][] = new long[n][m];
		for (int j=0 ; j<m ; j++)
			dp[0][j] = points[0][j];

		for (int i=1 ; i<n ; i++) {

			long leftMax[] = new long[m];
			leftMax[0] = dp[i-1][0];
			for (int k=1 ; k<m ; k++) {
				leftMax[k] = Math.max( leftMax[k-1] , dp[i-1][k] + k );
			}

			long rightMax[] = new long[m];
			rightMax[m-1] = dp[i-1][m-1] - (m-1);
			for (int k = m-2 ; k >= 0 ; k--) {
				rightMax[k] = Math.max( rightMax[k+1] , dp[i-1][k] - k );
			}

			for (int j=0 ; j<m ; j++) {
				dp[i][j] = points[i][j] + Math.max( leftMax[j]-j , rightMax[j]+j );
			}
		}
		long ans = 0;
		for (int j=0 ; j<m ; j++)
			ans = Math.max( ans , dp[n-1][j] );

		return ans;
	}
}