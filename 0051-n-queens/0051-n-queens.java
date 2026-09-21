class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Initialize the board with empty cells
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nqueens(board, 0, ans);
        return ans;
    }

    private void nqueens(char[][] board, int row, List<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l.add(new String(board[i])); // convert char[] to string directly
            }
            ans.add(l);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                nqueens(board, row + 1, ans); // Recur
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
