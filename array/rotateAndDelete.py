#program for redix sort
from array import array

def rotate(arr) :
	temp = arr[len(arr) - 1]
	i = len(arr)-1
	while i>=1 :
		arr[i] = arr[i-1]
		i=i-1
	arr[0] = temp




testCases = input()

for i in range(0, testCases) :
	arraySize = input()
	arr = [0] * arraySize
	for j in range(0, arraySize) :
		arr[i] = input()
	j=len(arr) - 1
	while len(arr) > 1 :
		rotate(arr)
		if (j > (len(arr)-1)) :
			arr.pop(0)
		else :
			arr.pop(j)
		j=j-1
	print "result array is"
	for k in range(0, len(arr)) :
		print arr[k]
	