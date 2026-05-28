class Node:
    def __init__(self):
        self.child = [-1] * 26
        self.idx = -1

class Solution:
    # update best index according to:
    # 1. smaller length
    # 2. earlier index
    def updateIndex(self,storedIdx,newIdx,wordsContainer):
        if storedIdx == -1:
            return newIdx

        oldLen = len(wordsContainer[storedIdx])
        newLen = len(wordsContainer[newIdx])

        if newLen < oldLen:
            return newIdx

        if newLen == oldLen and newIdx < storedIdx:
            return newIdx

        return storedIdx

    def stringIndices(self, wordsContainer: List[str], wordsQuery: List[str]) -> List[int]:
        trie = [Node()]  # root node

        # build reverse trie
        for i in range(len(wordsContainer)):
            word = wordsContainer[i][::-1]

            node = 0

            # update root answer
            trie[node].idx = self.updateIndex(trie[node].idx,i,wordsContainer)

            for ch in word:
                c = ord(ch) - ord('a')

                if trie[node].child[c] == -1:
                    trie[node].child[c] = len(trie)
                    trie.append(Node())

                node = trie[node].child[c]

                trie[node].idx = self.updateIndex(trie[node].idx,i,wordsContainer)

        ans = []

        # process queries
        for query in wordsQuery:
            query = query[::-1]

            node = 0

            for ch in query:
                c = ord(ch) - ord('a')

                if trie[node].child[c] == -1:
                    break

                node = trie[node].child[c]

            ans.append(trie[node].idx)

        return ans

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    wordsContainer1 = ["abcd","bcd","xbcd"]
    wordsQuery1 = ["cd","bcd","xyz"]
    output1 = sol.stringIndices(wordsContainer1, wordsQuery1)
    print(f"Example 1: wordsContainer={wordsContainer1}, wordsQuery={wordsQuery1}")
    print(f"Output: {output1}")
    print(f"Expected: [1,1,1]")
    print()
    
    # Example 2
    wordsContainer2 = ["abcdefgh","poiuygh","ghghgh"]
    wordsQuery2 = ["gh","acbfgh","acbfegh"]
    output2 = sol.stringIndices(wordsContainer2, wordsQuery2)
    print(f"Example 2: wordsContainer={wordsContainer2}, wordsQuery={wordsQuery2}")
    print(f"Output: {output2}")
    print(f"Expected: [2,0,2]")