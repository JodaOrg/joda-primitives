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
package org.joda.primitives.collection.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.collection.AbstractTestCollection;
import org.joda.primitives.ByteUtils;
import org.joda.primitives.collection.ByteCollection;
import org.joda.primitives.iterator.ByteIterator;

/**
 * Abstract base class for testing AbstractByteCollection subclasses.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestByteCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestByteCollection(String name) {
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

    public Collection<Byte> makeConfirmedCollection() {
        return new ArrayList<Byte>();
    }

    public Collection<Byte> makeConfirmedFullCollection() {
        List<Byte> list = new ArrayList<Byte>();
        list.addAll(Arrays.asList(getFullNonNullElements()));
        return list;
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
        ByteCollection ic = (ByteCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        ByteCollection ic = (ByteCollection) makeFullCollection();
        byte[] values = ic.toByteArray();
        int i = 0;
        for (ByteIterator it = ic.iterator(); it.hasNext(); i++) {
            byte next = it.nextByte();
            assertEquals(values[i], next);
        }
    }
    
    public void testToValueArrayEmpty() {
        ByteCollection ic = (ByteCollection) makeFullCollection();
        ic.clear();
        byte[] values = ic.toByteArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        ByteCollection ic = (ByteCollection) makeFullCollection();
        byte[] array = new byte[2];
        try {
            ic.toByteArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        byte[] values = ic.toByteArray();
        
        // array null
        byte[] result = ic.toByteArray(null, 1);
        assertEquals((byte) 0, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new byte[2];
        array[0] = (byte) 2;
        array[1] = (byte) 6;
        result = ic.toByteArray(array, 1);
        assertEquals((byte) 2, array[0]);
        assertEquals((byte) 6, array[1]);
        assertEquals(ic.size() + 1, result.length);
        assertEquals((byte) 2, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new byte[values.length + 2];
        Arrays.fill(array, (byte) 2);
        result = ic.toByteArray(array, 1);
        assertSame(array, result);
        assertEquals((byte) 2, array[0]);
        assertEquals((byte) 2, array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }
    
    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        assertEquals(true, coll.containsAll((byte[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        ByteCollection clone = (ByteCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator<Byte> it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((ByteCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAllRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        coll.add((byte) 2);
        coll.add((byte) 3);
        coll.add((byte) 4);
        coll.add((byte) 5);
        assertEquals(false, coll.containsAll((byte) 0, (byte) 1));
        assertEquals(false, coll.containsAll((byte) 6, (byte) 7));
        
        assertEquals(true, coll.containsAll((byte) 3, (byte) 4));
        assertEquals(true, coll.containsAll((byte) 3, (byte) 5));
        assertEquals(false, coll.containsAll((byte) 3, (byte) 6));
        assertEquals(true, coll.containsAll((byte) 2, (byte) 4));
        assertEquals(true, coll.containsAll((byte) 2, (byte) 5));
        assertEquals(false, coll.containsAll((byte) 2, (byte) 6));
        assertEquals(false, coll.containsAll((byte) 1, (byte) 4));
        assertEquals(false, coll.containsAll((byte) 1, (byte) 5));
        assertEquals(false, coll.containsAll((byte) 1, (byte) 6));
        
        assertEquals(true, coll.containsAll((byte) 4, (byte) 3));
        assertEquals(true, coll.containsAll((byte) 5, (byte) 3));
        assertEquals(true, coll.containsAll((byte) 6, (byte) 3));
        assertEquals(true, coll.containsAll((byte) 4, (byte) 2));
        assertEquals(true, coll.containsAll((byte) 5, (byte) 2));
        assertEquals(true, coll.containsAll((byte) 6, (byte) 2));
        assertEquals(true, coll.containsAll((byte) 4, (byte) 1));
        assertEquals(true, coll.containsAll((byte) 5, (byte) 1));
        assertEquals(true, coll.containsAll((byte) 6, (byte) 1));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        assertEquals(false, coll.containsAny((byte[]) null));
        assertEquals(false, coll.containsAny(new byte[0]));
        assertEquals(true, coll.containsAny(new byte[] {ByteUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new byte[] {ByteUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        ByteCollection clone = (ByteCollection) coll.clone();
        
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        Iterator<Byte> it = clone.iterator();
        Byte obj = it.next();
        clone.clear();
        clone.add(obj);
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        coll.remove(obj);
        assertEquals(false, coll.containsAny(clone));
        assertEquals(false, clone.containsAny(coll));
        
        assertEquals(false, coll.containsAny((ByteCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAnyRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        coll.add((byte) 2);
        coll.add((byte) 3);
        coll.add((byte) 4);
        coll.add((byte) 5);
        assertEquals(false, coll.containsAny((byte) 0, (byte) 1));
        assertEquals(false, coll.containsAny((byte) 6, (byte) 7));
        
        assertEquals(true, coll.containsAny((byte) 3, (byte) 4));
        assertEquals(true, coll.containsAny((byte) 3, (byte) 5));
        assertEquals(true, coll.containsAny((byte) 3, (byte) 6));
        assertEquals(true, coll.containsAny((byte) 2, (byte) 4));
        assertEquals(true, coll.containsAny((byte) 2, (byte) 5));
        assertEquals(true, coll.containsAny((byte) 2, (byte) 6));
        assertEquals(true, coll.containsAny((byte) 1, (byte) 4));
        assertEquals(true, coll.containsAny((byte) 1, (byte) 5));
        assertEquals(true, coll.containsAny((byte) 1, (byte) 6));
        
        assertEquals(false, coll.containsAny((byte) 4, (byte) 3));
        assertEquals(false, coll.containsAny((byte) 5, (byte) 3));
        assertEquals(false, coll.containsAny((byte) 6, (byte) 3));
        assertEquals(false, coll.containsAny((byte) 4, (byte) 2));
        assertEquals(false, coll.containsAny((byte) 5, (byte) 2));
        assertEquals(false, coll.containsAny((byte) 6, (byte) 2));
        assertEquals(false, coll.containsAny((byte) 4, (byte) 1));
        assertEquals(false, coll.containsAny((byte) 5, (byte) 1));
        assertEquals(false, coll.containsAny((byte) 6, (byte) 1));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        coll.addAll((byte[]) null);
        verify();
    }

    public void testAddAllRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((byte) 2, (byte) 5);
        assertEquals(4, coll.size());
        assertEquals(true, coll.contains((byte) 2));
        assertEquals(true, coll.contains((byte) 3));
        assertEquals(true, coll.contains((byte) 4));
        assertEquals(true, coll.contains((byte) 5));
    }

    public void testAddAllReverseRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((byte) 5, (byte) 2);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        byte first = coll.iterator().nextByte();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        coll.removeAll((byte[]) null);
        verify();
    }

    public void testRemoveAllRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        coll.addAll((byte) 2, (byte) 6);
        
        coll.removeAll((byte) 3, (byte) 5);
        assertEquals(2, coll.size());
        assertEquals(true, coll.contains((byte) 2));
        assertEquals(true, coll.contains((byte) 6));
    }

    public void testRemoveAllReverseRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        coll.addAll((byte) 2, (byte) 6);
        
        coll.removeAll((byte) 4, (byte) 3);
        assertEquals(5, coll.size());
        assertEquals(true, coll.contains((byte) 2));
        assertEquals(true, coll.contains((byte) 3));
        assertEquals(true, coll.contains((byte) 4));
        assertEquals(true, coll.contains((byte) 5));
        assertEquals(true, coll.contains((byte) 6));
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        coll.retainAll((byte[]) null);
        confirmed.clear();
        verify();
    }

    public void testRetainAllRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        coll.addAll((byte) 2, (byte) 6);
        
        coll.retainAll((byte) 3, (byte) 5);
        assertEquals(3, coll.size());
        assertEquals(true, coll.contains((byte) 3));
        assertEquals(true, coll.contains((byte) 4));
        assertEquals(true, coll.contains((byte) 5));
    }

    public void testRetainAllReverseRange() {
        resetEmpty();
        ByteCollection coll = (ByteCollection) collection;
        coll.addAll((byte) 2, (byte) 6);
        
        coll.retainAll((byte) 4, (byte) 3);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        ByteCollection coll = (ByteCollection) collection;
        if (isCloneSupported()) {
            ByteCollection coll2 = (ByteCollection) coll.clone();
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
