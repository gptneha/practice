
class Stack:
    def __init__(self) :
        self.stack = []
    def push(self, data) :
        self.stack.append(data)
    def isEmpty(self) :
        return len(self.stack) == 0
    def removeFirst(self) :
        if (self.isEmpty()):
            return self.isEmpty()
        else :
            return self.stack.pop()
    def printStack(self):
        for i, val in enumerate(self.stack):
            print i, " ", val
    def peek(self):
        return self.stack[len(self.stack) - 1]
    def decidePrecedence(self, c) :
        mapping = {
            '/': 2,
            '*': 2,
            '+': 1,
            '-': 1
        }
        return mapping[c]
    def infixTOPostfixConversion(self, infixExpression) :
        postfixStack = Stack()
        output = ""
        for c in infixExpression:
            if ((c >= 'a' and c <= 'z') or (c >= 'A' and c<= 'Z')) :
                output = output + c
            elif (c is '(' or c is ')'):
                continue
            else :
                if (postfixStack.isEmpty()):
                    postfixStack.push(c)
                else :
                    result = self.decidePrecedence(c)
                    top = self.decidePrecedence(postfixStack.peek())
                    while (top >= result or postfixStack.isEmpty()) :
                        output = output+ postfixStack.peek()
                        postfixStack.removeFirst()
                        if not postfixStack.isEmpty() :
                            top = self.decidePrecedence(postfixStack.peek())
                        else :
                            break
                    postfixStack.push(c)
        if not (postfixStack.isEmpty()) :
            while not postfixStack.isEmpty() :
                output = output + postfixStack.removeFirst()
        print "postfix expression is ",  output
    def decideOperator(self, c) :
        mapOperation = {
            '/' : 1,
            '*' : 2,
            '+' : 3,
            '-' : 4
        }
        return mapOperation[c]
    def evaluatePostfixExpression(self, postfixExpression):
        evaluatePostfixStack = Stack()
        for c in postfixExpression :
            if (ord(c) >= 48 and ord(c) <= 57) :
                print "Number found"
                evaluatePostfixStack.push(ord(c) - 48)
            else :
                if (evaluatePostfixStack.isEmpty()) :
                    print "stack should not be empty"
                operator = self.decideOperator(c)
                operand1 = evaluatePostfixStack.peek()
                evaluatePostfixStack.removeFirst()
                operand2 = evaluatePostfixStack.peek()
                result = 0
                evaluatePostfixStack.removeFirst()
                print "operend 1st is " , operand1, " operend 2nd is " , operand2 , " operator is ", c 
                if (operator is 1) :
                    result = operand1/operand2
                elif (operator is 2) :
                    result = operand1 * operand2
                elif (operator is 3) :
                    result = operand1 + operand2
                elif (operator is 4) :
                    result = operand1 - operand2
                evaluatePostfixStack.push(result)
        finalResult = evaluatePostfixStack.peek()
        print "result of the expression is " ,  finalResult

    def nextGreaterElement(self, arr) :
        print "arr is " ,arr
        newStack = Stack()
        output = []
        for value in arr :
            if (newStack.isEmpty()) :
                newStack.push(value)
            else :
                e = newStack.peek()
                while ( (not newStack.isEmpty()) and value > e ) :
                    print "in while loop"
                    output.append(value)
                    newStack.removeFirst()
                    if (not  newStack.isEmpty()) :
                        e = newStack.peek()
                newStack.push(value)
        while (not newStack.isEmpty()) :
            output.append(-1)
            newStack.removeFirst()
        print "next greater element array is " ,  output

    def insertAtBottom(self, item): 
        if self.isEmpty(): 
            self.push(item) 
        else: 
            temp = self.removeFirst() 
            self.insertAtBottom(item) 
            self.push(temp)
    def reverse(self): 
        if not self.isEmpty(): 
            temp = self.removeFirst() 
            self.reverse() 
            self.insertAtBottom(temp)

    def sortStack(self):
        if not self.isEmpty():
            temp = self.removeFirst()
            self.sortStack()
            self.insertAtProperIndex(temp)
    def insertAtProperIndex(self, data):
        if self.isEmpty() or data > self.peek():
            self.push(data)
        else :
            temp = self.removeFirst()
            self.insertAtProperIndex(data)
            self.push(temp)



if __name__ == '__main__' :
    stack1 = Stack() 
    stack1.push(1)
    stack1.push(2)
    stack1.push(3)
    stack1.push(4)
    stack1.push(5)
    stack1.push(6)
stack1.printStack()
poppedElement = stack1.removeFirst()
print "popped element is", poppedElement
stack1.printStack()
print "is stack empty ", stack1.isEmpty()
print "Top element in stack is ", stack1.peek()
stack1.infixTOPostfixConversion("((a*b)+c)-(d*f)")
stack1.evaluatePostfixExpression("12*3+")
#num_array = list()
#num = raw_input("Enter how many elements you want:")
#print 'Enter numbers in array: '
#for i in range(int(num)):
#    n = raw_input("num :")
#    num_array.append(int(n))
#print 'ARRAY: ',num_array
stack1.nextGreaterElement([1,2,3,4,5,6 ,12, 11])
print "stack before calling reverse function is"
stack1.printStack()
stack1.reverse()
print "stack before sorting elements are"
stack1.printStack()
print "stack after sorting is "
stack1.sortStack()
print stack1.printStack()


