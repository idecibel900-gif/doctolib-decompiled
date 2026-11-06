package com.revenuecat.purchases.common.caching;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReceiptInfo$$serializer;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData$$serializer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 02\u00020\u0001:\u0002/0BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J3\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÁ\u0001¢\u0006\u0002\b.R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;", "", "seen1", "", "token", "", "receiptInfo", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "paywallPostReceiptData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/common/ReceiptInfo;Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;Lcom/revenuecat/purchases/PurchasesAreCompletedBy;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/ReceiptInfo;Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;Lcom/revenuecat/purchases/PurchasesAreCompletedBy;)V", "getPaywallPostReceiptData$annotations", "()V", "getPaywallPostReceiptData", "()Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "getPurchasesAreCompletedBy$annotations", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getReceiptInfo$annotations", "getReceiptInfo", "()Lcom/revenuecat/purchases/common/ReceiptInfo;", "getToken$annotations", "getToken", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LocalTransactionMetadata {
    private final PaywallPostReceiptData paywallPostReceiptData;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final ReceiptInfo receiptInfo;
    private final String token;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, null, null, EnumsKt.createSimpleEnumSerializer("com.revenuecat.purchases.PurchasesAreCompletedBy", PurchasesAreCompletedBy.values())};

    public static /* synthetic */ LocalTransactionMetadata copy$default(LocalTransactionMetadata localTransactionMetadata, String str, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localTransactionMetadata.token;
        }
        if ((i & 2) != 0) {
            receiptInfo = localTransactionMetadata.receiptInfo;
        }
        if ((i & 4) != 0) {
            paywallPostReceiptData = localTransactionMetadata.paywallPostReceiptData;
        }
        if ((i & 8) != 0) {
            purchasesAreCompletedBy = localTransactionMetadata.purchasesAreCompletedBy;
        }
        return localTransactionMetadata.copy(str, receiptInfo, paywallPostReceiptData, purchasesAreCompletedBy);
    }

    public static /* synthetic */ void getPaywallPostReceiptData$annotations() {
    }

    public static /* synthetic */ void getPurchasesAreCompletedBy$annotations() {
    }

    public static /* synthetic */ void getReceiptInfo$annotations() {
    }

    public static /* synthetic */ void getToken$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ReceiptInfo getReceiptInfo() {
        return this.receiptInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PaywallPostReceiptData getPaywallPostReceiptData() {
        return this.paywallPostReceiptData;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    public final LocalTransactionMetadata copy(String token, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        return new LocalTransactionMetadata(token, receiptInfo, paywallPostReceiptData, purchasesAreCompletedBy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalTransactionMetadata)) {
            return false;
        }
        LocalTransactionMetadata localTransactionMetadata = (LocalTransactionMetadata) other;
        return Intrinsics.areEqual(this.token, localTransactionMetadata.token) && Intrinsics.areEqual(this.receiptInfo, localTransactionMetadata.receiptInfo) && Intrinsics.areEqual(this.paywallPostReceiptData, localTransactionMetadata.paywallPostReceiptData) && this.purchasesAreCompletedBy == localTransactionMetadata.purchasesAreCompletedBy;
    }

    public int hashCode() {
        int iHashCode = ((this.token.hashCode() * 31) + this.receiptInfo.hashCode()) * 31;
        PaywallPostReceiptData paywallPostReceiptData = this.paywallPostReceiptData;
        return ((iHashCode + (paywallPostReceiptData == null ? 0 : paywallPostReceiptData.hashCode())) * 31) + this.purchasesAreCompletedBy.hashCode();
    }

    public String toString() {
        return "LocalTransactionMetadata(token=" + this.token + ", receiptInfo=" + this.receiptInfo + ", paywallPostReceiptData=" + this.paywallPostReceiptData + ", purchasesAreCompletedBy=" + this.purchasesAreCompletedBy + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return LocalTransactionMetadata$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ LocalTransactionMetadata(int i, String str, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i & 11)) {
            PluginExceptionsKt.throwMissingFieldException(i, 11, LocalTransactionMetadata$$serializer.INSTANCE.getDescriptor());
        }
        this.token = str;
        this.receiptInfo = receiptInfo;
        if ((i & 4) == 0) {
            this.paywallPostReceiptData = null;
        } else {
            this.paywallPostReceiptData = paywallPostReceiptData;
        }
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
    }

    public LocalTransactionMetadata(String token, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        this.token = token;
        this.receiptInfo = receiptInfo;
        this.paywallPostReceiptData = paywallPostReceiptData;
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(LocalTransactionMetadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.token);
        output.encodeSerializableElement(serialDesc, 1, ReceiptInfo$$serializer.INSTANCE, self.receiptInfo);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.paywallPostReceiptData != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, PaywallPostReceiptData$$serializer.INSTANCE, self.paywallPostReceiptData);
        }
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.purchasesAreCompletedBy);
    }

    public /* synthetic */ LocalTransactionMetadata(String str, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, receiptInfo, (i & 4) != 0 ? null : paywallPostReceiptData, purchasesAreCompletedBy);
    }

    public final String getToken() {
        return this.token;
    }

    public final ReceiptInfo getReceiptInfo() {
        return this.receiptInfo;
    }

    public final PaywallPostReceiptData getPaywallPostReceiptData() {
        return this.paywallPostReceiptData;
    }

    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }
}
