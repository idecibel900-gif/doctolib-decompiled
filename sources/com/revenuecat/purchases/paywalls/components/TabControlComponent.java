package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TabControlComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabControlComponent implements PaywallComponent {
    public static final TabControlComponent INSTANCE = new TabControlComponent();
    private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.TabControlComponent.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer invoke() {
            return new ObjectSerializer("tab_control", TabControlComponent.INSTANCE, new Annotation[0]);
        }
    });

    private TabControlComponent() {
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return (KSerializer) $cachedSerializer$delegate.getValue();
    }

    public final KSerializer serializer() {
        return get$cachedSerializer();
    }
}
