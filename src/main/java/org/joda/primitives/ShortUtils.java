/*
 *  Copyright 2001-2013 Stephen Colebourne
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

import org.joda.primitives.collection.ShortCollection;

/**
 * Provides utility methods and constants for <code>short</code>.
 * 
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class ShortUtils {
    // This file is CODE GENERATED. Do not change manually.
    
    /**
     * Immutable empty array.
     */
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    
    /**
     * Constructor that should not usually be used.
     */
    public ShortUtils() {
        super();
    }

    /**
     * Wraps an <code>short</code> with an Object wrapper.
     * 
     * @param value  the primitive value
     * @return the Object wrapper
     */
    public static Short toObject(short value) {
        return new Short(value);
    }

    /**
     * Unwraps the <code>Short</code> to retrieve the primitive <code>short</code>.
     * 
     * @param value  the Object wrapper, must not be null
     * @return the primitive value
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Short</code>
     */
    public static short toPrimitive(Object value) {
        return ((Short) value).shortValue();
    }

    /**
     * Unwraps a <code>Collection</code> to retrieve the primitive <code>short</code>.
     * 
     * @param coll  the Collection of Short, must not be null
     * @return the primitive value array
     * @throws NullPointerException if the collection if null
     * @throws ClassCastException if any object is not <code>Short</code>
     */
    public static short[] toPrimitiveArray(Collection<?> coll) {
        if (coll instanceof ShortCollection) {
            return ((ShortCollection) coll).toShortArray();
        }
        short[] result = new short[coll.size()];
        int i = 0;
        for (Iterator<?> it = coll.iterator(); it.hasNext(); i++) {
            Short value = (Short) it.next();
            result[i] = value.shortValue();
        }
        return result;
    }

}
