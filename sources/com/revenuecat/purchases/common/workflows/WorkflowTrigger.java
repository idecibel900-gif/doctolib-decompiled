package com.revenuecat.purchases.common.workflows;

import com.opentok.android.PublisherKit;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*BE\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÁ\u0001¢\u0006\u0002\b(R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTrigger;", "", "seen1", "", "name", "", "type", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "actionId", "componentId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;Ljava/lang/String;Ljava/lang/String;)V", "getActionId$annotations", "()V", "getActionId", "()Ljava/lang/String;", "getComponentId$annotations", "getComponentId", "getName", "getType", "()Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorkflowTrigger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String actionId;
    private final String componentId;
    private final String name;
    private final WorkflowTriggerType type;

    public static /* synthetic */ WorkflowTrigger copy$default(WorkflowTrigger workflowTrigger, String str, WorkflowTriggerType workflowTriggerType, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = workflowTrigger.name;
        }
        if ((i & 2) != 0) {
            workflowTriggerType = workflowTrigger.type;
        }
        if ((i & 4) != 0) {
            str2 = workflowTrigger.actionId;
        }
        if ((i & 8) != 0) {
            str3 = workflowTrigger.componentId;
        }
        return workflowTrigger.copy(str, workflowTriggerType, str2, str3);
    }

    public static /* synthetic */ void getActionId$annotations() {
    }

    public static /* synthetic */ void getComponentId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WorkflowTriggerType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActionId() {
        return this.actionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getComponentId() {
        return this.componentId;
    }

    public final WorkflowTrigger copy(String name, WorkflowTriggerType type, String actionId, String componentId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        return new WorkflowTrigger(name, type, actionId, componentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowTrigger)) {
            return false;
        }
        WorkflowTrigger workflowTrigger = (WorkflowTrigger) other;
        return Intrinsics.areEqual(this.name, workflowTrigger.name) && this.type == workflowTrigger.type && Intrinsics.areEqual(this.actionId, workflowTrigger.actionId) && Intrinsics.areEqual(this.componentId, workflowTrigger.componentId);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.actionId.hashCode()) * 31) + this.componentId.hashCode();
    }

    public String toString() {
        return "WorkflowTrigger(name=" + this.name + ", type=" + this.type + ", actionId=" + this.actionId + ", componentId=" + this.componentId + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowTrigger$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowTrigger;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return WorkflowTrigger$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ WorkflowTrigger(int i, String str, WorkflowTriggerType workflowTriggerType, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, WorkflowTrigger$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.type = workflowTriggerType;
        this.actionId = str2;
        this.componentId = str3;
    }

    public WorkflowTrigger(String name, WorkflowTriggerType type, String actionId, String componentId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        this.name = name;
        this.type = type;
        this.actionId = actionId;
        this.componentId = componentId;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WorkflowTrigger self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeSerializableElement(serialDesc, 1, WorkflowTriggerTypeDeserializer.INSTANCE, self.type);
        output.encodeStringElement(serialDesc, 2, self.actionId);
        output.encodeStringElement(serialDesc, 3, self.componentId);
    }

    public final String getName() {
        return this.name;
    }

    public final WorkflowTriggerType getType() {
        return this.type;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final String getComponentId() {
        return this.componentId;
    }
}
