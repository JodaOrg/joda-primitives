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
package org.joda.primitives.iterator.impl;

import java.util.Iterator;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.apache.commons.collections.iterators.AbstractTestIterator;
import org.joda.primitives.LongUtils;

/**
 * Test ArrayLongIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayLongIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayLongIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayLongIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Long> makeEmptyIterator() {
        return new ArrayLongIterator(LongUtils.EMPTY_LONG_ARRAY);
    }

    @Override
    public Iterator<Long> makeFullIterator() {
        long[] data = new long[] {new Long(2),new Long(-2),new Long(38),new Long(0),new Long(10000),new Long(202),new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)};
        return new ArrayLongIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        long[] data = new long[] {0L, 6L, 2L};
        ArrayLongIterator test = ArrayLongIterator.copyOf(data);
        assertEquals(0L, test.nextLong());
        assertEquals(6L, test.nextLong());
        assertEquals(2L, test.nextLong());
        assertEquals(false, test.hasNext());
   }

}
