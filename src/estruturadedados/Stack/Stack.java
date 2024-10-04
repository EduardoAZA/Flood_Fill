package estruturadedados.Stack;

import estruturadedados.StaticStructure;

public class Stack<T> extends StaticStructure<T> {

    public Stack() {
        super();
    }

    public Stack(int capacity) {
        super(capacity);
    }

    public void push(T element) {
        super.add(element);
    }

    public T top() {

        if (this.isEmpty()) {
            return null;
        }

        return this.elements[size - 1];
    }

    public T pop() {

        if (this.isEmpty()) {
            return null;
        }

        return this.elements[--size];
    }
}