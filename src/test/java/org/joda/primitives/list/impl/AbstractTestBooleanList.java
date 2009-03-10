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
import org.joda.primitives.list.BooleanList;
import org.joda.primitives.iterator.BooleanIterator;

/**
 * Abstract base class for testing AbstractBooleanList subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestBooleanList extends AbstractTestList {
    // This file is CODE GENERATED. Do not change manually.

    public AbstractTestBooleanList(String name) {
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
            Boolean.TRUE
        };
    }

    public Object[] getOtherNonNullElements() {
        return new Object[] {
            Boolean.FALSE
        };
    }

    public void testIsModifiable() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        assertEquals(isAddSupported() || isRemoveSupported() || isSetSupported(), plist.isModifiable());
    }

    public void testToValueArray() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        boolean[] values = plist.toBooleanArray();
        int i = 0;
        for (BooleanIterator it = plist.booleanIterator(); it.hasNext(); i++) {
            boolean next = it.nextBoolean();
            assertEquals(values[i], next);
        }
    }

    public void testToValueArrayInsert() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        boolean[] array = new boolean[2];
        try {
            plist.toBooleanArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        boolean[] values = plist.toBooleanArray();
        
        // array null
        boolean[] result = plist.toBooleanArray(null, 1);
        assertEquals(false, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new boolean[1];
        array[0] = false;
        result = plist.toBooleanArray(array, 1);
        assertEquals(false, array[0]);
        assertEquals(plist.size() + 1, result.length);
        assertEquals(false, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new boolean[values.length + 2];
        Arrays.fill(array, false);
        result = plist.toBooleanArray(array, 1);
        assertSame(array, result);
        assertEquals(false, array[0]);
        assertEquals(false, array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }

    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        assertEquals(true, plist.containsAll((boolean[]) null));
    }

    public void testAddAllArray() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        plist.addAll((boolean[]) null);
        verify();
    }

    public void testAddAllArrayIndexed() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        plist.addAll(0, (boolean[]) null);
        verify();
    }

    public void testRemoveAllArray() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        plist.removeAll((boolean[]) null);
        verify();
    }

    public void testRetainAllArray() {
        resetFull();
        BooleanList plist = (BooleanList) collection;
        plist.retainAll((boolean[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testFirstBoolean_empty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        try {
            plist.firstBoolean();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testFirstBoolean_notEmpty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        plist.add(false);
        plist.add(true);
        assertEquals(false, plist.firstBoolean());
    }

    public void testLastBoolean_empty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        try {
            plist.lastBoolean();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testLastBoolean_notEmpty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        plist.add(false);
        plist.add(true);
        assertEquals(true, plist.lastBoolean());
    }

    //-----------------------------------------------------------------------
    public void testFirst_empty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        assertNull(plist.first());
    }

    public void testFirst_notEmpty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        plist.add(false);
        plist.add(true);
        assertEquals((false ? Boolean.TRUE : Boolean.FALSE), plist.first());
    }

    public void testLast_empty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        assertNull(plist.last());
    }

    public void testLast_notEmpty() {
        resetEmpty();
        BooleanList plist = (BooleanList) collection;
        plist.add(false);
        plist.add(true);
        assertEquals((true ? Boolean.TRUE : Boolean.FALSE), plist.last());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        BooleanList coll = (BooleanList) collection;
        if (isCloneSupported()) {
            BooleanList coll2 = (BooleanList) coll.clone();
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
