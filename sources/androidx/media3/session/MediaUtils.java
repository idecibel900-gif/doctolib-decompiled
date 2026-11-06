package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$BrowserRoot;

/* JADX INFO: loaded from: classes.dex */
abstract class MediaUtils {
    public static final MediaBrowserServiceCompat$BrowserRoot defaultBrowserRoot;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.session.legacy.MediaBrowserServiceCompat$BrowserRoot] */
    static {
        final String str = "androidx.media3.session.MediaLibraryService";
        final Bundle bundle = null;
        defaultBrowserRoot = new Object(str, bundle) { // from class: androidx.media3.session.legacy.MediaBrowserServiceCompat$BrowserRoot
            private final Bundle extras;
            private final String rootId;

            {
                if (str == null) {
                    throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
                }
                this.rootId = str;
                this.extras = bundle;
            }
        };
    }

    public static Player.Commands intersect(Player.Commands commands, Player.Commands commands2) {
        if (commands == null || commands2 == null) {
            return Player.Commands.EMPTY;
        }
        Player.Commands.Builder builder = new Player.Commands.Builder();
        for (int i = 0; i < commands.size(); i++) {
            if (commands2.contains(commands.get(i))) {
                builder.add(commands.get(i));
            }
        }
        return builder.build();
    }

    public static void setMediaItemsWithStartIndexAndPosition(Player player, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
        if (mediaItemsWithStartPosition.startIndex == -1) {
            if (player.isCommandAvailable(20)) {
                player.setMediaItems(mediaItemsWithStartPosition.mediaItems, true);
                return;
            } else {
                if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                    return;
                }
                player.setMediaItem((MediaItem) mediaItemsWithStartPosition.mediaItems.get(0), true);
                return;
            }
        }
        if (player.isCommandAvailable(20)) {
            player.setMediaItems(mediaItemsWithStartPosition.mediaItems, mediaItemsWithStartPosition.startIndex, mediaItemsWithStartPosition.startPositionMs);
        } else {
            if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                return;
            }
            player.setMediaItem((MediaItem) mediaItemsWithStartPosition.mediaItems.get(0), mediaItemsWithStartPosition.startPositionMs);
        }
    }

    public static boolean areSessionPositionInfosInSamePeriodOrAd(SessionPositionInfo sessionPositionInfo, SessionPositionInfo sessionPositionInfo2) {
        Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
        int i = positionInfo.mediaItemIndex;
        Player.PositionInfo positionInfo2 = sessionPositionInfo2.positionInfo;
        return i == positionInfo2.mediaItemIndex && positionInfo.periodIndex == positionInfo2.periodIndex && positionInfo.adGroupIndex == positionInfo2.adGroupIndex && positionInfo.adIndexInAdGroup == positionInfo2.adIndexInAdGroup;
    }
}
