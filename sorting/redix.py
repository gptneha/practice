#program for redix sort
from array import array

def redixSort(arr, exp) :
	count = [0]*10
	#preparing count array
	for i in range(0, len(arr)) :
		index = arr[i]/exp
		count[(index%10)]+=1

	#storing cumulative count
	for i in range(1, 10) :
		count[i] = count[i] + count[i-1]

	print "count Array is"
	for i in range(0, len(count)) :
		print count[i]
	#storing result in temparory array
	resultArray = [0]*len(arr)
	for i in range(0, len(arr)) :
		index = arr[i]/exp
		resultArray[count[(index%10)] - 1] = arr[i]
		count[(index%10)]-=1

	print "resultArray is"
	for i in range(0, len(resultArray)) :
		print resultArray[i]
	#copying result from temporary result array to original array
	for i in range(0, len(arr)) :
		arr[i] = resultArray[i]



number = input()

intarray = array('i')
for i in range(0, number) :
	num = input()
	intarray.append(num)

maxNum = max(intarray)
exponent = 1
while maxNum/exponent > 0 :
	redixSort(intarray, exponent)
	exponent = exponent*10
print "sorted array is"
for i in range(0, number):
	print intarray[i]

