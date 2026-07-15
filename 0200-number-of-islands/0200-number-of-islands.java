class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == '1') {

                    islands++;

                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {

        if(r < 0 || c < 0 ||
           r >= grid.length ||
           c >= grid[0].length)
            return;

        if(grid[r][c] == '0')
            return;

        // Mark visited
        grid[r][c] = '0';

        for(int i = 0; i < 4; i++) {

            dfs(grid,
                r + dr[i],
                c + dc[i]);
        }
    }
}