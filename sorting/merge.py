#program for merge sort
from array import array

def mergeSort(arr, l, r) :
	if l < r :
		m = (l+(r-1))/2
		mergeSort(arr, l, m)
		mergeSort(arr, m+1, r)
		merge(arr, l, m, r)

def merge(arr, l, m, r) :
	n1 = m-l+1
	n2 = r-m
	arr1 = array('i')
	arr2 = array('i')
	for i in range(0, n1) :
		arr1.append(arr[l+i])
	for j in range(0, n2) :
		arr2.append(arr[m+1+j])

	i = 0
	j = 0
	k = l
	while i<n1 and j<n2 :
		if (arr1[i] <= arr2[j]) :
			arr[k] = arr1[i]
			i = i+1
		else :
			arr[k] = arr2[j]
			j = j+1
		k = k+1
	while i < n1 :
		arr[k] = arr1[i]
		i = i+1
		k = k+1
	while j < n2 :
		arr[k] = arr2[j]
		j = j+1
		k = k+1


number = input()

intarray = array('i')
for i in range(0, number) :
	num = input()
	intarray.append(num)

mergeSort(intarray, 0, number-1)

print "sorted array is"
for i in range(0, number):
	print intarray[i]
