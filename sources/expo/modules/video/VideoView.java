package expo.modules.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.CaptioningManager;
import android.widget.ImageButton;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.R$drawable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$MissingActivity;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import expo.modules.video.delegates.IgnoreSameSet;
import expo.modules.video.enums.AudioMixingMode;
import expo.modules.video.enums.ContentFit;
import expo.modules.video.enums.PlayerStatus;
import expo.modules.video.listeners.VideoPlayerListener;
import expo.modules.video.listeners.VideoViewListener;
import expo.modules.video.managers.PictureInPictureManagerKt;
import expo.modules.video.managers.VideoManager;
import expo.modules.video.player.FirstFrameEventGenerator;
import expo.modules.video.player.VideoPlayer;
import expo.modules.video.records.AudioTrack;
import expo.modules.video.records.ButtonOptions;
import expo.modules.video.records.FullscreenOptions;
import expo.modules.video.records.PiPParams;
import expo.modules.video.records.PlaybackError;
import expo.modules.video.records.SubtitleTrack;
import expo.modules.video.records.TimeUpdate;
import expo.modules.video.records.VideoSource;
import expo.modules.video.records.VideoTrack;
import expo.modules.video.utils.EventDispatcherUtilsKt;
import expo.modules.video.utils.PictureInPictureUtilsKt;
import expo.modules.video.utils.SubtitleUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 °\u00012\u00020\u00012\u00020\u0002:\u0002°\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010{\u001a\u00020\u0015J\u0006\u0010|\u001a\u00020\u0015J\u0006\u0010}\u001a\u00020\u0015J\u0006\u0010~\u001a\u00020\u0015J\u0006\u0010\u007f\u001a\u00020\u0015J\u0012\u0010\u0080\u0001\u001a\u00020\u00152\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0000J\u0012\u0010\u0082\u0001\u001a\u00020\u00152\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u0083\u0001\u001a\u00020\u00152\u0007\u0010\u0084\u0001\u001a\u00020=J\u0010\u0010\u0085\u0001\u001a\u00020\u00152\u0007\u0010\u0084\u0001\u001a\u00020=Jc\u0010\u0086\u0001\u001a\u00020\u00152\u0007\u0010\u0087\u0001\u001a\u00020g2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u000f\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u00012\u000f\u0010\u008f\u0001\u001a\n\u0012\u0005\u0012\u00030\u0090\u00010\u008d\u00012\u000f\u0010\u0091\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u008d\u0001H\u0016¢\u0006\u0003\u0010\u0093\u0001J,\u0010\u0094\u0001\u001a\u00020\u00152\u0007\u0010\u0087\u0001\u001a\u00020g2\u0007\u0010\u0095\u0001\u001a\u00020\b2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0003\u0010\u0097\u0001J\u001c\u0010\u0098\u0001\u001a\u00020\u00152\u0007\u0010\u0087\u0001\u001a\u00020g2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0016J\u0012\u0010\u009b\u0001\u001a\u00020\u00152\u0007\u0010\u0087\u0001\u001a\u00020gH\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0015H\u0016J:\u0010\u009d\u0001\u001a\u00020\u00152\u0007\u0010\u009e\u0001\u001a\u00020\b2\b\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030 \u00012\b\u0010¢\u0001\u001a\u00030 \u00012\b\u0010£\u0001\u001a\u00030 \u0001H\u0014J\t\u0010¤\u0001\u001a\u00020\u0015H\u0014J\u001c\u0010¥\u0001\u001a\u00020\u00152\u0007\u0010¦\u0001\u001a\u00020A2\b\u0010§\u0001\u001a\u00030 \u0001H\u0014J\t\u0010¨\u0001\u001a\u00020\u0015H\u0014J\u0015\u0010©\u0001\u001a\u00020\b2\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\u0015\u0010¬\u0001\u001a\u00020\b2\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\u0012\u0010\u00ad\u0001\u001a\u00030 \u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002J\t\u0010®\u0001\u001a\u00020\u0015H\u0002J\t\u0010¯\u0001\u001a\u00020\u0015H\u0002R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001e\u0010\u0017R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b!\u0010\u0017R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b$\u0010\u0017R\u001a\u0010&\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u001e\u0010-\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u001e\u0010/\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R$\u00101\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R$\u00105\u001a\u0002042\u0006\u0010+\u001a\u000204@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010L\u001a\u00020K2\u0006\u0010J\u001a\u00020K8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010S\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010(\"\u0004\bU\u0010*R*\u0010V\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR+\u0010\\\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010R\u001a\u0004\b]\u0010(\"\u0004\b^\u0010*R$\u0010a\u001a\u00020`2\u0006\u0010+\u001a\u00020`@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR(\u0010h\u001a\u0004\u0018\u00010g2\b\u0010f\u001a\u0004\u0018\u00010g@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010m\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010(\"\u0004\bo\u0010*R$\u0010p\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010(\"\u0004\br\u0010*R$\u0010t\u001a\u00020s2\u0006\u0010+\u001a\u00020s@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u000e\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006±\u0001"}, d2 = {"Lexpo/modules/video/VideoView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/video/listeners/VideoPlayerListener;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "useTextureView", "", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;Z)V", "videoViewId", "", "getVideoViewId", "()Ljava/lang/String;", "playerView", "Landroidx/media3/ui/PlayerView;", "getPlayerView", "()Landroidx/media3/ui/PlayerView;", "onPictureInPictureStart", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "getOnPictureInPictureStart", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onPictureInPictureStart$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onPictureInPictureStop", "getOnPictureInPictureStop", "onPictureInPictureStop$delegate", "onFullscreenEnter", "getOnFullscreenEnter", "onFullscreenEnter$delegate", "onFullscreenExit", "getOnFullscreenExit", "onFullscreenExit$delegate", "onFirstFrameRender", "getOnFirstFrameRender", "onFirstFrameRender$delegate", "wasAutoPaused", "getWasAutoPaused", "()Z", "setWasAutoPaused", "(Z)V", "value", "isInFullscreen", "currentTrackHasSubtitles", "getCurrentTrackHasSubtitles", "showsAudioTracksButton", "getShowsAudioTracksButton", "requiresLinearPlayback", "getRequiresLinearPlayback", "setRequiresLinearPlayback", "Lexpo/modules/video/records/ButtonOptions;", "buttonOptions", "getButtonOptions", "()Lexpo/modules/video/records/ButtonOptions;", "setButtonOptions", "(Lexpo/modules/video/records/ButtonOptions;)V", "listeners", "", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/video/listeners/VideoViewListener;", "currentActivity", "Landroid/app/Activity;", "decorView", "Landroid/view/View;", "touchEventCoalescingKeyHelper", "Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;", "reactNativeEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "captioningChangeListener", "Landroid/view/accessibility/CaptioningManager$CaptioningChangeListener;", "windowFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "<set-?>", "Lexpo/modules/video/records/PiPParams;", "pipParams", "getPipParams", "()Lexpo/modules/video/records/PiPParams;", "setPipParams", "(Lexpo/modules/video/records/PiPParams;)V", "pipParams$delegate", "Lexpo/modules/video/delegates/IgnoreSameSet;", "shouldHideSurfaceView", "getShouldHideSurfaceView", "setShouldHideSurfaceView", "useExoShutter", "getUseExoShutter", "()Ljava/lang/Boolean;", "setUseExoShutter", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "autoEnterPiP", "getAutoEnterPiP", "setAutoEnterPiP", "autoEnterPiP$delegate", "Lexpo/modules/video/enums/ContentFit;", "contentFit", "getContentFit", "()Lexpo/modules/video/enums/ContentFit;", "setContentFit", "(Lexpo/modules/video/enums/ContentFit;)V", "newPlayer", "Lexpo/modules/video/player/VideoPlayer;", "videoPlayer", "getVideoPlayer", "()Lexpo/modules/video/player/VideoPlayer;", "setVideoPlayer", "(Lexpo/modules/video/player/VideoPlayer;)V", "useNativeControls", "getUseNativeControls", "setUseNativeControls", "allowsFullscreen", "getAllowsFullscreen", "setAllowsFullscreen", "Lexpo/modules/video/records/FullscreenOptions;", "fullscreenOptions", "getFullscreenOptions", "()Lexpo/modules/video/records/FullscreenOptions;", "setFullscreenOptions", "(Lexpo/modules/video/records/FullscreenOptions;)V", "mLayoutRunnable", "Ljava/lang/Runnable;", "applySurfaceViewVisibility", "enterFullscreen", "attachPlayer", "exitFullscreen", "enterPictureInPicture", "onStartPictureInPicture", "pipCandidate", "onStopPictureInPicture", "addVideoViewListener", "listener", "removeVideoViewListener", "onVideoSourceLoaded", "player", "videoSource", "Lexpo/modules/video/records/VideoSource;", "duration", "", "availableVideoTracks", "", "Lexpo/modules/video/records/VideoTrack;", "availableSubtitleTracks", "Lexpo/modules/video/records/SubtitleTrack;", "availableAudioTracks", "Lexpo/modules/video/records/AudioTrack;", "(Lexpo/modules/video/player/VideoPlayer;Lexpo/modules/video/records/VideoSource;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "onIsPlayingChanged", "isPlaying", "oldIsPlaying", "(Lexpo/modules/video/player/VideoPlayer;ZLjava/lang/Boolean;)V", "onTracksChanged", "tracks", "Landroidx/media3/common/Tracks;", "onRenderedFirstFrame", "requestLayout", "onLayout", "changed", "l", "", "t", "r", "b", "onAttachedToWindow", "onVisibilityChanged", "changedView", "visibility", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "getPlayerViewLayoutId", "setupCaptioningChangeListener", "applyButtonSettings", "Companion", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class VideoView extends ExpoView implements VideoPlayerListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(VideoView.class, "onPictureInPictureStart", "getOnPictureInPictureStart()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(VideoView.class, "onPictureInPictureStop", "getOnPictureInPictureStop()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(VideoView.class, "onFullscreenEnter", "getOnFullscreenEnter()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(VideoView.class, "onFullscreenExit", "getOnFullscreenExit()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(VideoView.class, "onFirstFrameRender", "getOnFirstFrameRender()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoView.class, "pipParams", "getPipParams()Lexpo/modules/video/records/PiPParams;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoView.class, "autoEnterPiP", "getAutoEnterPiP()Z", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean allowsFullscreen;

    /* JADX INFO: renamed from: autoEnterPiP$delegate, reason: from kotlin metadata */
    private final IgnoreSameSet autoEnterPiP;
    private ButtonOptions buttonOptions;
    private CaptioningManager.CaptioningChangeListener captioningChangeListener;
    private ContentFit contentFit;
    private final Activity currentActivity;
    private boolean currentTrackHasSubtitles;
    private final View decorView;
    private FullscreenOptions fullscreenOptions;
    private boolean isInFullscreen;
    private List<WeakReference<VideoViewListener>> listeners;
    private final Runnable mLayoutRunnable;

    /* JADX INFO: renamed from: onFirstFrameRender$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onFirstFrameRender;

    /* JADX INFO: renamed from: onFullscreenEnter$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onFullscreenEnter;

    /* JADX INFO: renamed from: onFullscreenExit$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onFullscreenExit;

    /* JADX INFO: renamed from: onPictureInPictureStart$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onPictureInPictureStart;

    /* JADX INFO: renamed from: onPictureInPictureStop$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onPictureInPictureStop;

    /* JADX INFO: renamed from: pipParams$delegate, reason: from kotlin metadata */
    private final IgnoreSameSet pipParams;
    private final PlayerView playerView;
    private EventDispatcher reactNativeEventDispatcher;
    private boolean requiresLinearPlayback;
    private boolean shouldHideSurfaceView;
    private boolean showsAudioTracksButton;
    private final TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper;
    private Boolean useExoShutter;
    private boolean useNativeControls;
    private VideoPlayer videoPlayer;
    private final String videoViewId;
    private boolean wasAutoPaused;
    private final View.OnFocusChangeListener windowFocusChangeListener;

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onAudioMixingModeChanged(VideoPlayer videoPlayer, AudioMixingMode audioMixingMode, AudioMixingMode audioMixingMode2) {
        VideoPlayerListener.DefaultImpls.onAudioMixingModeChanged(this, videoPlayer, audioMixingMode, audioMixingMode2);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onMutedChanged(VideoPlayer videoPlayer, boolean z, Boolean bool) {
        VideoPlayerListener.DefaultImpls.onMutedChanged(this, videoPlayer, z, bool);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onPlaybackRateChanged(VideoPlayer videoPlayer, float f, Float f2) {
        VideoPlayerListener.DefaultImpls.onPlaybackRateChanged(this, videoPlayer, f, f2);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onPlayedToEnd(VideoPlayer videoPlayer) {
        VideoPlayerListener.DefaultImpls.onPlayedToEnd(this, videoPlayer);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onSourceChanged(VideoPlayer videoPlayer, VideoSource videoSource, VideoSource videoSource2) {
        VideoPlayerListener.DefaultImpls.onSourceChanged(this, videoPlayer, videoSource, videoSource2);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onStatusChanged(VideoPlayer videoPlayer, PlayerStatus playerStatus, PlayerStatus playerStatus2, PlaybackError playbackError) {
        VideoPlayerListener.DefaultImpls.onStatusChanged(this, videoPlayer, playerStatus, playerStatus2, playbackError);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onTargetViewChanged(VideoPlayer videoPlayer, VideoView videoView, VideoView videoView2) {
        VideoPlayerListener.DefaultImpls.onTargetViewChanged(this, videoPlayer, videoView, videoView2);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onTimeUpdate(VideoPlayer videoPlayer, TimeUpdate timeUpdate) {
        VideoPlayerListener.DefaultImpls.onTimeUpdate(this, videoPlayer, timeUpdate);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onTrackSelectionParametersChanged(VideoPlayer videoPlayer, TrackSelectionParameters trackSelectionParameters) {
        VideoPlayerListener.DefaultImpls.onTrackSelectionParametersChanged(this, videoPlayer, trackSelectionParameters);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onVideoTrackChanged(VideoPlayer videoPlayer, VideoTrack videoTrack, VideoTrack videoTrack2) {
        VideoPlayerListener.DefaultImpls.onVideoTrackChanged(this, videoPlayer, videoTrack, videoTrack2);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onVolumeChanged(VideoPlayer videoPlayer, float f, Float f2) {
        VideoPlayerListener.DefaultImpls.onVolumeChanged(this, videoPlayer, f, f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoView(final Context context, AppContext appContext, boolean z) throws Exceptions$MissingActivity {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.videoViewId = string;
        View viewInflate = LayoutInflater.from(context.getApplicationContext()).inflate(getPlayerViewLayoutId(z), (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.media3.ui.PlayerView");
        PlayerView playerView = (PlayerView) viewInflate;
        this.playerView = playerView;
        this.onPictureInPictureStart = new ViewEventDelegate(this, null);
        this.onPictureInPictureStop = new ViewEventDelegate(this, null);
        this.onFullscreenEnter = new ViewEventDelegate(this, null);
        this.onFullscreenExit = new ViewEventDelegate(this, null);
        this.onFirstFrameRender = new ViewEventDelegate(this, null);
        this.buttonOptions = new ButtonOptions(false, false, false, false, null, false, false, false, 255, null);
        this.listeners = new ArrayList();
        Activity throwingActivity = appContext.getThrowingActivity();
        this.currentActivity = throwingActivity;
        View decorView = throwingActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        this.decorView = decorView;
        this.touchEventCoalescingKeyHelper = new TouchEventCoalescingKeyHelper();
        this.windowFocusChangeListener = new View.OnFocusChangeListener() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                VideoView.windowFocusChangeListener$lambda$0(this.f$0, context, view, z2);
            }
        };
        this.pipParams = new IgnoreSameSet(new PiPParams(false, false, false, false, null, null, 63, null), null, new Function2() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoView.pipParams_delegate$lambda$2(this.f$0, (PiPParams) obj, (PiPParams) obj2);
            }
        }, 2, null);
        this.shouldHideSurfaceView = true;
        this.autoEnterPiP = new IgnoreSameSet(Boolean.FALSE, null, new Function2() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoView.autoEnterPiP_delegate$lambda$3(this.f$0, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            }
        }, 2, null);
        this.contentFit = ContentFit.CONTAIN;
        this.useNativeControls = true;
        this.allowsFullscreen = true;
        this.fullscreenOptions = new FullscreenOptions(false, null, false, 7, null);
        this.mLayoutRunnable = new Runnable() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                VideoView.mLayoutRunnable$lambda$8(this.f$0);
            }
        };
        VideoManager.INSTANCE.registerVideoView(this);
        playerView.setFullscreenButtonClickListener(new PlayerView.FullscreenButtonClickListener() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda5
            @Override // androidx.media3.ui.PlayerView.FullscreenButtonClickListener
            public final void onFullscreenButtonClick(boolean z2) {
                this.f$0.enterFullscreen();
            }
        });
        playerView.setUseController(false);
        playerView.setShutterBackgroundColor(0);
        View videoSurfaceView = playerView.getVideoSurfaceView();
        if (videoSurfaceView != null) {
            videoSurfaceView.setAlpha(0.0f);
        }
        SubtitleUtils.INSTANCE.configureSubtitleView(playerView, context);
        addView(playerView, new ViewGroup.LayoutParams(-1, -1));
        Context reactContext = appContext.getReactContext();
        Intrinsics.checkNotNull(reactContext, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        this.reactNativeEventDispatcher = UIManagerHelper.getEventDispatcher((ReactContext) reactContext, getId());
    }

    public /* synthetic */ VideoView(Context context, AppContext appContext, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, appContext, (i & 4) != 0 ? false : z);
    }

    public final String getVideoViewId() {
        return this.videoViewId;
    }

    public final PlayerView getPlayerView() {
        return this.playerView;
    }

    public final ViewEventCallback getOnPictureInPictureStart() {
        return this.onPictureInPictureStart.getValue(this, $$delegatedProperties[0]);
    }

    public final ViewEventCallback getOnPictureInPictureStop() {
        return this.onPictureInPictureStop.getValue(this, $$delegatedProperties[1]);
    }

    public final ViewEventCallback getOnFullscreenEnter() {
        return this.onFullscreenEnter.getValue(this, $$delegatedProperties[2]);
    }

    public final ViewEventCallback getOnFullscreenExit() {
        return this.onFullscreenExit.getValue(this, $$delegatedProperties[3]);
    }

    public final ViewEventCallback getOnFirstFrameRender() {
        return this.onFirstFrameRender.getValue(this, $$delegatedProperties[4]);
    }

    public final boolean getWasAutoPaused() {
        return this.wasAutoPaused;
    }

    public final void setWasAutoPaused(boolean z) {
        this.wasAutoPaused = z;
    }

    /* JADX INFO: renamed from: isInFullscreen, reason: from getter */
    public final boolean getIsInFullscreen() {
        return this.isInFullscreen;
    }

    public final boolean getCurrentTrackHasSubtitles() {
        return this.currentTrackHasSubtitles;
    }

    public final boolean getShowsAudioTracksButton() {
        return this.showsAudioTracksButton;
    }

    public final boolean getRequiresLinearPlayback() {
        return this.requiresLinearPlayback;
    }

    public final void setRequiresLinearPlayback(boolean z) {
        this.requiresLinearPlayback = z;
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.setRequiresLinearPlayback(z);
        }
        PlayerViewExtensionKt.applyRequiresLinearPlayback(this.playerView, z);
        applyButtonSettings();
    }

    public final ButtonOptions getButtonOptions() {
        return this.buttonOptions;
    }

    public final void setButtonOptions(ButtonOptions value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.buttonOptions = value;
        applyButtonSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void windowFocusChangeListener$lambda$0(VideoView videoView, Context context, View view, boolean z) {
        if (z) {
            SubtitleUtils.INSTANCE.configureSubtitleView(videoView.playerView, context);
        }
    }

    private final void setPipParams(PiPParams piPParams) {
        this.pipParams.setValue(this, $$delegatedProperties[5], piPParams);
    }

    public final PiPParams getPipParams() {
        return (PiPParams) this.pipParams.getValue(this, $$delegatedProperties[5]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pipParams_delegate$lambda$2(VideoView videoView, PiPParams piPParams, PiPParams old) {
        Intrinsics.checkNotNullParameter(piPParams, "new");
        Intrinsics.checkNotNullParameter(old, "old");
        Iterator<T> it = videoView.listeners.iterator();
        while (it.hasNext()) {
            VideoViewListener videoViewListener = (VideoViewListener) ((WeakReference) it.next()).get();
            if (videoViewListener != null) {
                videoViewListener.onPiPParamsChanged(videoView, old, piPParams);
            }
        }
        return Unit.INSTANCE;
    }

    public final boolean getShouldHideSurfaceView() {
        return this.shouldHideSurfaceView;
    }

    public final void setShouldHideSurfaceView(boolean z) {
        this.shouldHideSurfaceView = z;
    }

    public final Boolean getUseExoShutter() {
        return this.useExoShutter;
    }

    public final void setUseExoShutter(Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            this.playerView.setShutterBackgroundColor(-16777216);
        } else {
            this.playerView.setShutterBackgroundColor(0);
        }
        applySurfaceViewVisibility();
        this.useExoShutter = bool;
    }

    public final boolean getAutoEnterPiP() {
        return ((Boolean) this.autoEnterPiP.getValue(this, $$delegatedProperties[6])).booleanValue();
    }

    public final void setAutoEnterPiP(boolean z) {
        this.autoEnterPiP.setValue(this, $$delegatedProperties[6], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit autoEnterPiP_delegate$lambda$3(VideoView videoView, boolean z, boolean z2) {
        videoView.setPipParams(PiPParams.copy$default(videoView.getPipParams(), z, false, false, false, null, null, 62, null));
        return Unit.INSTANCE;
    }

    public final ContentFit getContentFit() {
        return this.contentFit;
    }

    public final void setContentFit(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.playerView.setResizeMode(value.toResizeMode());
        this.contentFit = value;
    }

    public final VideoPlayer getVideoPlayer() {
        return this.videoPlayer;
    }

    public final void setVideoPlayer(VideoPlayer videoPlayer) {
        FirstFrameEventGenerator firstFrameEventGenerator$expo_video_release;
        VideoPlayer videoPlayer2 = this.videoPlayer;
        if (videoPlayer2 != null) {
            VideoManager.INSTANCE.onVideoPlayerDetachedFromView(videoPlayer2, this);
        }
        VideoPlayer videoPlayer3 = this.videoPlayer;
        boolean hasSentFirstFrameForCurrentMediaItem$expo_video_release = (videoPlayer == null || (firstFrameEventGenerator$expo_video_release = videoPlayer.getFirstFrameEventGenerator()) == null) ? false : firstFrameEventGenerator$expo_video_release.getHasSentFirstFrameForCurrentMediaItem$expo_video_release();
        if (videoPlayer3 != null) {
            videoPlayer3.removeListener(this);
        }
        if (videoPlayer != null) {
            videoPlayer.addListener(this);
        }
        this.videoPlayer = videoPlayer;
        this.shouldHideSurfaceView = !hasSentFirstFrameForCurrentMediaItem$expo_video_release;
        applySurfaceViewVisibility();
        attachPlayer();
        if (videoPlayer != null) {
            VideoManager.INSTANCE.onVideoPlayerAttachedToView(videoPlayer, this);
        }
        if (Intrinsics.areEqual(videoPlayer3, videoPlayer) || videoPlayer3 == null) {
            return;
        }
        videoPlayer3.hasBeenDisconnectedFromVideoView();
    }

    public final boolean getUseNativeControls() {
        return this.useNativeControls;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    public final void setUseNativeControls(boolean z) {
        boolean z2;
        if (z) {
            Boolean showSubtitles = this.buttonOptions.getShowSubtitles();
            if (showSubtitles != null ? showSubtitles.booleanValue() : this.currentTrackHasSubtitles) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.playerView.setUseController(z);
        this.playerView.setShowSubtitleButton(z2);
        this.useNativeControls = z;
    }

    public final boolean getAllowsFullscreen() {
        return this.allowsFullscreen;
    }

    public final void setAllowsFullscreen(boolean z) {
        if (z) {
            this.playerView.setFullscreenButtonClickListener(new PlayerView.FullscreenButtonClickListener() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda0
                @Override // androidx.media3.ui.PlayerView.FullscreenButtonClickListener
                public final void onFullscreenButtonClick(boolean z2) {
                    this.f$0.enterFullscreen();
                }
            });
        } else {
            this.playerView.setFullscreenButtonClickListener(null);
            PlayerViewExtensionKt.setFullscreenButtonVisibility(this.playerView, false);
        }
        this.allowsFullscreen = z;
    }

    public final FullscreenOptions getFullscreenOptions() {
        return this.fullscreenOptions;
    }

    public final void setFullscreenOptions(FullscreenOptions value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.fullscreenOptions = value;
        if (value.getEnable()) {
            this.playerView.setFullscreenButtonClickListener(new PlayerView.FullscreenButtonClickListener() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda6
                @Override // androidx.media3.ui.PlayerView.FullscreenButtonClickListener
                public final void onFullscreenButtonClick(boolean z) {
                    this.f$0.enterFullscreen();
                }
            });
        } else {
            this.playerView.setFullscreenButtonClickListener(null);
            PlayerViewExtensionKt.setFullscreenButtonVisibility(this.playerView, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mLayoutRunnable$lambda$8(VideoView videoView) {
        videoView.measure(View.MeasureSpec.makeMeasureSpec(videoView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(videoView.getHeight(), 1073741824));
        videoView.layout(videoView.getLeft(), videoView.getTop(), videoView.getRight(), videoView.getBottom());
    }

    public final void applySurfaceViewVisibility() {
        if (!Intrinsics.areEqual(this.useExoShutter, Boolean.TRUE) && this.shouldHideSurfaceView) {
            View videoSurfaceView = this.playerView.getVideoSurfaceView();
            if (videoSurfaceView != null) {
                videoSurfaceView.setAlpha(0.0f);
                return;
            }
            return;
        }
        View videoSurfaceView2 = this.playerView.getVideoSurfaceView();
        if (videoSurfaceView2 != null) {
            videoSurfaceView2.setAlpha(1.0f);
        }
    }

    public final void enterFullscreen() {
        Intent intent = new Intent(getContext(), (Class<?>) FullscreenPlayerActivity.class);
        intent.putExtra("player_uuid", this.videoViewId);
        intent.putExtra("fullscreen_options", this.fullscreenOptions);
        this.isInFullscreen = true;
        this.currentActivity.startActivity(intent);
        if (Build.VERSION.SDK_INT >= 34) {
            this.currentActivity.overrideActivityTransition(0, 0, 0);
        } else {
            this.currentActivity.overridePendingTransition(0, 0);
        }
        getOnFullscreenEnter().invoke(Unit.INSTANCE);
        setPipParams(PiPParams.copy$default(getPipParams(), false, false, false, true, null, null, 55, null));
    }

    public final void attachPlayer() {
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.changeVideoView(this);
        }
    }

    public final void exitFullscreen() {
        View viewFindViewById = this.playerView.findViewById(androidx.media3.ui.R$id.exo_fullscreen);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((ImageButton) viewFindViewById).setImageResource(R$drawable.exo_icon_fullscreen_enter);
        attachPlayer();
        getOnFullscreenExit().invoke(Unit.INSTANCE);
        this.isInFullscreen = false;
        setPipParams(PiPParams.copy$default(getPipParams(), false, false, false, false, null, null, 55, null));
    }

    public final void enterPictureInPicture() throws PictureInPictureEnterException, PictureInPictureUnsupportedException {
        if (!INSTANCE.isPictureInPictureSupported(this.currentActivity)) {
            throw new PictureInPictureUnsupportedException();
        }
        if (this.playerView.getPlayer() == null) {
            throw new PictureInPictureEnterException("No player attached to the VideoView");
        }
        setPipParams(PiPParams.copy$default(getPipParams(), false, false, true, false, null, null, 59, null));
        VideoManager.INSTANCE.getPictureInPicture().enterPictureInPicture(this);
    }

    public final void onStartPictureInPicture(VideoView pipCandidate) {
        getOnPictureInPictureStart().invoke(Unit.INSTANCE);
    }

    public final void onStopPictureInPicture(VideoView pipCandidate) {
        setPipParams(PiPParams.copy$default(getPipParams(), false, false, false, false, null, null, 59, null));
        getOnPictureInPictureStop().invoke(Unit.INSTANCE);
    }

    public final void addVideoViewListener(VideoViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<WeakReference<VideoViewListener>> list = this.listeners;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), listener)) {
                    return;
                }
            }
        }
        this.listeners.add(new WeakReference<>(listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeVideoViewListener$lambda$11(VideoViewListener videoViewListener, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.get(), videoViewListener);
    }

    public final void removeVideoViewListener(final VideoViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CollectionsKt.retainAll((List) this.listeners, new Function1() { // from class: expo.modules.video.VideoView$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(VideoView.removeVideoViewListener$lambda$11(listener, (WeakReference) obj));
            }
        });
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onVideoSourceLoaded(VideoPlayer player, VideoSource videoSource, Double duration, List<VideoTrack> availableVideoTracks, List<SubtitleTrack> availableSubtitleTracks, List<AudioTrack> availableAudioTracks) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(availableVideoTracks, "availableVideoTracks");
        Intrinsics.checkNotNullParameter(availableSubtitleTracks, "availableSubtitleTracks");
        Intrinsics.checkNotNullParameter(availableAudioTracks, "availableAudioTracks");
        setPipParams(PiPParams.copy$default(getPipParams(), false, false, false, false, PictureInPictureManagerKt.calculateCurrentPipAspectRatio(this), null, 47, null));
        VideoPlayerListener.DefaultImpls.onVideoSourceLoaded(this, player, videoSource, duration, availableVideoTracks, availableSubtitleTracks, availableAudioTracks);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onIsPlayingChanged(VideoPlayer player, boolean isPlaying, Boolean oldIsPlaying) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (Intrinsics.areEqual(player, this.videoPlayer) && isPlaying) {
            this.wasAutoPaused = false;
        }
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onTracksChanged(VideoPlayer player, Tracks tracks) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        this.currentTrackHasSubtitles = !player.getSubtitles().getAvailableSubtitleTracks().isEmpty();
        this.showsAudioTracksButton = player.getAudioTracks().getAvailableAudioTracks().size() > 1;
        PlayerView playerView = this.playerView;
        Boolean showSubtitles = this.buttonOptions.getShowSubtitles();
        playerView.setShowSubtitleButton(showSubtitles != null ? showSubtitles.booleanValue() : this.currentTrackHasSubtitles);
        VideoPlayerListener.DefaultImpls.onTracksChanged(this, player, tracks);
    }

    @Override // expo.modules.video.listeners.VideoPlayerListener
    public void onRenderedFirstFrame(VideoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (Intrinsics.areEqual(player.getCurrentVideoView(), this)) {
            this.shouldHideSurfaceView = false;
            applySurfaceViewVisibility();
            getOnFirstFrameRender().invoke(Unit.INSTANCE);
        }
    }

    @Override // expo.modules.kotlin.views.ExpoView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.mLayoutRunnable);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        setPipParams(PiPParams.copy$default(getPipParams(), false, false, false, false, null, PictureInPictureUtilsKt.calculateRectHint(this.playerView), 31, null));
        PlayerView playerView = this.playerView;
        VideoPlayer videoPlayer = this.videoPlayer;
        PlayerViewExtensionKt.setTimeBarInteractive(playerView, videoPlayer != null ? videoPlayer.getRequiresLinearPlayback() : true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupCaptioningChangeListener();
        SubtitleUtils subtitleUtils = SubtitleUtils.INSTANCE;
        PlayerView playerView = this.playerView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        subtitleUtils.configureSubtitleView(playerView, context);
        this.decorView.setOnFocusChangeListener(this.windowFocusChangeListener);
        setPipParams(PiPParams.copy$default(getPipParams(), false, true, false, false, null, null, 61, null));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            SubtitleUtils subtitleUtils = SubtitleUtils.INSTANCE;
            PlayerView playerView = this.playerView;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            subtitleUtils.configureSubtitleView(playerView, context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CaptioningManager.CaptioningChangeListener captioningChangeListener = this.captioningChangeListener;
        if (captioningChangeListener != null) {
            Object systemService = getContext().getSystemService("captioning");
            CaptioningManager captioningManager = systemService instanceof CaptioningManager ? (CaptioningManager) systemService : null;
            if (captioningManager != null) {
                captioningManager.removeCaptioningChangeListener(captioningChangeListener);
            }
            this.captioningChangeListener = null;
        }
        this.decorView.setOnFocusChangeListener(null);
        setPipParams(PiPParams.copy$default(getPipParams(), false, false, false, false, null, null, 61, null));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.useNativeControls && event != null) {
            this.touchEventCoalescingKeyHelper.addCoalescingKey(event.getEventTime());
            EventDispatcher eventDispatcher = this.reactNativeEventDispatcher;
            if (eventDispatcher != null) {
                EventDispatcherUtilsKt.dispatchMotionEvent(eventDispatcher, this, event, this.touchEventCoalescingKeyHelper);
            }
        }
        if (event != null && event.getActionMasked() == 1) {
            performClick();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!this.useNativeControls || event == null) {
            return false;
        }
        this.touchEventCoalescingKeyHelper.addCoalescingKey(event.getEventTime());
        EventDispatcher eventDispatcher = this.reactNativeEventDispatcher;
        if (eventDispatcher == null) {
            return false;
        }
        EventDispatcherUtilsKt.dispatchMotionEvent(eventDispatcher, this, MotionEvent.obtainNoHistory(event), this.touchEventCoalescingKeyHelper);
        return false;
    }

    private final int getPlayerViewLayoutId(boolean useTextureView) {
        if (useTextureView) {
            return R$layout.texture_player_view;
        }
        return R$layout.surface_player_view;
    }

    private final void setupCaptioningChangeListener() {
        Object systemService = getContext().getSystemService("captioning");
        CaptioningManager captioningManager = systemService instanceof CaptioningManager ? (CaptioningManager) systemService : null;
        SubtitleUtils subtitleUtils = SubtitleUtils.INSTANCE;
        PlayerView playerView = this.playerView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CaptioningManager.CaptioningChangeListener captioningChangeListenerCreateCaptioningChangeListener = subtitleUtils.createCaptioningChangeListener(playerView, context);
        this.captioningChangeListener = captioningChangeListenerCreateCaptioningChangeListener;
        if (captioningChangeListenerCreateCaptioningChangeListener == null || captioningManager == null) {
            return;
        }
        captioningManager.addCaptioningChangeListener(captioningChangeListenerCreateCaptioningChangeListener);
    }

    private final void applyButtonSettings() {
        Boolean showSubtitles = this.buttonOptions.getShowSubtitles();
        boolean zBooleanValue = showSubtitles != null ? showSubtitles.booleanValue() : this.currentTrackHasSubtitles;
        PlayerViewExtensionKt.applyButtonOptions(this.playerView, this.buttonOptions, this.requiresLinearPlayback);
        this.playerView.setShowSubtitleButton(zBooleanValue);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPictureInPictureSupported(Activity currentActivity) {
            Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
            return Build.VERSION.SDK_INT >= 26 && currentActivity.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
        }
    }
}
