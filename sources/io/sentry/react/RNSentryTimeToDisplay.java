package io.sentry.react;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.facebook.react.bridge.Promise;
import io.sentry.SentryDateProvider;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RNSentryTimeToDisplay {
    private static final Map screenIdToRenderDuration = new LinkedHashMap(51, 0.75f, true) { // from class: io.sentry.react.RNSentryTimeToDisplay.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > 50;
        }
    };
    private static String activeSpanId = null;

    public static void setActiveSpanId(String str) {
        activeSpanId = str;
    }

    public static Double popTimeToDisplayFor(String str) {
        return (Double) screenIdToRenderDuration.remove(str);
    }

    public static void putTimeToInitialDisplayForActiveSpan(Double d) {
        if (activeSpanId != null) {
            putTimeToDisplayFor("ttid-navigation-" + activeSpanId, d);
        }
    }

    public static void putTimeToDisplayFor(String str, Double d) {
        screenIdToRenderDuration.put(str, d);
    }

    public static void getTimeToDisplay(final Promise promise, final SentryDateProvider sentryDateProvider) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            promise.reject("GetTimeToDisplay is not able to measure the time to display: Main looper not available.");
        } else {
            new Handler(mainLooper).post(new Runnable() { // from class: io.sentry.react.RNSentryTimeToDisplay$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RNSentryTimeToDisplay.$r8$lambda$FyrnRVp_IzyxAhxlC4NpFCfkiog(sentryDateProvider, promise);
                }
            });
        }
    }

    public static /* synthetic */ void $r8$lambda$FyrnRVp_IzyxAhxlC4NpFCfkiog(final SentryDateProvider sentryDateProvider, final Promise promise) {
        try {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: io.sentry.react.RNSentryTimeToDisplay$$ExternalSyntheticLambda1
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    promise.resolve(Double.valueOf(sentryDateProvider.now().nanoTimestamp() / 1.0E9d));
                }
            });
        } catch (Exception e) {
            promise.reject("Failed to receive the instance of Choreographer", e);
        }
    }
}
