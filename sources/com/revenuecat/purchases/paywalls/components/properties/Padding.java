package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB-\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018HÁ\u0001¢\u0006\u0002\b\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "", "seen1", "", "top", "", "bottom", "leading", "trailing", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDDDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(DDDD)V", "getBottom", "()D", "getLeading", "getTop", "getTrailing", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Padding {
    private final double bottom;
    private final double leading;
    private final double top;
    private final double trailing;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Padding zero = new Padding(0.0d, 0.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final Padding f53default = new Padding(10.0d, 10.0d, 20.0d, 20.0d);

    public Padding() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 15, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Padding)) {
            return false;
        }
        Padding padding = (Padding) obj;
        return Double.compare(this.top, padding.top) == 0 && Double.compare(this.bottom, padding.bottom) == 0 && Double.compare(this.leading, padding.leading) == 0 && Double.compare(this.trailing, padding.trailing) == 0;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.top) * 31) + Double.hashCode(this.bottom)) * 31) + Double.hashCode(this.leading)) * 31) + Double.hashCode(this.trailing);
    }

    public String toString() {
        return "Padding(top=" + this.top + ", bottom=" + this.bottom + ", leading=" + this.leading + ", trailing=" + this.trailing + ')';
    }

    public Padding(double d, double d2, double d3, double d4) {
        this.top = d;
        this.bottom = d2;
        this.leading = d3;
        this.trailing = d4;
    }

    @Deprecated
    public /* synthetic */ Padding(int i, double d, double d2, double d3, double d4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.top = 0.0d;
        } else {
            this.top = d;
        }
        if ((i & 2) == 0) {
            this.bottom = 0.0d;
        } else {
            this.bottom = d2;
        }
        if ((i & 4) == 0) {
            this.leading = 0.0d;
        } else {
            this.leading = d3;
        }
        if ((i & 8) == 0) {
            this.trailing = 0.0d;
        } else {
            this.trailing = d4;
        }
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Padding self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || Double.compare(self.top, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 0, self.top);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.bottom, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 1, self.bottom);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.leading, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 2, self.leading);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Double.compare(self.trailing, 0.0d) == 0) {
            return;
        }
        output.encodeDoubleElement(serialDesc, 3, self.trailing);
    }

    public /* synthetic */ Padding(double d, double d2, double d3, double d4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3, (i & 8) != 0 ? 0.0d : d4);
    }

    public final /* synthetic */ double getTop() {
        return this.top;
    }

    public final /* synthetic */ double getBottom() {
        return this.bottom;
    }

    public final /* synthetic */ double getLeading() {
        return this.leading;
    }

    public final /* synthetic */ double getTrailing() {
        return this.trailing;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001R\u0013\u0010\u0003\u001a\u00020\u00048F¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u00020\u00048F¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Padding$Companion;", "", "()V", "default", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getDefault", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "zero", "getZero", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return Padding$$serializer.INSTANCE;
        }

        public final /* synthetic */ Padding getZero() {
            return Padding.zero;
        }

        public final /* synthetic */ Padding getDefault() {
            return Padding.f53default;
        }
    }
}
