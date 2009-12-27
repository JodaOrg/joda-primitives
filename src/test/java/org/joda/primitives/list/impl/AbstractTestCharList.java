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
package org.joda.primitives.list.impl;

import java.util.Arrays;

import org.apache.commons.collections.list.AbstractTestList;
import org.joda.primitives.list.CharList;
import org.joda.primitives.iterator.CharIterator;

/**
 * Abstract base class for testing AbstractCharList subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestCharList extends AbstractTestList {
    // This file is CODE GENERATED. Do not change manually.

    public AbstractTestCharList(String name) {
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
        resetFull();
        CharList plist = (CharList) collection;
        assertEquals(isAddSupported() || isRemoveSupported() || isSetSupported(), plist.isModifiable());
    }

    public void testToValueArray() {
        resetFull();
        CharList plist = (CharList) collection;
        char[] values = plist.toCharArray();
        int i = 0;
        for (CharIterator it = plist.charIterator(); it.hasNext(); i++) {
            char next = it.nextChar();
            assertEquals(values[i], next);
        }
    }

    public void testToValueArrayInsert() {
        resetFull();
        CharList plist = (CharList) collection;
        char[] array = new char[2];
        try {
            plist.toCharArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        char[] values = plist.toCharArray();
        
        // array null
        char[] result = plist.toCharArray(null, 1);
        assertEquals((char) 0, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new char[2];
        array[0] = 'Z';
        array[1] = 'A';
        result = plist.toCharArray(array, 1);
        assertEquals('Z', array[0]);
        assertEquals('A', array[1]);
        assertEquals(plist.size() + 1, result.length);
        assertEquals('Z', result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new char[values.length + 2];
        Arrays.fill(array, 'Z');
        result = plist.toCharArray(array, 1);
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
        CharList plist = (CharList) collection;
        assertEquals(true, plist.containsAll((char[]) null));
    }

    public void testAddAllArray() {
        resetFull();
        CharList plist = (CharList) collection;
        plist.addAll((char[]) null);
        verify();
    }

    public void testAddAllArrayIndexed() {
        resetFull();
        CharList plist = (CharList) collection;
        plist.addAll(0, (char[]) null);
        verify();
    }

    public void testRemoveAllArray() {
        resetFull();
        CharList plist = (CharList) collection;
        plist.removeAll((char[]) null);
        verify();
    }

    public void testRetainAllArray() {
        resetFull();
        CharList plist = (CharList) collection;
        plist.retainAll((char[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testToStringContents() {
        resetEmpty();
        CharList plist = (CharList) collection;
        plist.add('a');
        plist.add('b');
        plist.add('c');
        assertEquals("abc", plist.toStringContents());
    }

    //-----------------------------------------------------------------------
    public void testFirstChar_empty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        try {
            plist.firstChar();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testFirstChar_notEmpty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        plist.add((char) 0);
        plist.add('A');
        assertEquals((char) 0, plist.firstChar());
    }

    public void testLastChar_empty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        try {
            plist.lastChar();
            fail();
        } catch (IndexOutOfBoundsException ex) {
            // expected
        }
    }

    public void testLastChar_notEmpty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        plist.add((char) 0);
        plist.add('A');
        assertEquals('A', plist.lastChar());
    }

    //-----------------------------------------------------------------------
    public void testFirst_empty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        assertNull(plist.first());
    }

    public void testFirst_notEmpty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        plist.add((char) 0);
        plist.add('A');
        assertEquals(new Character((char) 0), plist.first());
    }

    public void testLast_empty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        assertNull(plist.last());
    }

    public void testLast_notEmpty() {
        resetEmpty();
        CharList plist = (CharList) collection;
        plist.add((char) 0);
        plist.add('A');
        assertEquals(new Character('A'), plist.last());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        CharList coll = (CharList) collection;
        if (isCloneSupported()) {
            CharList coll2 = (CharList) coll.clone();
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
