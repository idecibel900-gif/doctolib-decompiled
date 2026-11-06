package expo.modules.kotlin.activityresult;

import androidx.activity.result.ActivityResultCallback;
import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AppContextActivityResultLauncher {
    public abstract void launch(Serializable serializable, ActivityResultCallback activityResultCallback);

    public final Object launch(Serializable serializable, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        launch(serializable, new ActivityResultCallback() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultLauncher$launch$2$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                if (cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(obj));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
