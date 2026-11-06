package io.sentry.react;

import android.app.Activity;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import io.sentry.ILogger;
import io.sentry.SentryDateProvider;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.SentryAndroidDateProvider;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import io.sentry.react.utils.RNSentryActivityUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class RNSentryOnDrawReporterManager extends SimpleViewManager<RNSentryOnDrawReporterView> {
    public static final String REACT_CLASS = "RNSentryOnDrawReporter";
    public static final String TTFD_PREFIX = "ttfd-";
    public static final String TTID_PREFIX = "ttid-";
    private final ReactApplicationContext mCallerContext;

    public RNSentryOnDrawReporterManager(ReactApplicationContext reactApplicationContext) {
        this.mCallerContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RNSentryOnDrawReporterView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNSentryOnDrawReporterView(this.mCallerContext, new BuildInfoProvider(new AndroidLogger()));
    }

    @ReactProp(defaultBoolean = false, name = "initialDisplay")
    public void setInitialDisplay(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, boolean z) {
        rNSentryOnDrawReporterView.setInitialDisplay(z);
    }

    @ReactProp(defaultBoolean = false, name = "fullDisplay")
    public void setFullDisplay(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, boolean z) {
        rNSentryOnDrawReporterView.setFullDisplay(z);
    }

    @ReactProp(name = "parentSpanId")
    public void setParentSpanId(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, String str) {
        rNSentryOnDrawReporterView.setParentSpanId(str);
    }

    public static class RNSentryOnDrawReporterView extends View {
        private static final ILogger logger = new AndroidLogger("RNSentryOnDrawReporterView");
        private final BuildInfoProvider buildInfo;
        private final SentryDateProvider dateProvider;
        private boolean isFullDisplay;
        private boolean isInitialDisplay;
        private String parentSpanId;
        private final ReactApplicationContext reactContext;
        private boolean spanIdUsed;

        public RNSentryOnDrawReporterView(ReactApplicationContext reactApplicationContext, BuildInfoProvider buildInfoProvider) {
            super(reactApplicationContext);
            this.dateProvider = new SentryAndroidDateProvider();
            this.isInitialDisplay = false;
            this.isFullDisplay = false;
            this.spanIdUsed = false;
            this.parentSpanId = null;
            this.reactContext = reactApplicationContext;
            this.buildInfo = buildInfoProvider;
        }

        public void setFullDisplay(boolean z) {
            if (z != this.isFullDisplay) {
                this.isFullDisplay = z;
                processPropsChanged();
            }
        }

        public void setInitialDisplay(boolean z) {
            if (z != this.isInitialDisplay) {
                this.isInitialDisplay = z;
                processPropsChanged();
            }
        }

        public void setParentSpanId(String str) {
            if (Objects.equals(str, this.parentSpanId)) {
                return;
            }
            this.parentSpanId = str;
            this.spanIdUsed = false;
            processPropsChanged();
        }

        private void processPropsChanged() {
            if (this.parentSpanId == null) {
                return;
            }
            if (this.spanIdUsed) {
                logger.log(SentryLevel.DEBUG, "[TimeToDisplay] Already recorded time to display for spanId: " + this.parentSpanId, new Object[0]);
                return;
            }
            if (this.isInitialDisplay) {
                logger.log(SentryLevel.DEBUG, "[TimeToDisplay] Register initial display event emitter.", new Object[0]);
            } else if (this.isFullDisplay) {
                logger.log(SentryLevel.DEBUG, "[TimeToDisplay] Register full display event emitter.", new Object[0]);
            } else {
                logger.log(SentryLevel.DEBUG, "[TimeToDisplay] Not ready, missing displayType prop.", new Object[0]);
                return;
            }
            if (this.buildInfo == null) {
                logger.log(SentryLevel.ERROR, "[TimeToDisplay] Won't emit next frame drawn event, buildInfo is null.", new Object[0]);
                return;
            }
            ReactApplicationContext reactApplicationContext = this.reactContext;
            if (reactApplicationContext == null) {
                logger.log(SentryLevel.ERROR, "[TimeToDisplay] Won't emit next frame drawn event, reactContext is null.", new Object[0]);
                return;
            }
            ILogger iLogger = logger;
            Activity currentActivity = RNSentryActivityUtils.getCurrentActivity(reactApplicationContext, iLogger);
            if (currentActivity == null) {
                iLogger.log(SentryLevel.ERROR, "[TimeToDisplay] Won't emit next frame drawn event, activity is null.", new Object[0]);
            } else {
                this.spanIdUsed = true;
                registerForNextDraw(currentActivity, new Runnable() { // from class: io.sentry.react.RNSentryOnDrawReporterManager$RNSentryOnDrawReporterView$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processPropsChanged$0();
                    }
                }, this.buildInfo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processPropsChanged$0() {
            Double dValueOf = Double.valueOf(this.dateProvider.now().nanoTimestamp() / 1.0E9d);
            if (this.parentSpanId == null) {
                logger.log(SentryLevel.ERROR, "[TimeToDisplay] parentSpanId removed before frame was rendered.", new Object[0]);
                return;
            }
            if (this.isInitialDisplay) {
                RNSentryTimeToDisplay.putTimeToDisplayFor(RNSentryOnDrawReporterManager.TTID_PREFIX + this.parentSpanId, dValueOf);
                return;
            }
            if (this.isFullDisplay) {
                RNSentryTimeToDisplay.putTimeToDisplayFor(RNSentryOnDrawReporterManager.TTFD_PREFIX + this.parentSpanId, dValueOf);
                return;
            }
            logger.log(SentryLevel.DEBUG, "[TimeToDisplay] display type removed before frame was rendered.", new Object[0]);
        }

        protected void registerForNextDraw(Activity activity, Runnable runnable, BuildInfoProvider buildInfoProvider) {
            FirstDrawDoneListener.registerForNextDraw(activity, runnable, buildInfoProvider);
        }
    }
}
