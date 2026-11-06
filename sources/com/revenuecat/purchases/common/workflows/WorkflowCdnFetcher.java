package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.models.Checksum;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowCdnFetcher;", "", "fetchCompiledWorkflowJson", "", "cdnUrl", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "(Ljava/lang/String;Lcom/revenuecat/purchases/models/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface WorkflowCdnFetcher {
    Object fetchCompiledWorkflowJson(String str, Checksum checksum, Continuation continuation) throws IOException;
}
