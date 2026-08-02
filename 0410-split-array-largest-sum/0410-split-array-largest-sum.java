class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num); // largest element
            high += num;              // total sum
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;       // try smaller answer
            } else {
                low = mid + 1;    // increase answer
            }
        }

        return low;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {

        int subArrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {
                subArrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subArrays <= k;
    }
}