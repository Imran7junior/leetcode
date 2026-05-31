class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        asteroids.sort()

        for asteroid in asteroids:
            if mass < asteroid:
                return False

            mass += asteroid

        return True

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    mass1 = 10
    asteroids1 = [3,9,19,5,21]
    output1 = sol.asteroidsDestroyed(mass1, asteroids1)
    print(f"Example 1: mass={mass1}, asteroids={asteroids1}")
    print(f"Output: {output1}")
    print(f"Expected: True")
    print()
    
    # Example 2
    mass2 = 5
    asteroids2 = [4,9,23,4]
    output2 = sol.asteroidsDestroyed(mass2, asteroids2)
    print(f"Example 2: mass={mass2}, asteroids={asteroids2}")
    print(f"Output: {output2}")
    print(f"Expected: False")