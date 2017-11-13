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

import org.joda.primitives.ShortUtils;
import org.joda.primitives.iterator.ShortIterator;
import org.joda.primitives.list.ShortList;

/**
 * Tests for ImmutableArrayShortList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayShortList extends AbstractTestShortList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayShortList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayShortList.class);
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

    public List<Short> makeEmptyList() {
        return ImmutableArrayShortList.empty();
    }

    public List<Short> makeFullList() {
        short[] a = new short[] {new Short((short)2),new Short((short)-2),new Short((short)38),new Short((short)0),new Short((short)1000),new Short((short)202),new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)};
        return ImmutableArrayShortList.copyOf(a);
    }

    public List<Short> makeConfirmedFullCollection() {
        short[] a = new short[] {new Short((short)2),new Short((short)-2),new Short((short)38),new Short((short)0),new Short((short)1000),new Short((short)202),new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)};
        return ImmutableArrayShortList.copyOf(a);
    }

    public Object[] getFullElements() {
        short[] a = new short[] {new Short((short)2),new Short((short)-2),new Short((short)38),new Short((short)0),new Short((short)1000),new Short((short)202),new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = ShortUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add((short) 0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, (short) 0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayShortList c = ImmutableArrayShortList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        short[] a = new short[] {new Short((short)2),new Short((short)-2),new Short((short)38),new Short((short)0),new Short((short)1000),new Short((short)202),new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)};
        ImmutableArrayShortList c = ImmutableArrayShortList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toShortArray(), a));
        
        c = ImmutableArrayShortList.copyOf((short[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayShortList c = ImmutableArrayShortList.copyOf((Collection<Short>) null);
        assertEquals(0, c.size());
        
        Collection<Short> coll = new ArrayList<Short>();
        coll.add((short) 0);
        c = ImmutableArrayShortList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals((short) 0, c.iterator().nextShort());
        
        ImmutableArrayShortList c2 = ImmutableArrayShortList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        short[] a = new short[] {new Short((short)2),new Short((short)-2),new Short((short)38),new Short((short)0),new Short((short)1000),new Short((short)202),new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)};
        ImmutableArrayShortList c = ImmutableArrayShortList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ImmutableArrayShortList c = ImmutableArrayShortList.copyOf(a);
        
        ShortIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals((short) 0, it.nextShort());
        assertEquals((short) 6, it.nextShort());
        it.reset();
        assertEquals((short) 0, it.nextShort());
        assertEquals((short) 6, it.nextShort());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        ShortList coll = (ShortList) collection;
        ShortList coll2 = (ShortList) coll.clone();
        assertTrue(coll == coll2);
    }

}
