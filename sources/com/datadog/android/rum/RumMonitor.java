package com.datadog.android.rum;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface RumMonitor {
    /* synthetic */ _RumInternalProxy _getInternal();

    void addAction(RumActionType rumActionType, String str, Map map);

    void addAttribute(String str, Object obj);

    void addError(String str, RumErrorSource rumErrorSource, Throwable th, Map map);

    void addErrorWithStacktrace(String str, RumErrorSource rumErrorSource, String str2, Map map);

    void addFeatureFlagEvaluation(String str, Object obj);

    void addTiming(String str);

    void addViewLoadingTime(boolean z);

    Map getAttributes();

    void getCurrentSessionId(Function1 function1);

    void startAction(RumActionType rumActionType, String str, Map map);

    void startResource(String str, RumResourceMethod rumResourceMethod, String str2, Map map);

    void startView(Object obj, String str, Map map);

    void stopAction(RumActionType rumActionType, String str, Map map);

    void stopResource(String str, Integer num, Long l, RumResourceKind rumResourceKind, Map map);

    void stopSession();

    void stopView(Object obj, Map map);

    public static final class DefaultImpls {
        public static /* synthetic */ void stopView$default(RumMonitor rumMonitor, Object obj, Map map, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopView");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            rumMonitor.stopView(obj, map);
        }
    }
}
