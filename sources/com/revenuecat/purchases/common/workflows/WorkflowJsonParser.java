package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.JsonTools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowJsonParser;", "", "()V", "parsePublishedWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "payload", "", "parseWorkflowDetailResponse", "Lcom/revenuecat/purchases/common/workflows/WorkflowDetailResponse;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkflowJsonParser {
    public static final WorkflowJsonParser INSTANCE = new WorkflowJsonParser();

    private WorkflowJsonParser() {
    }

    public final PublishedWorkflow parsePublishedWorkflow(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Json json = JsonTools.INSTANCE.getJson();
        json.getSerializersModule();
        return (PublishedWorkflow) json.decodeFromString(PublishedWorkflow.INSTANCE.serializer(), payload);
    }

    public final WorkflowDetailResponse parseWorkflowDetailResponse(String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Json json = JsonTools.INSTANCE.getJson();
        json.getSerializersModule();
        return (WorkflowDetailResponse) json.decodeFromString(WorkflowDetailResponse.INSTANCE.serializer(), payload);
    }
}
