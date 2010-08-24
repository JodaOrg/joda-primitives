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

import org.joda.primitives.LongUtils;
import org.joda.primitives.iterator.LongIterator;
import org.joda.primitives.list.LongList;

/**
 * Tests for ImmutableArrayLongList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayLongList extends AbstractTestLongList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayLongList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayLongList.class);
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

    public List<Long> makeEmptyList() {
        return ImmutableArrayLongList.empty();
    }

    public List<Long> makeFullList() {
        long[] a = new long[] {new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)};
        return ImmutableArrayLongList.copyOf(a);
    }

    public List<Long> makeConfirmedFullCollection() {
        long[] a = new long[] {new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)};
        return ImmutableArrayLongList.copyOf(a);
    }

    public Object[] getFullElements() {
        long[] a = new long[] {new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = LongUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add(0L);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, 0L);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayLongList c = ImmutableArrayLongList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        long[] a = new long[] {new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)};
        ImmutableArrayLongList c = ImmutableArrayLongList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toLongArray(), a));
        
        c = ImmutableArrayLongList.copyOf((long[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayLongList c = ImmutableArrayLongList.copyOf((Collection<Long>) null);
        assertEquals(0, c.size());
        
        Collection<Long> coll = new ArrayList<Long>();
        coll.add(0L);
        c = ImmutableArrayLongList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals(0L, c.iterator().nextLong());
        
        ImmutableArrayLongList c2 = ImmutableArrayLongList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        long[] a = new long[] {new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)};
        ImmutableArrayLongList c = ImmutableArrayLongList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        long[] a = new long[] {0L, 6L, 2L};
        ImmutableArrayLongList c = ImmutableArrayLongList.copyOf(a);
        
        LongIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals(0L, it.nextLong());
        assertEquals(6L, it.nextLong());
        it.reset();
        assertEquals(0L, it.nextLong());
        assertEquals(6L, it.nextLong());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        LongList coll = (LongList) collection;
        LongList coll2 = (LongList) coll.clone();
        assertTrue(coll == coll2);
    }

}
