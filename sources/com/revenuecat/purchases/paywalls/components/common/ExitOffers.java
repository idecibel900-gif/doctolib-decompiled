package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012HÁ\u0001¢\u0006\u0002\b\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;", "", "seen1", "", "dismiss", "Lcom/revenuecat/purchases/paywalls/components/common/ExitOffer;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/common/ExitOffer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/common/ExitOffer;)V", "getDismiss", "()Lcom/revenuecat/purchases/paywalls/components/common/ExitOffer;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExitOffers {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ExitOffer dismiss;

    /* JADX WARN: Multi-variable type inference failed */
    public ExitOffers() {
        this((ExitOffer) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExitOffers) && Intrinsics.areEqual(this.dismiss, ((ExitOffers) obj).dismiss);
    }

    public int hashCode() {
        ExitOffer exitOffer = this.dismiss;
        if (exitOffer == null) {
            return 0;
        }
        return exitOffer.hashCode();
    }

    public String toString() {
        return "ExitOffers(dismiss=" + this.dismiss + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ExitOffers;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return ExitOffers$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ ExitOffers(int i, ExitOffer exitOffer, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.dismiss = null;
        } else {
            this.dismiss = exitOffer;
        }
    }

    public ExitOffers(ExitOffer exitOffer) {
        this.dismiss = exitOffer;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ExitOffers self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.dismiss == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 0, ExitOffer$$serializer.INSTANCE, self.dismiss);
    }

    public /* synthetic */ ExitOffers(ExitOffer exitOffer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : exitOffer);
    }

    public final ExitOffer getDismiss() {
        return this.dismiss;
    }
}
