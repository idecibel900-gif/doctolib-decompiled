package com.revenuecat.purchases.common.networking;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB'\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J+\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/common/networking/WebBillingPhase;", "", "seen1", "", b.x, "Lcom/revenuecat/purchases/common/networking/WebBillingPrice;", "periodDuration", "", "cycleCount", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/networking/WebBillingPrice;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/networking/WebBillingPrice;Ljava/lang/String;I)V", "getCycleCount$annotations", "()V", "getCycleCount", "()I", "getPeriodDuration$annotations", "getPeriodDuration", "()Ljava/lang/String;", "getPrice", "()Lcom/revenuecat/purchases/common/networking/WebBillingPrice;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WebBillingPhase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int cycleCount;
    private final String periodDuration;
    private final WebBillingPrice price;

    public WebBillingPhase() {
        this((WebBillingPrice) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebBillingPhase copy$default(WebBillingPhase webBillingPhase, WebBillingPrice webBillingPrice, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            webBillingPrice = webBillingPhase.price;
        }
        if ((i2 & 2) != 0) {
            str = webBillingPhase.periodDuration;
        }
        if ((i2 & 4) != 0) {
            i = webBillingPhase.cycleCount;
        }
        return webBillingPhase.copy(webBillingPrice, str, i);
    }

    public static /* synthetic */ void getCycleCount$annotations() {
    }

    public static /* synthetic */ void getPeriodDuration$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WebBillingPrice getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPeriodDuration() {
        return this.periodDuration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCycleCount() {
        return this.cycleCount;
    }

    public final WebBillingPhase copy(WebBillingPrice price, String periodDuration, int cycleCount) {
        return new WebBillingPhase(price, periodDuration, cycleCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebBillingPhase)) {
            return false;
        }
        WebBillingPhase webBillingPhase = (WebBillingPhase) other;
        return Intrinsics.areEqual(this.price, webBillingPhase.price) && Intrinsics.areEqual(this.periodDuration, webBillingPhase.periodDuration) && this.cycleCount == webBillingPhase.cycleCount;
    }

    public int hashCode() {
        WebBillingPrice webBillingPrice = this.price;
        int iHashCode = (webBillingPrice == null ? 0 : webBillingPrice.hashCode()) * 31;
        String str = this.periodDuration;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.cycleCount);
    }

    public String toString() {
        return "WebBillingPhase(price=" + this.price + ", periodDuration=" + this.periodDuration + ", cycleCount=" + this.cycleCount + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/networking/WebBillingPhase$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/networking/WebBillingPhase;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return WebBillingPhase$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ WebBillingPhase(int i, WebBillingPrice webBillingPrice, String str, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.price = null;
        } else {
            this.price = webBillingPrice;
        }
        if ((i & 2) == 0) {
            this.periodDuration = null;
        } else {
            this.periodDuration = str;
        }
        if ((i & 4) == 0) {
            this.cycleCount = 1;
        } else {
            this.cycleCount = i2;
        }
    }

    public WebBillingPhase(WebBillingPrice webBillingPrice, String str, int i) {
        this.price = webBillingPrice;
        this.periodDuration = str;
        this.cycleCount = i;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebBillingPhase self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, WebBillingPrice$$serializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.periodDuration != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.periodDuration);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.cycleCount == 1) {
            return;
        }
        output.encodeIntElement(serialDesc, 2, self.cycleCount);
    }

    public /* synthetic */ WebBillingPhase(WebBillingPrice webBillingPrice, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : webBillingPrice, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? 1 : i);
    }

    public final WebBillingPrice getPrice() {
        return this.price;
    }

    public final String getPeriodDuration() {
        return this.periodDuration;
    }

    public final int getCycleCount() {
        return this.cycleCount;
    }
}
