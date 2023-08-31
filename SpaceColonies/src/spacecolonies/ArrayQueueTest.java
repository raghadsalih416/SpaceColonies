//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Raghad Salih (906394954)
package spacecolonies;

import java.util.Arrays;
import queue.EmptyQueueException;

/**
 * this class tests the methods in the
 * array queue class
 * 
 * @author raghadsalih
 * @version 2022.25.10
 *
 */
public class ArrayQueueTest extends student.TestCase {
    // ~ Fields .......................................
    private ArrayQueue<String> queue;
    private ArrayQueue<String> queueEmpty;
    private ArrayQueue<String> queueDefault;

    /**
     * creates new ArrayQueue Objects
     */
    public ArrayQueueTest() {
        queue = new ArrayQueue<String>(20);
        queueEmpty = new ArrayQueue<String>(0);
        queueDefault = new ArrayQueue<String>();
    }


    /**
     * tests the get size
     * lengthOfUnderlyingArray and getFront
     * methods
     */
    public void testGetSize() {
        assertEquals(0, queue.getSize());
        assertEquals(0, queueDefault.getSize());
        assertEquals(21, queue.getLengthOfUnderlyingArray());
        Exception exception = null;
        try {
            queue.getFront();
            fail(".getFront is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(".getFront is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    /**
     * tests the to array and dequeue
     * methods
     */
    public void testDequeue() {
        queue.enqueue("hello");
        queue.enqueue("hello");
        queue.enqueue("hello");
        Object[] arrNew = new Object[3];
        arrNew[0] = "hello";
        arrNew[1] = "hello";
        arrNew[2] = "hello";
        assertTrue(Arrays.equals(queue.toArray(), arrNew));
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        Exception exception = null;
        try {
            queue.toArray();
            fail(".toArray is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(".toArray is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);

    }


    /**
     * tests the dequeue method
     */
    public void testDequeue2() {
        Exception exception = null;
        try {
            queue.dequeue();
            fail(".dequeue is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(".dequeue is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    /**
     * tests the getLength of unerlying array method
     */
    public void testSize() {
        for (int i = 0; i < 11; i++) {
            queue.enqueue("hello");
        }
        assertEquals(21, queue.getLengthOfUnderlyingArray());
    }


    /**
     * tests the enqueue method
     */
    public void testCapacity() {
        for (int i = 0; i < 21; i++) {
            queue.enqueue("hello");
        }
        assertEquals(41, queue.getLengthOfUnderlyingArray());

    }


    /**
     * tests the enqueue method
     */
    public void testEnqueue() {
        queue.enqueue("hello");
        assertEquals(1, queue.getSize());
    }


    /**
     * tests the getFront and isEmpty methods
     */
    public void testMultipleMethods() {
        assertTrue(queue.isEmpty());
        queue.enqueue("hello");
        assertEquals("hello", queue.getFront());
        assertFalse(queue.isEmpty());
    }


    /**
     * tests the clear method
     */
    public void testClear() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue("hello");
        }
        assertEquals(5, queue.getSize());
        queue.clear();
        assertEquals(0, queue.getSize());
    }


    /**
     * tests the ensure capacity when false
     */
    public void testEnsureCapacityFalse() {
        for (int i = 0; i < 20; i++) {
            queue.enqueue("hello");
        }
        assertEquals(20, queue.getSize());
        queue.enqueue("hello");
        queue.enqueue("hello");
        // assertEquals(41, queue.getSizeOfUnderlyingArray());

    }


    /**
     * tests the toString method
     */
    public void testToString() {
        queue.enqueue("hi");
        queue.enqueue("hello");
        assertEquals("[]", queueEmpty.toString());
        assertEquals("[hi, hello]", queue.toString());

    }


    /**
     * tests the equals method
     */
    public void testEquals() {
        ArrayQueue<String> queue2 = new ArrayQueue<String>(20);
        ArrayQueue<String> queue3 = new ArrayQueue<String>(0);
        ArrayQueue<String> queueEmpty2 = new ArrayQueue<String>(0);
        ArrayQueue<String> queue4 = new ArrayQueue<String>(0);

        queue.enqueue("hello");
        queue.enqueue("hi");
        queue.enqueue("grr");

        queue2.enqueue("hello");
        queue2.enqueue("hi");
        queue2.enqueue("grr");

        queue3.enqueue("hi");
        queue3.enqueue("hello");

        queue4.enqueue("hello");
        queue4.enqueue("hello");
        queue4.enqueue("hello");
        assertFalse(queue.equals(new Object()));
        assertFalse(queue.equals(null));
        assertTrue(queue.equals(queue));
        assertFalse(queue.equals(queueEmpty));
        assertFalse(queue.equals(queue3));
        assertTrue(queue.equals(queue2));
        assertFalse(queueEmpty.equals(queue3));
        assertTrue(queueEmpty.equals(queueEmpty));
        assertTrue(queueEmpty.equals(queueEmpty2));
        assertFalse(queue4.equals(queue));

    }
}
