package com.revenuecat.purchases.hybridcommon.ui;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ui/PaywallFragmentNonSerializableArgsStore;", "", "()V", ProductResponseJsonKeys.STORE, "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/revenuecat/purchases/hybridcommon/ui/PaywallFragmentNonSerializableArgs;", b.au, SubscriberAttributeKt.JSON_NAME_KEY, "put", "", "args", "remove", "hybridcommon-ui_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallFragmentNonSerializableArgsStore {
    public static final PaywallFragmentNonSerializableArgsStore INSTANCE = new PaywallFragmentNonSerializableArgsStore();
    private static final ConcurrentHashMap<String, PaywallFragmentNonSerializableArgs> store = new ConcurrentHashMap<>();

    private PaywallFragmentNonSerializableArgsStore() {
    }

    public final void put(String key, PaywallFragmentNonSerializableArgs args) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        store.put(key, args);
    }

    public final PaywallFragmentNonSerializableArgs get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return store.get(key);
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        store.remove(key);
    }
}
