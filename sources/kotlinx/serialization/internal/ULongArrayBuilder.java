package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.ULongArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ULongArrayBuilder extends PrimitiveArrayBuilder {
    private long[] buffer;
    private int position;

    public /* synthetic */ ULongArrayBuilder(long[] jArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(jArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ Object build$kotlinx_serialization_core() {
        return ULongArray.m5303boximpl(m5497buildY2RjT0g$kotlinx_serialization_core());
    }

    private ULongArrayBuilder(long[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = ULongArray.m5310getSizeimpl(bufferWithData);
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int i) {
        if (ULongArray.m5310getSizeimpl(this.buffer) < i) {
            long[] jArr = this.buffer;
            long[] jArrCopyOf = Arrays.copyOf(jArr, RangesKt.coerceAtLeast(i, ULongArray.m5310getSizeimpl(jArr) * 2));
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(this, newSize)");
            this.buffer = ULongArray.m5305constructorimpl(jArrCopyOf);
        }
    }

    /* JADX INFO: renamed from: append-VKZWuLQ$kotlinx_serialization_core, reason: not valid java name */
    public final void m5496appendVKZWuLQ$kotlinx_serialization_core(long j) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        long[] jArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        ULongArray.m5314setk8EXiF4(jArr, position$kotlinx_serialization_core, j);
    }

    /* JADX INFO: renamed from: build-Y2RjT0g$kotlinx_serialization_core, reason: not valid java name */
    public long[] m5497buildY2RjT0g$kotlinx_serialization_core() {
        long[] jArrCopyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(this, newSize)");
        return ULongArray.m5305constructorimpl(jArrCopyOf);
    }
}
