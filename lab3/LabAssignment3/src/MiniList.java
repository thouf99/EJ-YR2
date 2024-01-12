public interface MiniList <T> {
    public void add(T element);
    public T get(int index);
    public int getIndex(T element);
    public void set(int index, T element);
    public int size();
    public T remove(int index);
    public boolean remove(T element);
    public void clear();
}
