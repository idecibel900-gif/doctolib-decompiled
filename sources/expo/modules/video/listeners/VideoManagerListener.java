package expo.modules.video.listeners;

import expo.modules.video.VideoView;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public interface VideoManagerListener {

    public static final class DefaultImpls {
        public static void onAppBackgrounded(VideoManagerListener videoManagerListener) {
        }

        public static void onVideoViewRegistered(VideoManagerListener videoManagerListener, VideoView videoView, Collection allVideoViews) {
            Intrinsics.checkNotNullParameter(videoView, "videoView");
            Intrinsics.checkNotNullParameter(allVideoViews, "allVideoViews");
        }

        public static void onVideoViewUnregistered(VideoManagerListener videoManagerListener, VideoView videoView, Collection allVideoViews) {
            Intrinsics.checkNotNullParameter(videoView, "videoView");
            Intrinsics.checkNotNullParameter(allVideoViews, "allVideoViews");
        }
    }

    void onAppBackgrounded();

    void onAppForegrounded();

    void onVideoViewRegistered(VideoView videoView, Collection collection);

    void onVideoViewUnregistered(VideoView videoView, Collection collection);
}
