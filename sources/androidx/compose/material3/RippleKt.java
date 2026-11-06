package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class RippleKt {
    private static final RippleNodeFactory DefaultBoundedRipple;
    private static final RippleNodeFactory DefaultUnboundedRipple;
    private static final ProvidableCompositionLocal LocalUseFallbackRippleImplementation = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.RippleKt$LocalUseFallbackRippleImplementation$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });
    private static final ProvidableCompositionLocal LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.RippleKt$LocalRippleConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        public final RippleConfiguration invoke() {
            return new RippleConfiguration(0L, null, 3, null);
        }
    }, 1, null);

    /* JADX INFO: renamed from: ripple-H2RKhps$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m812rippleH2RKhps$default(boolean z, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            j = Color.Companion.m1385getUnspecified0d7_KjU();
        }
        return m811rippleH2RKhps(z, f, j);
    }

    /* JADX INFO: renamed from: ripple-H2RKhps, reason: not valid java name */
    public static final IndicationNodeFactory m811rippleH2RKhps(boolean z, float f, long j) {
        if (Dp.m2553equalsimpl0(f, Dp.Companion.m2560getUnspecifiedD9Ej5fM()) && Color.m1367equalsimpl0(j, Color.Companion.m1385getUnspecified0d7_KjU())) {
            return z ? DefaultBoundedRipple : DefaultUnboundedRipple;
        }
        return new RippleNodeFactory(z, f, j, (DefaultConstructorMarker) null);
    }

    static {
        Dp.Companion companion = Dp.Companion;
        float fM2560getUnspecifiedD9Ej5fM = companion.m2560getUnspecifiedD9Ej5fM();
        Color.Companion companion2 = Color.Companion;
        DefaultBoundedRipple = new RippleNodeFactory(true, fM2560getUnspecifiedD9Ej5fM, companion2.m1385getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        DefaultUnboundedRipple = new RippleNodeFactory(false, companion.m2560getUnspecifiedD9Ej5fM(), companion2.m1385getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
    }

    public static final ProvidableCompositionLocal getLocalRippleConfiguration() {
        return LocalRippleConfiguration;
    }

    /* JADX INFO: renamed from: rippleOrFallbackImplementation-9IZ8Weo, reason: not valid java name */
    public static final Indication m813rippleOrFallbackImplementation9IZ8Weo(boolean z, float f, long j, Composer composer, int i, int i2) {
        Composer composer2;
        Indication indicationM811rippleH2RKhps;
        if ((i2 & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        float f2 = f;
        if ((i2 & 4) != 0) {
            j = Color.Companion.m1385getUnspecified0d7_KjU();
        }
        long j2 = j;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1315814667, i, -1, "androidx.compose.material3.rippleOrFallbackImplementation (Ripple.kt:230)");
        }
        composer.startReplaceGroup(-1280632857);
        if (((Boolean) composer.consume(LocalUseFallbackRippleImplementation)).booleanValue()) {
            composer2 = composer;
            indicationM811rippleH2RKhps = androidx.compose.material.ripple.RippleKt.m680rememberRipple9IZ8Weo(z2, f2, j2, composer2, i & 1022, 0);
        } else {
            composer2 = composer;
            indicationM811rippleH2RKhps = m811rippleH2RKhps(z2, f2, j2);
        }
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return indicationM811rippleH2RKhps;
    }
}
