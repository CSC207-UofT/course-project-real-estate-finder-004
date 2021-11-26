package externalinterfaces;

public interface Storage<T, K> {
    void add(K object);
    void remove(T id);
    K get(T id);
}
