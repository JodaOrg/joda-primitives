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
package org.joda.primitives.iterator.impl;

import java.util.Iterator;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.apache.commons.collections.iterators.AbstractTestIterator;
import org.joda.primitives.FloatUtils;

/**
 * Test ArrayFloatIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayFloatIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayFloatIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayFloatIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Float> makeEmptyIterator() {
        return new ArrayFloatIterator(FloatUtils.EMPTY_FLOAT_ARRAY);
    }

    @Override
    public Iterator<Float> makeFullIterator() {
        float[] data = new float[] {new Float(2f),new Float(-2f),new Float(38.874f),new Float(0f),new Float(10000f),new Float(202f),new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)};
        return new ArrayFloatIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        float[] data = new float[] {0f, 0.1f, 12.6f};
        ArrayFloatIterator test = ArrayFloatIterator.copyOf(data);
        assertEquals(0f, test.nextFloat());
        assertEquals(0.1f, test.nextFloat());
        assertEquals(12.6f, test.nextFloat());
        assertEquals(false, test.hasNext());
   }

}
