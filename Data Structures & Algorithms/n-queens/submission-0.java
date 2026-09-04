class Solution {
    public List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int row = 0; row<n;row++){
            Arrays.fill(board[row], '.');
        }
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n-1];
        boolean[] diag2 = new boolean[2*n-1];

        backtracking(0, n, board, cols, diag1, diag2, result);
        return result;
    }

    private void backtracking(int row, int n, char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2, List<List<String>> result){
        if(row==n){
            List<String> solution = new ArrayList<>();
            for(char[] currentRow:board){
                solution.add(new String(currentRow));
            }

            result.add(solution);
        }

        for(int col = 0; col<n;col++){
            int d1 = row+col;
            int d2 = row-col+n-1;
            if(cols[col] || diag1[d1]||diag2[d2]){
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtracking(row+1, n, board, cols, diag1, diag2, result);
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }

    }
}
