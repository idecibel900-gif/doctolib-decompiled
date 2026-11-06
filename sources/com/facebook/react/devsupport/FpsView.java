package com.facebook.react.devsupport;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.R$layout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class FpsView extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private final FPSMonitorRunnable fpsMonitorRunnable;
    private final FpsDebugFrameCallback frameCallback;
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FpsView(ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNull(reactContext);
        View.inflate(reactContext, R$layout.fps_view, this);
        View viewFindViewById = findViewById(R$id.fps_text);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.textView = (TextView) viewFindViewById;
        FpsDebugFrameCallback fpsDebugFrameCallback = new FpsDebugFrameCallback(reactContext);
        this.frameCallback = fpsDebugFrameCallback;
        this.fpsMonitorRunnable = new FPSMonitorRunnable();
        setCurrentFPS(0.0d, 0.0d, 0, 0, fpsDebugFrameCallback.isRunningOnFabric());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.frameCallback.reset();
        FpsDebugFrameCallback.start$default(this.frameCallback, 0.0d, 1, null);
        this.fpsMonitorRunnable.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.frameCallback.stop();
        this.fpsMonitorRunnable.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentFPS(double d, double d2, int i, int i2, boolean z) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        String str = String.format(locale, "UI: %.1f fps\n%d dropped so far\n%d stutters (4+) so far", Arrays.copyOf(new Object[]{Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2)}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (!z) {
            String str2 = String.format(locale, "\nJS: %.1f fps", Arrays.copyOf(new Object[]{Double.valueOf(d2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            str = str + str2;
        }
        this.textView.setText(str);
        FLog.d("ReactNative", str);
    }

    private final class FPSMonitorRunnable implements Runnable {
        private boolean shouldStop;
        private int total4PlusFrameStutters;
        private int totalFramesDropped;

        public FPSMonitorRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.shouldStop) {
                return;
            }
            this.totalFramesDropped += FpsView.this.frameCallback.getExpectedNumFrames() - FpsView.this.frameCallback.getNumFrames();
            this.total4PlusFrameStutters += FpsView.this.frameCallback.get4PlusFrameStutters();
            FpsView fpsView = FpsView.this;
            fpsView.setCurrentFPS(fpsView.frameCallback.getFps(), FpsView.this.frameCallback.getJsFPS(), this.totalFramesDropped, this.total4PlusFrameStutters, FpsView.this.frameCallback.isRunningOnFabric());
            FpsView.this.frameCallback.reset();
            FpsView.this.postDelayed(this, 500L);
        }

        public final void start() {
            this.shouldStop = false;
            FpsView.this.post(this);
        }

        public final void stop() {
            this.shouldStop = true;
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
