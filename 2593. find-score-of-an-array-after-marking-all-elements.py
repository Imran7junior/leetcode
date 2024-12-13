class Solution:
    def findScore(self, nums: List[int]) -> int:
        stk = []
        res = 0
        for i in range(len(nums)):
            if not stk or nums[i] < stk[-1]:
                # maintain a decreasing stack
                stk.append(nums[i])
            else:
                # when the current element is larger we can choose previous element since it's smaller than current and its previous
                while stk:
                    res += stk.pop()
                    if stk:
                        # if there is previous element skip that too
                        stk.pop()
        while stk:
            res += stk.pop()
            if stk:
                stk.pop()

        return res