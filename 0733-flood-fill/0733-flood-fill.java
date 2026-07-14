class Solution {

    int[] dr = {-1, 0, 1, 0}; // Up, Right, Down, Left
    int[] dc = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If the new color is the same as the original,
        // no need to do anything.
        if (originalColor == color)
            return image;

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c,
                     int originalColor, int newColor) {

        // Boundary check
        if (r < 0 || c < 0 ||
            r >= image.length ||
            c >= image[0].length)
            return;

        // Stop if the cell is not the original color
        if (image[r][c] != originalColor)
            return;

        // Paint the current cell
        image[r][c] = newColor;

        // Visit all 4 neighbours
        for (int i = 0; i < 4; i++) {
            dfs(image,
                r + dr[i],
                c + dc[i],
                originalColor,
                newColor);
        }
    }
}