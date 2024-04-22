class Solution:
	matrix = [[1, 2, 3, 4],
    		 [5, 6, 7, 8],
    		 [9, 10, 11, 12]]
	target = 7
def searchMatrix(self, matrix, target):
	if not matrix:
		return False
	m, n = len(matrix), len(matrix[0])
	left, right = 0, m * n - 1

	while left <= right:
		mid = (left + right) // 2
		mid_row, mid_col = divmod(mid, n)

		if matrix[mid_row][mid_col] == target:
			return True
		elif matrix[mid_row][mid_col] < target:
			left = mid + 1
		else:
			right = mid - 1

	return False