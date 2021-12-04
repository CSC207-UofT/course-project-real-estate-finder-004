package externalinterfaces;

import java.util.Set;

public interface Storage<T, K> {
    /**
     * Adds an object to the storage.
     * @param object    object to be added to the storage that has an id as its key
     */
    void add(K object);

    /**
     * Removes an id and its associated object from the storage
     * @param id    a key that has an associated value, object
     */
    void remove(T id);

    /**
     * Returns an object in the storage given its key.
     * @param id    a key that has an associated value, object
     * @return  an object in the storage
     */
    K get(T id);
    Set<T> keySet();
}
