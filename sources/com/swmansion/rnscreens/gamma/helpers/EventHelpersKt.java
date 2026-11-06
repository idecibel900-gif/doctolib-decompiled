package com.swmansion.rnscreens.gamma.helpers;

import com.swmansion.rnscreens.gamma.common.event.NamingAwareEventType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventHelpersKt {
    public static final Pair makeEventRegistrationInfo(NamingAwareEventType event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return TuplesKt.to(event.getEventName(), MapsKt.hashMapOf(TuplesKt.to("registrationName", event.getEventRegistrationName())));
    }
}
