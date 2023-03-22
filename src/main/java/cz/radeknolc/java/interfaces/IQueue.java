package cz.radeknolc.java.interfaces;

public interface IQueue<T> {

    void add(T data);
    T poll() throws Exception;
    T get() throws Exception;
    void peek() throws Exception;

}
