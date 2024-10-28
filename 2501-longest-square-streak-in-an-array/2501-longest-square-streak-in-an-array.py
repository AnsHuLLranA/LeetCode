class Solution:
    def maxChainSize(self, curr, nos, mem):
        if curr in mem:
            return mem[curr]
        
        if curr * curr in nos:
            mem[curr] = 1 + self.maxChainSize(curr * curr, nos, mem)
            return mem[curr]
        
        mem[curr] = 0
        return 0

    def longestSquareStreak(self, nums):
        nos = set(nums)
        mem = {}
        max_chain_size = -1

        for ele in nums:
            if ele not in mem and ele * ele in nos:
                length = 2 + self.maxChainSize(ele * ele, nos, mem)
                max_chain_size = max(max_chain_size, length)
                
        return max_chain_size