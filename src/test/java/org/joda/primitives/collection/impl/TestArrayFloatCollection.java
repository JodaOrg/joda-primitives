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
 * Test ArrayFloatCollection.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayFloatCollection extends AbstractTestFloatCollection {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayFloatCollection(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayFloatCollection.class);
    }

    //-----------------------------------------------------------------------
    public boolean isFailFastSupported() {
        return false;
    }

    public Collection<Float> makeCollection() {
        return new ArrayFloatCollection();
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
        ArrayFloatCollection c = new ArrayFloatCollection();
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_int() throws Exception {
        ArrayFloatCollection c = new ArrayFloatCollection(2);
        assertEquals(0, c.size());
        assertEquals(2, dataLength(c));
        
        c = new ArrayFloatCollection(0);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        c = new ArrayFloatCollection(-2);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_floatarray() throws Exception {
        float[] a = new float[] {0f, 0.1f, 12.6f};
        ArrayFloatCollection c = new ArrayFloatCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        assertEquals(true, Arrays.equals(c.toFloatArray(), a));
        
        c = new ArrayFloatCollection((float[]) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
    }

    public void testConstructor_Collection() throws Exception {
        ArrayFloatCollection c = new ArrayFloatCollection((Collection<Float>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Float> coll = new ArrayList<Float>();
        coll.add(new Float(0f));
        c = new ArrayFloatCollection(coll);
        assertEquals(1, c.size());
        assertEquals(1, dataLength(c));
        assertEquals(0f, c.iterator().nextFloat(), 0.00001f);
        
        ArrayFloatCollection c2 = new ArrayFloatCollection(c);
        assertEquals(1, c2.size());
        assertEquals(1, dataLength(c2));
        assertEquals(0f, c2.iterator().nextFloat(), 0.00001f);
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testConstructor_Iterator() throws Exception {
        ArrayFloatCollection c = new ArrayFloatCollection((Iterator<Float>) null);
        assertEquals(0, c.size());
        assertEquals(0, dataLength(c));
        
        Collection<Float> coll = new ArrayList<Float>();
        coll.add(new Float(0f));
        c = new ArrayFloatCollection(coll.iterator());
        assertEquals(1, c.size());
        assertEquals(4, dataLength(c));
        assertEquals(0f, c.iterator().nextFloat(), 0.00001f);
        
        ArrayFloatCollection c2 = new ArrayFloatCollection(c.iterator());
        assertEquals(1, c2.size());
        assertEquals(4, dataLength(c2));
        assertEquals(0f, c2.iterator().nextFloat(), 0.00001f);
        c2.clear();
        assertEquals(0, c2.size());
        assertEquals(1, c.size());
    }

    public void testOptimize() throws Exception {
        float[] a = new float[] {0f, 0.1f, 12.6f};
        ArrayFloatCollection c = new ArrayFloatCollection(a);
        assertEquals(3, c.size());
        assertEquals(3, dataLength(c));
        
        c.removeFirst(0.1f);
        assertEquals(2, c.size());
        assertEquals(3, dataLength(c));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0f));
        assertEquals(true, c.contains(12.6f));
        
        c.optimize();
        assertEquals(2, c.size());
        assertEquals(2, dataLength(c));
        assertEquals(true, c.contains(0f));
        assertEquals(true, c.contains(12.6f));
    }

    public void testEnsureCapacity() throws Exception {
        float[] a = new float[] {0f, 0.1f, 12.6f};
        ArrayFloatCollection c = new ArrayFloatCollection(a);
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
