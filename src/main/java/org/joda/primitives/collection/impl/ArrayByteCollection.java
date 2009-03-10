/*
 *  Copyright 2001-2006 Stephen Colebourne
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

import org.joda.primitives.ByteUtils;
import org.joda.primitives.collection.ByteCollection;
import org.joda.primitives.iterator.ByteIterator;

/**
 * Array based implementation of <code>ByteCollection</code> for
 * primitive <code>byte</code> elements.
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
public class ArrayByteCollection extends AbstractByteCollection implements Cloneable {
    // This file is CODE GENERATED. Do not change manually.

    /** The minimum size allowed when growth occurs */
    private static final int MIN_GROWTH_SIZE = 4;
    /** The amount the collection grows by when resized (3/2) */
    private static final int GROWTH_FACTOR_MULTIPLIER = 3;
    /** The amount the collection grows by when resized (3/2) */
    private static final int GROWTH_FACTOR_DIVISOR = 2;

    /** The array of elements */
    private byte[] iData;
    /** The current size */
    private int iSize;

    /**
     * Constructor.
     */
    public ArrayByteCollection() {
        super();
        iData = ByteUtils.EMPTY_BYTE_ARRAY;
    }

    /**
     * Constructor that defines an initial size for the internal storage array.
     *
     * @param initialSize  the initial size of the internal array, negative treated as zero
     */
    public ArrayByteCollection(int initialSize) {
        super();
        if (initialSize <= 0) {
            iData = ByteUtils.EMPTY_BYTE_ARRAY;
        } else {
            iData = new byte[initialSize];
        }
    }

    /**
     * Constructor that copies the specified values.
     *
     * @param values  an array of values to copy, null treated as zero size array
     */
    public ArrayByteCollection(byte[] values) {
        super();
        if (values == null) {
            iData = ByteUtils.EMPTY_BYTE_ARRAY;
        } else {
            iData = (byte[]) values.clone();
            iSize = values.length;
        }
    }

    /**
     * Constructs a new collection by copying values from another collection.
     *
     * @param coll  a collection of values to copy, null treated as zero size collection
     */
    public ArrayByteCollection(Collection coll) {
        super();
        if (coll == null) {
            iData = ByteUtils.EMPTY_BYTE_ARRAY;
        } else if (coll instanceof ByteCollection) {
            ByteCollection c = (ByteCollection) coll;
            iSize = c.size();
            iData = new byte[iSize];
            c.toByteArray(iData, 0);
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
    public ArrayByteCollection(Iterator it) {
        super();
        if (it == null) {
            iData = ByteUtils.EMPTY_BYTE_ARRAY;
        } else if (it instanceof ByteIterator) {
            ByteIterator typed = (ByteIterator) it;
            iData = new byte[MIN_GROWTH_SIZE];
            while (typed.hasNext()) {
                add(typed.nextByte());
            }
        } else {
            iData = new byte[MIN_GROWTH_SIZE];
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
    public ByteIterator byteIterator() {
        return new PIterator(this);
    }

    /**
     * Adds a primitive value to this collection.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     */
    public boolean add(byte value) {
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
            byte[] array = new byte[iSize];
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
    public boolean contains(byte value) {
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
    public boolean addAll(byte[] values) {
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
    public boolean addAll(ByteCollection values) {
        checkAddModifiable();
        if (values == null || values.size() == 0) {
            return false;
        }
        int len = values.size();
        ensureCapacity(iSize + len);
        values.toByteArray(iData, iSize);
        iSize += len;
        return true;
    }

    /**
     * Adds a range of primitive values to this collection.
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the range is equivalent to an empty collection.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if a value is rejected by this set
     * @throws UnsupportedOperationException if not supported by this set
     */
    public boolean addAll(byte startInclusive, byte endInclusive) {
        int increase = endInclusive - startInclusive + 1;
        if (increase < 0) {
            return false;
        }
        ensureCapacity(iSize + increase);
        byte i = startInclusive;
        while (i < endInclusive) {
            iData[iSize++] = i++;
        }
        iData[iSize++] = i;  // handles endInclusive=MAX_VALUE
        return true;
    }

    /**
     * Clone implementation that calls Object clone().
     *
     * @return the clone
     */
    public Object clone() {
        ArrayByteCollection cloned = (ArrayByteCollection) super.clone();
        cloned.iData = (byte[]) iData.clone();
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
    protected void arrayCopy(int fromIndex, byte[] dest, int destIndex, int size) {
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
    protected boolean doAdd(int index, byte[] values) {
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
        byte[] newArray = new byte[newCapacity];
        System.arraycopy(iData, 0, newArray, 0, curCapacity);
        iData = newArray;
    }

    // Iterator
    //-----------------------------------------------------------------------
    /**
     * Iterator.
     */
    protected static class PIterator implements ByteIterator {

        private final ArrayByteCollection iCollection;
        private int iCursor = 0;
        private boolean iCanRemove = false;

        protected PIterator(ArrayByteCollection coll) {
            super();
            this.iCollection = coll;
        }

        public boolean hasNext() {
            return (iCursor < iCollection.iSize);
        }

        public byte nextByte() {
            if (hasNext() == false) {
                throw new NoSuchElementException("No more elements available");
            }
            iCanRemove = true;
            return iCollection.iData[iCursor++];
        }

        public Object next() {
            return iCollection.toObject(nextByte());
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
