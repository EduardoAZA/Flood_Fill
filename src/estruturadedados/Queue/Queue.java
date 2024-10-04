package estruturadedados.Queue;

import estruturadedados.StaticStructure;

public class Queue<T> extends StaticStructure<T> {
    public Queue() {
        super();
    }

    public Queue(int capacity) {
        super(capacity);
    }

    public void enqueue(T element) {
        this.add(element);
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }

        return this.elements[0];
    }

    public T dequeue() {
        final int POSITION = 0;

        if (this.isEmpty()) {
            return null;
        }

        T elementToBeRemoved = this.elements[POSITION];

        this.remove(POSITION);

        return elementToBeRemoved;
    }
}
