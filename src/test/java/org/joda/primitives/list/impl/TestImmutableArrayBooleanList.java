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

import org.joda.primitives.BooleanUtils;
import org.joda.primitives.iterator.BooleanIterator;
import org.joda.primitives.list.BooleanList;

/**
 * Tests for ImmutableArrayBooleanList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayBooleanList extends AbstractTestBooleanList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayBooleanList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayBooleanList.class);
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

    public List<Boolean> makeEmptyList() {
        return ImmutableArrayBooleanList.empty();
    }

    public List<Boolean> makeFullList() {
        boolean[] a = new boolean[] {Boolean.TRUE};
        return ImmutableArrayBooleanList.copyOf(a);
    }

    public List<Boolean> makeConfirmedFullCollection() {
        boolean[] a = new boolean[] {Boolean.TRUE};
        return ImmutableArrayBooleanList.copyOf(a);
    }

    public Object[] getFullElements() {
        boolean[] a = new boolean[] {Boolean.TRUE};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = BooleanUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add(false);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, false);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayBooleanList c = ImmutableArrayBooleanList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        boolean[] a = new boolean[] {Boolean.TRUE};
        ImmutableArrayBooleanList c = ImmutableArrayBooleanList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toBooleanArray(), a));
        
        c = ImmutableArrayBooleanList.copyOf((boolean[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayBooleanList c = ImmutableArrayBooleanList.copyOf((Collection<Boolean>) null);
        assertEquals(0, c.size());
        
        Collection<Boolean> coll = new ArrayList<Boolean>();
        coll.add(false);
        c = ImmutableArrayBooleanList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals(false, c.iterator().nextBoolean());
        
        ImmutableArrayBooleanList c2 = ImmutableArrayBooleanList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        boolean[] a = new boolean[] {Boolean.TRUE};
        ImmutableArrayBooleanList c = ImmutableArrayBooleanList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ImmutableArrayBooleanList c = ImmutableArrayBooleanList.copyOf(a);
        
        BooleanIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals(false, it.nextBoolean());
        assertEquals(true, it.nextBoolean());
        it.reset();
        assertEquals(false, it.nextBoolean());
        assertEquals(true, it.nextBoolean());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        BooleanList coll = (BooleanList) collection;
        BooleanList coll2 = (BooleanList) coll.clone();
        assertTrue(coll == coll2);
    }

}
