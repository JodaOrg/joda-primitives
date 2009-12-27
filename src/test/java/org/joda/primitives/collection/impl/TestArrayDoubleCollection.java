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
 * Test ArrayDoubleCollection.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayDoubleCollection extends AbstractTestDoubleCollection {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayDoubleCollection(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayDoubleCollection.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public Collection<Double> makeCollection() {
        return new ArrayDoubleCollection();
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
        ArrayDoubleCollection c = new ArrayDoubleCollection();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayDoubleCollection c = new ArrayDoubleCollection(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayDoubleCollection(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayDoubleCollection(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_doublearray() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleCollection c = new ArrayDoubleCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toDoubleArray(), a));
        
        c = new ArrayDoubleCollection((double[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayDoubleCollection c = new ArrayDoubleCollection((Collection<Double>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Double> coll = new ArrayList<Double>();
        coll.add(new Double(0d));
        c = new ArrayDoubleCollection(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(0d, c.doubleIterator().nextDouble(), 0.00001d);
        
        ArrayDoubleCollection c2 = new ArrayDoubleCollection(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(0d, c2.doubleIterator().nextDouble(), 0.00001d);
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testConstructor_Iterator() throws Exception {
        ArrayDoubleCollection c = new ArrayDoubleCollection((Iterator<Double>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Double> coll = new ArrayList<Double>();
        coll.add(new Double(0d));
        c = new ArrayDoubleCollection(coll.iterator());
        assertEquals(1, c.size());
        assertEquals(4, dataLength(c));
        assertEquals(0d, c.doubleIterator().nextDouble(), 0.00001d);
        
        ArrayDoubleCollection c2 = new ArrayDoubleCollection(c.iterator());
        assertEquals(1, c2.size());
        assertEquals(4, dataLength(c2));
        assertEquals(0d, c2.doubleIterator().nextDouble(), 0.00001d);
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleCollection c = new ArrayDoubleCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeFirst(-0.9d);
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
        ArrayDoubleCollection c = new ArrayDoubleCollection(a);
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
