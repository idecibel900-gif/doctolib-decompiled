package expo.modules.video.utils;

import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MediaSessionUtilsKt {
    public static final MediaSession buildBasicMediaSession(Context context, ExoPlayer player) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(player, "player");
        MediaSession mediaSessionBuild = new MediaSession.Builder(context, player).setId("ExpoVideoBasicMediaSession_" + player.hashCode()).build();
        Intrinsics.checkNotNullExpressionValue(mediaSessionBuild, "build(...)");
        return mediaSessionBuild;
    }
}
