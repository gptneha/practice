#program for counting sort
from array import array
number = input()

intarray = array('i')
maxvalue = 0
for i in range(0, number) :
	num = input()
	intarray.append(num)
	if (num > maxvalue) :
		maxvalue = num
count = [0]*(maxvalue)
for j in range(0, number) :
	count[intarray[j]-1]+=1
for i in range(1, maxvalue) :
	count[i] = count[i] + count[i-1]

resultArray = [0]*number
for i in range(0, number) :
	resultArray[count[intarray[i]-1] - 1] = intarray[i]


print "sorted array is"
for i in range(0, number):
	print resultArray[i]
