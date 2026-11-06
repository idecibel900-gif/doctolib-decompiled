package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class EventsManager$Companion$paywalls$1 extends FunctionReferenceImpl implements Function1 {
    public static final EventsManager$Companion$paywalls$1 INSTANCE = new EventsManager$Companion$paywalls$1();

    EventsManager$Companion$paywalls$1() {
        super(1, PaywallStoredEvent.class, "toString", "toString()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(PaywallStoredEvent p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.toString();
    }
}
