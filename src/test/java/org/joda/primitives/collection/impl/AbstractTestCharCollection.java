/*
 *  Copyright 2001-present Stephen Colebourne
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
import org.joda.primitives.CharUtils;
import org.joda.primitives.collection.CharCollection;
import org.joda.primitives.iterator.CharIterator;

/**
 * Abstract base class for testing AbstractCharCollection subclasses.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestCharCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestCharCollection(String name) {
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

    public Collection<Character> makeConfirmedCollection() {
        return new ArrayList<Character>();
    }

    public Collection<Character> makeConfirmedFullCollection() {
        List<Character> list = new ArrayList<Character>();
        list.addAll(Arrays.asList(getFullNonNullElements()));
        return list;
    }

    public Character[] getFullNonNullElements() {
        return new Character[] {
            new Character((char)2),new Character('a'),new Character('@'),new Character('Z'),new Character((char)5000),new Character((char)202),new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)
        };
    }
    
    public Character[] getOtherNonNullElements() {
        return new Character[] {
            new Character('S'),new Character('J'),new Character('C')
        };
    }
    
    public void testIsModifiable() {
        CharCollection ic = (CharCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        CharCollection ic = (CharCollection) makeFullCollection();
        char[] values = ic.toCharArray();
        int i = 0;
        for (CharIterator it = ic.iterator(); it.hasNext(); i++) {
            char next = it.nextChar();
            assertEquals(values[i], next);
        }
    }
    
    public void testToValueArrayEmpty() {
        CharCollection ic = (CharCollection) makeFullCollection();
        ic.clear();
        char[] values = ic.toCharArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        CharCollection ic = (CharCollection) makeFullCollection();
        char[] array = new char[2];
        try {
            ic.toCharArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        char[] values = ic.toCharArray();
        
        // array null
        char[] result = ic.toCharArray(null, 1);
        assertEquals((char) 0, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new char[2];
        array[0] = 'Z';
        array[1] = 'A';
        result = ic.toCharArray(array, 1);
        assertEquals('Z', array[0]);
        assertEquals('A', array[1]);
        assertEquals(ic.size() + 1, result.length);
        assertEquals('Z', result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new char[values.length + 2];
        Arrays.fill(array, 'Z');
        result = ic.toCharArray(array, 1);
        assertSame(array, result);
        assertEquals('Z', array[0]);
        assertEquals('Z', array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }
    
    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        assertEquals(true, coll.containsAll((char[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        CharCollection clone = (CharCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator<Character> it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((CharCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAllRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        coll.add((char) 2);
        coll.add((char) 3);
        coll.add((char) 4);
        coll.add((char) 5);
        assertEquals(false, coll.containsAll((char) 0, (char) 1));
        assertEquals(false, coll.containsAll((char) 6, (char) 7));
        
        assertEquals(true, coll.containsAll((char) 3, (char) 4));
        assertEquals(true, coll.containsAll((char) 3, (char) 5));
        assertEquals(false, coll.containsAll((char) 3, (char) 6));
        assertEquals(true, coll.containsAll((char) 2, (char) 4));
        assertEquals(true, coll.containsAll((char) 2, (char) 5));
        assertEquals(false, coll.containsAll((char) 2, (char) 6));
        assertEquals(false, coll.containsAll((char) 1, (char) 4));
        assertEquals(false, coll.containsAll((char) 1, (char) 5));
        assertEquals(false, coll.containsAll((char) 1, (char) 6));
        
        assertEquals(true, coll.containsAll((char) 4, (char) 3));
        assertEquals(true, coll.containsAll((char) 5, (char) 3));
        assertEquals(true, coll.containsAll((char) 6, (char) 3));
        assertEquals(true, coll.containsAll((char) 4, (char) 2));
        assertEquals(true, coll.containsAll((char) 5, (char) 2));
        assertEquals(true, coll.containsAll((char) 6, (char) 2));
        assertEquals(true, coll.containsAll((char) 4, (char) 1));
        assertEquals(true, coll.containsAll((char) 5, (char) 1));
        assertEquals(true, coll.containsAll((char) 6, (char) 1));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        assertEquals(false, coll.containsAny((char[]) null));
        assertEquals(false, coll.containsAny(new char[0]));
        assertEquals(true, coll.containsAny(new char[] {CharUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new char[] {CharUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        CharCollection clone = (CharCollection) coll.clone();
        
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        Iterator<Character> it = clone.iterator();
        Character obj = it.next();
        clone.clear();
        clone.add(obj);
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        coll.remove(obj);
        assertEquals(false, coll.containsAny(clone));
        assertEquals(false, clone.containsAny(coll));
        
        assertEquals(false, coll.containsAny((CharCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    public void testContainsAnyRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        coll.add((char) 2);
        coll.add((char) 3);
        coll.add((char) 4);
        coll.add((char) 5);
        assertEquals(false, coll.containsAny((char) 0, (char) 1));
        assertEquals(false, coll.containsAny((char) 6, (char) 7));
        
        assertEquals(true, coll.containsAny((char) 3, (char) 4));
        assertEquals(true, coll.containsAny((char) 3, (char) 5));
        assertEquals(true, coll.containsAny((char) 3, (char) 6));
        assertEquals(true, coll.containsAny((char) 2, (char) 4));
        assertEquals(true, coll.containsAny((char) 2, (char) 5));
        assertEquals(true, coll.containsAny((char) 2, (char) 6));
        assertEquals(true, coll.containsAny((char) 1, (char) 4));
        assertEquals(true, coll.containsAny((char) 1, (char) 5));
        assertEquals(true, coll.containsAny((char) 1, (char) 6));
        
        assertEquals(false, coll.containsAny((char) 4, (char) 3));
        assertEquals(false, coll.containsAny((char) 5, (char) 3));
        assertEquals(false, coll.containsAny((char) 6, (char) 3));
        assertEquals(false, coll.containsAny((char) 4, (char) 2));
        assertEquals(false, coll.containsAny((char) 5, (char) 2));
        assertEquals(false, coll.containsAny((char) 6, (char) 2));
        assertEquals(false, coll.containsAny((char) 4, (char) 1));
        assertEquals(false, coll.containsAny((char) 5, (char) 1));
        assertEquals(false, coll.containsAny((char) 6, (char) 1));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        coll.addAll((char[]) null);
        verify();
    }

    public void testAddAllRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((char) 2, (char) 5);
        assertEquals(4, coll.size());
        assertEquals(true, coll.contains((char) 2));
        assertEquals(true, coll.contains((char) 3));
        assertEquals(true, coll.contains((char) 4));
        assertEquals(true, coll.contains((char) 5));
    }

    public void testAddAllReverseRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        assertEquals(0, coll.size());
        coll.addAll((char) 5, (char) 2);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        char first = coll.iterator().nextChar();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        coll.removeAll((char[]) null);
        verify();
    }

    public void testRemoveAllRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        coll.addAll((char) 2, (char) 6);
        
        coll.removeAll((char) 3, (char) 5);
        assertEquals(2, coll.size());
        assertEquals(true, coll.contains((char) 2));
        assertEquals(true, coll.contains((char) 6));
    }

    public void testRemoveAllReverseRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        coll.addAll((char) 2, (char) 6);
        
        coll.removeAll((char) 4, (char) 3);
        assertEquals(5, coll.size());
        assertEquals(true, coll.contains((char) 2));
        assertEquals(true, coll.contains((char) 3));
        assertEquals(true, coll.contains((char) 4));
        assertEquals(true, coll.contains((char) 5));
        assertEquals(true, coll.contains((char) 6));
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        coll.retainAll((char[]) null);
        confirmed.clear();
        verify();
    }

    public void testRetainAllRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        coll.addAll((char) 2, (char) 6);
        
        coll.retainAll((char) 3, (char) 5);
        assertEquals(3, coll.size());
        assertEquals(true, coll.contains((char) 3));
        assertEquals(true, coll.contains((char) 4));
        assertEquals(true, coll.contains((char) 5));
    }

    public void testRetainAllReverseRange() {
        resetEmpty();
        CharCollection coll = (CharCollection) collection;
        coll.addAll((char) 2, (char) 6);
        
        coll.retainAll((char) 4, (char) 3);
        assertEquals(0, coll.size());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        CharCollection coll = (CharCollection) collection;
        if (isCloneSupported()) {
            CharCollection coll2 = (CharCollection) coll.clone();
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
