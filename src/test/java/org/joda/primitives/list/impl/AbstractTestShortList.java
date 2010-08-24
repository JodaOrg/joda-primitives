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
import org.joda.primitives.list.ShortList;
import org.joda.primitives.iterator.ShortIterator;

/**
 * Abstract base class for testing AbstractShortList subclasses.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestShortList extends AbstractTestList {
    // This file is CODE GENERATED. Do not change manually.

    public AbstractTestShortList(String name) {
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

    public Short[] getFullNonNullElements() {
        return new Short[] {
            new Short((short)2),new Short((short)-2),new Short((short)38),new Short((short)0),new Short((short)1000),new Short((short)202),new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)
        };
    }

    public Short[] getOtherNonNullElements() {
        return new Short[] {
            new Short((short)-33),new Short((short)66),new Short((short)-99)
        };
    }

    public void testIsModifiable() {
        resetFull();
        ShortList plist = (ShortList) collection;
        assertEquals(isAddSupported() || isRemoveSupported() || isSetSupported(), plist.isModifiable());
    }

    public void testToValueArray() {
        resetFull();
        ShortList plist = (ShortList) collection;
        short[] values = plist.toShortArray();
        int i = 0;
        for (ShortIterator it = plist.iterator(); it.hasNext(); i++) {
            short next = it.nextShort();
            assertEquals(values[i], next);
        }
    }

    public void testToValueArrayInsert() {
        resetFull();
        ShortList plist = (ShortList) collection;
        short[] array = new short[2];
        try {
            plist.toShortArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        short[] values = plist.toShortArray();
        
        // array null
        short[] result = plist.toShortArray(null, 1);
        assertEquals((short) 0, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new short[2];
        array[0] = (short) 2;
        array[1] = (short) 6;
        result = plist.toShortArray(array, 1);
        assertEquals((short) 2, array[0]);
        assertEquals((short) 6, array[1]);
        assertEquals(plist.size() + 1, result.length);
        assertEquals((short) 2, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new short[values.length + 2];
        Arrays.fill(array, (short) 2);
        result = plist.toShortArray(array, 1);
        assertSame(array, result);
        assertEquals((short) 2, array[0]);
        assertEquals((short) 2, array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }

    //-----------------------------------------------------------------------
    public void testRemoveRange() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        int size = collection.size();
        ShortList plist = (ShortList) collection;
        plist.removeRange(size - 4, size - 2);
        ((List<?>) confirmed).remove(size - 4);
        ((List<?>) confirmed).remove(size - 4);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        ShortList plist = (ShortList) collection;
        assertEquals(true, plist.containsAll((short[]) null));
    }

    public void testAddAllArray() {
        if (isAddSupported() == false) {
            return;
        }
        resetFull();
        ShortList plist = (ShortList) collection;
        plist.addAll((short[]) null);
        verify();
    }

    public void testAddAllArrayIndexed() {
        if (isAddSupported() == false) {
            return;
        }
        resetFull();
        ShortList plist = (ShortList) collection;
        plist.addAll(0, (short[]) null);
        verify();
    }

    public void testRemoveAllArray() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        ShortList plist = (ShortList) collection;
        plist.removeAll((short[]) null);
        verify();
    }

    public void testRetainAllArray() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        ShortList plist = (ShortList) collection;
        plist.retainAll((short[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testFirstShort_empty() {
        resetEmpty();
        ShortList plist = (ShortList) collection;
        try {
            plist.firstShort();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testFirstShort_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ShortList plist = (ShortList) collection;
        plist.add((short) 0);
        plist.add((short) 6);
        assertEquals((short) 0, plist.firstShort());
    }

    public void testLastShort_empty() {
        resetEmpty();
        ShortList plist = (ShortList) collection;
        try {
            plist.lastShort();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testLastShort_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ShortList plist = (ShortList) collection;
        plist.add((short) 0);
        plist.add((short) 6);
        assertEquals((short) 6, plist.lastShort());
    }

    //-----------------------------------------------------------------------
    public void testFirst_empty() {
        resetEmpty();
        ShortList plist = (ShortList) collection;
        assertNull(plist.first());
    }

    public void testFirst_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ShortList plist = (ShortList) collection;
        plist.add((short) 0);
        plist.add((short) 6);
        assertEquals(new Short((short) 0), plist.first());
    }

    public void testLast_empty() {
        resetEmpty();
        ShortList plist = (ShortList) collection;
        assertNull(plist.last());
    }

    public void testLast_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ShortList plist = (ShortList) collection;
        plist.add((short) 0);
        plist.add((short) 6);
        assertEquals(new Short((short) 6), plist.last());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        ShortList coll = (ShortList) collection;
        if (isCloneSupported()) {
            ShortList coll2 = (ShortList) coll.clone();
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
