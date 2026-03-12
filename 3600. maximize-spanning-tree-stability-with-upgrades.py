class Solution:
    def maxStability(self, n: int, edges: List[List[int]], k: int) -> int:
        parent = list(range(n))
        size = [1] * n
        
        def find(v):
            if parent[v] == v:
                return v
            parent[v] = find(parent[v])
            return parent[v]
        
        def union(a, b):
            a = find(a)
            b = find(b)
            if a != b:
                if size[a] < size[b]:
                    a, b = b, a
                parent[b] = a
                size[a] += size[b]
                return True
            return False

        comp = n
        res = float("inf")
        opt = []
        for idx, edge in enumerate(edges):
            if edge[3] == 1:
                if union(edge[0], edge[1]):
                    comp -= 1
                    res = min(res, edge[2]) 
                else:
                    return -1  
        
        if comp == 1:  
            return res
        
        opt = [idx for idx, edge in enumerate(edges) if edge[3] == 0]

        opt.sort(key=lambda x: edges[x][2], reverse=True)
        
        stab = [] 
        
        for i in opt:
            edge = edges[i]
            if union(edge[0], edge[1]):
                comp -= 1
                stab.append(edge[2]) 
                if comp == 1:  
                    break
        
        if comp > 1: 
            return -1

        for i in range(1, min(len(stab), k) + 1):
            stab[-i] *= 2  
        return min(min(stab, default=res), res)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    n = 3
    edges = [[0,1,2,1],[1,2,3,0]]
    k = 1
    output = sol.maxStability(n, edges, k)
    print(f"Example 1: Input: n = {n}, edges = {edges}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 2")
    print()
    
    # Example 2:
    n = 3
    edges = [[0,1,4,0],[1,2,3,0],[0,2,1,0]]
    k = 2
    output = sol.maxStability(n, edges, k)
    print(f"Example 2: Input: n = {n}, edges = {edges}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 6")
    print()
    
    # Example 3:
    n = 3
    edges = [[0,1,1,1],[1,2,1,1],[2,0,1,1]]
    k = 0
    output = sol.maxStability(n, edges, k)
    print(f"Example 3: Input: n = {n}, edges = {edges}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: -1")