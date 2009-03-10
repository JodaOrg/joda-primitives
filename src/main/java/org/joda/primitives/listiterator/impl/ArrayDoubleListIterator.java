/*
 *  Copyright 2001-2009 Stephen Colebourne
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
package org.joda.primitives.listiterator.impl;

import java.util.NoSuchElementException;

import org.joda.primitives.DoubleUtils;
import org.joda.primitives.listiterator.DoubleListIterator;

/**
 * An iterator over an array of <code>double</code> values.
 * <p>
 * This class implements {@link java.util.ListIterator ListIterator} allowing
 * seamless integration with other APIs.
 * <p>
 * The iterator can be reset to the start if required.
 * <code>add()</code> and <code>remove()</code> are unsupported, but
 * <code>set()</code> is supported.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class ArrayDoubleListIterator implements DoubleListIterator {
    // This file is CODE GENERATED. Do not change manually.

    /** The array to iterate over */
    protected final double[] iArray;
    /** Cursor position */
    protected int iCursor = 0;
    /** Last returned position */
    protected int iLast = -1;

    /**
     * Constructs an iterator over an <code>double</code> array.
     * 
     * @param array  the array to iterate over, must not be null
     * @throws IllegalArgumentException if the array is null
     */
    public ArrayDoubleListIterator(double[] array) {
        super();
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        this.iArray = array;
    }

    //-----------------------------------------------------------------------
    public boolean isModifiable() {
        return true;
    }

    public boolean isResetable() {
        return true;
    }

    //-----------------------------------------------------------------------
    public boolean hasNext() {
        return (iCursor < iArray.length);
    }

    public int nextIndex() {
        return iCursor;
    }

    public double nextDouble() {
        if (hasNext() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        iLast = iCursor;
        return iArray[iCursor++];
    }

    public Object next() {
        return DoubleUtils.toObject(nextDouble());
    }

    public boolean hasPrevious() {
        return (iCursor > 0);
    }

    public int previousIndex() {
        return iCursor - 1;
    }

    public double previousDouble() {
        if (hasPrevious() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        iLast = --iCursor;
        return iArray[iCursor];
    }

    public Object previous() {
        return DoubleUtils.toObject(previousDouble());
    }

    public void add(double value) {
        throw new UnsupportedOperationException("ArrayDoubleListIterator does not support add");
    }

    public void add(Object value) {
        throw new UnsupportedOperationException("ArrayDoubleListIterator does not support add");
    }

    public void remove() {
        throw new UnsupportedOperationException("ArrayDoubleListIterator does not support remove");
    }

    public void set(double value) {
        if (iLast < 0) {
            throw new IllegalStateException("ArrayDoubleListIterator cannot be set until next is called");
        }
        iArray[iLast] = value;
    }

    public void set(Object value) {
        set(DoubleUtils.toPrimitive(value));
    }

    public void reset() {
        iCursor = 0;
        iLast = -1;
    }

}
