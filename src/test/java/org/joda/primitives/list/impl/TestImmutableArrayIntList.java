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
package org.joda.primitives.list.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.joda.primitives.IntUtils;
import org.joda.primitives.iterator.IntIterator;
import org.joda.primitives.list.IntList;

/**
 * Tests for ImmutableArrayIntList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayIntList extends AbstractTestIntList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayIntList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayIntList.class);
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

    public List<Integer> makeEmptyList() {
        return ImmutableArrayIntList.empty();
    }

    public List<Integer> makeFullList() {
        int[] a = new int[] {new Integer(2),new Integer(-2),new Integer(38),new Integer(0),new Integer(10000),new Integer(202),new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)};
        return ImmutableArrayIntList.copyOf(a);
    }

    public List<Integer> makeConfirmedFullCollection() {
        int[] a = new int[] {new Integer(2),new Integer(-2),new Integer(38),new Integer(0),new Integer(10000),new Integer(202),new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)};
        return ImmutableArrayIntList.copyOf(a);
    }

    public Object[] getFullElements() {
        int[] a = new int[] {new Integer(2),new Integer(-2),new Integer(38),new Integer(0),new Integer(10000),new Integer(202),new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = IntUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add(0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, 0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayIntList c = ImmutableArrayIntList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        int[] a = new int[] {new Integer(2),new Integer(-2),new Integer(38),new Integer(0),new Integer(10000),new Integer(202),new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)};
        ImmutableArrayIntList c = ImmutableArrayIntList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toIntArray(), a));
        
        c = ImmutableArrayIntList.copyOf((int[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayIntList c = ImmutableArrayIntList.copyOf((Collection<Integer>) null);
        assertEquals(0, c.size());
        
        Collection<Integer> coll = new ArrayList<Integer>();
        coll.add(0);
        c = ImmutableArrayIntList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals(0, c.iterator().nextInt());
        
        ImmutableArrayIntList c2 = ImmutableArrayIntList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        int[] a = new int[] {new Integer(2),new Integer(-2),new Integer(38),new Integer(0),new Integer(10000),new Integer(202),new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)};
        ImmutableArrayIntList c = ImmutableArrayIntList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        int[] a = new int[] {0, 6, 2};
        ImmutableArrayIntList c = ImmutableArrayIntList.copyOf(a);
        
        IntIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals(0, it.nextInt());
        assertEquals(6, it.nextInt());
        it.reset();
        assertEquals(0, it.nextInt());
        assertEquals(6, it.nextInt());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        IntList coll = (IntList) collection;
        IntList coll2 = (IntList) coll.clone();
        assertTrue(coll == coll2);
    }

}
