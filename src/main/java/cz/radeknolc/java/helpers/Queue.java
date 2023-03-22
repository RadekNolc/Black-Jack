package cz.radeknolc.java.helpers;

import cz.radeknolc.java.interfaces.IQueue;

public class Queue<T> implements IQueue<T> {

    private int count = 0;
    protected Link<T> first;
    protected Link<T> last;

    @Override
    public void add(T data) {
        Link<T> nl = new Link<>();
        nl.data = data;

        if (first == null) {
            first = nl;
        } else {
            last.next = nl;
        }

        last = nl;
        count++;
    }

    @Override
    public T poll() throws Exception {
        T item = (T) get();
        peek();

        return item;
    }

    @Override
    public T get() throws Exception {
        if (first != null) {
            return first.data;
        } else throw new Exception("There is nothing to get from the queue.");
    }

    @Override
    public void peek() throws Exception {
        if (first != null) {
            first = first.next;
            count--;
        } else throw new Exception("There is nothing to remove from the queue.");
    }

    public int getCount() {
        return count;
    }
}
