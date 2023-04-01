package cz.radeknolc.java.helpers;

import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class QueueTest {

    Queue<Integer> queue;

    @BeforeEach
    void beforeEach() {
        queue = new Queue<>();
    }

    @Test
    void testMethods() {
        queue.add(1);
        queue.add(3);
        queue.add(7);
        queue.add(9);

        Assertions.assertEquals(4, queue.getCount());
        Assertions.assertEquals(1, queue.poll());
        Assertions.assertEquals(3, queue.getCount());

        queue.add(1);
        Assertions.assertEquals(3, queue.poll());
        Assertions.assertEquals(7, queue.poll());

        queue.peek();
        Assertions.assertEquals(1, queue.getCount());
        Assertions.assertEquals(1, queue.poll());

        queue.add(7);
        queue.add(5);
        queue.add(1);
        Assertions.assertEquals(7, queue.get());

        queue.peek();
        Assertions.assertEquals(5, queue.get());
    }
}
