package com.datadog.trace.api;

import com.datadog.trace.api.internal.util.LongStringUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DD64bTraceId extends DDTraceId {
    public static final DD64bTraceId MAX = new DD64bTraceId(-1, "18446744073709551615");
    private String hexStr;
    private final long id;
    private String str;

    DD64bTraceId(long j, String str) {
        this.id = j;
        this.str = str;
    }

    public static DD64bTraceId from(long j) {
        return create(j, null);
    }

    static DD64bTraceId create(long j, String str) {
        DDTraceId dDTraceId;
        if (j == 0 && (dDTraceId = DDTraceId.ZERO) != null) {
            return (DD64bTraceId) dDTraceId;
        }
        if (j == -1) {
            return MAX;
        }
        return new DD64bTraceId(j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DD64bTraceId) && this.id == ((DD64bTraceId) obj).id;
    }

    public int hashCode() {
        long j = this.id;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        String str = this.str;
        if (str != null) {
            return str;
        }
        String strM = DD128bTraceId$$ExternalSyntheticBackport1.m(this.id, 10);
        this.str = strM;
        return strM;
    }

    @Override // com.datadog.trace.api.DDTraceId
    public String toHexString() {
        String str = this.hexStr;
        if (str != null) {
            return str;
        }
        String hexStringPadded = LongStringUtils.toHexStringPadded(this.id, 32);
        this.hexStr = hexStringPadded;
        return hexStringPadded;
    }
}
