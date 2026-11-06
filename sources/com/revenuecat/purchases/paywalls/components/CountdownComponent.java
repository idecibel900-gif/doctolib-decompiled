package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import java.lang.annotation.Annotation;
import java.util.Date;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0004$%&'BQ\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "style", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountdownStyle;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "countdownStack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "endStack", "fallback", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountdownStyle;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountdownStyle;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/StackComponent;)V", "getCountFrom$annotations", "()V", "getCountFrom", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "getCountdownStack$annotations", "getCountdownStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getEndStack$annotations", "getEndStack", "getFallback", "getStyle", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountdownStyle;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "CountFrom", "CountdownStyle", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CountdownComponent implements PaywallComponent {
    private final CountFrom countFrom;
    private final StackComponent countdownStack;
    private final StackComponent endStack;
    private final StackComponent fallback;
    private final CountdownStyle style;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, CountFrom.INSTANCE.serializer(), null, null, null};

    public static /* synthetic */ void getCountFrom$annotations() {
    }

    public static /* synthetic */ void getCountdownStack$annotations() {
    }

    public static /* synthetic */ void getEndStack$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountdownComponent)) {
            return false;
        }
        CountdownComponent countdownComponent = (CountdownComponent) obj;
        return Intrinsics.areEqual(this.style, countdownComponent.style) && this.countFrom == countdownComponent.countFrom && Intrinsics.areEqual(this.countdownStack, countdownComponent.countdownStack) && Intrinsics.areEqual(this.endStack, countdownComponent.endStack) && Intrinsics.areEqual(this.fallback, countdownComponent.fallback);
    }

    public int hashCode() {
        int iHashCode = ((((this.style.hashCode() * 31) + this.countFrom.hashCode()) * 31) + this.countdownStack.hashCode()) * 31;
        StackComponent stackComponent = this.endStack;
        int iHashCode2 = (iHashCode + (stackComponent == null ? 0 : stackComponent.hashCode())) * 31;
        StackComponent stackComponent2 = this.fallback;
        return iHashCode2 + (stackComponent2 != null ? stackComponent2.hashCode() : 0);
    }

    public String toString() {
        return "CountdownComponent(style=" + this.style + ", countFrom=" + this.countFrom + ", countdownStack=" + this.countdownStack + ", endStack=" + this.endStack + ", fallback=" + this.fallback + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return CountdownComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ CountdownComponent(int i, CountdownStyle countdownStyle, CountFrom countFrom, StackComponent stackComponent, StackComponent stackComponent2, StackComponent stackComponent3, SerializationConstructorMarker serializationConstructorMarker) {
        if (5 != (i & 5)) {
            PluginExceptionsKt.throwMissingFieldException(i, 5, CountdownComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.style = countdownStyle;
        if ((i & 2) == 0) {
            this.countFrom = CountFrom.DAYS;
        } else {
            this.countFrom = countFrom;
        }
        this.countdownStack = stackComponent;
        if ((i & 8) == 0) {
            this.endStack = null;
        } else {
            this.endStack = stackComponent2;
        }
        if ((i & 16) == 0) {
            this.fallback = null;
        } else {
            this.fallback = stackComponent3;
        }
    }

    public CountdownComponent(CountdownStyle style, CountFrom countFrom, StackComponent countdownStack, StackComponent stackComponent, StackComponent stackComponent2) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(countdownStack, "countdownStack");
        this.style = style;
        this.countFrom = countFrom;
        this.countdownStack = countdownStack;
        this.endStack = stackComponent;
        this.fallback = stackComponent2;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CountdownComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, CountdownComponent$CountdownStyle$$serializer.INSTANCE, self.style);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.countFrom != CountFrom.DAYS) {
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.countFrom);
        }
        StackComponent$$serializer stackComponent$$serializer = StackComponent$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 2, stackComponent$$serializer, self.countdownStack);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.endStack != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, stackComponent$$serializer, self.endStack);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.fallback == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, stackComponent$$serializer, self.fallback);
    }

    public final /* synthetic */ CountdownStyle getStyle() {
        return this.style;
    }

    public /* synthetic */ CountdownComponent(CountdownStyle countdownStyle, CountFrom countFrom, StackComponent stackComponent, StackComponent stackComponent2, StackComponent stackComponent3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(countdownStyle, (i & 2) != 0 ? CountFrom.DAYS : countFrom, stackComponent, (i & 8) != 0 ? null : stackComponent2, (i & 16) != 0 ? null : stackComponent3);
    }

    public final /* synthetic */ CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ StackComponent getCountdownStack() {
        return this.countdownStack;
    }

    public final /* synthetic */ StackComponent getEndStack() {
        return this.endStack;
    }

    public final /* synthetic */ StackComponent getFallback() {
        return this.fallback;
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB/\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018HÁ\u0001¢\u0006\u0002\b\u0019R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountdownStyle;", "", "seen1", "", "type", "", "date", "Ljava/util/Date;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/Date;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/Date;)V", "getDate$annotations", "()V", "getDate", "()Ljava/util/Date;", "getType", "()Ljava/lang/String;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CountdownStyle {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Date date;
        private final String type;

        public static /* synthetic */ void getDate$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CountdownStyle)) {
                return false;
            }
            CountdownStyle countdownStyle = (CountdownStyle) obj;
            return Intrinsics.areEqual(this.type, countdownStyle.type) && Intrinsics.areEqual(this.date, countdownStyle.date);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.date.hashCode();
        }

        public String toString() {
            return "CountdownStyle(type=" + this.type + ", date=" + this.date + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountdownStyle$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountdownStyle;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CountdownComponent$CountdownStyle$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ CountdownStyle(int i, String str, Date date, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, CountdownComponent$CountdownStyle$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
            this.date = date;
        }

        public CountdownStyle(String type, Date date) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(date, "date");
            this.type = type;
            this.date = date;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CountdownStyle self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.type);
            output.encodeSerializableElement(serialDesc, 1, ISO8601DateSerializer.INSTANCE, self.date);
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }

        public final /* synthetic */ Date getDate() {
            return this.date;
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "", "(Ljava/lang/String;I)V", "DAYS", "HOURS", "MINUTES", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum CountFrom {
        DAYS,
        HOURS,
        MINUTES;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.CountdownComponent.CountFrom.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.paywalls.components.CountdownComponent.CountFrom", CountFrom.values(), new String[]{"days", "hours", "minutes"}, new Annotation[][]{null, null, null}, null);
            }
        });

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) CountFrom.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }
    }
}
