class Solution:
    def robotSim(self, commands, obstacles):
        # Store obstacles
        blocked = set()
        for o in obstacles:
            blocked.add((o[0], o[1]))

        # Directions: North, East, South, West
        directions = [
            (0, 1), (1, 0), (0, -1), (-1, 0)
        ]

        x, y = 0, 0
        dir = 0  # initially facing North
        maxDist = 0

        for cmd in commands:
            if cmd == -1:
                dir = (dir + 1) % 4  # turn right
            elif cmd == -2:
                dir = (dir + 3) % 4  # turn left
            else:
                while cmd > 0:
                    nx = x + directions[dir][0]
                    ny = y + directions[dir][1]

                    # check obstacle
                    if (nx, ny) in blocked:
                        break

                    x = nx
                    y = ny

                    maxDist = max(maxDist, x * x + y * y)
                    cmd -= 1

        return maxDist

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1
    commands1 = [4,-1,3]
    obstacles1 = []
    output1 = sol.robotSim(commands1, obstacles1)
    print(f"Example 1: commands={commands1}, obstacles={obstacles1}")
    print(f"Output: {output1}")
    print(f"Expected: 25")
    print()
    
    # Example 2
    commands2 = [4,-1,4,-2,4]
    obstacles2 = [[2,4]]
    output2 = sol.robotSim(commands2, obstacles2)
    print(f"Example 2: commands={commands2}, obstacles={obstacles2}")
    print(f"Output: {output2}")
    print(f"Expected: 65")
    print()
    
    # Example 3
    commands3 = [6,-1,-1,6]
    obstacles3 = [[0,0]]
    output3 = sol.robotSim(commands3, obstacles3)
    print(f"Example 3: commands={commands3}, obstacles={obstacles3}")
    print(f"Output: {output3}")
    print(f"Expected: 36")