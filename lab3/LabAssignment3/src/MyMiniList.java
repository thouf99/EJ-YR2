import java.util.Arrays;

public class MyMiniList <T> implements MiniList<T> {
    
    public T[] objectStore;
    public int objectSize;

    public MyMiniList() {
        objectStore = (T[])  new Object[10]; // initial array
        objectSize = 0; // size
    }
    @Override
    public void add(T element) {
        if(objectSize == objectStore.length)
        {
            extendsArray(); // doubles size of array and copies it
        }

        objectStore[objectSize++] = element; // adds element
    }
    private void extendsArray(){
        int newObjectSize = objectStore.length * 2; // doubling array
        objectStore = Arrays.copyOf(objectStore, newObjectSize); // copying array with original contents
    }


    @Override
    public T get(int index) {
        checkElement(index); // checking if the element is at the in the array
        return objectStore[index]; // if found return that index

    }
    //both methods checks if the current index is within
    //the size of array
    private void checkElement(int index) {

        if (index >= objectSize)
            throw new IndexOutOfBoundsException(ElementOutOfBoundsMsg(index)); // exception message displays when index is out of arraysize
    }

    private String ElementOutOfBoundsMsg(int index) {
        return "Index at position: " + index + ", Size of array is : "+objectSize;
    }

    @Override
    public int getIndex(T element) {
        if (element == null) {
            for (int i = 0; i < objectSize; i++)
                if (objectStore[i]==null)
                    return i;
        } else {
            for (int i = 0; i < objectSize; i++)
                if (element.equals(objectStore[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public void set(int index, T element) {
        if(index >= objectSize)
        {
            throw new IndexOutOfBoundsException(ElementOutOfBoundsMsg(index));
        }

        T valueOld = objectStore[index];
        objectStore[index] = element;


    }

    @Override
    public int size() {
        return objectSize;
    }

    @Override
    public T remove(int index) {
        if(index >= objectSize)
        {
            throw new IndexOutOfBoundsException(ElementOutOfBoundsMsg(index));
        }
        T valuePrevious = objectStore[index];

        int movedNumber = objectSize - index - 1;
        if (movedNumber > 0)
            System.arraycopy(objectStore, index+1, objectStore, index,
                    movedNumber);
        objectStore[--objectSize] = null;

        return valuePrevious;

        //return null;
    }

    @Override
    public boolean remove(T element) {
        int index = 0;
        if(element == null)
        {
            for(int i = 0; i < objectSize; i++)
            {
                if(objectStore[i] == null)
                {
                    int movedNumber = objectSize - index - 1;
                    if (movedNumber > 0)
                        System.arraycopy(objectStore, index+1, objectStore, index,
                                movedNumber);
                    objectStore[--objectSize] = null;
                    return  true;
                }
            }
        }
        else{
            for(int j = 0; j < objectSize; j++)
            {
                if(element.equals(objectStore[j]))
                {
                    int movedNumber = objectSize - index - 1;
                    if (movedNumber > 0)
                        System.arraycopy(objectStore, index+1, objectStore, index,
                                movedNumber);
                    objectStore[--objectSize] = null;
                    return true;
                }
            }

        }
        return false;

    }


    @Override
    public void clear() {
        for( int i = 0; i < objectSize; i++)
        {
            objectStore[i] = null;
        }
        objectSize = 0;

    }
}
