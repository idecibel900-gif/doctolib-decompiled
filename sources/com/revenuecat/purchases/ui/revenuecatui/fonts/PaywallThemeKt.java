package com.revenuecat.purchases.ui.revenuecatui.fonts;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.revenuecat.purchases.ui.revenuecatui.extensions.TypographyExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "fontProvider", "Lkotlin/Function0;", "", "content", "PaywallTheme", "(Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallThemeKt {
    public static final void PaywallTheme(final FontProvider fontProvider, Function2 content, Composer composer, final int i) {
        int i2;
        final Function2 function2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1433874321);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(fontProvider) : composerStartRestartGroup.changedInstance(fontProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1433874321, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallTheme (PaywallTheme.kt:10)");
            }
            if (fontProvider == null) {
                composerStartRestartGroup.startReplaceGroup(1090937919);
                content.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceGroup();
                function2 = content;
            } else {
                composerStartRestartGroup.startReplaceGroup(1090975739);
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i3 = MaterialTheme.$stable;
                function2 = content;
                MaterialThemeKt.MaterialTheme(materialTheme.getColorScheme(composerStartRestartGroup, i3), materialTheme.getShapes(composerStartRestartGroup, i3), TypographyExtensionsKt.copyWithFontProvider(materialTheme.getTypography(composerStartRestartGroup, i3), fontProvider), function2, composerStartRestartGroup, (i2 << 6) & 7168, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function2 = content;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallThemeKt.PaywallTheme.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    PaywallThemeKt.PaywallTheme(fontProvider, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
