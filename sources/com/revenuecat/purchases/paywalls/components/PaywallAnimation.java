package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
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
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001c\u001d\u001eB7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÁ\u0001¢\u0006\u0002\b\u001bR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation;", "", "seen1", "", "type", "Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation$AnimationType;", "msDelay", "msDuration", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/PaywallAnimation$AnimationType;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation$AnimationType;II)V", "getMsDelay$annotations", "()V", "getMsDelay", "()I", "getMsDuration$annotations", "getMsDuration", "getType", "()Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation$AnimationType;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "AnimationType", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallAnimation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int msDelay;
    private final int msDuration;
    private final AnimationType type;

    public static /* synthetic */ void getMsDelay$annotations() {
    }

    public static /* synthetic */ void getMsDuration$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallAnimation)) {
            return false;
        }
        PaywallAnimation paywallAnimation = (PaywallAnimation) obj;
        return this.type == paywallAnimation.type && this.msDelay == paywallAnimation.msDelay && this.msDuration == paywallAnimation.msDuration;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.msDelay) * 31) + this.msDuration;
    }

    public String toString() {
        return "PaywallAnimation(type=" + this.type + ", msDelay=" + this.msDelay + ", msDuration=" + this.msDuration + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PaywallAnimation$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ PaywallAnimation(int i, AnimationType animationType, int i2, int i3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, PaywallAnimation$$serializer.INSTANCE.getDescriptor());
        }
        this.type = animationType;
        this.msDelay = i2;
        this.msDuration = i3;
    }

    public PaywallAnimation(AnimationType type, int i, int i2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.msDelay = i;
        this.msDuration = i2;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallAnimation self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, AnimationTypeSerializer.INSTANCE, self.type);
        output.encodeIntElement(serialDesc, 1, self.msDelay);
        output.encodeIntElement(serialDesc, 2, self.msDuration);
    }

    public final /* synthetic */ AnimationType getType() {
        return this.type;
    }

    public final /* synthetic */ int getMsDelay() {
        return this.msDelay;
    }

    public final /* synthetic */ int getMsDuration() {
        return this.msDuration;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation$AnimationType;", "", "(Ljava/lang/String;I)V", "EASE_IN", "EASE_OUT", "EASE_IN_OUT", "LINEAR", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum AnimationType {
        EASE_IN,
        EASE_OUT,
        EASE_IN_OUT,
        LINEAR;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation$AnimationType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PaywallAnimation$AnimationType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return AnimationTypeSerializer.INSTANCE;
            }
        }
    }
}
