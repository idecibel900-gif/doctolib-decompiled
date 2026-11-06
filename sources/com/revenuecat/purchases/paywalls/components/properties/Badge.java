package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001c\u001d\u001eB7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÁ\u0001¢\u0006\u0002\b\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Badge;", "", "seen1", "", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "style", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "alignment", "Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;)V", "getAlignment", "()Lcom/revenuecat/purchases/paywalls/components/properties/TwoDimensionalAlignment;", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getStyle", "()Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "Style", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Badge {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TwoDimensionalAlignment alignment;
    private final StackComponent stack;
    private final Style style;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) obj;
        return Intrinsics.areEqual(this.stack, badge.stack) && this.style == badge.style && this.alignment == badge.alignment;
    }

    public int hashCode() {
        return (((this.stack.hashCode() * 31) + this.style.hashCode()) * 31) + this.alignment.hashCode();
    }

    public String toString() {
        return "Badge(stack=" + this.stack + ", style=" + this.style + ", alignment=" + this.alignment + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return Badge$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ Badge(int i, StackComponent stackComponent, Style style, TwoDimensionalAlignment twoDimensionalAlignment, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, Badge$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        this.style = style;
        this.alignment = twoDimensionalAlignment;
    }

    public Badge(StackComponent stack, Style style, TwoDimensionalAlignment alignment) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.stack = stack;
        this.style = style;
        this.alignment = alignment;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Badge self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, StackComponent$$serializer.INSTANCE, self.stack);
        output.encodeSerializableElement(serialDesc, 1, BadgeStyleSerializer.INSTANCE, self.style);
        output.encodeSerializableElement(serialDesc, 2, TwoDimensionalAlignmentDeserializer.INSTANCE, self.alignment);
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ Style getStyle() {
        return this.style;
    }

    public final /* synthetic */ TwoDimensionalAlignment getAlignment() {
        return this.alignment;
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "", "(Ljava/lang/String;I)V", "Overlay", "EdgeToEdge", "Nested", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Style {
        Overlay,
        EdgeToEdge,
        Nested;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BadgeStyleSerializer.INSTANCE;
            }
        }
    }
}
