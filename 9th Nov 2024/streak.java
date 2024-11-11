// Minimum Array End - https://leetcode.com/problems/minimum-array-end/description/?envType=daily-question&envId=2024-11-09

// You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between all elements of nums is x.
// Return the minimum possible value of nums[n - 1].

// Example 1:
// Input: n = 3, x = 4
// Output: 6
// Explanation:
// nums can be [4,5,6] and its last element is 6.

// Example 2:
// Input: n = 2, x = 7
// Output: 15
// Explanation:
// nums can be [7,15] and its last element is 15.

// Constraints:
// 1 <= n, x <= 108

class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long remaining = n - 1;
        long position = 1;
        
        while (remaining != 0) {
            if ((x & position) == 0) {
                result |= (remaining & 1) * position;
                remaining >>= 1;
            }
            position <<= 1;
        }
        
        return result;
    }
}
