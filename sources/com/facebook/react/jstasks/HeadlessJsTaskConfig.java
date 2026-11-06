package com.facebook.react.jstasks;

import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class HeadlessJsTaskConfig {
    private final WritableMap data;
    private final boolean isAllowedInForeground;
    private final HeadlessJsTaskRetryPolicy retryPolicy;
    private final String taskKey;
    private final long timeout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadlessJsTaskConfig(String taskKey, WritableMap data, long j, boolean z) {
        this(taskKey, data, j, z, null, 16, null);
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public HeadlessJsTaskConfig(String taskKey, WritableMap data, long j, boolean z, HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy) {
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        Intrinsics.checkNotNullParameter(data, "data");
        this.taskKey = taskKey;
        this.data = data;
        this.timeout = j;
        this.isAllowedInForeground = z;
        this.retryPolicy = headlessJsTaskRetryPolicy;
    }

    public final String getTaskKey() {
        return this.taskKey;
    }

    public final WritableMap getData() {
        return this.data;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final boolean isAllowedInForeground() {
        return this.isAllowedInForeground;
    }

    public /* synthetic */ HeadlessJsTaskConfig(String str, WritableMap writableMap, long j, boolean z, HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, writableMap, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? false : z, (i & 16) != 0 ? NoRetryPolicy.INSTANCE : headlessJsTaskRetryPolicy);
    }

    public final HeadlessJsTaskRetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HeadlessJsTaskConfig(HeadlessJsTaskConfig source) {
        Intrinsics.checkNotNullParameter(source, "source");
        String str = source.taskKey;
        WritableMap writableMapCopy = source.data.copy();
        long j = source.timeout;
        boolean z = source.isAllowedInForeground;
        HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy = source.retryPolicy;
        this(str, writableMapCopy, j, z, headlessJsTaskRetryPolicy != null ? headlessJsTaskRetryPolicy.copy() : null);
    }
}
