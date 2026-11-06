package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PriorityThreadFactory implements ThreadFactory {
    private final boolean addThreadNumber;
    private final String prefix;
    private final AtomicInteger threadNumber;
    private final int threadPriority;

    public PriorityThreadFactory(int i, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.threadPriority = i;
        this.prefix = prefix;
        this.addThreadNumber = z;
        this.threadNumber = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.core.PriorityThreadFactory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PriorityThreadFactory.newThread$lambda$0(this.f$0, runnable);
            }
        };
        if (this.addThreadNumber) {
            str = this.prefix + "-" + this.threadNumber.getAndIncrement();
        } else {
            str = this.prefix;
        }
        return new Thread(runnable2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newThread$lambda$0(PriorityThreadFactory this$0, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        try {
            Process.setThreadPriority(this$0.threadPriority);
        } catch (Throwable unused) {
        }
        runnable.run();
    }
}
