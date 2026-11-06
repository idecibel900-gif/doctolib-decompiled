package com.revenuecat.purchases.hybridcommon.mappers;

/* JADX INFO: loaded from: classes4.dex */
class PurchasesMath {
    PurchasesMath() {
    }

    static int addExact(int i, int i2) {
        int i3 = i + i2;
        if (((i ^ i3) & (i2 ^ i3)) >= 0) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }

    static int multiplyExact(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        int i3 = (int) j;
        if (i3 == j) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }
}
