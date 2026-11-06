package com.datadog.android.webview.internal.rum.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewNativeRumViewsCache implements NativeRumViewsCache {
    public static final Companion Companion = new Companion(null);
    private static final long DATA_PURGE_TTL_LIMIT_IN_MS = TimeUnit.HOURS.toMillis(2);
    private final long entriesTtlLimitInMs;
    private final LinkedList parentViewsHistoryQueue;

    public WebViewNativeRumViewsCache(long j) {
        this.entriesTtlLimitInMs = j;
        this.parentViewsHistoryQueue = new LinkedList();
    }

    public /* synthetic */ WebViewNativeRumViewsCache(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DATA_PURGE_TTL_LIMIT_IN_MS : j);
    }

    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public synchronized String resolveLastParentIdForBrowserEvent(long j) {
        try {
            Iterator it = this.parentViewsHistoryQueue.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "parentViewsHistoryQueue.iterator()");
            String viewId = null;
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                ViewEntry viewEntry = (ViewEntry) next;
                if (viewEntry.getTimestamp() <= j) {
                    if (viewId == null) {
                        viewId = viewEntry.getViewId();
                    }
                    if (viewEntry.getHasReplay()) {
                        return viewEntry.getViewId();
                    }
                }
            }
            return viewId;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public synchronized void addToCache(Map event) {
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            Object obj = event.get("view_id");
            String str = obj instanceof String ? (String) obj : null;
            Object obj2 = event.get("view_timestamp");
            Long l = obj2 instanceof Long ? (Long) obj2 : null;
            Object obj3 = event.get("view_has_replay");
            Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            if (str != null && !Intrinsics.areEqual(str, RumContext.Companion.getNULL_UUID()) && l != null) {
                addToCache(new ViewEntry(str, l.longValue(), zBooleanValue));
            }
            purgeHistory();
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void addToCache(ViewEntry viewEntry) {
        if (this.parentViewsHistoryQueue.isEmpty() || (!Intrinsics.areEqual(((ViewEntry) this.parentViewsHistoryQueue.getFirst()).getViewId(), viewEntry.getViewId()) && ((ViewEntry) this.parentViewsHistoryQueue.getFirst()).getTimestamp() <= viewEntry.getTimestamp())) {
            this.parentViewsHistoryQueue.add(0, viewEntry);
        } else if (Intrinsics.areEqual(((ViewEntry) this.parentViewsHistoryQueue.getFirst()).getViewId(), viewEntry.getViewId())) {
            if (!this.parentViewsHistoryQueue.isEmpty()) {
                this.parentViewsHistoryQueue.remove(0);
            }
            this.parentViewsHistoryQueue.add(0, viewEntry);
        }
    }

    private final void purgeHistory() {
        ViewEntry viewEntry = (ViewEntry) this.parentViewsHistoryQueue.peekLast();
        while (viewEntry != null && System.currentTimeMillis() - viewEntry.getTimestamp() > this.entriesTtlLimitInMs) {
            this.parentViewsHistoryQueue.remove(viewEntry);
            viewEntry = (ViewEntry) this.parentViewsHistoryQueue.peekLast();
        }
        while (this.parentViewsHistoryQueue.size() > 30) {
            LinkedList linkedList = this.parentViewsHistoryQueue;
            linkedList.remove(linkedList.size() - 1);
        }
    }

    public static final class ViewEntry {
        private final boolean hasReplay;
        private final long timestamp;
        private final String viewId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewEntry)) {
                return false;
            }
            ViewEntry viewEntry = (ViewEntry) obj;
            return Intrinsics.areEqual(this.viewId, viewEntry.viewId) && this.timestamp == viewEntry.timestamp && this.hasReplay == viewEntry.hasReplay;
        }

        public int hashCode() {
            return (((this.viewId.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.hasReplay);
        }

        public String toString() {
            return "ViewEntry(viewId=" + this.viewId + ", timestamp=" + this.timestamp + ", hasReplay=" + this.hasReplay + ")";
        }

        public ViewEntry(String viewId, long j, boolean z) {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            this.viewId = viewId;
            this.timestamp = j;
            this.hasReplay = z;
        }

        public final String getViewId() {
            return this.viewId;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final boolean getHasReplay() {
            return this.hasReplay;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
