graph = {
    1:[2],
    2:[3],
    3:[4,1],
    4:[]
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

