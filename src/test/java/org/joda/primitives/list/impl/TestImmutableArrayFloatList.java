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

import org.joda.primitives.FloatUtils;
import org.joda.primitives.iterator.FloatIterator;
import org.joda.primitives.list.FloatList;

/**
 * Tests for ImmutableArrayFloatList.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestImmutableArrayFloatList extends AbstractTestFloatList {
    // This file is CODE GENERATED. Do not change manually.

    public TestImmutableArrayFloatList(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestImmutableArrayFloatList.class);
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

    public List<Float> makeEmptyList() {
        return ImmutableArrayFloatList.empty();
    }

    public List<Float> makeFullList() {
        float[] a = new float[] {new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)};
        return ImmutableArrayFloatList.copyOf(a);
    }

    public List<Float> makeConfirmedFullCollection() {
        float[] a = new float[] {new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)};
        return ImmutableArrayFloatList.copyOf(a);
    }

    public Object[] getFullElements() {
        float[] a = new float[] {new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)};
        Object[] objs = new Object[a.length];
        for (int i = 0; i < a.length; i++) {
            objs[i] = FloatUtils.toObject(a[i]);
        }
        return objs;
    }

    //-----------------------------------------------------------------------
    public void testUnsupportedAdd() {
        try {
            makeEmptyList().add(0f);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    public void testUnsupportedSet() {
        try {
            makeEmptyList().set(0, 0f);
        } catch (UnsupportedOperationException ex) {
            
        }
    }

    //-----------------------------------------------------------------------
    public void testConstructor() throws Exception {
        ImmutableArrayFloatList c = ImmutableArrayFloatList.empty();
        assertEquals(0, c.size());
    }

    public void testConstructor_array() throws Exception {
        float[] a = new float[] {new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)};
        ImmutableArrayFloatList c = ImmutableArrayFloatList.copyOf(a);
        assertEquals(a.length, c.size());
        assertEquals(true, Arrays.equals(c.toFloatArray(), a));
        
        c = ImmutableArrayFloatList.copyOf((float[]) null);
        assertEquals(0, c.size());
    }

    public void testConstructor_Collection() throws Exception {
        ImmutableArrayFloatList c = ImmutableArrayFloatList.copyOf((Collection<Float>) null);
        assertEquals(0, c.size());
        
        Collection<Float> coll = new ArrayList<Float>();
        coll.add(0f);
        c = ImmutableArrayFloatList.copyOf(coll);
        assertEquals(1, c.size());
        assertEquals(0f, c.iterator().nextFloat());
        
        ImmutableArrayFloatList c2 = ImmutableArrayFloatList.copyOf(c);
        assertSame(c, c2);
    }

    public void testIteratorIsNotModifiable() throws Exception {
        float[] a = new float[] {new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)};
        ImmutableArrayFloatList c = ImmutableArrayFloatList.copyOf(a);
        
        assertEquals(false, c.iterator().isModifiable());
    }

    public void testIteratorReset() throws Exception {
        float[] a = new float[] {0f, 0.1f, 12.6f};
        ImmutableArrayFloatList c = ImmutableArrayFloatList.copyOf(a);
        
        FloatIterator it = c.iterator();
        assertEquals(true, it.isResettable());
        assertEquals(0f, it.nextFloat(), 0.00001f);
        assertEquals(0.1f, it.nextFloat(), 0.00001f);
        it.reset();
        assertEquals(0f, it.nextFloat(), 0.00001f);
        assertEquals(0.1f, it.nextFloat(), 0.00001f);
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        FloatList coll = (FloatList) collection;
        FloatList coll2 = (FloatList) coll.clone();
        assertTrue(coll == coll2);
    }

}
