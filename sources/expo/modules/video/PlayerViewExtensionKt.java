package expo.modules.video;

import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import expo.modules.video.records.ButtonOptions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PlayerViewExtensionKt {
    public static final void applyRequiresLinearPlayback(PlayerView playerView, boolean z) {
        Intrinsics.checkNotNullParameter(playerView, "<this>");
        playerView.setShowFastForwardButton(!z);
        playerView.setShowRewindButton(!z);
        playerView.setShowPreviousButton(!z);
        playerView.setShowNextButton(!z);
        setTimeBarInteractive(playerView, z);
    }

    public static final void setTimeBarInteractive(PlayerView playerView, boolean z) {
        Intrinsics.checkNotNullParameter(playerView, "<this>");
        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) playerView.findViewById(androidx.media3.ui.R$id.exo_progress);
        if (z) {
            if (defaultTimeBar != null) {
                defaultTimeBar.setScrubberColor(0);
            }
            if (defaultTimeBar != null) {
                defaultTimeBar.setEnabled(false);
                return;
            }
            return;
        }
        if (defaultTimeBar != null) {
            defaultTimeBar.setScrubberColor(-1);
        }
        if (defaultTimeBar != null) {
            defaultTimeBar.setEnabled(true);
        }
    }

    public static final void setFullscreenButtonVisibility(PlayerView playerView, boolean z) {
        Intrinsics.checkNotNullParameter(playerView, "<this>");
        ImageButton imageButton = (ImageButton) playerView.findViewById(androidx.media3.ui.R$id.exo_fullscreen);
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
        }
    }

    public static final void setSettingsButtonVisibility(PlayerView playerView, boolean z) {
        Intrinsics.checkNotNullParameter(playerView, "<this>");
        ImageButton imageButton = (ImageButton) playerView.findViewById(androidx.media3.ui.R$id.exo_settings);
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
        }
    }

    public static final void setPlayPauseButtonVisibility(PlayerView playerView, boolean z) {
        Intrinsics.checkNotNullParameter(playerView, "<this>");
        ImageButton imageButton = (ImageButton) playerView.findViewById(androidx.media3.ui.R$id.exo_play_pause);
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 8);
        }
    }

    public static final void setBottomBarVisibility(PlayerView playerView, boolean z) {
        Intrinsics.checkNotNullParameter(playerView, "<this>");
        ViewGroup viewGroup = (ViewGroup) playerView.findViewById(androidx.media3.ui.R$id.exo_bottom_bar);
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
        DefaultTimeBar defaultTimeBar = (DefaultTimeBar) playerView.findViewById(androidx.media3.ui.R$id.exo_progress);
        if (defaultTimeBar != null) {
            defaultTimeBar.setVisibility(z ? 0 : 8);
        }
    }

    public static final void applyButtonOptions(PlayerView playerView, ButtonOptions config, boolean z) {
        Intrinsics.checkNotNullParameter(playerView, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        boolean z2 = false;
        playerView.setShowFastForwardButton(!z && config.getShowSeekForward());
        playerView.setShowRewindButton(!z && config.getShowSeekBackward());
        playerView.setShowPreviousButton(!z && config.getShowPrevious());
        if (!z && config.getShowNext()) {
            z2 = true;
        }
        playerView.setShowNextButton(z2);
        setSettingsButtonVisibility(playerView, config.getShowSettings());
        setPlayPauseButtonVisibility(playerView, config.getShowPlayPause());
        setBottomBarVisibility(playerView, config.getShowBottomBar());
    }
}
