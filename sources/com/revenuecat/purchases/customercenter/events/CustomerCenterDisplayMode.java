package com.revenuecat.purchases.customercenter.events;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", "", "(Ljava/lang/String;I)V", "FULL_SCREEN", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum CustomerCenterDisplayMode {
    FULL_SCREEN;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer invoke() {
            return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode", CustomerCenterDisplayMode.values(), new String[]{"full_screen"}, new Annotation[][]{null}, null);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CustomerCenterDisplayMode.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer serializer() {
            return get$cachedSerializer();
        }
    }
}
