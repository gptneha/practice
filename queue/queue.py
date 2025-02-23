class Queue :
    def __init__(self) :
        self.queue = []
    def push(self, item):
        self.queue.append(item)
    def isEmptyQueue(self):
        if (len(self.queue) == 0):
            return True
        else:
            return False
    def removeFirst(self) :
        if not self.isEmptyQueue():
            return self.queue.pop(0)
        else :
            return "empty stack"

    def printQueue(self) :
        print "queue is"
        for value in self.queue:
            print value

    def peek(self) :
        if not self.isEmptyQueue():
            return self.queue[0]
        else :
            return "stack is empty"

if __name__ == "__main__":
    q = Queue()
    q.push(1)
    q.push(2)
    q.push(3)
    q.push(4)
    q.printQueue()
    poppedElement = q.removeFirst()
    print "pooped element is ", poppedElement
    peekElement = q.peek()
    print "peek element is ", peekElement
    
