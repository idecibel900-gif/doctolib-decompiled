package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005Jk\u0010\u0013\u001a\u00020\u000b2 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u00062\u0006\u0010\t\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2$\u0010\u0012\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributesPoster;", "", "Lcom/revenuecat/purchases/common/BackendHelper;", "backendHelper", "<init>", "(Lcom/revenuecat/purchases/common/BackendHelper;)V", "", "", "attributes", "appUserID", "Lkotlin/Function0;", "", "onSuccessHandler", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/PurchasesError;", "", "", "Lcom/revenuecat/purchases/common/SubscriberAttributeError;", "onErrorHandler", "postSubscriberAttributes", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "Lcom/revenuecat/purchases/common/BackendHelper;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SubscriberAttributesPoster {
    private final BackendHelper backendHelper;

    public SubscriberAttributesPoster(BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
    }

    public final void postSubscriberAttributes(Map<String, ? extends Map<String, ? extends Object>> attributes, String appUserID, final Function0 onSuccessHandler, final Function3 onErrorHandler) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccessHandler, "onSuccessHandler");
        Intrinsics.checkNotNullParameter(onErrorHandler, "onErrorHandler");
        this.backendHelper.performRequest(new Endpoint.PostAttributes(appUserID), MapsKt.mapOf(TuplesKt.to("attributes", attributes)), null, Delay.DEFAULT, new Function1() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster.postSubscriberAttributes.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onErrorHandler.invoke(error, Boolean.FALSE, CollectionsKt.emptyList());
            }
        }, new Function3() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster.postSubscriberAttributes.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws JSONException {
                invoke((PurchasesError) obj, ((Number) obj2).intValue(), (JSONObject) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError, int i, JSONObject body) throws JSONException {
                Unit unit;
                Intrinsics.checkNotNullParameter(body, "body");
                if (purchasesError != null) {
                    Function3 function3 = onErrorHandler;
                    boolean zIsServerError = RCHTTPStatusCodes.INSTANCE.isServerError(i);
                    boolean z = false;
                    boolean z2 = i == 404;
                    if (!zIsServerError && !z2) {
                        z = true;
                    }
                    List<SubscriberAttributeError> listEmptyList = CollectionsKt.emptyList();
                    if (purchasesError.getCode() == PurchasesErrorCode.InvalidSubscriberAttributesError) {
                        listEmptyList = BackendHelpersKt.getAttributeErrors(body);
                    }
                    function3.invoke(purchasesError, Boolean.valueOf(z), listEmptyList);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    onSuccessHandler.invoke();
                }
            }
        });
    }
}
