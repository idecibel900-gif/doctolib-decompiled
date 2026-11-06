package com.datadog.opentracing;

import java.math.BigInteger;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class StringCachingBigInteger extends BigInteger {
    private String cachedString;

    public StringCachingBigInteger(int i, Random random) {
        super(i, random);
    }

    @Override // java.math.BigInteger
    public String toString() {
        if (this.cachedString == null) {
            this.cachedString = super.toString();
        }
        return this.cachedString;
    }

    @Override // java.math.BigInteger
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.math.BigInteger
    public int hashCode() {
        return super.hashCode();
    }
}
