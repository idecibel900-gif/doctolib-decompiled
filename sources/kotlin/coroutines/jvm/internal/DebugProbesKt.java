package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Classes with same name are omitted, all sources:
  Doctolib.apk:DebugProbesKt.bin
  classes5.dex
 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class DebugProbesKt {
    public static final Continuation probeCoroutineCreated(Continuation completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return completion;
    }

    public static final void probeCoroutineResumed(Continuation frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
    }

    public static final void probeCoroutineSuspended(Continuation frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
    }
}
