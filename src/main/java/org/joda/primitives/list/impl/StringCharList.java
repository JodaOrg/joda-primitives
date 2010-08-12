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

import org.joda.primitives.CharUtils;
import org.joda.primitives.list.CharList;

/**
 * Unmodifiable CharList wrapped around a String.
 * <p>
 * This class implements {@link java.util.List List} allowing
 * seamless integration with other APIs.
 *
 * @author Stephen Colebourne
 * @since 1.0
 */
public class StringCharList extends AbstractCharList implements Cloneable {

    /** The String being wrapped */
    protected final String string;

    /**
     * Constructor that uses an empty string as the datasource.
     */
    public StringCharList() {
        super();
        this.string = "";
    }

    /**
     * Constructor that copies the specified list.
     * 
     * @param list  the list to copy, must not be null
     * @throws IllegalArgumentException if the list is null
     */
    public StringCharList(CharList list) {
        super();
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        this.string = new String(list.toCharArray());
    }

    /**
     * Constructor that uses the specified string as the datasource.
     * 
     * @param str  the string to wrap in a list, must not be null
     * @throws IllegalArgumentException if the string is null
     */
    public StringCharList(String str) {
        super();
        if (str == null) {
            throw new IllegalArgumentException("String must not be null");
        }
        this.string = str;
    }

    // Implementation
    //-----------------------------------------------------------------------
    /**
     * Gets the character at the specified index.
     * 
     * @param index  the index to retrieve
     * @return the character at the specified index
     */
    public char getChar(int index) {
        return string.charAt(index);
    }

    /**
     * Gets the size of the list, which is the string length.
     * 
     * @return the string length
     */
    public int size() {
        return string.length();
    }

    // Optimisation
    //-----------------------------------------------------------------------
    /**
     * Checks whether this collection contains a specified primitive value.
     * <p>
     * This implementation uses <code>String.indexOf(char)</code>.
     *
     * @param value  the value to search for
     * @return <code>true</code> if the value is found
     */
    public boolean contains(char value) {
        return (string.indexOf(value) >= 0);
    }

    /**
     * Gets the first index of the specified primitive value.
     * <p>
     * This implementation uses <code>String.indexOf(char)</code>.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int indexOf(char value) {
        return string.indexOf(value);
    }

    /**
     * Gets the first index of the specified primitive value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that a
     * negative index is treated as zero, and an index greater than the list
     * size will simply return <code>-1</code>.
     * <p>
     * This implementation uses <code>String.indexOf(char, int)</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int indexOf(char value, int fromIndexInclusive) {
        return string.indexOf(value, fromIndexInclusive);
    }

    /**
     * Gets the last index of the specified primitive value.
     * <p>
     * This implementation uses <code>String.lastIndexOf(char)</code>.
     *
     * @param value  the value to search for
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int lastIndexOf(char value) {
        return string.lastIndexOf(value);
    }

    /**
     * Gets the first index of the specified primitive value from an index.
     * <p>
     * This method follows the conventions of <code>String</code> in that an
     * index greater than the list size will start searching at the list size,
     * and a negative index simply returns <code>-1</code>.
     * <p>
     * This implementation uses <code>String.lastIndexOf(char, int)</code>.
     *
     * @param value  the value to search for
     * @param fromIndexInclusive  the index to start searching from, inclusive
     * @return the zero-based index, or <code>-1</code> if not found
     */
    public int lastIndexOf(char value, int fromIndexInclusive) {
        return string.lastIndexOf(value, fromIndexInclusive);
    }

    /**
     * Gets the String underlying the list.
     * 
     * @return the underlying string, not null
     */
    public String toStringContents() {
        return string;
    }

    /**
     * Gets the elements of this collection as an array.
     * <p>
     * This implementation uses <code>String.toCharArray()</code>.
     *
     * @return a new array containing a copy of the elements of this collection, not null
     */
    public char[] toCharArray() {
        if (size() == 0) {
            return CharUtils.EMPTY_CHAR_ARRAY;
        }
        return string.toCharArray();
    }

    /**
     * Gets a range view of part of this list.
     * <p>
     * This method allows operations to work on a range within the greater list.
     * StringCharList is unmodifiable, thus so is the view.
     *
     * @param fromIndexInclusive  the index to start from, inclusive
     * @param toIndexExclusive  the index to end at, exclusive
     * @return a new CharList for the subList, not null
     * @throws IndexOutOfBoundsException if either index is invalid
     */
    public CharList subCharList(int fromIndexInclusive, int toIndexExclusive) {
        checkRange(fromIndexInclusive, toIndexExclusive);
        return new StringCharList(string.substring(fromIndexInclusive, toIndexExclusive));
    }

}
