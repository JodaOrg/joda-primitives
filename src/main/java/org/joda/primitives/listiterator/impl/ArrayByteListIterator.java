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
package org.joda.primitives.listiterator.impl;

import java.util.NoSuchElementException;

import org.joda.primitives.ByteUtils;
import org.joda.primitives.listiterator.ByteListIterator;

/**
 * An iterator over an array of <code>byte</code> values.
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
public class ArrayByteListIterator implements ByteListIterator {
    // This file is CODE GENERATED. Do not change manually.

    /** The array to iterate over */
    protected final byte[] iArray;
    /** Cursor position */
    protected int iCursor = 0;
    /** Last returned position */
    protected int iLast = -1;

    /**
     * Constructs an iterator over an <code>byte</code> array.
     * 
     * @param array  the array to iterate over, must not be null
     * @throws IllegalArgumentException if the array is null
     */
    public ArrayByteListIterator(byte[] array) {
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

    public byte nextByte() {
        if (hasNext() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        iLast = iCursor;
        return iArray[iCursor++];
    }

    public Byte next() {
        return ByteUtils.toObject(nextByte());
    }

    public boolean hasPrevious() {
        return (iCursor > 0);
    }

    public int previousIndex() {
        return iCursor - 1;
    }

    public byte previousByte() {
        if (hasPrevious() == false) {
            throw new NoSuchElementException("No more elements available");
        }
        iLast = --iCursor;
        return iArray[iCursor];
    }

    public Byte previous() {
        return ByteUtils.toObject(previousByte());
    }

    public void add(byte value) {
        throw new UnsupportedOperationException("ArrayByteListIterator does not support add");
    }

    public void add(Byte value) {
        throw new UnsupportedOperationException("ArrayByteListIterator does not support add");
    }

    public void remove() {
        throw new UnsupportedOperationException("ArrayByteListIterator does not support remove");
    }

    public void set(byte value) {
        if (iLast < 0) {
            throw new IllegalStateException("ArrayByteListIterator cannot be set until next is called");
        }
        iArray[iLast] = value;
    }

    public void set(Byte value) {
        set(ByteUtils.toPrimitive(value));
    }

    public void reset() {
        iCursor = 0;
        iLast = -1;
    }

}
