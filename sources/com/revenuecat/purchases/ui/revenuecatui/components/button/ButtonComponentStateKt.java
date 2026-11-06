package com.revenuecat.purchases.ui.revenuecatui.components.button;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.intl.Locale;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"rememberButtonComponentState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/button/ButtonComponentState;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "localeProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/text/intl/Locale;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/button/ButtonComponentState;", "paywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/button/ButtonComponentState;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ButtonComponentStateKt {
    public static final /* synthetic */ ButtonComponentState rememberButtonComponentState(ButtonComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.startReplaceGroup(1389420952);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1389420952, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.rememberButtonComponentState (ButtonComponentState.kt:26)");
        }
        composer.startReplaceGroup(1826062199);
        boolean z = (((i & 112) ^ 48) > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentStateKt$rememberButtonComponentState$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Locale invoke() {
                    return paywallState.getLocale();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        ButtonComponentState buttonComponentStateRememberButtonComponentState = rememberButtonComponentState(style, (Function0) objRememberedValue, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return buttonComponentStateRememberButtonComponentState;
    }

    public static final /* synthetic */ ButtonComponentState rememberButtonComponentState(ButtonComponentStyle style, Function0 localeProvider, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        composer.startReplaceGroup(-1664983180);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1664983180, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.rememberButtonComponentState (ButtonComponentState.kt:37)");
        }
        composer.startReplaceGroup(1826068755);
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(style)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new ButtonComponentState(style, localeProvider);
            composer.updateRememberedValue(objRememberedValue);
        }
        ButtonComponentState buttonComponentState = (ButtonComponentState) objRememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return buttonComponentState;
    }
}
