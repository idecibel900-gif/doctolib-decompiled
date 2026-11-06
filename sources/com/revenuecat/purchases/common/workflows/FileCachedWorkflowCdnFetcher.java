package com.revenuecat.purchases.common.workflows;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.storage.FileRepository;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/workflows/FileCachedWorkflowCdnFetcher;", "Lcom/revenuecat/purchases/common/workflows/WorkflowCdnFetcher;", "fileRepository", "Lcom/revenuecat/purchases/storage/FileRepository;", "(Lcom/revenuecat/purchases/storage/FileRepository;)V", "fetchCompiledWorkflowJson", "", "cdnUrl", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "(Ljava/lang/String;Lcom/revenuecat/purchases/models/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileCachedWorkflowCdnFetcher implements WorkflowCdnFetcher {
    private final FileRepository fileRepository;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher$fetchCompiledWorkflowJson$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.common.workflows.FileCachedWorkflowCdnFetcher", f = "WorkflowCdnFetcher.kt", l = {30}, m = "fetchCompiledWorkflowJson")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return FileCachedWorkflowCdnFetcher.this.fetchCompiledWorkflowJson(null, null, this);
        }
    }

    public FileCachedWorkflowCdnFetcher(FileRepository fileRepository) {
        Intrinsics.checkNotNullParameter(fileRepository, "fileRepository");
        this.fileRepository = fileRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.revenuecat.purchases.common.workflows.WorkflowCdnFetcher
    public Object fetchCompiledWorkflowJson(String str, Checksum checksum, Continuation continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
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
        Object objGenerateOrGetCachedFileURL = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objGenerateOrGetCachedFileURL);
            URL url = new URL(str);
            FileRepository fileRepository = this.fileRepository;
            anonymousClass1.label = 1;
            objGenerateOrGetCachedFileURL = fileRepository.generateOrGetCachedFileURL(url, checksum, anonymousClass1);
            if (objGenerateOrGetCachedFileURL == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objGenerateOrGetCachedFileURL);
        }
        return FilesKt.readText$default(new File((URI) objGenerateOrGetCachedFileURL), null, 1, null);
    }
}
