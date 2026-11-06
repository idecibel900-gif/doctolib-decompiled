package com.revenuecat.purchases.paywalls.components.common;

import com.amazon.a.a.o.b.f;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.PartialComponent;
import java.lang.annotation.Annotation;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonPrimitiveSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000  *\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0005\u001e\u001f !\"B3\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ@\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0001\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001cHÁ\u0001¢\u0006\u0002\b\u001dR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "T", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "", "seen1", "", "conditions", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", DiagnosticsEntry.PROPERTIES_KEY, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/revenuecat/purchases/paywalls/components/PartialComponent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/PartialComponent;)V", "getConditions", "()Ljava/util/List;", "getProperties", "()Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "write$Self", "", "T0", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$purchases_defaultsBc8Release", "$serializer", "ArrayOperator", "Companion", "Condition", "EqualityOperator", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComponentOverride<T extends PartialComponent> {
    private static final SerialDescriptor $cachedDescriptor;
    private final List<Condition> conditions;
    private final T properties;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {new ArrayListSerializer(ConditionSerializer.INSTANCE), null};

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComponentOverride)) {
            return false;
        }
        ComponentOverride componentOverride = (ComponentOverride) obj;
        return Intrinsics.areEqual(this.conditions, componentOverride.conditions) && Intrinsics.areEqual(this.properties, componentOverride.properties);
    }

    public int hashCode() {
        return (this.conditions.hashCode() * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "ComponentOverride(conditions=" + this.conditions + ", properties=" + this.properties + ')';
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0004\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004HÆ\u0001¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "T0", "typeSerial0", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T0> KSerializer serializer(KSerializer typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new ComponentOverride$$serializer(typeSerial0);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.ComponentOverride", null, 2);
        pluginGeneratedSerialDescriptor.addElement("conditions", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.PROPERTIES_KEY, false);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public /* synthetic */ ComponentOverride(int i, List list, PartialComponent partialComponent, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, $cachedDescriptor);
        }
        this.conditions = list;
        this.properties = partialComponent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentOverride(List<? extends Condition> conditions, T properties) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.conditions = conditions;
        this.properties = properties;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ComponentOverride self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.conditions);
        output.encodeSerializableElement(serialDesc, 1, typeSerial0, self.properties);
    }

    public final /* synthetic */ List getConditions() {
        return this.conditions;
    }

    public final /* synthetic */ PartialComponent getProperties() {
        return this.properties;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "", "(Ljava/lang/String;I)V", "EQUALS", "NOT_EQUALS", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum EqualityOperator {
        EQUALS,
        NOT_EQUALS;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.EqualityOperator.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.EqualityOperator", EqualityOperator.values(), new String[]{f.b, "!="}, new Annotation[][]{null, null}, null);
            }
        });

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) EqualityOperator.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$ArrayOperator;", "", "(Ljava/lang/String;I)V", "IN", "NOT_IN", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ArrayOperator {
        IN,
        NOT_IN;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.ArrayOperator.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.ArrayOperator", ArrayOperator.values(), new String[]{"in", "not in"}, new Annotation[][]{null, null}, null);
            }
        });

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$ArrayOperator$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$ArrayOperator;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) ArrayOperator.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \b2\u00020\u0001:\r\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0006\u0082\u0001\f\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "", "isRule", "", "isRule$annotations", "()V", "()Z", "Compact", "Companion", "Expanded", "IntroOffer", "IntroOfferRule", "Medium", "MultiplePhaseOffers", "PromoOffer", "PromoOfferRule", "Selected", "SelectedPackage", "Unsupported", "Variable", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Compact;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Expanded;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$IntroOffer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$IntroOfferRule;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Medium;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$MultiplePhaseOffers;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$PromoOffer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$PromoOfferRule;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Selected;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$SelectedPackage;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Unsupported;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Variable;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Condition {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        default boolean isRule() {
            return false;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer serializer() {
                return ConditionSerializer.INSTANCE;
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            @InternalRevenueCatAPI
            public static /* synthetic */ void isRule$annotations() {
            }

            @Deprecated
            public static boolean isRule(Condition condition) {
                return Condition.super.isRule();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Compact;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Compact implements Condition {
            public static final Compact INSTANCE = new Compact();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Compact.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Compact", Compact.INSTANCE, new Annotation[0]);
                }
            });

            private Compact() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Medium;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Medium implements Condition {
            public static final Medium INSTANCE = new Medium();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Medium.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Medium", Medium.INSTANCE, new Annotation[0]);
                }
            });

            private Medium() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Expanded;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Expanded implements Condition {
            public static final Expanded INSTANCE = new Expanded();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Expanded.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Expanded", Expanded.INSTANCE, new Annotation[0]);
                }
            });

            private Expanded() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$IntroOffer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class IntroOffer implements Condition {
            public static final IntroOffer INSTANCE = new IntroOffer();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.IntroOffer.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.IntroOffer", IntroOffer.INSTANCE, new Annotation[0]);
                }
            });

            private IntroOffer() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0014\u0010\f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$IntroOfferRule;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "seen1", "", "operator", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "value", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;Z)V", "isRule", "()Z", "getOperator", "()Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "getValue", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class IntroOfferRule implements Condition {
            private final EqualityOperator operator;
            private final boolean value;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {EqualityOperator.INSTANCE.serializer(), null};

            public static /* synthetic */ IntroOfferRule copy$default(IntroOfferRule introOfferRule, EqualityOperator equalityOperator, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    equalityOperator = introOfferRule.operator;
                }
                if ((i & 2) != 0) {
                    z = introOfferRule.value;
                }
                return introOfferRule.copy(equalityOperator, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EqualityOperator getOperator() {
                return this.operator;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getValue() {
                return this.value;
            }

            public final IntroOfferRule copy(EqualityOperator operator, boolean value) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                return new IntroOfferRule(operator, value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof IntroOfferRule)) {
                    return false;
                }
                IntroOfferRule introOfferRule = (IntroOfferRule) other;
                return this.operator == introOfferRule.operator && this.value == introOfferRule.value;
            }

            public int hashCode() {
                return (this.operator.hashCode() * 31) + Boolean.hashCode(this.value);
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "IntroOfferRule(operator=" + this.operator + ", value=" + this.value + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$IntroOfferRule$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$IntroOfferRule;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ComponentOverride$Condition$IntroOfferRule$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ IntroOfferRule(int i, EqualityOperator equalityOperator, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ComponentOverride$Condition$IntroOfferRule$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = equalityOperator;
                this.value = z;
            }

            public IntroOfferRule(EqualityOperator operator, boolean z) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                this.operator = operator;
                this.value = z;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(IntroOfferRule self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.operator);
                output.encodeBooleanElement(serialDesc, 1, self.value);
            }

            public final EqualityOperator getOperator() {
                return this.operator;
            }

            public final boolean getValue() {
                return this.value;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$MultiplePhaseOffers;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class MultiplePhaseOffers implements Condition {
            public static final MultiplePhaseOffers INSTANCE = new MultiplePhaseOffers();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.MultiplePhaseOffers.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.MultiplePhaseOffers", MultiplePhaseOffers.INSTANCE, new Annotation[0]);
                }
            });

            private MultiplePhaseOffers() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Selected;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Selected implements Condition {
            public static final Selected INSTANCE = new Selected();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Selected.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Selected", Selected.INSTANCE, new Annotation[0]);
                }
            });

            private Selected() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$PromoOffer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PromoOffer implements Condition {
            public static final PromoOffer INSTANCE = new PromoOffer();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.PromoOffer.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.PromoOffer", PromoOffer.INSTANCE, new Annotation[0]);
                }
            });

            private PromoOffer() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B+\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0014\u0010\f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$PromoOfferRule;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "seen1", "", "operator", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "value", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;Z)V", "isRule", "()Z", "getOperator", "()Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "getValue", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class PromoOfferRule implements Condition {
            private final EqualityOperator operator;
            private final boolean value;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {EqualityOperator.INSTANCE.serializer(), null};

            public static /* synthetic */ PromoOfferRule copy$default(PromoOfferRule promoOfferRule, EqualityOperator equalityOperator, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    equalityOperator = promoOfferRule.operator;
                }
                if ((i & 2) != 0) {
                    z = promoOfferRule.value;
                }
                return promoOfferRule.copy(equalityOperator, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EqualityOperator getOperator() {
                return this.operator;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getValue() {
                return this.value;
            }

            public final PromoOfferRule copy(EqualityOperator operator, boolean value) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                return new PromoOfferRule(operator, value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PromoOfferRule)) {
                    return false;
                }
                PromoOfferRule promoOfferRule = (PromoOfferRule) other;
                return this.operator == promoOfferRule.operator && this.value == promoOfferRule.value;
            }

            public int hashCode() {
                return (this.operator.hashCode() * 31) + Boolean.hashCode(this.value);
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "PromoOfferRule(operator=" + this.operator + ", value=" + this.value + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$PromoOfferRule$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$PromoOfferRule;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ComponentOverride$Condition$PromoOfferRule$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ PromoOfferRule(int i, EqualityOperator equalityOperator, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ComponentOverride$Condition$PromoOfferRule$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = equalityOperator;
                this.value = z;
            }

            public PromoOfferRule(EqualityOperator operator, boolean z) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                this.operator = operator;
                this.value = z;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PromoOfferRule self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.operator);
                output.encodeBooleanElement(serialDesc, 1, self.value);
            }

            public final EqualityOperator getOperator() {
                return this.operator;
            }

            public final boolean getValue() {
                return this.value;
            }
        }

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B3\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$SelectedPackage;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "seen1", "", "operator", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$ArrayOperator;", "packages", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$ArrayOperator;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$ArrayOperator;Ljava/util/List;)V", "isRule", "", "()Z", "getOperator", "()Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$ArrayOperator;", "getPackages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class SelectedPackage implements Condition {
            private final ArrayOperator operator;
            private final List<String> packages;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {ArrayOperator.INSTANCE.serializer(), new ArrayListSerializer(StringSerializer.INSTANCE)};

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SelectedPackage copy$default(SelectedPackage selectedPackage, ArrayOperator arrayOperator, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    arrayOperator = selectedPackage.operator;
                }
                if ((i & 2) != 0) {
                    list = selectedPackage.packages;
                }
                return selectedPackage.copy(arrayOperator, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ArrayOperator getOperator() {
                return this.operator;
            }

            public final List<String> component2() {
                return this.packages;
            }

            public final SelectedPackage copy(ArrayOperator operator, List<String> packages) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(packages, "packages");
                return new SelectedPackage(operator, packages);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectedPackage)) {
                    return false;
                }
                SelectedPackage selectedPackage = (SelectedPackage) other;
                return this.operator == selectedPackage.operator && Intrinsics.areEqual(this.packages, selectedPackage.packages);
            }

            public int hashCode() {
                return (this.operator.hashCode() * 31) + this.packages.hashCode();
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "SelectedPackage(operator=" + this.operator + ", packages=" + this.packages + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$SelectedPackage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$SelectedPackage;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ComponentOverride$Condition$SelectedPackage$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ SelectedPackage(int i, ArrayOperator arrayOperator, List list, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ComponentOverride$Condition$SelectedPackage$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = arrayOperator;
                this.packages = list;
            }

            public SelectedPackage(ArrayOperator operator, List<String> packages) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(packages, "packages");
                this.operator = operator;
                this.packages = packages;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(SelectedPackage self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer[] kSerializerArr = $childSerializers;
                output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.operator);
                output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.packages);
            }

            public final ArrayOperator getOperator() {
                return this.operator;
            }

            public final List<String> getPackages() {
                return this.packages;
            }
        }

        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Variable;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "seen1", "", "operator", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "variable", "", "value", "Lkotlinx/serialization/json/JsonPrimitive;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;Ljava/lang/String;Lkotlinx/serialization/json/JsonPrimitive;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;Ljava/lang/String;Lkotlinx/serialization/json/JsonPrimitive;)V", "isRule", "", "()Z", "getOperator", "()Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$EqualityOperator;", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "getVariable", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Variable implements Condition {
            private final EqualityOperator operator;
            private final JsonPrimitive value;
            private final String variable;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {EqualityOperator.INSTANCE.serializer(), null, null};

            public static /* synthetic */ Variable copy$default(Variable variable, EqualityOperator equalityOperator, String str, JsonPrimitive jsonPrimitive, int i, Object obj) {
                if ((i & 1) != 0) {
                    equalityOperator = variable.operator;
                }
                if ((i & 2) != 0) {
                    str = variable.variable;
                }
                if ((i & 4) != 0) {
                    jsonPrimitive = variable.value;
                }
                return variable.copy(equalityOperator, str, jsonPrimitive);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EqualityOperator getOperator() {
                return this.operator;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getVariable() {
                return this.variable;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final JsonPrimitive getValue() {
                return this.value;
            }

            public final Variable copy(EqualityOperator operator, String variable, JsonPrimitive value) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(variable, "variable");
                Intrinsics.checkNotNullParameter(value, "value");
                return new Variable(operator, variable, value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Variable)) {
                    return false;
                }
                Variable variable = (Variable) other;
                return this.operator == variable.operator && Intrinsics.areEqual(this.variable, variable.variable) && Intrinsics.areEqual(this.value, variable.value);
            }

            public int hashCode() {
                return (((this.operator.hashCode() * 31) + this.variable.hashCode()) * 31) + this.value.hashCode();
            }

            @Override // com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition
            public boolean isRule() {
                return true;
            }

            public String toString() {
                return "Variable(operator=" + this.operator + ", variable=" + this.variable + ", value=" + this.value + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Variable$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Variable;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ComponentOverride$Condition$Variable$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Variable(int i, EqualityOperator equalityOperator, String str, JsonPrimitive jsonPrimitive, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i & 7)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 7, ComponentOverride$Condition$Variable$$serializer.INSTANCE.getDescriptor());
                }
                this.operator = equalityOperator;
                this.variable = str;
                this.value = jsonPrimitive;
            }

            public Variable(EqualityOperator operator, String variable, JsonPrimitive value) {
                Intrinsics.checkNotNullParameter(operator, "operator");
                Intrinsics.checkNotNullParameter(variable, "variable");
                Intrinsics.checkNotNullParameter(value, "value");
                this.operator = operator;
                this.variable = variable;
                this.value = value;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Variable self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.operator);
                output.encodeStringElement(serialDesc, 1, self.variable);
                output.encodeSerializableElement(serialDesc, 2, JsonPrimitiveSerializer.INSTANCE, self.value);
            }

            public final EqualityOperator getOperator() {
                return this.operator;
            }

            public final String getVariable() {
                return this.variable;
            }

            public final JsonPrimitive getValue() {
                return this.value;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition$Unsupported;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Unsupported implements Condition {
            public static final Unsupported INSTANCE = new Unsupported();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Unsupported.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.common.ComponentOverride.Condition.Unsupported", Unsupported.INSTANCE, new Annotation[0]);
                }
            });

            private Unsupported() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }
    }
}
