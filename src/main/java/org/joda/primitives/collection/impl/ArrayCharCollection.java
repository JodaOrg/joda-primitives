/*
 *  Copyright 2001-2013 Stephen Colebourne
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

import org.joda.primitives.CharUtils;
import org.joda.primitives.collection.CharCollection;
import org.joda.primitives.iterator.CharIterator;

/**
 * Array based implementation of <code>CharCollection</code> for
 * primitive <code>char</code> elements.
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
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class ArrayCharCollection extends AbstractCharCollection implements Cloneable {
    // This file is CODE GENERATED. Do not change manually.

    /** The minimum size allowed when growth occurs */
    private static final int MIN_GROWTH_SIZE = 4;
    /** The amount the collection grows by when resized (3/2) */
    private static final int GROWTH_FACTOR_MULTIPLIER = 3;
    /** The amount the collection grows by when resized (3/2) */
    private static final int GROWTH_FACTOR_DIVISOR = 2;

    /** The array of elements */
    private char[] data;
    /** The current size */
    private int size;

    /**
     * Constructor.
     */
    public ArrayCharCollection() {
        super();
        data = CharUtils.EMPTY_CHAR_ARRAY;
    }

    /**
     * Constructor that defines an initial size for the internal storage array.
     *
     * @param initialSize  the initial size of the internal array, negative treated as zero
     */
    public ArrayCharCollection(int initialSize) {
        super();
        if (initialSize <= 0) {
            data = CharUtils.EMPTY_CHAR_ARRAY;
        } else {
            data = new char[initialSize];
        }
    }

    /**
     * Constructor that copies the specified values.
     *
     * @param values  an array of values to copy, null treated as zero size array
     */
    public ArrayCharCollection(char[] values) {
        super();
        if (values == null) {
            data = CharUtils.EMPTY_CHAR_ARRAY;
        } else {
            data = (char[]) values.clone();
            size = values.length;
        }
    }

    /**
     * Constructs a new collection by copying values from another collection.
     *
     * @param coll  a collection of values to copy, null treated as zero size collection
     */
    public ArrayCharCollection(Collection<?> coll) {
        super();
        if (coll == null) {
            data = CharUtils.EMPTY_CHAR_ARRAY;
        } else if (coll instanceof CharCollection) {
            CharCollection c = (CharCollection) coll;
            size = c.size();
            data = new char[size];
            c.toCharArray(data, 0);
        } else {
            data = toPrimitiveArray(coll);
            size = coll.size();
        }
    }

    /**
     * Constructs a new collection by copying values from an iterator.
     *
     * @param it  an iterator of values to extract, null treated as zero size collection
     */
    public ArrayCharCollection(Iterator<Character> it) {
        super();
        if (it == null) {
            data = CharUtils.EMPTY_CHAR_ARRAY;
        } else if (it instanceof CharIterator) {
            CharIterator typed = (CharIterator) it;
            data = new char[MIN_GROWTH_SIZE];
            while (typed.hasNext()) {
                add(typed.nextChar());
            }
        } else {
            data = new char[MIN_GROWTH_SIZE];
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
        return size;
    }

    /**
     * Gets an iterator over this collection capable of accessing the primitive values.
     *
     * @return an iterator over this collection
     */
    public CharIterator iterator() {
        return new PIterator(this);
    }

    /**
     * Adds a primitive value to this collection.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     */
    public boolean add(char value) {
        ensureCapacity(size + 1);
        data[size++] = value;
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
        if (size < data.length) {
            char[] array = new char[size];
            System.arraycopy(data, 0, array, 0, size);
            data = array;
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
    public boolean contains(char value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
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
        size = 0;
    }

    /**
     * Adds an array of primitive values to this collection.
     *
     * @param values  the values to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     */
    public boolean addAll(char[] values) {
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
    public boolean addAll(CharCollection values) {
        checkAddModifiable();
        if (values == null || values.size() == 0) {
            return false;
        }
        int len = values.size();
        ensureCapacity(size + len);
        values.toCharArray(data, size);
        size += len;
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
    public boolean addAll(char startInclusive, char endInclusive) {
        int increase = endInclusive - startInclusive + 1;
        if (increase < 0) {
            return false;
        }
        ensureCapacity(size + increase);
        char i = startInclusive;
        while (i < endInclusive) {
            data[size++] = i++;
        }
        data[size++] = i;  // handles endInclusive=MAX_VALUE
        return true;
    }

    /**
     * Clone implementation that calls Object clone().
     *
     * @return the clone
     */
    public Object clone() {
        ArrayCharCollection cloned = (ArrayCharCollection) super.clone();
        cloned.data = (char[]) data.clone();
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
    protected void arrayCopy(int fromIndex, char[] dest, int destIndex, int size) {
        System.arraycopy(data, fromIndex, dest, destIndex, size);
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
    protected boolean doAdd(int index, char[] values) {
        int len = values.length;
        ensureCapacity(size + len);
        System.arraycopy(values, 0, data, size, len);
        size += len;
        return (len > 0);
    }

    /**
     * Internal implementation to remove the element at the specified index.
     * 
     * @param index  the index, valid
     */
    protected void doRemoveIndex(int index) {
        System.arraycopy(data, index + 1, data, index, size - 1 - index);
        size--;
    }

    /**
     * Internal implementation to ensure that the internal storage array has
     * at least the specified size.
     * 
     * @param reqCapacity  the amount to expand to
     */
    protected void ensureCapacity(int reqCapacity) {
        int curCapacity = data.length;
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
        char[] newArray = new char[newCapacity];
        System.arraycopy(data, 0, newArray, 0, curCapacity);
        data = newArray;
    }

    // Iterator
    //-----------------------------------------------------------------------
    /**
     * Iterator.
     */
    protected static class PIterator implements CharIterator {

        private final ArrayCharCollection collection;
        private int cursor;
        private boolean canRemove;

        protected PIterator(ArrayCharCollection coll) {
            super();
            this.collection = coll;
        }

        public boolean hasNext() {
            return (cursor < collection.size);
        }

        public char nextChar() {
            if (hasNext() == false) {
                throw new NoSuchElementException("No more elements available");
            }
            canRemove = true;
            return collection.data[cursor++];
        }

        public Character next() {
            return collection.toObject(nextChar());
        }

        public void remove() {
            if (canRemove == false) {
                throw new IllegalStateException("Element cannot be removed");
            }
            collection.doRemoveIndex(--cursor);
            canRemove = false;
        }

        public boolean isModifiable() {
            return collection.isModifiable();
        }

        public boolean isResettable() {
            return true;
        }

        public void reset() {
            cursor = 0;
        }
    }

}
