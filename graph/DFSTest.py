graph = {
    1:[2,3],
    2:[4,5],
    3:[6],
    4:[],
    5:[],
    6:[]
}

visited = set()
def dfs(graph, node, visited):
    if node not in visited:
        print("current node ", node)
        visited.add(node)
        for i in graph.get(node, []):
            print("neibour ", i)
            dfs(graph, i, visited)
    else:
        print("node already present in visited ", node)
dfs(graph, 1, visited)

