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
package org.joda.primitives.iterator;

import java.util.Iterator;

/**
 * Base interface for all primitive iterator interfaces.
 * 
 * @author Stephen Colebourne
 * @version $Id: PrimitiveIterator.java,v 1.4 2006/03/27 22:42:11 scolebourne Exp $
 * @since 1.0
 */
public interface PrimitiveIterator extends Iterator {

    /**
     * Checks whether the iterator can currently be modified.
     *
     * @return <code>true</code> if the object can be modified
     */
    boolean isModifiable();

    /**
     * Checks whether the iterator can be reset.
     *
     * @return <code>true</code> if the object can be reset
     */
    boolean isResetable();

    /**
     * Resets the iterator back to its initial state.
     */
    void reset();

}
