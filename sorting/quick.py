#program for quick sort
from array import array

def quicksort(arr, l, r) :
	if l<r :
		pivot = partition(arr, l, r)
		quicksort(arr, l, pivot-1)
		quicksort(arr, pivot+1, r)

def partition(arr, l, r) :
	pivot = arr[r]
	low = l
	for i in range(l, r+1) :
		if (arr[i] < pivot ) :
			value = arr[i]
			arr[i] = arr[low]
			arr[low] = value
			low=low+1
	value = arr[low]
	arr[low] = arr[r]
	arr[r] = value
	return low 



number = input()
intarray = array('i')
for i in range(0, number) :
	num = input()
	intarray.append(num)

quicksort(intarray, 0, number-1)

print "sorted array is"
for i in range(0, number):
	print intarray[i]