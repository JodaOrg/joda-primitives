/*
 *  Copyright 2001-2009 Stephen Colebourne, Jason Tiscione
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.primitives.collection.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.joda.primitives.BooleanUtils;
import org.joda.primitives.collection.BooleanCollection;
import org.joda.primitives.iterator.BooleanIterator;

/**
 * Array based implementation of <code>BooleanCollection</code> for
 * primitive <code>boolean</code> elements.
 * <p>
 * This collection implementation allows multiple copies of the same value to be added.
 * Internally, it uses an array, and behaves much like a list.
 * <p>
 * This class implements {@link java.util.Collection Collection} allowing
 * seamless integration with other APIs.
 * <p>
 * Add, Remove and Clear are supported.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class ArrayBooleanCollection extends AbstractBooleanCollection implements Cloneable {
    // This file is CODE GENERATED. Do not change manually.

    /** The minimum size allowed when growth occurs */
    private static final int MIN_GROWTH_SIZE = 4;
    /** The amount the collection grows by when resized (3/2) */
    private static final int GROWTH_FACTOR_MULTIPLIER = 3;
    /** The amount the collection grows by when resized (3/2) */
    private static final int GROWTH_FACTOR_DIVISOR = 2;

    /** The array of elements */
    private boolean[] iData;
    /** The current size */
    private int iSize;

    /**
     * Constructor.
     */
    public ArrayBooleanCollection() {
        super();
        iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
    }

    /**
     * Constructor that defines an initial size for the internal storage array.
     *
     * @param initialSize  the initial size of the internal array, negative treated as zero
     */
    public ArrayBooleanCollection(int initialSize) {
        super();
        if (initialSize <= 0) {
            iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
        } else {
            iData = new boolean[initialSize];
        }
    }

    /**
     * Constructor that copies the specified values.
     *
     * @param values  an array of values to copy, null treated as zero size array
     */
    public ArrayBooleanCollection(boolean[] values) {
        super();
        if (values == null) {
            iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
        } else {
            iData = (boolean[]) values.clone();
            iSize = values.length;
        }
    }

    /**
     * Constructs a new collection by copying values from another collection.
     *
     * @param coll  a collection of values to copy, null treated as zero size collection
     */
    public ArrayBooleanCollection(Collection<?> coll) {
        super();
        if (coll == null) {
            iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
        } else if (coll instanceof BooleanCollection) {
            BooleanCollection c = (BooleanCollection) coll;
            iSize = c.size();
            iData = new boolean[iSize];
            c.toBooleanArray(iData, 0);
        } else {
            iData = toPrimitiveArray(coll);
            iSize = coll.size();
        }
    }

    /**
     * Constructs a new collection by copying values from an iterator.
     *
     * @param it  an iterator of values to extract, null treated as zero size collection
     */
    public ArrayBooleanCollection(Iterator<Boolean> it) {
        super();
        if (it == null) {
            iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
        } else if (it instanceof BooleanIterator) {
            BooleanIterator typed = (BooleanIterator) it;
            iData = new boolean[MIN_GROWTH_SIZE];
            while (typed.hasNext()) {
                add(typed.nextBoolean());
            }
        } else {
            iData = new boolean[MIN_GROWTH_SIZE];
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }

    // Implementation
    //-----------------------------------------------------------------------
    /**
     * Gets the current size of the collection.
     *
     * @return the current size
     */
    public int size() {
        return iSize;
    }

    /**
     * Gets an iterator over this collection.
     *
     * @return an iterator over this collection
     */
    public BooleanIterator booleanIterator() {
        return new PIterator(this);
    }

    /**
     * Adds a primitive value to this collection.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     */
    public boolean add(boolean value) {
        ensureCapacity(iSize + 1);
        iData[iSize++] = value;
        return true;
    }

    // Overrides
    //-----------------------------------------------------------------------
    /**
     * Optimizes the implementation.
     * <p>
     * This implementation changes the internal array to be the same size as
     * the size of the collection.
     */
    public void optimize() {
        if (iSize < iData.length) {
            boolean[] array = new boolean[iSize];
            System.arraycopy(iData, 0, array, 0, iSize);
            iData = array;
        }
    }

    /**
     * Are the add methods supported.
     *
     * @return <code>true</code>
     */
    protected boolean isAddModifiable() {
        return true;
    }

    /**
     * Are the remove methods supported.
     *
     * @return <code>true</code>
     */
    protected boolean isRemoveModifiable() {
        return true;
    }

    /**
     * Checks whether the object can currently be modified.
     *
     * @return <code>true</code>
     */
    public boolean isModifiable() {
        return true;
    }

    /**
     * Checks whether this collection contains a specified primitive value.
     * <p>
     * This implementation uses the internal array directly.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(boolean value) {
        for (int i = 0; i < iSize; i++) {
            if (iData[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears the collection of all elements.
     * The collection will have a zero size after this method completes.
     * <p>
     * This implementation resets the size, but does not reduce the internal storage array.
     */
    public void clear() {
        iSize = 0;
    }

    /**
     * Adds an array of primitive values to this collection.
     *
     * @param values  the values to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     */
    public boolean addAll(boolean[] values) {
        checkAddModifiable();
        if (values == null || values.length == 0) {
            return false;
        }
        return doAdd(0, values);
    }

    /**
     * Adds a collection of primitive values to this collection.
     *
     * @param values  the values to add to this collection, null treated as empty collection
     * @return <code>true</code> if this collection was modified by this method call
     */
    public boolean addAll(BooleanCollection values) {
        checkAddModifiable();
        if (values == null || values.size() == 0) {
            return false;
        }
        int len = values.size();
        ensureCapacity(iSize + len);
        values.toBooleanArray(iData, iSize);
        iSize += len;
        return true;
    }

    /**
     * Clone implementation that calls Object clone().
     *
     * @return the clone
     */
    public Object clone() {
        ArrayBooleanCollection cloned = (ArrayBooleanCollection) super.clone();
        cloned.iData = (boolean[]) iData.clone();
        return cloned;
    }

    /**
     * Copies data from this collection into the specified array.
     * This method is pre-validated.
     *
     * @param fromIndex  the index to start from
     * @param dest  the destination array
     * @param destIndex  the destination start index
     * @param size  the number of items to copy
     */
    protected void arrayCopy(int fromIndex, boolean[] dest, int destIndex, int size) {
        System.arraycopy(iData, fromIndex, dest, destIndex, size);
    }

    // Internal implementation
    //-----------------------------------------------------------------------
    /**
     * Internal implementation to add to this collection at the specified index.
     * This method adjusts the capacity and size.
     * 
     * @param index  the index to add at, valid
     * @param values  the array to add, not null
     * @return true if the array was updated
     */
    protected boolean doAdd(int index, boolean[] values) {
        int len = values.length;
        ensureCapacity(iSize + len);
        System.arraycopy(values, 0, iData, iSize, len);
        iSize += len;
        return (len > 0);
    }

    /**
     * Internal implementation to remove the element at the specified index.
     * 
     * @param index  the index, valid
     */
    protected void doRemoveIndex(int index) {
        System.arraycopy(iData, index + 1, iData, index, iSize - 1 - index);
        iSize--;
    }

    /**
     * Internal implementation to ensure that the internal storage array has
     * at least the specified size.
     * 
     * @param reqCapacity  the amount to expand to
     */
    protected void ensureCapacity(int reqCapacity) {
        int curCapacity = iData.length;
        if (reqCapacity <= curCapacity) {
            return;
        }
        int newCapacity = curCapacity * GROWTH_FACTOR_MULTIPLIER / GROWTH_FACTOR_DIVISOR;
        if ((newCapacity - curCapacity) < MIN_GROWTH_SIZE) {
            newCapacity = curCapacity + MIN_GROWTH_SIZE;
        }
        if (newCapacity < reqCapacity) {
            newCapacity = reqCapacity;
        }
        boolean[] newArray = new boolean[newCapacity];
        System.arraycopy(iData, 0, newArray, 0, curCapacity);
        iData = newArray;
    }

    // Iterator
    //-----------------------------------------------------------------------
    /**
     * Iterator.
     */
    protected static class PIterator implements BooleanIterator {

        private final ArrayBooleanCollection iCollection;
        private int iCursor = 0;
        private boolean iCanRemove = false;

        protected PIterator(ArrayBooleanCollection coll) {
            super();
            this.iCollection = coll;
        }

        public boolean hasNext() {
            return (iCursor < iCollection.iSize);
        }

        public boolean nextBoolean() {
            if (hasNext() == false) {
                throw new NoSuchElementException("No more elements available");
            }
            iCanRemove = true;
            return iCollection.iData[iCursor++];
        }

        public Boolean next() {
            return iCollection.toObject(nextBoolean());
        }

        public void remove() {
            if (iCanRemove == false) {
                throw new IllegalStateException("Element cannot be removed");
            }
            iCollection.doRemoveIndex(--iCursor);
            iCanRemove = false;
        }

        public boolean isModifiable() {
            return iCollection.isModifiable();
        }

        public boolean isResetable() {
            return true;
        }

        public void reset() {
            iCursor = 0;
        }
    }

}
