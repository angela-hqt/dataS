package leedcode;

import java.util.LinkedList;

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
public class BFSDemo {
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
					bfs(grid,i,j);
				}
			}
		return total;
		}
	class Pair{
		int row;
		int col;
		
		public Pair(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
	private boolean isValid(char[][]grid,int row,int col){
		return !visited[row][col]&&grid[row][col]=='1';
	}
	

	private void bfs(char[][] grid, int row, int col) {
		visited[row][col]=true; 
		LinkedList <Pair> queue=new LinkedList<Pair>();
		queue.offer(new Pair(row, col)); 
		Pair curIdx; 
		while(! queue.isEmpty()){
			curIdx=queue.poll(); 
			int i=curIdx. row; 
			int j=curIdx. col; 
			if(i>0 && isValid(grid,i-1,j)){
				queue.offer(new Pair(i-1,j)); 
				visited[i-1][j]=true;
			}
			if(i< numRow-1 && isValid(grid, i+1,j)){
				queue.offer(new Pair(i+1,j)); 
				visited[i+1][j]=true;
			}
			if(j>0 && isValid(grid,i,j-1)){
				queue.offer(new Pair(i,j-1)); 
				visited[i][j-1]=true;
			}
			if(j<numCol-1 && isValid(grid,i,j+1)){
				queue.offer(new Pair(i,j+1));
				visited[i][j +1]=true;
		
			}
		
		}
	}	
	
}
