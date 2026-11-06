package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntOffsetKt {
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m2586constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: plus-Nv-tHpc, reason: not valid java name */
    public static final long m2600plusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m1223getXimpl(j) + IntOffset.m2591getXimpl(j2), Offset.m1224getYimpl(j) + IntOffset.m2592getYimpl(j2));
    }

    /* JADX INFO: renamed from: minus-Nv-tHpc, reason: not valid java name */
    public static final long m2599minusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m1223getXimpl(j) - IntOffset.m2591getXimpl(j2), Offset.m1224getYimpl(j) - IntOffset.m2592getYimpl(j2));
    }

    /* JADX INFO: renamed from: round-k-4lQ0M, reason: not valid java name */
    public static final long m2601roundk4lQ0M(long j) {
        int iRound = Math.round(Offset.m1223getXimpl(j));
        return IntOffset.m2586constructorimpl((((long) Math.round(Offset.m1224getYimpl(j))) & 4294967295L) | (((long) iRound) << 32));
    }
}
