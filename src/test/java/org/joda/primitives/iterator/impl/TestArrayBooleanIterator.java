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
import org.joda.primitives.BooleanUtils;

/**
 * Test ArrayBooleanIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayBooleanIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayBooleanIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayBooleanIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Boolean> makeEmptyIterator() {
        return new ArrayBooleanIterator(BooleanUtils.EMPTY_BOOLEAN_ARRAY);
    }

    @Override
    public Iterator<Boolean> makeFullIterator() {
        boolean[] data = new boolean[] {Boolean.TRUE};
        return new ArrayBooleanIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        boolean[] data = new boolean[] {false, true, false};
        ArrayBooleanIterator test = ArrayBooleanIterator.copyOf(data);
        assertEquals(false, test.nextBoolean());
        assertEquals(true, test.nextBoolean());
        assertEquals(false, test.nextBoolean());
        assertEquals(false, test.hasNext());
   }

}
