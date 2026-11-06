package com.facebook.react.jstasks;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class NoRetryPolicy implements HeadlessJsTaskRetryPolicy {
    public static final Companion Companion = new Companion(null);
    public static final NoRetryPolicy INSTANCE = new NoRetryPolicy();

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public boolean canRetry() {
        return false;
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public HeadlessJsTaskRetryPolicy copy() {
        return this;
    }

    private NoRetryPolicy() {
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public int getDelay() {
        throw new IllegalStateException("Should not retrieve delay as canRetry is: " + canRetry());
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy
    public HeadlessJsTaskRetryPolicy update() {
        throw new IllegalStateException("Should not update as canRetry is: " + canRetry());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
