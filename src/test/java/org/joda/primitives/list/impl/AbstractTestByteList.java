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
package org.joda.primitives.list.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.list.AbstractTestList;
import org.joda.primitives.list.ByteList;
import org.joda.primitives.iterator.ByteIterator;

/**
 * Abstract base class for testing AbstractByteList subclasses.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestByteList extends AbstractTestList {
    // This file is CODE GENERATED. Do not change manually.

    public AbstractTestByteList(String name) {
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

    public Byte[] getFullNonNullElements() {
        return new Byte[] {
            new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38),new Byte((byte)0),new Byte((byte)126),new Byte((byte)202),new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)
        };
    }

    public Byte[] getOtherNonNullElements() {
        return new Byte[] {
            new Byte((byte)-33),new Byte((byte)66),new Byte((byte)-99)
        };
    }

    public void testIsModifiable() {
        resetFull();
        ByteList plist = (ByteList) collection;
        assertEquals(isAddSupported() || isRemoveSupported() || isSetSupported(), plist.isModifiable());
    }

    public void testToValueArray() {
        resetFull();
        ByteList plist = (ByteList) collection;
        byte[] values = plist.toByteArray();
        int i = 0;
        for (ByteIterator it = plist.iterator(); it.hasNext(); i++) {
            byte next = it.nextByte();
            assertEquals(values[i], next);
        }
    }

    public void testToValueArrayInsert() {
        resetFull();
        ByteList plist = (ByteList) collection;
        byte[] array = new byte[2];
        try {
            plist.toByteArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        byte[] values = plist.toByteArray();
        
        // array null
        byte[] result = plist.toByteArray(null, 1);
        assertEquals((byte) 0, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new byte[2];
        array[0] = (byte) 2;
        array[1] = (byte) 6;
        result = plist.toByteArray(array, 1);
        assertEquals((byte) 2, array[0]);
        assertEquals((byte) 6, array[1]);
        assertEquals(plist.size() + 1, result.length);
        assertEquals((byte) 2, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new byte[values.length + 2];
        Arrays.fill(array, (byte) 2);
        result = plist.toByteArray(array, 1);
        assertSame(array, result);
        assertEquals((byte) 2, array[0]);
        assertEquals((byte) 2, array[array.length - 1]);
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
        ByteList plist = (ByteList) collection;
        plist.removeRange(size - 4, size - 2);
        ((List<?>) confirmed).remove(size - 4);
        ((List<?>) confirmed).remove(size - 4);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        ByteList plist = (ByteList) collection;
        assertEquals(true, plist.containsAll((byte[]) null));
    }

    public void testAddAllArray() {
        if (isAddSupported() == false) {
            return;
        }
        resetFull();
        ByteList plist = (ByteList) collection;
        plist.addAll((byte[]) null);
        verify();
    }

    public void testAddAllArrayIndexed() {
        if (isAddSupported() == false) {
            return;
        }
        resetFull();
        ByteList plist = (ByteList) collection;
        plist.addAll(0, (byte[]) null);
        verify();
    }

    public void testRemoveAllArray() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        ByteList plist = (ByteList) collection;
        plist.removeAll((byte[]) null);
        verify();
    }

    public void testRetainAllArray() {
        if (isRemoveSupported() == false) {
            return;
        }
        resetFull();
        ByteList plist = (ByteList) collection;
        plist.retainAll((byte[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testFirstByte_empty() {
        resetEmpty();
        ByteList plist = (ByteList) collection;
        try {
            plist.firstByte();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testFirstByte_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ByteList plist = (ByteList) collection;
        plist.add((byte) 0);
        plist.add((byte) 6);
        assertEquals((byte) 0, plist.firstByte());
    }

    public void testLastByte_empty() {
        resetEmpty();
        ByteList plist = (ByteList) collection;
        try {
            plist.lastByte();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testLastByte_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ByteList plist = (ByteList) collection;
        plist.add((byte) 0);
        plist.add((byte) 6);
        assertEquals((byte) 6, plist.lastByte());
    }

    //-----------------------------------------------------------------------
    public void testFirst_empty() {
        resetEmpty();
        ByteList plist = (ByteList) collection;
        assertNull(plist.first());
    }

    public void testFirst_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ByteList plist = (ByteList) collection;
        plist.add((byte) 0);
        plist.add((byte) 6);
        assertEquals(new Byte((byte) 0), plist.first());
    }

    public void testLast_empty() {
        resetEmpty();
        ByteList plist = (ByteList) collection;
        assertNull(plist.last());
    }

    public void testLast_notEmpty() {
        if (isAddSupported() == false) {
            return;
        }
        resetEmpty();
        ByteList plist = (ByteList) collection;
        plist.add((byte) 0);
        plist.add((byte) 6);
        assertEquals(new Byte((byte) 6), plist.last());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        ByteList coll = (ByteList) collection;
        if (isCloneSupported()) {
            ByteList coll2 = (ByteList) coll.clone();
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
