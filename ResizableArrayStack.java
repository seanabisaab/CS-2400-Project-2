import java.util.Arrays;
import java.util.EmptyStackException;

/** A class of stacks whose entries are stored in an array. */
public class ResizableArrayStack<T> implements StackInterface<T>
{
    private T[] stack; // Array of stack entries.
    private int topIndex; // Index of top entry.
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizableArrayStack()
    {
        this(DEFAULT_CAPACITY);
    } // end of default constructor

    public ResizableArrayStack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    } // end of type constructor.

    @Override
    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end of "push"

    @Override
    public T pop()
    {
        checkIntegrity();
        T top = peek();

        stack[topIndex] = null;
        topIndex--;
        return top;

    } // end of "pop"

    @Override
    public T peek()
    {
        checkIntegrity();
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[topIndex];
        }
    } // end of "peek"

    @Override
    public boolean isEmpty()
    {
        return topIndex < 0;
    } // end of "isEmpty"

    @Override
    public void clear()
    {
        checkIntegrity();

        // remove references to the objects in the stack,
        // but do not deallocate the array.
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        } // end of while
        // Assertion: topIndex is -1.
    } // end of "clear"

    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("ResizableArrayStack object is corrupt...");
    } // end of "checkIntegrity"

    private void ensureCapacity()
    {
        if (topIndex >= stack.length - 1) // If array is full, double its size
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        } // end if
    } // end of "ensureCapacity"

    private void checkCapacity(int size)
    {
        if (size > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack whose "
                    + "capacity exceeds allowed "
                    + "maximum of " + MAX_CAPACITY);
    } // end of "checkCapacity"
} // end of "ResizableArrayStack" class
