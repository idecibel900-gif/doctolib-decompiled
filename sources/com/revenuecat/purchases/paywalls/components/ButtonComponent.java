package com.revenuecat.purchases.paywalls.components;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 $2\u00020\u0001:\u0005\"#$%&BK\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "action", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "transition", "Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", "name", "", DiagnosticsEntry.ID_KEY, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "getId", "()Ljava/lang/String;", "getName", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "getTransition", "()Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Action", "Companion", "Destination", "UrlMethod", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ButtonComponent implements PaywallComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Action action;
    private final String id;
    private final String name;
    private final StackComponent stack;
    private final PaywallTransition transition;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) obj;
        return Intrinsics.areEqual(this.action, buttonComponent.action) && Intrinsics.areEqual(this.stack, buttonComponent.stack) && Intrinsics.areEqual(this.transition, buttonComponent.transition) && Intrinsics.areEqual(this.name, buttonComponent.name) && Intrinsics.areEqual(this.id, buttonComponent.id);
    }

    public int hashCode() {
        int iHashCode = ((this.action.hashCode() * 31) + this.stack.hashCode()) * 31;
        PaywallTransition paywallTransition = this.transition;
        int iHashCode2 = (iHashCode + (paywallTransition == null ? 0 : paywallTransition.hashCode())) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.id;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ButtonComponent(action=" + this.action + ", stack=" + this.stack + ", transition=" + this.transition + ", name=" + this.name + ", id=" + this.id + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return ButtonComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ ButtonComponent(int i, Action action, StackComponent stackComponent, PaywallTransition paywallTransition, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.action = action;
        this.stack = stackComponent;
        if ((i & 4) == 0) {
            this.transition = null;
        } else {
            this.transition = paywallTransition;
        }
        if ((i & 8) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        if ((i & 16) == 0) {
            this.id = null;
        } else {
            this.id = str2;
        }
    }

    public ButtonComponent(Action action, StackComponent stack, PaywallTransition paywallTransition, String str, String str2) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.action = action;
        this.stack = stack;
        this.transition = paywallTransition;
        this.name = str;
        this.id = str2;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ButtonComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ActionSerializer.INSTANCE, self.action);
        output.encodeSerializableElement(serialDesc, 1, StackComponent$$serializer.INSTANCE, self.stack);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.transition != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, PaywallTransition$$serializer.INSTANCE, self.transition);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.name);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.id == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.id);
    }

    public /* synthetic */ ButtonComponent(Action action, StackComponent stackComponent, PaywallTransition paywallTransition, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(action, stackComponent, (i & 4) != 0 ? null : paywallTransition, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2);
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ PaywallTransition getTransition() {
        return this.transition;
    }

    public final /* synthetic */ String getName() {
        return this.name;
    }

    public final /* synthetic */ String getId() {
        return this.id;
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "", "Companion", "NavigateBack", "NavigateTo", "RestorePurchases", "Unknown", "WorkflowTrigger", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateBack;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$RestorePurchases;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$WorkflowTrigger;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Action {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer serializer() {
                return ActionSerializer.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Unknown implements Action {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.Unknown.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.Unknown", Unknown.INSTANCE, new Annotation[0]);
                }
            });

            private Unknown() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$RestorePurchases;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class RestorePurchases implements Action {
            public static final RestorePurchases INSTANCE = new RestorePurchases();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.RestorePurchases.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.RestorePurchases", RestorePurchases.INSTANCE, new Annotation[0]);
                }
            });

            private RestorePurchases() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateBack;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NavigateBack implements Action {
            public static final NavigateBack INSTANCE = new NavigateBack();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateBack.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateBack", NavigateBack.INSTANCE, new Annotation[0]);
                }
            });

            private NavigateBack() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$WorkflowTrigger;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class WorkflowTrigger implements Action {
            public static final WorkflowTrigger INSTANCE = new WorkflowTrigger();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.WorkflowTrigger.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.WorkflowTrigger", WorkflowTrigger.INSTANCE, new Annotation[0]);
                }
            });

            private WorkflowTrigger() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action;", "seen1", "", "destination", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;)V", "getDestination", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class NavigateTo implements Action {
            private final Destination destination;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", Reflection.getOrCreateKotlinClass(Destination.class), new KClass[]{Reflection.getOrCreateKotlinClass(Destination.CustomerCenter.class), Reflection.getOrCreateKotlinClass(Destination.PrivacyPolicy.class), Reflection.getOrCreateKotlinClass(Destination.Sheet.class), Reflection.getOrCreateKotlinClass(Destination.Terms.class), Reflection.getOrCreateKotlinClass(Destination.Unknown.class), Reflection.getOrCreateKotlinClass(Destination.Url.class)}, new KSerializer[]{new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", Destination.CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Destination.Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0])};

            public static /* synthetic */ NavigateTo copy$default(NavigateTo navigateTo, Destination destination, int i, Object obj) {
                if ((i & 1) != 0) {
                    destination = navigateTo.destination;
                }
                return navigateTo.copy(destination);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Destination getDestination() {
                return this.destination;
            }

            public final NavigateTo copy(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                return new NavigateTo(destination);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateTo) && Intrinsics.areEqual(this.destination, ((NavigateTo) other).destination);
            }

            public int hashCode() {
                return this.destination.hashCode();
            }

            public String toString() {
                return "NavigateTo(destination=" + this.destination + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Action$NavigateTo;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ButtonComponent$Action$NavigateTo$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ NavigateTo(int i, Destination destination, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, ButtonComponent$Action$NavigateTo$$serializer.INSTANCE.getDescriptor());
                }
                this.destination = destination;
            }

            public NavigateTo(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                this.destination = destination;
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "", "Companion", "CustomerCenter", "PrivacyPolicy", "Sheet", "Terms", "Unknown", "Url", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Destination {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer serializer() {
                return new SealedClassSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination", Reflection.getOrCreateKotlinClass(Destination.class), new KClass[]{Reflection.getOrCreateKotlinClass(CustomerCenter.class), Reflection.getOrCreateKotlinClass(PrivacyPolicy.class), Reflection.getOrCreateKotlinClass(Sheet.class), Reflection.getOrCreateKotlinClass(Terms.class), Reflection.getOrCreateKotlinClass(Unknown.class), Reflection.getOrCreateKotlinClass(Url.class)}, new KSerializer[]{new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]), ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, ButtonComponent$Destination$Terms$$serializer.INSTANCE, new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]), ButtonComponent$Destination$Url$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Unknown implements Destination {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Unknown", Unknown.INSTANCE, new Annotation[0]);
                }
            });

            private Unknown() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CustomerCenter implements Destination {
            public static final CustomerCenter INSTANCE = new CustomerCenter();
            private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.CustomerCenter", CustomerCenter.INSTANCE, new Annotation[0]);
                }
            });

            private CustomerCenter() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) $cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }
        }

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "seen1", "", "urlLid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "method", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getUrlLid-z7Tp-4o", "()Ljava/lang/String;", "Ljava/lang/String;", "component1", "component1-z7Tp-4o", "component2", "copy", "copy-26kQY28", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class PrivacyPolicy implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            @Deprecated
            public /* synthetic */ PrivacyPolicy(int i, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, urlMethod, serializationConstructorMarker);
            }

            public /* synthetic */ PrivacyPolicy(String str, UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, urlMethod);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ PrivacyPolicy m3915copy26kQY28$default(PrivacyPolicy privacyPolicy, String str, UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = privacyPolicy.urlLid;
                }
                if ((i & 2) != 0) {
                    urlMethod = privacyPolicy.method;
                }
                return privacyPolicy.m3917copy26kQY28(str, urlMethod);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
            public final String getUrlLid() {
                return this.urlLid;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final PrivacyPolicy m3917copy26kQY28(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                return new PrivacyPolicy(urlLid, method, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PrivacyPolicy)) {
                    return false;
                }
                PrivacyPolicy privacyPolicy = (PrivacyPolicy) other;
                return LocalizationKey.m3992equalsimpl0(this.urlLid, privacyPolicy.urlLid) && this.method == privacyPolicy.method;
            }

            public int hashCode() {
                return (LocalizationKey.m3993hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "PrivacyPolicy(urlLid=" + ((Object) LocalizationKey.m3994toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$PrivacyPolicy;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE;
                }
            }

            private PrivacyPolicy(int i, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ButtonComponent$Destination$PrivacyPolicy$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private PrivacyPolicy(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PrivacyPolicy self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m3989boximpl(self.urlLid));
                output.encodeSerializableElement(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.method);
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m3918getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }
        }

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "seen1", "", "urlLid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "method", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getUrlLid-z7Tp-4o", "()Ljava/lang/String;", "Ljava/lang/String;", "component1", "component1-z7Tp-4o", "component2", "copy", "copy-26kQY28", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Terms implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            @Deprecated
            public /* synthetic */ Terms(int i, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, urlMethod, serializationConstructorMarker);
            }

            public /* synthetic */ Terms(String str, UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, urlMethod);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Terms m3919copy26kQY28$default(Terms terms, String str, UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = terms.urlLid;
                }
                if ((i & 2) != 0) {
                    urlMethod = terms.method;
                }
                return terms.m3921copy26kQY28(str, urlMethod);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
            public final String getUrlLid() {
                return this.urlLid;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Terms m3921copy26kQY28(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                return new Terms(urlLid, method, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Terms)) {
                    return false;
                }
                Terms terms = (Terms) other;
                return LocalizationKey.m3992equalsimpl0(this.urlLid, terms.urlLid) && this.method == terms.method;
            }

            public int hashCode() {
                return (LocalizationKey.m3993hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Terms(urlLid=" + ((Object) LocalizationKey.m3994toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Terms;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ButtonComponent$Destination$Terms$$serializer.INSTANCE;
                }
            }

            private Terms(int i, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ButtonComponent$Destination$Terms$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private Terms(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Terms self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m3989boximpl(self.urlLid));
                output.encodeSerializableElement(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.method);
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m3922getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }
        }

        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "seen1", "", "urlLid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "method", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getUrlLid-z7Tp-4o", "()Ljava/lang/String;", "Ljava/lang/String;", "component1", "component1-z7Tp-4o", "component2", "copy", "copy-26kQY28", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Url implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final UrlMethod method;
            private final String urlLid;

            @Deprecated
            public /* synthetic */ Url(int i, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, urlMethod, serializationConstructorMarker);
            }

            public /* synthetic */ Url(String str, UrlMethod urlMethod, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, urlMethod);
            }

            /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
            public static /* synthetic */ Url m3923copy26kQY28$default(Url url, String str, UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = url.urlLid;
                }
                if ((i & 2) != 0) {
                    urlMethod = url.method;
                }
                return url.m3925copy26kQY28(str, urlMethod);
            }

            /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
            public final String getUrlLid() {
                return this.urlLid;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final UrlMethod getMethod() {
                return this.method;
            }

            /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
            public final Url m3925copy26kQY28(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                return new Url(urlLid, method, null);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Url)) {
                    return false;
                }
                Url url = (Url) other;
                return LocalizationKey.m3992equalsimpl0(this.urlLid, url.urlLid) && this.method == url.method;
            }

            public int hashCode() {
                return (LocalizationKey.m3993hashCodeimpl(this.urlLid) * 31) + this.method.hashCode();
            }

            public String toString() {
                return "Url(urlLid=" + ((Object) LocalizationKey.m3994toStringimpl(this.urlLid)) + ", method=" + this.method + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Url;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ButtonComponent$Destination$Url$$serializer.INSTANCE;
                }
            }

            private Url(int i, String str, UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, ButtonComponent$Destination$Url$$serializer.INSTANCE.getDescriptor());
                }
                this.urlLid = str;
                this.method = urlMethod;
            }

            private Url(String urlLid, UrlMethod method) {
                Intrinsics.checkNotNullParameter(urlLid, "urlLid");
                Intrinsics.checkNotNullParameter(method, "method");
                this.urlLid = urlLid;
                this.method = method;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Url self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m3989boximpl(self.urlLid));
                output.encodeSerializableElement(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.method);
            }

            /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
            public final /* synthetic */ String m3926getUrlLidz7Tp4o() {
                return this.urlLid;
            }

            public final /* synthetic */ UrlMethod getMethod() {
                return this.method;
            }
        }

        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BK\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J?\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÁ\u0001¢\u0006\u0002\b.R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination;", "seen1", "", DiagnosticsEntry.ID_KEY, "", "name", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "backgroundBlur", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/StackComponent;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/StackComponent;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;)V", "getBackgroundBlur$annotations", "()V", "getBackgroundBlur", "()Z", "getId", "()Ljava/lang/String;", "getName", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Sheet implements Destination {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final boolean backgroundBlur;
            private final String id;
            private final String name;
            private final Size size;
            private final StackComponent stack;

            public static /* synthetic */ Sheet copy$default(Sheet sheet, String str, String str2, StackComponent stackComponent, boolean z, Size size, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sheet.id;
                }
                if ((i & 2) != 0) {
                    str2 = sheet.name;
                }
                if ((i & 4) != 0) {
                    stackComponent = sheet.stack;
                }
                if ((i & 8) != 0) {
                    z = sheet.backgroundBlur;
                }
                if ((i & 16) != 0) {
                    size = sheet.size;
                }
                Size size2 = size;
                StackComponent stackComponent2 = stackComponent;
                return sheet.copy(str, str2, stackComponent2, z, size2);
            }

            public static /* synthetic */ void getBackgroundBlur$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StackComponent getStack() {
                return this.stack;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getBackgroundBlur() {
                return this.backgroundBlur;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Size getSize() {
                return this.size;
            }

            public final Sheet copy(String id, String name, StackComponent stack, boolean backgroundBlur, Size size) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(stack, "stack");
                return new Sheet(id, name, stack, backgroundBlur, size);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Sheet)) {
                    return false;
                }
                Sheet sheet = (Sheet) other;
                return Intrinsics.areEqual(this.id, sheet.id) && Intrinsics.areEqual(this.name, sheet.name) && Intrinsics.areEqual(this.stack, sheet.stack) && this.backgroundBlur == sheet.backgroundBlur && Intrinsics.areEqual(this.size, sheet.size);
            }

            public int hashCode() {
                int iHashCode = this.id.hashCode() * 31;
                String str = this.name;
                int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.stack.hashCode()) * 31) + Boolean.hashCode(this.backgroundBlur)) * 31;
                Size size = this.size;
                return iHashCode2 + (size != null ? size.hashCode() : 0);
            }

            public String toString() {
                return "Sheet(id=" + this.id + ", name=" + this.name + ", stack=" + this.stack + ", backgroundBlur=" + this.backgroundBlur + ", size=" + this.size + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return ButtonComponent$Destination$Sheet$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Sheet(int i, String str, String str2, StackComponent stackComponent, boolean z, Size size, SerializationConstructorMarker serializationConstructorMarker) {
                if (31 != (i & 31)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 31, ButtonComponent$Destination$Sheet$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
                this.stack = stackComponent;
                this.backgroundBlur = z;
                this.size = size;
            }

            public Sheet(String id, String str, StackComponent stack, boolean z, Size size) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(stack, "stack");
                this.id = id;
                this.name = str;
                this.stack = stack;
                this.backgroundBlur = z;
                this.size = size;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Sheet self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.id);
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
                output.encodeSerializableElement(serialDesc, 2, StackComponent$$serializer.INSTANCE, self.stack);
                output.encodeBooleanElement(serialDesc, 3, self.backgroundBlur);
                output.encodeNullableSerializableElement(serialDesc, 4, Size$$serializer.INSTANCE, self.size);
            }

            public final /* synthetic */ String getId() {
                return this.id;
            }

            public final /* synthetic */ String getName() {
                return this.name;
            }

            public final /* synthetic */ StackComponent getStack() {
                return this.stack;
            }

            public final /* synthetic */ boolean getBackgroundBlur() {
                return this.backgroundBlur;
            }

            public final /* synthetic */ Size getSize() {
                return this.size;
            }
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "", "(Ljava/lang/String;I)V", "IN_APP_BROWSER", "EXTERNAL_BROWSER", "DEEP_LINK", "UNKNOWN", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum UrlMethod {
        IN_APP_BROWSER,
        EXTERNAL_BROWSER,
        DEEP_LINK,
        UNKNOWN;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return UrlMethodDeserializer.INSTANCE;
            }
        }
    }
}
