from typing import List


class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        events = []
        for x, y, l in squares:
            events.append((y, 1, x, x + l))
            events.append((y + l, -1, x, x + l))

        events.sort()
        xs = []
        prev_y = events[0][0]
        total = 0
        areas = []

        def union_len(intervals):
            intervals.sort()
            res = cur = 0
            end = -10**30
            for a, b in intervals:
                if a > end:
                    res += b - a
                    end = b
                elif b > end:
                    res += b - end
                    end = b
            return res

        for y, typ, x1, x2 in events:
            if y > prev_y and xs:
                h = y - prev_y
                w = union_len(xs)
                areas.append((prev_y, h, w))
                total += h * w
            if typ == 1:
                xs.append((x1, x2))
            else:
                xs.remove((x1, x2))
            prev_y = y

        half = total / 2
        acc = 0
        for y, h, w in areas:
            if acc + h * w >= half:
                return y + (half - acc) / w
            acc += h * w

        return 0.0


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    squares1 = [[0,0,1],[2,2,1]]
    output1 = solution.separateSquares(squares1)
    print(f"Test 1: squares = {squares1}")
    print(f"Output: {output1:.5f}, Expected: 1.00000")
    
    # Test case 2
    squares2 = [[0,0,2],[1,1,1]]
    output2 = solution.separateSquares(squares2)
    print(f"Test 2: squares = {squares2}")
    print(f"Output: {output2:.5f}, Expected: 1.00000")
    
    print("\nTest cases executed!")