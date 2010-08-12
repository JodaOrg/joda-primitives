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

import org.joda.primitives.iterator.BooleanIterator;

/**
 * Tests for ArrayBooleanList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayBooleanList extends AbstractTestBooleanList {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayBooleanList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayBooleanList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public List<Boolean> makeEmptyList() {
        return new ArrayBooleanList();
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
        ArrayBooleanList c = new ArrayBooleanList();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayBooleanList c = new ArrayBooleanList(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayBooleanList(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayBooleanList(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_booleanarray() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanList c = new ArrayBooleanList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toBooleanArray(), a));
        
        c = new ArrayBooleanList((boolean[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayBooleanList c = new ArrayBooleanList((Collection<Boolean>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Boolean> coll = new ArrayList<Boolean>();
        coll.add((false ? Boolean.TRUE : Boolean.FALSE));
        c = new ArrayBooleanList(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(false, c.iterator().nextBoolean());
        
        ArrayBooleanList c2 = new ArrayBooleanList(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(false, c2.iterator().nextBoolean());
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanList c = new ArrayBooleanList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeBoolean(true);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(false));
        assertEquals(true, c.contains(false));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(false));
        assertEquals(true, c.contains(false));
    }

    public void testEnsureCapacity() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanList c = new ArrayBooleanList(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

    public void testIteratorIsModifiable() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanList c = new ArrayBooleanList(a);
        
        assertEquals(true, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        boolean[] a = new boolean[] {false, true, false};
        ArrayBooleanList c = new ArrayBooleanList(a);
        
        BooleanIterator it = c.iterator();
        assertEquals(true, it.isResetable());
        assertEquals(false, it.nextBoolean());
        assertEquals(true, it.nextBoolean());
        it.reset();
        assertEquals(false, it.nextBoolean());
        assertEquals(true, it.nextBoolean());
    }

}
