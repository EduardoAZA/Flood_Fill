package estruturadedados;

public class StaticStructure<T> {
    protected T[] elements;
    protected int size;

    public StaticStructure(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public StaticStructure() {
        this(10);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(T element) {
        this.increaseCapacity();
        if (this.size < this.elements.length) {
            this.elements[this.size] = element;
            this.size++;
            return true;
        }
        return false;
    }

    public boolean add(int position, T element) {

        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position");
        }

        this.increaseCapacity();

        for (int i = this.size - 1; i >= position; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[position] = element;
        this.size++;

        return true;
    }

    public void remove(int position) {
        if (!(position >= 0 && position < size)) {
            throw new IllegalArgumentException("Invalid position");
        }
        for (int i = position; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void increaseCapacity() {
        if (this.size == this.elements.length) {
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            for (int i = 0; i < this.elements.length; i++) {
                newElements[i] = this.elements[i];
            }
            this.elements = newElements;
        }
    }

    public int size() {
        return this.size;
    }


    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.size - 1; i++) {
            s.append(this.elements[i]);
            s.append(", ");
        }

        if (this.size > 0) {
            s.append(this.elements[this.size - 1]);
        }

        s.append("]");

        return s.toString();
    }
}