package com.example;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in an array.
 * 
 * @author Frank M. Carrano and Timothy M. Henry
 * @version 5.0
 */
public class ResizeableArrayStack<T> implements StackInterface<T> {
    private T[] stack; // Array of stack entries
    private int topIndex; // Index of top entry
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizeableArrayStack() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    public ResizeableArrayStack(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end constructor

    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    } // end checkIntegrity


    /**
     * Throws an exception if the client requests a capacity that is too large.
     * 
     * @author Frank M. Carrano, Timothy M. Henry
     * @version 5.0
     */
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose " +
                    "capacity exeeds allowed " +
                    "maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    private void ensureCapacity() {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end ensureCapacity
      // @author Frank M. Carrano, Timothy M. Henry
      // @version 5.0

    public T peek() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } // end peek

    public void push(T newEntry)
    {
    checkIntegrity();
    ensureCapacity();
    stack[topIndex + 1] = newEntry;
    topIndex++;
    } // end push

    public T pop() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        } // end if
    } // end pop

    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0
    public boolean isEmpty() {
        return topIndex < 0;
    } // end isEmpty

    public void clear() {
        while (topIndex > 0) {
            pop();
        }
    } // end clear

}
