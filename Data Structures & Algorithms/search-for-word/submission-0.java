class Solution {
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index))
            return false;

        char original = board[row][col];
        board[row][col] = '#';
        for (int[] direction : directions) {
            int nrow = direction[0] + row;
            int ncol = direction[1] + col;
            if (dfs(board, word, nrow, ncol, index + 1)) {
                board[row][col] = original;
                return true;
            }
        }

        board[row][col] = original;
        return false;
    }
}
