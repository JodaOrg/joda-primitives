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

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.joda.primitives.iterator.CharIterator;

/**
 * Tests for ArrayCharList.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayCharList extends AbstractTestCharList {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayCharList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayCharList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public List<Character> makeEmptyList() {
        return new ArrayCharList();
    }

    //-----------------------------------------------------------------------
    protected int dataLength(Object obj) throws Exception {
        Field field = obj.getClass().getDeclaredField("data");
        field.setAccessible(true);
        Object value = field.get(obj);
        return Array.getLength(value);
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ArrayCharList c = new ArrayCharList();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayCharList c = new ArrayCharList(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayCharList(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayCharList(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_chararray() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharList c = new ArrayCharList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toCharArray(), a));
        
        c = new ArrayCharList((char[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayCharList c = new ArrayCharList((Collection<Character>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Character> coll = new ArrayList<Character>();
        coll.add(new Character((char) 0));
        c = new ArrayCharList(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals((char) 0, c.iterator().nextChar());
        
        ArrayCharList c2 = new ArrayCharList(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals((char) 0, c2.iterator().nextChar());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharList c = new ArrayCharList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeChar('A');
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((char) 0));
        assertEquals(true, c.contains('Z'));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((char) 0));
        assertEquals(true, c.contains('Z'));
    }

    public void testEnsureCapacity() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharList c = new ArrayCharList(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

    public void testIteratorIsModifiable() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharList c = new ArrayCharList(a);
        
        assertEquals(true, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        char[] a = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharList c = new ArrayCharList(a);
        
        CharIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals((char) 0, it.nextChar());
        assertEquals('A', it.nextChar());
        it.reset();
        assertEquals((char) 0, it.nextChar());
        assertEquals('A', it.nextChar());
    }

}
