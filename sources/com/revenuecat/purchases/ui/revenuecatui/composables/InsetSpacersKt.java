package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsSizeKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"StatusBarSpacer", "", "(Landroidx/compose/runtime/Composer;I)V", "SystemBarsSpacer", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InsetSpacersKt {
    public static final void StatusBarSpacer(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-585549758);
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-585549758, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.StatusBarSpacer (InsetSpacers.kt:12)");
            }
            SpacerKt.Spacer(WindowInsetsSizeKt.windowInsetsTopHeight(Modifier.Companion, WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, composerStartRestartGroup, 6)), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt.StatusBarSpacer.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    InsetSpacersKt.StatusBarSpacer(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void SystemBarsSpacer(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1253623468);
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1253623468, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SystemBarsSpacer (InsetSpacers.kt:21)");
            }
            SpacerKt.Spacer(WindowInsetsSizeKt.windowInsetsBottomHeight(Modifier.Companion, WindowInsets_androidKt.getSystemBars(WindowInsets.Companion, composerStartRestartGroup, 6)), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.InsetSpacersKt.SystemBarsSpacer.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    InsetSpacersKt.SystemBarsSpacer(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
