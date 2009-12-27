/*
 *  Copyright 2001-2009 Stephen Colebourne, Jason Tiscione
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
package org.joda.primitives.collection.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.collection.AbstractTestCollection;
import org.joda.primitives.DoubleUtils;
import org.joda.primitives.collection.DoubleCollection;
import org.joda.primitives.iterator.DoubleIterator;

/**
 * Abstract base class for testing AbstractDoubleCollection subclasses.
 *
 * @author Stephen Colebourne
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestDoubleCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestDoubleCollection(String name) {
        super(name);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Override to indicate that clone is not supported for this object.
     */
    public boolean isCloneSupported() {
        return true;
    }
    
    //-----------------------------------------------------------------------
    public boolean isNullSupported() {
        return false;
    }

    public Collection<Double> makeConfirmedCollection() {
        return new ArrayList<Double>();
    }

    public Collection<Double> makeConfirmedFullCollection() {
        List<Double> list = new ArrayList<Double>();
        list.addAll(Arrays.asList(getFullNonNullElements()));
        return list;
    }

    public Double[] getFullNonNullElements() {
        return new Double[] {
            new Double(2d),new Double(-2d),new Double(38.765d),new Double(0d),new Double(10000d),new Double(202d),new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)
        };
    }
    
    public Double[] getOtherNonNullElements() {
        return new Double[] {
            new Double(-33d),new Double(66d),new Double(-99d)
        };
    }
    
    public void testIsModifiable() {
        DoubleCollection ic = (DoubleCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        DoubleCollection ic = (DoubleCollection) makeFullCollection();
        double[] values = ic.toDoubleArray();
        int i = 0;
        for (DoubleIterator it = ic.doubleIterator(); it.hasNext(); i++) {
            double next = it.nextDouble();
            assertEquals(values[i], next, 0.00001d);
        }
    }
    
    public void testToValueArrayEmpty() {
        DoubleCollection ic = (DoubleCollection) makeFullCollection();
        ic.clear();
        double[] values = ic.toDoubleArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        DoubleCollection ic = (DoubleCollection) makeFullCollection();
        double[] array = new double[2];
        try {
            ic.toDoubleArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        double[] values = ic.toDoubleArray();
        
        // array null
        double[] result = ic.toDoubleArray(null, 1);
        assertEquals(0d, result[0], 0.00001d);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i], 0.00001d);
        }
        
        // array too small
        array = new double[2];
        array[0] = 3.5d;
        array[1] = -0.9d;
        result = ic.toDoubleArray(array, 1);
        assertEquals(3.5d, array[0], 0.00001d);
        assertEquals(-0.9d, array[1], 0.00001d);
        assertEquals(ic.size() + 1, result.length);
        assertEquals(3.5d, result[0], 0.00001d);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001d);
        }
        
        // array big enough
        array = new double[values.length + 2];
        Arrays.fill(array, 3.5d);
        result = ic.toDoubleArray(array, 1);
        assertSame(array, result);
        assertEquals(3.5d, array[0], 0.00001d);
        assertEquals(3.5d, array[array.length - 1], 0.00001d);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1], 0.00001d);
        }
    }
    
    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        assertEquals(true, coll.containsAll((double[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        DoubleCollection clone = (DoubleCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator<Double> it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((DoubleCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        assertEquals(false, coll.containsAny((double[]) null));
        assertEquals(false, coll.containsAny(new double[0]));
        assertEquals(true, coll.containsAny(new double[] {DoubleUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new double[] {DoubleUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        DoubleCollection clone = (DoubleCollection) coll.clone();
        
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        Iterator<Double> it = clone.iterator();
        Double obj = it.next();
        clone.clear();
        clone.add(obj);
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        coll.remove(obj);
        assertEquals(false, coll.containsAny(clone));
        assertEquals(false, clone.containsAny(coll));
        
        assertEquals(false, coll.containsAny((DoubleCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        coll.addAll((double[]) null);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        double first = coll.doubleIterator().nextDouble();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        coll.removeAll((double[]) null);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        coll.retainAll((double[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        DoubleCollection coll = (DoubleCollection) collection;
        if (isCloneSupported()) {
            DoubleCollection coll2 = (DoubleCollection) coll.clone();
            assertTrue(coll != coll2);
            assertTrue(coll.size() == coll2.size());
            assertTrue(coll.containsAll(coll2));
            assertTrue(coll2.containsAll(coll));
        } else {
            try {
                coll.clone();
                fail();
            } catch (UnsupportedOperationException ex) {}
        }
    }
    
}
