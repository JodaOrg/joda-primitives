/*
 *  Copyright 2001-2010 Stephen Colebourne
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
package org.joda.primitives.iterator;

import java.util.Iterator;

/**
 * Base interface for all primitive iterator interfaces.
 * 
 * @author Stephen Colebourne
 * @since 1.0
 */
public interface PrimitiveIterator<E> extends Iterator<E> {

    // Mandatory operations
    //-----------------------------------------------------------------------
    /**
     * Checks whether the iterator can currently be modified.
     *
     * @return <code>true</code> if the modification methods of the iterator can be used
     */
    boolean isModifiable();

    /**
     * Checks whether the iterator can be reset.
     *
     * @return <code>true</code> if the object can be reset
     */
    boolean isResetable();

    // Optional operations
    //-----------------------------------------------------------------------
    /**
     * Resets the iterator back to its initial state (optional operation).
     * 
     * @throws UnsupportedOperationException if the iterator cannot be reset
     */
    void reset();

}
