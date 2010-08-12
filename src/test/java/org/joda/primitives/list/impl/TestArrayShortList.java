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

import org.joda.primitives.iterator.ShortIterator;

/**
 * Tests for ArrayShortList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayShortList extends AbstractTestShortList {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayShortList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayShortList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public List<Short> makeEmptyList() {
        return new ArrayShortList();
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
        ArrayShortList c = new ArrayShortList();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayShortList c = new ArrayShortList(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayShortList(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayShortList(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_shortarray() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortList c = new ArrayShortList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toShortArray(), a));
        
        c = new ArrayShortList((short[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayShortList c = new ArrayShortList((Collection<Short>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Short> coll = new ArrayList<Short>();
        coll.add(new Short((short) 0));
        c = new ArrayShortList(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals((short) 0, c.iterator().nextShort());
        
        ArrayShortList c2 = new ArrayShortList(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals((short) 0, c2.iterator().nextShort());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortList c = new ArrayShortList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeShort((short) 6);
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
        ArrayShortList c = new ArrayShortList(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

    public void testIteratorIsModifiable() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortList c = new ArrayShortList(a);
        
        assertEquals(true, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        short[] a = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortList c = new ArrayShortList(a);
        
        ShortIterator it = c.iterator();
        assertEquals(true, it.isResetable());
        assertEquals((short) 0, it.nextShort());
        assertEquals((short) 6, it.nextShort());
        it.reset();
        assertEquals((short) 0, it.nextShort());
        assertEquals((short) 6, it.nextShort());
    }

}
