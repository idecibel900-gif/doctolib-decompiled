package com.datadog.android.webview.internal.rum;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TimestampOffsetProvider {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;
    private final LinkedHashMap offsets;

    public TimestampOffsetProvider(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.offsets = new LinkedHashMap();
    }

    public final synchronized long getOffset$dd_sdk_android_webview_release(String viewId, DatadogContext datadogContext) {
        Long lValueOf;
        try {
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
            lValueOf = (Long) this.offsets.get(viewId);
            if (lValueOf == null) {
                lValueOf = Long.valueOf(datadogContext.getTime().getServerTimeOffsetMs());
                this.offsets.put(viewId, lValueOf);
            }
            purgeOffsets();
        } catch (Throwable th) {
            throw th;
        }
        return lValueOf.longValue();
    }

    private final void purgeOffsets() {
        while (this.offsets.entrySet().size() > 3) {
            try {
                Set setEntrySet = this.offsets.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "offsets.entries");
                Object objFirst = CollectionsKt.first(setEntrySet);
                Intrinsics.checkNotNullExpressionValue(objFirst, "offsets.entries.first()");
                this.offsets.remove(((Map.Entry) objFirst).getKey());
            } catch (NoSuchElementException e) {
                InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.webview.internal.rum.TimestampOffsetProvider.purgeOffsets.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Trying to remove offset from an empty map.";
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
                return;
            }
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
