package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public abstract class MaterialThemeKt {
    private static final ProvidableCompositionLocal LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.MaterialThemeKt$LocalUsingExpressiveTheme$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });

    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, final Function2 function2, Composer composer, final int i, final int i2) {
        final ColorScheme colorScheme2;
        int i3;
        Shapes shapes2;
        Typography typography2;
        final Typography typography3;
        final Shapes shapes3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2127166334);
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                colorScheme2 = colorScheme;
                int i4 = composerStartRestartGroup.changed(colorScheme2) ? 4 : 2;
                i3 = i4 | i;
            } else {
                colorScheme2 = colorScheme;
            }
            i3 = i4 | i;
        } else {
            colorScheme2 = colorScheme;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shapes2 = shapes;
                int i5 = composerStartRestartGroup.changed(shapes2) ? 32 : 16;
                i3 |= i5;
            } else {
                shapes2 = shapes;
            }
            i3 |= i5;
        } else {
            shapes2 = shapes;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                typography2 = typography;
                int i6 = composerStartRestartGroup.changed(typography2) ? IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER : 128;
                i3 |= i6;
            } else {
                typography2 = typography;
            }
            i3 |= i6;
        } else {
            typography2 = typography;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
        }
        if ((i3 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
            int i7 = i3;
            final Typography typography4 = typography2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2127166334, i7, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:55)");
            }
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(colorScheme2), IndicationKt.getLocalIndication().provides(RippleKt.m813rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(CompatRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(colorScheme2, composerStartRestartGroup, i7 & 14)), TypographyKt.getLocalTypography().provides(typography4)}, ComposableLambdaKt.rememberComposableLambda(-1066563262, true, new Function2() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    if ((i8 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1066563262, i8, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:68)");
                    }
                    TextKt.ProvideTextStyle(typography4.getBodyLarge(), function2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Shapes shapes4 = shapes2;
            typography3 = typography4;
            shapes3 = shapes4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            shapes3 = shapes2;
            typography3 = typography2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MaterialThemeKt.MaterialTheme.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    MaterialThemeKt.MaterialTheme(colorScheme2, shapes3, typography3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        }
        long jM735getPrimary0d7_KjU = colorScheme.m735getPrimary0d7_KjU();
        boolean zChanged = composer.changed(jM735getPrimary0d7_KjU);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(jM735getPrimary0d7_KjU, Color.m1365copywmQWz5c$default(jM735getPrimary0d7_KjU, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.updateRememberedValue(textSelectionColors);
            objRememberedValue = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return textSelectionColors2;
    }
}
