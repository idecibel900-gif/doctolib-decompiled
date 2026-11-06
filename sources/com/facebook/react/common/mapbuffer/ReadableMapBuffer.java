package com.facebook.react.common.mapbuffer;

import com.amazon.device.iap.internal.c.b;
import com.facebook.jni.HybridClassBase;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UShort;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002IHB\u0019\b\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0011J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010.\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b.\u0010\u0011J\u0017\u0010/\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010(J\u0017\u00100\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\u0011J\u0017\u00101\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u0010!J\u0017\u00102\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010+J\u0017\u00103\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010(J\u0017\u00104\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u0010\u000bJ\u000f\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020&2\b\u00108\u001a\u0004\u0018\u000107H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020)H\u0016¢\u0006\u0004\b;\u0010<J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=H\u0096\u0002¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010AR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010BR$\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00058\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bD\u0010B\u001a\u0004\bE\u00106R\u0014\u0010G\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u00106¨\u0006J"}, d2 = {"Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;", "Lcom/facebook/jni/HybridClassBase;", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "Ljava/nio/ByteBuffer;", "buffer", "", "offsetToMapBuffer", "<init>", "(Ljava/nio/ByteBuffer;I)V", b.as, "cloneWithOffset", "(I)Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;", "", "readHeader", "()V", "intKey", "getBucketIndexForKey", "(I)I", "bucketIndex", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "readDataType", "(I)Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", SubscriberAttributeKt.JSON_NAME_KEY, "expected", "getTypedValueOffsetForKey", "(ILcom/facebook/react/common/mapbuffer/MapBuffer$DataType;)I", "bufferPosition", "Lkotlin/UShort;", "readUnsignedShort-BwKQO78", "(I)S", "readUnsignedShort", "", "readDoubleValue", "(I)D", "readIntValue", "", "readLongValue", "(I)J", "", "readBooleanValue", "(I)Z", "", "readStringValue", "(I)Ljava/lang/String;", "position", "readMapBufferValue", "getKeyOffsetForBucketIndex", "contains", "getInt", "getDouble", "getString", "getBoolean", "getMapBuffer", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "iterator", "()Ljava/util/Iterator;", "Ljava/nio/ByteBuffer;", "I", "value", "count", "getCount", "getOffsetForDynamicData", "offsetForDynamicData", "Companion", "MapBufferEntry", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableMapBuffer extends HybridClassBase implements MapBuffer {
    private static final MapBuffer.DataType[] DATA_TYPES = MapBuffer.DataType.values();
    private final ByteBuffer buffer;
    private int count;
    private final int offsetToMapBuffer;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MapBuffer.DataType.values().length];
            try {
                iArr[MapBuffer.DataType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapBuffer.DataType.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MapBuffer.DataType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MapBuffer.DataType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MapBuffer.DataType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MapBuffer.DataType.MAP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DoNotStrip
    private ReadableMapBuffer(ByteBuffer byteBuffer, int i) {
        this.buffer = byteBuffer;
        this.offsetToMapBuffer = i;
        readHeader();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getCount() {
        return this.count;
    }

    private final ReadableMapBuffer cloneWithOffset(int offset) {
        ByteBuffer byteBufferDuplicate = this.buffer.duplicate();
        byteBufferDuplicate.position(offset);
        Intrinsics.checkNotNullExpressionValue(byteBufferDuplicate, "apply(...)");
        return new ReadableMapBuffer(byteBufferDuplicate, offset);
    }

    private final void readHeader() {
        if (this.buffer.getShort() != 254) {
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.count = m3353readUnsignedShortBwKQO78(this.buffer.position()) & 65535;
    }

    private final int getOffsetForDynamicData() {
        return getKeyOffsetForBucketIndex(getCount());
    }

    private final int getBucketIndexForKey(int intKey) {
        IntRange kEY_RANGE$ReactAndroid_release = MapBuffer.Companion.getKEY_RANGE$ReactAndroid_release();
        int first = kEY_RANGE$ReactAndroid_release.getFirst();
        if (intKey <= kEY_RANGE$ReactAndroid_release.getLast() && first <= intKey) {
            short sM5320constructorimpl = UShort.m5320constructorimpl((short) intKey);
            int count = getCount() - 1;
            int i = 0;
            while (i <= count) {
                int i2 = (i + count) >>> 1;
                int iM3353readUnsignedShortBwKQO78 = m3353readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(i2)) & 65535;
                int i3 = 65535 & sM5320constructorimpl;
                if (Intrinsics.compare(iM3353readUnsignedShortBwKQO78, i3) < 0) {
                    i = i2 + 1;
                } else {
                    if (Intrinsics.compare(iM3353readUnsignedShortBwKQO78, i3) <= 0) {
                        return i2;
                    }
                    count = i2 - 1;
                }
            }
        }
        return -1;
    }

    private final MapBuffer.DataType readDataType(int bucketIndex) {
        int iM3353readUnsignedShortBwKQO78 = m3353readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(bucketIndex) + 2) & 65535;
        if (ReactNativeFeatureFlags.enableAndroidTextMeasurementOptimizations()) {
            return DATA_TYPES[iM3353readUnsignedShortBwKQO78];
        }
        return MapBuffer.DataType.values()[iM3353readUnsignedShortBwKQO78];
    }

    private final int getTypedValueOffsetForKey(int key, MapBuffer.DataType expected) {
        int bucketIndexForKey = getBucketIndexForKey(key);
        if (bucketIndexForKey == -1) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        MapBuffer.DataType dataType = readDataType(bucketIndexForKey);
        if (dataType != expected) {
            throw new IllegalStateException(("Expected " + expected + " for key: " + key + ", found " + dataType + " instead.").toString());
        }
        return getKeyOffsetForBucketIndex(bucketIndexForKey) + 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: readUnsignedShort-BwKQO78, reason: not valid java name */
    public final short m3353readUnsignedShortBwKQO78(int bufferPosition) {
        return UShort.m5320constructorimpl(this.buffer.getShort(bufferPosition));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double readDoubleValue(int bufferPosition) {
        return this.buffer.getDouble(bufferPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int readIntValue(int bufferPosition) {
        return this.buffer.getInt(bufferPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readLongValue(int bufferPosition) {
        return this.buffer.getLong(bufferPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean readBooleanValue(int bufferPosition) {
        return readIntValue(bufferPosition) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String readStringValue(int bufferPosition) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(bufferPosition);
        int i = this.buffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i];
        this.buffer.position(offsetForDynamicData + 4);
        this.buffer.get(bArr, 0, i);
        return new String(bArr, Charsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableMapBuffer readMapBufferValue(int position) {
        return cloneWithOffset(getOffsetForDynamicData() + this.buffer.getInt(position) + 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getKeyOffsetForBucketIndex(int bucketIndex) {
        return this.offsetToMapBuffer + 8 + (bucketIndex * 12);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean contains(int key) {
        return getBucketIndexForKey(key) != -1;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getInt(int key) {
        return readIntValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.INT));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public double getDouble(int key) {
        return readDoubleValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.DOUBLE));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public String getString(int key) {
        return readStringValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.STRING));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean getBoolean(int key) {
        return readBooleanValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.BOOL));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public ReadableMapBuffer getMapBuffer(int key) {
        return readMapBufferValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.MAP));
    }

    public int hashCode() {
        this.buffer.rewind();
        return this.buffer.hashCode();
    }

    public boolean equals(Object other) {
        if (!(other instanceof ReadableMapBuffer)) {
            return false;
        }
        ByteBuffer byteBuffer = this.buffer;
        ByteBuffer byteBuffer2 = ((ReadableMapBuffer) other).buffer;
        if (byteBuffer == byteBuffer2) {
            return true;
        }
        byteBuffer.rewind();
        byteBuffer2.rewind();
        return Intrinsics.areEqual(byteBuffer, byteBuffer2);
    }

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder("{");
        CollectionsKt___CollectionsKt.joinTo(this, sb, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new Function1() { // from class: com.facebook.react.common.mapbuffer.ReadableMapBuffer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReadableMapBuffer.toString$lambda$5((MapBuffer.Entry) obj);
            }
        });
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$5(MapBuffer.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        StringBuilder sb = new StringBuilder();
        sb.append(entry.getKey());
        sb.append('=');
        switch (WhenMappings.$EnumSwitchMapping$0[entry.getType().ordinal()]) {
            case 1:
                sb.append(entry.getBooleanValue());
                return sb;
            case 2:
                sb.append(entry.getIntValue());
                return sb;
            case 3:
                sb.append(entry.getLongValue());
                return sb;
            case 4:
                sb.append(entry.getDoubleValue());
                return sb;
            case 5:
                sb.append('\"');
                sb.append(entry.getStringValue());
                sb.append('\"');
                return sb;
            case 6:
                sb.append(entry.getMapBufferValue().toString());
                return sb;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.facebook.react.common.mapbuffer.ReadableMapBuffer$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator, KMappedMarker {
        private int current;
        private final int last;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
            this.last = ReadableMapBuffer.this.getCount() - 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current <= this.last;
        }

        @Override // java.util.Iterator
        public MapBuffer.Entry next() {
            ReadableMapBuffer readableMapBuffer = ReadableMapBuffer.this;
            int i = this.current;
            this.current = i + 1;
            return readableMapBuffer.new MapBufferEntry(readableMapBuffer.getKeyOffsetForBucketIndex(i));
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    private final class MapBufferEntry implements MapBuffer.Entry {
        private final int bucketOffset;

        public MapBufferEntry(int i) {
            this.bucketOffset = i;
        }

        private final void assertType(MapBuffer.DataType dataType) {
            MapBuffer.DataType type = getType();
            if (dataType == type) {
                return;
            }
            throw new IllegalStateException(("Expected " + dataType + " for key: " + getKey() + " found " + type + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getKey() {
            return ReadableMapBuffer.this.m3353readUnsignedShortBwKQO78(this.bucketOffset) & 65535;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer.DataType getType() {
            return ReactNativeFeatureFlags.enableAndroidTextMeasurementOptimizations() ? ReadableMapBuffer.DATA_TYPES[65535 & ReadableMapBuffer.this.m3353readUnsignedShortBwKQO78(this.bucketOffset + 2)] : MapBuffer.DataType.values()[65535 & ReadableMapBuffer.this.m3353readUnsignedShortBwKQO78(this.bucketOffset + 2)];
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public double getDoubleValue() {
            assertType(MapBuffer.DataType.DOUBLE);
            return ReadableMapBuffer.this.readDoubleValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getIntValue() {
            assertType(MapBuffer.DataType.INT);
            return ReadableMapBuffer.this.readIntValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public long getLongValue() {
            assertType(MapBuffer.DataType.LONG);
            return ReadableMapBuffer.this.readLongValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public boolean getBooleanValue() {
            assertType(MapBuffer.DataType.BOOL);
            return ReadableMapBuffer.this.readBooleanValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public String getStringValue() {
            assertType(MapBuffer.DataType.STRING);
            return ReadableMapBuffer.this.readStringValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer getMapBufferValue() {
            assertType(MapBuffer.DataType.MAP);
            return ReadableMapBuffer.this.readMapBufferValue(this.bucketOffset + 4);
        }
    }
}
