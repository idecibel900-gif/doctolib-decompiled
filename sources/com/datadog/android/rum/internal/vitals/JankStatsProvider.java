package com.datadog.android.rum.internal.vitals;

import android.view.Window;
import androidx.metrics.performance.JankStats;
import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface JankStatsProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    JankStats createJankStatsAndTrack(Window window, JankStats.OnFrameListener onFrameListener, InternalLogger internalLogger);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final JankStatsProvider DEFAULT = new JankStatsProvider() { // from class: com.datadog.android.rum.internal.vitals.JankStatsProvider$Companion$DEFAULT$1
            @Override // com.datadog.android.rum.internal.vitals.JankStatsProvider
            public JankStats createJankStatsAndTrack(Window window, JankStats.OnFrameListener listener, InternalLogger internalLogger) {
                Intrinsics.checkNotNullParameter(window, "window");
                Intrinsics.checkNotNullParameter(listener, "listener");
                Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
                try {
                    return JankStats.Companion.createAndTrack(window, listener);
                } catch (IllegalStateException e) {
                    InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.vitals.JankStatsProvider$Companion$DEFAULT$1$createJankStatsAndTrack$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Unable to attach JankStats to the current window";
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                    return null;
                }
            }
        };

        private Companion() {
        }

        public final JankStatsProvider getDEFAULT() {
            return DEFAULT;
        }
    }
}
