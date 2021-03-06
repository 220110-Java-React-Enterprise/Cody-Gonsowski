package list;

/**
 * A fairly simple arraylist implementation extending custom list interface.
 * Default size is 2, grows by size * 2 when needed.
 * When an element is added or removed at an index other elements are not re-arranged.
 *
 * @param <E>
 */
public class CustomArrayList<E> implements CustomListInterface<E> {
    private Object[] array;
    private int size;
    private int maxSize;


    /**
     * Default constructor, creates an empty underlying array with maxSize 2
     */
    public CustomArrayList() {
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];
    }


    /**
     * Sized constructor, creates an empty object with maxSize size
     * @param size the initial size of the underlying array
     */
    public CustomArrayList(int size) {
        maxSize = size;
        this.size = 0;
        array = new Object[size];
    }


    /**
     * Element list constructor, takes in variable number of objects and creates an underlying
     * array large enough to fit them.
     * @param e
     */
    @SuppressWarnings("unchecked")
    //! heap pollution via varargs parameter
    public CustomArrayList(E... e) {
        maxSize = size = e.length;
        array = new Object[size];

        for (int i = 0; i < size; ++i) {
            array[i] = e[i];
        }
    }


    /**
     * Adds an object to the underlying array after all previously added objects.
     * If array needs to grow, it invokes grow method.
     * @param o object to be added
     */
    @Override
    public void add(Object o) {
        // increment size
        this.size++;

        // grow array if updated size is too large for current maxSize
        if (size >= maxSize) {
            growArray();
        }

        // updates end of array with Object o
        array[size - 1] = o;
    }


    /**
     * Adds object at specified index, advancing the size of the underlying array. This will
     * require us to shift all later elements further down the index order
     * @param index index location where object will be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(E e, int index) throws IndexOutOfBoundsException {
        // index out of bounds
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("ERROR: Index is out of bounds!");
        }

        // grow array if the new size would be too large
        if (this.size + 1 >= this.maxSize) {
            growArray();
        }

        // update size
        this.size++;

        // shift elements
        for (int i = this.size; i > index; i--) {
            array[i] = array[i - 1];
        }

        // update object at index to e
        array[index] = e;
    }


    /**
     * gets the object located at supplied index
     * @param index index of object to get
     * @return object located at index
     * @throws IndexOutOfBoundsException
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException {
        // index out of bounds
        if (index >= size) {
            throw new IndexOutOfBoundsException("ERROR: Index is out of bounds!");
        }

        // cast to generic type
        //! typecast is suppressed
        return (E)array[index];
    }


    /**
     * Emptys the underlying array by setting it's private reference to null and allowing
     * the old array to be garbage collected.
     */
    @Override
    public void clear() {
        array = null;
    }


    /**
     * Check if object o is found within underlying array, using Object.equals() method
     * @param o object to search for
     * @return index location of first instance of matching object. -1 if not found.
     */
    @Override
    public int contains(Object o) {
        for (int i = 0; i < this.size; i++) {
            // utilize get() method
            if (get(i).equals(o)) {
                // return index of current iteration if matching object was found
                return i;
            }
        }

        // if the object was not found, return -1
        return -1;
    }


    /**
     * Removes object at specified index from underlying array, we will then
     * need to shift the remaining elements up in the index order to fill in the gap
     * @param index index of object to remove from array
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        // index out of bounds
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("ERROR: Index is out of bounds!");
        }

        // update size
        this.size--;

        // shift elements
        for (int i = index; i < this.size; i++) {
            array[i] = array[i + 1];
        }
    }


    /**
     * returns size of array. This is the one greater than the index of the most advanced stored object,
     * not the maxSize which controls growth of the underlying array.
     * @return one greater than index of most advanced stored object
     */
    @Override
    public int size() {
        return this.size;
    }


    /**
     * Doubles the size of the underlying array by creating a new array and copying the
     * contents of the previous array into it.
     */
    private void growArray() {
        //System.out.println("Growing Array from " + maxSize + " to " + maxSize * 2);
        //set up new array
        maxSize = maxSize * 2;
        Object[] tempArray = array;
        array = new Object[maxSize];

        //copy to new array
        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }
    }

}
