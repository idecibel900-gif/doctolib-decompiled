package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: classes.dex */
public final class IconButtonDefaults {
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();

    private IconButtonDefaults() {
    }

    public final IconButtonColors iconButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-1519621781);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1519621781, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:592)");
        }
        long jM1375unboximpl = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1375unboximpl();
        IconButtonColors iconButtonColorsM785defaultIconButtonColors4WTKRHQ$material3_release = m785defaultIconButtonColors4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM1375unboximpl);
        if (Color.m1367equalsimpl0(iconButtonColorsM785defaultIconButtonColors4WTKRHQ$material3_release.m784getContentColor0d7_KjU(), jM1375unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconButtonColorsM785defaultIconButtonColors4WTKRHQ$material3_release;
        }
        IconButtonColors iconButtonColorsM780copyjRlVdoo$default = IconButtonColors.m780copyjRlVdoo$default(iconButtonColorsM785defaultIconButtonColors4WTKRHQ$material3_release, 0L, jM1375unboximpl, 0L, Color.m1365copywmQWz5c$default(jM1375unboximpl, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconButtonColorsM780copyjRlVdoo$default;
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3_release, reason: not valid java name */
    public final IconButtonColors m785defaultIconButtonColors4WTKRHQ$material3_release(ColorScheme colorScheme, long j) {
        IconButtonColors defaultIconButtonColorsCached$material3_release = colorScheme.getDefaultIconButtonColorsCached$material3_release();
        if (defaultIconButtonColorsCached$material3_release != null) {
            return defaultIconButtonColorsCached$material3_release;
        }
        Color.Companion companion = Color.Companion;
        IconButtonColors iconButtonColors = new IconButtonColors(companion.m1384getTransparent0d7_KjU(), j, companion.m1384getTransparent0d7_KjU(), Color.m1365copywmQWz5c$default(j, 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonColorsCached$material3_release(iconButtonColors);
        return iconButtonColors;
    }
}
