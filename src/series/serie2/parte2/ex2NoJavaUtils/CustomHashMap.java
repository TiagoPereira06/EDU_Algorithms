package series.serie2.parte2.ex2NoJavaUtils;

import series.serie2.parte2.LinkedList;

public class CustomHashMap<K, V> {
    private Entry<K, V>[] table;
    private LinkedList<K> keys = new LinkedList<>();
    private LinkedList<V> values = new LinkedList<>();
    private int capacity = 4;


    public CustomHashMap() {
        table = new Entry[capacity];
    }

    public boolean containsKey(K key) {
        return keys.contains(key) != -1;
    }

    public Iterable<Object> keySet() {
        return (Iterable<Object>) keys;
    }

    public Iterable<? extends Integer> values() {
        return (Iterable<? extends Integer>) values;
    }

    public void put(K newKey, V data) {
        if (newKey == null)
            return;
        int dif = keys.contains(newKey);
        if (dif == -1) {
            keys.addFirst(newKey);
            values.addFirst(data);
        } else {
            values.deleteNode(dif);
            values.addFirst(data);
            keys.deleteNode(dif);
            keys.addFirst(newKey);
        }

        int hash = hash(newKey);
        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { //we have reached last entry node of bucket.
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {  //delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
