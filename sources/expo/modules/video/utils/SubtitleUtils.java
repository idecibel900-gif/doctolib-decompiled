package expo.modules.video.utils;

import android.content.Context;
import android.view.accessibility.CaptioningManager;
import androidx.media3.ui.CaptionStyleCompat;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class SubtitleUtils {
    public static final SubtitleUtils INSTANCE = new SubtitleUtils();

    private SubtitleUtils() {
    }

    public final void configureSubtitleView(PlayerView playerView, Context context) {
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        Intrinsics.checkNotNullParameter(context, "context");
        SubtitleView subtitleView = playerView.getSubtitleView();
        if (subtitleView != null) {
            subtitleView.setApplyEmbeddedStyles(false);
            subtitleView.setApplyEmbeddedFontSizes(false);
            Object systemService = context.getSystemService("captioning");
            CaptioningManager captioningManager = systemService instanceof CaptioningManager ? (CaptioningManager) systemService : null;
            CaptioningManager.CaptionStyle userStyle = captioningManager != null ? captioningManager.getUserStyle() : null;
            if (userStyle != null) {
                CaptionStyleCompat captionStyleCompatCreateFromCaptionStyle = CaptionStyleCompat.createFromCaptionStyle(userStyle);
                Intrinsics.checkNotNullExpressionValue(captionStyleCompatCreateFromCaptionStyle, "createFromCaptionStyle(...)");
                subtitleView.setStyle(captionStyleCompatCreateFromCaptionStyle);
                subtitleView.setFixedTextSize(2, captioningManager.getFontScale() * 16.0f);
            }
        }
    }

    public final CaptioningManager.CaptioningChangeListener createCaptioningChangeListener(final PlayerView playerView, final Context context) {
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        Intrinsics.checkNotNullParameter(context, "context");
        return new CaptioningManager.CaptioningChangeListener() { // from class: expo.modules.video.utils.SubtitleUtils.createCaptioningChangeListener.1
            @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
            public void onEnabledChanged(boolean z) {
                SubtitleUtils.INSTANCE.configureSubtitleView(playerView, context);
            }

            @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
            public void onUserStyleChanged(CaptioningManager.CaptionStyle userStyle) {
                Intrinsics.checkNotNullParameter(userStyle, "userStyle");
                SubtitleUtils.INSTANCE.configureSubtitleView(playerView, context);
            }

            @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
            public void onFontScaleChanged(float f) {
                SubtitleUtils.INSTANCE.configureSubtitleView(playerView, context);
            }
        };
    }
}
