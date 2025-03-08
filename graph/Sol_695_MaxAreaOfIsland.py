class Solution:
    def initialize_matrix(self, rows, cols):
        # Create a matrix of size rows x cols filled with 1s
        matrix = [[0] * cols for _ in range(rows)]
        return matrix

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        '''
            create a visited matrix of current size
            create a result variable which will store the largest area island
            loop over matrix
            if found 0 then go to next index
            if already visited then also move to next index
            if found 1 then call dfs which will return the size of the island
        '''
        if not grid:
            return 0
        
        result = 0
        visited = self.initialize_matrix(len(grid), len(grid[0]))

        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == 0:
                    visited[i][j] = 1
                    continue
                result = max(result, self.dfs(grid, visited, i, j, 1))
        return result

    '''
        dfs method will take matrix , current index and current size as the input
        if already visited
    '''
    def dfs(self,grid: List[List[int]], visited:List[List[int]], i:int, j:int, currentArea:int):
        rows = len(grid)
        cols = len(grid[0])

        if (i < 0 or i >= rows):
            return currentArea
        if (j < 0 or j>= cols):
            return currentArea
        if visited[i][j] == 1:
            return currentArea

        if grid[i][j] == 0:
            return currentArea

        visited[i][j] = 1
        
        return 1 + self.dfs(grid, visited, i-1, j, 0) + self.dfs(grid, visited, i+1, j, 0) + self.dfs(grid, visited, i,j-1, 0) + self.dfs(grid, visited, i, j+1,0)
