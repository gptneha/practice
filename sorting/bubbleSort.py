#program for bubble sort
from array import array
number = input()

intarray = array('i')
for i in range(0, number) :
	num = input()
	intarray.append(num)

for i in range(0, number):
	for j in range(0, number-i-1):
		if intarray[j] > intarray[j+1]:
			minvalue = intarray[j]
			intarray[j] = intarray[j+1]
			intarray[j+1] = minvalue

print "sorted array is"
for i in range(0, number):
	print intarray[i]