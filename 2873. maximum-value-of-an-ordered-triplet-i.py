class Solution:
    def maximumTripletValue(self, a: List[int]) -> int:
        return max(max((v-u)*w for v,u,w in combinations(a,3)),0)