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
package org.joda.primitives.list.impl;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.joda.primitives.ShortUtils;
import org.joda.primitives.collection.impl.AbstractShortCollection;
import org.joda.primitives.iterator.ShortIterator;
import org.joda.primitives.list.ShortList;
import org.joda.primitives.listiterator.ShortListIterator;

/**
 * Abstract base class for lists of primitive <code>short</code> elements.
 * <p>
 * This class implements {@link java.util.Collection Collection} allowing
 * seamless integration with other APIs.
 * <p>
 * The <code>get(int)</code> and <code>size()</code> methods must be
 * implemented by subclases.
 * To make the subclass modifiable, the <code>add(int, short)</code>,
 * <code>removeIndex(int)</code> and set(int, short) must also be implemented.
 * Subclasses may override other methods to increase efficiency.
 *
 * @author Stephen Colebourne
 * @author Rodney Waldhoff
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractShortList extends AbstractShortCollection implements ShortList {
    // This file is CODE GENERATED. Do not change manually.

    /**
     * Constructor.
     */
    protected AbstractShortList() {
        super();
    }

    // ShortList methods
    //-----------------------------------------------------------------------
    /**
     * Gets an iterator over this list.
     *
     * @return an iterator over this list
     */
    public ShortIterator shortIterator() {
        return shortListIterator(0);
    }

    /**
     * Gets a list iterator over this list.
     * <p>
     * This implementation uses <code>shortListIterator(int)</code>.
     *
     * @return an iterator over this list
     */
    public ShortListIterator shortListIterator() {
        return shortListIterator(0);
    }

    /**
     * Gets a list iterator over this list from a start index.
     *
     * @param index  the index to start from
     * @return an iterator over this list
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public ShortListIterator shortListIterator(int index) {
        checkIndex(index);
        return new PListIterator(this, index);
    }

    /**
     * Gets the first primitive value.
     *
     * @return value at index zero
     * @throws IndexOutOfBoundsException if the size is zero
     */
    public short firstShort() {
        return getShort(0);
    }

    /**
     * Gets the last primitive value.
     *
     * @return value at index <code>size() - 1</code>
     * @throws IndexOutOfBoundsException if the size is zero
     */
    public short lastShort() {
        return getShort(size() - 1);
    }

    /**
     * Checks whether this collection contains a specified primitive value.
     * <p>
     * This implementation uses <code>getShort(int)</code>.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(short value) {
        for (int i = 0, isize = size(); i < isize; i++) {
            if (getShort(i) == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the first index of the specified primitive value.
     * <p>
     * This implementation uses <code>indexof(short, int)</code>.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int indexOf(short value) {
        return indexOf(value, 0);
    }

    /**
     * Gets the first index of the specified primitive value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that a
     * negative index is treated as zero, and an index greater than the list
     * size will simply return <code>-1</code>.
     * <p>
     * This implementation uses <code>get(int)</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int indexOf(short value, int fromIndexInclusive) {
        if (fromIndexInclusive < 0) {
            fromIndexInclusive = 0;
        }
        for (int i = fromIndexInclusive, isize = size(); i < isize; i++) {
            if (getShort(i) == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets the last index of the specified primitive value.
     * <p>
     * This implementation uses <code>lastIndexof(short, int)</code>.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int lastIndexOf(short value) {
        return lastIndexOf(value, size());
    }

    /**
     * Gets the first index of the specified primitive value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that an
     * index greater than the list size will start searching at the list size,
     * and a negative index simply returns <code>-1</code>.
     * <p>
     * This implementation uses <code>get(int)</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int lastIndexOf(short value, int fromIndexInclusive) {
        if (fromIndexInclusive >= size()) {
            fromIndexInclusive = size() - 1;
        }
        for (int i = fromIndexInclusive; i >= 0; i--) {
            if (getShort(i) == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets a range of elements as an array.
     *
     * @param fromIndexInclusive  the index to start from, inclusive
     * @param toIndexExclusive  the index to end at, exclusive
     * @return a new array containing a copy of the range of elements
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    public short[] toShortArray(int fromIndexInclusive, int toIndexExclusive) {
        checkRange(fromIndexInclusive, toIndexExclusive);
        
        if (fromIndexInclusive == toIndexExclusive) {
            return ShortUtils.EMPTY_SHORT_ARRAY;
        }
        int size = toIndexExclusive - fromIndexInclusive;
        short[] result = new short[size];
        arrayCopy(fromIndexInclusive, result, 0, size);
        return result;
    }

    /**
     * Gets a range view of part of this list.
     * <p>
     * This method allows operations to work on a range within the greater list.
     * Changes made to the either object will affect the other.
     *
     * @param fromIndexInclusive  the index to start from, inclusive
     * @param toIndexExclusive  the index to end at, exclusive
     * @return a new ShortList for the subList
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    public ShortList subShortList(int fromIndexInclusive, int toIndexExclusive) {
        return null; // TODO
    }

    /**
     * Clears the listof all elements (optional operation).
     * <p>
     * This implementation uses <code>removeRange(int, int)</code>.
     *
     * @throws UnsupportedOperationException if method not supported by this collection
     */
    public void clear() {
        removeRange(0, size());
    }

    /**
     * Adds a primitive value to this collection (optional operation).
     * <p>
     * This implementation uses <code>add(int, short)</code>.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean add(short value) {
        checkAddModifiable();
        return add(size(), value);
    }

    /**
     * Adds a primitive value to this list at an index (optional operation).
     * <p>
     * This implementation throws UnsupportedOperationException.
     *
     * @param index  the index to add at
     * @param value  the value to add to this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean add(int index, short value) {
        throw new UnsupportedOperationException("List does not support add");
    }

    /**
     * Adds an array of primitive values to this list at an index (optional operation).
     * <p>
     * This implementation uses <code>addAll(int, short)</code>.
     *
     * @param values  the values to add to this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(short[] values) {
        checkAddModifiable();
        return addAll(size(), values);
    }

    /**
     * Adds an array of primitive values to this list at an index (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     *
     * @param index  the index to add at
     * @param values  the values to add to this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(int index, short[] values) {
        checkAddModifiable();
        checkIndex(index);
        boolean changed = false;
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                changed |= add(index + i, values[i]);
            }
        }
        return changed;
    }

    /**
     * Removes a primitive value by index from the list (optional operation).
     * <p>
     * This implementation throws UnsupportedOperationException.
     *
     * @param index  the index to remove from
     * @return the primitive value previously at this index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public short removeShortAt(int index) {
        throw new UnsupportedOperationException("List does not support remove");
    }

    /**
     * Removes the first occurance of a primitive value from the list (optional operation).
     * <p>
     * This implementation uses <code>get(int)</code> and <code>removeShortAt(int)</code>.
     *
     * @param value  the value to remove
     * @return the primitive value previously at this index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean removeShort(short value) {
        checkRemoveModifiable();
        for (int i = 0, isize = size(); i < isize; i++) {
            if (getShort(i) == value) {
                removeShortAt(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a range of values from the list (optional operation).
     * <p>
     * This implementation uses <code>removeShortAt(int)</code>.
     *
     * @param fromIndexInclusive  the start of the range to remove, inclusive
     * @param toIndexExclusive  the end of the range to remove, exclusive
     * @return <code>true</code> if the collection was modified
     * @throws UnsupportedOperationException if remove is not supported
     */
    public boolean removeRange(int fromIndexInclusive, int toIndexExclusive) {
        checkRemoveModifiable();
        checkRange(fromIndexInclusive, toIndexExclusive);
        if (fromIndexInclusive == toIndexExclusive) {
            return false;
        }
        for (int i = size() - 1; i >= 0; i--) {
            removeShortAt(i);
        }
        return true;
    }

    /**
     * Sets the primitive value at a specified index.
     * <p>
     * This implementation throws UnsupportedOperationException.
     *
     * @param index  the index to set
     * @param value  the value to store
     * @return the previous value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public short set(int index, short value) {
        throw new UnsupportedOperationException("List does not support set");
    }

    // List methods
    //-----------------------------------------------------------------------
    /**
     * Gets the <code>Short</code> value at the specified index.
     *
     * @param index  the index to get from
     * @return value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public Short get(int index) {
        return ShortUtils.toObject(getShort(index));
    }

    /**
     * Gets a list iterator over this list.
     *
     * @return an iterator over this list
     */
    public ListIterator<Short> listIterator() {
        return shortListIterator();
    }

    /**
     * Gets a list iterator over this list from a start index.
     *
     * @param index  the index to start from
     * @return an iterator over this list
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public ListIterator<Short> listIterator(int index) {
        return shortListIterator(index);
    }

    /**
     * Gets the first <code>Short</code> value.
     *
     * @return value at index zero or null if the size is zero
     */
    public Short first() {
        if (size() == 0) {
            return null;
        }
        return get(0);
    }

    /**
     * Gets the last <code>Short</code> value.
     *
     * @return value at index <code>size() - 1</code> or null if the size is zero
     */
    public Short last() {
        if (size() == 0) {
            return null;
        }
        return get(size() - 1);
    }

    /**
     * Gets the first index of the specified <code>Short</code> value.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Short</code>
     */
    public int indexOf(Object value) {
        return indexOf(ShortUtils.toPrimitive(value));
    }

    /**
     * Gets the first index of the specified <code>Short</code> value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that a
     * negative index is treated as zero, and an index greater than the list
     * size will simply return <code>-1</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Short</code>
     */
    public int indexOf(Object value, int fromIndexInclusive) {
        return indexOf(ShortUtils.toPrimitive(value), fromIndexInclusive);
    }

    /**
     * Gets the last index of the specified <code>Short</code> value.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Short</code>
     */
    public int lastIndexOf(Object value) {
        return lastIndexOf(ShortUtils.toPrimitive(value));
    }

    /**
     * Gets the first index of the specified <code>Short</code> value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that an
     * index greater than the list size will start searching at the list size,
     * and a negative index simply returns <code>-1</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Short</code>
     */
    public int lastIndexOf(Object value, int fromIndexInclusive) {
        return lastIndexOf(ShortUtils.toPrimitive(value), fromIndexInclusive);
    }

    /**
     * Adds the <code>Short</code> value to this collection (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean add(Short value) {
        checkAddModifiable();
        return add(size(), ShortUtils.toPrimitive(value));
    }

    /**
     * Adds the <code>Short</code> value to this list at an index (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     *
     * @param index  the index to add at
     * @param value  the value to add to this collection
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws ClassCastException if the object is not <code>Short</code>
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public void add(int index, Short value) {
        checkAddModifiable();
        checkIndex(index);
        add(index, ShortUtils.toPrimitive(value));
    }

    /**
     * Adds an array of <code>Short</code> values to this list at an index (optional operation).
     * <p>
     * This method is optional, throwing an UnsupportedOperationException if the
     * collection cannot be added to.
     *
     * @param index  the index to add at
     * @param coll  the values to add to this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws ClassCastException if any object is not <code>Short</code>
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public boolean addAll(int index, Collection<? extends Short> coll) {
        checkAddModifiable();
        checkIndex(index);
        return addAll(index, ShortUtils.toPrimitiveArray(coll));
    }

    /**
     * Removes a primitive value by index from the list (optional operation).
     * <p>
     * This implementation uses <code>removeShortAt(int)</code>.
     *
     * @deprecated This method should only be used when working with List and
     *  not when working with ShortList - use <code>removeShortAt(int)</code>
     * @param index  the index to remove from
     * @return the primitive value previously at this index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public Short remove(int index) {
        checkRemoveModifiable();
        return ShortUtils.toObject(removeShortAt(index));
    }

    /**
     * Sets the <code>Short</code> value at a specified index.
     * <p>
     * This implementation uses <code>set(int, short)</code>.
     *
     * @param index  the index to set
     * @param value  the value to store
     * @return the previous value at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws IllegalArgumentException if value is rejected by this collection
     * @throws UnsupportedOperationException if not supported by this collection
     */
    public Short set(int index, Short value) {
        checkSetModifiable();
        checkIndexExists(index);
        return ShortUtils.toObject(set(index, ShortUtils.toPrimitive(value)));
    }

    /**
     * Gets a range view of part of this list.
     * <p>
     * This method allows operations to work on a range within the greater list.
     * Changes made to the either object will affect the other.
     * <p>
     * This implementation uses <code>subShortList(int, int)</code>.
     *
     * @param fromIndexInclusive  the index to start from, inclusive
     * @param toIndexExclusive  the index to end at, exclusive
     * @return a new ShortList for the subList
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    public List<Short> subList(int fromIndexInclusive, int toIndexExclusive) {
        return subShortList(fromIndexInclusive, toIndexExclusive);
    }

    //-----------------------------------------------------------------------
    /**
     * Compares this list to another as per the contract of <code>List</code>.
     *
     * @param obj  the object to compare to
     * @return <code>true</code> if the lists are equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ShortList) {
            ShortList other = (ShortList) obj;
            if (size() != other.size()) {
                return false;
            }
            ShortIterator it1 = shortListIterator();
            ShortIterator it2 = other.shortListIterator();
            while (it1.hasNext() && it2.hasNext()) {
                if (it1.nextShort() != it2.nextShort()) {
                    return false;
                }
            }
            return true;
        } else if (obj instanceof List<?>) {
            List<?> other = (List<?>) obj;
            if (size() != other.size()) {
                return false;
            }
            ShortIterator it1 = shortListIterator();
            Iterator<?> it2 = other.listIterator();
            while (it1.hasNext() && it2.hasNext()) {
                Object next = it2.next();
                if (isToPrimitivePossible(next) == false) {
                    return false;
                }
                if (it1.nextShort() != toPrimitive(next)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the hashCode of this list as per the contract of <code>List</code>.
     *
     * @return the hash code for this list
     */
    public int hashCode() {
        int hashCode = 1;
        Iterator<Short> it = iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

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
    protected void arrayCopy(int fromIndex, short[] dest, int destIndex, int size) {
        for (int i = 0; i < size; i++) {
            dest[i + destIndex] = getShort(i + fromIndex);
        }
    }

    /**
     * Are the set methods supported.
     * <p>
     * This implementation returns false.
     *
     * @return true if supported
     */
    protected boolean isSetModifiable() {
        return false;
    }

    /**
     * Is the collection modifiable in any way.
     *
     * @return true if supported
     */
    public boolean isModifiable() {
        return isAddModifiable() || isRemoveModifiable() || isSetModifiable();
    }

    /**
     * Check whether add is suported and throw an exception.
     */
    protected void checkSetModifiable() {
        if (isSetModifiable() == false) {
            throw new UnsupportedOperationException("Collection does not support set");
        }
    }

    /**
     * Checks whether an index is valid or not.
     * 
     * @param index  the index to check
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    protected void checkIndexExists(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(
                "Index less than zero: " + index + " < 0");
        }
        if (index >= size()) {
            throw new ArrayIndexOutOfBoundsException(
                "Index greater than/equal to size(): " + index + " >= " + size());
        }
    }

    /**
     * Checks whether an index is valid or not.
     * 
     * @param index  the index to check
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    protected void checkIndex(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(
                "Index less than zero: " + index + " < 0");
        }
        if (index > size()) {
            throw new ArrayIndexOutOfBoundsException(
                "Index greater than size(): " + index + " > " + size());
        }
    }

    /**
     * Checks whether a range is valid or not.
     * 
     * @param fromIndexInclusive  the index to start from, inclusive
     * @param toIndexExclusive  the index to end at, exclusive
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    protected void checkRange(int fromIndexInclusive, int toIndexExclusive) {
        if (fromIndexInclusive < 0) {
            throw new ArrayIndexOutOfBoundsException(
                "From index less than zero: " + fromIndexInclusive + " < 0");
        }
        if (toIndexExclusive > size()) {
            throw new ArrayIndexOutOfBoundsException(
                "To index greater than size(): " + toIndexExclusive + " > " + size());
        }
        if (fromIndexInclusive > toIndexExclusive) {
            throw new ArrayIndexOutOfBoundsException(
                "To index greater than from index: " + fromIndexInclusive + " > " + toIndexExclusive);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * List iterator.
     */
    protected static class PListIterator implements ShortListIterator {

        private final AbstractShortList iList;
        private final int iStart;
        private int iCursor = 0;
        private int iLastIndex = -1;
        
        protected PListIterator(AbstractShortList list, int start) {
            super();
            this.iList = list;
            this.iStart = start;
            this.iCursor = start;
        }

        //-----------------------------------------------------------------------
        public boolean hasNext() {
            return (iCursor < iList.size());
        }

        public short nextShort() {
            if (hasNext() == false) {
                throw new NoSuchElementException("No more elements available");
            }
            iLastIndex = iCursor;
            return iList.getShort(iCursor++);
        }

        public Short next() {
            return iList.toObject(nextShort());
        }

        public int nextIndex() {
            return iCursor;
        }

        //-----------------------------------------------------------------------
        public boolean hasPrevious() {
            return (iCursor > 0);
        }

        public short previousShort() {
            if (hasPrevious() == false) {
                throw new NoSuchElementException("No more elements available");
            }
            iLastIndex = --iCursor;
            return iList.getShort(iCursor);
        }

        public Short previous() {
            return iList.toObject(previousShort());
        }

        public int previousIndex() {
            return iCursor - 1;
        }

        //-----------------------------------------------------------------------
        public void remove() {
            iList.checkRemoveModifiable();
            if (iLastIndex == -1) {
                throw new IllegalStateException("Element cannot be removed");
            }
            iList.removeShortAt(iLastIndex);
            iCursor = iLastIndex;
            iLastIndex = -1;
        }

        public void add(short value) {
            iList.checkAddModifiable();
            try {
                iList.add(iCursor++, value);
                iLastIndex = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException("The underlying list was modified");
            }
        }

        public void add(Short obj) {
            iList.checkAddModifiable();
            add(iList.toPrimitive(obj));
        }
        
        public void set(short value) {
            iList.checkSetModifiable();
            if (iLastIndex == -1) {
                throw new IllegalStateException("Element cannot be set");
            }
            try {
                iList.set(iLastIndex, value);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException("The underlying list was modified");
            }
        }

        public void set(Short obj) {
            iList.checkSetModifiable();
            set(iList.toPrimitive(obj));
        }

        //-----------------------------------------------------------------------
        public boolean isModifiable() {
            return iList.isModifiable();
        }

        public boolean isResetable() {
            return true;
        }

        public void reset() {
            iCursor = iStart;
        }

    }

}
    