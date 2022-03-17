package project2;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {

    private Node firstNode; // reference to first node
    private int numberOfEntries;
    private Node topNode; // References the first node in the chain

    public LinkedStack() {
        topNode = null;
    } // end default constructor

    /**
     * Locates a given entry within this bag.
     * Returns a reference to the node containing the entry, if located,
     * or null otherwise.
     * @author Frank M. Carrano, Timothy M. Henry
     * @version 5.0
     *  */ 
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end while

        return currentNode;
    } // end getReferenceTo

    public int getCurrentSize() {
        return numberOfEntries;
    } // end getCurrentSize

     /**
     * Removes all entries from this bag.
     * 
     * @author Frank M. Carrano, Timothy M. Henry
     * @version 5.0
     */
    public void clear() {
        topNode = null;
    } // end clear
      // @author Frank M. Carrano, Timothy M. Henry
      // @version 5.0

    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    } // end push

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } // end peek

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public T pop() {
        T top = peek(); // Might throw EmptyStackException

        // Assertion: topNode != null
        topNode = topNode.getNextNode();

        return top;
    } // end pop


      /**
     * @author Frank M. Carrano, Timothy M. Henry
     * @version 5.0
     */
    public boolean isEmpty() {
        return topNode == null;
    } // end isEmpty

   
    // @version 5.0 */
    private class Node {
        private T data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node

    // Converts an infix expression to an equivalent postfix expression. operatorStack = a new empty stack
    private static String convertToPostFix(String infix){
        StackInterface<Character> operatorStack = new LinkedStack<>();
        String postfix = "";

        int spot = 0;
        int end = infix.length()-1;
        char nextCharacter = infix.charAt(0);

        while(spot <= end){
            nextCharacter = infix.charAt(spot);
            switch(nextCharacter){
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+' : case '-' : case '*' : case '/' :
                    while (!operatorStack.isEmpty() &&  (opPrecedence(nextCharacter) <= opPrecedence(operatorStack.peek()))){
                        postfix += operatorStack.peek();
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(' :
                    operatorStack.push(nextCharacter);
                    break;
                case ')' :
                    char topOperator = operatorStack.pop();
                    while (topOperator != '('){
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        while (!operatorStack.isEmpty()){
            char topOperator = operatorStack.pop();
            postfix += topOperator;
        }
        return postfix;

    }

    private static int opPrecedence(char operator){
        switch (op){
            case '+': 
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
        }
    }

}
