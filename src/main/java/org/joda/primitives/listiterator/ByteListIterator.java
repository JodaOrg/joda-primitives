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
package org.joda.primitives.listiterator;

import org.joda.primitives.iterator.ByteIterator;

/**
 * Defines a list iterator over primitive <code>byte</code> values.
 * 
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public interface ByteListIterator extends ByteIterator, PrimitiveListIterator {
    // This file is CODE GENERATED. Do not change manually.

    // Mandatory operations
    //-----------------------------------------------------------------------
    /**
     * Gets the previous value from the iterator.
     *
     * @return the previous available value
     * @throws NoSuchElementException if there are no more values available
     */
    byte previousByte();

    // Optional operations
    //-----------------------------------------------------------------------
    /**
     * Adds the specified value to the list underlying the iterator at the
     * current iteration index.
     *
     * @param value  the value to add
     * @throws IllegalStateException if the iterator cannot be added to at present
     * @throws UnsupportedOperationException if not supported by this collection
     */
    void add(byte value);

    /**
     * Sets the last retrieved value from the iterator.
     *
     * @param value  the value to set
     * @throws IllegalStateException if the iterator cannot be set to at present
     * @throws UnsupportedOperationException if not supported by this collection
     */
    void set(byte value);

}
