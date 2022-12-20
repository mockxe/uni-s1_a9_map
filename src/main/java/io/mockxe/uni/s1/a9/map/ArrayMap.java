package io.mockxe.uni.s1.a9.map;

import io.mockxe.uni.s1.a9.map.external.GenericArrayHelper;

import java.util.HashSet;
import java.util.Set;

public class ArrayMap<K, V> extends AbstractMap<K, V> {

    private Entry<K, V>[] entries;


    public ArrayMap(Entry<K, V>[] entries) {
        this.entries = GenericArrayHelper.copyArray(entries);
    }

    public ArrayMap() {
        this.entries = GenericArrayHelper.newEntryArrayOfSize(10);
    }


    @Override
    public V getOrThrow(K key) throws UnknownKeyException {
        for (Entry<K, V> entry : entries) {
            if (entry != null && entry.key().equals(key)) {
                return entry.value();
            }
        }

        throw new UnknownKeyException();
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null || entries[i].key().equals(key)) {
                entries[i] = new Entry<>(key, value);
                return;
            }
        }

        int oldLength = entries.length;
        entries = GenericArrayHelper.copyArrayWithIncreasedSize(entries, oldLength  * 2);
        entries[oldLength + 1] = new Entry<>(key, value);
    }

    @Override
    public Set<K> keysAsSet() {
        Set<K> set = new HashSet<>();

        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                set.add(entry.key());
            }
        }

        return set;
    }

}
