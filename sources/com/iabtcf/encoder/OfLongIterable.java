package com.iabtcf.encoder;

import com.iabtcf.utils.Objects;
import com.iabtcf.utils.PrimitiveIterator;
import com.iabtcf.utils.function.LongConsumer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
class OfLongIterable {
    private long[] array = new long[10];
    private int size = 0;

    OfLongIterable() {
    }

    public void add(long j) {
        int i = this.size;
        long[] jArr = this.array;
        if (i == jArr.length) {
            this.array = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OfLongIterable ofLongIterable = (OfLongIterable) obj;
        return Arrays.equals(this.array, ofLongIterable.array) && this.size == ofLongIterable.size;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.array) + 31) * 31) + this.size;
    }

    public PrimitiveIterator.OfLong longIterator() {
        return new PrimitiveIterator.OfLong() { // from class: com.iabtcf.encoder.OfLongIterable.1
            int i = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.i < OfLongIterable.this.size;
            }

            @Override // com.iabtcf.utils.PrimitiveIterator.OfLong
            public long nextLong() {
                long[] jArr = OfLongIterable.this.array;
                int i = this.i;
                this.i = i + 1;
                return jArr[i];
            }

            @Override // com.iabtcf.utils.PrimitiveIterator
            public void forEachRemaining(LongConsumer longConsumer) {
                Objects.requireNonNull(longConsumer);
                while (hasNext()) {
                    longConsumer.accept(nextLong());
                }
            }

            @Override // java.util.Iterator
            public Long next() {
                return Long.valueOf(nextLong());
            }
        };
    }

    public int size() {
        return this.size;
    }
}
