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
 * Test ArrayShortCollection.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayShortCollection extends AbstractTestShortCollection {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayShortCollection(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayShortCollection.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public Collection<Short> makeCollection() {
        return new ArrayShortCollection();
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
        ArrayShortCollection c = new ArrayShortCollection();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayShortCollection c = new ArrayShortCollection(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayShortCollection(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayShortCollection(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_shortarray() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortCollection c = new ArrayShortCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toShortArray(), a));
        
        c = new ArrayShortCollection((short[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayShortCollection c = new ArrayShortCollection((Collection<Short>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Short> coll = new ArrayList<Short>();
        coll.add(new Short((short) 0));
        c = new ArrayShortCollection(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals((short) 0, c.iterator().nextShort());
        
        ArrayShortCollection c2 = new ArrayShortCollection(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals((short) 0, c2.iterator().nextShort());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testConstructor_Iterator() throws Exception {
        ArrayShortCollection c = new ArrayShortCollection((Iterator<Short>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Short> coll = new ArrayList<Short>();
        coll.add(new Short((short) 0));
        c = new ArrayShortCollection(coll.iterator());
        assertEquals(1, c.size());
        assertEquals(4, dataLength(c));
        assertEquals((short) 0, c.iterator().nextShort());
        
        ArrayShortCollection c2 = new ArrayShortCollection(c.iterator());
        assertEquals(1, c2.size());
        assertEquals(4, dataLength(c2));
        assertEquals((short) 0, c2.iterator().nextShort());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortCollection c = new ArrayShortCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeFirst((short) 6);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((short) 0));
        assertEquals(true, c.contains((short) 2));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains((short) 0));
        assertEquals(true, c.contains((short) 2));
    }

    public void testEnsureCapacity() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortCollection c = new ArrayShortCollection(a);
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
