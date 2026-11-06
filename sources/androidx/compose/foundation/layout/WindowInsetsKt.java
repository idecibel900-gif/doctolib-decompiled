package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
public abstract class WindowInsetsKt {
    public static final WindowInsets union(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new UnionInsets(windowInsets, windowInsets2);
    }

    public static final WindowInsets exclude(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new ExcludeInsets(windowInsets, windowInsets2);
    }

    /* JADX INFO: renamed from: only-bOOhFvg, reason: not valid java name */
    public static final WindowInsets m347onlybOOhFvg(WindowInsets windowInsets, int i) {
        return new LimitInsets(windowInsets, i, null);
    }

    public static final PaddingValues asPaddingValues(WindowInsets windowInsets, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1485016250, i, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:244)");
        }
        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues(windowInsets, (Density) composer.consume(CompositionLocalsKt.getLocalDensity()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return insetsPaddingValues;
    }

    public static final PaddingValues asPaddingValues(WindowInsets windowInsets, Density density) {
        return new InsetsPaddingValues(windowInsets, density);
    }

    public static final WindowInsets WindowInsets(int i, int i2, int i3, int i4) {
        return new FixedIntInsets(i, i2, i3, i4);
    }
}
