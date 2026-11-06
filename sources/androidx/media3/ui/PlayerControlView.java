package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.Format;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PlayerControlView extends FrameLayout {
    private static final float[] PLAYBACK_SPEEDS;
    private long[] adGroupTimesMs;
    private final View audioTrackButton;
    private final AudioTrackSelectionAdapter audioTrackSelectionAdapter;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final ComponentListener componentListener;
    private final Class compositionPlayerClazz;
    private final Method compositionPlayerIsScrubbingModeEnabledMethod;
    private final Method compositionPlayerSetScrubbingModeEnabledMethod;
    private final PlayerControlViewLayoutManager controlViewLayoutManager;
    private long currentWindowOffset;
    private final TextView durationView;
    private final Class exoplayerClazz;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    private final View fastForwardButton;
    private final TextView fastForwardButtonTextView;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final ImageView fullscreenButton;
    private final String fullscreenEnterContentDescription;
    private final Drawable fullscreenEnterDrawable;
    private final String fullscreenExitContentDescription;
    private final Drawable fullscreenExitDrawable;
    private boolean isAttachedToWindow;
    private boolean isFullscreen;
    private final Method isScrubbingModeEnabledMethod;
    private final ImageView minimalFullscreenButton;
    private boolean multiWindowTimeBar;
    private boolean needToHideBars;
    private final ImageView nextButton;
    private OnFullScreenModeChangedListener onFullScreenModeChangedListener;
    private final Drawable pauseButtonDrawable;
    private final Timeline.Period period;
    private final Drawable playButtonDrawable;
    private final ImageView playPauseButton;
    private final PlaybackSpeedAdapter playbackSpeedAdapter;
    private final View playbackSpeedButton;
    private boolean[] playedAdGroups;
    private Player player;
    private final TextView positionView;
    private final ImageView previousButton;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private final Resources resources;
    private final View rewindButton;
    private final TextView rewindButtonTextView;
    private boolean scrubbing;
    private final Method setScrubbingModeEnabledMethod;
    private final SettingsAdapter settingsAdapter;
    private final View settingsButton;
    private final RecyclerView settingsView;
    private final PopupWindow settingsWindow;
    private final int settingsWindowMargin;
    private boolean showMultiWindowTimeBar;
    private boolean showPlayButtonIfSuppressed;
    private int showTimeoutMs;
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private final ImageView subtitleButton;
    private final Drawable subtitleOffButtonDrawable;
    private final String subtitleOffContentDescription;
    private final Drawable subtitleOnButtonDrawable;
    private final String subtitleOnContentDescription;
    private final TextTrackSelectionAdapter textTrackSelectionAdapter;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private boolean timeBarScrubbingEnabled;
    private final TrackNameProvider trackNameProvider;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList visibilityListeners;
    private final ImageView vrButton;
    private final Timeline.Window window;

    public interface OnFullScreenModeChangedListener {
        void onFullScreenModeChanged(boolean z);
    }

    public interface ProgressUpdateListener {
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    private static boolean isHandledMediaKey(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    public void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener) {
    }

    static {
        MediaLibraryInfo.registerModule("media3.ui");
        PLAYBACK_SPEEDS = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:100:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:41:0x0277  */
    /* JADX WARN: Code duplicated, block: B:44:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:50:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:53:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:54:0x02fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:56:0x034e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0370  */
    /* JADX WARN: Code duplicated, block: B:62:0x0387  */
    /* JADX WARN: Code duplicated, block: B:65:0x0398  */
    /* JADX WARN: Code duplicated, block: B:68:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:71:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x03e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:74:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:77:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:80:0x0409  */
    /* JADX WARN: Code duplicated, block: B:81:0x0415 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0417  */
    /* JADX WARN: Code duplicated, block: B:83:0x041f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0427  */
    /* JADX WARN: Code duplicated, block: B:89:0x0438  */
    /* JADX WARN: Code duplicated, block: B:92:0x0449  */
    /* JADX WARN: Code duplicated, block: B:95:0x0470  */
    /* JADX WARN: Code duplicated, block: B:96:0x047c  */
    /* JADX WARN: Code duplicated, block: B:99:0x05e0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [androidx.media3.ui.TimeBar] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.view.View, android.view.ViewGroup, android.widget.TextView, androidx.media3.ui.PlayerControlView$1] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.LayoutInflater] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 3 */
    public PlayerControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) throws Throwable {
        final PlayerControlView playerControlView;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i9;
        boolean z5;
        boolean z6;
        boolean z7;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z8;
        String str;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Class<?> cls;
        Method method5;
        ImageView imageView;
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        TimeBar timeBar;
        View viewFindViewById4;
        int i17;
        ImageView imageView2;
        final PlayerControlView playerControlView2;
        Context context2;
        ?? r10;
        TimeBar timeBar2;
        Resources resources;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        Typeface font;
        ImageView imageView6;
        TextView textView;
        View view;
        ImageView imageView7;
        TextView textView2;
        View view2;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        boolean z9;
        super(context, attributeSet, i);
        Class cls2 = Boolean.TYPE;
        int i18 = R$layout.exo_player_control_view;
        int i19 = R$drawable.exo_styled_controls_play;
        int i20 = R$drawable.exo_styled_controls_pause;
        int i21 = R$drawable.exo_styled_controls_next;
        int i22 = R$drawable.exo_styled_controls_simple_fastforward;
        int i23 = R$drawable.exo_styled_controls_previous;
        int resourceId = R$drawable.exo_styled_controls_simple_rewind;
        int i24 = R$drawable.exo_styled_controls_fullscreen_exit;
        int i25 = R$drawable.exo_styled_controls_fullscreen_enter;
        int i26 = R$drawable.exo_styled_controls_repeat_off;
        int i27 = R$drawable.exo_styled_controls_repeat_one;
        int i28 = R$drawable.exo_styled_controls_repeat_all;
        String str2 = "isScrubbingModeEnabled";
        int i29 = R$drawable.exo_styled_controls_shuffle_on;
        int i30 = R$drawable.exo_styled_controls_shuffle_off;
        int i31 = R$drawable.exo_styled_controls_subtitle_on;
        int resourceId2 = R$drawable.exo_styled_controls_subtitle_off;
        int i32 = R$drawable.exo_styled_controls_vr;
        this.showPlayButtonIfSuppressed = true;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i, 0);
            try {
                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, i18);
                int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_play_icon, i19);
                int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_pause_icon, i20);
                int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_next_icon, i21);
                int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_fastforward_icon, i22);
                int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_previous_icon, i23);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_rewind_icon, resourceId);
                int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_fullscreen_exit_icon, i24);
                int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_fullscreen_enter_icon, i25);
                int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_repeat_off_icon, i26);
                int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_repeat_one_icon, i27);
                int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_repeat_all_icon, i28);
                int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_shuffle_on_icon, i29);
                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_shuffle_off_icon, i30);
                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_subtitle_on_icon, i31);
                resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_subtitle_off_icon, resourceId2);
                int resourceId17 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_vr_icon, i32);
                playerControlView = this;
                try {
                    playerControlView.showTimeoutMs = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, playerControlView.showTimeoutMs);
                    playerControlView.repeatToggleModes = getRepeatToggleModes(typedArrayObtainStyledAttributes, playerControlView.repeatToggleModes);
                    boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, true);
                    boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, true);
                    z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, true);
                    boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, true);
                    boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, false);
                    boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_subtitle_button, false);
                    boolean z15 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_vr_button, false);
                    playerControlView.timeBarScrubbingEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_time_bar_scrubbing_enabled, false);
                    playerControlView.setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, playerControlView.timeBarMinUpdateIntervalMs));
                    boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_animation_enabled, true);
                    typedArrayObtainStyledAttributes.recycle();
                    i3 = resourceId7;
                    i4 = resourceId9;
                    i5 = resourceId8;
                    i6 = resourceId10;
                    z3 = z10;
                    z7 = z13;
                    z4 = z11;
                    z = z12;
                    z8 = z16;
                    i11 = resourceId11;
                    i12 = resourceId6;
                    i13 = resourceId12;
                    i14 = resourceId5;
                    i15 = resourceId4;
                    i16 = resourceId3;
                    z5 = z15;
                    i9 = resourceId13;
                    i7 = resourceId16;
                    i2 = resourceId15;
                    i10 = resourceId17;
                    z6 = z14;
                    i8 = resourceId14;
                } catch (Throwable th) {
                    th = th;
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            playerControlView = this;
            i2 = i30;
            i3 = i22;
            i4 = i24;
            i5 = i23;
            i6 = i25;
            i7 = i31;
            i8 = i29;
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            i9 = i28;
            z5 = false;
            z6 = false;
            z7 = false;
            i10 = i32;
            i11 = i26;
            i12 = i21;
            i13 = i27;
            i14 = i20;
            i15 = i19;
            i16 = i18;
            z8 = true;
        }
        LayoutInflater.from(context).inflate(i16, playerControlView);
        playerControlView.setDescendantFocusability(262144);
        playerControlView.componentListener = new ComponentListener();
        playerControlView.visibilityListeners = new CopyOnWriteArrayList();
        playerControlView.period = new Timeline.Period();
        playerControlView.window = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        playerControlView.formatBuilder = sb;
        int i33 = i10;
        playerControlView.formatter = new Formatter(sb, Locale.getDefault());
        playerControlView.adGroupTimesMs = new long[0];
        playerControlView.playedAdGroups = new boolean[0];
        playerControlView.extraAdGroupTimesMs = new long[0];
        playerControlView.extraPlayedAdGroups = new boolean[0];
        playerControlView.updateProgressAction = new Runnable() { // from class: androidx.media3.ui.PlayerControlView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateProgress();
            }
        };
        try {
            Class[] clsArr = {cls2};
            str = "setScrubbingModeEnabled";
            try {
                try {
                    method = ExoPlayer.class.getMethod(str, clsArr);
                    str2 = str2;
                    try {
                        method2 = ExoPlayer.class.getMethod(str2, null);
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        method2 = null;
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                    method = null;
                    method2 = null;
                    Method method6 = method;
                    playerControlView.exoplayerClazz = ExoPlayer.class;
                    playerControlView.setScrubbingModeEnabledMethod = method6;
                    playerControlView.isScrubbingModeEnabledMethod = method2;
                    cls = Class.forName("androidx.media3.transformer.CompositionPlayer");
                    method4 = cls.getMethod(str, cls2);
                    method3 = null;
                    try {
                        method5 = cls.getMethod(str2, null);
                    } catch (ClassNotFoundException | NoSuchMethodException unused3) {
                        method5 = method3;
                    }
                    playerControlView.compositionPlayerClazz = cls;
                    playerControlView.compositionPlayerSetScrubbingModeEnabledMethod = method4;
                    playerControlView.compositionPlayerIsScrubbingModeEnabledMethod = method5;
                    playerControlView.durationView = (TextView) playerControlView.findViewById(R$id.exo_duration);
                    playerControlView.positionView = (TextView) playerControlView.findViewById(R$id.exo_position);
                    imageView = (ImageView) playerControlView.findViewById(R$id.exo_subtitle);
                    playerControlView.subtitleButton = imageView;
                    if (imageView != null) {
                        imageView.setOnClickListener(playerControlView.componentListener);
                    }
                    ImageView imageView11 = (ImageView) playerControlView.findViewById(R$id.exo_fullscreen);
                    playerControlView.fullscreenButton = imageView11;
                    initializeFullscreenButton(imageView11, new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            this.f$0.onFullscreenButtonClicked(view3);
                        }
                    });
                    ImageView imageView12 = (ImageView) playerControlView.findViewById(R$id.exo_minimal_fullscreen);
                    playerControlView.minimalFullscreenButton = imageView12;
                    initializeFullscreenButton(imageView12, new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            this.f$0.onFullscreenButtonClicked(view3);
                        }
                    });
                    viewFindViewById = playerControlView.findViewById(R$id.exo_settings);
                    playerControlView.settingsButton = viewFindViewById;
                    if (viewFindViewById != null) {
                        viewFindViewById.setOnClickListener(playerControlView.componentListener);
                    }
                    viewFindViewById2 = playerControlView.findViewById(R$id.exo_playback_speed);
                    playerControlView.playbackSpeedButton = viewFindViewById2;
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setOnClickListener(playerControlView.componentListener);
                    }
                    viewFindViewById3 = playerControlView.findViewById(R$id.exo_audio_track);
                    playerControlView.audioTrackButton = viewFindViewById3;
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setOnClickListener(playerControlView.componentListener);
                    }
                    timeBar = (TimeBar) playerControlView.findViewById(R$id.exo_progress);
                    viewFindViewById4 = playerControlView.findViewById(R$id.exo_progress_placeholder);
                    if (timeBar != null) {
                        playerControlView.timeBar = timeBar;
                        i17 = resourceId2;
                        imageView2 = imageView;
                        playerControlView2 = playerControlView;
                        r10 = method3;
                        context2 = context;
                    } else if (viewFindViewById4 != null) {
                        i17 = resourceId2;
                        imageView2 = imageView;
                        playerControlView2 = this;
                        r10 = method3;
                        context2 = context;
                        DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context2, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
                        defaultTimeBar.setId(R$id.exo_progress);
                        defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
                        ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
                        int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
                        viewGroup.removeView(viewFindViewById4);
                        viewGroup.addView(defaultTimeBar, iIndexOfChild);
                        playerControlView2.timeBar = defaultTimeBar;
                    } else {
                        i17 = resourceId2;
                        imageView2 = imageView;
                        playerControlView2 = playerControlView;
                        ?? r11 = method3;
                        context2 = context;
                        playerControlView2.timeBar = r11;
                        r10 = r11;
                    }
                    timeBar2 = playerControlView2.timeBar;
                    if (timeBar2 != null) {
                        timeBar2.addListener(playerControlView2.componentListener);
                    }
                    resources = context2.getResources();
                    playerControlView2.resources = resources;
                    imageView3 = (ImageView) playerControlView2.findViewById(R$id.exo_play_pause);
                    playerControlView2.playPauseButton = imageView3;
                    if (imageView3 != null) {
                        imageView3.setOnClickListener(playerControlView2.componentListener);
                    }
                    imageView4 = (ImageView) playerControlView2.findViewById(R$id.exo_prev);
                    playerControlView2.previousButton = imageView4;
                    if (imageView4 != null) {
                        imageView4.setImageDrawable(Util.getDrawable(context2, resources, i5));
                        imageView4.setOnClickListener(playerControlView2.componentListener);
                    }
                    imageView5 = (ImageView) playerControlView2.findViewById(R$id.exo_next);
                    playerControlView2.nextButton = imageView5;
                    if (imageView5 != null) {
                        imageView5.setImageDrawable(Util.getDrawable(context2, resources, i12));
                        imageView5.setOnClickListener(playerControlView2.componentListener);
                    }
                    font = ResourcesCompat.getFont(context2, R$font.roboto_medium_numbers);
                    imageView6 = (ImageView) playerControlView2.findViewById(R$id.exo_rew);
                    textView = (TextView) playerControlView2.findViewById(R$id.exo_rew_with_amount);
                    if (imageView6 != null) {
                        imageView6.setImageDrawable(Util.getDrawable(context2, resources, resourceId));
                        playerControlView2.rewindButton = imageView6;
                        playerControlView2.rewindButtonTextView = r10;
                    } else if (textView != null) {
                        textView.setTypeface(font);
                        playerControlView2.rewindButtonTextView = textView;
                        playerControlView2.rewindButton = textView;
                    } else {
                        playerControlView2.rewindButtonTextView = r10;
                        playerControlView2.rewindButton = r10;
                    }
                    view = playerControlView2.rewindButton;
                    if (view != null) {
                        view.setOnClickListener(playerControlView2.componentListener);
                    }
                    imageView7 = (ImageView) playerControlView2.findViewById(R$id.exo_ffwd);
                    textView2 = (TextView) playerControlView2.findViewById(R$id.exo_ffwd_with_amount);
                    if (imageView7 != null) {
                        imageView7.setImageDrawable(Util.getDrawable(context2, resources, i3));
                        playerControlView2.fastForwardButton = imageView7;
                        playerControlView2.fastForwardButtonTextView = r10;
                    } else if (textView2 != null) {
                        textView2.setTypeface(font);
                        playerControlView2.fastForwardButtonTextView = textView2;
                        playerControlView2.fastForwardButton = textView2;
                    } else {
                        playerControlView2.fastForwardButtonTextView = r10;
                        playerControlView2.fastForwardButton = r10;
                    }
                    view2 = playerControlView2.fastForwardButton;
                    if (view2 != null) {
                        view2.setOnClickListener(playerControlView2.componentListener);
                    }
                    imageView8 = (ImageView) playerControlView2.findViewById(R$id.exo_repeat_toggle);
                    playerControlView2.repeatToggleButton = imageView8;
                    if (imageView8 != null) {
                        imageView8.setOnClickListener(playerControlView2.componentListener);
                    }
                    imageView9 = (ImageView) playerControlView2.findViewById(R$id.exo_shuffle);
                    playerControlView2.shuffleButton = imageView9;
                    if (imageView9 != null) {
                        imageView9.setOnClickListener(playerControlView2.componentListener);
                    }
                    playerControlView2.buttonAlphaEnabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
                    playerControlView2.buttonAlphaDisabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
                    imageView10 = (ImageView) playerControlView2.findViewById(R$id.exo_vr);
                    playerControlView2.vrButton = imageView10;
                    if (imageView10 != null) {
                        imageView10.setImageDrawable(Util.getDrawable(context2, resources, i33));
                        playerControlView2.updateButton(false, imageView10);
                    }
                    PlayerControlViewLayoutManager playerControlViewLayoutManager = new PlayerControlViewLayoutManager(playerControlView2);
                    playerControlView2.controlViewLayoutManager = playerControlViewLayoutManager;
                    playerControlViewLayoutManager.setAnimationEnabled(z8);
                    SettingsAdapter settingsAdapter = playerControlView2.new SettingsAdapter(new String[]{resources.getString(R$string.exo_controls_playback_speed), resources.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{Util.getDrawable(context2, resources, R$drawable.exo_styled_controls_speed), Util.getDrawable(context2, resources, R$drawable.exo_styled_controls_audiotrack)});
                    playerControlView2.settingsAdapter = settingsAdapter;
                    playerControlView2.settingsWindowMargin = resources.getDimensionPixelSize(R$dimen.exo_settings_offset);
                    RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context2).inflate(R$layout.exo_styled_settings_list, r10);
                    playerControlView2.settingsView = recyclerView;
                    recyclerView.setAdapter(settingsAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(playerControlView2.getContext()));
                    PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
                    playerControlView2.settingsWindow = popupWindow;
                    popupWindow.setOnDismissListener(playerControlView2.componentListener);
                    playerControlView2.needToHideBars = true;
                    playerControlView2.trackNameProvider = new DefaultTrackNameProvider(playerControlView2.getResources());
                    playerControlView2.subtitleOnButtonDrawable = Util.getDrawable(context2, resources, i7);
                    playerControlView2.subtitleOffButtonDrawable = Util.getDrawable(context2, resources, i17);
                    playerControlView2.subtitleOnContentDescription = resources.getString(R$string.exo_controls_cc_enabled_description);
                    playerControlView2.subtitleOffContentDescription = resources.getString(R$string.exo_controls_cc_disabled_description);
                    playerControlView2.textTrackSelectionAdapter = new TextTrackSelectionAdapter();
                    playerControlView2.audioTrackSelectionAdapter = new AudioTrackSelectionAdapter();
                    playerControlView2.playbackSpeedAdapter = playerControlView2.new PlaybackSpeedAdapter(resources.getStringArray(R$array.exo_controls_playback_speeds), PLAYBACK_SPEEDS);
                    playerControlView2.playButtonDrawable = Util.getDrawable(context2, resources, i15);
                    playerControlView2.pauseButtonDrawable = Util.getDrawable(context2, resources, i14);
                    playerControlView2.fullscreenExitDrawable = Util.getDrawable(context2, resources, i4);
                    playerControlView2.fullscreenEnterDrawable = Util.getDrawable(context2, resources, i6);
                    playerControlView2.repeatOffButtonDrawable = Util.getDrawable(context2, resources, i11);
                    playerControlView2.repeatOneButtonDrawable = Util.getDrawable(context2, resources, i13);
                    playerControlView2.repeatAllButtonDrawable = Util.getDrawable(context2, resources, i9);
                    playerControlView2.shuffleOnButtonDrawable = Util.getDrawable(context2, resources, i8);
                    playerControlView2.shuffleOffButtonDrawable = Util.getDrawable(context2, resources, i2);
                    playerControlView2.fullscreenExitContentDescription = resources.getString(R$string.exo_controls_fullscreen_exit_description);
                    playerControlView2.fullscreenEnterContentDescription = resources.getString(R$string.exo_controls_fullscreen_enter_description);
                    playerControlView2.repeatOffButtonContentDescription = resources.getString(R$string.exo_controls_repeat_off_description);
                    playerControlView2.repeatOneButtonContentDescription = resources.getString(R$string.exo_controls_repeat_one_description);
                    playerControlView2.repeatAllButtonContentDescription = resources.getString(R$string.exo_controls_repeat_all_description);
                    playerControlView2.shuffleOnContentDescription = resources.getString(R$string.exo_controls_shuffle_on_description);
                    playerControlView2.shuffleOffContentDescription = resources.getString(R$string.exo_controls_shuffle_off_description);
                    playerControlViewLayoutManager.setShowButton((ViewGroup) playerControlView2.findViewById(R$id.exo_bottom_bar), true);
                    playerControlViewLayoutManager.setShowButton(playerControlView2.fastForwardButton, z4);
                    playerControlViewLayoutManager.setShowButton(playerControlView2.rewindButton, z3);
                    playerControlViewLayoutManager.setShowButton(imageView4, z2);
                    playerControlViewLayoutManager.setShowButton(imageView5, z);
                    playerControlViewLayoutManager.setShowButton(imageView9, z7);
                    playerControlViewLayoutManager.setShowButton(imageView2, z6);
                    playerControlViewLayoutManager.setShowButton(imageView10, z5);
                    if (playerControlView2.repeatToggleModes != 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    playerControlViewLayoutManager.setShowButton(imageView8, z9);
                    playerControlView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.media3.ui.PlayerControlView$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view3, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41) {
                            this.f$0.onLayoutChange(view3, i34, i35, i36, i37, i38, i39, i40, i41);
                        }
                    });
                }
                cls = Class.forName("androidx.media3.transformer.CompositionPlayer");
                try {
                    method4 = cls.getMethod(str, cls2);
                    method3 = null;
                    method5 = cls.getMethod(str2, null);
                } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    method3 = null;
                    method4 = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                method3 = null;
                method4 = null;
                cls = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused6) {
            str = "setScrubbingModeEnabled";
        }
        Method method7 = method;
        playerControlView.exoplayerClazz = ExoPlayer.class;
        playerControlView.setScrubbingModeEnabledMethod = method7;
        playerControlView.isScrubbingModeEnabledMethod = method2;
        playerControlView.compositionPlayerClazz = cls;
        playerControlView.compositionPlayerSetScrubbingModeEnabledMethod = method4;
        playerControlView.compositionPlayerIsScrubbingModeEnabledMethod = method5;
        playerControlView.durationView = (TextView) playerControlView.findViewById(R$id.exo_duration);
        playerControlView.positionView = (TextView) playerControlView.findViewById(R$id.exo_position);
        imageView = (ImageView) playerControlView.findViewById(R$id.exo_subtitle);
        playerControlView.subtitleButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(playerControlView.componentListener);
        }
        ImageView imageView13 = (ImageView) playerControlView.findViewById(R$id.exo_fullscreen);
        playerControlView.fullscreenButton = imageView13;
        initializeFullscreenButton(imageView13, new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.onFullscreenButtonClicked(view3);
            }
        });
        ImageView imageView14 = (ImageView) playerControlView.findViewById(R$id.exo_minimal_fullscreen);
        playerControlView.minimalFullscreenButton = imageView14;
        initializeFullscreenButton(imageView14, new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.onFullscreenButtonClicked(view3);
            }
        });
        viewFindViewById = playerControlView.findViewById(R$id.exo_settings);
        playerControlView.settingsButton = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(playerControlView.componentListener);
        }
        viewFindViewById2 = playerControlView.findViewById(R$id.exo_playback_speed);
        playerControlView.playbackSpeedButton = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(playerControlView.componentListener);
        }
        viewFindViewById3 = playerControlView.findViewById(R$id.exo_audio_track);
        playerControlView.audioTrackButton = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(playerControlView.componentListener);
        }
        timeBar = (TimeBar) playerControlView.findViewById(R$id.exo_progress);
        viewFindViewById4 = playerControlView.findViewById(R$id.exo_progress_placeholder);
        if (timeBar != null) {
            playerControlView.timeBar = timeBar;
            i17 = resourceId2;
            imageView2 = imageView;
            playerControlView2 = playerControlView;
            r10 = method3;
            context2 = context;
        } else if (viewFindViewById4 != null) {
            i17 = resourceId2;
            imageView2 = imageView;
            playerControlView2 = this;
            r10 = method3;
            context2 = context;
            DefaultTimeBar defaultTimeBar2 = new DefaultTimeBar(context2, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar2.setId(R$id.exo_progress);
            defaultTimeBar2.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup2 = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild2 = viewGroup2.indexOfChild(viewFindViewById4);
            viewGroup2.removeView(viewFindViewById4);
            viewGroup2.addView(defaultTimeBar2, iIndexOfChild2);
            playerControlView2.timeBar = defaultTimeBar2;
        } else {
            i17 = resourceId2;
            imageView2 = imageView;
            playerControlView2 = playerControlView;
            ?? r12 = method3;
            context2 = context;
            playerControlView2.timeBar = r12;
            r10 = r12;
        }
        timeBar2 = playerControlView2.timeBar;
        if (timeBar2 != null) {
            timeBar2.addListener(playerControlView2.componentListener);
        }
        resources = context2.getResources();
        playerControlView2.resources = resources;
        imageView3 = (ImageView) playerControlView2.findViewById(R$id.exo_play_pause);
        playerControlView2.playPauseButton = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(playerControlView2.componentListener);
        }
        imageView4 = (ImageView) playerControlView2.findViewById(R$id.exo_prev);
        playerControlView2.previousButton = imageView4;
        if (imageView4 != null) {
            imageView4.setImageDrawable(Util.getDrawable(context2, resources, i5));
            imageView4.setOnClickListener(playerControlView2.componentListener);
        }
        imageView5 = (ImageView) playerControlView2.findViewById(R$id.exo_next);
        playerControlView2.nextButton = imageView5;
        if (imageView5 != null) {
            imageView5.setImageDrawable(Util.getDrawable(context2, resources, i12));
            imageView5.setOnClickListener(playerControlView2.componentListener);
        }
        font = ResourcesCompat.getFont(context2, R$font.roboto_medium_numbers);
        imageView6 = (ImageView) playerControlView2.findViewById(R$id.exo_rew);
        textView = (TextView) playerControlView2.findViewById(R$id.exo_rew_with_amount);
        if (imageView6 != null) {
            imageView6.setImageDrawable(Util.getDrawable(context2, resources, resourceId));
            playerControlView2.rewindButton = imageView6;
            playerControlView2.rewindButtonTextView = r10;
        } else if (textView != null) {
            textView.setTypeface(font);
            playerControlView2.rewindButtonTextView = textView;
            playerControlView2.rewindButton = textView;
        } else {
            playerControlView2.rewindButtonTextView = r10;
            playerControlView2.rewindButton = r10;
        }
        view = playerControlView2.rewindButton;
        if (view != null) {
            view.setOnClickListener(playerControlView2.componentListener);
        }
        imageView7 = (ImageView) playerControlView2.findViewById(R$id.exo_ffwd);
        textView2 = (TextView) playerControlView2.findViewById(R$id.exo_ffwd_with_amount);
        if (imageView7 != null) {
            imageView7.setImageDrawable(Util.getDrawable(context2, resources, i3));
            playerControlView2.fastForwardButton = imageView7;
            playerControlView2.fastForwardButtonTextView = r10;
        } else if (textView2 != null) {
            textView2.setTypeface(font);
            playerControlView2.fastForwardButtonTextView = textView2;
            playerControlView2.fastForwardButton = textView2;
        } else {
            playerControlView2.fastForwardButtonTextView = r10;
            playerControlView2.fastForwardButton = r10;
        }
        view2 = playerControlView2.fastForwardButton;
        if (view2 != null) {
            view2.setOnClickListener(playerControlView2.componentListener);
        }
        imageView8 = (ImageView) playerControlView2.findViewById(R$id.exo_repeat_toggle);
        playerControlView2.repeatToggleButton = imageView8;
        if (imageView8 != null) {
            imageView8.setOnClickListener(playerControlView2.componentListener);
        }
        imageView9 = (ImageView) playerControlView2.findViewById(R$id.exo_shuffle);
        playerControlView2.shuffleButton = imageView9;
        if (imageView9 != null) {
            imageView9.setOnClickListener(playerControlView2.componentListener);
        }
        playerControlView2.buttonAlphaEnabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        playerControlView2.buttonAlphaDisabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        imageView10 = (ImageView) playerControlView2.findViewById(R$id.exo_vr);
        playerControlView2.vrButton = imageView10;
        if (imageView10 != null) {
            imageView10.setImageDrawable(Util.getDrawable(context2, resources, i33));
            playerControlView2.updateButton(false, imageView10);
        }
        PlayerControlViewLayoutManager playerControlViewLayoutManager2 = new PlayerControlViewLayoutManager(playerControlView2);
        playerControlView2.controlViewLayoutManager = playerControlViewLayoutManager2;
        playerControlViewLayoutManager2.setAnimationEnabled(z8);
        SettingsAdapter settingsAdapter2 = playerControlView2.new SettingsAdapter(new String[]{resources.getString(R$string.exo_controls_playback_speed), resources.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{Util.getDrawable(context2, resources, R$drawable.exo_styled_controls_speed), Util.getDrawable(context2, resources, R$drawable.exo_styled_controls_audiotrack)});
        playerControlView2.settingsAdapter = settingsAdapter2;
        playerControlView2.settingsWindowMargin = resources.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView2 = (RecyclerView) LayoutInflater.from(context2).inflate(R$layout.exo_styled_settings_list, r10);
        playerControlView2.settingsView = recyclerView2;
        recyclerView2.setAdapter(settingsAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(playerControlView2.getContext()));
        PopupWindow popupWindow2 = new PopupWindow((View) recyclerView2, -2, -2, true);
        playerControlView2.settingsWindow = popupWindow2;
        popupWindow2.setOnDismissListener(playerControlView2.componentListener);
        playerControlView2.needToHideBars = true;
        playerControlView2.trackNameProvider = new DefaultTrackNameProvider(playerControlView2.getResources());
        playerControlView2.subtitleOnButtonDrawable = Util.getDrawable(context2, resources, i7);
        playerControlView2.subtitleOffButtonDrawable = Util.getDrawable(context2, resources, i17);
        playerControlView2.subtitleOnContentDescription = resources.getString(R$string.exo_controls_cc_enabled_description);
        playerControlView2.subtitleOffContentDescription = resources.getString(R$string.exo_controls_cc_disabled_description);
        playerControlView2.textTrackSelectionAdapter = new TextTrackSelectionAdapter();
        playerControlView2.audioTrackSelectionAdapter = new AudioTrackSelectionAdapter();
        playerControlView2.playbackSpeedAdapter = playerControlView2.new PlaybackSpeedAdapter(resources.getStringArray(R$array.exo_controls_playback_speeds), PLAYBACK_SPEEDS);
        playerControlView2.playButtonDrawable = Util.getDrawable(context2, resources, i15);
        playerControlView2.pauseButtonDrawable = Util.getDrawable(context2, resources, i14);
        playerControlView2.fullscreenExitDrawable = Util.getDrawable(context2, resources, i4);
        playerControlView2.fullscreenEnterDrawable = Util.getDrawable(context2, resources, i6);
        playerControlView2.repeatOffButtonDrawable = Util.getDrawable(context2, resources, i11);
        playerControlView2.repeatOneButtonDrawable = Util.getDrawable(context2, resources, i13);
        playerControlView2.repeatAllButtonDrawable = Util.getDrawable(context2, resources, i9);
        playerControlView2.shuffleOnButtonDrawable = Util.getDrawable(context2, resources, i8);
        playerControlView2.shuffleOffButtonDrawable = Util.getDrawable(context2, resources, i2);
        playerControlView2.fullscreenExitContentDescription = resources.getString(R$string.exo_controls_fullscreen_exit_description);
        playerControlView2.fullscreenEnterContentDescription = resources.getString(R$string.exo_controls_fullscreen_enter_description);
        playerControlView2.repeatOffButtonContentDescription = resources.getString(R$string.exo_controls_repeat_off_description);
        playerControlView2.repeatOneButtonContentDescription = resources.getString(R$string.exo_controls_repeat_one_description);
        playerControlView2.repeatAllButtonContentDescription = resources.getString(R$string.exo_controls_repeat_all_description);
        playerControlView2.shuffleOnContentDescription = resources.getString(R$string.exo_controls_shuffle_on_description);
        playerControlView2.shuffleOffContentDescription = resources.getString(R$string.exo_controls_shuffle_off_description);
        playerControlViewLayoutManager2.setShowButton((ViewGroup) playerControlView2.findViewById(R$id.exo_bottom_bar), true);
        playerControlViewLayoutManager2.setShowButton(playerControlView2.fastForwardButton, z4);
        playerControlViewLayoutManager2.setShowButton(playerControlView2.rewindButton, z3);
        playerControlViewLayoutManager2.setShowButton(imageView4, z2);
        playerControlViewLayoutManager2.setShowButton(imageView5, z);
        playerControlViewLayoutManager2.setShowButton(imageView9, z7);
        playerControlViewLayoutManager2.setShowButton(imageView2, z6);
        playerControlViewLayoutManager2.setShowButton(imageView10, z5);
        if (playerControlView2.repeatToggleModes != 0) {
            z9 = true;
        } else {
            z9 = false;
        }
        playerControlViewLayoutManager2.setShowButton(imageView8, z9);
        playerControlView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.media3.ui.PlayerControlView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view3, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41) {
                this.f$0.onLayoutChange(view3, i34, i35, i36, i37, i38, i39, i40, i41);
            }
        });
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        Assertions.checkArgument(player == null || player.getApplicationLooper() == Looper.getMainLooper());
        Player player2 = this.player;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.componentListener);
        }
        this.player = player;
        if (player != null) {
            player.addListener(this.componentListener);
        }
        updateAll();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        updateTimeline();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        this.showPlayButtonIfSuppressed = z;
        updatePlayPauseButton();
    }

    public void addVisibilityListener(VisibilityListener visibilityListener) {
        Assertions.checkNotNull(visibilityListener);
        this.visibilityListeners.add(visibilityListener);
    }

    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.visibilityListeners.remove(visibilityListener);
    }

    public void setShowRewindButton(boolean z) {
        this.controlViewLayoutManager.setShowButton(this.rewindButton, z);
        updateNavigation();
    }

    public void setShowFastForwardButton(boolean z) {
        this.controlViewLayoutManager.setShowButton(this.fastForwardButton, z);
        updateNavigation();
    }

    public void setShowPreviousButton(boolean z) {
        this.controlViewLayoutManager.setShowButton(this.previousButton, z);
        updateNavigation();
    }

    public void setShowNextButton(boolean z) {
        this.controlViewLayoutManager.setShowButton(this.nextButton, z);
        updateNavigation();
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public void setShowTimeoutMs(int i) {
        this.showTimeoutMs = i;
        if (isFullyVisible()) {
            this.controlViewLayoutManager.resetHideCallbacks();
        }
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public void setRepeatToggleModes(int i) {
        this.repeatToggleModes = i;
        Player player = this.player;
        if (player != null && player.isCommandAvailable(15)) {
            int repeatMode = this.player.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.player.setRepeatMode(0);
            } else if (i == 1 && repeatMode == 2) {
                this.player.setRepeatMode(1);
            } else if (i == 2 && repeatMode == 1) {
                this.player.setRepeatMode(2);
            }
        }
        this.controlViewLayoutManager.setShowButton(this.repeatToggleButton, i != 0);
        updateRepeatModeButton();
    }

    public boolean getShowShuffleButton() {
        return this.controlViewLayoutManager.getShowButton(this.shuffleButton);
    }

    public void setShowShuffleButton(boolean z) {
        this.controlViewLayoutManager.setShowButton(this.shuffleButton, z);
        updateShuffleButton();
    }

    public boolean getShowSubtitleButton() {
        return this.controlViewLayoutManager.getShowButton(this.subtitleButton);
    }

    public void setShowSubtitleButton(boolean z) {
        this.controlViewLayoutManager.setShowButton(this.subtitleButton, z);
    }

    public boolean getShowVrButton() {
        return this.controlViewLayoutManager.getShowButton(this.vrButton);
    }

    public void setShowVrButton(boolean z) {
        this.controlViewLayoutManager.setShowButton(this.vrButton, z);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.vrButton;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            updateButton(onClickListener != null, this.vrButton);
        }
    }

    public void setAnimationEnabled(boolean z) {
        this.controlViewLayoutManager.setAnimationEnabled(z);
    }

    public void setTimeBarScrubbingEnabled(boolean z) {
        this.timeBarScrubbingEnabled = z;
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.timeBarMinUpdateIntervalMs = Util.constrainValue(i, 16, 1000);
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        this.onFullScreenModeChangedListener = onFullScreenModeChangedListener;
        updateFullscreenButtonVisibility(this.fullscreenButton, onFullScreenModeChangedListener != null);
        updateFullscreenButtonVisibility(this.minimalFullscreenButton, onFullScreenModeChangedListener != null);
    }

    public void show() {
        this.controlViewLayoutManager.show();
    }

    public void hide() {
        this.controlViewLayoutManager.hide();
    }

    public void hideImmediately() {
        this.controlViewLayoutManager.hideImmediately();
    }

    public boolean isFullyVisible() {
        return this.controlViewLayoutManager.isFullyVisible();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    void notifyOnVisibilityChange() {
        Iterator it = this.visibilityListeners.iterator();
        while (it.hasNext()) {
            ((VisibilityListener) it.next()).onVisibilityChange(getVisibility());
        }
    }

    void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTrackLists();
        updatePlaybackSpeedList();
        updateTimeline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        int i;
        if (isVisible() && this.isAttachedToWindow && this.playPauseButton != null) {
            boolean zShouldShowPlayButton = Util.shouldShowPlayButton(this.player, this.showPlayButtonIfSuppressed);
            Drawable drawable = zShouldShowPlayButton ? this.playButtonDrawable : this.pauseButtonDrawable;
            if (zShouldShowPlayButton) {
                i = R$string.exo_controls_play_description;
            } else {
                i = R$string.exo_controls_pause_description;
            }
            this.playPauseButton.setImageDrawable(drawable);
            this.playPauseButton.setContentDescription(this.resources.getString(i));
            updateButton(Util.shouldEnablePlayPauseButton(this.player), this.playPauseButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNavigation() {
        boolean zIsCommandAvailable;
        boolean zIsCommandAvailable2;
        boolean zIsCommandAvailable3;
        boolean zIsCommandAvailable4;
        boolean zIsCommandAvailable5;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            if (player != null) {
                if (this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player, this.window)) {
                    zIsCommandAvailable = player.isCommandAvailable(10);
                } else {
                    zIsCommandAvailable = player.isCommandAvailable(5);
                }
                zIsCommandAvailable3 = player.isCommandAvailable(7);
                zIsCommandAvailable4 = player.isCommandAvailable(11);
                zIsCommandAvailable5 = player.isCommandAvailable(12);
                zIsCommandAvailable2 = player.isCommandAvailable(9);
            } else {
                zIsCommandAvailable = false;
                zIsCommandAvailable2 = false;
                zIsCommandAvailable3 = false;
                zIsCommandAvailable4 = false;
                zIsCommandAvailable5 = false;
            }
            if (zIsCommandAvailable4) {
                updateRewindButton();
            }
            if (zIsCommandAvailable5) {
                updateFastForwardButton();
            }
            updateButton(zIsCommandAvailable3, this.previousButton);
            updateButton(zIsCommandAvailable4, this.rewindButton);
            updateButton(zIsCommandAvailable5, this.fastForwardButton);
            updateButton(zIsCommandAvailable2, this.nextButton);
            TimeBar timeBar = this.timeBar;
            if (timeBar != null) {
                timeBar.setEnabled(zIsCommandAvailable);
            }
        }
    }

    private void updateRewindButton() {
        Player player = this.player;
        int seekBackIncrement = (int) ((player != null ? player.getSeekBackIncrement() : HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS) / 1000);
        TextView textView = this.rewindButtonTextView;
        if (textView != null) {
            textView.setText(String.valueOf(seekBackIncrement));
        }
        View view = this.rewindButton;
        if (view != null) {
            view.setContentDescription(this.resources.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, seekBackIncrement, Integer.valueOf(seekBackIncrement)));
        }
    }

    private void updateFastForwardButton() {
        Player player = this.player;
        int seekForwardIncrement = (int) ((player != null ? player.getSeekForwardIncrement() : 15000L) / 1000);
        TextView textView = this.fastForwardButtonTextView;
        if (textView != null) {
            textView.setText(String.valueOf(seekForwardIncrement));
        }
        View view = this.fastForwardButton;
        if (view != null) {
            view.setContentDescription(this.resources.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, seekForwardIncrement, Integer.valueOf(seekForwardIncrement)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                updateButton(false, imageView);
                return;
            }
            Player player = this.player;
            if (player == null || !player.isCommandAvailable(15)) {
                updateButton(false, this.repeatToggleButton);
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                return;
            }
            updateButton(true, this.repeatToggleButton);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
            } else if (repeatMode == 1) {
                this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShuffleButton() {
        ImageView imageView;
        String str;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.shuffleButton) != null) {
            Player player = this.player;
            if (!this.controlViewLayoutManager.getShowButton(imageView)) {
                updateButton(false, this.shuffleButton);
                return;
            }
            if (player == null || !player.isCommandAvailable(14)) {
                updateButton(false, this.shuffleButton);
                this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(this.shuffleOffContentDescription);
                return;
            }
            updateButton(true, this.shuffleButton);
            this.shuffleButton.setImageDrawable(player.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable);
            ImageView imageView2 = this.shuffleButton;
            if (player.getShuffleModeEnabled()) {
                str = this.shuffleOnContentDescription;
            } else {
                str = this.shuffleOffContentDescription;
            }
            imageView2.setContentDescription(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrackLists() {
        initTrackSelectionAdapter();
        updateButton(this.textTrackSelectionAdapter.getItemCount() > 0, this.subtitleButton);
        updateSettingsButton();
    }

    private void initTrackSelectionAdapter() {
        this.textTrackSelectionAdapter.clear();
        this.audioTrackSelectionAdapter.clear();
        Player player = this.player;
        if (player != null && player.isCommandAvailable(30) && this.player.isCommandAvailable(29)) {
            Tracks currentTracks = this.player.getCurrentTracks();
            this.audioTrackSelectionAdapter.init(gatherSupportedTrackInfosOfType(currentTracks, 1));
            if (this.controlViewLayoutManager.getShowButton(this.subtitleButton)) {
                this.textTrackSelectionAdapter.init(gatherSupportedTrackInfosOfType(currentTracks, 3));
            } else {
                this.textTrackSelectionAdapter.init(ImmutableList.of());
            }
        }
    }

    private ImmutableList gatherSupportedTrackInfosOfType(Tracks tracks, int i) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList groups = tracks.getGroups();
        for (int i2 = 0; i2 < groups.size(); i2++) {
            Tracks.Group group = (Tracks.Group) groups.get(i2);
            if (group.getType() == i) {
                for (int i3 = 0; i3 < group.length; i3++) {
                    if (group.isTrackSupported(i3)) {
                        Format trackFormat = group.getTrackFormat(i3);
                        if ((trackFormat.selectionFlags & 2) == 0) {
                            builder.add((Object) new TrackInformation(tracks, i2, i3, this.trackNameProvider.getTrackName(trackFormat)));
                        }
                    }
                }
            }
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:62:0x0116  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public void updateTimeline() {
        Timeline currentTimeline;
        int i;
        long jMsToUs;
        Timeline.Window window;
        long j;
        Player player = this.player;
        if (player == null) {
            return;
        }
        boolean z = true;
        this.multiWindowTimeBar = this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player, this.window);
        long j2 = 0;
        this.currentWindowOffset = 0L;
        if (player.isCommandAvailable(17)) {
            currentTimeline = player.getCurrentTimeline();
        } else {
            currentTimeline = Timeline.EMPTY;
        }
        long j3 = -9223372036854775807L;
        if (!currentTimeline.isEmpty()) {
            int currentMediaItemIndex = player.getCurrentMediaItemIndex();
            boolean z2 = this.multiWindowTimeBar;
            int i2 = z2 ? 0 : currentMediaItemIndex;
            int windowCount = z2 ? currentTimeline.getWindowCount() - 1 : currentMediaItemIndex;
            i = 0;
            long j4 = 0;
            while (i2 <= windowCount) {
                if (i2 == currentMediaItemIndex) {
                    this.currentWindowOffset = Util.usToMs(j4);
                }
                currentTimeline.getWindow(i2, this.window);
                Timeline.Window window2 = this.window;
                boolean z3 = z;
                long j5 = j2;
                if (window2.durationUs == j3) {
                    Assertions.checkState(this.multiWindowTimeBar ^ z3);
                    break;
                }
                int i3 = window2.firstPeriodIndex;
                while (true) {
                    window = this.window;
                    if (i3 <= window.lastPeriodIndex) {
                        currentTimeline.getPeriod(i3, this.period);
                        int removedAdGroupCount = this.period.getRemovedAdGroupCount();
                        int adGroupCount = this.period.getAdGroupCount();
                        while (removedAdGroupCount < adGroupCount) {
                            long adGroupTimeUs = this.period.getAdGroupTimeUs(removedAdGroupCount);
                            if (adGroupTimeUs == Long.MIN_VALUE) {
                                j = j3;
                                long j6 = this.period.durationUs;
                                if (j6 != j) {
                                    adGroupTimeUs = j6;
                                }
                                removedAdGroupCount++;
                                j3 = j;
                            } else {
                                j = j3;
                            }
                            long positionInWindowUs = adGroupTimeUs + this.period.getPositionInWindowUs();
                            if (positionInWindowUs >= j5) {
                                long[] jArr = this.adGroupTimesMs;
                                if (i == jArr.length) {
                                    ?? length = jArr.length == 0 ? z3 : jArr.length * 2;
                                    this.adGroupTimesMs = Arrays.copyOf(jArr, (int) length);
                                    this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, (int) length);
                                }
                                this.adGroupTimesMs[i] = Util.usToMs(j4 + positionInWindowUs);
                                this.playedAdGroups[i] = this.period.hasPlayedAdGroup(removedAdGroupCount);
                                i++;
                            }
                            removedAdGroupCount++;
                            j3 = j;
                        }
                        i3++;
                    }
                }
                j4 += window.durationUs;
                i2++;
                z = z3;
                j2 = j5;
            }
            jMsToUs = j4;
        } else if (player.isCommandAvailable(16)) {
            long contentDuration = player.getContentDuration();
            if (contentDuration != -9223372036854775807L) {
                jMsToUs = Util.msToUs(contentDuration);
                i = 0;
            } else {
                i = 0;
                jMsToUs = 0;
            }
        } else {
            i = 0;
            jMsToUs = 0;
        }
        long jUsToMs = Util.usToMs(jMsToUs);
        TextView textView = this.durationView;
        if (textView != null) {
            textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, jUsToMs));
        }
        TimeBar timeBar = this.timeBar;
        if (timeBar != null) {
            timeBar.setDuration(jUsToMs);
            int length2 = this.extraAdGroupTimesMs.length;
            int i4 = i + length2;
            long[] jArr2 = this.adGroupTimesMs;
            if (i4 > jArr2.length) {
                this.adGroupTimesMs = Arrays.copyOf(jArr2, i4);
                this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i4);
            }
            System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i, length2);
            System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i, length2);
            this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i4);
        }
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        long contentPosition;
        long contentBufferedPosition;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            if (player == null || !player.isCommandAvailable(16)) {
                contentPosition = 0;
                contentBufferedPosition = 0;
            } else {
                contentPosition = this.currentWindowOffset + player.getContentPosition();
                contentBufferedPosition = this.currentWindowOffset + player.getContentBufferedPosition();
            }
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, contentPosition));
            }
            TimeBar timeBar = this.timeBar;
            if (timeBar != null) {
                timeBar.setPosition(contentPosition);
                TimeBar timeBar2 = this.timeBar;
                if (isScrubbingModeEnabled(player)) {
                    contentBufferedPosition = contentPosition;
                }
                timeBar2.setBufferedPosition(contentBufferedPosition);
            }
            removeCallbacks(this.updateProgressAction);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.updateProgressAction, 1000L);
                return;
            }
            TimeBar timeBar3 = this.timeBar;
            long jMin = Math.min(timeBar3 != null ? timeBar3.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f = player.getPlaybackParameters().speed;
            postDelayed(this.updateProgressAction, Util.constrainValue(f > 0.0f ? (long) (jMin / f) : 1000L, this.timeBarMinUpdateIntervalMs, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackSpeedList() {
        Player player = this.player;
        if (player == null) {
            return;
        }
        this.playbackSpeedAdapter.updateSelectedIndex(player.getPlaybackParameters().speed);
        this.settingsAdapter.setSubTextAtPosition(0, this.playbackSpeedAdapter.getSelectedText());
        updateSettingsButton();
    }

    private void updateSettingsButton() {
        updateButton(this.settingsAdapter.hasSettingsToShow(), this.settingsButton);
    }

    private void updateSettingsWindowSize() {
        this.settingsView.measure(0, 0);
        this.settingsWindow.setWidth(Math.min(this.settingsView.getMeasuredWidth(), getWidth() - (this.settingsWindowMargin * 2)));
        this.settingsWindow.setHeight(Math.min(getHeight() - (this.settingsWindowMargin * 2), this.settingsView.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displaySettingsWindow(RecyclerView.Adapter adapter, View view) {
        this.settingsView.setAdapter(adapter);
        updateSettingsWindowSize();
        this.needToHideBars = false;
        this.settingsWindow.dismiss();
        this.needToHideBars = true;
        this.settingsWindow.showAsDropDown(view, (getWidth() - this.settingsWindow.getWidth()) - this.settingsWindowMargin, (-this.settingsWindow.getHeight()) - this.settingsWindowMargin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f) {
        Player player = this.player;
        if (player == null || !player.isCommandAvailable(13)) {
            return;
        }
        Player player2 = this.player;
        player2.setPlaybackParameters(player2.getPlaybackParameters().withSpeed(f));
    }

    void requestPlayPauseFocus() {
        ImageView imageView = this.playPauseButton;
        if (imageView != null) {
            imageView.requestFocus();
        }
    }

    private void updateButton(boolean z, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.buttonAlphaEnabled : this.buttonAlphaDisabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToTimeBarPosition(Player player, long j) {
        if (this.multiWindowTimeBar) {
            if (player.isCommandAvailable(17) && player.isCommandAvailable(10)) {
                Timeline currentTimeline = player.getCurrentTimeline();
                int windowCount = currentTimeline.getWindowCount();
                int i = 0;
                while (true) {
                    long durationMs = currentTimeline.getWindow(i, this.window).getDurationMs();
                    if (j < durationMs) {
                        break;
                    }
                    if (i == windowCount - 1) {
                        j = durationMs;
                        break;
                    } else {
                        j -= durationMs;
                        i++;
                    }
                }
                player.seekTo(i, j);
            }
        } else if (player.isCommandAvailable(5)) {
            player.seekTo(j);
        }
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFullscreenButtonClicked(View view) {
        updateIsFullscreen(!this.isFullscreen);
    }

    public void updateIsFullscreen(boolean z) {
        if (this.isFullscreen == z) {
            return;
        }
        this.isFullscreen = z;
        updateFullscreenButtonForState(this.fullscreenButton, z);
        updateFullscreenButtonForState(this.minimalFullscreenButton, z);
        OnFullScreenModeChangedListener onFullScreenModeChangedListener = this.onFullScreenModeChangedListener;
        if (onFullScreenModeChangedListener != null) {
            onFullScreenModeChangedListener.onFullScreenModeChanged(z);
        }
    }

    private void updateFullscreenButtonForState(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(this.fullscreenExitDrawable);
            imageView.setContentDescription(this.fullscreenExitContentDescription);
        } else {
            imageView.setImageDrawable(this.fullscreenEnterDrawable);
            imageView.setContentDescription(this.fullscreenEnterContentDescription);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSettingViewClicked(int i) {
        if (i == 0) {
            displaySettingsWindow(this.playbackSpeedAdapter, (View) Assertions.checkNotNull(this.settingsButton));
        } else if (i == 1) {
            displaySettingsWindow(this.audioTrackSelectionAdapter, (View) Assertions.checkNotNull(this.settingsButton));
        } else {
            this.settingsWindow.dismiss();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.controlViewLayoutManager.onAttachedToWindow();
        this.isAttachedToWindow = true;
        if (isFullyVisible()) {
            this.controlViewLayoutManager.resetHideCallbacks();
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.controlViewLayoutManager.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        this.controlViewLayoutManager.removeHideCallbacks();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.player;
        if (player == null || !isHandledMediaKey(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4 || !player.isCommandAvailable(12)) {
                return true;
            }
            player.seekForward();
            return true;
        }
        if (keyCode == 89 && player.isCommandAvailable(11)) {
            player.seekBack();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            Util.handlePlayPauseButtonAction(player, this.showPlayButtonIfSuppressed);
            return true;
        }
        if (keyCode == 87) {
            if (!player.isCommandAvailable(9)) {
                return true;
            }
            player.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            if (!player.isCommandAvailable(7)) {
                return true;
            }
            player.seekToPrevious();
            return true;
        }
        if (keyCode == 126) {
            Util.handlePlayButtonAction(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        Util.handlePauseButtonAction(player);
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.controlViewLayoutManager.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i4 - i2;
        int i10 = i8 - i6;
        if (!(i3 - i == i7 - i5 && i9 == i10) && this.settingsWindow.isShowing()) {
            updateSettingsWindowSize();
            this.settingsWindow.update(view, (getWidth() - this.settingsWindow.getWidth()) - this.settingsWindowMargin, (-this.settingsWindow.getHeight()) - this.settingsWindowMargin, -1, -1);
        }
    }

    private static boolean canShowMultiWindowTimeBar(Player player, Timeline.Window window) {
        Timeline currentTimeline;
        int windowCount;
        if (!player.isCommandAvailable(17) || (windowCount = (currentTimeline = player.getCurrentTimeline()).getWindowCount()) <= 1 || windowCount > 100) {
            return false;
        }
        for (int i = 0; i < windowCount; i++) {
            if (currentTimeline.getWindow(i, window).durationUs == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private static void initializeFullscreenButton(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    private static void updateFullscreenButtonVisibility(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int i) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isScrubbingModeEnabled(Player player) {
        try {
            if (isExoPlayer(player) && ((Boolean) Assertions.checkNotNull(((Method) Assertions.checkNotNull(this.isScrubbingModeEnabledMethod)).invoke(player, null))).booleanValue()) {
                return true;
            }
            return isCompositionPlayer(player) && ((Boolean) Assertions.checkNotNull(((Method) Assertions.checkNotNull(this.compositionPlayerIsScrubbingModeEnabledMethod)).invoke(player, null))).booleanValue();
        } catch (IllegalAccessException e) {
            e = e;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            e = e2;
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isExoPlayer(Player player) {
        Class cls;
        return (player == null || (cls = this.exoplayerClazz) == null || !cls.isAssignableFrom(player.getClass())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCompositionPlayer(Player player) {
        Class cls;
        return (player == null || (cls = this.compositionPlayerClazz) == null || !cls.isAssignableFrom(player.getClass())) ? false : true;
    }

    private final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        private ComponentListener() {
        }

        @Override // androidx.media3.common.Player.Listener
        public void onEvents(Player player, Player.Events events) {
            if (events.containsAny(4, 5, 13)) {
                PlayerControlView.this.updatePlayPauseButton();
            }
            if (events.containsAny(4, 5, 7, 13)) {
                PlayerControlView.this.updateProgress();
            }
            if (events.containsAny(8, 13)) {
                PlayerControlView.this.updateRepeatModeButton();
            }
            if (events.containsAny(9, 13)) {
                PlayerControlView.this.updateShuffleButton();
            }
            if (events.containsAny(8, 9, 11, 0, 16, 17, 13)) {
                PlayerControlView.this.updateNavigation();
            }
            if (events.containsAny(11, 0, 13)) {
                PlayerControlView.this.updateTimeline();
            }
            if (events.containsAny(12, 13)) {
                PlayerControlView.this.updatePlaybackSpeedList();
            }
            if (events.containsAny(2, 13)) {
                PlayerControlView.this.updateTrackLists();
            }
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public void onScrubStart(TimeBar timeBar, long j) {
            PlayerControlView.this.scrubbing = true;
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
            PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
            if (PlayerControlView.this.player == null || !PlayerControlView.this.timeBarScrubbingEnabled) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            if (playerControlView.isExoPlayer(playerControlView.player)) {
                try {
                    ((Method) Assertions.checkNotNull(PlayerControlView.this.setScrubbingModeEnabledMethod)).invoke(PlayerControlView.this.player, Boolean.TRUE);
                    return;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            PlayerControlView playerControlView2 = PlayerControlView.this;
            if (playerControlView2.isCompositionPlayer(playerControlView2.player)) {
                try {
                    ((Method) Assertions.checkNotNull(PlayerControlView.this.compositionPlayerSetScrubbingModeEnabledMethod)).invoke(PlayerControlView.this.player, Boolean.TRUE);
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                Log.w("PlayerControlView", "Time bar scrubbing is enabled, but player is not an ExoPlayer or CompositionPlayer instance, so ignoring (because we can't enable scrubbing mode). player.class=" + ((Player) Assertions.checkNotNull(PlayerControlView.this.player)).getClass());
            }
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public void onScrubMove(TimeBar timeBar, long j) {
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            if (playerControlView.isScrubbingModeEnabled(playerControlView.player)) {
                PlayerControlView playerControlView2 = PlayerControlView.this;
                playerControlView2.seekToTimeBarPosition(playerControlView2.player, j);
            }
        }

        @Override // androidx.media3.ui.TimeBar.OnScrubListener
        public void onScrubStop(TimeBar timeBar, long j, boolean z) {
            PlayerControlView.this.scrubbing = false;
            if (PlayerControlView.this.player != null) {
                if (!z) {
                    PlayerControlView playerControlView = PlayerControlView.this;
                    playerControlView.seekToTimeBarPosition(playerControlView.player, j);
                }
                PlayerControlView playerControlView2 = PlayerControlView.this;
                if (playerControlView2.isExoPlayer(playerControlView2.player)) {
                    try {
                        ((Method) Assertions.checkNotNull(PlayerControlView.this.setScrubbingModeEnabledMethod)).invoke(PlayerControlView.this.player, Boolean.FALSE);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    PlayerControlView playerControlView3 = PlayerControlView.this;
                    if (playerControlView3.isCompositionPlayer(playerControlView3.player)) {
                        try {
                            ((Method) Assertions.checkNotNull(PlayerControlView.this.compositionPlayerSetScrubbingModeEnabledMethod)).invoke(PlayerControlView.this.player, Boolean.FALSE);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
            }
            PlayerControlView.this.controlViewLayoutManager.resetHideCallbacks();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (PlayerControlView.this.needToHideBars) {
                PlayerControlView.this.controlViewLayoutManager.resetHideCallbacks();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Player player = PlayerControlView.this.player;
            if (player == null) {
                return;
            }
            PlayerControlView.this.controlViewLayoutManager.resetHideCallbacks();
            if (PlayerControlView.this.nextButton != view) {
                if (PlayerControlView.this.previousButton != view) {
                    if (PlayerControlView.this.fastForwardButton != view) {
                        if (PlayerControlView.this.rewindButton != view) {
                            if (PlayerControlView.this.playPauseButton == view) {
                                Util.handlePlayPauseButtonAction(player, PlayerControlView.this.showPlayButtonIfSuppressed);
                                return;
                            }
                            if (PlayerControlView.this.repeatToggleButton != view) {
                                if (PlayerControlView.this.shuffleButton != view) {
                                    if (PlayerControlView.this.settingsButton == view) {
                                        PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                                        PlayerControlView playerControlView = PlayerControlView.this;
                                        playerControlView.displaySettingsWindow(playerControlView.settingsAdapter, PlayerControlView.this.settingsButton);
                                        return;
                                    }
                                    if (PlayerControlView.this.playbackSpeedButton == view) {
                                        PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                                        PlayerControlView playerControlView2 = PlayerControlView.this;
                                        playerControlView2.displaySettingsWindow(playerControlView2.playbackSpeedAdapter, PlayerControlView.this.playbackSpeedButton);
                                        return;
                                    } else if (PlayerControlView.this.audioTrackButton == view) {
                                        PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                                        PlayerControlView playerControlView3 = PlayerControlView.this;
                                        playerControlView3.displaySettingsWindow(playerControlView3.audioTrackSelectionAdapter, PlayerControlView.this.audioTrackButton);
                                        return;
                                    } else {
                                        if (PlayerControlView.this.subtitleButton == view) {
                                            PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                                            PlayerControlView playerControlView4 = PlayerControlView.this;
                                            playerControlView4.displaySettingsWindow(playerControlView4.textTrackSelectionAdapter, PlayerControlView.this.subtitleButton);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (player.isCommandAvailable(14)) {
                                    player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
                                    return;
                                }
                                return;
                            }
                            if (player.isCommandAvailable(15)) {
                                player.setRepeatMode(RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), PlayerControlView.this.repeatToggleModes));
                                return;
                            }
                            return;
                        }
                        if (player.isCommandAvailable(11)) {
                            player.seekBack();
                            return;
                        }
                        return;
                    }
                    if (player.getPlaybackState() == 4 || !player.isCommandAvailable(12)) {
                        return;
                    }
                    player.seekForward();
                    return;
                }
                if (player.isCommandAvailable(7)) {
                    player.seekToPrevious();
                    return;
                }
                return;
            }
            if (player.isCommandAvailable(9)) {
                player.seekToNext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SettingsAdapter extends RecyclerView.Adapter {
        private final Drawable[] iconIds;
        private final String[] mainTexts;
        private final String[] subTexts;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        public SettingsAdapter(String[] strArr, Drawable[] drawableArr) {
            this.mainTexts = strArr;
            this.subTexts = new String[strArr.length];
            this.iconIds = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return PlayerControlView.this.new SettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SettingViewHolder settingViewHolder, int i) {
            if (shouldShowSetting(i)) {
                settingViewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                settingViewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
            settingViewHolder.mainTextView.setText(this.mainTexts[i]);
            if (this.subTexts[i] == null) {
                settingViewHolder.subTextView.setVisibility(8);
            } else {
                settingViewHolder.subTextView.setText(this.subTexts[i]);
            }
            if (this.iconIds[i] == null) {
                settingViewHolder.iconView.setVisibility(8);
            } else {
                settingViewHolder.iconView.setImageDrawable(this.iconIds[i]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mainTexts.length;
        }

        public void setSubTextAtPosition(int i, String str) {
            this.subTexts[i] = str;
        }

        public boolean hasSettingsToShow() {
            return shouldShowSetting(1) || shouldShowSetting(0);
        }

        private boolean shouldShowSetting(int i) {
            if (PlayerControlView.this.player == null) {
                return false;
            }
            if (i == 0) {
                return PlayerControlView.this.player.isCommandAvailable(13);
            }
            if (i != 1) {
                return true;
            }
            return PlayerControlView.this.player.isCommandAvailable(30) && PlayerControlView.this.player.isCommandAvailable(29);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class SettingViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iconView;
        private final TextView mainTextView;
        private final TextView subTextView;

        public SettingViewHolder(View view) {
            super(view);
            if (Build.VERSION.SDK_INT < 26) {
                view.setFocusable(true);
            }
            this.mainTextView = (TextView) view.findViewById(R$id.exo_main_text);
            this.subTextView = (TextView) view.findViewById(R$id.exo_sub_text);
            this.iconView = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$SettingViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PlayerControlView.SettingViewHolder settingViewHolder = this.f$0;
                    PlayerControlView.this.onSettingViewClicked(settingViewHolder.getBindingAdapterPosition());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class PlaybackSpeedAdapter extends RecyclerView.Adapter {
        private final String[] playbackSpeedTexts;
        private final float[] playbackSpeeds;
        private int selectedIndex;

        public PlaybackSpeedAdapter(String[] strArr, float[] fArr) {
            this.playbackSpeedTexts = strArr;
            this.playbackSpeeds = fArr;
        }

        public void updateSelectedIndex(float f) {
            int i = 0;
            float f2 = Float.MAX_VALUE;
            int i2 = 0;
            while (true) {
                float[] fArr = this.playbackSpeeds;
                if (i < fArr.length) {
                    float fAbs = Math.abs(f - fArr[i]);
                    if (fAbs < f2) {
                        i2 = i;
                        f2 = fAbs;
                    }
                    i++;
                } else {
                    this.selectedIndex = i2;
                    return;
                }
            }
        }

        public String getSelectedText() {
            return this.playbackSpeedTexts[this.selectedIndex];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, final int i) {
            String[] strArr = this.playbackSpeedTexts;
            if (i < strArr.length) {
                subSettingViewHolder.textView.setText(strArr[i]);
            }
            if (i == this.selectedIndex) {
                subSettingViewHolder.itemView.setSelected(true);
                subSettingViewHolder.checkView.setVisibility(0);
            } else {
                subSettingViewHolder.itemView.setSelected(false);
                subSettingViewHolder.checkView.setVisibility(4);
            }
            subSettingViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$PlaybackSpeedAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.PlaybackSpeedAdapter.$r8$lambda$YrK3cD4fCvtWqJrbozXZftTqDxU(this.f$0, i, view);
                }
            });
        }

        public static /* synthetic */ void $r8$lambda$YrK3cD4fCvtWqJrbozXZftTqDxU(PlaybackSpeedAdapter playbackSpeedAdapter, int i, View view) {
            if (i != playbackSpeedAdapter.selectedIndex) {
                PlayerControlView.this.setPlaybackSpeed(playbackSpeedAdapter.playbackSpeeds[i]);
            }
            PlayerControlView.this.settingsWindow.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.playbackSpeedTexts.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class TrackInformation {
        public final Tracks.Group trackGroup;
        public final int trackIndex;
        public final String trackName;

        public TrackInformation(Tracks tracks, int i, int i2, String str) {
            this.trackGroup = (Tracks.Group) tracks.getGroups().get(i);
            this.trackIndex = i2;
            this.trackName = str;
        }

        public boolean isSelected() {
            return this.trackGroup.isTrackSelected(this.trackIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class TextTrackSelectionAdapter extends TrackSelectionAdapter {
        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public void onTrackSelection(String str) {
        }

        private TextTrackSelectionAdapter() {
            super();
        }

        public void init(List list) {
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                if (((TrackInformation) list.get(i)).isSelected()) {
                    z = true;
                    break;
                }
            }
            if (PlayerControlView.this.subtitleButton != null) {
                ImageView imageView = PlayerControlView.this.subtitleButton;
                PlayerControlView playerControlView = PlayerControlView.this;
                imageView.setImageDrawable(z ? playerControlView.subtitleOnButtonDrawable : playerControlView.subtitleOffButtonDrawable);
                PlayerControlView.this.subtitleButton.setContentDescription(z ? PlayerControlView.this.subtitleOnContentDescription : PlayerControlView.this.subtitleOffContentDescription);
            }
            this.tracks = list;
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public void onBindViewHolderAtZeroPosition(SubSettingViewHolder subSettingViewHolder) {
            boolean z;
            subSettingViewHolder.textView.setText(R$string.exo_track_selection_none);
            int i = 0;
            while (true) {
                if (i >= this.tracks.size()) {
                    z = true;
                    break;
                } else {
                    if (((TrackInformation) this.tracks.get(i)).isSelected()) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            subSettingViewHolder.checkView.setVisibility(z ? 0 : 4);
            subSettingViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$TextTrackSelectionAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.TextTrackSelectionAdapter.m2898$r8$lambda$KOmte5c_Tsc0wexTmq13xZWHj0(this.f$0, view);
                }
            });
        }

        /* JADX INFO: renamed from: $r8$lambda$KOmte5c_-Tsc0wexTmq13xZWHj0, reason: not valid java name */
        public static /* synthetic */ void m2898$r8$lambda$KOmte5c_Tsc0wexTmq13xZWHj0(TextTrackSelectionAdapter textTrackSelectionAdapter, View view) {
            if (PlayerControlView.this.player == null || !PlayerControlView.this.player.isCommandAvailable(29)) {
                return;
            }
            PlayerControlView.this.player.setTrackSelectionParameters(PlayerControlView.this.player.getTrackSelectionParameters().buildUpon().clearOverridesOfType(3).setIgnoredTextSelectionFlags(-3).setPreferredTextLanguage(null).setPreferredTextRoleFlags(0).build());
            PlayerControlView.this.settingsWindow.dismiss();
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i) {
            super.onBindViewHolder(subSettingViewHolder, i);
            if (i > 0) {
                subSettingViewHolder.checkView.setVisibility(((TrackInformation) this.tracks.get(i + (-1))).isSelected() ? 0 : 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class AudioTrackSelectionAdapter extends TrackSelectionAdapter {
        private AudioTrackSelectionAdapter() {
            super();
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public void onBindViewHolderAtZeroPosition(SubSettingViewHolder subSettingViewHolder) {
            subSettingViewHolder.textView.setText(R$string.exo_track_selection_auto);
            subSettingViewHolder.checkView.setVisibility(hasSelectionOverride(((Player) Assertions.checkNotNull(PlayerControlView.this.player)).getTrackSelectionParameters()) ? 4 : 0);
            subSettingViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$AudioTrackSelectionAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.AudioTrackSelectionAdapter.$r8$lambda$ruLjjtO5OGHADFFhOSeNAPioWww(this.f$0, view);
                }
            });
        }

        public static /* synthetic */ void $r8$lambda$ruLjjtO5OGHADFFhOSeNAPioWww(AudioTrackSelectionAdapter audioTrackSelectionAdapter, View view) {
            if (PlayerControlView.this.player == null || !PlayerControlView.this.player.isCommandAvailable(29)) {
                return;
            }
            ((Player) Util.castNonNull(PlayerControlView.this.player)).setTrackSelectionParameters(PlayerControlView.this.player.getTrackSelectionParameters().buildUpon().clearOverridesOfType(1).setTrackTypeDisabled(1, false).build());
            PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
            PlayerControlView.this.settingsWindow.dismiss();
        }

        private boolean hasSelectionOverride(TrackSelectionParameters trackSelectionParameters) {
            for (int i = 0; i < this.tracks.size(); i++) {
                if (trackSelectionParameters.overrides.containsKey(((TrackInformation) this.tracks.get(i)).trackGroup.getMediaTrackGroup())) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.media3.ui.PlayerControlView.TrackSelectionAdapter
        public void onTrackSelection(String str) {
            PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, str);
        }

        public void init(List list) {
            this.tracks = list;
            TrackSelectionParameters trackSelectionParameters = ((Player) Assertions.checkNotNull(PlayerControlView.this.player)).getTrackSelectionParameters();
            if (list.isEmpty()) {
                PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
                return;
            }
            if (!hasSelectionOverride(trackSelectionParameters)) {
                PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                TrackInformation trackInformation = (TrackInformation) list.get(i);
                if (trackInformation.isSelected()) {
                    PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, trackInformation.trackName);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class TrackSelectionAdapter extends RecyclerView.Adapter {
        protected List tracks = new ArrayList();

        protected abstract void onBindViewHolderAtZeroPosition(SubSettingViewHolder subSettingViewHolder);

        protected abstract void onTrackSelection(String str);

        protected TrackSelectionAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i) {
            final Player player = PlayerControlView.this.player;
            if (player == null) {
                return;
            }
            if (i == 0) {
                onBindViewHolderAtZeroPosition(subSettingViewHolder);
                return;
            }
            final TrackInformation trackInformation = (TrackInformation) this.tracks.get(i - 1);
            final TrackGroup mediaTrackGroup = trackInformation.trackGroup.getMediaTrackGroup();
            boolean z = player.getTrackSelectionParameters().overrides.get(mediaTrackGroup) != null && trackInformation.isSelected();
            subSettingViewHolder.textView.setText(trackInformation.trackName);
            subSettingViewHolder.checkView.setVisibility(z ? 0 : 4);
            subSettingViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.PlayerControlView$TrackSelectionAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerControlView.TrackSelectionAdapter.m2899$r8$lambda$DzyVXKiRAR0kG1pNlO4Y4q0(this.f$0, player, mediaTrackGroup, trackInformation, view);
                }
            });
        }

        /* JADX INFO: renamed from: $r8$lambda$DzyVX-Ki-RAR--0kG1pNlO4Y4q0, reason: not valid java name */
        public static /* synthetic */ void m2899$r8$lambda$DzyVXKiRAR0kG1pNlO4Y4q0(TrackSelectionAdapter trackSelectionAdapter, Player player, TrackGroup trackGroup, TrackInformation trackInformation, View view) {
            trackSelectionAdapter.getClass();
            if (player.isCommandAvailable(29)) {
                player.setTrackSelectionParameters(player.getTrackSelectionParameters().buildUpon().setOverrideForType(new TrackSelectionOverride(trackGroup, ImmutableList.of((Object) Integer.valueOf(trackInformation.trackIndex)))).setTrackTypeDisabled(trackInformation.trackGroup.getType(), false).build());
                trackSelectionAdapter.onTrackSelection(trackInformation.trackName);
                PlayerControlView.this.settingsWindow.dismiss();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.tracks.isEmpty()) {
                return 0;
            }
            return this.tracks.size() + 1;
        }

        protected void clear() {
            this.tracks = Collections.EMPTY_LIST;
        }
    }

    private static class SubSettingViewHolder extends RecyclerView.ViewHolder {
        public final View checkView;
        public final TextView textView;

        public SubSettingViewHolder(View view) {
            super(view);
            if (Build.VERSION.SDK_INT < 26) {
                view.setFocusable(true);
            }
            this.textView = (TextView) view.findViewById(R$id.exo_text);
            this.checkView = view.findViewById(R$id.exo_check);
        }
    }
}
