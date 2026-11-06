package com.revenuecat.purchases.common.networking;

import com.opentok.android.PublisherKit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+BE\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006,"}, d2 = {"Lcom/revenuecat/purchases/common/networking/WebBillingPurchaseOption;", "", "seen1", "", "basePrice", "Lcom/revenuecat/purchases/common/networking/WebBillingPrice;", "base", "Lcom/revenuecat/purchases/common/networking/WebBillingPhase;", "trial", "introPrice", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/networking/WebBillingPrice;Lcom/revenuecat/purchases/common/networking/WebBillingPhase;Lcom/revenuecat/purchases/common/networking/WebBillingPhase;Lcom/revenuecat/purchases/common/networking/WebBillingPhase;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/networking/WebBillingPrice;Lcom/revenuecat/purchases/common/networking/WebBillingPhase;Lcom/revenuecat/purchases/common/networking/WebBillingPhase;Lcom/revenuecat/purchases/common/networking/WebBillingPhase;)V", "getBase", "()Lcom/revenuecat/purchases/common/networking/WebBillingPhase;", "getBasePrice$annotations", "()V", "getBasePrice", "()Lcom/revenuecat/purchases/common/networking/WebBillingPrice;", "getIntroPrice$annotations", "getIntroPrice", "getTrial", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WebBillingPurchaseOption {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WebBillingPhase base;
    private final WebBillingPrice basePrice;
    private final WebBillingPhase introPrice;
    private final WebBillingPhase trial;

    public WebBillingPurchaseOption() {
        this((WebBillingPrice) null, (WebBillingPhase) null, (WebBillingPhase) null, (WebBillingPhase) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebBillingPurchaseOption copy$default(WebBillingPurchaseOption webBillingPurchaseOption, WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, int i, Object obj) {
        if ((i & 1) != 0) {
            webBillingPrice = webBillingPurchaseOption.basePrice;
        }
        if ((i & 2) != 0) {
            webBillingPhase = webBillingPurchaseOption.base;
        }
        if ((i & 4) != 0) {
            webBillingPhase2 = webBillingPurchaseOption.trial;
        }
        if ((i & 8) != 0) {
            webBillingPhase3 = webBillingPurchaseOption.introPrice;
        }
        return webBillingPurchaseOption.copy(webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3);
    }

    public static /* synthetic */ void getBasePrice$annotations() {
    }

    public static /* synthetic */ void getIntroPrice$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WebBillingPrice getBasePrice() {
        return this.basePrice;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WebBillingPhase getBase() {
        return this.base;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WebBillingPhase getTrial() {
        return this.trial;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final WebBillingPhase getIntroPrice() {
        return this.introPrice;
    }

    public final WebBillingPurchaseOption copy(WebBillingPrice basePrice, WebBillingPhase base, WebBillingPhase trial, WebBillingPhase introPrice) {
        return new WebBillingPurchaseOption(basePrice, base, trial, introPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebBillingPurchaseOption)) {
            return false;
        }
        WebBillingPurchaseOption webBillingPurchaseOption = (WebBillingPurchaseOption) other;
        return Intrinsics.areEqual(this.basePrice, webBillingPurchaseOption.basePrice) && Intrinsics.areEqual(this.base, webBillingPurchaseOption.base) && Intrinsics.areEqual(this.trial, webBillingPurchaseOption.trial) && Intrinsics.areEqual(this.introPrice, webBillingPurchaseOption.introPrice);
    }

    public int hashCode() {
        WebBillingPrice webBillingPrice = this.basePrice;
        int iHashCode = (webBillingPrice == null ? 0 : webBillingPrice.hashCode()) * 31;
        WebBillingPhase webBillingPhase = this.base;
        int iHashCode2 = (iHashCode + (webBillingPhase == null ? 0 : webBillingPhase.hashCode())) * 31;
        WebBillingPhase webBillingPhase2 = this.trial;
        int iHashCode3 = (iHashCode2 + (webBillingPhase2 == null ? 0 : webBillingPhase2.hashCode())) * 31;
        WebBillingPhase webBillingPhase3 = this.introPrice;
        return iHashCode3 + (webBillingPhase3 != null ? webBillingPhase3.hashCode() : 0);
    }

    public String toString() {
        return "WebBillingPurchaseOption(basePrice=" + this.basePrice + ", base=" + this.base + ", trial=" + this.trial + ", introPrice=" + this.introPrice + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/networking/WebBillingPurchaseOption$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/networking/WebBillingPurchaseOption;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return WebBillingPurchaseOption$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ WebBillingPurchaseOption(int i, WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.basePrice = null;
        } else {
            this.basePrice = webBillingPrice;
        }
        if ((i & 2) == 0) {
            this.base = null;
        } else {
            this.base = webBillingPhase;
        }
        if ((i & 4) == 0) {
            this.trial = null;
        } else {
            this.trial = webBillingPhase2;
        }
        if ((i & 8) == 0) {
            this.introPrice = null;
        } else {
            this.introPrice = webBillingPhase3;
        }
    }

    public WebBillingPurchaseOption(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3) {
        this.basePrice = webBillingPrice;
        this.base = webBillingPhase;
        this.trial = webBillingPhase2;
        this.introPrice = webBillingPhase3;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebBillingPurchaseOption self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.basePrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, WebBillingPrice$$serializer.INSTANCE, self.basePrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.base != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, WebBillingPhase$$serializer.INSTANCE, self.base);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.trial != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, WebBillingPhase$$serializer.INSTANCE, self.trial);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.introPrice == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, WebBillingPhase$$serializer.INSTANCE, self.introPrice);
    }

    public /* synthetic */ WebBillingPurchaseOption(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : webBillingPrice, (i & 2) != 0 ? null : webBillingPhase, (i & 4) != 0 ? null : webBillingPhase2, (i & 8) != 0 ? null : webBillingPhase3);
    }

    public final WebBillingPrice getBasePrice() {
        return this.basePrice;
    }

    public final WebBillingPhase getBase() {
        return this.base;
    }

    public final WebBillingPhase getTrial() {
        return this.trial;
    }

    public final WebBillingPhase getIntroPrice() {
        return this.introPrice;
    }
}
