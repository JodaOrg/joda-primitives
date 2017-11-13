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
import org.joda.primitives.ByteUtils;

/**
 * Test ArrayByteIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayByteIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayByteIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayByteIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Byte> makeEmptyIterator() {
        return new ArrayByteIterator(ByteUtils.EMPTY_BYTE_ARRAY);
    }

    @Override
    public Iterator<Byte> makeFullIterator() {
        byte[] data = new byte[] {new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38),new Byte((byte)0),new Byte((byte)126),new Byte((byte)202),new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)};
        return new ArrayByteIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        byte[] data = new byte[] {(byte) 0, (byte) 6, (byte) 2};
        ArrayByteIterator test = ArrayByteIterator.copyOf(data);
        assertEquals((byte) 0, test.nextByte());
        assertEquals((byte) 6, test.nextByte());
        assertEquals((byte) 2, test.nextByte());
        assertEquals(false, test.hasNext());
   }

}
