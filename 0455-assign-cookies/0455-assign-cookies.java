import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // Sort children by greed factor
        Arrays.sort(g);

        // Sort cookies by size
        Arrays.sort(s);

        int child = 0;   // Pointer for children
        int cookie = 0;  // Pointer for cookies

        // Try to assign cookies until one array is exhausted
        while (child < g.length && cookie < s.length) {

            // If current cookie is large enough,
            // satisfy this child.
            if (s[cookie] >= g[child]) {
                child++;   // Move to next child
            }

            // Whether used or too small, move to the next cookie
            cookie++;
        }

        // Number of satisfied children
        return child;
    }
}