package com.datadog.android.core.internal.persistence.tlvformat;

import com.datadog.android.api.InternalLogger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TLVBlock {
    public static final Companion Companion = new Companion(null);
    private final byte[] data;
    private final InternalLogger internalLogger;
    private final TLVBlockType type;

    public TLVBlock(TLVBlockType type, byte[] data, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.type = type;
        this.data = data;
        this.internalLogger = internalLogger;
    }

    public final TLVBlockType getType() {
        return this.type;
    }

    public final byte[] getData() {
        return this.data;
    }

    public static /* synthetic */ byte[] serialize$dd_sdk_android_core_release$default(TLVBlock tLVBlock, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 10485760;
        }
        return tLVBlock.serialize$dd_sdk_android_core_release(i);
    }

    public final byte[] serialize$dd_sdk_android_core_release(int i) {
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return null;
        }
        int length = bArr.length;
        int i2 = 6 + length;
        if (i2 > i) {
            logEntrySizeExceededError(i2, i);
            return null;
        }
        return ByteBuffer.allocate(i2).putShort(this.type.m3153getRawValueMh2AYeg()).putInt(length).put(this.data).array();
    }

    private final void logEntrySizeExceededError(final int i, final int i2) {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlock.logEntrySizeExceededError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "DataBlock length exceeds limit of %s bytes, was %s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
