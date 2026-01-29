class Solution:
    def minimumCost(self, source: str, target: str,
                    original: list[str], changed: list[str], cost: list[int]) -> int:
        
        INF = 10**18
        dist = [[INF]*26 for _ in range(26)]

        for i in range(26):
            dist[i][i] = 0

        for o, c, w in zip(original, changed, cost):
            u = ord(o) - ord('a')
            v = ord(c) - ord('a')
            dist[u][v] = min(dist[u][v], w)

        for k in range(26):
            for i in range(26):
                for j in range(26):
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

        ans = 0
        for s, t in zip(source, target):
            u = ord(s) - ord('a')
            v = ord(t) - ord('a')
            if dist[u][v] == INF:
                return -1
            ans += dist[u][v]

        return ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    source1 = "abcd"
    target1 = "acbe"
    original1 = ["a","b","c","c","e","d"]
    changed1 = ["b","c","b","e","b","e"]
    cost1 = [2,5,5,1,2,20]
    output1 = solution.minimumCost(source1, target1, original1, changed1, cost1)
    print(f"Test 1: source = \"{source1}\", target = \"{target1}\"")
    print(f"Output: {output1}, Expected: 28")
    
    # Test case 2
    source2 = "aaaa"
    target2 = "bbbb"
    original2 = ["a","c"]
    changed2 = ["c","b"]
    cost2 = [1,2]
    output2 = solution.minimumCost(source2, target2, original2, changed2, cost2)
    print(f"Test 2: source = \"{source2}\", target = \"{target2}\"")
    print(f"Output: {output2}, Expected: 12")
    
    print("\nTest cases executed!")
