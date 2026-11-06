package expo.modules.video.playbackService;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$AppContextLost;
import expo.modules.video.VideoExceptionsKt;
import expo.modules.video.player.VideoPlayer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class PlaybackServiceConnection implements ServiceConnection {
    private final WeakReference _appContext;
    private boolean isConnected;
    private final WeakReference player;

    public final PlaybackServiceBinder getPlaybackServiceBinder() {
        return null;
    }

    public PlaybackServiceConnection(WeakReference player, AppContext appContext) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.player = player;
        this._appContext = new WeakReference(appContext);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    private final AppContext getAppContext() throws Exceptions$AppContextLost {
        AppContext appContext = (AppContext) this._appContext.get();
        if (appContext != null) {
            return appContext;
        }
        throw new Exceptions$AppContextLost();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder binder) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(binder, "binder");
        if (((VideoPlayer) this.player.get()) == null) {
            return;
        }
        if (binder instanceof PlaybackServiceBinder) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(binder);
        }
        Logger jsLogger = getAppContext().getJsLogger();
        if (jsLogger != null) {
            Logger.error$default(jsLogger, VideoExceptionsKt.getPlaybackServiceErrorMessage$default("Expo-video could not bind to the playback service", null, 2, null), null, 2, null);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        this.isConnected = false;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.isConnected = false;
        Logger jsLogger = getAppContext().getJsLogger();
        if (jsLogger != null) {
            Logger.error$default(jsLogger, VideoExceptionsKt.getPlaybackServiceErrorMessage("Expo-video has lost connection to the playback service binder", "This will cause issues with now playing notification and sustaining background playback."), null, 2, null);
        }
        super.onBindingDied(componentName);
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        this.isConnected = false;
        Logger jsLogger = getAppContext().getJsLogger();
        if (jsLogger != null) {
            Logger.error$default(jsLogger, VideoExceptionsKt.getPlaybackServiceErrorMessage$default("Expo Video could not bind to the playback service", null, 2, null), null, 2, null);
        }
        super.onNullBinding(componentName);
    }
}
