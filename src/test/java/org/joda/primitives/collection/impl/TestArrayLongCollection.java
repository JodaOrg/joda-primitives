/*
 *  Copyright 2001-2010 Stephen Colebourne, Jason Tiscione
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
 * Test ArrayLongCollection.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayLongCollection extends AbstractTestLongCollection {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayLongCollection(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayLongCollection.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public Collection<Long> makeCollection() {
        return new ArrayLongCollection();
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
        ArrayLongCollection c = new ArrayLongCollection();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayLongCollection c = new ArrayLongCollection(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayLongCollection(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayLongCollection(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_longarray() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ArrayLongCollection c = new ArrayLongCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toLongArray(), a));
        
        c = new ArrayLongCollection((long[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayLongCollection c = new ArrayLongCollection((Collection<Long>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Long> coll = new ArrayList<Long>();
        coll.add(new Long(0L));
        c = new ArrayLongCollection(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(0L, c.iterator().nextLong());
        
        ArrayLongCollection c2 = new ArrayLongCollection(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(0L, c2.iterator().nextLong());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testConstructor_Iterator() throws Exception {
        ArrayLongCollection c = new ArrayLongCollection((Iterator<Long>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Long> coll = new ArrayList<Long>();
        coll.add(new Long(0L));
        c = new ArrayLongCollection(coll.iterator());
        assertEquals(1, c.size());
        assertEquals(4, dataLength(c));
        assertEquals(0L, c.iterator().nextLong());
        
        ArrayLongCollection c2 = new ArrayLongCollection(c.iterator());
        assertEquals(1, c2.size());
        assertEquals(4, dataLength(c2));
        assertEquals(0L, c2.iterator().nextLong());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ArrayLongCollection c = new ArrayLongCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeFirst(6L);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0L));
        assertEquals(true, c.contains(2L));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0L));
        assertEquals(true, c.contains(2L));
    }

    public void testEnsureCapacity() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ArrayLongCollection c = new ArrayLongCollection(a);
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
