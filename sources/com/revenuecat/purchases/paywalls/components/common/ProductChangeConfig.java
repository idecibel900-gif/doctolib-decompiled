package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.paywalls.components.common.serializers.DowngradeReplacementModeDeserializer;
import com.revenuecat.purchases.paywalls.components.common.serializers.UpgradeReplacementModeDeserializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017HÁ\u0001¢\u0006\u0002\b\u0018R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "", "seen1", "", "upgradeReplacementMode", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "downgradeReplacementMode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/models/StoreReplacementMode;Lcom/revenuecat/purchases/models/StoreReplacementMode;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/models/StoreReplacementMode;Lcom/revenuecat/purchases/models/StoreReplacementMode;)V", "getDowngradeReplacementMode$annotations", "()V", "getDowngradeReplacementMode", "()Lcom/revenuecat/purchases/models/StoreReplacementMode;", "getUpgradeReplacementMode$annotations", "getUpgradeReplacementMode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProductChangeConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreReplacementMode downgradeReplacementMode;
    private final StoreReplacementMode upgradeReplacementMode;

    /* JADX WARN: Multi-variable type inference failed */
    public ProductChangeConfig() {
        this((StoreReplacementMode) null, (StoreReplacementMode) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ void getDowngradeReplacementMode$annotations() {
    }

    public static /* synthetic */ void getUpgradeReplacementMode$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductChangeConfig)) {
            return false;
        }
        ProductChangeConfig productChangeConfig = (ProductChangeConfig) obj;
        return Intrinsics.areEqual(this.upgradeReplacementMode, productChangeConfig.upgradeReplacementMode) && Intrinsics.areEqual(this.downgradeReplacementMode, productChangeConfig.downgradeReplacementMode);
    }

    public int hashCode() {
        return (this.upgradeReplacementMode.hashCode() * 31) + this.downgradeReplacementMode.hashCode();
    }

    public String toString() {
        return "ProductChangeConfig(upgradeReplacementMode=" + this.upgradeReplacementMode + ", downgradeReplacementMode=" + this.downgradeReplacementMode + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return ProductChangeConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ ProductChangeConfig(int i, StoreReplacementMode storeReplacementMode, StoreReplacementMode storeReplacementMode2, SerializationConstructorMarker serializationConstructorMarker) {
        this.upgradeReplacementMode = (i & 1) == 0 ? StoreReplacementMode.CHARGE_PRORATED_PRICE : storeReplacementMode;
        if ((i & 2) == 0) {
            this.downgradeReplacementMode = StoreReplacementMode.DEFERRED;
        } else {
            this.downgradeReplacementMode = storeReplacementMode2;
        }
    }

    public ProductChangeConfig(StoreReplacementMode upgradeReplacementMode, StoreReplacementMode downgradeReplacementMode) {
        Intrinsics.checkNotNullParameter(upgradeReplacementMode, "upgradeReplacementMode");
        Intrinsics.checkNotNullParameter(downgradeReplacementMode, "downgradeReplacementMode");
        this.upgradeReplacementMode = upgradeReplacementMode;
        this.downgradeReplacementMode = downgradeReplacementMode;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ProductChangeConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.upgradeReplacementMode, StoreReplacementMode.CHARGE_PRORATED_PRICE)) {
            output.encodeSerializableElement(serialDesc, 0, UpgradeReplacementModeDeserializer.INSTANCE, self.upgradeReplacementMode);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.downgradeReplacementMode, StoreReplacementMode.DEFERRED)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, DowngradeReplacementModeDeserializer.INSTANCE, self.downgradeReplacementMode);
    }

    public /* synthetic */ ProductChangeConfig(StoreReplacementMode storeReplacementMode, StoreReplacementMode storeReplacementMode2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreReplacementMode.CHARGE_PRORATED_PRICE : storeReplacementMode, (i & 2) != 0 ? StoreReplacementMode.DEFERRED : storeReplacementMode2);
    }

    public final /* synthetic */ StoreReplacementMode getUpgradeReplacementMode() {
        return this.upgradeReplacementMode;
    }

    public final /* synthetic */ StoreReplacementMode getDowngradeReplacementMode() {
        return this.downgradeReplacementMode;
    }
}
