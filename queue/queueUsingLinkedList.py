class Node:
    def __init__(self, data) :
        self.data = data
        self.next = None
class LL:
    def __init__(self) :
        self.head = None
    def printQueue(self) :
        temp = self.head
        if (temp == None) :
            return
        while (temp != None) :
            print temp.data, "data is"
            temp = temp.next

    def insertNodeAtEnd(self, data) :
        temp = self.head
        while (temp.next != None) :
            temp = temp.next
        temp.next = Node(data)

    def countNodesInQueue(self) :
        count = 0
        temp = self.head
        while (temp.next != None) :
            count = count + 1
            temp = temp.next
        print "size of the linked list is " , count+1

    def countNodesInQueueRecursive(self, node) :
        if (node == None) :
            return 0
        return 1 + self.countNodesInLinkedListRecursive(node.next) 

    def countRecursive(self) :
        return self.countNodesInLinkedListRecursive(self.head)
    # def pop(self) :
    #     temp = self.head
    #     if (temp == None) :
    #         return self.head
    #     if (temp.next == None) :
    #         head = None
    #         return head
    #     while (temp.next.next is not None) :
    #         temp = temp.next
    #     temp.next = None
    #     return self
    def popQueue(self):
        temp = self.head
        if (temp == None):
            return None
        if (temp.next == None) :
            self.head = None
            return temp.data
        self.head = temp.next
        return temp.data 
    def peek(self) :
        if self.head != None:
            return self.head.data
        else :
            return 

if __name__ == "__main__":
    queue = LL()
    queue.head = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    node5 = Node(5)
    queue.head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    queue.printQueue()
    poppedElement = queue.popQueue()
    print "popped one element" , poppedElement
    print "Queue is now ", queue.printQueue()
    peekElement = queue.peek()
    print "peek element is ", peekElement
