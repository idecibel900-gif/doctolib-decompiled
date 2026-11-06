package androidx.compose.ui.text.googlefonts;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerHelper {
    public static final HandlerHelper INSTANCE = new HandlerHelper();

    private HandlerHelper() {
    }

    public final Handler createAsync(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler28Impl.INSTANCE.createAsync(looper);
        }
        return new Handler(looper);
    }

    public static final class Handler28Impl {
        public static final Handler28Impl INSTANCE = new Handler28Impl();

        private Handler28Impl() {
        }

        public final Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
