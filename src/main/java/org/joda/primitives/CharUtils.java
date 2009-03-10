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

import org.joda.primitives.collection.CharCollection;

/**
 * Provides utility methods and constants for <code>char</code>.
 * 
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class CharUtils {
    // This file is CODE GENERATED. Do not change manually.
    
    /**
     * Immutable empty array.
     */
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    
    /**
     * Constructor that should not usually be used.
     */
    public CharUtils() {
        super();
    }

    /**
     * Wraps an <code>char</code> with an Object wrapper.
     * 
     * @param value  the primitive value
     * @return the Object wrapper
     */
    public static Character toObject(char value) {
        return new Character(value);
    }

    /**
     * Unwraps the <code>Character</code> to retrieve the primitive <code>char</code>.
     * 
     * @param value  the Object wrapper, must not be null
     * @return the primitive value
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Character</code>
     */
    public static char toPrimitive(Object value) {
        return ((Character) value).charValue();
    }

    /**
     * Unwraps a <code>Collection</code> to retrieve the primitive <code>char</code>.
     * 
     * @param coll  the Collection of Character, must not be null
     * @return the primitive value array
     * @throws NullPointerException if the collection if null
     * @throws ClassCastException if any object is not <code>Character</code>
     */
    public static char[] toPrimitiveArray(Collection coll) {
        if (coll instanceof CharCollection) {
            return ((CharCollection) coll).toCharArray();
        }
        char[] result = new char[coll.size()];
        int i = 0;
        for (Iterator it = coll.iterator(); it.hasNext(); i++) {
            Character value = (Character) it.next();
            result[i] = value.charValue();
        }
        return result;
    }

}
