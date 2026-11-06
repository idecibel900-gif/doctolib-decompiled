package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/events/FeatureEvent;", "", "isPriorityEvent", "", "()Z", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FeatureEvent {
    default boolean isPriorityEvent() {
        return false;
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isPriorityEvent(FeatureEvent featureEvent) {
            return FeatureEvent.super.isPriorityEvent();
        }
    }
}
