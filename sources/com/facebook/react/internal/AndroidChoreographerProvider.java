package com.facebook.react.internal;

import android.view.Choreographer;
import com.facebook.react.bridge.UiThreadUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidChoreographerProvider implements ChoreographerProvider {
    public static final AndroidChoreographerProvider INSTANCE = new AndroidChoreographerProvider();

    private AndroidChoreographerProvider() {
    }

    private static final class AndroidChoreographer implements ChoreographerProvider.Choreographer {
        private final Choreographer instance;

        public AndroidChoreographer() {
            Choreographer choreographer = Choreographer.getInstance();
            Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance(...)");
            this.instance = choreographer;
        }

        @Override // com.facebook.react.internal.ChoreographerProvider.Choreographer
        public void postFrameCallback(Choreographer.FrameCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.instance.postFrameCallback(callback);
        }

        @Override // com.facebook.react.internal.ChoreographerProvider.Choreographer
        public void removeFrameCallback(Choreographer.FrameCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.instance.removeFrameCallback(callback);
        }
    }

    public static final AndroidChoreographerProvider getInstance() {
        return INSTANCE;
    }

    @Override // com.facebook.react.internal.ChoreographerProvider
    public ChoreographerProvider.Choreographer getChoreographer() {
        UiThreadUtil.assertOnUiThread();
        return new AndroidChoreographer();
    }
}
