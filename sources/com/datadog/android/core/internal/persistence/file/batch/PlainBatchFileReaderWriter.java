package com.datadog.android.core.internal.persistence.file.batch;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PlainBatchFileReaderWriter implements BatchFileReaderWriter {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    public PlainBatchFileReaderWriter(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.core.internal.persistence.file.FileWriter
    public boolean writeData(final File file, RawBatchEvent data, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            lockFileAndWriteData(file, z, data);
            return true;
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf(InternalLogger.Target.MAINTAINER), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.writeData.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to write data to file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return false;
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.writeData.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to write data to file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return false;
        }
    }

    @Override // com.datadog.android.core.internal.persistence.file.batch.BatchFileReader
    public List readData(final File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            return readFileData(file);
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readData.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to read data from file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return CollectionsKt.emptyList();
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readData.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Unable to read data from file: %s", Arrays.copyOf(new Object[]{file.getPath()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return CollectionsKt.emptyList();
        }
    }

    private final void lockFileAndWriteData(File file, boolean z, RawBatchEvent rawBatchEvent) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, z);
        try {
            FileLock fileLockLock = fileOutputStream.getChannel().lock();
            Intrinsics.checkNotNullExpressionValue(fileLockLock, "outputStream.channel.lock()");
            try {
                byte[] metadata = rawBatchEvent.getMetadata();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(metadata.length + 6 + rawBatchEvent.getData().length + 6);
                Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(metaBlockSize + dataBlockSize)");
                fileOutputStream.write(putAsTlv(putAsTlv(byteBufferAllocate, BlockType.META, metadata), BlockType.EVENT, rawBatchEvent.getData()).array());
                Unit unit = Unit.INSTANCE;
                fileLockLock.release();
                CloseableKt.closeFinally(fileOutputStream, null);
            } catch (Throwable th) {
                fileLockLock.release();
                throw th;
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(fileOutputStream, th2);
                throw th3;
            }
        }
    }

    private final List readFileData(final File file) throws IOException {
        int iLengthSafe = (int) FileExtKt.lengthSafe(file, this.internalLogger);
        ArrayList arrayList = new ArrayList();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
        int bytesRead = iLengthSafe;
        while (bytesRead > 0) {
            try {
                BlockReadResult block = readBlock(bufferedInputStream, BlockType.META);
                if (block.getData() == null) {
                    bytesRead -= block.getBytesRead();
                    break;
                }
                BlockReadResult block2 = readBlock(bufferedInputStream, BlockType.EVENT);
                bytesRead -= block.getBytesRead() + block2.getBytesRead();
                if (block2.getData() == null) {
                    break;
                }
                arrayList.add(new RawBatchEvent(block2.getData(), block.getData()));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedInputStream, th);
                    throw th2;
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(bufferedInputStream, null);
        if (bytesRead == 0 && (iLengthSafe <= 0 || !arrayList.isEmpty())) {
            return arrayList;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readFileData.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "File %s is probably corrupted, not all content was read.", Arrays.copyOf(new Object[]{file.getPath()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return arrayList;
    }

    private final BlockReadResult readBlock(InputStream inputStream, final BlockType blockType) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(6);
        int i = inputStream.read(byteBufferAllocate.array());
        if (!checkReadExpected(6, i, "Block(" + blockType.name() + "): Header read")) {
            return new BlockReadResult(null, Math.max(0, i));
        }
        final short s = byteBufferAllocate.getShort();
        if (s != blockType.getIdentifier()) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.readBlock.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    short s2 = s;
                    BlockType blockType2 = blockType;
                    return "Unexpected block type identifier=" + ((int) s2) + " met, was expecting " + blockType2 + "(" + ((int) blockType2.getIdentifier()) + ")";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return new BlockReadResult(null, i);
        }
        int i2 = byteBufferAllocate.getInt();
        byte[] bArr = new byte[i2];
        int i3 = inputStream.read(bArr);
        if (checkReadExpected(i2, i3, "Block(" + blockType.name() + "):Data read")) {
            return new BlockReadResult(bArr, i + i3);
        }
        return new BlockReadResult(null, i + Math.max(0, i3));
    }

    private final boolean checkReadExpected(final int i, final int i2, final String str) {
        if (i == i2) {
            return true;
        }
        if (i2 != -1) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.checkReadExpected.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Number of bytes read for operation='" + str + "' doesn't match with expected: expected=" + i + ", actual=" + i2;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return false;
        }
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.persistence.file.batch.PlainBatchFileReaderWriter.checkReadExpected.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Unexpected EOF at the operation=" + str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
        return false;
    }

    private final ByteBuffer putAsTlv(ByteBuffer byteBuffer, BlockType blockType, byte[] bArr) {
        ByteBuffer byteBufferPut = byteBuffer.putShort(blockType.getIdentifier()).putInt(bArr.length).put(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferPut, "this\n            .putSho…e)\n            .put(data)");
        return byteBufferPut;
    }

    private static final class BlockReadResult {
        private final int bytesRead;
        private final byte[] data;

        public BlockReadResult(byte[] bArr, int i) {
            this.data = bArr;
            this.bytesRead = i;
        }

        public final byte[] getData() {
            return this.data;
        }

        public final int getBytesRead() {
            return this.bytesRead;
        }
    }

    private enum BlockType {
        EVENT(0),
        META(1);

        private final short identifier;

        BlockType(short s) {
            this.identifier = s;
        }

        public final short getIdentifier() {
            return this.identifier;
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
