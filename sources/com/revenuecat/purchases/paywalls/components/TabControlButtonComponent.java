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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !BC\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TabControlButtonComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "tabIndex", "tabId", "", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "name", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getTabId$annotations", "()V", "getTabId", "getTabIndex$annotations", "getTabIndex", "()I", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabControlButtonComponent implements PaywallComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final StackComponent stack;
    private final String tabId;
    private final int tabIndex;

    public static /* synthetic */ void getTabId$annotations() {
    }

    public static /* synthetic */ void getTabIndex$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabControlButtonComponent)) {
            return false;
        }
        TabControlButtonComponent tabControlButtonComponent = (TabControlButtonComponent) obj;
        return this.tabIndex == tabControlButtonComponent.tabIndex && Intrinsics.areEqual(this.tabId, tabControlButtonComponent.tabId) && Intrinsics.areEqual(this.stack, tabControlButtonComponent.stack) && Intrinsics.areEqual(this.name, tabControlButtonComponent.name);
    }

    public int hashCode() {
        int iHashCode = ((((this.tabIndex * 31) + this.tabId.hashCode()) * 31) + this.stack.hashCode()) * 31;
        String str = this.name;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TabControlButtonComponent(tabIndex=" + this.tabIndex + ", tabId=" + this.tabId + ", stack=" + this.stack + ", name=" + this.name + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TabControlButtonComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TabControlButtonComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return TabControlButtonComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ TabControlButtonComponent(int i, int i2, String str, StackComponent stackComponent, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, TabControlButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.tabIndex = i2;
        this.tabId = str;
        this.stack = stackComponent;
        if ((i & 8) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
    }

    public TabControlButtonComponent(int i, String tabId, StackComponent stack, String str) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.tabIndex = i;
        this.tabId = tabId;
        this.stack = stack;
        this.name = str;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TabControlButtonComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.tabIndex);
        output.encodeStringElement(serialDesc, 1, self.tabId);
        output.encodeSerializableElement(serialDesc, 2, StackComponent$$serializer.INSTANCE, self.stack);
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.name == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.name);
    }

    public /* synthetic */ TabControlButtonComponent(int i, String str, StackComponent stackComponent, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, stackComponent, (i2 & 8) != 0 ? null : str2);
    }

    public final /* synthetic */ int getTabIndex() {
        return this.tabIndex;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }
}
