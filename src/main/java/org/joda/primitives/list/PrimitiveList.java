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
package org.joda.primitives.list;

import java.util.List;

import org.joda.primitives.collection.PrimitiveCollection;

/**
 * Base interface for all primitive list interfaces.
 * <p>
 * This interface extends {@link List} allowing seamless integration with other APIs.
 * All List methods can be used, using the primitive wrapper class.
 * However, it will be <em>much</em> more efficient to use the direct primitive methods
 * in the subinterface.
 * 
 * @author Stephen Colebourne
 * @version $Id: PrimitiveList.java,v 1.5 2006/03/27 22:42:12 scolebourne Exp $
 * @since 1.0
 */
public interface PrimitiveList extends PrimitiveCollection, List {

    /**
     * Gets the first list value.
     *
     * @return value at index zero, or null if the size is zero
     */
    Object first();

    /**
     * Gets the last list value.
     *
     * @return value at index <code>size() - 1</code> or null if the size is zero
     */
    Object last();

    /**
     * Removes a range of values from the list (optional operation).
     *
     * @param fromIndexInclusive  the start of the range to remove, inclusive
     * @param toIndexExclusive  the end of the range to remove, exclusive
     * @return <code>true</code> if the collection was modified
     * @throws UnsupportedOperationException if remove is not supported
     */
    boolean removeRange(int fromIndexInclusive, int toIndexExclusive);

}
