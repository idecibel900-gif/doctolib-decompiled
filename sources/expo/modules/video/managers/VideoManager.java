package expo.modules.video.managers;

import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.video.FullscreenPlayerActivity;
import expo.modules.video.VideoCache;
import expo.modules.video.VideoView;
import expo.modules.video.VideoViewNotFoundException;
import expo.modules.video.listeners.VideoManagerListener;
import expo.modules.video.player.VideoPlayer;
import expo.modules.video.utils.WeakMutableSet;
import expo.modules.video.utils.WeakMutableSetKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class VideoManager {
    private static AudioFocusManager audioFocusManager;
    public static VideoCache cache;
    public static PictureInPictureManager pictureInPicture;
    public static final VideoManager INSTANCE = new VideoManager();
    private static WeakReference appContext = new WeakReference(null);
    private static Map videoViews = new LinkedHashMap();
    private static Map fullscreenPlayerActivities = new LinkedHashMap();
    private static Map videoPlayersToVideoViews = new LinkedHashMap();
    private static WeakMutableSet playersRequestingKeepAwake = WeakMutableSetKt.weakMutableHashSetOf();
    private static List listeners = new ArrayList();

    private VideoManager() {
    }

    public final PictureInPictureManager getPictureInPicture() {
        PictureInPictureManager pictureInPictureManager = pictureInPicture;
        if (pictureInPictureManager != null) {
            return pictureInPictureManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pictureInPicture");
        return null;
    }

    public final void setPictureInPicture(PictureInPictureManager pictureInPictureManager) {
        Intrinsics.checkNotNullParameter(pictureInPictureManager, "<set-?>");
        pictureInPicture = pictureInPictureManager;
    }

    public final VideoCache getCache() {
        VideoCache videoCache = cache;
        if (videoCache != null) {
            return videoCache;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cache");
        return null;
    }

    public final void setCache(VideoCache videoCache) {
        Intrinsics.checkNotNullParameter(videoCache, "<set-?>");
        cache = videoCache;
    }

    public final void onModuleCreated(AppContext appContext2) {
        Intrinsics.checkNotNullParameter(appContext2, "appContext");
        synchronized (this) {
            try {
                Context reactContext = appContext2.getReactContext();
                if (reactContext == null) {
                    throw new Exceptions$ReactContextLost();
                }
                VideoManager videoManager = INSTANCE;
                videoManager.setPictureInPicture(new PictureInPictureManager(appContext2));
                if (audioFocusManager == null) {
                    audioFocusManager = new AudioFocusManager(appContext2);
                }
                if (cache == null) {
                    videoManager.setCache(new VideoCache(reactContext));
                } else {
                    AppContext appContext3 = (AppContext) appContext.get();
                    if (!Intrinsics.areEqual(appContext3 != null ? appContext3.getReactContext() : null, appContext2.getReactContext())) {
                        videoManager.getCache().release();
                        videoManager.setCache(new VideoCache(reactContext));
                    }
                }
                appContext = new WeakReference(appContext2);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onModuleDestroyed(AppContext appContext2) {
        Intrinsics.checkNotNullParameter(appContext2, "appContext");
        getPictureInPicture().release();
        listeners.clear();
    }

    public final void registerListener(VideoManagerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(new WeakReference(listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unregisterListener$lambda$1(VideoManagerListener videoManagerListener, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.get(), videoManagerListener);
    }

    public final void unregisterListener(final VideoManagerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CollectionsKt.retainAll(listeners, new Function1() { // from class: expo.modules.video.managers.VideoManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(VideoManager.unregisterListener$lambda$1(listener, (WeakReference) obj));
            }
        });
    }

    public final void registerVideoView(VideoView videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoViews.put(videoView.getVideoViewId(), videoView);
        Iterator it = listeners.iterator();
        while (it.hasNext()) {
            VideoManagerListener videoManagerListener = (VideoManagerListener) ((WeakReference) it.next()).get();
            if (videoManagerListener != null) {
                videoManagerListener.onVideoViewRegistered(videoView, videoViews.values());
            }
        }
    }

    public final VideoView getVideoView(String id) throws VideoViewNotFoundException {
        Intrinsics.checkNotNullParameter(id, "id");
        VideoView videoView = (VideoView) videoViews.get(id);
        if (videoView != null) {
            return videoView;
        }
        throw new VideoViewNotFoundException(id);
    }

    public final void unregisterVideoView(VideoView videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoViews.remove(videoView.getVideoViewId());
        Iterator it = listeners.iterator();
        while (it.hasNext()) {
            VideoManagerListener videoManagerListener = (VideoManagerListener) ((WeakReference) it.next()).get();
            if (videoManagerListener != null) {
                videoManagerListener.onVideoViewUnregistered(videoView, videoViews.values());
            }
        }
    }

    public final void registerVideoPlayer(VideoPlayer videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Map map = videoPlayersToVideoViews;
        Collection arrayList = (List) map.get(videoPlayer);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        map.put(videoPlayer, arrayList);
        AudioFocusManager audioFocusManager2 = audioFocusManager;
        if (audioFocusManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioFocusManager");
            audioFocusManager2 = null;
        }
        audioFocusManager2.registerPlayer(videoPlayer);
    }

    public final void unregisterVideoPlayer(VideoPlayer videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        videoPlayersToVideoViews.remove(videoPlayer);
        AudioFocusManager audioFocusManager2 = audioFocusManager;
        if (audioFocusManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioFocusManager");
            audioFocusManager2 = null;
        }
        audioFocusManager2.unregisterPlayer(videoPlayer);
    }

    public final void registerFullscreenPlayerActivity(String id, FullscreenPlayerActivity fullscreenActivity) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fullscreenActivity, "fullscreenActivity");
        fullscreenPlayerActivities.put(id, new WeakReference(fullscreenActivity));
    }

    public final void unregisterFullscreenPlayerActivity(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        fullscreenPlayerActivities.remove(id);
    }

    public final void onVideoPlayerAttachedToView(VideoPlayer videoPlayer, VideoView videoView) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        List list = (List) videoPlayersToVideoViews.get(videoPlayer);
        if (list == null || !list.contains(videoView)) {
            List list2 = (List) videoPlayersToVideoViews.get(videoPlayer);
            if (list2 != null) {
                list2.add(videoView);
            } else {
                videoPlayersToVideoViews.put(videoPlayer, CollectionsKt.arrayListOf(videoView));
            }
            List list3 = (List) videoPlayersToVideoViews.get(videoPlayer);
            if (list3 == null || list3.size() != 1) {
                return;
            }
            videoPlayer.getServiceConnection().getPlaybackServiceBinder();
        }
    }

    public final void onVideoPlayerDetachedFromView(VideoPlayer videoPlayer, VideoView videoView) {
        List list;
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        List list2 = (List) videoPlayersToVideoViews.get(videoPlayer);
        if (list2 != null) {
            list2.remove(videoView);
        }
        if (videoPlayersToVideoViews.get(videoPlayer) == null || ((list = (List) videoPlayersToVideoViews.get(videoPlayer)) != null && list.size() == 0)) {
            videoPlayer.getServiceConnection().getPlaybackServiceBinder();
        }
    }

    public final void requestKeepAwake(VideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        playersRequestingKeepAwake.add(player);
        applyKeepAwake();
    }

    public final void releaseKeepAwake(VideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        playersRequestingKeepAwake.remove(player);
        applyKeepAwake();
    }

    public final boolean hasRegisteredPlayers() {
        return !videoPlayersToVideoViews.isEmpty();
    }

    public final void onAppForegrounded() {
        Iterator it = listeners.iterator();
        while (it.hasNext()) {
            VideoManagerListener videoManagerListener = (VideoManagerListener) ((WeakReference) it.next()).get();
            if (videoManagerListener != null) {
                videoManagerListener.onAppForegrounded();
            }
        }
    }

    public final void onAppBackgrounded() {
        for (VideoView videoView : videoViews.values()) {
            if (shouldPauseVideo(videoView)) {
                handleVideoPause(videoView);
            } else {
                videoView.setWasAutoPaused(false);
            }
        }
        Iterator it = listeners.iterator();
        while (it.hasNext()) {
            VideoManagerListener videoManagerListener = (VideoManagerListener) ((WeakReference) it.next()).get();
            if (videoManagerListener != null) {
                videoManagerListener.onAppBackgrounded();
            }
        }
    }

    private final void applyKeepAwake() {
        Iterator it = videoViews.values().iterator();
        while (it.hasNext()) {
            ((VideoView) it.next()).setKeepScreenOn(!playersRequestingKeepAwake.isEmpty());
        }
    }

    private final boolean shouldPauseVideo(VideoView videoView) {
        VideoPlayer videoPlayer = videoView.getVideoPlayer();
        return (videoPlayer == null || videoPlayer.getStaysActiveInBackground() || videoView.getPipParams().getAutoEnter() || videoView.getPipParams().getWillEnter() || videoView.getIsInFullscreen()) ? false : true;
    }

    private final void handleVideoPause(VideoView videoView) {
        ExoPlayer player;
        VideoPlayer videoPlayer = videoView.getVideoPlayer();
        if (videoPlayer == null || (player = videoPlayer.getPlayer()) == null || !player.isPlaying()) {
            return;
        }
        player.pause();
        videoView.setWasAutoPaused(true);
    }
}
