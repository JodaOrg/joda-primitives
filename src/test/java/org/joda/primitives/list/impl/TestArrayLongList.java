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

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.joda.primitives.iterator.LongIterator;

/**
 * Tests for ArrayLongList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayLongList extends AbstractTestLongList {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayLongList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayLongList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public List<Long> makeEmptyList() {
        return new ArrayLongList();
    }

    //-----------------------------------------------------------------------
    protected int dataLength(Object obj) throws Exception {
        Field field = obj.getClass().getDeclaredField("iData");
        field.setAccessible(true);
        Object value = field.get(obj);
        return Array.getLength(value);
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ArrayLongList c = new ArrayLongList();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayLongList c = new ArrayLongList(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayLongList(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayLongList(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_longarray() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ArrayLongList c = new ArrayLongList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toLongArray(), a));
        
        c = new ArrayLongList((long[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayLongList c = new ArrayLongList((Collection<Long>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Long> coll = new ArrayList<Long>();
        coll.add(new Long(0L));
        c = new ArrayLongList(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(0L, c.longIterator().nextLong());
        
        ArrayLongList c2 = new ArrayLongList(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(0L, c2.longIterator().nextLong());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ArrayLongList c = new ArrayLongList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeLong(6L);
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
        ArrayLongList c = new ArrayLongList(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

    public void testIteratorIsModifiable() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ArrayLongList c = new ArrayLongList(a);
        
        assertEquals(true, c.longIterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ArrayLongList c = new ArrayLongList(a);
        
        LongIterator it = c.longIterator();
        assertEquals(true, it.isResetable());
        assertEquals(0L, it.nextLong());
        assertEquals(6L, it.nextLong());
        it.reset();
        assertEquals(0L, it.nextLong());
        assertEquals(6L, it.nextLong());
    }

}
