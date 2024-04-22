class Solution:
    def maxProfit(a) -> int:
        l, r = 0,1
        maxP = 0
   
        while r < len(a):
            if a[l] < a[r]:
                 profit = a[r] - a[l]
                 maxP = max(maxP, profit)
            else:
                 l = r
            r += 1
        return maxP
    prices1 = [8,2,1,4,6,5,3] 
    maxProfit(prices1)