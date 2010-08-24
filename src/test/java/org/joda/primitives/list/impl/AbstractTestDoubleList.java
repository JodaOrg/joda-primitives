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
import org.joda.primitives.list.DoubleList;
import org.joda.primitives.iterator.DoubleIterator;

/**
 * Abstract base class for testing AbstractDoubleList subclasses.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestDoubleList extends AbstractTestList {
    // This file is CODE GENERATED. Do not change manually.

    public AbstractTestDoubleList(String name) {
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

    public Double[] getFullNonNullElements() {
        return new Double[] {
            new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)
        };
    }

    public Double[] getOtherNonNullElements() {
        return new Double[] {
            new Double(-33d),new Double(66d),new Double(-99d)
        };
    }

    public void testIsModifiable() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        assertEquals(isAddSupported() || isRemoveSupported() || isSetSupported(), plist.isModifiable());
    }

    public void testToValueArray() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        double[] values = plist.toDoubleArray();
        int i = 0;
        for (DoubleIterator it = plist.iterator(); it.hasNext(); i++) {
            double next = it.nextDouble();
            assertEquals(values[i], next, 0.00001d);
        }
    }

    public void testToValueArrayInsert() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        double[] array = new double[2];
        try {
            plist.toDoubleArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        double[] values = plist.toDoubleArray();
        
        // array null
        double[] result = plist.toDoubleArray(null, 1);
        assertEquals(0d, result[0], 0.00001d);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i], 0.00001d);
        }
        
        // array too small
        array = new double[2];
        array[0] = 3.5d;
        array[1] = -0.9d;
        result = plist.toDoubleArray(array, 1);
        assertEquals(3.5d, array[0], 0.00001d);
        assertEquals(-0.9d, array[1], 0.00001d);
        assertEquals(plist.size() + 1, result.length);
        assertEquals(3.5d, result[0], 0.00001d);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001d);
        }
        
        // array big enough
        array = new double[values.length + 2];
        Arrays.fill(array, 3.5d);
        result = plist.toDoubleArray(array, 1);
        assertSame(array, result);
        assertEquals(3.5d, array[0], 0.00001d);
        assertEquals(3.5d, array[array.length - 1], 0.00001d);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001d);
        }
    }

    //-----------------------------------------------------------------------
    public void testRemoveRange() {
        resetFull();
        int size = collection.size();
        DoubleList plist = (DoubleList) collection;
        plist.removeRange(size - 4, size - 2);
        ((List<?>) confirmed).remove(size - 4);
        ((List<?>) confirmed).remove(size - 4);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        assertEquals(true, plist.containsAll((double[]) null));
    }

    public void testAddAllArray() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        plist.addAll((double[]) null);
        verify();
    }

    public void testAddAllArrayIndexed() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        plist.addAll(0, (double[]) null);
        verify();
    }

    public void testRemoveAllArray() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        plist.removeAll((double[]) null);
        verify();
    }

    public void testRetainAllArray() {
        resetFull();
        DoubleList plist = (DoubleList) collection;
        plist.retainAll((double[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testFirstDouble_empty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        try {
            plist.firstDouble();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testFirstDouble_notEmpty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        plist.add(0d);
        plist.add(-0.9d);
        assertEquals(0d, plist.firstDouble(), 0.00001d);
    }

    public void testLastDouble_empty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        try {
            plist.lastDouble();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testLastDouble_notEmpty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        plist.add(0d);
        plist.add(-0.9d);
        assertEquals(-0.9d, plist.lastDouble(), 0.00001d);
    }

    //-----------------------------------------------------------------------
    public void testFirst_empty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        assertNull(plist.first());
    }

    public void testFirst_notEmpty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        plist.add(0d);
        plist.add(-0.9d);
        assertEquals(new Double(0d), plist.first());
    }

    public void testLast_empty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        assertNull(plist.last());
    }

    public void testLast_notEmpty() {
        resetEmpty();
        DoubleList plist = (DoubleList) collection;
        plist.add(0d);
        plist.add(-0.9d);
        assertEquals(new Double(-0.9d), plist.last());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        DoubleList coll = (DoubleList) collection;
        if (isCloneSupported()) {
            DoubleList coll2 = (DoubleList) coll.clone();
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
