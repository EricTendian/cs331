interface Iterator<E> {
    E get();
    void next();
    boolean isValid();
    void delete();
}
