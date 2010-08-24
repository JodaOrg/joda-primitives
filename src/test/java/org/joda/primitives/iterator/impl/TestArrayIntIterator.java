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
import org.joda.primitives.IntUtils;

/**
 * Test ArrayIntIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayIntIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayIntIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayIntIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Integer> makeEmptyIterator() {
        return new ArrayIntIterator(IntUtils.EMPTY_INT_ARRAY);
    }

    @Override
    public Iterator<Integer> makeFullIterator() {
        int[] data = new int[] {new Integer(2),new Integer(-2),new Integer(38),new Integer(0),new Integer(10000),new Integer(202),new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)};
        return new ArrayIntIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        int[] data = new int[] {0, 6, 2};
        ArrayIntIterator test = ArrayIntIterator.copyOf(data);
        assertEquals(0, test.nextInt());
        assertEquals(6, test.nextInt());
        assertEquals(2, test.nextInt());
        assertEquals(false, test.hasNext());
   }

}
