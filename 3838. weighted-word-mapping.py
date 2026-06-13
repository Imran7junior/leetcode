from typing import List


class Solution:
    def mapWordWeights(self, words: List[str], wt: List[int]) -> str:
        res = []

        for word in words:
            s = 0
            for ch in word:
                s += wt[(ord(ch) & (1 << 5) - 1) - 1]
            res.append(chr(122 - (s - ((s * 2521) >> (1 << 4)) * len(wt))))

        return "".join(res)


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    words1 = ["abcd","def","xyz"]
    weights1 = [5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2]
    out1 = sol.mapWordWeights(words1, weights1)
    print(f"Example 1: words={words1}, weights(len)={len(weights1)}")
    print(f"Output: {out1}")
    print(f"Expected: rij")
    print()

    # Example 2
    words2 = ["a","b","c"]
    weights2 = [1] * 26
    out2 = sol.mapWordWeights(words2, weights2)
    print(f"Example 2: words={words2}")
    print(f"Output: {out2}")
    print(f"Expected: yyy")
    print()

    # Example 3
    words3 = ["abcd"]
    weights3 = [7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5]
    out3 = sol.mapWordWeights(words3, weights3)
    print(f"Example 3: words={words3}")
    print(f"Output: {out3}")
    print(f"Expected: g")