class Solution:
    def initialize_matrix(self, rows, cols) -> List[List[bool]]:
        matrix = [[False] * cols for _ in range(rows)]
        return matrix

    def exist(self, board: List[List[str]], word: str) -> bool:
        '''
            create a visited matrix initialize it with all zero
            iterate over the matrix from 0,0
            if index is not the part if the word then mark visited as 1
            if index is present in the word then do not mark it visited
            if index is equal to the current character then mark it visited and call for others
        '''
        if not board :
            return False
        visited = self.initialize_matrix(len(board), len(board[0]))

        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == word[0]:
                    if self.dfs(board, visited, i, j, word, 0):
                        return True
        return False

    def dfs(self, board:List[List[str]], visited:List[List[bool]], i:int, j:int, word:str, wordIndex:int)-> bool:
        if wordIndex == len(word):
            return True
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[wordIndex] or visited[i][j]:
            return False
        visited[i][j] = True
        found = self.dfs(board, visited, i-1, j, word, wordIndex+1) or self.dfs(board, visited, i+1, j, word, wordIndex+1) or self.dfs(board, visited, i, j-1, word, wordIndex+1) or self.dfs(board, visited, i, j+1, word, wordIndex+1)
        visited[i][j] = False
        return found
        
