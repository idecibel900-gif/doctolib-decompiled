package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "", "track", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallComponentInteractionTracker {
    void track(PaywallComponentInteractionData data);
}
