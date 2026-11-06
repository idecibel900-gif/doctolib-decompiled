package com.revenuecat.purchases.ui.revenuecatui.activity;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityNonSerializableArgsStore;", "", "()V", "argsByHashCode", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityNonSerializableArgs;", "clear", "", b.au, SubscriberAttributeKt.JSON_NAME_KEY, "remove", ProductResponseJsonKeys.STORE, "args", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallActivityNonSerializableArgsStore {
    public static final PaywallActivityNonSerializableArgsStore INSTANCE = new PaywallActivityNonSerializableArgsStore();
    private static final Map<Integer, PaywallActivityNonSerializableArgs> argsByHashCode = new LinkedHashMap();
    public static final int $stable = 8;

    private PaywallActivityNonSerializableArgsStore() {
    }

    public final synchronized int store(PaywallActivityNonSerializableArgs args) {
        int iIdentityHashCode;
        Intrinsics.checkNotNullParameter(args, "args");
        iIdentityHashCode = System.identityHashCode(args);
        argsByHashCode.put(Integer.valueOf(iIdentityHashCode), args);
        return iIdentityHashCode;
    }

    public final synchronized PaywallActivityNonSerializableArgs get(int key) {
        return argsByHashCode.get(Integer.valueOf(key));
    }

    public final synchronized void remove(int key) {
        argsByHashCode.remove(Integer.valueOf(key));
    }

    public final synchronized void clear() {
        argsByHashCode.clear();
    }
}
