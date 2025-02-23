Dynamic Programming

1. For finding maximum sum subarray
	1. Kadane's algorithm - 
		1. this algorithm is nothing but a considering maximum till now and result. 
		2. https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/ 
		3. Used to solve maximum sum subarray
2. Dynamic Programming - 
	1. Overlapping subproblems
	2. Try to identify subproblem in below format - 
F(0) = 0
F(1) = 1
F(2) = F(1) + F(0)
F(3) = F(2) + F(1)
F(4) = F(3) + F(2)
3. Dynamic programming problems can be solved in 2 ways with memoization
	1. Top Down Approach 
		1. Like fibonacci number
	2. Bottom Up Approach
4. Different Types of Dynamic programming Problems - 
    1. Longest common subsequence
        1. To solve longest common subsequence - keep a 2 D Metrics of the length of both the strings
        2. Populate the 2 D metrix considering the length of the substring from 0 to x and 0 to Y
        3. If current row and current column elements are matching then fill with 
            1+ diagonal
            else 
            max(last row, last column)
    2. Floyd Warshell Algorithm - 
        1. This algo is being used to take out shortest path between 2 vertices in weighted directed graph , this does will not work the cases
        where there is a negative cycle in the graph
        2. Algo - 
            1. Create a 2 D matrix with all edges given in the graph, and fill the matrix with direct edges between 2 vertex, 
            if there does not exist any edge between 2 vertex, then fill with infinity. 
            2. Then take k = 1 to number of vertices , and run below - 
            if m[i][j] > m[i][k]+m[k][j]
            3. End matrix will give the shortest path between any 2 edges in the graph.
            4. Pseudo Code -
                n = no of vertices
                A = matrix of dimension n*n
                for k = 1 to n
                    for i = 1 to n
                        for j = 1 to n
                            Ak[i, j] = min (Ak-1[i, j], Ak-1[i, k] + Ak-1[k, j])
                return A
            5. 
Dynamic programming can be used in 2 types of problems, where we get any/both out of below patterns - 
1. Optimal substucture - 
    longest common subsequence - 
    Such an example is likely to exhibit optimal substructure. That is, if the shortest route from Seattle to Los Angeles passes through Portland and then Sacramento, then the shortest route from Portland to Los Angeles must pass through Sacramento too.
2. Overlapping subproblems - Fibonacci Numbers

Methods to solve dynamic programming problem - 
    1. Top Down approach - 
        Memoization - The act of storing results of costly function call, and retrieving them from the store when needed again to avoid re-evaluation.
        1. Knapsack problem - 
def knapsack(weights, prices, capacity):
  # your code goes here 
  if (capacity == 0):
    return 0
  return maxprofit(capacity , weights, prices, 0)

mem = {}
def maxprofit(rcapacity , weights, prices, index):
  if (rcapacity, index) in mem:
    return mem[(rcapacity,index)]

  if rcapacity <= 0 or index >= len(weights):
    mem[(rcapacity,index)] = 0
    return 0
  if weights[index] > rcapacity: 
    mem[(rcapacity, index)] = maxprofit(rcapacity, weights, prices, index + 1)
    return mem[(rcapacity, index)]
    
  withoutindex = maxprofit(rcapacity, weights, prices, index+1)
  withindex = prices[index] + maxprofit(rcapacity-weights[index], weights, prices, index+1)
  maxm = max(withoutindex,withindex)
  mem[(rcapacity,index)] = maxm
  return maxm

stressTesting = True
    2. Number of ways for climbing the stairs

def staircase(n, m):
  # Your code goes here
  return reach(n, m, n)

def reach(x, m, n):
  if mem.get(x) is not None:
    return mem.get(x)
  if (x == 0):
    mem[x] = 1
    return  1
  count = 0
  for i in range(1, m+1):
    if (x-i >= 0):
      count = count + reach(x-i, m, n)
  # mem[x] = count
  return count
    

stressTesting = False


implement below over weekend -
1. Stack 
    using array
    using linked list
    See the internal implementation of the python
2. Queue
    using array
    using linked list
    See the internal implementation of the python
3. Heap
    From array in array
    From array and in keep it in tree
4. Binary Tree from Array
5. Graph Cyclic
6. BFS - implement BFS
7. DFS - implement DFS
8 Binary Tree Creation
    Post, in , Pre, order level Order Traversal iteratively and recursively




Things to revise  
1. Implementation of Trie
2. Suffix Tree - Store all suffix of a given word in trie
3. Rabin Karp - 


    
    
      
            
 
            