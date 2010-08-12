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
import org.joda.primitives.ShortUtils;
import org.joda.primitives.collection.ShortCollection;
import org.joda.primitives.iterator.ShortIterator;

/**
 * Abstract base class for testing AbstractShortCollection subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestShortCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestShortCollection(String name) {
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

    public Collection<Short> makeConfirmedCollection() {
        return new ArrayList<Short>();
    }

    public Collection<Short> makeConfirmedFullCollection() {
        List<Short> list = new ArrayList<Short>();
        list.addAll(Arrays.asList(getFullNonNullElements()));
        return list;
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
        ShortCollection ic = (ShortCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        ShortCollection ic = (ShortCollection) makeFullCollection();
        short[] values = ic.toShortArray();
        int i = 0;
        for (ShortIterator it = ic.iterator(); it.hasNext(); i++) {
            short next = it.nextShort();
            assertEquals(values[i], next);
        }
    }
    
    public void testToValueArrayEmpty() {
        ShortCollection ic = (ShortCollection) makeFullCollection();
        ic.clear();
        short[] values = ic.toShortArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        ShortCollection ic = (ShortCollection) makeFullCollection();
        short[] array = new short[2];
        try {
            ic.toShortArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        short[] values = ic.toShortArray();
        
        // array null
        short[] result = ic.toShortArray(null, 1);
        assertEquals((short) 0, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new short[2];
        array[0] = (short) 2;
        array[1] = (short) 6;
        result = ic.toShortArray(array, 1);
        assertEquals((short) 2, array[0]);
        assertEquals((short) 6, array[1]);
        assertEquals(ic.size() + 1, result.length);
        assertEquals((short) 2, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new short[values.length + 2];
        Arrays.fill(array, (short) 2);
        result = ic.toShortArray(array, 1);
        assertSame(array, result);
        assertEquals((short) 2, array[0]);
        assertEquals((short) 2, array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }
    
    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        assertEquals(true, coll.containsAll((short[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        ShortCollection clone = (ShortCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator<Short> it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((ShortCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAllRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        coll.add((short) 2);
        coll.add((short) 3);
        coll.add((short) 4);
        coll.add((short) 5);
        assertEquals(false, coll.containsAll((short) 0, (short) 1));
        assertEquals(false, coll.containsAll((short) 6, (short) 7));
        
        assertEquals(true, coll.containsAll((short) 3, (short) 4));
        assertEquals(true, coll.containsAll((short) 3, (short) 5));
        assertEquals(false, coll.containsAll((short) 3, (short) 6));
        assertEquals(true, coll.containsAll((short) 2, (short) 4));
        assertEquals(true, coll.containsAll((short) 2, (short) 5));
        assertEquals(false, coll.containsAll((short) 2, (short) 6));
        assertEquals(false, coll.containsAll((short) 1, (short) 4));
        assertEquals(false, coll.containsAll((short) 1, (short) 5));
        assertEquals(false, coll.containsAll((short) 1, (short) 6));
        
        assertEquals(true, coll.containsAll((short) 4, (short) 3));
        assertEquals(true, coll.containsAll((short) 5, (short) 3));
        assertEquals(true, coll.containsAll((short) 6, (short) 3));
        assertEquals(true, coll.containsAll((short) 4, (short) 2));
        assertEquals(true, coll.containsAll((short) 5, (short) 2));
        assertEquals(true, coll.containsAll((short) 6, (short) 2));
        assertEquals(true, coll.containsAll((short) 4, (short) 1));
        assertEquals(true, coll.containsAll((short) 5, (short) 1));
        assertEquals(true, coll.containsAll((short) 6, (short) 1));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        assertEquals(false, coll.containsAny((short[]) null));
        assertEquals(false, coll.containsAny(new short[0]));
        assertEquals(true, coll.containsAny(new short[] {ShortUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new short[] {ShortUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        ShortCollection clone = (ShortCollection) coll.clone();
        
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        Iterator<Short> it = clone.iterator();
        Short obj = it.next();
        clone.clear();
        clone.add(obj);
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        coll.remove(obj);
        assertEquals(false, coll.containsAny(clone));
        assertEquals(false, clone.containsAny(coll));
        
        assertEquals(false, coll.containsAny((ShortCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAnyRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        coll.add((short) 2);
        coll.add((short) 3);
        coll.add((short) 4);
        coll.add((short) 5);
        assertEquals(false, coll.containsAny((short) 0, (short) 1));
        assertEquals(false, coll.containsAny((short) 6, (short) 7));
        
        assertEquals(true, coll.containsAny((short) 3, (short) 4));
        assertEquals(true, coll.containsAny((short) 3, (short) 5));
        assertEquals(true, coll.containsAny((short) 3, (short) 6));
        assertEquals(true, coll.containsAny((short) 2, (short) 4));
        assertEquals(true, coll.containsAny((short) 2, (short) 5));
        assertEquals(true, coll.containsAny((short) 2, (short) 6));
        assertEquals(true, coll.containsAny((short) 1, (short) 4));
        assertEquals(true, coll.containsAny((short) 1, (short) 5));
        assertEquals(true, coll.containsAny((short) 1, (short) 6));
        
        assertEquals(false, coll.containsAny((short) 4, (short) 3));
        assertEquals(false, coll.containsAny((short) 5, (short) 3));
        assertEquals(false, coll.containsAny((short) 6, (short) 3));
        assertEquals(false, coll.containsAny((short) 4, (short) 2));
        assertEquals(false, coll.containsAny((short) 5, (short) 2));
        assertEquals(false, coll.containsAny((short) 6, (short) 2));
        assertEquals(false, coll.containsAny((short) 4, (short) 1));
        assertEquals(false, coll.containsAny((short) 5, (short) 1));
        assertEquals(false, coll.containsAny((short) 6, (short) 1));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        coll.addAll((short[]) null);
        verify();
    }

    public void testAddAllRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((short) 2, (short) 5);
        assertEquals(4, coll.size());
        assertEquals(true, coll.contains((short) 2));
        assertEquals(true, coll.contains((short) 3));
        assertEquals(true, coll.contains((short) 4));
        assertEquals(true, coll.contains((short) 5));
    }

    public void testAddAllReverseRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((short) 5, (short) 2);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        short first = coll.iterator().nextShort();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        coll.removeAll((short[]) null);
        verify();
    }

    public void testRemoveAllRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        coll.addAll((short) 2, (short) 6);
        
        coll.removeAll((short) 3, (short) 5);
        assertEquals(2, coll.size());
        assertEquals(true, coll.contains((short) 2));
        assertEquals(true, coll.contains((short) 6));
    }

    public void testRemoveAllReverseRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        coll.addAll((short) 2, (short) 6);
        
        coll.removeAll((short) 4, (short) 3);
        assertEquals(5, coll.size());
        assertEquals(true, coll.contains((short) 2));
        assertEquals(true, coll.contains((short) 3));
        assertEquals(true, coll.contains((short) 4));
        assertEquals(true, coll.contains((short) 5));
        assertEquals(true, coll.contains((short) 6));
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        coll.retainAll((short[]) null);
        confirmed.clear();
        verify();
    }

    public void testRetainAllRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        coll.addAll((short) 2, (short) 6);
        
        coll.retainAll((short) 3, (short) 5);
        assertEquals(3, coll.size());
        assertEquals(true, coll.contains((short) 3));
        assertEquals(true, coll.contains((short) 4));
        assertEquals(true, coll.contains((short) 5));
    }

    public void testRetainAllReverseRange() {
        resetEmpty();
        ShortCollection coll = (ShortCollection) collection;
        coll.addAll((short) 2, (short) 6);
        
        coll.retainAll((short) 4, (short) 3);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        ShortCollection coll = (ShortCollection) collection;
        if (isCloneSupported()) {
            ShortCollection coll2 = (ShortCollection) coll.clone();
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
