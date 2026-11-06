package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class Magnifier_androidKt {
    private static final SemanticsPropertyKey MagnifierPositionInRoot = new SemanticsPropertyKey("MagnifierPositionInRoot", null, 2, null);

    public static final boolean isPlatformMagnifierSupported(int i) {
        return i >= 28;
    }

    public static final SemanticsPropertyKey getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q$default, reason: not valid java name */
    public static /* synthetic */ Modifier m161magnifierjPUL71Q$default(Modifier modifier, Function1 function1, Function1 function2, Function1 function3, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            f = Float.NaN;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        if ((i & 32) != 0) {
            j = DpSize.Companion.m2581getUnspecifiedMYxV2XQ();
        }
        if ((i & 64) != 0) {
            f2 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 128) != 0) {
            f3 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            z2 = true;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0) {
            platformMagnifierFactory = null;
        }
        return m160magnifierjPUL71Q(modifier, function1, function2, function3, f, z, j, f2, f3, z2, platformMagnifierFactory);
    }

    /* JADX INFO: renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m160magnifierjPUL71Q(Modifier modifier, Function1 function1, Function1 function2, Function1 function3, float f, boolean z, long j, float f2, float f3, boolean z2, PlatformMagnifierFactory platformMagnifierFactory) {
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            return modifier.then(new MagnifierElement(function1, function2, function3, f, z, j, f2, f3, z2, platformMagnifierFactory == null ? PlatformMagnifierFactory.Companion.getForCurrentPlatform() : platformMagnifierFactory, null));
        }
        return modifier;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    public static final boolean equalsIncludingNaN(float f, float f2) {
        return (Float.isNaN(f) && Float.isNaN(f2)) || f == f2;
    }
}
