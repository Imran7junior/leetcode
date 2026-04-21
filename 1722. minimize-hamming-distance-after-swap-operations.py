class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        n = len(source)

        parent = list(range(n))
        rank = [0] * n

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def unite(a, b):
            pa, pb = find(a), find(b)
            if pa == pb:
                return

            if rank[pa] < rank[pb]:
                pa, pb = pb, pa

            parent[pb] = pa
            if rank[pa] == rank[pb]:
                rank[pa] += 1

        for a, b in allowedSwaps:
            unite(a, b)

        from collections import defaultdict

        groups = defaultdict(list)
        for i in range(n):
            groups[find(i)].append(i)

        ans = 0

        for idxs in groups.values():
            freq = {}

            for i in idxs:
                freq[source[i]] = freq.get(source[i], 0) + 1

            for i in idxs:
                if freq.get(target[i], 0) > 0:
                    freq[target[i]] -= 1
                else:
                    ans += 1

        return ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    source1 = [1,2,3,4]
    target1 = [2,1,4,5]
    allowedSwaps1 = [[0,1],[2,3]]
    output1 = sol.minimumHammingDistance(source1, target1, allowedSwaps1)
    print(f"Example 1: source={source1}, target={target1}, allowedSwaps={allowedSwaps1}")
    print(f"Output: {output1}")
    print(f"Expected: 1")
    print()
    
    # Example 2
    source2 = [1,2,3,4]
    target2 = [1,3,2,4]
    allowedSwaps2 = []
    output2 = sol.minimumHammingDistance(source2, target2, allowedSwaps2)
    print(f"Example 2: source={source2}, target={target2}, allowedSwaps={allowedSwaps2}")
    print(f"Output: {output2}")
    print(f"Expected: 2")
    print()
    
    # Example 3
    source3 = [5,1,2,4,3]
    target3 = [1,5,4,2,3]
    allowedSwaps3 = [[0,4],[4,2],[1,3],[1,4]]
    output3 = sol.minimumHammingDistance(source3, target3, allowedSwaps3)
    print(f"Example 3: source={source3}, target={target3}, allowedSwaps={allowedSwaps3}")
    print(f"Output: {output3}")
    print(f"Expected: 0")