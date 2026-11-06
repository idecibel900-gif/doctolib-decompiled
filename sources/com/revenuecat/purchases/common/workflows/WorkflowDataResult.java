package com.revenuecat.purchases.common.workflows;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowDataResult;", "", "workflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "enrolledVariants", "", "", "(Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;Ljava/util/Map;)V", "getEnrolledVariants", "()Ljava/util/Map;", "getWorkflow", "()Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WorkflowDataResult {
    private final Map<String, String> enrolledVariants;
    private final PublishedWorkflow workflow;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowDataResult copy$default(WorkflowDataResult workflowDataResult, PublishedWorkflow publishedWorkflow, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            publishedWorkflow = workflowDataResult.workflow;
        }
        if ((i & 2) != 0) {
            map = workflowDataResult.enrolledVariants;
        }
        return workflowDataResult.copy(publishedWorkflow, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PublishedWorkflow getWorkflow() {
        return this.workflow;
    }

    public final Map<String, String> component2() {
        return this.enrolledVariants;
    }

    public final WorkflowDataResult copy(PublishedWorkflow workflow, Map<String, String> enrolledVariants) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        return new WorkflowDataResult(workflow, enrolledVariants);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowDataResult)) {
            return false;
        }
        WorkflowDataResult workflowDataResult = (WorkflowDataResult) other;
        return Intrinsics.areEqual(this.workflow, workflowDataResult.workflow) && Intrinsics.areEqual(this.enrolledVariants, workflowDataResult.enrolledVariants);
    }

    public int hashCode() {
        int iHashCode = this.workflow.hashCode() * 31;
        Map<String, String> map = this.enrolledVariants;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "WorkflowDataResult(workflow=" + this.workflow + ", enrolledVariants=" + this.enrolledVariants + ')';
    }

    public WorkflowDataResult(PublishedWorkflow workflow, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        this.workflow = workflow;
        this.enrolledVariants = map;
    }

    public final PublishedWorkflow getWorkflow() {
        return this.workflow;
    }

    public final Map<String, String> getEnrolledVariants() {
        return this.enrolledVariants;
    }
}
