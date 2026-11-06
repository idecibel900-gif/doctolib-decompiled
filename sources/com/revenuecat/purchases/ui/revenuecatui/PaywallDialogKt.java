package com.revenuecat.purchases.ui.revenuecatui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.composables.RevenueCatDialogScaffoldKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a3\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\n\u001aH\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010H\u0002¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002²\u0006\f\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u008a\u008e\u0002"}, d2 = {"PaywallDialog", "", "paywallDialogOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;Landroidx/compose/runtime/Composer;I)V", "PaywallDialogContent", "offeringSelection", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "onDismissRequest", "Lkotlin/Function1;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallDialogOptions;Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "buildPaywallOptions", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "dismissRequest", "Lkotlin/Function0;", "dismissRequestWithExitOffering", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "revenuecatui_defaultsBc8Release", "shouldDisplayDialog", "", "currentDialogOffering", "pendingExitOffering"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallDialogKt {
    public static final void PaywallDialog(final PaywallDialogOptions paywallDialogOptions, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paywallDialogOptions, "paywallDialogOptions");
        Composer composerStartRestartGroup = composer.startRestartGroup(1772149319);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(paywallDialogOptions) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772149319, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialog (PaywallDialog.kt:23)");
            }
            final Function1 shouldDisplayBlock = paywallDialogOptions.getShouldDisplayBlock();
            Object[] objArr = new Object[0];
            composerStartRestartGroup.startReplaceGroup(751283007);
            boolean zChanged = composerStartRestartGroup.changed(shouldDisplayBlock);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$shouldDisplayDialog$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(shouldDisplayBlock == null), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 6);
            composerStartRestartGroup.startReplaceGroup(751284803);
            if (shouldDisplayBlock != null) {
                composerStartRestartGroup.startReplaceGroup(751287246);
                boolean zChanged2 = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(shouldDisplayBlock);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new PaywallDialogKt$PaywallDialog$1$1(shouldDisplayBlock, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(paywallDialogOptions, (Function2) objRememberedValue2, composerStartRestartGroup, i2 & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(751292590);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PaywallDialog$lambda$1(mutableState) ? paywallDialogOptions.getOfferingSelection$revenuecatui_defaultsBc8Release() : null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(751298534);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue4;
            composerStartRestartGroup.endReplaceGroup();
            Boolean boolValueOf = Boolean.valueOf(PaywallDialog$lambda$1(mutableState));
            composerStartRestartGroup.startReplaceGroup(751301681);
            int i3 = i2 & 14;
            boolean zChanged3 = composerStartRestartGroup.changed(mutableState) | (i3 == 4);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new PaywallDialogKt$PaywallDialog$2$1(paywallDialogOptions, mutableState, mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(boolValueOf, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceGroup(751307991);
            boolean zChanged4 = composerStartRestartGroup.changed(mutableState) | (i3 == 4);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$dismissDialog$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m4033invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m4033invoke() {
                        mutableState2.setValue(null);
                        PaywallDialogKt.PaywallDialog$lambda$2(mutableState, false);
                        Function0 dismissRequest = paywallDialogOptions.getDismissRequest();
                        if (dismissRequest != null) {
                            dismissRequest.invoke();
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final Function0 function0 = (Function0) objRememberedValue6;
            composerStartRestartGroup.endReplaceGroup();
            OfferingSelection offeringSelectionPaywallDialog$lambda$5 = PaywallDialog$lambda$5(mutableState2);
            OfferingSelection offeringSelectionPaywallDialog$lambda$8 = PaywallDialog$lambda$8(mutableState3);
            composerStartRestartGroup.startReplaceGroup(751318540);
            boolean zChanged5 = composerStartRestartGroup.changed(shouldDisplayBlock) | composerStartRestartGroup.changed(function0);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged5 || objRememberedValue7 == companion.getEmpty()) {
                PaywallDialogKt$PaywallDialog$3$1 paywallDialogKt$PaywallDialog$3$1 = new PaywallDialogKt$PaywallDialog$3$1(shouldDisplayBlock, function0, mutableState2, mutableState3, null);
                composerStartRestartGroup.updateRememberedValue(paywallDialogKt$PaywallDialog$3$1);
                objRememberedValue7 = paywallDialogKt$PaywallDialog$3$1;
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(offeringSelectionPaywallDialog$lambda$5, offeringSelectionPaywallDialog$lambda$8, (Function2) objRememberedValue7, composerStartRestartGroup, 0);
            OfferingSelection offeringSelectionPaywallDialog$lambda$6 = PaywallDialog$lambda$5(mutableState2);
            if (offeringSelectionPaywallDialog$lambda$6 != null) {
                composerStartRestartGroup.startReplaceGroup(714520786);
                boolean zChanged6 = composerStartRestartGroup.changed(function0);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged6 || objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialog$4$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((OfferingSelection) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(OfferingSelection offeringSelection) {
                            if (offeringSelection == null) {
                                function0.invoke();
                            } else {
                                mutableState3.setValue(offeringSelection);
                                mutableState2.setValue(null);
                            }
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceGroup();
                PaywallDialogContent(paywallDialogOptions, offeringSelectionPaywallDialog$lambda$6, (Function1) objRememberedValue8, composerStartRestartGroup, i3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialog.5
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
                    PaywallDialogKt.PaywallDialog(paywallDialogOptions, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialog$lambda$2(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PaywallDialog$lambda$1(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$5(MutableState mutableState) {
        return (OfferingSelection) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferingSelection PaywallDialog$lambda$8(MutableState mutableState) {
        return (OfferingSelection) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallDialogContent(final PaywallDialogOptions paywallDialogOptions, final OfferingSelection offeringSelection, final Function1 function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(217055693);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(paywallDialogOptions) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(offeringSelection) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(217055693, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent (PaywallDialog.kt:92)");
            }
            composerStartRestartGroup.startReplaceGroup(-926362855);
            boolean z = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = buildPaywallOptions(paywallDialogOptions, offeringSelection, new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m4035invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m4035invoke() {
                        function1.invoke(null);
                    }
                }, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt$PaywallDialogContent$paywallOptions$1$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Offering) obj, (PaywallResult) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Offering offering, PaywallResult paywallResult) {
                        function1.invoke(offering != null ? new OfferingSelection.OfferingType(offering) : null);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PaywallOptions paywallOptions = (PaywallOptions) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            final PaywallViewModel paywallViewModel = InternalPaywallKt.getPaywallViewModel(paywallOptions, paywallDialogOptions.getShouldDisplayBlock(), composerStartRestartGroup, 0, 0);
            Unit unit = Unit.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-926343657);
            boolean zChanged = composerStartRestartGroup.changed(paywallViewModel);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new PaywallDialogKt$PaywallDialogContent$1$1(paywallViewModel, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2) objRememberedValue2, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceGroup(-926340225);
            boolean zChanged2 = composerStartRestartGroup.changed(paywallViewModel);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new PaywallDialogKt$PaywallDialogContent$2$1(paywallViewModel);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceGroup();
            RevenueCatDialogScaffoldKt.RevenueCatDialogScaffold((Function0) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(1910079027, true, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.3
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
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1910079027, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallDialogContent.<anonymous> (PaywallDialog.kt:116)");
                    }
                    InternalPaywallKt.InternalPaywall(paywallOptions, paywallViewModel, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.PaywallDialogKt.PaywallDialogContent.4
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
                    PaywallDialogKt.PaywallDialogContent(paywallDialogOptions, offeringSelection, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    static /* synthetic */ PaywallOptions buildPaywallOptions$default(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0 function0, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = null;
        }
        return buildPaywallOptions(paywallDialogOptions, offeringSelection, function0, function2);
    }

    private static final PaywallOptions buildPaywallOptions(PaywallDialogOptions paywallDialogOptions, OfferingSelection offeringSelection, Function0 function0, Function2 function2) {
        return new PaywallOptions.Builder(function0).setOfferingSelection$revenuecatui_defaultsBc8Release(offeringSelection).setShouldDisplayDismissButton(paywallDialogOptions.getShouldDisplayDismissButton()).setFontProvider(paywallDialogOptions.getFontProvider()).setListener(paywallDialogOptions.getListener()).setPurchaseLogic(paywallDialogOptions.getPurchaseLogic()).setDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release(function2).setCustomVariables(paywallDialogOptions.getCustomVariables()).build();
    }
}
