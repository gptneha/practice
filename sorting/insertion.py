#program for insertion sort
from array import array
number = input()

intarray = array('i')
for i in range(0, number) :
	num = input()
	intarray.append(num)

for i in range(0, number) :
	minvalue = intarray[i]
	index = i
	for j in range(i+1, number):
		if minvalue > intarray[j]:
			minvalue = intarray[j]
			index = j
	intarray[index] = intarray[i]
	intarray[i] = minvalue

print "sorted array is"
for i in range(0, number):
	print intarray[i]
