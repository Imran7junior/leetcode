class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sliderSet = set()
        l = 0
        result=0
        for r in range(len(s)):
            while s[r] in sliderSet:
                sliderSet.remove(s[l])
                l += 1
            sliderSet.add(s[r])
            result = max(result, r - l + 1)
        return result