package io.mockxe.uni.s1.a9.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {

    @Test
    void testPutEntries() throws UnknownKeyException {
        AbstractMap<String, Integer> map = new ArrayMap<>();

        Launcher.putEntries(map);

        assert map.keysAsSet().size() == 3;

        assert map.getOrThrow("sizeInMB") == 42;
        assert map.getOrThrow("version") == 4;
        assert map.getOrThrow("yearOfRelease") == 2015;
    }

}