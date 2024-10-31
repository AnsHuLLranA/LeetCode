class Solution:
    def minimumTotalDistance(self, robot, factory):
        robot.sort()
        factory.sort()

        n = len(robot)
        m = len(factory)
        
        # Initialize DP table with "infinity" values
        dp = [[float('inf')] * (n + 1) for _ in range(m + 1)]
        dp[0][0] = 0  # No distance if no robots and no factories used

        for i in range(1, m + 1):
            dp[i][0] = 0  # No robots to repair means 0 distance for any factories
            for j in range(1, n + 1):
                dp[i][j] = dp[i - 1][j]  # Option of not using this factory
                distance = 0
                
                # Calculate the cumulative distance for possible repairs at this factory
                for k in range(1, min(j, factory[i - 1][1]) + 1):
                    distance += abs(factory[i - 1][0] - robot[j - k])
                    if dp[i - 1][j - k] != float('inf'):
                        dp[i][j] = min(dp[i][j], dp[i - 1][j - k] + distance)
        
        return dp[m][n]

# Example usage:
robot = [0, 4, 6]
factory = [[2, 2], [6, 2]]

solution = Solution()
result = solution.minimumTotalDistance(robot, factory)
print("Minimum total distance:", result)
