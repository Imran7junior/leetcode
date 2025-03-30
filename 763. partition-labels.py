class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # Step 1: Store the last occurrence of each character
        last_occurrence = {char: index for index, char in enumerate(s)}
        partition_sizes = []
        partition_start, partition_end = 0, 0

        # Step 2: Iterate and determine partitions
        for index, char in enumerate(s):
            partition_end = max(partition_end, last_occurrence[char])
            if index == partition_end:
                partition_sizes.append(partition_end - partition_start + 1)
                partition_start = index + 1
        
        return partition_sizes