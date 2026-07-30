class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix one number at a time
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Found a valid triplet
                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values on the left
                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    // Skip duplicate values on the right
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    // Move both pointers
                    left++;
                    right--;
                }

                // Need a larger sum
                else if (sum < 0) {
                    left++;
                }

                // Need a smaller sum
                else {
                    right--;
                }
            }
        }

        return result;
    }
}