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
 * Test ArrayByteCollection.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayByteCollection extends AbstractTestByteCollection {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayByteCollection(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayByteCollection.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public Collection<Byte> makeCollection() {
        return new ArrayByteCollection();
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
        ArrayByteCollection c = new ArrayByteCollection();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayByteCollection c = new ArrayByteCollection(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayByteCollection(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayByteCollection(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_bytearray() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteCollection c = new ArrayByteCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toByteArray(), a));
        
        c = new ArrayByteCollection((byte[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayByteCollection c = new ArrayByteCollection((Collection<Byte>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Byte> coll = new ArrayList<Byte>();
        coll.add(new Byte((byte) 0));
        c = new ArrayByteCollection(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals((byte) 0, c.iterator().nextByte());
        
        ArrayByteCollection c2 = new ArrayByteCollection(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals((byte) 0, c2.iterator().nextByte());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testConstructor_Iterator() throws Exception {
        ArrayByteCollection c = new ArrayByteCollection((Iterator<Byte>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Byte> coll = new ArrayList<Byte>();
        coll.add(new Byte((byte) 0));
        c = new ArrayByteCollection(coll.iterator());
        assertEquals(1, c.size());
        assertEquals(4, dataLength(c));
        assertEquals((byte) 0, c.iterator().nextByte());
        
        ArrayByteCollection c2 = new ArrayByteCollection(c.iterator());
        assertEquals(1, c2.size());
        assertEquals(4, dataLength(c2));
        assertEquals((byte) 0, c2.iterator().nextByte());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        byte[] a = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteCollection c = new ArrayByteCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeFirst((byte) 6);
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
        ArrayByteCollection c = new ArrayByteCollection(a);
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
