class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        st = set()

        for i in range(len(s) - k + 1):
            st.add(s[i:i+k])

        return len(st) == 2**k

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    s = "00110110"
    k = 2
    output = sol.hasAllCodes(s, k)
    print(f"Example 1: Input: s = {s}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: True")
    print()
    
    # Example 2:
    s = "0110"
    k = 1
    output = sol.hasAllCodes(s, k)
    print(f"Example 2: Input: s = {s}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: True")
    print()
    
    # Example 3:
    s = "0110"
    k = 2
    output = sol.hasAllCodes(s, k)
    print(f"Example 3: Input: s = {s}, k = {k}")
    print(f"Output: {output}")
    print(f"Expected: False")