package io.mockxe.uni.s1.a9.map;

import java.util.HashSet;
import java.util.Set;

public class Launcher {

    public static void main(String[] args) {
        AbstractMap<String, Integer> map = new ArrayMap<>();

        putEntries(map);
        printMap(map);


        Set<String> keys = new HashSet<>();
        keys.add("unknown");

        try {
            map.getValuesAsSetOrThrow(keys);
        } catch (UnknownKeyException e) {
            System.out.println("unknown key");
        }
    }


    public static void putEntries(AbstractMap<String, Integer> map) {
        map.put("sizeInMB", 42);
        map.put("version", 4);
        map.put("yearOfRelease", 2015);
    }

    public static <K, V> void printMap(AbstractMap<K, V> map) {
        for (K key : map.keysAsSet()) {
            try {
                System.out.println(key + ": " + map.getOrThrow(key));
            } catch (UnknownKeyException e) {
                System.out.println("encountered " + e + " for key " + key);
            }
        }
    }

}
