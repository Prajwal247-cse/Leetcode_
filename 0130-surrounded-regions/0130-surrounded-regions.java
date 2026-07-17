class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // First and last column
        for (int i = 0; i < rows; i++) {

            if (board[i][0] == 'O')
                dfs(board, i, 0);

            if (board[i][cols - 1] == 'O')
                dfs(board, i, cols - 1);
        }

        // First and last row
        for (int j = 0; j < cols; j++) {

            if (board[0][j] == 'O')
                dfs(board, 0, j);

            if (board[rows - 1][j] == 'O')
                dfs(board, rows - 1, j);
        }

        // Convert remaining O to X
        // Restore S to O
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == 'S')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {

        if (r < 0 || c < 0 ||
            r >= board.length ||
            c >= board[0].length)
            return;

        if (board[r][c] != 'O')
            return;

        board[r][c] = 'S';

        for (int i = 0; i < 4; i++) {

            dfs(board,
                r + dr[i],
                c + dc[i]);
        }
    }
}