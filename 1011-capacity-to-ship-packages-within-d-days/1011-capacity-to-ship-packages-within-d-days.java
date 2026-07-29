class Solution {

    public int shipWithinDays(int[] weights, int days) {

        
        int low = 0;

        
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            int requiredDays = daysNeeded(weights, mid);

            if (requiredDays <= days) {
         
                high = mid;
            } else {
             
                low = mid + 1;
            }
        }

        return low;
    }

    private int daysNeeded(int[] weights, int capacity) {

        int days = 1;     
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight > capacity) {
                days++;
                currentLoad = 0;
            }

            currentLoad += weight;
        }

        return days;
    }
}