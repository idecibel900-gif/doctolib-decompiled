package expo.modules.video.playbackService;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.media3.session.MediaSessionService;
import expo.modules.kotlin.AppContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExpoVideoPlaybackService extends MediaSessionService {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean startService(AppContext appContext, Context context, PlaybackServiceConnection serviceConnection) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
            Context reactContext = appContext.getReactContext();
            if (reactContext == null) {
                return false;
            }
            Intent intent = new Intent(context, (Class<?>) ExpoVideoPlaybackService.class);
            intent.setAction("androidx.media3.session.MediaSessionService");
            reactContext.startService(intent);
            return reactContext.bindService(intent, serviceConnection, Build.VERSION.SDK_INT >= 29 ? 4097 : 1);
        }
    }
}
