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
package org.joda.primitives.iterable;

import org.joda.primitives.iterator.ByteIterator;

/**
 * Defines a provider of iteration over a collection of primitive <code>byte</code> values.
 * <p>
 * This interface extends {@link java.util.Iterable Iterable} allowing
 * seamless integration with other APIs.
 * 
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public interface ByteIterable extends Iterable<Byte> {
    // This file is CODE GENERATED. Do not change manually.

    // Mandatory operations
    //-----------------------------------------------------------------------
    /**
     * Gets an iterator over this collection capable of accessing the primitive values.
     *
     * @return an iterator, not null
     */
    ByteIterator iterator();

}
