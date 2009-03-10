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
package org.joda.primitives;

import java.util.Collection;
import java.util.Iterator;

import org.joda.primitives.collection.BooleanCollection;

/**
 * Provides utility methods and constants for <code>boolean</code>.
 * 
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class BooleanUtils {
    // This file is CODE GENERATED. Do not change manually.
    
    /**
     * Immutable empty array.
     */
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    
    /**
     * Constructor that should not usually be used.
     */
    public BooleanUtils() {
        super();
    }

    /**
     * Wraps an <code>boolean</code> with an Object wrapper.
     * 
     * @param value  the primitive value
     * @return the Object wrapper
     */
    public static Boolean toObject(boolean value) {
        return (value ? Boolean.TRUE : Boolean.FALSE);
    }

    /**
     * Unwraps the <code>Boolean</code> to retrieve the primitive <code>boolean</code>.
     * 
     * @param value  the Object wrapper, must not be null
     * @return the primitive value
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Boolean</code>
     */
    public static boolean toPrimitive(Object value) {
        return ((Boolean) value).booleanValue();
    }

    /**
     * Unwraps a <code>Collection</code> to retrieve the primitive <code>boolean</code>.
     * 
     * @param coll  the Collection of Boolean, must not be null
     * @return the primitive value array
     * @throws NullPointerException if the collection if null
     * @throws ClassCastException if any object is not <code>Boolean</code>
     */
    public static boolean[] toPrimitiveArray(Collection coll) {
        if (coll instanceof BooleanCollection) {
            return ((BooleanCollection) coll).toBooleanArray();
        }
        boolean[] result = new boolean[coll.size()];
        int i = 0;
        for (Iterator it = coll.iterator(); it.hasNext(); i++) {
            Boolean value = (Boolean) it.next();
            result[i] = value.booleanValue();
        }
        return result;
    }

}
