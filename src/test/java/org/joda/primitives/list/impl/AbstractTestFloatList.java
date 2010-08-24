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
package org.joda.primitives.list.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.list.AbstractTestList;
import org.joda.primitives.list.FloatList;
import org.joda.primitives.iterator.FloatIterator;

/**
 * Abstract base class for testing AbstractFloatList subclasses.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestFloatList extends AbstractTestList {
    // This file is CODE GENERATED. Do not change manually.

    public AbstractTestFloatList(String name) {
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

    public Float[] getFullNonNullElements() {
        return new Float[] {
            new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)
        };
    }

    public Float[] getOtherNonNullElements() {
        return new Float[] {
            new Float(-33f),new Float(66f),new Float(-99f)
        };
    }

    public void testIsModifiable() {
        resetFull();
        FloatList plist = (FloatList) collection;
        assertEquals(isAddSupported() || isRemoveSupported() || isSetSupported(), plist.isModifiable());
    }

    public void testToValueArray() {
        resetFull();
        FloatList plist = (FloatList) collection;
        float[] values = plist.toFloatArray();
        int i = 0;
        for (FloatIterator it = plist.iterator(); it.hasNext(); i++) {
            float next = it.nextFloat();
            assertEquals(values[i], next, 0.00001f);
        }
    }

    public void testToValueArrayInsert() {
        resetFull();
        FloatList plist = (FloatList) collection;
        float[] array = new float[2];
        try {
            plist.toFloatArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        float[] values = plist.toFloatArray();
        
        // array null
        float[] result = plist.toFloatArray(null, 1);
        assertEquals(0f, result[0], 0.00001f);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i], 0.00001f);
        }
        
        // array too small
        array = new float[2];
        array[0] = 12.6f;
        array[1] = 0.1f;
        result = plist.toFloatArray(array, 1);
        assertEquals(12.6f, array[0], 0.00001f);
        assertEquals(0.1f, array[1], 0.00001f);
        assertEquals(plist.size() + 1, result.length);
        assertEquals(12.6f, result[0], 0.00001f);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001f);
        }
        
        // array big enough
        array = new float[values.length + 2];
        Arrays.fill(array, 12.6f);
        result = plist.toFloatArray(array, 1);
        assertSame(array, result);
        assertEquals(12.6f, array[0], 0.00001f);
        assertEquals(12.6f, array[array.length - 1], 0.00001f);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001f);
        }
    }

    //-----------------------------------------------------------------------
    public void testRemoveRange() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        int size = collection.size();
        FloatList plist = (FloatList) collection;
        plist.removeRange(size - 4, size - 2);
        ((List<?>) confirmed).remove(size - 4);
        ((List<?>) confirmed).remove(size - 4);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        FloatList plist = (FloatList) collection;
        assertEquals(true, plist.containsAll((float[]) null));
    }

    public void testAddAllArray() {
        if (isAddSupported() == false) {
            return;
        }
        resetFull();
        FloatList plist = (FloatList) collection;
        plist.addAll((float[]) null);
        verify();
    }

    public void testAddAllArrayIndexed() {
        if (isAddSupported() == false) {
            return;
        }
        resetFull();
        FloatList plist = (FloatList) collection;
        plist.addAll(0, (float[]) null);
        verify();
    }

    public void testRemoveAllArray() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        FloatList plist = (FloatList) collection;
        plist.removeAll((float[]) null);
        verify();
    }

    public void testRetainAllArray() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        FloatList plist = (FloatList) collection;
        plist.retainAll((float[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testFirstFloat_empty() {
        resetEmpty();
        FloatList plist = (FloatList) collection;
        try {
            plist.firstFloat();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testFirstFloat_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        FloatList plist = (FloatList) collection;
        plist.add(0f);
        plist.add(0.1f);
        assertEquals(0f, plist.firstFloat(), 0.00001f);
    }

    public void testLastFloat_empty() {
        resetEmpty();
        FloatList plist = (FloatList) collection;
        try {
            plist.lastFloat();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testLastFloat_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        FloatList plist = (FloatList) collection;
        plist.add(0f);
        plist.add(0.1f);
        assertEquals(0.1f, plist.lastFloat(), 0.00001f);
    }

    //-----------------------------------------------------------------------
    public void testFirst_empty() {
        resetEmpty();
        FloatList plist = (FloatList) collection;
        assertNull(plist.first());
    }

    public void testFirst_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        FloatList plist = (FloatList) collection;
        plist.add(0f);
        plist.add(0.1f);
        assertEquals(new Float(0f), plist.first());
    }

    public void testLast_empty() {
        resetEmpty();
        FloatList plist = (FloatList) collection;
        assertNull(plist.last());
    }

    public void testLast_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        FloatList plist = (FloatList) collection;
        plist.add(0f);
        plist.add(0.1f);
        assertEquals(new Float(0.1f), plist.last());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        FloatList coll = (FloatList) collection;
        if (isCloneSupported()) {
            FloatList coll2 = (FloatList) coll.clone();
            assertTrue(coll != coll2);
            assertEquals(coll, coll2);
        } else {
            try {
                coll.clone();
                fail();
            } catch (UnsupportedOperationException ex) {}
        }
    }

}
