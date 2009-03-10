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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

import org.joda.primitives.ByteUtils;
import org.joda.primitives.collection.ByteCollection;
import org.joda.primitives.iterator.ByteIterator;

/**
 * Abstract base class for collections of primitive <code>byte</code> elements.
 * <p>
 * This class implements {@link java.util.Collection Collection} allowing
 * seamless integration with other APIs.
 * <p>
 * The <code>iterator</code> and <code>size</code> must be implemented by subclases.
 * To make the subclass modifiable, the <code>add(byte)</code> and
 * iterator <code>remove()</code> methods must also be implemented.
 * Subclasses may override other methods to increase efficiency.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractByteCollection
        extends AbstractPrimitiveCollectable
        implements ByteCollection {
    // This file is CODE GENERATED. Do not change manually.

    /**
     * Constructor.
     */
    protected AbstractByteCollection() {
        super();
    }
    
    // Mandatory operations
    //-----------------------------------------------------------------------
    /**
     * Checks whether this collection contains a specified primitive value.
     * <p>
     * This implementation uses <code>byteIterator()</code>.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(byte value) {
        for (ByteIterator it = byteIterator(); it.hasNext();) {
            if (it.nextByte() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this collection contains all of the values in the specified array.
     * If the specified array is empty, <code>true</code> is returned.
     * <p>
     * This implementation uses <code>contains(byte)</code>.
     *
     * @param values  the values to search for, null treated as empty array
     * @return <code>true</code> if all of the values are found
     */
    public boolean containsAll(byte[] values) {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (contains(values[i]) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if this collection contains all of the values in the specified collection.
     * If the specified collection is empty, <code>true</code> is returned.
     * <p>
     * This implementation uses <code>contains(byte)</code>.
     *
     * @param values  the values to search for, null treated as empty collection
     * @return <code>true</code> if all of the values are found
     */
    public boolean containsAll(ByteCollection values) {
        if (values != null) {
            for (ByteIterator it = values.byteIterator(); it.hasNext(); ) {
                if (contains(it.nextByte()) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if this collection contain all the values in the specified range.
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the result is <code>true</code>
     * as the range is equivalent to an empty collection.
     * <p>
     * This implementation uses <code>contains(byte)</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if the collection contains the entire range
     */
    public boolean containsAll(byte startInclusive, byte endInclusive) {
        if (startInclusive > endInclusive) {
            return true;
        }
        for (byte i = startInclusive; i <= endInclusive; i++) {
            if (contains(i) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if this collection contains any of the values in the specified array.
     * If the specified array is empty, <code>false</code> is returned.
     * <p>
     * This implementation uses <code>contains(byte)</code>.
     *
     * @param values  the values to search for, null treated as empty array
     * @return <code>true</code> if at least one of the values is found
     */
    public boolean containsAny(byte[] values) {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (contains(values[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if this collection contains any of the values in the specified collection.
     * If the specified collection is empty, <code>false</code> is returned.
     * <p>
     * This implementation uses <code>contains(byte)</code>.
     *
     * @param values  the values to search for, null treated as empty collection
     * @return <code>true</code> if at least one of the values is found
     */
    public boolean containsAny(ByteCollection values) {
        if (values != null) {
            for (ByteIterator it = values.byteIterator(); it.hasNext(); ) {
                if (contains(it.nextByte())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if this collection contain some of the values in the specified range.
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the result is <code>false</code>
     * as the range is equivalent to an empty collection.
     * <p>
     * This implementation uses <code>contains(byte)</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if the collection contains at least one of the range
     */
    public boolean containsAny(byte startInclusive, byte endInclusive) {
        if (startInclusive > endInclusive) {
            return false;
        }
        for (byte i = startInclusive; i <= endInclusive; i++) {
            if (contains(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the elements of this collection as an array.
     * <p>
     * This implementation uses <code>arrayCopy</code>.
     *
     * @return a new array containing a copy of the elements of this collection
     */
    public byte[] toByteArray() {
        if (size() == 0) {
            return ByteUtils.EMPTY_BYTE_ARRAY;
        }
        byte[] result = new byte[size()];
        arrayCopy(0, result, 0, size());
        return result;
    }

    /**
     * Copies the elements of this collection into an array at a specified position.
     * Previous values in the array are overwritten.
     * <p>
     * If the array specified is null a new array is created.
     * If the array specified is large enough, it will be modified.
     * If the array is not large enough, a new array will be created containing the
     * values from the specified array before the startIndex plus those from this collection.
     * <p>
     * This implementation uses <code>arrayCopy</code>.
     *
     * @param array  the array to add the elements to, null treated as empty array
     * @param startIndex  the position in the array to start setting elements
     * @return the array with the populated collection
     * @throws IndexOutOfBoundsException if the index is negative
     */
    public byte[] toByteArray(byte[] array, int startIndex) {
        if (startIndex < 0) {
            throw new IndexOutOfBoundsException("Start index must not be negative: " + startIndex);
        }
        byte[] result = null;
        if (array == null) {
            // create new
            result = new byte[startIndex + size()];
            
        } else if (array.length - startIndex - size() >= 0) {
            // room to fit data
            result = array;
            
        } else {
            // expand array
            result = new byte[startIndex + size()];
            System.arraycopy(array, 0, result, 0, startIndex);
        }
        arrayCopy(0, result, startIndex, size());
        return result;
    }

    // Optional operations
    //-----------------------------------------------------------------------
    /**
     * Clears the collection/map of all elements (optional operation).
     * <p>
     * The collection/map will have a zero size after this method completes.
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection/map cannot be cleared.
     * <p>
     * This implementation uses <code>byteIterator()</code>.
     *
     * @throws UnsupportedOperationException if method not supported by this collection
     */
    public void clear() {
        checkRemoveModifiable();
        for (ByteIterator it = byteIterator(); it.hasNext();) {
            it.nextByte();
            it.remove();
        }
    }

    /**
     * Adds a primitive value to this collection (optional operation).
     * <p>
     * This implementation throws UnsupportedOperationException.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean add(byte value) {
        throw new UnsupportedOperationException("Collection does not support add");
    }

    /**
     * Adds an array of primitive values to this collection (optional operation).
     * <p>
     * This implementation uses <code>add(byte)</code>.
     *
     * @param values  the values to add to this collection, null treated as empty array
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if a value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(byte[] values) {
        checkAddModifiable();
        boolean changed = false;
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                changed |= add(values[i]);
            }
        }
        return changed;
    }

    /**
     * Adds a collection of primitive values to this collection (optional operation).
     * <p>
     * This implementation uses <code>add(byte)</code>.
     *
     * @param values  the values to add to this collection, null treated as empty collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if a value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(ByteCollection values) {
        checkAddModifiable();
        boolean changed = false;
        if (values != null) {
            for (ByteIterator it = values.byteIterator(); it.hasNext(); ) {
                changed |= add(it.nextByte());
            }
        }
        return changed;
    }

    /**
     * Adds a range of primitive values to this collection (optional operation).
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the range is equivalent to an empty collection.
     * <p>
     * This implementation uses <code>add(byte)</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if a value is rejected by this set
     * @throws UnsupportedOperationException if not supported by this set
     */
    public boolean addAll(byte startInclusive, byte endInclusive) {
        checkAddModifiable();
        if (startInclusive > endInclusive) {
            return false;
        }
        boolean changed = false;
        for (byte i = startInclusive; i <= endInclusive; i++) {
            changed |= add(i);
        }
        return false;
    }

    /**
     * Removes the first occurrance of the specified primitive value from this collection
     * <p>
     * This implementation uses <code>byteIterator().remove()</code>.
     *
     * @param value  the value to remove
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeFirst(byte value) {
        checkRemoveModifiable();
        for (ByteIterator it = byteIterator(); it.hasNext(); ) {
            if (it.nextByte() == value) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all occurrances of the specified primitive value from this collection.
     * <p>
     * This implementation uses <code>byteIterator().remove()</code>.
     *
     * @param value  the value to remove
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(byte value) {
        checkRemoveModifiable();
        boolean changed = false;
        for (ByteIterator it = byteIterator(); it.hasNext(); ) {
            if (it.nextByte() == value) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Removes all occurences from this collection of each primitive in the specified array.
     * <p>
     * This implementation uses <code>byteIterator().remove()</code>.
     *
     * @param values  the values to remove from this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(byte[] values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values != null) {
            for (ByteIterator it = byteIterator(); it.hasNext(); ) {
                byte value = it.nextByte();
                for (int i = 0; i < values.length; i++) {
                    if (values[i] == value) {
                        it.remove();
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    /**
     * Removes all occurences from this collection of each primitive in the specified collection.
     * <p>
     * This implementation uses <code>byteIterator().remove()</code>.
     *
     * @param values  the values to remove from this collection, null treated as empty collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(ByteCollection values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values != null) {
            for (ByteIterator it = byteIterator(); it.hasNext(); ) {
                if (values.contains(it.nextByte())) {
                    it.remove();
                    changed = true;
                }
            }
        }
        return changed;
    }

    /**
     * Removes all occurences of a range of primitive values from this collection.
     * <p>
     * The range is defined to be inclusive of the start and end.
     * The elements removed are greater than or equal to the start and
     * less than or equal to the end. Thus if the start is greater than the
     * end then no elements are removed.
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * set cannot be changed.
     * <p>
     * This implementation uses <code>byteIterator().remove()</code>.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(byte startInclusive, byte endInclusive) {
        checkRemoveModifiable();
        if (startInclusive > endInclusive) {
            return false;
        }
        boolean changed = false;
        for (ByteIterator it = byteIterator(); it.hasNext(); ) {
            byte value = it.nextByte();
            if (value >= startInclusive && value <= endInclusive) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Retains each element of this collection that is present in the specified array
     * removing all other values.
     * <p>
     * This implementation uses <code>byteIterator().remove()</code>.
     *
     * @param values  the values to remove from this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(byte[] values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values == null || values.length == 0) {
            changed = !isEmpty();
            clear();
        } else {
            for (ByteIterator it = byteIterator(); it.hasNext(); ) {
                byte next = it.nextByte();
                boolean match = false;
                for (int i = 0; i < values.length; i++) {
                    if (values[i] == next) {
                        match = true;
                        break;
                    }
                }
                if (match == false) {
                    it.remove();
                    changed = true;
                }
            }
        }
        return changed;
    }

    /**
     * Retains each element of this collection that is present in the specified collection
     * removing all other values.
     * <p>
     * This implementation uses <code>byteIterator().remove()</code>.
     *
     * @param values  the values to retain in this collection, null treated as empty collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(ByteCollection values) {
        checkRemoveModifiable();
        boolean changed = false;
        if (values == null || values.isEmpty()) {
            changed = !isEmpty();
            clear();
        } else {
            for (ByteIterator it = byteIterator(); it.hasNext(); ) {
                if (values.contains(it.nextByte()) == false) {
                    it.remove();
                    changed = true;
                }
            }
        }
        return changed;
    }

    /**
     * Retains all occurences of a range of primitive values within this collection
     * removing all values outside the range (optional operation).
     * <p>
     * The range is defined to be inclusive of the start and end.
     * If the start is greater than the end then the range is equivalent to an empty collection.
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * set cannot be changed.
     *
     * @param startInclusive  the inclusive range start value
     * @param endInclusive  the inclusive range end value
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(byte startInclusive, byte endInclusive) {
        checkRemoveModifiable();
        boolean changed = false;
        for (ByteIterator it = byteIterator(); it.hasNext(); ) {
            byte value = it.nextByte();
            if (value < startInclusive || value > endInclusive) {
                it.remove();
                changed = true;
            }
        }
        return changed;
    }

    // Collection integration
    //-----------------------------------------------------------------------
    /**
     * Gets an iterator over this collection.
     * <p>
     * This implementation uses <code>byteIterator()</code>.
     *
     * @return an iterator over this collection
     */
    public Iterator iterator() {
        return byteIterator();
    }

    /**
     * Checks whether this collection contains a specified <code>Byte</code> value.
     * <p>
     * This implementation uses <code>contains(byte)</code>.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(Object value) {
        return contains(toPrimitive(value));
    }

    /**
     * Checks if the collection contains all of the primitive values.
     * <p>
     * This implementation uses <code>containsAll(byte[])</code>.
     *
     * @param coll  the collection of values to search for
     * @return <code>true</code> if all the values are found
     */
    public boolean containsAll(Collection coll) {
        if (coll == this || coll.size() == 0) {
            return true;
        }
        if (size() == 0) {
            return false;
        }
        return containsAll(toPrimitiveArray(coll));
    }

    /**
     * Checks if the collection contains any of the primitive values in the array.
     * If the specified collection is empty, <code>false</code> is returned.
     * <p>
     * This implementation uses <code>containsAny(byte[])</code>.
     *
     * @param coll  the collection of values to search for
     * @return <code>true</code> if at least one of the values is found
     */
    public boolean containsAny(Collection coll) {
        if (size() == 0 || coll.size() == 0) {
            return false;
        }
        if (coll == this) {
            return true;
        }
        return containsAny(toPrimitiveArray(coll));
    }

    /**
     * Gets the collection as an array of <code>Byte</code>.
     * 
     * @return an array of <code>Byte</code>
     */
    public Object[] toArray() {
        Object[] result = new Byte[size()];
        ByteIterator it = byteIterator();
        for (int i = 0; it.hasNext(); i++) {
            result[i] = it.next();
        }
        return result;
    }

    /**
     * Gets the collection as an array, using the array provided.
     * 
     * @param array  the array to populate
     * @return an array of <code>Byte</code>
     */
    public Object[] toArray(Object[] array) {
        int size = size();
        if (array.length < size) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), size);
        }

        Iterator it = iterator();
        for (int i = 0; i < size; i++) {
            array[i] = it.next();
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    /**
     * Adds the <code>Byte</code> value to this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>add(byte)</code>.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean add(Object value) {
        checkAddModifiable();
        return add(toPrimitive(value));
    }

    /**
     * Adds a collection of <code>Byte</code> values to this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>addAll(byte[])</code>.
     *
     * @param coll  the values to add to this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws ClassCastException if any object is not <code>Byte</code>
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(Collection coll) {
        checkAddModifiable();
        return addAll(toPrimitiveArray(coll));
    }

    /**
     * Removes the first occurrance of the specified <code>Byte</code> value from
     * this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be removed from.
     * <p>
     * This implementation uses <code>removeFirst(byte)</code>.
     *
     * @param value  the value to remove
     * @return <code>true</code> if this collection was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean remove(Object value) {
        checkRemoveModifiable();
        return removeFirst(toPrimitive(value));
    }

    /**
     * Removes each of a collection of <code>Byte</code> values from this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>removeAll(byte[])</code>.
     *
     * @param coll  the values to remove from this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeAll(Collection coll) {
        checkRemoveModifiable();
        if (coll == this) {
            int size = size();
            clear();
            return (size() != size);
        }
        return removeAll(toPrimitiveArray(coll));
    }

    /**
     * Retains each of a collection of <code>Byte</code> values, removing other
     * values (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     * <p>
     * This implementation uses <code>retainAll(byte[])</code>.
     *
     * @param coll  the values to retain in this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean retainAll(Collection coll) {
        checkRemoveModifiable();
        if (coll == this) {
            return false;
        }
        return retainAll(toPrimitiveArray(coll));
    }

    // Basics
    //-----------------------------------------------------------------------
    /**
     * Gets a string representing this collection.
     * <p>
     * The format used is as per <code>Collection</code>.
     * 
     * @return collection as a String
     */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("[");

        ByteIterator it = byteIterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            buf.append(it.nextByte());
            hasNext = it.hasNext();
            if (hasNext) {
                buf.append(", ");
            }
        }

        buf.append("]");
        return buf.toString();
    }
    
    // Internals
    //-----------------------------------------------------------------------
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
        ByteIterator it = byteIterator();
        for (int i = 0; it.hasNext() && i < size; i++) {
            dest[destIndex + i] = it.nextByte();
        }
    }

    /**
     * Are the add methods supported.
     * <p>
     * This implementation returns false.
     *
     * @return true if supported
     */
    protected boolean isAddModifiable() {
        return false;
    }

    /**
     * Are the remove methods supported.
     * <p>
     * This implementation returns false.
     *
     * @return true if supported
     */
    protected boolean isRemoveModifiable() {
        return false;
    }

    /**
     * Is the collection modifiable in any way.
     *
     * @return true if supported
     */
    public boolean isModifiable() {
        return isAddModifiable() || isRemoveModifiable();
    }

    /**
     * Check whether add is suported and throw an exception.
     */
    protected void checkAddModifiable() {
        if (isAddModifiable() == false) {
            throw new UnsupportedOperationException("Collection does not support add");
        }
    }

    /**
     * Check whether remove is suported and throw an exception.
     */
    protected void checkRemoveModifiable() {
        if (isRemoveModifiable() == false) {
            throw new UnsupportedOperationException("Collection does not support remove");
        }
    }

    /**
     * Wraps an <code>byte</code> with an Object wrapper.
     * 
     * @param value  the primitive value
     * @return the Object wrapper
     */
    protected Byte toObject(byte value) {
        return ByteUtils.toObject(value);
    }

    /**
     * Checks if the object can be converted to a primitive successfully.
     * <p>
     * This implementation only allows non-null Byte objects.
     * 
     * @param value  the Object wrapper
     * @return true if a primitive value can be successfully extracted
     */
    protected boolean isToPrimitivePossible(Object value) {
        return (value instanceof Byte);
    }

    /**
     * Unwraps the <code>Byte</code> to retrieve the primitive <code>byte</code>.
     * <p>
     * This implementation only allows non-null Byte objects.
     * 
     * @param value  the Object to convert to a primitive
     * @return the primitive value
     * @throws NullPointerException if the value is null and this is unacceptable
     * @throws ClassCastException if the object is of an unsuitable type
     */
    protected byte toPrimitive(Object value) {
        return ByteUtils.toPrimitive(value);
    }

    /**
     * Unwraps a <code>Collection</code> to retrieve the primitive <code>byte</code>.
     * <p>
     * This implementation only allows non-null Byte objects.
     * 
     * @param coll  the Collection to convert to primitives
     * @return the primitive value
     * @throws NullPointerException if the value is null and this is unacceptable
     * @throws ClassCastException if any object is of an unsuitable type
     */
    protected byte[] toPrimitiveArray(Collection coll) {
        return ByteUtils.toPrimitiveArray(coll);
    }

}
