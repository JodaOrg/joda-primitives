/*
 *  Copyright 2001-2009 Stephen Colebourne
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

import org.joda.primitives.iterator.ByteIterator;

/**
 * Tests for ArrayByteList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayByteList extends AbstractTestByteList {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayByteList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayByteList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public List makeEmptyList() {
        return new ArrayByteList();
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
        ArrayByteList c = new ArrayByteList();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayByteList c = new ArrayByteList(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayByteList(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayByteList(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_bytearray() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteList c = new ArrayByteList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toByteArray(), a));
        
        c = new ArrayByteList((byte[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayByteList c = new ArrayByteList((Collection) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection coll = new ArrayList();
        coll.add(new Byte((byte) 0));
        c = new ArrayByteList(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals((byte) 0, c.byteIterator().nextByte());
        
        ArrayByteList c2 = new ArrayByteList(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals((byte) 0, c2.byteIterator().nextByte());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteList c = new ArrayByteList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeByte((byte) 6);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((byte) 0));
        assertEquals(true, c.contains((byte) 2));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((byte) 0));
        assertEquals(true, c.contains((byte) 2));
    }

    public void testEnsureCapacity() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteList c = new ArrayByteList(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

    public void testIteratorIsModifiable() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteList c = new ArrayByteList(a);
        
        assertEquals(true, c.byteIterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteList c = new ArrayByteList(a);
        
        ByteIterator it = c.byteIterator();
        assertEquals(true, it.isResetable());
        assertEquals((byte) 0, it.nextByte());
        assertEquals((byte) 6, it.nextByte());
        it.reset();
        assertEquals((byte) 0, it.nextByte());
        assertEquals((byte) 6, it.nextByte());
    }

}
