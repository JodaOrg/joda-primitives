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
package org.joda.primitives.collection.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.collection.AbstractTestCollection;
import org.joda.primitives.BooleanUtils;
import org.joda.primitives.collection.BooleanCollection;
import org.joda.primitives.iterator.BooleanIterator;

/**
 * Abstract base class for testing AbstractBooleanCollection subclasses.
 *
 * @author Stephen Colebourne
 * @author Jason Tiscione
 * @version CODE GENERATED
 * @since 1.0
 */
public abstract class AbstractTestBooleanCollection extends AbstractTestCollection {
    // This file is CODE GENERATED. Do not change manually.
    
    public AbstractTestBooleanCollection(String name) {
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

    public Collection<Boolean> makeConfirmedCollection() {
        return new ArrayList<Boolean>();
    }

    public Collection<Boolean> makeConfirmedFullCollection() {
        List<Boolean> list = new ArrayList<Boolean>();
        list.addAll(Arrays.asList(getFullNonNullElements()));
        return list;
    }

    public Boolean[] getFullNonNullElements() {
        return new Boolean[] {
            Boolean.TRUE
        };
    }
    
    public Boolean[] getOtherNonNullElements() {
        return new Boolean[] {
            Boolean.FALSE
        };
    }
    
    public void testIsModifiable() {
        BooleanCollection ic = (BooleanCollection) makeFullCollection();
        assertEquals(isAddSupported() || isRemoveSupported(), ic.isModifiable());
    }
    
    public void testToValueArray() {
        BooleanCollection ic = (BooleanCollection) makeFullCollection();
        boolean[] values = ic.toBooleanArray();
        int i = 0;
        for (BooleanIterator it = ic.iterator(); it.hasNext(); i++) {
            boolean next = it.nextBoolean();
            assertEquals(values[i], next);
        }
    }
    
    public void testToValueArrayEmpty() {
        BooleanCollection ic = (BooleanCollection) makeFullCollection();
        ic.clear();
        boolean[] values = ic.toBooleanArray();
        assertEquals(0, values.length);
    }
    
    public void testToValueArrayInsert() {
        BooleanCollection ic = (BooleanCollection) makeFullCollection();
        boolean[] array = new boolean[2];
        try {
            ic.toBooleanArray(array, -1);
            fail();
        } catch (IndexOutOfBoundsException ex) {}
        
        boolean[] values = ic.toBooleanArray();
        
        // array null
        boolean[] result = ic.toBooleanArray(null, 1);
        assertEquals(false, result[0]);
        for (int i = 1; i < result.length; i++) {
            assertEquals(values[i - 1], result[i]);
        }
        
        // array too small
        array = new boolean[1];
        array[0] = false;
        result = ic.toBooleanArray(array, 1);
        assertEquals(false, array[0]);
        assertEquals(ic.size() + 1, result.length);
        assertEquals(false, result[0]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
        
        // array big enough
        array = new boolean[values.length + 2];
        Arrays.fill(array, false);
        result = ic.toBooleanArray(array, 1);
        assertSame(array, result);
        assertEquals(false, array[0]);
        assertEquals(false, array[array.length - 1]);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], result[i + 1]);
        }
    }
    
    //-----------------------------------------------------------------------
    public void testContainsAllArray() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        assertEquals(true, coll.containsAll((boolean[]) null));
    }

    public void testContainsAllTypedCollection() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        BooleanCollection clone = (BooleanCollection) coll.clone();
        
        assertEquals(true, coll.containsAll(clone));
        assertEquals(true, clone.containsAll(coll));
        
        Iterator<Boolean> it = clone.iterator();
        it.next();
        it.remove();
        assertEquals(true, coll.containsAll(clone));
        assertEquals(false, clone.containsAll(coll));
        
        assertEquals(true, coll.containsAll((BooleanCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    //-----------------------------------------------------------------------
    public void testContainsAnyArray() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        assertEquals(false, coll.containsAny((boolean[]) null));
        assertEquals(false, coll.containsAny(new boolean[0]));
        assertEquals(true, coll.containsAny(new boolean[] {BooleanUtils.toPrimitive(getFullElements()[0])}));
        assertEquals(false, coll.containsAny(new boolean[] {BooleanUtils.toPrimitive(getOtherElements()[0])}));
    }

    public void testContainsAnyTypedCollection() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        BooleanCollection clone = (BooleanCollection) coll.clone();
        
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        Iterator<Boolean> it = clone.iterator();
        Boolean obj = it.next();
        clone.clear();
        clone.add(obj);
        assertEquals(true, coll.containsAny(clone));
        assertEquals(true, clone.containsAny(coll));
        
        coll.remove(obj);
        assertEquals(false, coll.containsAny(clone));
        assertEquals(false, clone.containsAny(coll));
        
        assertEquals(false, coll.containsAny((BooleanCollection) null));
        clone.clear();
        assertEquals(false, coll.containsAny(clone));
    }

    //-----------------------------------------------------------------------
    public void testAddAllArray() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        coll.addAll((boolean[]) null);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testRemoveAll() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        boolean first = coll.iterator().nextBoolean();
        coll.add(first);
        int size = coll.size();
        
        coll.removeAll(first);
        assertEquals(size - 2, coll.size());
        assertEquals(false, coll.contains(first));
    }

    public void testRemoveAllArray() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        coll.removeAll((boolean[]) null);
        verify();
    }

    //-----------------------------------------------------------------------
    public void testRetainAllArray() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        coll.retainAll((boolean[]) null);
        confirmed.clear();
        verify();
    }

    //-----------------------------------------------------------------------
    public void testClone() {
        resetFull();
        BooleanCollection coll = (BooleanCollection) collection;
        if (isCloneSupported()) {
            BooleanCollection coll2 = (BooleanCollection) coll.clone();
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
