

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

if __name__ == '__main__' :
    llist = LL() 
  
    llist.head  = Node(1) 
    second = Node(2) 
    third  = Node(3)
llist.head.next = second
second.next = third
llist.printList()
llist.insertNodeAtFront(4)
print "printing after insertion"
llist.printList()
llist.insertNodeAtEnd(5)
print "printing after insertion at end"
llist.printList()
llist.insertAtIndex(6, 2)
print "prnting list after inserting at index 3"
llist.printList()
llist.countNodesInLinkedList()
count = llist.countRecursive()
print "count recursive is " ,  count

