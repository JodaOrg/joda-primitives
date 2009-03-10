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
package org.joda.primitives.list.impl;

import java.util.Collection;

import org.joda.primitives.BooleanUtils;

/**
 * Array based implementation of <code>BooleanList</code> for
 * primitive <code>int</code> elements.
 * <p>
 * This class implements {@link java.util.List List} allowing
 * seamless integration with other APIs.
 * <p>
 * Add, Remove, Set and Clear are supported.
 *
 * @author Stephen Colebourne
 * @author Rodney Waldhoff
 * @version CODE GENERATED
 * @since 1.0
 */
public class ArrayBooleanList extends AbstractBooleanList implements Cloneable {
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
    public ArrayBooleanList() {
        super();
        iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
    }

    /**
     * Constructor that defines an initial size for the internal storage array.
     * 
     * @param initialSize  the initial size of the internal array, negative treated as zero
     */
    public ArrayBooleanList(int initialSize) {
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
    public ArrayBooleanList(boolean[] values) {
        super();
        if (values == null) {
            iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
        } else {
            iData = (boolean[]) values.clone();
            iSize = values.length;
        }
    }

    /**
     * Constructor that copies the specified values.
     * 
     * @param coll  a collection of values to copy, null treated as zero size collection
     */
    public ArrayBooleanList(Collection coll) {
        super();
        if (coll == null) {
            iData = BooleanUtils.EMPTY_BOOLEAN_ARRAY;
        } else if (coll instanceof ArrayBooleanList) {
            ArrayBooleanList c = (ArrayBooleanList) coll;
            this.iData = new boolean[c.iSize];
            System.arraycopy(c.iData, 0, this.iData, 0, c.iSize);
            iSize = c.iSize;
        } else {
            iData = toPrimitiveArray(coll);
            iSize = coll.size();
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
     * Gets the primitive value at the specified index.
     *
     * @param index  the index to get from
     * @return value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public boolean getBoolean(int index) {
        checkIndexExists(index);
        return iData[index];
    }

    /**
     * Adds a primitive value to this collection.
     *
     * @param index  the index to insert at
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public boolean add(int index, boolean value) {
        checkAddModifiable();
        checkIndex(index);
        ensureCapacity(iSize + 1);
        System.arraycopy(iData, index, iData, index + 1, iSize - index);
        iData[index] = value;
        iSize++;
        return true;
    }

    /**
     * Removes a primitive value by index from the list.
     *
     * @param index  the index to remove from
     * @return the primitive value previously at this index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public boolean removeBooleanAt(int index) {
        checkRemoveModifiable();
        checkIndexExists(index);
        boolean result = iData[index];
        System.arraycopy(iData, index + 1, iData, index, iSize - 1 - index);
        iSize--;
        return result;
    }

    /**
     * Sets the primitive value at a specified index.
     *
     * @param index  the index to set
     * @param value  the value to store
     * @return the previous value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public boolean set(int index, boolean value) {
        checkSetModifiable();
        checkIndexExists(index);
        boolean result = iData[index];
        iData[index] = value;
        return result;
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
     * Clears the collection/map of all elements.
     * <p>
     * This implementation resets the size, but does not reduce the internal storage array.
     * <p>
     * The collection/map will have a zero size after this method completes.
     */
    public void clear() {
        iSize = 0;
    }

    /**
     * Checks whether this collection contains a specified primitive value.
     * <p>
     * This implementation accesses the internal storage array directly.
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
     * Adds an array of primitive values to this collection at a specified index.
     *
     * @param index  the index to add at
     * @param values  the values to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public boolean addAll(int index, boolean[] values) {
        checkAddModifiable();
        checkIndex(index);
        if (values == null || values.length == 0) {
            return false;
        }
        int len = values.length;
        ensureCapacity(iSize + len);
        System.arraycopy(iData, index, iData, index + len, iSize - index);
        System.arraycopy(values, 0, iData, index, len);
        iSize += len;
        return true;
    }

    //-----------------------------------------------------------------------
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
     * Are the remove methods supported.
     *
     * @return <code>true</code>
     */
    protected boolean isSetModifiable() {
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
     * Clone implementation that calls Object clone().
     * 
     * @return the clone
     */
    public Object clone() {
        ArrayBooleanList cloned = (ArrayBooleanList) super.clone();
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
     * Ensures that the internal storage array has at least the specified size.
     * 
     * @param capacity  the amount to expand to
     */
    protected void ensureCapacity(int capacity) {
        int len = iData.length;
        if (capacity <= len) {
            return;
        }
        int newLen = len * GROWTH_FACTOR_MULTIPLIER / GROWTH_FACTOR_DIVISOR;
        if (newLen < capacity) {
            newLen = capacity;
        }
        if (newLen < MIN_GROWTH_SIZE) {
            newLen = MIN_GROWTH_SIZE;
        }
        boolean[] newArray = new boolean[newLen];
        System.arraycopy(iData, 0, newArray, 0, len);
        iData = newArray;
    }

}
    