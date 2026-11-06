package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0081@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"resolveButtonText", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "resolveOfferingSuspend", "Lcom/revenuecat/purchases/Offering;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScreenOfferingExtensionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.values().length];
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.SPECIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt$resolveOfferingSuspend$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.ScreenOfferingExtensionsKt", f = "ScreenOfferingExtensions.kt", l = {14}, m = "resolveOfferingSuspend")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return ScreenOfferingExtensionsKt.resolveOfferingSuspend(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @InternalRevenueCatAPI
    public static final Object resolveOfferingSuspend(CustomerCenterConfigData.Screen screen, PurchasesType purchasesType, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        CustomerCenterConfigData.ScreenOffering offering;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwaitOfferings = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitOfferings);
            offering = screen.getOffering();
            if (offering == null) {
                return null;
            }
            anonymousClass1.L$0 = offering;
            anonymousClass1.label = 1;
            objAwaitOfferings = purchasesType.awaitOfferings(anonymousClass1);
            if (objAwaitOfferings == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            offering = (CustomerCenterConfigData.ScreenOffering) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAwaitOfferings);
        }
        Offerings offerings = (Offerings) objAwaitOfferings;
        int i3 = WhenMappings.$EnumSwitchMapping$0[offering.getType().ordinal()];
        if (i3 == 1) {
            return offerings.getCurrent();
        }
        if (i3 == 2) {
            String offeringId = offering.getOfferingId();
            if (offeringId != null) {
                return offerings.getAll().get(offeringId);
            }
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @InternalRevenueCatAPI
    public static final String resolveButtonText(CustomerCenterConfigData.Screen screen, CustomerCenterConfigData.Localization localization) {
        String buttonText;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Intrinsics.checkNotNullParameter(localization, "localization");
        CustomerCenterConfigData.ScreenOffering offering = screen.getOffering();
        return (offering == null || (buttonText = offering.getButtonText()) == null) ? localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BUY_SUBSCRIPTION) : buttonText;
    }
}
