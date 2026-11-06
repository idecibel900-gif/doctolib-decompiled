package expo.modules.kotlin.jni;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public enum TypedArrayKind {
    Int8Array(0, 1, null),
    Int16Array(0, 1, null),
    Int32Array(0, 1, null),
    Uint8Array(0, 1, null),
    Uint8ClampedArray(0, 1, null),
    Uint16Array(0, 1, null),
    Uint32Array(0, 1, null),
    Float32Array(0, 1, null),
    Float64Array(0, 1, null),
    BigInt64Array(0, 1, null),
    BigUint64Array(0, 1, null);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    TypedArrayKind(int i) {
        this.value = i;
    }

    /* synthetic */ TypedArrayKind(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? JavaScriptTypedArrayKt.nextValue() : i);
    }

    public final int getValue() {
        return this.value;
    }
}
