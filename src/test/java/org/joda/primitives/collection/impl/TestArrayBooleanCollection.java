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

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Test ArrayBooleanCollection.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
@SuppressWarnings("unused")
public class TestArrayBooleanCollection extends AbstractTestBooleanCollection {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayBooleanCollection(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayBooleanCollection.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public Collection<Boolean> makeCollection() {
        return new ArrayBooleanCollection();
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
        ArrayBooleanCollection c = new ArrayBooleanCollection();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayBooleanCollection c = new ArrayBooleanCollection(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayBooleanCollection(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayBooleanCollection(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_booleanarray() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanCollection c = new ArrayBooleanCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toBooleanArray(), a));
        
        c = new ArrayBooleanCollection((boolean[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayBooleanCollection c = new ArrayBooleanCollection((Collection<Boolean>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Boolean> coll = new ArrayList<Boolean>();
        coll.add((false ? Boolean.TRUE : Boolean.FALSE));
        c = new ArrayBooleanCollection(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(false, c.iterator().nextBoolean());
        
        ArrayBooleanCollection c2 = new ArrayBooleanCollection(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(false, c2.iterator().nextBoolean());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testConstructor_Iterator() throws Exception {
        ArrayBooleanCollection c = new ArrayBooleanCollection((Iterator<Boolean>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Boolean> coll = new ArrayList<Boolean>();
        coll.add((false ? Boolean.TRUE : Boolean.FALSE));
        c = new ArrayBooleanCollection(coll.iterator());
        assertEquals(1, c.size());
        assertEquals(4, dataLength(c));
        assertEquals(false, c.iterator().nextBoolean());
        
        ArrayBooleanCollection c2 = new ArrayBooleanCollection(c.iterator());
        assertEquals(1, c2.size());
        assertEquals(4, dataLength(c2));
        assertEquals(false, c2.iterator().nextBoolean());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanCollection c = new ArrayBooleanCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeFirst(true);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(false));
        assertEquals(true, c.contains(false));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(false));
        assertEquals(true, c.contains(false));
    }

    public void testEnsureCapacity() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanCollection c = new ArrayBooleanCollection(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(5);
        assertEquals(7, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

}
