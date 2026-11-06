package expo.modules.video.player;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.URLUtil;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.hls.HlsManifest;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.session.MediaSession;
import androidx.media3.ui.PlayerView;
import com.google.firebase.messaging.Constants;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$AppContextLost;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.video.IntervalUpdateClock;
import expo.modules.video.IntervalUpdateEmitter;
import expo.modules.video.VideoExceptionsKt;
import expo.modules.video.VideoView;
import expo.modules.video.delegates.IgnoreSameSet;
import expo.modules.video.enums.AudioMixingMode;
import expo.modules.video.enums.PlayerStatus;
import expo.modules.video.listeners.VideoPlayerListener;
import expo.modules.video.managers.VideoManager;
import expo.modules.video.playbackService.ExpoVideoPlaybackService;
import expo.modules.video.playbackService.PlaybackServiceConnection;
import expo.modules.video.records.AudioTrack;
import expo.modules.video.records.BufferOptions;
import expo.modules.video.records.PlaybackError;
import expo.modules.video.records.PlayerBuilderOptions;
import expo.modules.video.records.ScrubbingModeOptions;
import expo.modules.video.records.SeekTolerance;
import expo.modules.video.records.SubtitleTrack;
import expo.modules.video.records.TimeUpdate;
import expo.modules.video.records.VideoSource;
import expo.modules.video.records.VideoTrack;
import expo.modules.video.utils.MediaSessionUtilsKt;
import expo.modules.video.utils.MutableWeakReference;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004*\u0004á\u0001ä\u0001\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u001bH\u0016¢\u0006\u0004\b.\u0010\u001fJ\u000f\u0010/\u001a\u00020\u001bH\u0016¢\u0006\u0004\b/\u0010\u001fJ\r\u00100\u001a\u00020\u001b¢\u0006\u0004\b0\u0010\u001fJ\u0017\u00103\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u001b¢\u0006\u0004\b5\u0010\u001fJ\u0015\u00108\u001a\u00020\u001b2\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u001b2\u0006\u00107\u001a\u000206¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\u001bH\u0016¢\u0006\u0004\b;\u0010\u001fJ\r\u0010=\u001a\u00020<¢\u0006\u0004\b=\u0010>R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR \u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060F0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0017\u0010M\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010R\u001a\u00020Q8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0017\u0010W\u001a\u00020V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0017\u0010\\\u001a\u00020[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0017\u0010a\u001a\u00020`8\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020+8\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010-R\u0017\u0010i\u001a\u00020h8\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0017\u0010u\u001a\u00020t8\u0006¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR+\u0010~\u001a\u00020!2\u0006\u0010y\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010#\"\u0004\b}\u0010&R)\u0010\u007f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R5\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t2\b\u0010y\u001a\u0004\u0018\u00010\t8B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\b\u0085\u0001\u0010{\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R*\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R&\u0010\u0018\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0018\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0005\b\u001c\u0010\u0093\u0001R'\u0010\u0094\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0005\b\u0096\u0001\u0010#\"\u0005\b\u0097\u0001\u0010&R0\u0010\u0099\u0001\u001a\u00020!2\u0007\u0010\u0098\u0001\u001a\u00020!8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u0099\u0001\u0010\u0095\u0001\u001a\u0005\b\u009a\u0001\u0010#\"\u0005\b\u009b\u0001\u0010&R0\u0010\u009c\u0001\u001a\u00020!2\u0007\u0010\u009c\u0001\u001a\u00020!8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u009c\u0001\u0010\u0095\u0001\u001a\u0005\b\u009d\u0001\u0010#\"\u0005\b\u009e\u0001\u0010&R0\u0010\u009f\u0001\u001a\u00020!2\u0007\u0010\u0098\u0001\u001a\u00020!8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u009f\u0001\u0010\u0095\u0001\u001a\u0005\b \u0001\u0010#\"\u0005\b¡\u0001\u0010&R*\u0010¢\u0001\u001a\u00030\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010\u008b\u0001\u001a\u0006\b£\u0001\u0010\u008d\u0001\"\u0006\b¤\u0001\u0010\u008f\u0001R'\u0010¥\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¥\u0001\u0010\u0095\u0001\u001a\u0005\b¥\u0001\u0010#\"\u0005\b¦\u0001\u0010&R3\u0010ª\u0001\u001a\u00030\u0089\u00012\u0007\u0010y\u001a\u00030\u0089\u00018F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b§\u0001\u0010{\u001a\u0006\b¨\u0001\u0010\u008d\u0001\"\u0006\b©\u0001\u0010\u008f\u0001R/\u0010®\u0001\u001a\u00020!2\u0006\u0010y\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b«\u0001\u0010{\u001a\u0005\b¬\u0001\u0010#\"\u0005\b\u00ad\u0001\u0010&R0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b¯\u0001\u0010{\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R4\u0010µ\u0001\u001a\u00030´\u00012\b\u0010\u0098\u0001\u001a\u00030´\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R4\u0010¼\u0001\u001a\u00030»\u00012\b\u0010\u0098\u0001\u001a\u00030»\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R)\u0010Â\u0001\u001a\u00020!2\u0007\u0010\u0098\u0001\u001a\u00020!8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bÂ\u0001\u0010\u0095\u0001\u001a\u0005\bÂ\u0001\u0010#R8\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00012\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0006@BX\u0086\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R4\u0010Ë\u0001\u001a\u00030Ê\u00012\b\u0010\u0098\u0001\u001a\u00030Ê\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R4\u0010Ò\u0001\u001a\u00030Ñ\u00012\b\u0010\u0098\u0001\u001a\u00030Ñ\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R9\u0010Ù\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Ø\u00012\u000f\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Ø\u00018\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\bÙ\u0001\u0010H\u001a\u0006\bÚ\u0001\u0010Û\u0001R0\u0010à\u0001\u001a\u00020!2\u0006\u0010y\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0016\n\u0006\bÜ\u0001\u0010Ý\u0001\u001a\u0005\bÞ\u0001\u0010#\"\u0005\bß\u0001\u0010&R\u0018\u0010â\u0001\u001a\u00030á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0018\u0010å\u0001\u001a\u00030ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R5\u0010ì\u0001\u001a\u0004\u0018\u0001012\b\u0010y\u001a\u0004\u0018\u0001018F@FX\u0086\u008e\u0002¢\u0006\u0017\u001a\u0006\bç\u0001\u0010è\u0001\"\u0005\bé\u0001\u00104*\u0006\bê\u0001\u0010ë\u0001R\u0017\u0010ï\u0001\u001a\u0005\u0018\u00010\u0089\u00018F¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u0017\u0010ó\u0001\u001a\u0005\u0018\u00010ð\u00018F¢\u0006\b\u001a\u0006\bñ\u0001\u0010ò\u0001R\u0015\u0010÷\u0001\u001a\u00030ô\u00018F¢\u0006\b\u001a\u0006\bõ\u0001\u0010ö\u0001¨\u0006ø\u0001"}, d2 = {"Lexpo/modules/video/player/VideoPlayer;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lexpo/modules/video/IntervalUpdateEmitter;", "Landroid/content/Context;", "context", "Lexpo/modules/kotlin/AppContext;", "appContext", "Lexpo/modules/video/records/VideoSource;", Constants.ScionAnalytics.PARAM_SOURCE, "Lexpo/modules/video/records/PlayerBuilderOptions;", "playerBuilderOptions", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;Lexpo/modules/video/records/VideoSource;Lexpo/modules/video/records/PlayerBuilderOptions;)V", "Landroidx/media3/common/PlaybackParameters;", "playbackParameters", "applyPitchCorrection", "(Landroidx/media3/common/PlaybackParameters;)Landroidx/media3/common/PlaybackParameters;", "", "state", "Lexpo/modules/video/enums/PlayerStatus;", "playerStateToPlayerStatus", "(I)Lexpo/modules/video/enums/PlayerStatus;", "status", "Landroidx/media3/common/PlaybackException;", "error", "", "setStatus", "(Lexpo/modules/video/enums/PlayerStatus;Landroidx/media3/common/PlaybackException;)V", "refreshPlaybackInfo", "()V", "resetPlaybackInfo", "", "startPlaybackService", "()Z", "showNotification", "serviceSetShowNotification", "(Z)V", "Lexpo/modules/video/player/PlayerEvent;", "event", "sendEvent", "(Lexpo/modules/video/player/PlayerEvent;)V", "Lexpo/modules/video/player/FirstFrameEventGenerator;", "createFirstFrameEventGenerator", "()Lexpo/modules/video/player/FirstFrameEventGenerator;", "close", "sharedObjectDidRelease", "hasBeenDisconnectedFromVideoView", "Lexpo/modules/video/VideoView;", "videoView", "changeVideoView", "(Lexpo/modules/video/VideoView;)V", "prepare", "Lexpo/modules/video/listeners/VideoPlayerListener;", "videoPlayerListener", "addListener", "(Lexpo/modules/video/listeners/VideoPlayerListener;)V", "removeListener", "emitTimeUpdate", "Landroid/media/MediaMetadataRetriever;", "toMetadataRetriever", "()Landroid/media/MediaMetadataRetriever;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroidx/media3/exoplayer/DefaultRenderersFactory;", "renderersFactory", "Landroidx/media3/exoplayer/DefaultRenderersFactory;", "", "Ljava/lang/ref/WeakReference;", "listeners", "Ljava/util/List;", "Lexpo/modules/video/utils/MutableWeakReference;", "currentVideoViewRef", "Lexpo/modules/video/utils/MutableWeakReference;", "Lexpo/modules/video/player/VideoPlayerLoadControl;", "loadControl", "Lexpo/modules/video/player/VideoPlayerLoadControl;", "getLoadControl", "()Lexpo/modules/video/player/VideoPlayerLoadControl;", "Lexpo/modules/video/player/VideoPlayerSubtitles;", "subtitles", "Lexpo/modules/video/player/VideoPlayerSubtitles;", "getSubtitles", "()Lexpo/modules/video/player/VideoPlayerSubtitles;", "Lexpo/modules/video/player/VideoPlayerAudioTracks;", "audioTracks", "Lexpo/modules/video/player/VideoPlayerAudioTracks;", "getAudioTracks", "()Lexpo/modules/video/player/VideoPlayerAudioTracks;", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "trackSelector", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "getTrackSelector", "()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "Landroidx/media3/exoplayer/ExoPlayer;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "getPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "firstFrameEventGenerator", "Lexpo/modules/video/player/FirstFrameEventGenerator;", "getFirstFrameEventGenerator$expo_video_release", "Lexpo/modules/video/playbackService/PlaybackServiceConnection;", "serviceConnection", "Lexpo/modules/video/playbackService/PlaybackServiceConnection;", "getServiceConnection", "()Lexpo/modules/video/playbackService/PlaybackServiceConnection;", "Landroidx/media3/session/MediaSession;", "mediaSession", "Landroidx/media3/session/MediaSession;", "getMediaSession", "()Landroidx/media3/session/MediaSession;", "setMediaSession", "(Landroidx/media3/session/MediaSession;)V", "Lexpo/modules/video/IntervalUpdateClock;", "intervalUpdateClock", "Lexpo/modules/video/IntervalUpdateClock;", "getIntervalUpdateClock", "()Lexpo/modules/video/IntervalUpdateClock;", "<set-?>", "playing$delegate", "Lexpo/modules/video/delegates/IgnoreSameSet;", "getPlaying", "setPlaying", "playing", "uncommittedSource", "Lexpo/modules/video/records/VideoSource;", "getUncommittedSource", "()Lexpo/modules/video/records/VideoSource;", "setUncommittedSource", "(Lexpo/modules/video/records/VideoSource;)V", "commitedSource$delegate", "getCommitedSource", "setCommitedSource", "commitedSource", "", "userVolume", "F", "getUserVolume", "()F", "setUserVolume", "(F)V", "Lexpo/modules/video/enums/PlayerStatus;", "getStatus", "()Lexpo/modules/video/enums/PlayerStatus;", "(Lexpo/modules/video/enums/PlayerStatus;)V", "requiresLinearPlayback", "Z", "getRequiresLinearPlayback", "setRequiresLinearPlayback", "value", "staysActiveInBackground", "getStaysActiveInBackground", "setStaysActiveInBackground", "preservesPitch", "getPreservesPitch", "setPreservesPitch", "showNowPlayingNotification", "getShowNowPlayingNotification", "setShowNowPlayingNotification", "duration", "getDuration", "setDuration", "isLive", "setLive", "volume$delegate", "getVolume", "setVolume", "volume", "muted$delegate", "getMuted", "setMuted", "muted", "playbackParameters$delegate", "getPlaybackParameters", "()Landroidx/media3/common/PlaybackParameters;", "setPlaybackParameters", "(Landroidx/media3/common/PlaybackParameters;)V", "Lexpo/modules/video/records/BufferOptions;", "bufferOptions", "Lexpo/modules/video/records/BufferOptions;", "getBufferOptions", "()Lexpo/modules/video/records/BufferOptions;", "setBufferOptions", "(Lexpo/modules/video/records/BufferOptions;)V", "Lexpo/modules/video/enums/AudioMixingMode;", "audioMixingMode", "Lexpo/modules/video/enums/AudioMixingMode;", "getAudioMixingMode", "()Lexpo/modules/video/enums/AudioMixingMode;", "setAudioMixingMode", "(Lexpo/modules/video/enums/AudioMixingMode;)V", "isLoadingNewSource", "Lexpo/modules/video/records/VideoTrack;", "currentVideoTrack", "Lexpo/modules/video/records/VideoTrack;", "getCurrentVideoTrack", "()Lexpo/modules/video/records/VideoTrack;", "setCurrentVideoTrack", "(Lexpo/modules/video/records/VideoTrack;)V", "Lexpo/modules/video/records/SeekTolerance;", "seekTolerance", "Lexpo/modules/video/records/SeekTolerance;", "getSeekTolerance", "()Lexpo/modules/video/records/SeekTolerance;", "setSeekTolerance", "(Lexpo/modules/video/records/SeekTolerance;)V", "Lexpo/modules/video/records/ScrubbingModeOptions;", "scrubbingModeOptions", "Lexpo/modules/video/records/ScrubbingModeOptions;", "getScrubbingModeOptions", "()Lexpo/modules/video/records/ScrubbingModeOptions;", "setScrubbingModeOptions", "(Lexpo/modules/video/records/ScrubbingModeOptions;)V", "", "availableVideoTracks", "getAvailableVideoTracks", "()Ljava/util/List;", "keepScreenOnWhilePlaying$delegate", "Lexpo/modules/video/player/VideoPlayerKeepAwake;", "getKeepScreenOnWhilePlaying", "setKeepScreenOnWhilePlaying", "keepScreenOnWhilePlaying", "expo/modules/video/player/VideoPlayer$playerListener$1", "playerListener", "Lexpo/modules/video/player/VideoPlayer$playerListener$1;", "expo/modules/video/player/VideoPlayer$analyticsListener$1", "analyticsListener", "Lexpo/modules/video/player/VideoPlayer$analyticsListener$1;", "getCurrentVideoView", "()Lexpo/modules/video/VideoView;", "setCurrentVideoView", "getCurrentVideoView$delegate", "(Lexpo/modules/video/player/VideoPlayer;)Ljava/lang/Object;", "currentVideoView", "getCurrentOffsetFromLive", "()Ljava/lang/Float;", "currentOffsetFromLive", "", "getCurrentLiveTimestamp", "()Ljava/lang/Long;", "currentLiveTimestamp", "", "getBufferedPosition", "()D", "bufferedPosition", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPlayer extends SharedObject implements AutoCloseable, IntervalUpdateEmitter {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoPlayer.class, "currentVideoView", "getCurrentVideoView()Lexpo/modules/video/VideoView;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoPlayer.class, "playing", "getPlaying()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoPlayer.class, "commitedSource", "getCommitedSource()Lexpo/modules/video/records/VideoSource;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoPlayer.class, "volume", "getVolume()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoPlayer.class, "muted", "getMuted()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoPlayer.class, "playbackParameters", "getPlaybackParameters()Landroidx/media3/common/PlaybackParameters;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(VideoPlayer.class, "keepScreenOnWhilePlaying", "getKeepScreenOnWhilePlaying()Z", 0))};
    private final VideoPlayer$analyticsListener$1 analyticsListener;
    private AudioMixingMode audioMixingMode;
    private final VideoPlayerAudioTracks audioTracks;
    private List availableVideoTracks;
    private BufferOptions bufferOptions;

    /* JADX INFO: renamed from: commitedSource$delegate, reason: from kotlin metadata */
    private final IgnoreSameSet commitedSource;
    private final Context context;
    private VideoTrack currentVideoTrack;
    private final MutableWeakReference currentVideoViewRef;
    private float duration;
    private final FirstFrameEventGenerator firstFrameEventGenerator;
    private final IntervalUpdateClock intervalUpdateClock;
    private boolean isLive;
    private boolean isLoadingNewSource;

    /* JADX INFO: renamed from: keepScreenOnWhilePlaying$delegate, reason: from kotlin metadata */
    private final VideoPlayerKeepAwake keepScreenOnWhilePlaying;
    private final List listeners;
    private final VideoPlayerLoadControl loadControl;
    private MediaSession mediaSession;

    /* JADX INFO: renamed from: muted$delegate, reason: from kotlin metadata */
    private final IgnoreSameSet muted;

    /* JADX INFO: renamed from: playbackParameters$delegate, reason: from kotlin metadata */
    private final IgnoreSameSet playbackParameters;
    private final ExoPlayer player;
    private final VideoPlayer$playerListener$1 playerListener;

    /* JADX INFO: renamed from: playing$delegate, reason: from kotlin metadata */
    private final IgnoreSameSet playing;
    private boolean preservesPitch;
    private DefaultRenderersFactory renderersFactory;
    private boolean requiresLinearPlayback;
    private ScrubbingModeOptions scrubbingModeOptions;
    private SeekTolerance seekTolerance;
    private final PlaybackServiceConnection serviceConnection;
    private boolean showNowPlayingNotification;
    private PlayerStatus status;
    private boolean staysActiveInBackground;
    private final VideoPlayerSubtitles subtitles;
    private final DefaultTrackSelector trackSelector;
    private VideoSource uncommittedSource;
    private float userVolume;

    /* JADX INFO: renamed from: volume$delegate, reason: from kotlin metadata */
    private final IgnoreSameSet volume;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.media3.common.Player$Listener, expo.modules.video.player.VideoPlayer$playerListener$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.media3.exoplayer.analytics.AnalyticsListener, expo.modules.video.player.VideoPlayer$analyticsListener$1] */
    public VideoPlayer(Context context, final AppContext appContext, VideoSource videoSource, PlayerBuilderOptions playerBuilderOptions) {
        Duration seekForwardIncrement;
        Duration seekBackwardIncrement;
        super(appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.context = context;
        DefaultRenderersFactory enableDecoderFallback = new DefaultRenderersFactory(context).forceEnableMediaCodecAsynchronousQueueing().setEnableDecoderFallback(true);
        Intrinsics.checkNotNullExpressionValue(enableDecoderFallback, "setEnableDecoderFallback(...)");
        this.renderersFactory = enableDecoderFallback;
        this.listeners = new ArrayList();
        this.currentVideoViewRef = new MutableWeakReference(null, new Function2() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoPlayer.currentVideoViewRef$lambda$0(this.f$0, (VideoView) obj, (VideoView) obj2);
            }
        });
        VideoPlayerLoadControl videoPlayerLoadControl = new VideoPlayerLoadControl();
        this.loadControl = videoPlayerLoadControl;
        this.subtitles = new VideoPlayerSubtitles(this);
        this.audioTracks = new VideoPlayerAudioTracks(this);
        this.trackSelector = new DefaultTrackSelector(context);
        ExoPlayer.Builder builder = new ExoPlayer.Builder(context, this.renderersFactory);
        builder.setLooper(context.getMainLooper());
        builder.setLoadControl(videoPlayerLoadControl);
        if (playerBuilderOptions != null && (seekBackwardIncrement = playerBuilderOptions.getSeekBackwardIncrement()) != null) {
            builder.setSeekBackIncrementMs(RangesKt.coerceIn(Duration.m5427toLongimpl(seekBackwardIncrement.m5431unboximpl(), DurationUnit.MILLISECONDS), 1L, 999000L));
        }
        if (playerBuilderOptions != null && (seekForwardIncrement = playerBuilderOptions.getSeekForwardIncrement()) != null) {
            builder.setSeekForwardIncrementMs(RangesKt.coerceIn(Duration.m5427toLongimpl(seekForwardIncrement.m5431unboximpl(), DurationUnit.MILLISECONDS), 1L, 999000L));
        }
        ExoPlayer exoPlayerBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "build(...)");
        this.player = exoPlayerBuild;
        this.serviceConnection = new PlaybackServiceConnection(new WeakReference(this), appContext);
        this.mediaSession = MediaSessionUtilsKt.buildBasicMediaSession(context, exoPlayerBuild);
        this.intervalUpdateClock = new IntervalUpdateClock(this);
        Boolean bool = Boolean.FALSE;
        this.playing = new IgnoreSameSet(bool, null, new Function2() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoPlayer.playing_delegate$lambda$4(this.f$0, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            }
        }, 2, null);
        this.uncommittedSource = videoSource;
        this.commitedSource = new IgnoreSameSet(null, null, new Function2() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoPlayer.commitedSource_delegate$lambda$5(this.f$0, (VideoSource) obj, (VideoSource) obj2);
            }
        }, 2, null);
        this.userVolume = 1.0f;
        this.status = PlayerStatus.IDLE;
        this.volume = new IgnoreSameSet(Float.valueOf(1.0f), null, new Function2() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoPlayer.volume_delegate$lambda$6(appContext, this, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        }, 2, null);
        this.muted = new IgnoreSameSet(bool, null, new Function2() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoPlayer.muted_delegate$lambda$7(appContext, this, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            }
        }, 2, null);
        this.playbackParameters = new IgnoreSameSet(PlaybackParameters.DEFAULT, new Function1() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoPlayer.playbackParameters_delegate$lambda$8(this.f$0, (PlaybackParameters) obj);
            }
        }, new Function2() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return VideoPlayer.playbackParameters_delegate$lambda$9(appContext, this, (PlaybackParameters) obj, (PlaybackParameters) obj2);
            }
        });
        this.bufferOptions = new BufferOptions(null, 0L, false, 0.0d, 15, null);
        this.audioMixingMode = AudioMixingMode.AUTO;
        this.seekTolerance = new SeekTolerance(0.0d, 0.0d, 3, null);
        this.scrubbingModeOptions = new ScrubbingModeOptions(false, false, false, false, false, 31, null);
        this.availableVideoTracks = CollectionsKt.emptyList();
        this.keepScreenOnWhilePlaying = new VideoPlayerKeepAwake(this, appContext, false, 4, null);
        ?? r0 = new Player.Listener() { // from class: expo.modules.video.player.VideoPlayer$playerListener$1
            @Override // androidx.media3.common.Player.Listener
            public void onIsPlayingChanged(boolean z) {
                this.this$0.setPlaying(z);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onTracksChanged(Tracks tracks) {
                Intrinsics.checkNotNullParameter(tracks, "tracks");
                ArrayList arrayList = new ArrayList(this.this$0.getSubtitles().getAvailableSubtitleTracks());
                ArrayList arrayList2 = new ArrayList(this.this$0.getAudioTracks().getAvailableAudioTracks());
                SubtitleTrack currentSubtitleTrack = this.this$0.getSubtitles().getCurrentSubtitleTrack();
                AudioTrack currentAudioTrack = this.this$0.getAudioTracks().getCurrentAudioTrack();
                this.this$0.sendEvent(new PlayerEvent.TracksChanged(tracks));
                ArrayList availableSubtitleTracks = this.this$0.getSubtitles().getAvailableSubtitleTracks();
                ArrayList availableAudioTracks = this.this$0.getAudioTracks().getAvailableAudioTracks();
                SubtitleTrack currentSubtitleTrack2 = this.this$0.getSubtitles().getCurrentSubtitleTrack();
                AudioTrack currentAudioTrack2 = this.this$0.getAudioTracks().getCurrentAudioTrack();
                Object currentManifest = this.this$0.getPlayer().getCurrentManifest();
                this.this$0.availableVideoTracks = VideoPlayerKt.toVideoTracks(tracks, currentManifest instanceof HlsManifest ? (HlsManifest) currentManifest : null);
                this.this$0.refreshPlaybackInfo();
                if (this.this$0.getIsLoadingNewSource()) {
                    VideoPlayer videoPlayer = this.this$0;
                    videoPlayer.sendEvent(new PlayerEvent.VideoSourceLoaded(videoPlayer.getCommitedSource(), this.this$0.getDuration(), this.this$0.getAvailableVideoTracks(), availableSubtitleTracks, availableAudioTracks));
                    this.this$0.isLoadingNewSource = false;
                }
                if (!Arrays.equals(arrayList.toArray(), availableSubtitleTracks.toArray())) {
                    this.this$0.sendEvent(new PlayerEvent.AvailableSubtitleTracksChanged(availableSubtitleTracks, arrayList));
                }
                if (!Arrays.equals(arrayList2.toArray(), availableAudioTracks.toArray())) {
                    this.this$0.sendEvent(new PlayerEvent.AvailableAudioTracksChanged(availableAudioTracks, arrayList2));
                }
                if (!Intrinsics.areEqual(currentSubtitleTrack, currentSubtitleTrack2)) {
                    this.this$0.sendEvent(new PlayerEvent.SubtitleTrackChanged(currentSubtitleTrack2, currentSubtitleTrack));
                }
                if (!Intrinsics.areEqual(currentAudioTrack, currentAudioTrack2)) {
                    this.this$0.sendEvent(new PlayerEvent.AudioTrackChanged(currentAudioTrack2, currentAudioTrack));
                }
                super.onTracksChanged(tracks);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onTrackSelectionParametersChanged(TrackSelectionParameters parameters) {
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                SubtitleTrack currentSubtitleTrack = this.this$0.getSubtitles().getCurrentSubtitleTrack();
                AudioTrack currentAudioTrack = this.this$0.getAudioTracks().getCurrentAudioTrack();
                this.this$0.sendEvent(new PlayerEvent.TrackSelectionParametersChanged(parameters));
                SubtitleTrack currentSubtitleTrack2 = this.this$0.getSubtitles().getCurrentSubtitleTrack();
                AudioTrack currentAudioTrack2 = this.this$0.getAudioTracks().getCurrentAudioTrack();
                this.this$0.sendEvent(new PlayerEvent.SubtitleTrackChanged(currentSubtitleTrack2, currentSubtitleTrack));
                this.this$0.sendEvent(new PlayerEvent.AudioTrackChanged(currentAudioTrack2, currentAudioTrack));
                super.onTrackSelectionParametersChanged(parameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onMediaItemTransition(MediaItem mediaItem, int i) {
                if (i == 0) {
                    this.this$0.sendEvent(new PlayerEvent.PlayedToEnd());
                } else {
                    this.this$0.resetPlaybackInfo();
                }
                this.this$0.getSubtitles().setSubtitlesEnabled(false);
                super.onMediaItemTransition(mediaItem, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int i) {
                if (i != 1 || this.this$0.getPlayer().getPlayerError() == null) {
                    if (i == 3) {
                        this.this$0.refreshPlaybackInfo();
                    }
                    VideoPlayer videoPlayer = this.this$0;
                    videoPlayer.setStatus(videoPlayer.playerStateToPlayerStatus(i), null);
                    super.onPlaybackStateChanged(i);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public void onVolumeChanged(float f) {
                if (this.this$0.getMuted()) {
                    return;
                }
                this.this$0.setVolume(f);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                Intrinsics.checkNotNullParameter(playbackParameters, "playbackParameters");
                this.this$0.setPlaybackParameters(playbackParameters);
                super.onPlaybackParametersChanged(playbackParameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayerErrorChanged(PlaybackException playbackException) {
                if (playbackException != null) {
                    VideoPlayer videoPlayer = this.this$0;
                    videoPlayer.resetPlaybackInfo();
                    videoPlayer.setStatus(PlayerStatus.ERROR, playbackException);
                } else {
                    VideoPlayer videoPlayer2 = this.this$0;
                    videoPlayer2.setStatus(videoPlayer2.playerStateToPlayerStatus(videoPlayer2.getPlayer().getPlaybackState()), null);
                }
                super.onPlayerErrorChanged(playbackException);
            }
        };
        this.playerListener = r0;
        ?? r2 = new AnalyticsListener() { // from class: expo.modules.video.player.VideoPlayer$analyticsListener$1
            @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
            public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
                Object obj;
                Object next;
                Format format2;
                Intrinsics.checkNotNullParameter(eventTime, "eventTime");
                Intrinsics.checkNotNullParameter(format, "format");
                VideoPlayer videoPlayer = this.this$0;
                Iterator it = videoPlayer.getAvailableVideoTracks().iterator();
                do {
                    obj = null;
                    if (it.hasNext()) {
                        next = it.next();
                        format2 = ((VideoTrack) next).getFormat();
                    }
                    videoPlayer.setCurrentVideoTrack((VideoTrack) obj);
                    super.onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
                } while (!Intrinsics.areEqual(format2 != null ? format2.id : null, format.id));
                obj = next;
                videoPlayer.setCurrentVideoTrack((VideoTrack) obj);
                super.onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
            }
        };
        this.analyticsListener = r2;
        exoPlayerBuild.addListener(r0);
        exoPlayerBuild.addAnalyticsListener(r2);
        VideoManager.INSTANCE.registerVideoPlayer(this);
        this.firstFrameEventGenerator = createFirstFrameEventGenerator();
        BuildersKt__Builders_commonKt.launch$default(appContext.getMainQueue(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit currentVideoViewRef$lambda$0(VideoPlayer videoPlayer, VideoView videoView, VideoView videoView2) {
        videoPlayer.sendEvent(new PlayerEvent.TargetViewChanged(videoView, videoView2));
        return Unit.INSTANCE;
    }

    public final VideoView getCurrentVideoView() {
        return (VideoView) this.currentVideoViewRef.getValue(this, $$delegatedProperties[0]);
    }

    public final void setCurrentVideoView(VideoView videoView) {
        this.currentVideoViewRef.setValue(this, $$delegatedProperties[0], videoView);
    }

    public final VideoPlayerSubtitles getSubtitles() {
        return this.subtitles;
    }

    public final VideoPlayerAudioTracks getAudioTracks() {
        return this.audioTracks;
    }

    public final ExoPlayer getPlayer() {
        return this.player;
    }

    /* JADX INFO: renamed from: getFirstFrameEventGenerator$expo_video_release, reason: from getter */
    public final FirstFrameEventGenerator getFirstFrameEventGenerator() {
        return this.firstFrameEventGenerator;
    }

    public final PlaybackServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final IntervalUpdateClock getIntervalUpdateClock() {
        return this.intervalUpdateClock;
    }

    public final boolean getPlaying() {
        return ((Boolean) this.playing.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setPlaying(boolean z) {
        this.playing.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playing_delegate$lambda$4(VideoPlayer videoPlayer, boolean z, boolean z2) {
        videoPlayer.sendEvent(new PlayerEvent.IsPlayingChanged(z, Boolean.valueOf(z2)));
        return Unit.INSTANCE;
    }

    public final void setUncommittedSource(VideoSource videoSource) {
        this.uncommittedSource = videoSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoSource getCommitedSource() {
        return (VideoSource) this.commitedSource.getValue(this, $$delegatedProperties[2]);
    }

    private final void setCommitedSource(VideoSource videoSource) {
        this.commitedSource.setValue(this, $$delegatedProperties[2], videoSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commitedSource_delegate$lambda$5(VideoPlayer videoPlayer, VideoSource videoSource, VideoSource videoSource2) {
        videoPlayer.sendEvent(new PlayerEvent.SourceChanged(videoSource, videoSource2));
        return Unit.INSTANCE;
    }

    public final float getUserVolume() {
        return this.userVolume;
    }

    public final void setUserVolume(float f) {
        this.userVolume = f;
    }

    public final PlayerStatus getStatus() {
        return this.status;
    }

    public final boolean getRequiresLinearPlayback() {
        return this.requiresLinearPlayback;
    }

    public final void setRequiresLinearPlayback(boolean z) {
        this.requiresLinearPlayback = z;
    }

    public final boolean getStaysActiveInBackground() {
        return this.staysActiveInBackground;
    }

    public final void setStaysActiveInBackground(boolean z) throws Exceptions$AppContextLost {
        this.staysActiveInBackground = z;
        if (z) {
            startPlaybackService();
        }
    }

    public final boolean getPreservesPitch() {
        return this.preservesPitch;
    }

    public final void setPreservesPitch(boolean z) {
        CoroutineScope mainQueue;
        this.preservesPitch = z;
        AppContext appContext = getAppContext();
        if (appContext == null || (mainQueue = appContext.getMainQueue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(mainQueue, null, null, new VideoPlayer$preservesPitch$1(this, null), 3, null);
    }

    public final boolean getShowNowPlayingNotification() {
        return this.showNowPlayingNotification;
    }

    public final void setShowNowPlayingNotification(boolean z) {
        CoroutineScope mainQueue;
        this.showNowPlayingNotification = z;
        AppContext appContext = getAppContext();
        if (appContext == null || (mainQueue = appContext.getMainQueue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(mainQueue, null, null, new VideoPlayer$showNowPlayingNotification$1(this, z, null), 3, null);
    }

    public final float getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: isLive, reason: from getter */
    public final boolean getIsLive() {
        return this.isLive;
    }

    public final float getVolume() {
        return ((Number) this.volume.getValue(this, $$delegatedProperties[3])).floatValue();
    }

    public final void setVolume(float f) {
        this.volume.setValue(this, $$delegatedProperties[3], Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit volume_delegate$lambda$6(AppContext appContext, VideoPlayer videoPlayer, float f, float f2) {
        BuildersKt__Builders_commonKt.launch$default(appContext.getMainQueue(), null, null, new VideoPlayer$volume$2$1(videoPlayer, f, null), 3, null);
        videoPlayer.userVolume = videoPlayer.getVolume();
        videoPlayer.sendEvent(new PlayerEvent.VolumeChanged(f, Float.valueOf(f2)));
        return Unit.INSTANCE;
    }

    public final boolean getMuted() {
        return ((Boolean) this.muted.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    public final void setMuted(boolean z) {
        this.muted.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit muted_delegate$lambda$7(AppContext appContext, VideoPlayer videoPlayer, boolean z, boolean z2) {
        BuildersKt__Builders_commonKt.launch$default(appContext.getMainQueue(), null, null, new VideoPlayer$muted$2$1(videoPlayer, z, null), 3, null);
        videoPlayer.sendEvent(new PlayerEvent.MutedChanged(z, Boolean.valueOf(z2)));
        return Unit.INSTANCE;
    }

    public final PlaybackParameters getPlaybackParameters() {
        return (PlaybackParameters) this.playbackParameters.getValue(this, $$delegatedProperties[5]);
    }

    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        Intrinsics.checkNotNullParameter(playbackParameters, "<set-?>");
        this.playbackParameters.setValue(this, $$delegatedProperties[5], playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlaybackParameters playbackParameters_delegate$lambda$8(VideoPlayer videoPlayer, PlaybackParameters it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return videoPlayer.applyPitchCorrection(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playbackParameters_delegate$lambda$9(AppContext appContext, VideoPlayer videoPlayer, PlaybackParameters playbackParameters, PlaybackParameters old) {
        Intrinsics.checkNotNullParameter(playbackParameters, "new");
        Intrinsics.checkNotNullParameter(old, "old");
        BuildersKt__Builders_commonKt.launch$default(appContext.getMainQueue(), null, null, new VideoPlayer$playbackParameters$3$1(videoPlayer, playbackParameters, null), 3, null);
        float f = old.speed;
        float f2 = playbackParameters.speed;
        if (f != f2) {
            videoPlayer.sendEvent(new PlayerEvent.PlaybackRateChanged(f2, Float.valueOf(f)));
        }
        return Unit.INSTANCE;
    }

    public final Float getCurrentOffsetFromLive() {
        if (this.player.getCurrentLiveOffset() == -9223372036854775807L) {
            return null;
        }
        return Float.valueOf(this.player.getCurrentLiveOffset() / 1000.0f);
    }

    public final Long getCurrentLiveTimestamp() {
        Timeline.Window window = new Timeline.Window();
        if (!this.player.getCurrentTimeline().isEmpty()) {
            this.player.getCurrentTimeline().getWindow(this.player.getCurrentMediaItemIndex(), window);
        }
        long j = window.windowStartTimeMs;
        if (j == -9223372036854775807L) {
            return null;
        }
        return Long.valueOf(j + this.player.getCurrentPosition());
    }

    public final BufferOptions getBufferOptions() {
        return this.bufferOptions;
    }

    public final void setBufferOptions(BufferOptions value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.bufferOptions = value;
        this.loadControl.applyBufferOptions(value);
    }

    public final double getBufferedPosition() {
        if (this.player.getCurrentMediaItem() == null) {
            return -1.0d;
        }
        if (this.player.getPlaybackState() == 2) {
            return 0.0d;
        }
        return this.player.getBufferedPosition() / 1000.0d;
    }

    public final AudioMixingMode getAudioMixingMode() {
        return this.audioMixingMode;
    }

    public final void setAudioMixingMode(AudioMixingMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        AudioMixingMode audioMixingMode = this.audioMixingMode;
        this.audioMixingMode = value;
        sendEvent(new PlayerEvent.AudioMixingModeChanged(value, audioMixingMode));
    }

    /* JADX INFO: renamed from: isLoadingNewSource, reason: from getter */
    public final boolean getIsLoadingNewSource() {
        return this.isLoadingNewSource;
    }

    public final VideoTrack getCurrentVideoTrack() {
        return this.currentVideoTrack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentVideoTrack(VideoTrack videoTrack) {
        VideoTrack videoTrack2 = this.currentVideoTrack;
        this.currentVideoTrack = videoTrack;
        sendEvent(new PlayerEvent.VideoTrackChanged(videoTrack, videoTrack2));
    }

    public final SeekTolerance getSeekTolerance() {
        return this.seekTolerance;
    }

    public final void setSeekTolerance(SeekTolerance value) {
        CoroutineScope mainQueue;
        Intrinsics.checkNotNullParameter(value, "value");
        this.seekTolerance = value;
        AppContext appContext = getAppContext();
        if (appContext == null || (mainQueue = appContext.getMainQueue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(mainQueue, null, null, new VideoPlayer$seekTolerance$1(this, null), 3, null);
    }

    public final ScrubbingModeOptions getScrubbingModeOptions() {
        return this.scrubbingModeOptions;
    }

    public final void setScrubbingModeOptions(ScrubbingModeOptions value) {
        CoroutineScope mainQueue;
        Intrinsics.checkNotNullParameter(value, "value");
        this.scrubbingModeOptions = value;
        AppContext appContext = getAppContext();
        if (appContext == null || (mainQueue = appContext.getMainQueue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(mainQueue, null, null, new VideoPlayer$scrubbingModeOptions$1(this, null), 3, null);
    }

    public final List getAvailableVideoTracks() {
        return this.availableVideoTracks;
    }

    public final boolean getKeepScreenOnWhilePlaying() {
        return this.keepScreenOnWhilePlaying.getValue((Object) this, $$delegatedProperties[6]).booleanValue();
    }

    public final void setKeepScreenOnWhilePlaying(boolean z) {
        this.keepScreenOnWhilePlaying.setValue(this, $$delegatedProperties[6], z);
    }

    /* JADX INFO: renamed from: expo.modules.video.player.VideoPlayer$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return VideoPlayer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            VideoPlayer.this.getSubtitles().setSubtitlesEnabled(false);
            return Unit.INSTANCE;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        AppContext appContext;
        Context reactContext;
        setKeepScreenOnWhilePlaying(false);
        this.intervalUpdateClock.setInterval(0L);
        synchronized (this.listeners) {
            this.listeners.clear();
            Unit unit = Unit.INSTANCE;
        }
        if (this.serviceConnection.isConnected() && (appContext = getAppContext()) != null && (reactContext = appContext.getReactContext()) != null) {
            reactContext.unbindService(this.serviceConnection);
        }
        this.serviceConnection.getPlaybackServiceBinder();
        this.mediaSession.release();
        VideoManager.INSTANCE.unregisterVideoPlayer(this);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AnonymousClass2(null), 2, null);
        this.uncommittedSource = null;
        setCommitedSource(null);
    }

    /* JADX INFO: renamed from: expo.modules.video.player.VideoPlayer$close$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return VideoPlayer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            VideoPlayer.this.getFirstFrameEventGenerator().release();
            VideoPlayer.this.getPlayer().removeListener(VideoPlayer.this.playerListener);
            VideoPlayer.this.getPlayer().removeAnalyticsListener(VideoPlayer.this.analyticsListener);
            VideoPlayer.this.getPlayer().release();
            return Unit.INSTANCE;
        }
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void sharedObjectDidRelease() {
        super.sharedObjectDidRelease();
        close();
    }

    public final void hasBeenDisconnectedFromVideoView() {
        PlayerView playerView;
        VideoView currentVideoView = getCurrentVideoView();
        if (Intrinsics.areEqual((currentVideoView == null || (playerView = currentVideoView.getPlayerView()) == null) ? null : playerView.getPlayer(), this.player)) {
            throw new IllegalStateException("The player has been notified of disconnection from the player view, even though it's still connected.");
        }
        setCurrentVideoView(null);
    }

    public final void changeVideoView(VideoView videoView) {
        ExoPlayer exoPlayer = this.player;
        VideoView currentVideoView = getCurrentVideoView();
        PlayerView.switchTargetView(exoPlayer, currentVideoView != null ? currentVideoView.getPlayerView() : null, videoView != null ? videoView.getPlayerView() : null);
        setCurrentVideoView(videoView);
    }

    public final void prepare() {
        this.availableVideoTracks = CollectionsKt.emptyList();
        setCurrentVideoTrack(null);
        VideoSource videoSource = this.uncommittedSource;
        MediaSource mediaSource = videoSource != null ? videoSource.toMediaSource(this.context) : null;
        if (mediaSource != null) {
            this.player.setMediaSource(mediaSource);
            this.player.prepare();
            setCommitedSource(videoSource);
            this.uncommittedSource = null;
            this.isLoadingNewSource = true;
            return;
        }
        this.player.clearMediaItems();
        this.player.prepare();
        this.isLoadingNewSource = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlaybackParameters applyPitchCorrection(PlaybackParameters playbackParameters) {
        float f = playbackParameters.speed;
        return new PlaybackParameters(f, this.preservesPitch ? 1.0f : f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayerStatus playerStateToPlayerStatus(int state) {
        if (state == 1) {
            return PlayerStatus.IDLE;
        }
        if (state == 2) {
            return PlayerStatus.LOADING;
        }
        if (state == 3) {
            return PlayerStatus.READY_TO_PLAY;
        }
        if (state == 4) {
            if (this.player.getPlayerError() != null) {
                return PlayerStatus.ERROR;
            }
            return PlayerStatus.IDLE;
        }
        return PlayerStatus.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStatus(PlayerStatus status, PlaybackException error) {
        PlayerStatus playerStatus = this.status;
        this.status = status;
        PlaybackError playbackError = error != null ? new PlaybackError(error) : null;
        if (playbackError == null && this.player.getPlaybackState() == 4) {
            sendEvent(new PlayerEvent.PlayedToEnd());
        }
        if (this.status != playerStatus) {
            sendEvent(new PlayerEvent.StatusChanged(status, playerStatus, playbackError));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshPlaybackInfo() {
        this.duration = this.player.getDuration() / 1000.0f;
        this.isLive = this.player.isCurrentMediaItemLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetPlaybackInfo() {
        this.duration = 0.0f;
        this.isLive = false;
    }

    private final boolean startPlaybackService() throws Exceptions$AppContextLost {
        Logger jsLogger;
        this.serviceConnection.getPlaybackServiceBinder();
        AppContext appContext = getAppContext();
        if (appContext == null) {
            throw new Exceptions$AppContextLost();
        }
        boolean zStartService = ExpoVideoPlaybackService.Companion.startService(appContext, this.context, this.serviceConnection);
        if (!zStartService && (jsLogger = appContext.getJsLogger()) != null) {
            Logger.error$default(jsLogger, VideoExceptionsKt.getPlaybackServiceErrorMessage$default("Expo-video has failed to bind with the playback service binder", null, 2, null), null, 2, null);
        }
        return zStartService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void serviceSetShowNotification(boolean showNotification) throws Exceptions$AppContextLost {
        if (showNotification) {
            startPlaybackService();
        }
        this.serviceConnection.getPlaybackServiceBinder();
    }

    public final void addListener(VideoPlayerListener videoPlayerListener) {
        Intrinsics.checkNotNullParameter(videoPlayerListener, "videoPlayerListener");
        synchronized (this.listeners) {
            try {
                List list = this.listeners;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    do {
                        if (it.hasNext()) {
                        }
                    } while (!Intrinsics.areEqual(((WeakReference) it.next()).get(), videoPlayerListener));
                    Unit unit = Unit.INSTANCE;
                }
                this.listeners.add(new WeakReference(videoPlayerListener));
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void removeListener(final VideoPlayerListener videoPlayerListener) {
        Intrinsics.checkNotNullParameter(videoPlayerListener, "videoPlayerListener");
        synchronized (this.listeners) {
            CollectionsKt.removeAll(this.listeners, new Function1() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(VideoPlayer.removeListener$lambda$17$lambda$16(videoPlayerListener, (WeakReference) obj));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeListener$lambda$17$lambda$16(VideoPlayerListener videoPlayerListener, WeakReference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.get(), videoPlayerListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(PlayerEvent event) {
        ArrayList arrayList;
        synchronized (this.listeners) {
            List list = this.listeners;
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                VideoPlayerListener videoPlayerListener = (VideoPlayerListener) ((WeakReference) it.next()).get();
                if (videoPlayerListener != null) {
                    arrayList.add(videoPlayerListener);
                }
            }
        }
        event.emit(this, arrayList);
        if (event.getEmitToJS()) {
            emit(event.getName(), event.getJsEventPayload());
        }
    }

    private final FirstFrameEventGenerator createFirstFrameEventGenerator() throws Exceptions$AppContextLost {
        AppContext appContext = getAppContext();
        if (appContext == null) {
            throw new Exceptions$AppContextLost();
        }
        return new FirstFrameEventGenerator(appContext, this, this.currentVideoViewRef, new Function0() { // from class: expo.modules.video.player.VideoPlayer$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return VideoPlayer.createFirstFrameEventGenerator$lambda$20(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createFirstFrameEventGenerator$lambda$20(VideoPlayer videoPlayer) {
        videoPlayer.sendEvent(new PlayerEvent.RenderedFirstFrame());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.video.player.VideoPlayer$emitTimeUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C11111 extends SuspendLambda implements Function2 {
        int label;

        C11111(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return VideoPlayer.this.new C11111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            VideoPlayer.this.sendEvent(new PlayerEvent.TimeUpdated(new TimeUpdate(VideoPlayer.this.getPlayer().getCurrentPosition() / 1000.0d, VideoPlayer.this.getCurrentOffsetFromLive(), VideoPlayer.this.getCurrentLiveTimestamp(), VideoPlayer.this.getBufferedPosition())));
            return Unit.INSTANCE;
        }
    }

    @Override // expo.modules.video.IntervalUpdateEmitter
    public void emitTimeUpdate() {
        CoroutineScope mainQueue;
        AppContext appContext = getAppContext();
        if (appContext == null || (mainQueue = appContext.getMainQueue()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(mainQueue, null, null, new C11111(null), 3, null);
    }

    public final MediaMetadataRetriever toMetadataRetriever() throws IOException {
        Uri uri;
        VideoSource commitedSource = this.uncommittedSource;
        if (commitedSource == null) {
            commitedSource = getCommitedSource();
        }
        if (commitedSource == null || (uri = commitedSource.getUri()) == null) {
            throw new IllegalStateException("Video source is not set");
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (URLUtil.isFileUrl(string)) {
            mediaMetadataRetriever.setDataSource(StringsKt.replace$default(string, "file://", "", false, 4, (Object) null));
            return mediaMetadataRetriever;
        }
        if (URLUtil.isContentUrl(string)) {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.context.getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                return mediaMetadataRetriever;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    mediaMetadataRetriever.setDataSource(fileInputStream.getFD());
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    CloseableKt.closeFinally(parcelFileDescriptorOpenFileDescriptor, null);
                    return mediaMetadataRetriever;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(parcelFileDescriptorOpenFileDescriptor, th3);
                    throw th4;
                }
            }
        }
        Map<String, String> headers = commitedSource.getHeaders();
        if (headers == null) {
            headers = MapsKt.emptyMap();
        }
        mediaMetadataRetriever.setDataSource(string, headers);
        return mediaMetadataRetriever;
    }
}
