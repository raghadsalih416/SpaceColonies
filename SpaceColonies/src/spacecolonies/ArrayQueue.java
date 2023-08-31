//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

import java.util.Arrays;
import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * this class creates the methods for
 * the array queue used in the space colonies
 * 
 * @author raghadsalih
 * @version 2022.25.10
 *
 *
 * @param <T>
 *            generic type used in the queue
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    // ~ Fields .......................................
    private T[] queue;
    /**
     * Default capacity of all arrays
     */
    public static final int DEFAULT_CAPACITY = 20;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    private int underlyingSize;

    /**
     * creates a new queue object
     * with a param indicating size of queue
     * 
     * @param num
     *            size of the queue, intiallized to default capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int num) {
        underlyingSize = num;
        queue = (T[])new Object[num + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;

    }


    /**
     * creates a new queue object
     * follows default capacity
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * gets the size of the queue array
     * 
     * @return the size of the queue array
     */
    public int getSize() {
        return size;
    }


    /**
     * gets the underlying size of the queue array
     * always 1 more than capacity
     * 
     * @return the underlying size of the queue array
     */
    public int getLengthOfUnderlyingArray() {
        return underlyingSize + 1;
    }


    /**
     * helper method that can be used to upgrade length
     * of the underlying array when queue is full
     * 
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if ((enqueueIndex + 2) % queue.length == dequeueIndex) {
            T[] oldContents = queue;
            int oldSize = queue.length;
            int newSize = 2 * underlyingSize;
            queue = (T[])new Object[newSize + 1];
            int x = dequeueIndex;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldContents[x];
                x = (x + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
            underlyingSize = 2 * underlyingSize;
        }
    }


    /**
     * helper method - anywhere you incrament
     * an index in the array
     * 
     * @param index
     *            index to be changed
     * @return the new index
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * clears the array
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }

    }


    /**
     * removes the first value in queue
     * 
     * @return the value that is removed
     */
    @Override
    public T dequeue() {
        T value = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        size--;
        return value;
    }


    /**
     * adds a newEntry to the back of the queue
     * 
     * @param newEntry
     *            the new entry being added
     */
    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = newEntry;
        size++;

    }


    /**
     * gets the front of the queue
     * 
     * @throws EmptyQueueException
     *             when array is full
     * @return the value at the front of index
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * checks to see if the queue is empty
     * 
     * @return true if queue is empty, false if not
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * converts the queue to an Array
     * 
     * @return an object array
     * @throws EmptyQueueException
     *             when queue is empty
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] arr = new Object[size];
        int i = dequeueIndex;
        for (int j = 0; j < size; j++) {

            arr[j] = queue[i];
            i = incrementIndex(i);
        }
        return arr;
    }


    /**
     * converts the queue to a string
     * 
     * @return a string made up of contents in queue
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        int i = dequeueIndex;
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        boolean firstItem = true;
        for (int j = 0; j < this.size; j++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }
            builder.append(String.valueOf(queue[i]));
            i = incrementIndex(i);
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * checks to see if both objects are equal
     * 
     * @param otherQueue
     *            other queue to be checked if equal
     * @return true if they = eachother, false if they do
     */
    public boolean equals(Object otherQueue) {
        if (this == otherQueue) {
            return true;
        }
        if (otherQueue == null) {
            return false;
        }
        if (this.getClass().equals(otherQueue.getClass())) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)otherQueue;
            if (this.isEmpty() && other.isEmpty()) {
                return true;
            }
            if (!this.isEmpty() && !other.isEmpty()) {
                return (Arrays.equals(this.toArray(), other.toArray()));
            }

        }
        return false;
    }

}
