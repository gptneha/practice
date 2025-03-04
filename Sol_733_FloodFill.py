class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        '''
            create a visited matrix of size of the original matrix
            start with the 0,0 and start marking the elements in the visited as 1
            call dfs for the current index
        '''


        if not image:
            return image

        # Example Usage
        rows, cols = len(image), len(image[0])
        visited = self.initialize_matrix(rows, cols)
        self.dfs(image, visited, sr, sc, image[sr][sc], color)
        
        return image

    def initialize_matrix(self, rows, cols):
        # Create a matrix of size rows x cols filled with 1s
        matrix = [[0] * cols for _ in range(rows)]
        return matrix

    def dfs(self, image: List[List[int]], visited: List[List[int]], i: int, j:int, pixelColor: int, color: int):
        '''
        check if the index is out of range for i and j and return
        check if visited of the index in true then return
        else mark the current index as visited
        call for neigbour elements
        '''
        # Get matrix dimensions
        rows = len(image)
        cols = len(image[0]) 
        if i < 0 or i >= rows:
            #print("returning from i")
            return
        if j < 0 or j>= cols:
            #print("returning from j")
            return
        if visited[i][j] == 1:
            #print("returning from visited")
            return
        
        if image[i][j] != pixelColor:
            #print("returning from image")
            return
        
        visited[i][j] = 1
        image[i][j] = color

        self.dfs(image, visited, i-1, j, pixelColor, color)
        self.dfs(image, visited, i+1, j, pixelColor, color)
        self.dfs(image, visited, i, j-1, pixelColor, color)
        self.dfs(image, visited, i, j+1, pixelColor, color)
