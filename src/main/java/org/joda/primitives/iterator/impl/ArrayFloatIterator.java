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
package org.joda.primitives.iterator.impl;

import java.util.NoSuchElementException;

import org.joda.primitives.FloatUtils;
import org.joda.primitives.iterator.FloatIterator;

/**
 * An iterator over an array of <code>float</code> values.
 * <p>
 * This class implements {@link java.util.Iterator Iterator} allowing
 * seamless integration with other APIs.
 * <p>
 * The iterator can be reset to the start if required.
 * It is unmodifiable and <code>remove()</code> is unsupported.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class ArrayFloatIterator implements FloatIterator {
    // This file is CODE GENERATED. Do not change manually.

    /** The array to iterate over */
    protected final float[] iArray;
    /** Cursor position */
    protected int iCursor = 0;

    /**
     * Constructs an iterator over an <code>float</code> array.
     * 
     * @param array  the array to iterate over, must not be null
     * @throws IllegalArgumentException if the array is null
     */
    public ArrayFloatIterator(float[] array) {
        super();
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        this.iArray = array;
    }

    //-----------------------------------------------------------------------
    public boolean isModifiable() {
        return false;
    }

    public boolean isResetable() {
        return true;
    }

    //-----------------------------------------------------------------------
    public boolean hasNext() {
        return (iCursor < iArray.length);
    }

    public float nextFloat() {
        if (hasNext() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        return iArray[iCursor++];
    }

    public Object next() {
        return FloatUtils.toObject(nextFloat());
    }

    public void remove() {
        throw new UnsupportedOperationException("ArrayFloatIterator does not support remove");
    }

    public void reset() {
        iCursor = 0;
    }

}
