package com.revenuecat.purchases.paywalls.components.common;

import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent$$serializer;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#BC\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsConfig;", "", "seen1", "", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "stickyFooter", "Lcom/revenuecat/purchases/paywalls/components/StickyFooterComponent;", "header", "Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/StickyFooterComponent;Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/StickyFooterComponent;Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;)V", "getBackground", "()Lcom/revenuecat/purchases/paywalls/components/common/Background;", "getHeader", "()Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getStickyFooter$annotations", "()V", "getStickyFooter", "()Lcom/revenuecat/purchases/paywalls/components/StickyFooterComponent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallComponentsConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Background background;
    private final HeaderComponent header;
    private final StackComponent stack;
    private final StickyFooterComponent stickyFooter;

    public static /* synthetic */ void getStickyFooter$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponentsConfig)) {
            return false;
        }
        PaywallComponentsConfig paywallComponentsConfig = (PaywallComponentsConfig) obj;
        return Intrinsics.areEqual(this.stack, paywallComponentsConfig.stack) && Intrinsics.areEqual(this.background, paywallComponentsConfig.background) && Intrinsics.areEqual(this.stickyFooter, paywallComponentsConfig.stickyFooter) && Intrinsics.areEqual(this.header, paywallComponentsConfig.header);
    }

    public int hashCode() {
        int iHashCode = ((this.stack.hashCode() * 31) + this.background.hashCode()) * 31;
        StickyFooterComponent stickyFooterComponent = this.stickyFooter;
        int iHashCode2 = (iHashCode + (stickyFooterComponent == null ? 0 : stickyFooterComponent.hashCode())) * 31;
        HeaderComponent headerComponent = this.header;
        return iHashCode2 + (headerComponent != null ? headerComponent.hashCode() : 0);
    }

    public String toString() {
        return "PaywallComponentsConfig(stack=" + this.stack + ", background=" + this.background + ", stickyFooter=" + this.stickyFooter + ", header=" + this.header + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsConfig;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PaywallComponentsConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ PaywallComponentsConfig(int i, StackComponent stackComponent, Background background, StickyFooterComponent stickyFooterComponent, HeaderComponent headerComponent, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, PaywallComponentsConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        this.background = background;
        if ((i & 4) == 0) {
            this.stickyFooter = null;
        } else {
            this.stickyFooter = stickyFooterComponent;
        }
        if ((i & 8) == 0) {
            this.header = null;
        } else {
            this.header = headerComponent;
        }
    }

    public PaywallComponentsConfig(StackComponent stack, Background background, StickyFooterComponent stickyFooterComponent, HeaderComponent headerComponent) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(background, "background");
        this.stack = stack;
        this.background = background;
        this.stickyFooter = stickyFooterComponent;
        this.header = headerComponent;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallComponentsConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, StackComponent$$serializer.INSTANCE, self.stack);
        output.encodeSerializableElement(serialDesc, 1, BackgroundDeserializer.INSTANCE, self.background);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.stickyFooter != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StickyFooterComponent$$serializer.INSTANCE, self.stickyFooter);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.header == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, HeaderComponent$$serializer.INSTANCE, self.header);
    }

    public /* synthetic */ PaywallComponentsConfig(StackComponent stackComponent, Background background, StickyFooterComponent stickyFooterComponent, HeaderComponent headerComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackComponent, background, (i & 4) != 0 ? null : stickyFooterComponent, (i & 8) != 0 ? null : headerComponent);
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ StickyFooterComponent getStickyFooter() {
        return this.stickyFooter;
    }

    public final /* synthetic */ HeaderComponent getHeader() {
        return this.header;
    }
}
