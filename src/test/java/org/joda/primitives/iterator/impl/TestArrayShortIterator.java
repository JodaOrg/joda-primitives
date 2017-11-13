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
import org.joda.primitives.ShortUtils;

/**
 * Test ArrayShortIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayShortIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayShortIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayShortIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Short> makeEmptyIterator() {
        return new ArrayShortIterator(ShortUtils.EMPTY_SHORT_ARRAY);
    }

    @Override
    public Iterator<Short> makeFullIterator() {
        short[] data = new short[] {new Short((short)2),new Short((short)-2),new Short((short)38),new Short((short)0),new Short((short)1000),new Short((short)202),new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)};
        return new ArrayShortIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        short[] data = new short[] {(short) 0, (short) 6, (short) 2};
        ArrayShortIterator test = ArrayShortIterator.copyOf(data);
        assertEquals((short) 0, test.nextShort());
        assertEquals((short) 6, test.nextShort());
        assertEquals((short) 2, test.nextShort());
        assertEquals(false, test.hasNext());
   }

}
