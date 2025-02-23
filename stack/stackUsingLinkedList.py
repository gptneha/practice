
class Node:
    def __init__(self, data) :
        self.data = data
        self.next = None
class LL:
    def __init__(self) :
        self.head = None
    def printList(self) :
        temp = self.head
        while (temp != None) :
            print temp.data
            temp = temp.next

    def insertNodeAtFront(self, data) :
        temp = self.head
        self.head = Node(data)
        self.head.next = temp

    def insertNodeAtEnd(self, data) :
        temp = self.head
        while (temp.next != None) :
            temp = temp.next
        temp.next = Node(data)

    def insertAtIndex(self, data, index) :
        temp = self.head
        count = 1
        if (temp == None) :
            return 
        while (temp.next != None and count < index ) :
            # print count , " count is"
            temp = temp.next
            count = count + 1
        new_temp = temp.next
        temp.next = Node(data)
        temp.next.next = new_temp

    def countNodesInLinkedList(self) :
        count = 0
        temp = self.head
        while (temp.next != None) :
            count = count + 1
            temp = temp.next
        print "size of the linked list is " , count+1
    def countNodesInLinkedListRecursive(self, node) :
        if (node == None) :
            return 0
        return 1 + self.countNodesInLinkedListRecursive(node.next) 
    def countRecursive(self) :
        return self.countNodesInLinkedListRecursive(self.head)
    def pop(self) :
        temp = self.head
        if (temp == None) :
            return self.head
        if (temp.next == None) :
            head = None
            return head
        while (temp.next.next is not None) :
            print "in loop"
            temp = temp.next
        temp.next = None
        return self

if __name__ == "__main__":
    linkedList = LL()
    linkedList.head = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)
    node5 = Node(5)
    linkedList.head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    linkedList.printList()
    print "inserting node 6 at the end"
    linkedList.insertNodeAtEnd(6)
    linkedList.pop()
    print "popped one element" , linkedList.printList()
