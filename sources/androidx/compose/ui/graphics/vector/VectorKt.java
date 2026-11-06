package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class VectorKt {
    private static final List EmptyPath = CollectionsKt.emptyList();
    private static final int DefaultStrokeLineCap = StrokeCap.Companion.m1500getButtKaPHkGw();
    private static final int DefaultStrokeLineJoin = StrokeJoin.Companion.m1508getMiterLxFBmk8();
    private static final int DefaultTintBlendMode = BlendMode.Companion.m1341getSrcIn0nO6VwU();
    private static final long DefaultTintColor = Color.Companion.m1384getTransparent0d7_KjU();
    private static final int DefaultFillType = PathFillType.Companion.m1468getNonZeroRgk1Os();

    public static final List getEmptyPath() {
        return EmptyPath;
    }

    public static final int getDefaultStrokeLineCap() {
        return DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return DefaultStrokeLineJoin;
    }

    public static final int getDefaultFillType() {
        return DefaultFillType;
    }

    /* JADX INFO: renamed from: rgbEqual--OWjLjI, reason: not valid java name */
    public static final boolean m1660rgbEqualOWjLjI(long j, long j2) {
        return Color.m1372getRedimpl(j) == Color.m1372getRedimpl(j2) && Color.m1371getGreenimpl(j) == Color.m1371getGreenimpl(j2) && Color.m1369getBlueimpl(j) == Color.m1369getBlueimpl(j2);
    }

    public static final boolean tintableWithAlphaMask(ColorFilter colorFilter) {
        if (!(colorFilter instanceof BlendModeColorFilter)) {
            return colorFilter == null;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) colorFilter;
        int iM1345getBlendMode0nO6VwU = blendModeColorFilter.m1345getBlendMode0nO6VwU();
        BlendMode.Companion companion = BlendMode.Companion;
        return BlendMode.m1313equalsimpl0(iM1345getBlendMode0nO6VwU, companion.m1341getSrcIn0nO6VwU()) || BlendMode.m1313equalsimpl0(blendModeColorFilter.m1345getBlendMode0nO6VwU(), companion.m1343getSrcOver0nO6VwU());
    }
}
