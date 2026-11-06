package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes5.dex */
public interface ParentJob extends Job {
    CancellationException getChildJobCancellationCause();
}
