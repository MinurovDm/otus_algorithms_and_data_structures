package hw_12;

import java.util.LinkedList;

public class HashTableChaining<K, V> {
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList<Entry<K, V>>[] table;
    private int capacity;
    private int size;

    public HashTableChaining() {
        this(16);
    }

    public HashTableChaining(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int hash = hash(key);
        LinkedList<Entry<K, V>> bucket = table[hash];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
        if ((double) size / capacity >=  LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        if  (key == null) {
            return null;
        }
        int hash = hash(key);
        LinkedList<Entry<K, V>> bucket = table[hash];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }
        int hash = hash(key);
        LinkedList<Entry<K, V>> bucket = table[hash];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    private void resize() {
        capacity *= 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            newTable[i] = new LinkedList<>();
        }
        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                int hash = hash(entry.key);
                newTable[hash].add(entry);
            }
        }
        table = newTable;
    }


    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
