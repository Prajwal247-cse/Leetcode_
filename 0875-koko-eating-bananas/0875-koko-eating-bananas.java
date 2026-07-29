class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Minimum possible speed = 1 banana/hour
        int low = 1;

        // Maximum possible speed = largest pile
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Binary Search on eating speed
        while (low < high) {

            // Middle speed to test
            int mid = low + (high - low) / 2;

            // Calculate total hours needed at speed = mid
            int hours = hoursNeeded(piles, mid);

            if (hours <= h) {
                // This speed works.
                // Try a smaller speed to find the minimum possible.
                high = mid;
            } else {
                // Too slow.
                // Need to increase eating speed.
                low = mid + 1;
            }
        }

        // low == high is the minimum valid speed
        return low;
    }

    // Returns total hours required if Koko eats at speed k
    private int hoursNeeded(int[] piles, int k) {
        int hours = 0;

        for (int pile : piles) {
            // Equivalent to Math.ceil((double)pile / k)
            // Integer trick:
            // ceil(a / b) = (a + b - 1) / b
            hours += (pile + k - 1) / k;
        }

        return hours;
    }
}