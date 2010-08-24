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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.joda.primitives.CharUtils;
import org.joda.primitives.iterator.CharIterator;
import org.joda.primitives.list.CharList;

/**
 * Tests for ImmutableArrayCharList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayCharList extends AbstractTestCharList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayCharList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayCharList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public boolean isAddSupported() {
        return false;
    }

    public boolean isRemoveSupported() {
        return false;
    }

    public boolean isSetSupported() {
        return false;
    }

    public List<Character> makeEmptyList() {
        return ImmutableArrayCharList.empty();
    }

    public List<Character> makeFullList() {
        char[] a = new char[] {new Character((char)2),new Character('a'),new Character('@'),new Character('Z'),new Character((char)5000),new Character((char)202),new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)};
        return ImmutableArrayCharList.copyOf(a);
    }

    public List<Character> makeConfirmedFullCollection() {
        char[] a = new char[] {new Character((char)2),new Character('a'),new Character('@'),new Character('Z'),new Character((char)5000),new Character((char)202),new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)};
        return ImmutableArrayCharList.copyOf(a);
    }

    public Object[] getFullElements() {
        char[] a = new char[] {new Character((char)2),new Character('a'),new Character('@'),new Character('Z'),new Character((char)5000),new Character((char)202),new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = CharUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add((char) 0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, (char) 0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayCharList c = ImmutableArrayCharList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        char[] a = new char[] {new Character((char)2),new Character('a'),new Character('@'),new Character('Z'),new Character((char)5000),new Character((char)202),new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)};
        ImmutableArrayCharList c = ImmutableArrayCharList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toCharArray(), a));
        
        c = ImmutableArrayCharList.copyOf((char[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayCharList c = ImmutableArrayCharList.copyOf((Collection<Character>) null);
        assertEquals(0, c.size());
        
        Collection<Character> coll = new ArrayList<Character>();
        coll.add((char) 0);
        c = ImmutableArrayCharList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals((char) 0, c.iterator().nextChar());
        
        ImmutableArrayCharList c2 = ImmutableArrayCharList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        char[] a = new char[] {new Character((char)2),new Character('a'),new Character('@'),new Character('Z'),new Character((char)5000),new Character((char)202),new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)};
        ImmutableArrayCharList c = ImmutableArrayCharList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ImmutableArrayCharList c = ImmutableArrayCharList.copyOf(a);
        
        CharIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals((char) 0, it.nextChar());
        assertEquals('A', it.nextChar());
        it.reset();
        assertEquals((char) 0, it.nextChar());
        assertEquals('A', it.nextChar());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        CharList coll = (CharList) collection;
        CharList coll2 = (CharList) coll.clone();
        assertTrue(coll == coll2);
    }

}
