class Solution:
    def minOperations(self, s: str, k: int) -> int:
        n = len(s)
        ts = [SortedSet() for _ in range(2)]
        for i in range(n + 1):
            ts[i % 2].add(i)
        cnt0 = s.count('0')
        ts[cnt0 % 2].remove(cnt0)
        q = deque([cnt0])
        ans = 0
        while q:
            for _ in range(len(q)):
                cur = q.popleft()
                if cur == 0:
                    return ans
                l = cur + k - 2 * min(cur, k)
                r = cur + k - 2 * max(k - n + cur, 0)
                t = ts[l % 2]
                j = t.bisect_left(l)
                while j < len(t) and t[j] <= r:
                    q.append(t[j])
                    t.remove(t[j])
            ans += 1
        return -1

if __name__ == "__main__":
    from collections import deque
    from sortedcontainers import SortedSet
    
    sol = Solution()
    
    # Example 1:
    s = "110"
    k = 1
    output = sol.minOperations(s, k)
    print(f"Example 1: Input: s = {s}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 1")
    print()
    
    # Example 2:
    s = "0101"
    k = 3
    output = sol.minOperations(s, k)
    print(f"Example 2: Input: s = {s}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: 2")
    print()
    
    # Example 3:
    s = "101"
    k = 2
    output = sol.minOperations(s, k)
    print(f"Example 3: Input: s = {s}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: -1")