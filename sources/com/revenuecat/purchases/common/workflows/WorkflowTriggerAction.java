package com.revenuecat.purchases.common.workflows;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction;", "", "()V", "Companion", "Step", "Unknown", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction$Step;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction$Unknown;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class WorkflowTriggerAction {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ WorkflowTriggerAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return WorkflowTriggerActionSerializer.INSTANCE;
        }
    }

    private WorkflowTriggerAction() {
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB%\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÁ\u0001¢\u0006\u0002\b\u001dR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction$Step;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction;", "seen1", "", "stepId", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getStepId$annotations", "()V", "getStepId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Step extends WorkflowTriggerAction {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String stepId;

        public static /* synthetic */ Step copy$default(Step step, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = step.stepId;
            }
            return step.copy(str);
        }

        public static /* synthetic */ void getStepId$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getStepId() {
            return this.stepId;
        }

        public final Step copy(String stepId) {
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            return new Step(stepId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Step) && Intrinsics.areEqual(this.stepId, ((Step) other).stepId);
        }

        public int hashCode() {
            return this.stepId.hashCode();
        }

        public String toString() {
            return "Step(stepId=" + this.stepId + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction$Step$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction$Step;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return WorkflowTriggerAction$Step$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Step(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(null);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, WorkflowTriggerAction$Step$$serializer.INSTANCE.getDescriptor());
            }
            this.stepId = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Step(String stepId) {
            super(null);
            Intrinsics.checkNotNullParameter(stepId, "stepId");
            this.stepId = stepId;
        }

        public final String getStepId() {
            return this.stepId;
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction$Unknown;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerAction;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Unknown extends WorkflowTriggerAction {
        public static final Unknown INSTANCE = new Unknown();
        private static final /* synthetic */ Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.common.workflows.WorkflowTriggerAction.Unknown.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return new ObjectSerializer("com.revenuecat.purchases.common.workflows.WorkflowTriggerAction.Unknown", Unknown.INSTANCE, new Annotation[0]);
            }
        });

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer serializer() {
            return get$cachedSerializer();
        }

        private Unknown() {
            super(null);
        }
    }
}
