package expo.modules.clipboard;

import android.content.ClipData;
import android.content.Context;
import expo.modules.kotlin.exception.CodedException;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class ClipboardModule$definition$lambda$12$$inlined$Coroutine$4 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClipboardModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipboardModule$definition$lambda$12$$inlined$Coroutine$4(Continuation continuation, ClipboardModule clipboardModule) {
        super(3, continuation);
        this.this$0 = clipboardModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        ClipboardModule$definition$lambda$12$$inlined$Coroutine$4 clipboardModule$definition$lambda$12$$inlined$Coroutine$4 = new ClipboardModule$definition$lambda$12$$inlined$Coroutine$4(continuation, this.this$0);
        clipboardModule$definition$lambda$12$$inlined$Coroutine$4.L$0 = objArr;
        return clipboardModule$definition$lambda$12$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws CopyFailureException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) ((Object[]) this.L$0)[0];
                Context context = this.this$0.getContext();
                File clipboardCacheDir = this.this$0.getClipboardCacheDir();
                this.label = 1;
                obj = ClipboardImageKt.clipDataFromBase64Image(context, str, clipboardCacheDir, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.getClipboardManager().setPrimaryClip((ClipData) obj);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            th.printStackTrace();
            if (th instanceof CodedException) {
                throw th;
            }
            throw new CopyFailureException(th, "image");
        }
    }
}
