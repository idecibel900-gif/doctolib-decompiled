package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;

/* JADX INFO: loaded from: classes.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo231toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo225roundToPx0680j_4(float f) {
        float fMo231toPx0680j_4 = mo231toPx0680j_4(f);
        if (Float.isInfinite(fMo231toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo231toPx0680j_4);
    }

    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo230toPxR2X_6o(long j) {
        if (!TextUnitType.m2635equalsimpl0(TextUnit.m2621getTypeUIouoOA(j), TextUnitType.Companion.m2640getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px");
        }
        return mo231toPx0680j_4(mo226toDpGaN1DYA(j));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo228toDpu2uoSUM(int i) {
        return Dp.m2551constructorimpl(i / getDensity());
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo227toDpu2uoSUM(float f) {
        return Dp.m2551constructorimpl(f / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo234toSpkPz2Gy4(float f) {
        return mo233toSp0xMU5do(mo227toDpu2uoSUM(f));
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo232toSizeXkaWNTQ(long j) {
        if (j != 9205357640488583168L) {
            return SizeKt.Size(mo231toPx0680j_4(DpSize.m2577getWidthD9Ej5fM(j)), mo231toPx0680j_4(DpSize.m2576getHeightD9Ej5fM(j)));
        }
        return Size.Companion.m1266getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo229toDpSizekrfVVM(long j) {
        if (j != 9205357640488583168L) {
            return DpKt.m2562DpSizeYgX7TsA(mo227toDpu2uoSUM(Size.m1261getWidthimpl(j)), mo227toDpu2uoSUM(Size.m1259getHeightimpl(j)));
        }
        return DpSize.Companion.m2581getUnspecifiedMYxV2XQ();
    }
}
