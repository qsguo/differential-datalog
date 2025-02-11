/*
 * Copyright (c) 2021 VMware, Inc.
 * SPDX-License-Identifier: MIT
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.dbsp.algebraic.dynamicTyping.types;

import org.dbsp.algebraic.dynamicTyping.DynamicGroup;
import org.dbsp.circuits.operators.relational.DynamicZSetGroup;
import org.dbsp.compute.time.IntegerRing;

/**
 * The type of DynamicZSet objects.
 */
public class DynamicZSetType implements Type {
    final Type elementType;
    final DynamicGroup zsetGroup;

    public DynamicZSetType(Type elementType) {
        this.elementType = elementType;
        this.zsetGroup = new DynamicZSetGroup<Integer>(IntegerRing.instance).asUntyped();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicZSetType that = (DynamicZSetType) o;
        return this.elementType.equals(that.elementType);
    }

    @Override
    public int hashCode() {
        return this.elementType.hashCode();
    }

    @Override
    public DynamicGroup getGroup() {
        return this.zsetGroup;
    }

    @Override
    public String toString() {
        return "DynamicZSetType<" + this.elementType.toString() + ">";
    }
}
