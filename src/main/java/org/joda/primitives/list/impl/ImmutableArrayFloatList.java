/*
 *  Copyright 2001-present Stephen Colebourne
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

import org.joda.primitives.FloatUtils;

/**
 * Immutable array-based implementation of <code>FloatList</code> for
 * primitive <code>int</code> elements.
 * <p>
 * This class implements {@link java.util.List List} allowing
 * seamless integration with other APIs.
 * <p>
 * Add, Remove, Set and Clear are not supported as this class is immutable.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public final class ImmutableArrayFloatList extends AbstractFloatList {
    // This file is CODE GENERATED. Do not change manually.

    /** The empty singleton. */
    private static final ImmutableArrayFloatList EMPTY = new ImmutableArrayFloatList(FloatUtils.EMPTY_FLOAT_ARRAY);

    /** The array of elements. */
    private float[] data;

    /**
     * Gets a list that is empty.
     * 
     * @return the empty list, not null
     */
    public static ImmutableArrayFloatList empty() {
        return EMPTY;
    }

    /**
     * Creates a list copying the specified array.
     * 
     * @param values  an array of values to copy, null treated as zero size array
     * @return the created list, not null
     */
    public static ImmutableArrayFloatList copyOf(float[] values) {
        if (values == null) {
            return EMPTY;
        } else {
            return new ImmutableArrayFloatList(values.clone());
        }
    }

    /**
     * Creates a list copying the values from the specified collection.
     * <p>
     * If the collection is an instance of this class, then it is simply returned.
     * 
     * @param coll  a collection of values to copy, null treated as zero size collection
     * @return the created list, not null
     */
    public static ImmutableArrayFloatList copyOf(Collection<Float> coll) {
        if (coll == null) {
            return EMPTY;
        } else if (coll instanceof ImmutableArrayFloatList) {
            return (ImmutableArrayFloatList) coll;
        } else {
            return new ImmutableArrayFloatList(FloatUtils.toPrimitiveArray(coll));
        }
    }

    /**
     * Constructor that copies the specified values.
     * 
     * @param values  the array to assign
     */
    private ImmutableArrayFloatList(float[] values) {
        super();
        data = values;
    }

    // Implementation
    //-----------------------------------------------------------------------
    /**
     * Gets the current size of the collection.
     * 
     * @return the current size
     */
    public int size() {
        return data.length;
    }

    /**
     * Gets the primitive value at the specified index.
     *
     * @param index  the index to get from
     * @return value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public float getFloat(int index) {
        checkIndexExists(index);
        return data[index];
    }

    // Overrides
    //-----------------------------------------------------------------------
    /**
     * Checks whether this collection contains a specified primitive value.
     * <p>
     * This implementation accesses the internal storage array directly.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(float value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------
    /**
     * Clone implementation that returns {@code this}.
     * 
     * @return {@code this}
     */
    public Object clone() {
        return this;
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
    protected void arrayCopy(int fromIndex, float[] dest, int destIndex, int size) {
        System.arraycopy(data, fromIndex, dest, destIndex, size);
    }

}
