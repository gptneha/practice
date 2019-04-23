class heap:
    def __init__(self):
        self.heap = []
    def isEmpty(self) :
        if (len(self.heap) == 0):
            return True
        else:
            return False
    def insertElement(self, data) :
        print "coming to this"
        if self.isEmpty():
            self.heap.append(data)
        else:
            self.heap.append(data)
            self.checkForPerfectPosition()
    def checkForPerfectPosition(self) :
        length = len(self.heap)
        data = self.heap[length-1]
        i = length - 1 
        while (self.heap[i] < self.heap[(i-1)/2] and i>0) :
            temp = self.heap[i]
            self.heap[i] = self.heap[(i-1)/2]
            self.heap[(i-1)/2] = temp
            i = (i-1)/2
    def printHeap(self):
        print "min heap is "
        print self.heap
    def heapSort (self) :
        poppedElement = self.heap.pop(len(self.heap)-1)
        print "popped element and size of array is now ", poppedElement, " ", len(self.heap) 
        print(*self.heap, sep='\n')

if __name__ == "__main__":
    newHeap = heap()
    newHeap.insertElement(8)
    newHeap.insertElement(2)
    newHeap.insertElement(3)
    newHeap.insertElement(4)
    newHeap.insertElement(5)
    newHeap.insertElement(6)
    newHeap.insertElement(7)
    newHeap.insertElement(1)
    newHeap.printHeap()
    newHeap.heapSort()
    newHeap.printHeap()

            