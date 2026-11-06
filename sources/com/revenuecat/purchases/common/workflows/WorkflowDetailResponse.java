package com.revenuecat.purchases.common.workflows;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 02\u00020\u0001:\u0002/0BY\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÁ\u0001¢\u0006\u0002\b.R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowDetailResponse;", "", "seen1", "", "action", "Lcom/revenuecat/purchases/common/workflows/WorkflowResponseAction;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "url", "", "hash", "enrolledVariants", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/workflows/WorkflowResponseAction;Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/workflows/WorkflowResponseAction;Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAction", "()Lcom/revenuecat/purchases/common/workflows/WorkflowResponseAction;", "getData", "()Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "getEnrolledVariants$annotations", "()V", "getEnrolledVariants", "()Ljava/util/Map;", "getHash", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorkflowDetailResponse {
    private static final KSerializer[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WorkflowResponseAction action;
    private final PublishedWorkflow data;
    private final Map<String, String> enrolledVariants;
    private final String hash;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowDetailResponse copy$default(WorkflowDetailResponse workflowDetailResponse, WorkflowResponseAction workflowResponseAction, PublishedWorkflow publishedWorkflow, String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            workflowResponseAction = workflowDetailResponse.action;
        }
        if ((i & 2) != 0) {
            publishedWorkflow = workflowDetailResponse.data;
        }
        if ((i & 4) != 0) {
            str = workflowDetailResponse.url;
        }
        if ((i & 8) != 0) {
            str2 = workflowDetailResponse.hash;
        }
        if ((i & 16) != 0) {
            map = workflowDetailResponse.enrolledVariants;
        }
        Map map2 = map;
        String str3 = str;
        return workflowDetailResponse.copy(workflowResponseAction, publishedWorkflow, str3, str2, map2);
    }

    public static /* synthetic */ void getEnrolledVariants$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WorkflowResponseAction getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PublishedWorkflow getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    public final Map<String, String> component5() {
        return this.enrolledVariants;
    }

    public final WorkflowDetailResponse copy(WorkflowResponseAction action, PublishedWorkflow data, String url, String hash, Map<String, String> enrolledVariants) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new WorkflowDetailResponse(action, data, url, hash, enrolledVariants);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowDetailResponse)) {
            return false;
        }
        WorkflowDetailResponse workflowDetailResponse = (WorkflowDetailResponse) other;
        return this.action == workflowDetailResponse.action && Intrinsics.areEqual(this.data, workflowDetailResponse.data) && Intrinsics.areEqual(this.url, workflowDetailResponse.url) && Intrinsics.areEqual(this.hash, workflowDetailResponse.hash) && Intrinsics.areEqual(this.enrolledVariants, workflowDetailResponse.enrolledVariants);
    }

    public int hashCode() {
        int iHashCode = this.action.hashCode() * 31;
        PublishedWorkflow publishedWorkflow = this.data;
        int iHashCode2 = (iHashCode + (publishedWorkflow == null ? 0 : publishedWorkflow.hashCode())) * 31;
        String str = this.url;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.hash;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.enrolledVariants;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "WorkflowDetailResponse(action=" + this.action + ", data=" + this.data + ", url=" + this.url + ", hash=" + this.hash + ", enrolledVariants=" + this.enrolledVariants + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowDetailResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/workflows/WorkflowDetailResponse;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return WorkflowDetailResponse$$serializer.INSTANCE;
        }
    }

    static {
        KSerializer kSerializerSerializer = WorkflowResponseAction.INSTANCE.serializer();
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{kSerializerSerializer, null, null, null, new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
    }

    @Deprecated
    public /* synthetic */ WorkflowDetailResponse(int i, WorkflowResponseAction workflowResponseAction, PublishedWorkflow publishedWorkflow, String str, String str2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, WorkflowDetailResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.action = workflowResponseAction;
        if ((i & 2) == 0) {
            this.data = null;
        } else {
            this.data = publishedWorkflow;
        }
        if ((i & 4) == 0) {
            this.url = null;
        } else {
            this.url = str;
        }
        if ((i & 8) == 0) {
            this.hash = null;
        } else {
            this.hash = str2;
        }
        if ((i & 16) == 0) {
            this.enrolledVariants = null;
        } else {
            this.enrolledVariants = map;
        }
    }

    public WorkflowDetailResponse(WorkflowResponseAction action, PublishedWorkflow publishedWorkflow, String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        this.data = publishedWorkflow;
        this.url = str;
        this.hash = str2;
        this.enrolledVariants = map;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WorkflowDetailResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.action);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, PublishedWorkflow$$serializer.INSTANCE, self.data);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.hash != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.hash);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.enrolledVariants == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.enrolledVariants);
    }

    public /* synthetic */ WorkflowDetailResponse(WorkflowResponseAction workflowResponseAction, PublishedWorkflow publishedWorkflow, String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(workflowResponseAction, (i & 2) != 0 ? null : publishedWorkflow, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : map);
    }

    public final WorkflowResponseAction getAction() {
        return this.action;
    }

    public final PublishedWorkflow getData() {
        return this.data;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getHash() {
        return this.hash;
    }

    public final Map<String, String> getEnrolledVariants() {
        return this.enrolledVariants;
    }
}
