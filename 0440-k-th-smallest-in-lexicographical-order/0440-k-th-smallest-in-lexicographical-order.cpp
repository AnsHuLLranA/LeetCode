#include <cstdint>
#include <algorithm>  // for min

class Solution {
    // Helper function to count numbers with the given prefix
    int64_t count(int64_t n, int64_t prefix) {
        int64_t current = prefix;
        int64_t next = prefix + 1;
        int64_t count = 0;
        
        // Count the number of numbers in the range [prefix, prefix+1) that are <= n
        while (current <= n) {
            count += std::min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        
        return count;
    }

public:
    // Main function to find the k-th lexicographical number
    int64_t findKthNumber(int64_t n, int64_t k, int64_t prefix = 0) {
        for (int i = (prefix == 0 ? 1 : 0); i <= 9; i++) {
            if (k == 0) {
                return prefix;
            }

            int64_t numbers_with_prefix = count(n, prefix * 10 + i);
            
            if (numbers_with_prefix >= k) {
                return findKthNumber(n, k - 1, prefix * 10 + i);
            } else {
                k -= numbers_with_prefix;
            }
        }

        return prefix; // This should not be reached in valid cases
    }
};
