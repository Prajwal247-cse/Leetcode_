class Solution {

    public int numRescueBoats(int[] people, int limit) {

        // Step 1: Sort people by weight
        Arrays.sort(people);

        // Two pointers
        int left = 0;
        int right = people.length - 1;

        int boats = 0;

        // Continue until everyone is assigned a boat
        while (left <= right) {

            // If the lightest and heaviest can share a boat
            if (people[left] + people[right] <= limit) {
                left++;     // Lightest person boards
                right--;    // Heaviest person boards
            } else {
                // Heaviest person must go alone
                right--;
            }

            // One boat is used in either case
            boats++;
        }

        return boats;
    }
}