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
package org.joda.primitives;

import java.util.Collection;
import java.util.Iterator;

import org.joda.primitives.collection.FloatCollection;

/**
 * Provides utility methods and constants for <code>float</code>.
 * 
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class FloatUtils {
    // This file is CODE GENERATED. Do not change manually.
    
    /**
     * Immutable empty array.
     */
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    
    /**
     * Constructor that should not usually be used.
     */
    public FloatUtils() {
        super();
    }

    /**
     * Wraps an <code>float</code> with an Object wrapper.
     * 
     * @param value  the primitive value
     * @return the Object wrapper
     */
    public static Float toObject(float value) {
        return new Float(value);
    }

    /**
     * Unwraps the <code>Float</code> to retrieve the primitive <code>float</code>.
     * 
     * @param value  the Object wrapper, must not be null
     * @return the primitive value
     * @throws NullPointerException if the value if null
     * @throws ClassCastException if the object is not <code>Float</code>
     */
    public static float toPrimitive(Object value) {
        return ((Float) value).floatValue();
    }

    /**
     * Unwraps a <code>Collection</code> to retrieve the primitive <code>float</code>.
     * 
     * @param coll  the Collection of Float, must not be null
     * @return the primitive value array
     * @throws NullPointerException if the collection if null
     * @throws ClassCastException if any object is not <code>Float</code>
     */
    public static float[] toPrimitiveArray(Collection <?> coll) {
        if (coll instanceof FloatCollection) {
            return ((FloatCollection) coll).toFloatArray();
        }
        float[] result = new float[coll.size()];
        int i = 0;
        for (Iterator<?> it = coll.iterator(); it.hasNext(); i++) {
            Float value = (Float) it.next();
            result[i] = value.floatValue();
        }
        return result;
    }

}
