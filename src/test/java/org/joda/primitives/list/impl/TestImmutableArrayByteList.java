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

import org.joda.primitives.ByteUtils;
import org.joda.primitives.iterator.ByteIterator;
import org.joda.primitives.list.ByteList;

/**
 * Tests for ImmutableArrayByteList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayByteList extends AbstractTestByteList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayByteList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayByteList.class);
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

    public List<Byte> makeEmptyList() {
        return ImmutableArrayByteList.empty();
    }

    public List<Byte> makeFullList() {
        byte[] a = new byte[] {new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38),new Byte((byte)0),new Byte((byte)126),new Byte((byte)202),new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)};
        return ImmutableArrayByteList.copyOf(a);
    }

    public List<Byte> makeConfirmedFullCollection() {
        byte[] a = new byte[] {new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38),new Byte((byte)0),new Byte((byte)126),new Byte((byte)202),new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)};
        return ImmutableArrayByteList.copyOf(a);
    }

    public Object[] getFullElements() {
        byte[] a = new byte[] {new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38),new Byte((byte)0),new Byte((byte)126),new Byte((byte)202),new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = ByteUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add((byte) 0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, (byte) 0);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayByteList c = ImmutableArrayByteList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        byte[] a = new byte[] {new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38),new Byte((byte)0),new Byte((byte)126),new Byte((byte)202),new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)};
        ImmutableArrayByteList c = ImmutableArrayByteList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toByteArray(), a));
        
        c = ImmutableArrayByteList.copyOf((byte[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayByteList c = ImmutableArrayByteList.copyOf((Collection<Byte>) null);
        assertEquals(0, c.size());
        
        Collection<Byte> coll = new ArrayList<Byte>();
        coll.add((byte) 0);
        c = ImmutableArrayByteList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals((byte) 0, c.iterator().nextByte());
        
        ImmutableArrayByteList c2 = ImmutableArrayByteList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        byte[] a = new byte[] {new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38),new Byte((byte)0),new Byte((byte)126),new Byte((byte)202),new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)};
        ImmutableArrayByteList c = ImmutableArrayByteList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ImmutableArrayByteList c = ImmutableArrayByteList.copyOf(a);
        
        ByteIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals((byte) 0, it.nextByte());
        assertEquals((byte) 6, it.nextByte());
        it.reset();
        assertEquals((byte) 0, it.nextByte());
        assertEquals((byte) 6, it.nextByte());
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        ByteList coll = (ByteList) collection;
        ByteList coll2 = (ByteList) coll.clone();
        assertTrue(coll == coll2);
    }

}
