// Shortest Subarray With OR at Least K II - https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/?envType=daily-question&envId=2024-11-10

// You are given an array nums of non-negative integers and an integer k.
// An array is called special if the bitwise OR of all of its elements is at least k.
// Return the length of the shortest special non-empty subarray of nums, or return -1 if no special subarray exists.

// Example 1:
// Input: nums = [1,2,3], k = 2
// Output: 1
// Explanation:
// The subarray [3] has OR value of 3. Hence, we return 1.

// Example 2:
// Input: nums = [2,1,8], k = 10
// Output: 3
// Explanation:
// The subarray [2,1,8] has OR value of 11. Hence, we return 3.

// Example 3:
// Input: nums = [1,2], k = 0
// Output: 1
// Explanation:
// The subarray [1] has OR value of 1. Hence, we return 1.

// Constraints:
// 1 <= nums.length <= 2 * 105
// 0 <= nums[i] <= 109
// 0 <= k <= 109

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0, n = nums.length;
        long or = 0;
        while(j < n) {
            or |= nums[j];
            while(or >= k) {
                ans = Math.min(ans, j - i + 1);
                or -= nums[i++];
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

