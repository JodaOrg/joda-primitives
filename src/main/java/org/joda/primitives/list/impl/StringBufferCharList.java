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

import org.joda.primitives.list.CharList;

/**
 * CharList implementation that uses a StringBuffer internally.
 * <p>
 * This class implements {@link java.util.List List} allowing
 * seamless integration with other APIs.
 *
 * @author Stephen Colebourne
 * @since 1.0
 */
public class StringBufferCharList extends AbstractCharList {

    /** The String being wrapped */    
    protected final StringBuffer stringBuffer;
    
    /**
     * Decorates the specified string buffer with a StringBufferCharList.
     * <p>
     * The specified buffer is used as the datasource, so changes to one
     * will affect the other.
     * 
     * @param buf  the string buffer to decorate, must not be null
     * @return the new StringBufferCharList
     * @throws IllegalArgumentException if the string is null
     */
    public static StringBufferCharList decorate(StringBuffer buf) {
        if (buf == null) {
            throw new IllegalArgumentException("StringBuffer must not be null");
        }
        return new StringBufferCharList(buf);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Constructor that uses an empty string as the datasource.
     */
    public StringBufferCharList() {
        super();
        this.stringBuffer = new StringBuffer();
    }
    
    /**
     * Constructor that copies the specified list.
     * 
     * @param list  the list to copy, must not be null
     * @throws IllegalArgumentException if the list is null
     */
    public StringBufferCharList(CharList list) {
        super();
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        this.stringBuffer = new StringBuffer(list.size());
        this.stringBuffer.append(list.toCharArray());
    }
    
    /**
     * Constructor that copies the specified string.
     * 
     * @param str  the string to copy, must not be null
     * @throws IllegalArgumentException if the string is null
     */
    public StringBufferCharList(String str) {
        super();
        if (str == null) {
            throw new IllegalArgumentException("String must not be null");
        }
        this.stringBuffer = new StringBuffer(str);
    }
    
    /**
     * Constructor that <i>decorates</i> the specified string buffer.
     * 
     * @param buf  the string buffer to decorate, must not be null
     * @throws IllegalArgumentException if the string is null
     */
    protected StringBufferCharList(StringBuffer buf) {
        super();
        if (buf == null) {
            throw new IllegalArgumentException("StringBuffer must not be null");
        }
        this.stringBuffer = buf;
    }
    
    // Implementation
    //-----------------------------------------------------------------------
    /**
     * Gets the character at the specified index.
     * 
     * @param index  the index to retrieve
     * @return the character at the specified index
     */
    @Override
    public char getChar(int index) {
        checkIndexExists(index);
        return stringBuffer.charAt(index);
    }

    /**
     * Gets the size of the list, which is the string length.
     * 
     * @return the string length
     */
    @Override
    public int size() {
        return stringBuffer.length();
    }

    /**
     * Adds a primitive value to this list at an index.
     *
     * @param index  the index to add at
     * @param value  the value to add to this collection
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    @Override
    public boolean add(int index, char value) {
        checkAddModifiable();
        checkIndex(index);
        stringBuffer.insert(index, value);
        return true;
    }

    /**
     * Removes a primitive value by index from the list.
     *
     * @param index  the index to remove from
     * @return the primitive value previously at this index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public char removeIndex(int index) {
        checkRemoveModifiable();
        checkIndexExists(index);
        char old = stringBuffer.charAt(index);
        stringBuffer.deleteCharAt(index);
        return old;
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
     */
    @Override
    public char set(int index, char value) {
        checkSetModifiable();
        checkIndexExists(index);
        char old = stringBuffer.charAt(index);
        stringBuffer.setCharAt(index, value);
        return old;
    }

    /**
     * Are the add methods supported.
     *
     * @return true
     */
    @Override
    protected boolean isAddModifiable() {
        return true;
    }

    /**
     * Are the remove methods supported.
     *
     * @return true
     */
    @Override
    protected boolean isRemoveModifiable() {
        return true;
    }

    /**
     * Are the set methods supported.
     *
     * @return true
     */
    @Override
    protected boolean isSetModifiable() {
        return true;
    }

    /**
     * Is the collection modifiable in any way.
     *
     * @return true if supported
     */
    @Override
    public boolean isModifiable() {
        return true;
    }

    // Optimisation
    //-----------------------------------------------------------------------
    /**
     * Adds a primitive value to this collection.
     *
     * @param value  the value to add to this collection
     * @return <code>true</code> if this collection was modified by this method call
     */
    @Override
    public boolean add(char value) {
        checkAddModifiable();
        stringBuffer.append(value);
        return true;
    }

    /**
     * Adds an array of primitive values to this list at an index.
     *
     * @param values  the values to add to this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    @Override
    public boolean addAll(char[] values) {
        checkAddModifiable();
        if (values == null || values.length == 0) {
            return false;
        }
        stringBuffer.append(values);
        return true;
    }

    /**
     * Adds an array of primitive values to this list at an index.
     *
     * @param index  the index to add at
     * @param values  the values to add to this collection, null treated as empty array
     * @return <code>true</code> if this list was modified by this method call
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    @Override
    public boolean addAll(int index, char[] values) {
        checkAddModifiable();
        checkIndex(index);
        if (values == null || values.length == 0) {
            return false;
        }
        stringBuffer.insert(index, values);
        return true;
    }

    /**
     * Removes a range of values from the list.
     *
     * @param fromIndexInclusive  the start of the range to remove, inclusive
     * @param toIndexExclusive  the end of the range to remove, exclusive
     * @return <code>true</code> if the collection was modified
     */
    @Override
    public boolean removeRange(int fromIndexInclusive, int toIndexExclusive) {
        checkRemoveModifiable();
        checkRange(fromIndexInclusive, toIndexExclusive);
        if (fromIndexInclusive == toIndexExclusive) {
            return false;
        }
        stringBuffer.delete(fromIndexInclusive, toIndexExclusive);
        return true;
    }

    /**
     * Gets the String underlying the list.
     * 
     * @return the underlying string, not null
     */
    @Override
    public String toStringContents() {
        return stringBuffer.substring(0, stringBuffer.length());
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
    @Override
    protected void arrayCopy(int fromIndex, char[] dest, int destIndex, int size) {
        stringBuffer.getChars(fromIndex, fromIndex + size, dest, destIndex);
    }

}
