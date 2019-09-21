class Solution {
    // Used to get the surounding squares
    final int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
    final int[] dy = {-1, 1, 1, 0, -1, -1, 0, 1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        // If the inital click is a bomb then we are done
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        // Perform dfs in all directions
        dfs(board, click[0], click[1]);
        return board;
    }
    
    private void dfs(char[][] board, int i, int j){
        // If we move off the edge of the board or we reach a node we have alread seen
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E'){
            return;
        }
        // Get the surrounding bombs
        int adj = getNumsOfBombs(board, i, j);
        // If there are bombs then we write that number down
        if(adj != 0){
            board[i][j] = Character.forDigit(adj, 10);
            return;
        }
        else{
            // Perform dfs on all adjacent locations
            board[i][j] = 'B';
            for (int k = 0; k < 8; k++) {
                int nx = i + dx[k], ny = j + dy[k];
                dfs(board, nx, ny);
            }
        }
    }
    
    private int getNumsOfBombs(char[][] board, int x, int y) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)    continue;
            if (board[nx][ny] == 'M' || board[nx][ny] == 'X') {
                num++;
            }
        }
        return num;
    }
}