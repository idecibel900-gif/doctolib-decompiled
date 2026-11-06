package com.revenuecat.purchases.common.workflows;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import com.revenuecat.purchases.models.Checksum;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowDetailResolver;", "", "workflowCdnFetcher", "Lcom/revenuecat/purchases/common/workflows/WorkflowCdnFetcher;", "(Lcom/revenuecat/purchases/common/workflows/WorkflowCdnFetcher;)V", "resolve", "Lcom/revenuecat/purchases/common/workflows/WorkflowDataResult;", "response", "Lcom/revenuecat/purchases/common/workflows/WorkflowDetailResponse;", "(Lcom/revenuecat/purchases/common/workflows/WorkflowDetailResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkflowDetailResolver {
    private final WorkflowCdnFetcher workflowCdnFetcher;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkflowResponseAction.values().length];
            try {
                iArr[WorkflowResponseAction.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkflowResponseAction.USE_CDN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowDetailResolver$resolve$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.common.workflows.WorkflowDetailResolver", f = "WorkflowDetailResolver.kt", l = {28}, m = "resolve")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return WorkflowDetailResolver.this.resolve(null, this);
        }
    }

    public WorkflowDetailResolver(WorkflowCdnFetcher workflowCdnFetcher) {
        Intrinsics.checkNotNullParameter(workflowCdnFetcher, "workflowCdnFetcher");
        this.workflowCdnFetcher = workflowCdnFetcher;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object resolve(WorkflowDetailResponse workflowDetailResponse, Continuation continuation) throws IllegalStateException, IOException, SignatureVerificationException {
        AnonymousClass1 anonymousClass1;
        PublishedWorkflow data;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objFetchCompiledWorkflowJson = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFetchCompiledWorkflowJson);
            int i3 = WhenMappings.$EnumSwitchMapping$0[workflowDetailResponse.getAction().ordinal()];
            if (i3 == 1) {
                data = workflowDetailResponse.getData();
                if (data == null) {
                    throw new IllegalStateException("Inline workflow response missing data");
                }
            } else if (i3 == 2) {
                String url = workflowDetailResponse.getUrl();
                if (url == null) {
                    throw new IllegalStateException("CDN workflow response missing url");
                }
                String hash = workflowDetailResponse.getHash();
                Checksum checksum = hash != null ? new Checksum(Checksum.Algorithm.SHA256, hash) : null;
                WorkflowCdnFetcher workflowCdnFetcher = this.workflowCdnFetcher;
                anonymousClass1.L$0 = workflowDetailResponse;
                anonymousClass1.label = 1;
                objFetchCompiledWorkflowJson = workflowCdnFetcher.fetchCompiledWorkflowJson(url, checksum, anonymousClass1);
                if (objFetchCompiledWorkflowJson == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new WorkflowDataResult(data, workflowDetailResponse.getEnrolledVariants());
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        workflowDetailResponse = (WorkflowDetailResponse) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objFetchCompiledWorkflowJson);
        data = WorkflowJsonParser.INSTANCE.parsePublishedWorkflow((String) objFetchCompiledWorkflowJson);
        return new WorkflowDataResult(data, workflowDetailResponse.getEnrolledVariants());
    }
}
