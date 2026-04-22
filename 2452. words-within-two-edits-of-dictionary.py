class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        def _get_distance(s1,s2):
            cnt = 0
            for i in range(len(s1)):
                if s1[i]!=s2[i]:
                    cnt+=1
                if cnt==3:
                    return False
            return True

        good = []
        for query in queries:
            for d in dictionary:
                dist = _get_distance(query,d)
                if dist:
                    good.append(query)
                    break
        return good

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    queries1 = ["word","note","ants","wood"]
    dictionary1 = ["wood","joke","moat"]
    output1 = sol.twoEditWords(queries1, dictionary1)
    print(f"Example 1: queries={queries1}, dictionary={dictionary1}")
    print(f"Output: {output1}")
    print(f"Expected: ['word','note','wood']")
    print()
    
    # Example 2
    queries2 = ["yes"]
    dictionary2 = ["not"]
    output2 = sol.twoEditWords(queries2, dictionary2)
    print(f"Example 2: queries={queries2}, dictionary={dictionary2}")
    print(f"Output: {output2}")
    print(f"Expected: []")