package expo.modules.updates.loader;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileDownloader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileDownloader$downloadAssetAndVerifyHashAndWriteToPath$1(FileDownloader fileDownloader, Continuation continuation) {
        super(continuation);
        this.this$0 = fileDownloader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return this.this$0.downloadAssetAndVerifyHashAndWriteToPath$expo_updates_release(null, null, null, null, null, null, null, false, null, null, this);
    }
}
