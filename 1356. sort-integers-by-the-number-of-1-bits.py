class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        arr.sort(key=lambda x: (x.bit_count(), x))
        return arr

if __name__ == "__main__":
    sol = Solution()
    
    # Example 1:
    arr = [0,1,2,3,4,5,6,7,8]
    output = sol.sortByBits(arr)
    print(f"Example 1: Input: arr = [0,1,2,3,4,5,6,7,8]")
    print(f"Output: {output}")
    print(f"Expected: [0,1,2,4,8,3,5,6,7]")
    print()
    
    # Example 2:
    arr = [1024,512,256,128,64,32,16,8,4,2,1]
    output = sol.sortByBits(arr)
    print(f"Example 2: Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]")
    print(f"Output: {output}")
    print(f"Expected: [1,2,4,8,16,32,64,128,256,512,1024]")