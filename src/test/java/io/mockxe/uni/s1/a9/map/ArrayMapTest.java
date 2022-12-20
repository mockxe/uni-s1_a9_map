package io.mockxe.uni.s1.a9.map;

import io.mockxe.uni.s1.a9.map.external.GenericArrayHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayMapTest {

    @Test
    void testGetOrThrow() throws UnknownKeyException {

        Entry<String, Integer>[] entries = GenericArrayHelper.newEntryArrayOfSize(3);
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new Entry<>("test" + i, i);
        }

        ArrayMap<String, Integer> map = new ArrayMap<>(entries);

        assert map.getOrThrow("test0") == 0;
        assert map.getOrThrow("test1") == 1;
        assert map.getOrThrow("test2") == 2;

        assertThrows(UnknownKeyException.class, () -> map.getOrThrow("test4"));

    }

    @Test
    void testPut() throws UnknownKeyException {
        ArrayMap<String, Integer> map = new ArrayMap<>();

        assertThrows(UnknownKeyException.class, () -> map.getOrThrow("test0"));

        for (int i = 0; i <= 20; i++) {
            map.put("test" + i, i);
            assert map.getOrThrow("test" + i).equals(i);
        }

        for (int i = 20; i >= 0; i--) {
            assert map.getOrThrow("test" + i).equals(i);
        }

    }

}