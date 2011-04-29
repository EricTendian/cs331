interface Iterator<E> {
    UpTree.Node get();
    void next();
    boolean isValid();
}