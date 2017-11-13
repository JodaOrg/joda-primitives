/*
 *  Copyright 2001-present Stephen Colebourne
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
import org.joda.primitives.DoubleUtils;

/**
 * Test ArrayDoubleIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayDoubleIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayDoubleIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayDoubleIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Double> makeEmptyIterator() {
        return new ArrayDoubleIterator(DoubleUtils.EMPTY_DOUBLE_ARRAY);
    }

    @Override
    public Iterator<Double> makeFullIterator() {
        double[] data = new double[] {new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)};
        return new ArrayDoubleIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        double[] data = new double[] {0d, -0.9d, 3.5d};
        ArrayDoubleIterator test = ArrayDoubleIterator.copyOf(data);
        assertEquals(0d, test.nextDouble());
        assertEquals(-0.9d, test.nextDouble());
        assertEquals(3.5d, test.nextDouble());
        assertEquals(false, test.hasNext());
   }

}
