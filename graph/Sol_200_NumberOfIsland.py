class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        '''
            iterate over matrix
            if 1 found then start dfs increase the count with 1
            mark all elements 2 if 1 found 
        '''
        if not grid:
            #print("returning from grid count")
            return 0
        #visited = self.initialize_matrix(len(grid), len(grid[0]))
        count = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == "1":
                    #print("increasing count")
                    count = count + 1
                    self.dfs(grid, i, j)
        return count

    def initialize_matrix(self, rows, cols) -> List[List[int]]:
        matrix = [[0] * cols for _ in range(rows)]
        return matrix


    def dfs(self, grid, i, j):
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]):
            return
        
        if grid[i][j] == "2":
            return
        if grid[i][j] == "0":
            grid[i][j] = "2"
            return

        if grid[i][j] == "1":
            grid[i][j] = "2"
        self.dfs(grid, i-1, j)
        self.dfs(grid, i+1, j)
        self.dfs(grid, i, j-1)
        self.dfs(grid, i, j+1)
        return
