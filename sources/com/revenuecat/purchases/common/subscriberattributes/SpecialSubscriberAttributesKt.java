package com.revenuecat.purchases.common.subscriberattributes;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getSubscriberAttributeKey", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpecialSubscriberAttributesKt {
    public static final SubscriberAttributeKey getSubscriberAttributeKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, ReservedSubscriberAttribute.EMAIL.getValue())) {
            return SubscriberAttributeKey.Email.INSTANCE;
        }
        if (Intrinsics.areEqual(str, ReservedSubscriberAttribute.DISPLAY_NAME.getValue())) {
            return SubscriberAttributeKey.DisplayName.INSTANCE;
        }
        if (Intrinsics.areEqual(str, ReservedSubscriberAttribute.PHONE_NUMBER.getValue())) {
            return SubscriberAttributeKey.PhoneNumber.INSTANCE;
        }
        return Intrinsics.areEqual(str, ReservedSubscriberAttribute.FCM_TOKENS.getValue()) ? SubscriberAttributeKey.FCMTokens.INSTANCE : new SubscriberAttributeKey.Custom(str);
    }
}
