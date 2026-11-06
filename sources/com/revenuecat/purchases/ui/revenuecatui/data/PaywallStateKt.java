package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0002*\u00020\rH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"currentColors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "getCurrentColors", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "isInFullScreenMode", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;)Z", "selectedLocalization", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "getSelectedLocalization", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "loadedLegacy", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallStateKt {
    public static final PaywallState.Loaded.Legacy loadedLegacy(PaywallState paywallState) {
        Intrinsics.checkNotNullParameter(paywallState, "<this>");
        if (paywallState instanceof PaywallState.Error) {
            return null;
        }
        if (paywallState instanceof PaywallState.Loaded) {
            PaywallState.Loaded loaded = (PaywallState.Loaded) paywallState;
            if (loaded instanceof PaywallState.Loaded.Legacy) {
                return (PaywallState.Loaded.Legacy) paywallState;
            }
            if (loaded instanceof PaywallState.Loaded.Components) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (paywallState instanceof PaywallState.Loading) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ProcessedLocalizedConfiguration getSelectedLocalization(PaywallState.Loaded.Legacy legacy) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        return ((TemplateConfiguration.PackageInfo) legacy.getSelectedPackage().getValue()).getLocalization();
    }

    public static final TemplateConfiguration.Colors getCurrentColors(PaywallState.Loaded.Legacy legacy, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(779612430, i, -1, "com.revenuecat.purchases.ui.revenuecatui.data.<get-currentColors> (PaywallState.kt:424)");
        }
        TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return currentColors;
    }

    public static final boolean isInFullScreenMode(PaywallState.Loaded.Legacy legacy) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        return PaywallModeKt.isFullScreen(legacy.getTemplateConfiguration().getMode());
    }
}
