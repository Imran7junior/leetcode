class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:

        from functools import lru_cache

        def solve(n: int) -> int:
            if n < 0:
                return 0

            s = str(n)

            @lru_cache(None)
            def dfs(pos, started, last, second_last, tight):
                if pos == len(s):
                    return (1, 0)

                limit = int(s[pos]) if tight else 9

                total_cnt = 0
                total_wav = 0

                for d in range(limit + 1):
                    ntight = tight and d == limit

                    if not started and d == 0:
                        cnt, wav = dfs(
                            pos + 1,
                            False,
                            10,
                            10,
                            ntight
                        )

                        total_cnt += cnt
                        total_wav += wav

                    else:
                        add = 0

                        if started and second_last != 10:
                            if (
                                (last > second_last and last > d)
                                or
                                (last < second_last and last < d)
                            ):
                                add = 1

                        n_second_last = last if started else 10

                        cnt, wav = dfs(
                            pos + 1,
                            True,
                            d,
                            n_second_last,
                            ntight
                        )

                        total_cnt += cnt
                        total_wav += wav + add * cnt

                return (total_cnt, total_wav)

            return dfs(0, False, 10, 10, True)[1]

        return solve(num2) - solve(num1 - 1)

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    num1_1 = 120
    num2_1 = 130
    output1 = sol.totalWaviness(num1_1, num2_1)
    print(f"Example 1: num1={num1_1}, num2={num2_1}")
    print(f"Output: {output1}")
    print(f"Expected: 3")
    print()
    
    # Example 2
    num1_2 = 198
    num2_2 = 202
    output2 = sol.totalWaviness(num1_2, num2_2)
    print(f"Example 2: num1={num1_2}, num2={num2_2}")
    print(f"Output: {output2}")
    print(f"Expected: 3")
    print()
    
    # Example 3
    num1_3 = 4848
    num2_3 = 4848
    output3 = sol.totalWaviness(num1_3, num2_3)
    print(f"Example 3: num1={num1_3}, num2={num2_3}")
    print(f"Output: {output3}")
    print(f"Expected: 2")