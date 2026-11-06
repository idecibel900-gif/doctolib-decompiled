package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes3.dex */
public interface Scheduler {
    void cancel(String str);

    boolean hasLimitedSchedulingSlots();

    void schedule(WorkSpec... workSpecArr);
}
