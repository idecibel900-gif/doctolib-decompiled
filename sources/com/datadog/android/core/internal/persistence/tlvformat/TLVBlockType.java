package com.datadog.android.core.internal.persistence.tlvformat;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.UShort;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum TLVBlockType {
    VERSION_CODE(0),
    DATA(1);

    public static final Companion Companion = new Companion(null);
    private static final Map map;
    private final short rawValue;

    TLVBlockType(short s) {
        this.rawValue = s;
    }

    /* JADX INFO: renamed from: getRawValue-Mh2AYeg, reason: not valid java name */
    public final short m3153getRawValueMh2AYeg() {
        return this.rawValue;
    }

    static {
        TLVBlockType[] tLVBlockTypeArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(tLVBlockTypeArrValues.length), 16));
        for (TLVBlockType tLVBlockType : tLVBlockTypeArrValues) {
            linkedHashMap.put(UShort.m5319boximpl(tLVBlockType.rawValue), tLVBlockType);
        }
        map = linkedHashMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: fromValue-xj2QHRw, reason: not valid java name */
        public final TLVBlockType m3154fromValuexj2QHRw(short s) {
            return (TLVBlockType) TLVBlockType.map.get(UShort.m5319boximpl(s));
        }
    }
}
