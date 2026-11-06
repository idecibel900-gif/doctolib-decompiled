package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"DefaultPaywallWarning", "", "warning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "warningColor", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "DefaultPaywallWarning-3IgeMak", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DefaultPaywallWarningKt {
    /* JADX INFO: renamed from: DefaultPaywallWarning-3IgeMak, reason: not valid java name */
    public static final void m4467DefaultPaywallWarning3IgeMak(final PaywallWarning warning, final long j, Modifier modifier, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(warning, "warning");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1893499378);
        if ((i & 1) == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if ((i2 & 4) != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1893499378, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallWarning (DefaultPaywallWarning.kt:13)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallWarningKt$DefaultPaywallWarning$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    DefaultPaywallWarningKt.m4467DefaultPaywallWarning3IgeMak(warning, j, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
