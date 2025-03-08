class Solution(object):
    def minimumRecolors(self, blocks, k):
        n = len(blocks)
        min_operations = float('inf')
        
        # Iterate through the string with a sliding window of size k
        for i in range(n - k + 1):
            white_count = 0
            
            # Count the number of 'W's in the current window
            for j in range(i, i + k):
                if blocks[j] == 'W':
                    white_count += 1
            
            # Update the minimum number of operations
            min_operations = min(min_operations, white_count)
        
        return min_operations