package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteArrayExtKt {
    public static /* synthetic */ byte[] join$default(Collection collection, byte[] bArr, byte[] bArr2, byte[] bArr3, InternalLogger internalLogger, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr2 = new byte[0];
        }
        if ((i & 4) != 0) {
            bArr3 = new byte[0];
        }
        return join(collection, bArr, bArr2, bArr3, internalLogger);
    }

    public static final byte[] join(Collection collection, byte[] separator, byte[] prefix, byte[] suffix, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Iterator it = collection.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        byte[] bArr = new byte[prefix.length + length + (collection.isEmpty() ? 0 : (collection.size() - 1) * separator.length) + suffix.length];
        copyTo(prefix, 0, bArr, 0, prefix.length, internalLogger);
        int length2 = prefix.length;
        for (IndexedValue indexedValue : CollectionsKt.withIndex(collection)) {
            copyTo((byte[]) indexedValue.getValue(), 0, bArr, length2, ((byte[]) indexedValue.getValue()).length, internalLogger);
            length2 += ((byte[]) indexedValue.getValue()).length;
            if (indexedValue.getIndex() != collection.size() - 1) {
                byte[] bArr2 = separator;
                copyTo(bArr2, 0, bArr, length2, separator.length, internalLogger);
                length2 += bArr2.length;
                separator = bArr2;
            }
        }
        copyTo(suffix, 0, bArr, length2, suffix.length, internalLogger);
        return bArr;
    }

    public static final boolean copyTo(byte[] bArr, int i, byte[] dest, int i2, int i3, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        if (i2 + i3 > dest.length) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.utils.ByteArrayExtKt.copyTo.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Cannot copy ByteArray, dest doesn't have enough space";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        if (i + i3 > bArr.length) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.utils.ByteArrayExtKt.copyTo.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Cannot copy ByteArray, src doesn't have enough data";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        System.arraycopy(bArr, i, dest, i2, i3);
        return true;
    }

    public static final int toInt(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ByteBuffer.wrap(bArr).getInt();
    }

    public static final short toShort(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ByteBuffer.wrap(bArr).getShort();
    }

    public static final byte[] copyOfRangeSafe(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            return ArraysKt.copyOfRange(bArr, i, i2);
        } catch (IllegalArgumentException unused) {
            return new byte[0];
        } catch (IndexOutOfBoundsException unused2) {
            return new byte[0];
        }
    }
}
