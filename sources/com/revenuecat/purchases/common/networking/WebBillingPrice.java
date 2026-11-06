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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/common/networking/WebBillingPrice;", "", "seen1", "", "amountMicros", "", b.a, "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JLjava/lang/String;)V", "getAmountMicros$annotations", "()V", "getAmountMicros", "()J", "getCurrency", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WebBillingPrice {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long amountMicros;
    private final String currency;

    public static /* synthetic */ WebBillingPrice copy$default(WebBillingPrice webBillingPrice, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = webBillingPrice.amountMicros;
        }
        if ((i & 2) != 0) {
            str = webBillingPrice.currency;
        }
        return webBillingPrice.copy(j, str);
    }

    public static /* synthetic */ void getAmountMicros$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getAmountMicros() {
        return this.amountMicros;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final WebBillingPrice copy(long amountMicros, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new WebBillingPrice(amountMicros, currency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebBillingPrice)) {
            return false;
        }
        WebBillingPrice webBillingPrice = (WebBillingPrice) other;
        return this.amountMicros == webBillingPrice.amountMicros && Intrinsics.areEqual(this.currency, webBillingPrice.currency);
    }

    public int hashCode() {
        return (Long.hashCode(this.amountMicros) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "WebBillingPrice(amountMicros=" + this.amountMicros + ", currency=" + this.currency + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/networking/WebBillingPrice$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/networking/WebBillingPrice;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return WebBillingPrice$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ WebBillingPrice(int i, long j, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, WebBillingPrice$$serializer.INSTANCE.getDescriptor());
        }
        this.amountMicros = j;
        this.currency = str;
    }

    public WebBillingPrice(long j, String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.amountMicros = j;
        this.currency = currency;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebBillingPrice self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.amountMicros);
        output.encodeStringElement(serialDesc, 1, self.currency);
    }

    public final long getAmountMicros() {
        return this.amountMicros;
    }

    public final String getCurrency() {
        return this.currency;
    }
}
