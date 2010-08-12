/*
 *  Copyright 2001-2009 Stephen Colebourne, Jason Tiscione
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
import org.joda.primitives.IntUtils;
import org.joda.primitives.collection.IntCollection;
import org.joda.primitives.iterator.IntIterator;

/**
 * Abstract base class for testing AbstractIntCollection subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestIntCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestIntCollection(String name) {
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

    public Collection<Integer> makeConfirmedCollection() {
        return new ArrayList<Integer>();
    }

    public Collection<Integer> makeConfirmedFullCollection() {
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(getFullNonNullElements()));
        return list;
    }

    public Integer[] getFullNonNullElements() {
        return new Integer[] {
            new Integer(2),new Integer(-2),new Integer(38),new Integer(0),new Integer(10000),new Integer(202),new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)
        };
    }
    
    public Integer[] getOtherNonNullElements() {
        return new Integer[] {
            new Integer(-33),new Integer(66),new Integer(-99)
        };
    }
    
    public void testIsModifiable() {
        IntCollection ic = (IntCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        IntCollection ic = (IntCollection) makeFullCollection();
        int[] values = ic.toIntArray();
        int i = 0;
        for (IntIterator it = ic.iterator(); it.hasNext(); i++) {
            int next = it.nextInt();
            assertEquals(values[i], next);
        }
    }
    
    public void testToValueArrayEmpty() {
        IntCollection ic = (IntCollection) makeFullCollection();
        ic.clear();
        int[] values = ic.toIntArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        IntCollection ic = (IntCollection) makeFullCollection();
        int[] array = new int[2];
        try {
            ic.toIntArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        int[] values = ic.toIntArray();
        
        // array null
        int[] result = ic.toIntArray(null, 1);
        assertEquals(0, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new int[2];
        array[0] = 2;
        array[1] = 6;
        result = ic.toIntArray(array, 1);
        assertEquals(2, array[0]);
        assertEquals(6, array[1]);
        assertEquals(ic.size() + 1, result.length);
        assertEquals(2, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new int[values.length + 2];
        Arrays.fill(array, 2);
        result = ic.toIntArray(array, 1);
        assertSame(array, result);
        assertEquals(2, array[0]);
        assertEquals(2, array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }
    
    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        assertEquals(true, coll.containsAll((int[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        IntCollection clone = (IntCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator<Integer> it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((IntCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAllRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        coll.add((int) 2);
        coll.add((int) 3);
        coll.add((int) 4);
        coll.add((int) 5);
        assertEquals(false, coll.containsAll((int) 0, (int) 1));
        assertEquals(false, coll.containsAll((int) 6, (int) 7));
        
        assertEquals(true, coll.containsAll((int) 3, (int) 4));
        assertEquals(true, coll.containsAll((int) 3, (int) 5));
        assertEquals(false, coll.containsAll((int) 3, (int) 6));
        assertEquals(true, coll.containsAll((int) 2, (int) 4));
        assertEquals(true, coll.containsAll((int) 2, (int) 5));
        assertEquals(false, coll.containsAll((int) 2, (int) 6));
        assertEquals(false, coll.containsAll((int) 1, (int) 4));
        assertEquals(false, coll.containsAll((int) 1, (int) 5));
        assertEquals(false, coll.containsAll((int) 1, (int) 6));
        
        assertEquals(true, coll.containsAll((int) 4, (int) 3));
        assertEquals(true, coll.containsAll((int) 5, (int) 3));
        assertEquals(true, coll.containsAll((int) 6, (int) 3));
        assertEquals(true, coll.containsAll((int) 4, (int) 2));
        assertEquals(true, coll.containsAll((int) 5, (int) 2));
        assertEquals(true, coll.containsAll((int) 6, (int) 2));
        assertEquals(true, coll.containsAll((int) 4, (int) 1));
        assertEquals(true, coll.containsAll((int) 5, (int) 1));
        assertEquals(true, coll.containsAll((int) 6, (int) 1));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        assertEquals(false, coll.containsAny((int[]) null));
        assertEquals(false, coll.containsAny(new int[0]));
        assertEquals(true, coll.containsAny(new int[] {IntUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new int[] {IntUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        IntCollection clone = (IntCollection) coll.clone();
        
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        Iterator<Integer> it = clone.iterator();
        Integer obj = it.next();
        clone.clear();
        clone.add(obj);
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        coll.remove(obj);
        assertEquals(false, coll.containsAny(clone));
        assertEquals(false, clone.containsAny(coll));
        
        assertEquals(false, coll.containsAny((IntCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAnyRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        coll.add((int) 2);
        coll.add((int) 3);
        coll.add((int) 4);
        coll.add((int) 5);
        assertEquals(false, coll.containsAny((int) 0, (int) 1));
        assertEquals(false, coll.containsAny((int) 6, (int) 7));
        
        assertEquals(true, coll.containsAny((int) 3, (int) 4));
        assertEquals(true, coll.containsAny((int) 3, (int) 5));
        assertEquals(true, coll.containsAny((int) 3, (int) 6));
        assertEquals(true, coll.containsAny((int) 2, (int) 4));
        assertEquals(true, coll.containsAny((int) 2, (int) 5));
        assertEquals(true, coll.containsAny((int) 2, (int) 6));
        assertEquals(true, coll.containsAny((int) 1, (int) 4));
        assertEquals(true, coll.containsAny((int) 1, (int) 5));
        assertEquals(true, coll.containsAny((int) 1, (int) 6));
        
        assertEquals(false, coll.containsAny((int) 4, (int) 3));
        assertEquals(false, coll.containsAny((int) 5, (int) 3));
        assertEquals(false, coll.containsAny((int) 6, (int) 3));
        assertEquals(false, coll.containsAny((int) 4, (int) 2));
        assertEquals(false, coll.containsAny((int) 5, (int) 2));
        assertEquals(false, coll.containsAny((int) 6, (int) 2));
        assertEquals(false, coll.containsAny((int) 4, (int) 1));
        assertEquals(false, coll.containsAny((int) 5, (int) 1));
        assertEquals(false, coll.containsAny((int) 6, (int) 1));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        coll.addAll((int[]) null);
        verify();
    }

    public void testAddAllRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((int) 2, (int) 5);
        assertEquals(4, coll.size());
        assertEquals(true, coll.contains((int) 2));
        assertEquals(true, coll.contains((int) 3));
        assertEquals(true, coll.contains((int) 4));
        assertEquals(true, coll.contains((int) 5));
    }

    public void testAddAllReverseRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((int) 5, (int) 2);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        int first = coll.iterator().nextInt();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        coll.removeAll((int[]) null);
        verify();
    }

    public void testRemoveAllRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        coll.addAll((int) 2, (int) 6);
        
        coll.removeAll((int) 3, (int) 5);
        assertEquals(2, coll.size());
        assertEquals(true, coll.contains((int) 2));
        assertEquals(true, coll.contains((int) 6));
    }

    public void testRemoveAllReverseRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        coll.addAll((int) 2, (int) 6);
        
        coll.removeAll((int) 4, (int) 3);
        assertEquals(5, coll.size());
        assertEquals(true, coll.contains((int) 2));
        assertEquals(true, coll.contains((int) 3));
        assertEquals(true, coll.contains((int) 4));
        assertEquals(true, coll.contains((int) 5));
        assertEquals(true, coll.contains((int) 6));
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        coll.retainAll((int[]) null);
        confirmed.clear();
        verify();
    }

    public void testRetainAllRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        coll.addAll((int) 2, (int) 6);
        
        coll.retainAll((int) 3, (int) 5);
        assertEquals(3, coll.size());
        assertEquals(true, coll.contains((int) 3));
        assertEquals(true, coll.contains((int) 4));
        assertEquals(true, coll.contains((int) 5));
    }

    public void testRetainAllReverseRange() {
        resetEmpty();
        IntCollection coll = (IntCollection) collection;
        coll.addAll((int) 2, (int) 6);
        
        coll.retainAll((int) 4, (int) 3);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        IntCollection coll = (IntCollection) collection;
        if (isCloneSupported()) {
            IntCollection coll2 = (IntCollection) coll.clone();
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
