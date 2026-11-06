package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class ColorVectorConverterKt {
    private static final Function1 ColorToVector = new Function1() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final TwoWayConverter invoke(final ColorSpace colorSpace) {
            return VectorConvertersKt.TwoWayConverter(new Function1() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m37invoke8_81llA(((Color) obj).m1375unboximpl());
                }

                /* JADX INFO: renamed from: invoke-8_81llA, reason: not valid java name */
                public final AnimationVector4D m37invoke8_81llA(long j) {
                    long jM1363convertvNxB06k = Color.m1363convertvNxB06k(j, ColorSpaces.INSTANCE.getOklab());
                    return new AnimationVector4D(Color.m1368getAlphaimpl(jM1363convertvNxB06k), Color.m1372getRedimpl(jM1363convertvNxB06k), Color.m1371getGreenimpl(jM1363convertvNxB06k), Color.m1369getBlueimpl(jM1363convertvNxB06k));
                }
            }, new Function1() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Color.m1361boximpl(m38invokevNxB06k((AnimationVector4D) obj));
                }

                /* JADX INFO: renamed from: invoke-vNxB06k, reason: not valid java name */
                public final long m38invokevNxB06k(AnimationVector4D animationVector4D) {
                    float v2 = animationVector4D.getV2();
                    if (v2 < 0.0f) {
                        v2 = 0.0f;
                    }
                    if (v2 > 1.0f) {
                        v2 = 1.0f;
                    }
                    float v3 = animationVector4D.getV3();
                    if (v3 < -0.5f) {
                        v3 = -0.5f;
                    }
                    if (v3 > 0.5f) {
                        v3 = 0.5f;
                    }
                    float v4 = animationVector4D.getV4();
                    float f = v4 >= -0.5f ? v4 : -0.5f;
                    float f2 = f <= 0.5f ? f : 0.5f;
                    float v1 = animationVector4D.getV1();
                    float f3 = v1 >= 0.0f ? v1 : 0.0f;
                    return Color.m1363convertvNxB06k(ColorKt.Color(v2, v3, f2, f3 <= 1.0f ? f3 : 1.0f, ColorSpaces.INSTANCE.getOklab()), colorSpace);
                }
            });
        }
    };

    public static final Function1 getVectorConverter(Color.Companion companion) {
        return ColorToVector;
    }
}
