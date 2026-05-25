class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        n = len(s)

        dp = [False] * n
        dp[0] = True

        reachable = 0

        for i in range(1, n):
            # add new index entering window
            if i - minJump >= 0 and dp[i - minJump]:
                reachable += 1

            # remove old index leaving window
            if i - maxJump - 1 >= 0 and dp[i - maxJump - 1]:
                reachable -= 1

            dp[i] = (reachable > 0 and s[i] == '0')

        return dp[n - 1]

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    s1 = "011010"
    minJump1 = 2
    maxJump1 = 3
    output1 = sol.canReach(s1, minJump1, maxJump1)
    print(f"Example 1: s={s1}, minJump={minJump1}, maxJump={maxJump1}")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    s2 = "01101110"
    minJump2 = 2
    maxJump2 = 3
    output2 = sol.canReach(s2, minJump2, maxJump2)
    print(f"Example 2: s={s2}, minJump={minJump2}, maxJump={maxJump2}")
    print(f"Output: {output2}")
    print(f"Expected: False")