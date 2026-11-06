package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\t\u001a\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00000\u0006H\u0080@¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\t\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00000\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b0\u0006H\u0000¢\u0006\u0004\b\t\u0010\r\u001a#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00000\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"", "isInPreviewMode", "(Landroidx/compose/runtime/Composer;I)Z", "", "windowAspectRatio", "(Landroidx/compose/runtime/Composer;I)F", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "shouldDisplayBlock", "shouldDisplayPaywall", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "result", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "entitlement", "shouldDisplayBlockForEntitlementIdentifier", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/app/Activity;", "LocalActivity", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalActivity", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HelperFunctionsKt {
    private static final ProvidableCompositionLocal LocalActivity = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt$LocalActivity$1
        @Override // kotlin.jvm.functions.Function0
        public final Activity invoke() {
            return null;
        }
    }, 1, null);

    public static final ProvidableCompositionLocal getLocalActivity() {
        return LocalActivity;
    }

    public static final boolean isInPreviewMode(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(774792703, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.isInPreviewMode (HelperFunctions.kt:23)");
        }
        boolean zBooleanValue = ((Boolean) composer.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return zBooleanValue;
    }

    public static final float windowAspectRatio(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1944383602, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.windowAspectRatio (HelperFunctions.kt:27)");
        }
        Configuration configuration = (Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        float f = configuration.screenHeightDp / configuration.screenWidthDp;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return f;
    }

    public static final void shouldDisplayPaywall(final Function1 shouldDisplayBlock, final Function1 result) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        Intrinsics.checkNotNullParameter(result, "result");
        ListenerConversionsKt.getCustomerInfoWith(Purchases.INSTANCE.getSharedInstance(), new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayPaywall.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Logger.INSTANCE.e("Error fetching customer info to display paywall", new PurchasesException(it));
                result.invoke(Boolean.FALSE);
            }
        }, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayPaywall.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean bool = (Boolean) shouldDisplayBlock.invoke(it);
                if (bool.booleanValue()) {
                    Logger.INSTANCE.d("Displaying paywall according to display logic");
                } else {
                    Logger.INSTANCE.d("Not displaying paywall according to display logic");
                }
                result.invoke(bool);
            }
        });
    }

    public static final Function1 shouldDisplayBlockForEntitlementIdentifier(final String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        return new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                EntitlementInfo entitlementInfo = customerInfo.getEntitlements().get(entitlement);
                boolean z = false;
                if (entitlementInfo != null && entitlementInfo.getIsActive()) {
                    z = true;
                }
                return Boolean.valueOf(!z);
            }
        };
    }

    public static final Object shouldDisplayPaywall(Function1 function1, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        shouldDisplayPaywall(function1, new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt$shouldDisplayPaywall$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, Boolean.valueOf(z));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
