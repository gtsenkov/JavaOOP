package InheritanceLab.StackOfStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class StackOfStrings {

    private ArrayList<String> data;
    private Deque<String> delegate;

    public StackOfStrings() {
        this.delegate = new ArrayDeque<>();
    }

    public void push(String item) {
        this.delegate.push(item);
    }

    public String pop() {
        return this.delegate.pop();
    }

    public String peek() {
        return this.delegate.peek();
    }

    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }
}
