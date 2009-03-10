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
import org.joda.primitives.LongUtils;
import org.joda.primitives.collection.LongCollection;
import org.joda.primitives.iterator.LongIterator;

/**
 * Abstract base class for testing AbstractLongCollection subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestLongCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestLongCollection(String name) {
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
            new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)
        };
    }
    
    public Object[] getOtherNonNullElements() {
        return new Object[] {
            new Long(-33),new Long(66),new Long(-99)
        };
    }
    
    public void testIsModifiable() {
        LongCollection ic = (LongCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        LongCollection ic = (LongCollection) makeFullCollection();
        long[] values = ic.toLongArray();
        int i = 0;
        for (LongIterator it = ic.longIterator(); it.hasNext(); i++) {
            long next = it.nextLong();
            assertEquals(values[i], next);
        }
    }
    
    public void testToValueArrayEmpty() {
        LongCollection ic = (LongCollection) makeFullCollection();
        ic.clear();
        long[] values = ic.toLongArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        LongCollection ic = (LongCollection) makeFullCollection();
        long[] array = new long[2];
        try {
            ic.toLongArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        long[] values = ic.toLongArray();
        
        // array null
        long[] result = ic.toLongArray(null, 1);
        assertEquals(0L, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new long[2];
        array[0] = 2L;
        array[1] = 6L;
        result = ic.toLongArray(array, 1);
        assertEquals(2L, array[0]);
        assertEquals(6L, array[1]);
        assertEquals(ic.size() + 1, result.length);
        assertEquals(2L, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new long[values.length + 2];
        Arrays.fill(array, 2L);
        result = ic.toLongArray(array, 1);
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
        LongCollection coll = (LongCollection) collection;
        assertEquals(true, coll.containsAll((long[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        LongCollection clone = (LongCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((LongCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAllRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        coll.add((long) 2);
        coll.add((long) 3);
        coll.add((long) 4);
        coll.add((long) 5);
        assertEquals(false, coll.containsAll((long) 0, (long) 1));
        assertEquals(false, coll.containsAll((long) 6, (long) 7));
        
        assertEquals(true, coll.containsAll((long) 3, (long) 4));
        assertEquals(true, coll.containsAll((long) 3, (long) 5));
        assertEquals(false, coll.containsAll((long) 3, (long) 6));
        assertEquals(true, coll.containsAll((long) 2, (long) 4));
        assertEquals(true, coll.containsAll((long) 2, (long) 5));
        assertEquals(false, coll.containsAll((long) 2, (long) 6));
        assertEquals(false, coll.containsAll((long) 1, (long) 4));
        assertEquals(false, coll.containsAll((long) 1, (long) 5));
        assertEquals(false, coll.containsAll((long) 1, (long) 6));
        
        assertEquals(true, coll.containsAll((long) 4, (long) 3));
        assertEquals(true, coll.containsAll((long) 5, (long) 3));
        assertEquals(true, coll.containsAll((long) 6, (long) 3));
        assertEquals(true, coll.containsAll((long) 4, (long) 2));
        assertEquals(true, coll.containsAll((long) 5, (long) 2));
        assertEquals(true, coll.containsAll((long) 6, (long) 2));
        assertEquals(true, coll.containsAll((long) 4, (long) 1));
        assertEquals(true, coll.containsAll((long) 5, (long) 1));
        assertEquals(true, coll.containsAll((long) 6, (long) 1));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        assertEquals(false, coll.containsAny((long[]) null));
        assertEquals(false, coll.containsAny(new long[0]));
        assertEquals(true, coll.containsAny(new long[] {LongUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new long[] {LongUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        LongCollection clone = (LongCollection) coll.clone();
        
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
        
        assertEquals(false, coll.containsAny((LongCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAnyRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        coll.add((long) 2);
        coll.add((long) 3);
        coll.add((long) 4);
        coll.add((long) 5);
        assertEquals(false, coll.containsAny((long) 0, (long) 1));
        assertEquals(false, coll.containsAny((long) 6, (long) 7));
        
        assertEquals(true, coll.containsAny((long) 3, (long) 4));
        assertEquals(true, coll.containsAny((long) 3, (long) 5));
        assertEquals(true, coll.containsAny((long) 3, (long) 6));
        assertEquals(true, coll.containsAny((long) 2, (long) 4));
        assertEquals(true, coll.containsAny((long) 2, (long) 5));
        assertEquals(true, coll.containsAny((long) 2, (long) 6));
        assertEquals(true, coll.containsAny((long) 1, (long) 4));
        assertEquals(true, coll.containsAny((long) 1, (long) 5));
        assertEquals(true, coll.containsAny((long) 1, (long) 6));
        
        assertEquals(false, coll.containsAny((long) 4, (long) 3));
        assertEquals(false, coll.containsAny((long) 5, (long) 3));
        assertEquals(false, coll.containsAny((long) 6, (long) 3));
        assertEquals(false, coll.containsAny((long) 4, (long) 2));
        assertEquals(false, coll.containsAny((long) 5, (long) 2));
        assertEquals(false, coll.containsAny((long) 6, (long) 2));
        assertEquals(false, coll.containsAny((long) 4, (long) 1));
        assertEquals(false, coll.containsAny((long) 5, (long) 1));
        assertEquals(false, coll.containsAny((long) 6, (long) 1));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        coll.addAll((long[]) null);
        verify();
    }

    public void testAddAllRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((long) 2, (long) 5);
        assertEquals(4, coll.size());
        assertEquals(true, coll.contains((long) 2));
        assertEquals(true, coll.contains((long) 3));
        assertEquals(true, coll.contains((long) 4));
        assertEquals(true, coll.contains((long) 5));
    }

    public void testAddAllReverseRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((long) 5, (long) 2);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        long first = coll.longIterator().nextLong();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        coll.removeAll((long[]) null);
        verify();
    }

    public void testRemoveAllRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        coll.addAll((long) 2, (long) 6);
        
        coll.removeAll((long) 3, (long) 5);
        assertEquals(2, coll.size());
        assertEquals(true, coll.contains((long) 2));
        assertEquals(true, coll.contains((long) 6));
    }

    public void testRemoveAllReverseRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        coll.addAll((long) 2, (long) 6);
        
        coll.removeAll((long) 4, (long) 3);
        assertEquals(5, coll.size());
        assertEquals(true, coll.contains((long) 2));
        assertEquals(true, coll.contains((long) 3));
        assertEquals(true, coll.contains((long) 4));
        assertEquals(true, coll.contains((long) 5));
        assertEquals(true, coll.contains((long) 6));
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        coll.retainAll((long[]) null);
        confirmed.clear();
        verify();
    }

    public void testRetainAllRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        coll.addAll((long) 2, (long) 6);
        
        coll.retainAll((long) 3, (long) 5);
        assertEquals(3, coll.size());
        assertEquals(true, coll.contains((long) 3));
        assertEquals(true, coll.contains((long) 4));
        assertEquals(true, coll.contains((long) 5));
    }

    public void testRetainAllReverseRange() {
        resetEmpty();
        LongCollection coll = (LongCollection) collection;
        coll.addAll((long) 2, (long) 6);
        
        coll.retainAll((long) 4, (long) 3);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        LongCollection coll = (LongCollection) collection;
        if (isCloneSupported()) {
            LongCollection coll2 = (LongCollection) coll.clone();
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
