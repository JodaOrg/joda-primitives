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
package org.joda.primitives.list.impl;

import java.util.Arrays;

import org.apache.commons.collections.list.AbstractTestList;
import org.joda.primitives.list.LongList;
import org.joda.primitives.iterator.LongIterator;

/**
 * Abstract base class for testing AbstractLongList subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestLongList extends AbstractTestList {
    // This file is CODE GENERATED. Do not change manually.

    public AbstractTestLongList(String name) {
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

    public Object[] getFullNonNullElements() {
        return new Object[] {
            new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)
        };
    }

    public Object[] getOtherNonNullElements() {
        return new Object[] {
            new Long(-33),new Long(66),new Long(-99)
        };
    }

    public void testIsModifiable() {
        resetFull();
        LongList plist = (LongList) collection;
        assertEquals(isAddSupported() || isRemoveSupported() || isSetSupported(), plist.isModifiable());
    }

    public void testToValueArray() {
        resetFull();
        LongList plist = (LongList) collection;
        long[] values = plist.toLongArray();
        int i = 0;
        for (LongIterator it = plist.longIterator(); it.hasNext(); i++) {
            long next = it.nextLong();
            assertEquals(values[i], next);
        }
    }

    public void testToValueArrayInsert() {
        resetFull();
        LongList plist = (LongList) collection;
        long[] array = new long[2];
        try {
            plist.toLongArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        long[] values = plist.toLongArray();
        
        // array null
        long[] result = plist.toLongArray(null, 1);
        assertEquals(0L, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new long[2];
        array[0] = 2L;
        array[1] = 6L;
        result = plist.toLongArray(array, 1);
        assertEquals(2L, array[0]);
        assertEquals(6L, array[1]);
        assertEquals(plist.size() + 1, result.length);
        assertEquals(2L, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new long[values.length + 2];
        Arrays.fill(array, 2L);
        result = plist.toLongArray(array, 1);
        assertSame(array, result);
        assertEquals(2L, array[0]);
        assertEquals(2L, array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }

    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        LongList plist = (LongList) collection;
        assertEquals(true, plist.containsAll((long[]) null));
    }

    public void testAddAllArray() {
        resetFull();
        LongList plist = (LongList) collection;
        plist.addAll((long[]) null);
        verify();
    }

    public void testAddAllArrayIndexed() {
        resetFull();
        LongList plist = (LongList) collection;
        plist.addAll(0, (long[]) null);
        verify();
    }

    public void testRemoveAllArray() {
        resetFull();
        LongList plist = (LongList) collection;
        plist.removeAll((long[]) null);
        verify();
    }

    public void testRetainAllArray() {
        resetFull();
        LongList plist = (LongList) collection;
        plist.retainAll((long[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testFirstLong_empty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        try {
            plist.firstLong();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testFirstLong_notEmpty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        plist.add(0L);
        plist.add(6L);
        assertEquals(0L, plist.firstLong());
    }

    public void testLastLong_empty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        try {
            plist.lastLong();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testLastLong_notEmpty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        plist.add(0L);
        plist.add(6L);
        assertEquals(6L, plist.lastLong());
    }

    //-----------------------------------------------------------------------
    public void testFirst_empty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        assertNull(plist.first());
    }

    public void testFirst_notEmpty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        plist.add(0L);
        plist.add(6L);
        assertEquals(new Long(0L), plist.first());
    }

    public void testLast_empty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        assertNull(plist.last());
    }

    public void testLast_notEmpty() {
        resetEmpty();
        LongList plist = (LongList) collection;
        plist.add(0L);
        plist.add(6L);
        assertEquals(new Long(6L), plist.last());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        LongList coll = (LongList) collection;
        if (isCloneSupported()) {
            LongList coll2 = (LongList) coll.clone();
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
