class Solution(object):
    def longestCommonPrefix(self, arr1, arr2):
        store = set()
        st1 = set(arr1)
        st2 = set(arr2)

        for val in arr2:
            cur = ""
            s = str(val)
            for ch in s:
                cur += ch
                if int(cur) not in store:
                    store.add(int(cur))

        ans = 0
        for val in st1:
            cur = ""
            s = str(val)
            for ch in s:
                cur += ch
                if int(cur) in store:
                    ans = max(ans, int(len(cur)))
        return ans


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Example 1
    arr1_1 = [1, 10, 100]
    arr2_1 = [1000]
    result1 = solution.longestCommonPrefix(arr1_1, arr2_1)
    print(f"Example 1: Input: arr1 = {arr1_1}, arr2 = {arr2_1}")
    print(f"Output: {result1}")
    print(f"Expected: 3\n")
    
    # Example 2
    arr1_2 = [1, 2, 3]
    arr2_2 = [4, 4, 4]
    result2 = solution.longestCommonPrefix(arr1_2, arr2_2)
    print(f"Example 2: Input: arr1 = {arr1_2}, arr2 = {arr2_2}")
    print(f"Output: {result2}")
    print(f"Expected: 0")