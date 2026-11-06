package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class UIntArrayBuilder extends PrimitiveArrayBuilder {
    private int[] buffer;
    private int position;

    public /* synthetic */ UIntArrayBuilder(int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public /* bridge */ /* synthetic */ Object build$kotlinx_serialization_core() {
        return UIntArray.m5280boximpl(m5489buildhP7Qyg$kotlinx_serialization_core());
    }

    private UIntArrayBuilder(int[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = UIntArray.m5287getSizeimpl(bufferWithData);
        ensureCapacity$kotlinx_serialization_core(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int i) {
        if (UIntArray.m5287getSizeimpl(this.buffer) < i) {
            int[] iArr = this.buffer;
            int[] iArrCopyOf = Arrays.copyOf(iArr, RangesKt.coerceAtLeast(i, UIntArray.m5287getSizeimpl(iArr) * 2));
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.buffer = UIntArray.m5282constructorimpl(iArrCopyOf);
        }
    }

    /* JADX INFO: renamed from: append-WZ4Q5Ns$kotlinx_serialization_core, reason: not valid java name */
    public final void m5488appendWZ4Q5Ns$kotlinx_serialization_core(int i) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default(this, 0, 1, null);
        int[] iArr = this.buffer;
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        UIntArray.m5291setVXSXFK8(iArr, position$kotlinx_serialization_core, i);
    }

    /* JADX INFO: renamed from: build--hP7Qyg$kotlinx_serialization_core, reason: not valid java name */
    public int[] m5489buildhP7Qyg$kotlinx_serialization_core() {
        int[] iArrCopyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
        return UIntArray.m5282constructorimpl(iArrCopyOf);
    }
}
