package com.revenuecat.purchases.react.ui.events;

import com.revenuecat.purchases.react.ui.PaywallEventKey;
import com.revenuecat.purchases.react.ui.PaywallEventName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0006H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/react/ui/events/OnRestoreErrorEvent;", "Lcom/revenuecat/purchases/react/ui/events/PaywallEvent;", "surfaceId", "", "viewTag", "error", "", "", "", "<init>", "(IILjava/util/Map;)V", "getPaywallEventName", "Lcom/revenuecat/purchases/react/ui/PaywallEventName;", "getPayload", "Lcom/revenuecat/purchases/react/ui/PaywallEventKey;", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnRestoreErrorEvent extends PaywallEvent<OnRestoreErrorEvent> {
    private final Map<String, Object> error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnRestoreErrorEvent(int i, int i2, Map<String, ? extends Object> error) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public PaywallEventName getPaywallEventName() {
        return PaywallEventName.ON_RESTORE_ERROR;
    }

    @Override // com.revenuecat.purchases.react.ui.events.PaywallEvent
    public Map<PaywallEventKey, Map<String, Object>> getPayload() {
        return MapsKt.mapOf(TuplesKt.to(PaywallEventKey.ERROR, this.error));
    }
}
