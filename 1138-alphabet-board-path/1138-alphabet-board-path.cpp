class Solution {
public:
    string alphabetBoardPath(string target) {
        string ans = "";
        int row = 0, col = 0; // Start at 'a'

        for (char ch : target) {
            int newRow = (ch - 'a') / 5;
            int newCol = (ch - 'a') % 5;

            // Move Up
            while (row > newRow) {
                ans += 'U';
                row--;
            }

            // Move Left
            while (col > newCol) {
                ans += 'L';
                col--;
            }

            // Move Down
            while (row < newRow) {
                ans += 'D';
                row++;
            }

            // Move Right
            while (col < newCol) {
                ans += 'R';
                col++;
            }

            ans += '!';
        }

        return ans;
    }
};