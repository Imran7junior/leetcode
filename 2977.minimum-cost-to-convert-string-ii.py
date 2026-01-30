from typing import List
from itertools import chain
from math import inf


class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        word_id = {}
        for word in chain(original, changed):
            if word not in word_id:
                word_id[word] = len(word_id)

        m = len(word_id)
        dist = [[inf] * m for _ in range(m)]
        for orig, chang, c in zip(original, changed, cost):
            i, j = word_id[orig], word_id[chang]
            dist[i][j] = min(dist[i][j], c)

        for k in range(m):
            for i in range(m):
                if dist[i][k] < inf:
                    for j in range(m):
                        if dist[k][j] < inf:
                            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
      
        def build_trie(text):
            root = {}
            for word in text:
                node = root
                for ch in word:
                    node = node.setdefault(ch, {})
                node['#'] = word_id[word]
            return root 

        n = len(source)
        root_original, root_changed = build_trie(original), build_trie(changed)
        dp = [inf] * (n+1)
        dp[0] = 0
        for start in range(n):
            if dp[start] == inf:
                continue
            if source[start] == target[start]:
                dp[start + 1] = min(dp[start + 1], dp[start])
            node_original, node_changed, end = root_original, root_changed, start
            while end < n and source[end] in node_original and target[end] in node_changed:
                node_original = node_original[source[end]]
                node_changed = node_changed[target[end]]
                end += 1
                if '#' in node_original and '#' in node_changed:
                    dp[end] = min(dp[end], dp[start] + dist[node_original['#']][node_changed['#']])
        return -1 if dp[-1] == inf else dp[-1]


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
    source2 = "abcdefgh"
    target2 = "acdeeghh"
    original2 = ["bcd","fgh","thh"]
    changed2 = ["cde","thh","ghh"]
    cost2 = [1,3,5]
    output2 = solution.minimumCost(source2, target2, original2, changed2, cost2)
    print(f"Test 2: source = \"{source2}\", target = \"{target2}\"")
    print(f"Output: {output2}, Expected: 9")
    
    print("\nTest cases executed!")
