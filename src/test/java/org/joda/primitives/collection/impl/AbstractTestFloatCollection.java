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
package org.joda.primitives.collection.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.collection.AbstractTestCollection;
import org.joda.primitives.FloatUtils;
import org.joda.primitives.collection.FloatCollection;
import org.joda.primitives.iterator.FloatIterator;

/**
 * Abstract base class for testing AbstractFloatCollection subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestFloatCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestFloatCollection(String name) {
        super(name);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Override to indicate that clone is not supported for this object.
     */
    public boolean isCloneSupported() {
        return true;
    }
    
    //-----------------------------------------------------------------------
    public boolean isNullSupported() {
        return false;
    }

    public Collection makeConfirmedCollection() {
        return new ArrayList();
    }

    public Collection makeConfirmedFullCollection() {
        List list = new ArrayList();
        list.addAll(Arrays.asList(getFullNonNullElements()));
        return list;
    }

    public Object[] getFullNonNullElements() {
        return new Object[] {
            new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)
        };
    }
    
    public Object[] getOtherNonNullElements() {
        return new Object[] {
            new Float(-33f),new Float(66f),new Float(-99f)
        };
    }
    
    public void testIsModifiable() {
        FloatCollection ic = (FloatCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        FloatCollection ic = (FloatCollection) makeFullCollection();
        float[] values = ic.toFloatArray();
        int i = 0;
        for (FloatIterator it = ic.floatIterator(); it.hasNext(); i++) {
            float next = it.nextFloat();
            assertEquals(values[i], next, 0.00001f);
        }
    }
    
    public void testToValueArrayEmpty() {
        FloatCollection ic = (FloatCollection) makeFullCollection();
        ic.clear();
        float[] values = ic.toFloatArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        FloatCollection ic = (FloatCollection) makeFullCollection();
        float[] array = new float[2];
        try {
            ic.toFloatArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        float[] values = ic.toFloatArray();
        
        // array null
        float[] result = ic.toFloatArray(null, 1);
        assertEquals(0f, result[0], 0.00001f);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i], 0.00001f);
        }
        
        // array too small
        array = new float[2];
        array[0] = 12.6f;
        array[1] = 0.1f;
        result = ic.toFloatArray(array, 1);
        assertEquals(12.6f, array[0], 0.00001f);
        assertEquals(0.1f, array[1], 0.00001f);
        assertEquals(ic.size() + 1, result.length);
        assertEquals(12.6f, result[0], 0.00001f);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001f);
        }
        
        // array big enough
        array = new float[values.length + 2];
        Arrays.fill(array, 12.6f);
        result = ic.toFloatArray(array, 1);
        assertSame(array, result);
        assertEquals(12.6f, array[0], 0.00001f);
        assertEquals(12.6f, array[array.length - 1], 0.00001f);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001f);
        }
    }
    
    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        assertEquals(true, coll.containsAll((float[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        FloatCollection clone = (FloatCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((FloatCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        assertEquals(false, coll.containsAny((float[]) null));
        assertEquals(false, coll.containsAny(new float[0]));
        assertEquals(true, coll.containsAny(new float[] {FloatUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new float[] {FloatUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        FloatCollection clone = (FloatCollection) coll.clone();
        
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        Iterator it = clone.iterator();
        Object obj = it.next();
        clone.clear();
        clone.add(obj);
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        coll.remove(obj);
        assertEquals(false, coll.containsAny(clone));
        assertEquals(false, clone.containsAny(coll));
        
        assertEquals(false, coll.containsAny((FloatCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        coll.addAll((float[]) null);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        float first = coll.floatIterator().nextFloat();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        coll.removeAll((float[]) null);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        coll.retainAll((float[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        FloatCollection coll = (FloatCollection) collection;
        if (isCloneSupported()) {
            FloatCollection coll2 = (FloatCollection) coll.clone();
            assertTrue(coll != coll2);
            assertTrue(coll.size() == coll2.size());
            assertTrue(coll.containsAll(coll2));
            assertTrue(coll2.containsAll(coll));
        } else {
            try {
                coll.clone();
                fail();
            } catch (UnsupportedOperationException ex) {}
        }
    }
    
}
