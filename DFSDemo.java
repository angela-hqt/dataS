package leedcode;
/*
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * 输入:
		11110
		11010
		11000
		00000
		输出: 1

	输入:
		11000
		11000
		00100
		00011
		输出: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands

 */
public class DFSDemo {
	private boolean[][] visited;
	private int numRow;
	private int numCol;
	
	public int numsIsland(char[][] grid){
		//Validate input
		if(grid == null||grid.length<1||grid[0].length<1){
			return 0;
		}
		
		int total=0;
		numRow = grid.length;
		numCol = grid[0].length;
		visited = new boolean[numRow][numCol];
		
		for(int i=0;i<numRow;++i){
			for(int j=0;j<numCol;++j){
					++total;
					dfs(grid,i,j);
				}
			}
		return total;
		}
		
	
	
	private void dfs(char[][]grid,int i,int j){
		if(i<0||i>numRow||j<0||j>=numCol
				||grid[i][j]=='0'||visited[i][j]){
			return;
		}
		visited[i][j]=true;
		dfs(grid,i+1,j);
		dfs(grid,i-1,j);
		dfs(grid,i,j+1);
		dfs(grid,i,j-1);
		
	}
}
	
