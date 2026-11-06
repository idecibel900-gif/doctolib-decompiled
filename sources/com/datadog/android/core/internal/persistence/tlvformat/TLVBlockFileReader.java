package com.datadog.android.core.internal.persistence.tlvformat;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.UShort;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TLVBlockFileReader {
    public static final Companion Companion = new Companion(null);
    private final FileReaderWriter fileReaderWriter;
    private final InternalLogger internalLogger;

    public TLVBlockFileReader(InternalLogger internalLogger, FileReaderWriter fileReaderWriter) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(fileReaderWriter, "fileReaderWriter");
        this.internalLogger = internalLogger;
        this.fileReaderWriter = fileReaderWriter;
    }

    public final List read$dd_sdk_android_core_release(File file) {
        TLVResult block;
        Intrinsics.checkNotNullParameter(file, "file");
        byte[] bArr = (byte[]) this.fileReaderWriter.readData(file);
        ArrayList arrayList = new ArrayList();
        int newIndex = 0;
        while (newIndex < bArr.length && (block = readBlock(bArr, newIndex)) != null) {
            arrayList.add(block.getData());
            newIndex = block.getNewIndex();
        }
        return arrayList;
    }

    private final TLVResult readBlock(byte[] bArr, int i) {
        TLVResult data;
        TLVResult type = readType(bArr, i);
        if (type == null || (data = readData(bArr, type.getNewIndex())) == null) {
            return null;
        }
        return new TLVResult(new TLVBlock((TLVBlockType) type.getData(), (byte[]) data.getData(), this.internalLogger), data.getNewIndex());
    }

    private final TLVResult readType(byte[] bArr, int i) {
        int i2 = i + 2;
        if (i2 > bArr.length) {
            logFailedToDeserializeError();
            return null;
        }
        short s = ByteArrayExtKt.toShort(ByteArrayExtKt.copyOfRangeSafe(bArr, i, i2));
        TLVBlockType tLVBlockTypeM3154fromValuexj2QHRw = TLVBlockType.Companion.m3154fromValuexj2QHRw(UShort.m5320constructorimpl(s));
        if (tLVBlockTypeM3154fromValuexj2QHRw == null) {
            logTypeCorruptionError(s);
            return null;
        }
        return new TLVResult(tLVBlockTypeM3154fromValuexj2QHRw, i2);
    }

    private final TLVResult readData(byte[] bArr, int i) {
        int i2 = i + 4;
        if (i2 > bArr.length) {
            logFailedToDeserializeError();
            return null;
        }
        int i3 = ByteArrayExtKt.toInt(ByteArrayExtKt.copyOfRangeSafe(bArr, i, i2)) + i2;
        return new TLVResult(ByteArrayExtKt.copyOfRangeSafe(bArr, i2, i3), i3);
    }

    private final void logTypeCorruptionError(final short s) {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader.logTypeCorruptionError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "TLV header corrupt. Invalid type %s", Arrays.copyOf(new Object[]{Short.valueOf(s)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final void logFailedToDeserializeError() {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader.logFailedToDeserializeError.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Failed to deserialize TLV data length";
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private static final class TLVResult {
        private final Object data;
        private final int newIndex;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TLVResult)) {
                return false;
            }
            TLVResult tLVResult = (TLVResult) obj;
            return Intrinsics.areEqual(this.data, tLVResult.data) && this.newIndex == tLVResult.newIndex;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + Integer.hashCode(this.newIndex);
        }

        public String toString() {
            return "TLVResult(data=" + this.data + ", newIndex=" + this.newIndex + ")";
        }

        public TLVResult(Object data, int i) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.newIndex = i;
        }

        public final Object getData() {
            return this.data;
        }

        public final int getNewIndex() {
            return this.newIndex;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
