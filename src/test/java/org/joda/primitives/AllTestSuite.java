/*
 *  Copyright 2001-2006 Stephen Colebourne
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
package org.joda.primitives;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.joda.primitives.collection.impl.TestArrayBooleanCollection;
import org.joda.primitives.collection.impl.TestArrayByteCollection;
import org.joda.primitives.collection.impl.TestArrayCharCollection;
import org.joda.primitives.collection.impl.TestArrayDoubleCollection;
import org.joda.primitives.collection.impl.TestArrayFloatCollection;
import org.joda.primitives.collection.impl.TestArrayIntCollection;
import org.joda.primitives.collection.impl.TestArrayLongCollection;
import org.joda.primitives.collection.impl.TestArrayShortCollection;
import org.joda.primitives.list.impl.TestArrayBooleanList;
import org.joda.primitives.list.impl.TestArrayByteList;
import org.joda.primitives.list.impl.TestArrayCharList;
import org.joda.primitives.list.impl.TestArrayDoubleList;
import org.joda.primitives.list.impl.TestArrayFloatList;
import org.joda.primitives.list.impl.TestArrayIntList;
import org.joda.primitives.list.impl.TestArrayLongList;
import org.joda.primitives.list.impl.TestArrayShortList;

/**
 * Overall test manager.
 * 
 * @author Stephen Colebourne
 * @since 1.0
 */
public class AllTestSuite extends TestSuite {

    public AllTestSuite(String name) {
        super(name);
    }
    
    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        TestRunner.run(suite());
    }
    
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(TestArrayLongCollection.suite());
        suite.addTest(TestArrayIntCollection.suite());
        suite.addTest(TestArrayShortCollection.suite());
        suite.addTest(TestArrayByteCollection.suite());
        suite.addTest(TestArrayDoubleCollection.suite());
        suite.addTest(TestArrayFloatCollection.suite());
        suite.addTest(TestArrayCharCollection.suite());
        suite.addTest(TestArrayBooleanCollection.suite());
        
        suite.addTest(TestArrayLongList.suite());
        suite.addTest(TestArrayIntList.suite());
        suite.addTest(TestArrayShortList.suite());
        suite.addTest(TestArrayByteList.suite());
        suite.addTest(TestArrayDoubleList.suite());
        suite.addTest(TestArrayFloatList.suite());
        suite.addTest(TestArrayCharList.suite());
        suite.addTest(TestArrayBooleanList.suite());
        return suite;
    }

}
