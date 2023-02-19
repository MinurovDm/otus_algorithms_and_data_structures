package model;

public class MatrixArray<T> implements IArray<T> {

    private int size;
    private final int vector;
    private final IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector) {
            array.add(new VectorArray<>(vector));
        }
        array.get(size / vector).add(item);
        size ++;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }

    @Override
    public void add(T item, int index) {
        while (array.size() <= index / vector) {
            array.add(new VectorArray<>(vector));
        }
        array.get(index / vector).add(item, index % vector);
        size ++;
    }

    @Override
    public T remove(int index) {
        return array.get(index / vector).remove(index % vector);
    }
}
