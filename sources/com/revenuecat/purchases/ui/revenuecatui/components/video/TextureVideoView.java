package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.MediaController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002HIB+\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u00020\bH\u0016J\b\u00102\u001a\u00020\u0015H\u0014J\b\u00103\u001a\u00020\u0015H\u0016J\b\u00104\u001a\u00020\u0015H\u0002J\u0006\u00105\u001a\u00020\u0015J\u0010\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0019H\u0002J\u0010\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u0019H\u0016J\u000e\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\bJ\u000e\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\bJ\u0016\u0010>\u001a\u00020\u00152\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u000e\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u000200J\u000e\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u001fJ\u000e\u0010D\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#J\b\u0010E\u001a\u00020\u0015H\u0016J\u0006\u0010F\u001a\u00020\u0015J\n\u0010G\u001a\u0004\u0018\u00010\fH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/TextureVideoView;", "Landroid/widget/FrameLayout;", "Landroid/widget/MediaController$MediaPlayerControl;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "showControls", "", "muteAudio", "(Landroid/content/Context;Landroid/util/AttributeSet;ZZ)V", "attachedSurface", "Landroid/view/Surface;", "autoStart", "controller", "Landroid/widget/MediaController;", "firstFrameRendered", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onReadyCallback", "Lkotlin/Function0;", "", "playerOwner", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/MediaPlayerThreadOwner;", "prepareRequestId", "", "prepared", "released", "resumePlayWhenReady", "resumePosMs", "scaleType", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/TextureVideoView$ScaleType;", "texture", "Landroid/view/TextureView;", "uri", "Landroid/net/Uri;", "videoHeight", "videoWidth", "viewTreeObserverListening", "applySizing", "canPause", "canSeekBackward", "canSeekForward", "getAudioSessionId", "getBufferPercentage", "getCurrentPosition", "getDuration", "getPlaybackState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/video/TextureVideoView$PlaybackState;", "isPlaying", "onDetachedFromWindow", "pause", "prepareIfNeeded", "release", "safeSeekTo", "position", "seekTo", "pos", "setAutoStart", "enabled", "setLooping", "loop", "setOnReadyCallback", "callback", "setPlaybackState", "state", "setScaleType", "type", "setVideoURI", "start", "startIfNeeded", "takeAttachedSurface", "PlaybackState", "ScaleType", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
final class TextureVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private Surface attachedSurface;
    private boolean autoStart;
    private MediaController controller;
    private boolean firstFrameRendered;
    private final ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private final boolean muteAudio;
    private Function0 onReadyCallback;
    private final MediaPlayerThreadOwner playerOwner;
    private int prepareRequestId;
    private boolean prepared;
    private boolean released;
    private boolean resumePlayWhenReady;
    private int resumePosMs;
    private ScaleType scaleType;
    private final boolean showControls;
    private final TextureView texture;
    private Uri uri;
    private int videoHeight;
    private int videoWidth;
    private boolean viewTreeObserverListening;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/TextureVideoView$ScaleType;", "", "(Ljava/lang/String;I)V", "FIT", "FILL", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ScaleType {
        FIT,
        FILL
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextureVideoView(Context context, boolean z, boolean z2) {
        this(context, null, z, z2, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    public /* synthetic */ TextureVideoView(Context context, AttributeSet attributeSet, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet, z, z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureVideoView(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showControls = z;
        this.muteAudio = z2;
        TextureView textureView = new TextureView(context);
        this.texture = textureView;
        this.playerOwner = new MediaPlayerThreadOwner(context, z2, null, 4, null);
        this.autoStart = true;
        this.scaleType = ScaleType.FIT;
        this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.applySizing();
            }
        };
        setClipToPadding(true);
        setClipChildren(true);
        addView(textureView, new FrameLayout.LayoutParams(-1, -1, 17));
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture st, int w, int h) {
                Intrinsics.checkNotNullParameter(st, "st");
                if (TextureVideoView.this.released) {
                    return;
                }
                Surface surfaceTakeAttachedSurface = TextureVideoView.this.takeAttachedSurface();
                if (surfaceTakeAttachedSurface != null) {
                    TextureVideoView.this.playerOwner.clearSurfaceBlocking(surfaceTakeAttachedSurface);
                }
                TextureVideoView.this.attachedSurface = new Surface(st);
                TextureVideoView.this.playerOwner.setSurface(TextureVideoView.this.attachedSurface);
                if (!TextureVideoView.this.viewTreeObserverListening) {
                    TextureVideoView.this.getViewTreeObserver().addOnGlobalLayoutListener(TextureVideoView.this.layoutListener);
                    TextureVideoView.this.viewTreeObserverListening = true;
                }
                if (!TextureVideoView.this.prepared) {
                    TextureVideoView.this.prepareIfNeeded();
                    return;
                }
                TextureVideoView textureVideoView = TextureVideoView.this;
                textureVideoView.safeSeekTo(textureVideoView.resumePosMs);
                if (TextureVideoView.this.resumePlayWhenReady) {
                    TextureVideoView.this.start();
                }
                TextureVideoView.this.applySizing();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture st, int w, int h) {
                Intrinsics.checkNotNullParameter(st, "st");
                TextureVideoView.this.applySizing();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture st) {
                Intrinsics.checkNotNullParameter(st, "st");
                Surface surfaceTakeAttachedSurface = TextureVideoView.this.takeAttachedSurface();
                if (TextureVideoView.this.released) {
                    return true;
                }
                TextureVideoView textureVideoView = TextureVideoView.this;
                textureVideoView.resumePlayWhenReady = textureVideoView.isPlaying();
                TextureVideoView textureVideoView2 = TextureVideoView.this;
                textureVideoView2.resumePosMs = textureVideoView2.getCurrentPosition();
                if (TextureVideoView.this.prepared) {
                    TextureVideoView.this.pause();
                }
                TextureVideoView.this.playerOwner.clearSurfaceBlocking(surfaceTakeAttachedSurface);
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture st) {
                Intrinsics.checkNotNullParameter(st, "st");
                if (TextureVideoView.this.firstFrameRendered || !TextureVideoView.this.prepared) {
                    return;
                }
                TextureVideoView.this.firstFrameRendered = true;
                Function0 function0 = TextureVideoView.this.onReadyCallback;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        MediaController mediaController = new MediaController(context);
        mediaController.setMediaPlayer(this);
        if (z) {
            mediaController.setAnchorView(this);
            mediaController.setEnabled(true);
        }
        this.controller = mediaController;
        setOnClickListener(new View.OnClickListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextureVideoView._init_$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(TextureVideoView textureVideoView, View view) {
        MediaController mediaController;
        if (!textureVideoView.showControls || (mediaController = textureVideoView.controller) == null) {
            return;
        }
        mediaController.show();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/TextureVideoView$PlaybackState;", "", "positionMs", "", "playWhenReady", "", "(IZ)V", "getPlayWhenReady", "()Z", "getPositionMs", "()I", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PlaybackState {
        public static final int $stable = 0;
        private final boolean playWhenReady;
        private final int positionMs;

        public PlaybackState(int i, boolean z) {
            this.positionMs = i;
            this.playWhenReady = z;
        }

        public final boolean getPlayWhenReady() {
            return this.playWhenReady;
        }

        public final int getPositionMs() {
            return this.positionMs;
        }
    }

    public final PlaybackState getPlaybackState() {
        int currentPosition;
        boolean zIsPlaying;
        if (this.prepared) {
            currentPosition = this.playerOwner.getCurrentPosition();
        } else {
            currentPosition = this.resumePosMs;
        }
        if (this.prepared) {
            zIsPlaying = this.playerOwner.isPlaying();
        } else {
            zIsPlaying = this.resumePlayWhenReady;
        }
        return new PlaybackState(currentPosition, zIsPlaying);
    }

    public final void setPlaybackState(PlaybackState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.resumePosMs = state.getPositionMs();
        this.resumePlayWhenReady = state.getPlayWhenReady();
        if (this.prepared) {
            safeSeekTo(this.resumePosMs);
            if (this.resumePlayWhenReady) {
                start();
            } else {
                pause();
            }
        }
    }

    public final void setVideoURI(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.prepared = false;
        this.firstFrameRendered = false;
        if (this.resumePosMs == 0) {
            this.resumePlayWhenReady = this.autoStart;
        }
        if (!this.texture.isAvailable() || this.released) {
            return;
        }
        prepareIfNeeded();
    }

    public final void setScaleType(ScaleType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.scaleType = type;
        applySizing();
    }

    public final void setLooping(boolean loop) {
        if (this.released) {
            return;
        }
        this.playerOwner.setLooping(loop);
    }

    public final void setAutoStart(boolean enabled) {
        this.autoStart = enabled;
    }

    public final void setOnReadyCallback(Function0 callback) {
        this.onReadyCallback = callback;
        if (!this.firstFrameRendered || callback == null) {
            return;
        }
        callback.invoke();
    }

    public final void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.prepared = false;
        this.prepareRequestId++;
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            mediaController.hide();
        }
        this.controller = null;
        this.playerOwner.release(takeAttachedSurface());
        if (this.viewTreeObserverListening) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
            this.viewTreeObserverListening = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareIfNeeded() {
        Uri uri;
        if (this.released || (uri = this.uri) == null) {
            return;
        }
        final int i = this.prepareRequestId + 1;
        this.prepareRequestId = i;
        this.prepared = false;
        this.playerOwner.prepare(uri, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView.prepareIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, int i3) {
                MediaController mediaController;
                if (TextureVideoView.this.released || i != TextureVideoView.this.prepareRequestId) {
                    return;
                }
                TextureVideoView.this.prepared = true;
                TextureVideoView.this.videoWidth = i2;
                TextureVideoView.this.videoHeight = i3;
                TextureVideoView.this.applySizing();
                if (TextureVideoView.this.resumePosMs <= 0) {
                    if (TextureVideoView.this.resumePosMs == 0) {
                        TextureVideoView.this.safeSeekTo(1);
                    }
                } else {
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.safeSeekTo(textureVideoView.resumePosMs);
                }
                if (TextureVideoView.this.autoStart || TextureVideoView.this.resumePlayWhenReady) {
                    TextureVideoView.this.start();
                }
                if (!TextureVideoView.this.showControls || (mediaController = TextureVideoView.this.controller) == null) {
                    return;
                }
                mediaController.show();
            }
        }, new Function2() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView.prepareIfNeeded.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, int i3) {
                if (TextureVideoView.this.released || i != TextureVideoView.this.prepareRequestId) {
                    return;
                }
                TextureVideoView.this.videoWidth = i2;
                TextureVideoView.this.videoHeight = i3;
                TextureVideoView.this.applySizing();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void safeSeekTo(int position) {
        if (!this.prepared || position <= 0) {
            return;
        }
        this.playerOwner.seekTo(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Surface takeAttachedSurface() {
        Surface surface = this.attachedSurface;
        this.attachedSurface = null;
        return surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySizing() {
        if (this.released || getWidth() == 0 || getHeight() == 0 || this.videoWidth == 0 || this.videoHeight == 0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float f = width;
        float f2 = height;
        float f3 = f / f2;
        float f4 = this.videoWidth / this.videoHeight;
        ViewGroup.LayoutParams layoutParams = this.texture.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.scaleType == ScaleType.FIT) {
            if (f4 > f3) {
                layoutParams2.width = width;
                layoutParams2.height = (int) (f / f4);
            } else {
                layoutParams2.height = height;
                layoutParams2.width = (int) (f2 * f4);
            }
        } else if (f4 > f3) {
            layoutParams2.height = height;
            layoutParams2.width = (int) (f2 * f4);
        } else {
            layoutParams2.width = width;
            layoutParams2.height = (int) (f / f4);
        }
        layoutParams2.gravity = 17;
        this.texture.setLayoutParams(layoutParams2);
        this.texture.setVisibility(0);
        this.texture.setAlpha(1.0f);
        invalidate();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (!this.prepared || this.released) {
            return;
        }
        this.playerOwner.start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (!this.prepared || this.released) {
            return;
        }
        this.playerOwner.pause();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (!this.prepared || this.released) {
            return 0;
        }
        return this.playerOwner.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return (!this.prepared || this.released) ? this.resumePosMs : this.playerOwner.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int pos) {
        this.resumePosMs = pos;
        safeSeekTo(pos);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.prepared && !this.released && this.playerOwner.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return this.playerOwner.getAudioSessionId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public final void startIfNeeded() {
        if (!this.prepared || this.released || this.playerOwner.isPlaying() || !this.autoStart) {
            return;
        }
        start();
    }
}
