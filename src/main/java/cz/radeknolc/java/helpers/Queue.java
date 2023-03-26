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
    public T poll() {
        T item = (T) get();
        peek();

        return item;
    }

    @Override
    public T get() {
        if (first != null) {
            return first.data;
        }

        return null;
    }

    @Override
    public void peek() {
        if (first != null) {
            first = first.next;
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
