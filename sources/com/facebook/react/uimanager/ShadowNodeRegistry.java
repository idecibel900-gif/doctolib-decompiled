package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ShadowNodeRegistry {
    private static final Companion Companion = new Companion(null);
    private final SparseArray tagsToCSSNodes = new SparseArray();
    private final SparseBooleanArray rootTags = new SparseBooleanArray();
    private final SingleThreadAsserter threadAsserter = new SingleThreadAsserter();

    public final void addRootNode(ReactShadowNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.threadAsserter.assertNow();
        int reactTag = node.getReactTag();
        this.tagsToCSSNodes.put(reactTag, node);
        this.rootTags.put(reactTag, true);
    }

    public final void removeRootNode(int i) {
        this.threadAsserter.assertNow();
        if (i == -1) {
            return;
        }
        if (!this.rootTags.get(i)) {
            throw new IllegalViewOperationException("View with tag " + i + " is not registered as a root view");
        }
        this.tagsToCSSNodes.remove(i);
        this.rootTags.delete(i);
    }

    public final void addNode(ReactShadowNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.threadAsserter.assertNow();
        this.tagsToCSSNodes.put(node.getReactTag(), node);
    }

    public final void removeNode(int i) {
        this.threadAsserter.assertNow();
        if (this.rootTags.get(i)) {
            throw new IllegalViewOperationException("Trying to remove root node " + i + " without using removeRootNode!");
        }
        this.tagsToCSSNodes.remove(i);
    }

    public final ReactShadowNode getNode(int i) {
        this.threadAsserter.assertNow();
        return (ReactShadowNode) this.tagsToCSSNodes.get(i);
    }

    public final boolean isRootNode(int i) {
        this.threadAsserter.assertNow();
        return this.rootTags.get(i);
    }

    public final int getRootNodeCount() {
        this.threadAsserter.assertNow();
        return this.rootTags.size();
    }

    public final int getRootTag(int i) {
        this.threadAsserter.assertNow();
        return this.rootTags.keyAt(i);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("ShadowNodeRegistry", LegacyArchitectureLogLevel.ERROR);
    }

    public final class SingleThreadAsserter {
        private Thread thread;

        public SingleThreadAsserter() {
        }

        public final void assertNow() {
            Thread threadCurrentThread = Thread.currentThread();
            if (this.thread == null) {
                this.thread = threadCurrentThread;
            }
            Assertions.assertCondition(Intrinsics.areEqual(this.thread, threadCurrentThread));
        }
    }
}
