/*
 *  Copyright 2001-2013 Stephen Colebourne
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

import org.joda.primitives.DoubleUtils;
import org.joda.primitives.iterator.DoubleIterator;
import org.joda.primitives.list.DoubleList;

/**
 * Tests for ImmutableArrayDoubleList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayDoubleList extends AbstractTestDoubleList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayDoubleList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayDoubleList.class);
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

    public List<Double> makeEmptyList() {
        return ImmutableArrayDoubleList.empty();
    }

    public List<Double> makeFullList() {
        double[] a = new double[] {new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)};
        return ImmutableArrayDoubleList.copyOf(a);
    }

    public List<Double> makeConfirmedFullCollection() {
        double[] a = new double[] {new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)};
        return ImmutableArrayDoubleList.copyOf(a);
    }

    public Object[] getFullElements() {
        double[] a = new double[] {new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = DoubleUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add(0d);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, 0d);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayDoubleList c = ImmutableArrayDoubleList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        double[] a = new double[] {new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)};
        ImmutableArrayDoubleList c = ImmutableArrayDoubleList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toDoubleArray(), a));
        
        c = ImmutableArrayDoubleList.copyOf((double[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayDoubleList c = ImmutableArrayDoubleList.copyOf((Collection<Double>) null);
        assertEquals(0, c.size());
        
        Collection<Double> coll = new ArrayList<Double>();
        coll.add(0d);
        c = ImmutableArrayDoubleList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals(0d, c.iterator().nextDouble());
        
        ImmutableArrayDoubleList c2 = ImmutableArrayDoubleList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        double[] a = new double[] {new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)};
        ImmutableArrayDoubleList c = ImmutableArrayDoubleList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        double[] a = new double[] {0d, -0.9d, 3.5d};
        ImmutableArrayDoubleList c = ImmutableArrayDoubleList.copyOf(a);
        
        DoubleIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals(0d, it.nextDouble(), 0.00001d);
        assertEquals(-0.9d, it.nextDouble(), 0.00001d);
        it.reset();
        assertEquals(0d, it.nextDouble(), 0.00001d);
        assertEquals(-0.9d, it.nextDouble(), 0.00001d);
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        DoubleList coll = (DoubleList) collection;
        DoubleList coll2 = (DoubleList) coll.clone();
        assertTrue(coll == coll2);
    }

}
