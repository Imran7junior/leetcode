nums = [0,1,2,4]
n = len(nums)
ans = 0
for i in range(1, n + 1):
	ans ^= i
	print(ans)
for num in nums:
	ans ^= num
print(ans)