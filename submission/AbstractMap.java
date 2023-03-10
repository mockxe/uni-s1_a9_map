import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMap<K, V> {

    public abstract V getOrThrow(K key) throws UnknownKeyException;

    public abstract void put(K key, V value);

    public abstract Set<K> keysAsSet();

    public Set<V> getValuesAsSetOrThrow(Set<K> keys) throws UnknownKeyException {
        Set<V> set = new HashSet<>();

        for (K key : keys) {
            set.add(getOrThrow(key));
        }

        return set;
    }

}
