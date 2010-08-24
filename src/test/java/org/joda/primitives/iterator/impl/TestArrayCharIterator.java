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
import org.joda.primitives.CharUtils;

/**
 * Test ArrayCharIterator.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public class TestArrayCharIterator extends AbstractTestIterator {
    // This file is CODE GENERATED. Do not change manually.

    public TestArrayCharIterator(String name) {
        super(name);
    }

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestArrayCharIterator.class);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean supportsRemove() {
        return false;
    }

    //-----------------------------------------------------------------------
    @Override
    public Iterator<Character> makeEmptyIterator() {
        return new ArrayCharIterator(CharUtils.EMPTY_CHAR_ARRAY);
    }

    @Override
    public Iterator<Character> makeFullIterator() {
        char[] data = new char[] {new Character((char)2),new Character('a'),new Character('@'),new Character('Z'),new Character((char)5000),new Character((char)202),new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)};
        return new ArrayCharIterator(data);
    }

    //-----------------------------------------------------------------------
    public void test_copyOf() {
        char[] data = new char[] {(char) 0, 'A', 'Z'};
        ArrayCharIterator test = ArrayCharIterator.copyOf(data);
        assertEquals((char) 0, test.nextChar());
        assertEquals('A', test.nextChar());
        assertEquals('Z', test.nextChar());
        assertEquals(false, test.hasNext());
   }

}
