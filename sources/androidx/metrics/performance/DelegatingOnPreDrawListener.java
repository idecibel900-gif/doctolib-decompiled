package androidx.metrics.performance;

import android.app.Activity;
import android.content.Context;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Field;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class DelegatingOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
    public static final Companion Companion = new Companion(null);
    private static final Field choreographerLastFrameTimeField;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Field getChoreographerLastFrameTimeField() {
            return DelegatingOnPreDrawListener.choreographerLastFrameTimeField;
        }

        public final long getExpectedFrameDuration(View view) {
            JankStatsBaseImpl.Companion companion = JankStatsBaseImpl.Companion;
            if (companion.getFrameDuration() < 0) {
                Window window = null;
                if ((view != null ? view.getContext() : null) instanceof Activity) {
                    Context context = view.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    window = ((Activity) context).getWindow();
                }
                float f = 60.0f;
                float refreshRate = window != null ? window.getWindowManager().getDefaultDisplay().getRefreshRate() : 60.0f;
                if (refreshRate >= 30.0f && refreshRate <= 200.0f) {
                    f = refreshRate;
                }
                companion.setFrameDuration((long) ((1000 / f) * 1000000));
            }
            return companion.getFrameDuration();
        }
    }

    static {
        Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
        Intrinsics.checkNotNullExpressionValue(declaredField, "Choreographer::class.jav…ld(\"mLastFrameTimeNanos\")");
        choreographerLastFrameTimeField = declaredField;
        declaredField.setAccessible(true);
    }
}
