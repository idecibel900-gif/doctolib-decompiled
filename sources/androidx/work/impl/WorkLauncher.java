package androidx.work.impl;

import androidx.work.WorkerParameters;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkLauncher {
    void startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras);

    void stopWork(StartStopToken startStopToken, int i);

    default void startWork(StartStopToken workSpecId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        startWork(workSpecId, null);
    }

    default void stopWork(StartStopToken workSpecId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        stopWork(workSpecId, -512);
    }

    default void stopWorkWithReason(StartStopToken workSpecId, int i) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        stopWork(workSpecId, i);
    }
}
