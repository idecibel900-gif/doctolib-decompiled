package com.datadog.trace.api;

import com.datadog.trace.api.internal.util.LongStringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DD128bTraceId extends DDTraceId {
    public static final DD128bTraceId ZERO = new DD128bTraceId(0, 0, "00000000000000000000000000000000");
    private String hexStr;
    private final long highOrderBits;
    private final long lowOrderBits;
    private String str;

    private DD128bTraceId(long j, long j2, String str) {
        this.highOrderBits = j;
        this.lowOrderBits = j2;
        this.hexStr = str;
    }

    public static DD128bTraceId from(long j, long j2) {
        return new DD128bTraceId(j, j2, null);
    }

    @Override // com.datadog.trace.api.DDTraceId
    public String toHexString() {
        String str = this.hexStr;
        if (str != null) {
            return str;
        }
        String hexStringPadded = LongStringUtils.toHexStringPadded(this.highOrderBits, this.lowOrderBits, 32);
        this.hexStr = hexStringPadded;
        return hexStringPadded;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DD128bTraceId)) {
            return false;
        }
        DD128bTraceId dD128bTraceId = (DD128bTraceId) obj;
        return this.highOrderBits == dD128bTraceId.highOrderBits && this.lowOrderBits == dD128bTraceId.lowOrderBits;
    }

    public int hashCode() {
        long j = this.highOrderBits;
        long j2 = j ^ (j >>> 32);
        long j3 = this.lowOrderBits;
        return (int) ((j2 ^ j3) ^ (j3 >>> 32));
    }

    public String toString() {
        String str = this.str;
        if (str != null) {
            return str;
        }
        String strM = DD128bTraceId$$ExternalSyntheticBackport1.m(this.lowOrderBits, 10);
        this.str = strM;
        return strM;
    }
}
