package middle.Tree;


/**
 * Time：2021年5月31日12:41:46
 * author:YORICHEONG
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i= 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    private void dfs(int i,int j,char[][] grid){
        if(i>=0&&i<grid.length&&j<grid[0].length&&j>=0&&grid[i][j]=='1'){
            grid[i][j] = '0';
            dfs(i-1, j, grid);
            dfs(i+1, j, grid);
            dfs(i, j+1, grid);
            dfs(i, j-1, grid);
        }
    }
}
