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
package org.joda.primitives;

import java.util.Collection;
import java.util.Iterator;

import org.joda.primitives.collection.ByteCollection;

/**
 * Provides utility methods and constants for <code>byte</code>.
 * 
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class ByteUtils {
    // This file is CODE GENERATED. Do not change manually.
    
    /**
     * Immutable empty array.
     */
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    
    /**
     * Constructor that should not usually be used.
     */
    public ByteUtils() {
        super();
    }

    /**
     * Wraps an <code>byte</code> with an Object wrapper.
     * 
     * @param value  the primitive value
     * @return the Object wrapper
     */
    public static Byte toObject(byte value) {
        return new Byte(value);
    }

    /**
     * Unwraps the <code>Byte</code> to retrieve the primitive <code>byte</code>.
     * 
     * @param value  the Object wrapper, must not be null
     * @return the primitive value
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Byte</code>
     */
    public static byte toPrimitive(Object value) {
        return ((Byte) value).byteValue();
    }

    /**
     * Unwraps a <code>Collection</code> to retrieve the primitive <code>byte</code>.
     * 
     * @param coll  the Collection of Byte, must not be null
     * @return the primitive value array
     * @throws NullPointerException if the collection if null
     * @throws ClassCastException if any object is not <code>Byte</code>
     */
    public static byte[] toPrimitiveArray(Collection<?> coll) {
        if (coll instanceof ByteCollection) {
            return ((ByteCollection) coll).toByteArray();
        }
        byte[] result = new byte[coll.size()];
        int i = 0;
        for (Iterator<?> it = coll.iterator(); it.hasNext(); i++) {
            Byte value = (Byte) it.next();
            result[i] = value.byteValue();
        }
        return result;
    }

}
