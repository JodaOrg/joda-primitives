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

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.joda.primitives.iterator.DoubleIterator;

/**
 * Tests for ArrayDoubleList.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayDoubleList extends AbstractTestDoubleList {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayDoubleList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayDoubleList.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public List<Double> makeEmptyList() {
        return new ArrayDoubleList();
    }

    //-----------------------------------------------------------------------
    protected int dataLength(Object obj) throws Exception {
        Field field = obj.getClass().getDeclaredField("data");
        field.setAccessible(true);
        Object value = field.get(obj);
        return Array.getLength(value);
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ArrayDoubleList c = new ArrayDoubleList();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayDoubleList c = new ArrayDoubleList(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayDoubleList(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayDoubleList(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_doublearray() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleList c = new ArrayDoubleList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toDoubleArray(), a));
        
        c = new ArrayDoubleList((double[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayDoubleList c = new ArrayDoubleList((Collection<Double>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Double> coll = new ArrayList<Double>();
        coll.add(new Double(0d));
        c = new ArrayDoubleList(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(0d, c.iterator().nextDouble(), 0.00001d);
        
        ArrayDoubleList c2 = new ArrayDoubleList(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(0d, c2.iterator().nextDouble(), 0.00001d);
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleList c = new ArrayDoubleList(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeDouble(-0.9d);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0d));
        assertEquals(true, c.contains(3.5d));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0d));
        assertEquals(true, c.contains(3.5d));
    }

    public void testEnsureCapacity() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleList c = new ArrayDoubleList(a);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(0);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(-1);
        assertEquals(3, dataLength(c));
        
        c.ensureCapacity(100);
        assertEquals(100, dataLength(c));
    }

    public void testIteratorIsModifiable() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleList c = new ArrayDoubleList(a);
        
        assertEquals(true, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleList c = new ArrayDoubleList(a);
        
        DoubleIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals(0d, it.nextDouble(), 0.00001d);
        assertEquals(-0.9d, it.nextDouble(), 0.00001d);
        it.reset();
        assertEquals(0d, it.nextDouble(), 0.00001d);
        assertEquals(-0.9d, it.nextDouble(), 0.00001d);
    }

}
