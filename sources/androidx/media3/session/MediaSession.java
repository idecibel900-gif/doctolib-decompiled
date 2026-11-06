package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MediaSession {
    private final MediaSessionImpl impl;
    private static final Object STATIC_LOCK = new Object();
    private static final HashMap SESSION_ID_TO_SESSION_MAP = new HashMap();

    interface ControllerCb {
        default void onAudioAttributesChanged(int i, AudioAttributes audioAttributes) {
        }

        default void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
        }

        default void onDeviceInfoChanged(int i, DeviceInfo deviceInfo) {
        }

        default void onDeviceVolumeChanged(int i, int i2, boolean z) {
        }

        default void onDisconnected(int i) {
        }

        default void onIsLoadingChanged(int i, boolean z) {
        }

        default void onIsPlayingChanged(int i, boolean z) {
        }

        default void onLibraryResult(int i, LibraryResult libraryResult) {
        }

        default void onMediaItemTransition(int i, MediaItem mediaItem, int i2) {
        }

        default void onMediaMetadataChanged(int i, MediaMetadata mediaMetadata) {
        }

        default void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i2) {
        }

        default void onPlayWhenReadyChanged(int i, boolean z, int i2) {
        }

        default void onPlaybackParametersChanged(int i, PlaybackParameters playbackParameters) {
        }

        default void onPlaybackStateChanged(int i, int i2, PlaybackException playbackException) {
        }

        default void onPlaybackSuppressionReasonChanged(int i, int i2) {
        }

        default void onPlayerChanged(int i, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) {
        }

        default void onPlayerError(int i, PlaybackException playbackException) {
        }

        default void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2) {
        }

        default void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) {
        }

        default void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        }

        default void onRenderedFirstFrame(int i) {
        }

        default void onRepeatModeChanged(int i, int i2) {
        }

        default void onSessionResult(int i, SessionResult sessionResult) {
        }

        default void onShuffleModeEnabledChanged(int i, boolean z) {
        }

        default void onTimelineChanged(int i, Timeline timeline, int i2) {
        }

        default void onTrackSelectionParametersChanged(int i, TrackSelectionParameters trackSelectionParameters) {
        }

        default void onTracksChanged(int i, Tracks tracks) {
        }

        default void onVideoSizeChanged(int i, VideoSize videoSize) {
        }

        default void onVolumeChanged(int i, float f) {
        }

        default void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) {
        }
    }

    public static final class Builder extends BuilderBase {
        public Builder(Context context, Player player) {
            super(context, player, new Callback() { // from class: androidx.media3.session.MediaSession.Builder.1
            });
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setId(String str) {
            return (Builder) super.setId(str);
        }

        public MediaSession build() {
            if (this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new DataSourceBitmapLoader(this.context));
            }
            return new MediaSession(this.context, this.id, this.player, this.sessionActivity, this.customLayout, this.mediaButtonPreferences, this.commandButtonsForMediaItems, this.callback, this.tokenExtras, this.sessionExtras, (BitmapLoader) Assertions.checkNotNull(this.bitmapLoader), this.playIfSuppressed, this.isPeriodicPositionUpdateEnabled, 0);
        }
    }

    public static final class ControllerInfo {
        private final Bundle connectionHints;
        private final ControllerCb controllerCb;
        private final int interfaceVersion;
        private final boolean isTrusted;
        private final int libraryVersion;
        private final int maxCommandsForMediaItems;
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;

        ControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i, int i2, boolean z, ControllerCb controllerCb, Bundle bundle, int i3) {
            this.remoteUserInfo = remoteUserInfo;
            this.libraryVersion = i;
            this.interfaceVersion = i2;
            this.isTrusted = z;
            this.controllerCb = controllerCb;
            this.connectionHints = bundle;
            this.maxCommandsForMediaItems = i3;
        }

        MediaSessionManager.RemoteUserInfo getRemoteUserInfo() {
            return this.remoteUserInfo;
        }

        public int getControllerVersion() {
            return this.libraryVersion;
        }

        public int getInterfaceVersion() {
            return this.interfaceVersion;
        }

        public String getPackageName() {
            return this.remoteUserInfo.getPackageName();
        }

        public Bundle getConnectionHints() {
            return new Bundle(this.connectionHints);
        }

        public boolean isTrusted() {
            return this.isTrusted;
        }

        public int hashCode() {
            return Objects.hash(this.controllerCb, this.remoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.controllerCb;
            if (controllerCb != null || controllerInfo.controllerCb != null) {
                return Objects.equals(controllerCb, controllerInfo.controllerCb);
            }
            return this.remoteUserInfo.equals(controllerInfo.remoteUserInfo);
        }

        public String toString() {
            return "ControllerInfo {pkg=" + this.remoteUserInfo.getPackageName() + ", uid=" + this.remoteUserInfo.getUid() + "}";
        }

        ControllerCb getControllerCb() {
            return this.controllerCb;
        }
    }

    MediaSession(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList immutableList, ImmutableList immutableList2, ImmutableList immutableList3, Callback callback, Bundle bundle, Bundle bundle2, BitmapLoader bitmapLoader, boolean z, boolean z2, int i) {
        synchronized (STATIC_LOCK) {
            HashMap map = SESSION_ID_TO_SESSION_MAP;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
            map.put(str, this);
        }
        this.impl = createImpl(context, str, player, pendingIntent, immutableList, immutableList2, immutableList3, callback, bundle, bundle2, bitmapLoader, z, z2, i);
    }

    MediaSessionImpl createImpl(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList immutableList, ImmutableList immutableList2, ImmutableList immutableList3, Callback callback, Bundle bundle, Bundle bundle2, BitmapLoader bitmapLoader, boolean z, boolean z2, int i) {
        return new MediaSessionImpl(this, context, str, player, pendingIntent, immutableList, immutableList2, immutableList3, callback, bundle, bundle2, bitmapLoader, z, z2);
    }

    public final void release() {
        try {
            synchronized (STATIC_LOCK) {
                SESSION_ID_TO_SESSION_MAP.remove(this.impl.getId());
            }
            this.impl.release();
        } catch (Exception unused) {
        }
    }

    public ControllerInfo getMediaNotificationControllerInfo() {
        return this.impl.getMediaNotificationControllerInfo();
    }

    public ImmutableList getCustomLayout() {
        return this.impl.getCustomLayout();
    }

    public ImmutableList getMediaButtonPreferences() {
        return this.impl.getMediaButtonPreferences();
    }

    public interface Callback {
        default void onDisconnected(MediaSession mediaSession, ControllerInfo controllerInfo) {
        }

        default boolean onMediaButtonEvent(MediaSession mediaSession, ControllerInfo controllerInfo, Intent intent) {
            return false;
        }

        default int onPlayerCommandRequest(MediaSession mediaSession, ControllerInfo controllerInfo, int i) {
            return 0;
        }

        default void onPlayerInteractionFinished(MediaSession mediaSession, ControllerInfo controllerInfo, Player.Commands commands) {
        }

        default void onPostConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
        }

        default ConnectionResult onConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
            return new ConnectionResult.AcceptedResultBuilder(mediaSession).build();
        }

        default ListenableFuture onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, String str, Rating rating) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, Rating rating) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture onCustomCommand(MediaSession mediaSession, ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture onAddMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((MediaItem) it.next()).localConfiguration == null) {
                    return Futures.immediateFailedFuture(new UnsupportedOperationException());
                }
            }
            return Futures.immediateFuture(list);
        }

        default ListenableFuture onSetMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List list, final int i, final long j) {
            return Util.transformFutureAsync(onAddMediaItems(mediaSession, controllerInfo, list), new AsyncFunction() { // from class: androidx.media3.session.MediaSession$Callback$$ExternalSyntheticLambda0
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return Futures.immediateFuture(new MediaSession.MediaItemsWithStartPosition((List) obj, i, j));
                }
            });
        }

        default ListenableFuture onPlaybackResumption(MediaSession mediaSession, ControllerInfo controllerInfo) {
            return Futures.immediateFailedFuture(new UnsupportedOperationException());
        }
    }

    public static final class MediaItemsWithStartPosition {
        public final ImmutableList mediaItems;
        public final int startIndex;
        public final long startPositionMs;

        public MediaItemsWithStartPosition(List list, int i, long j) {
            this.mediaItems = ImmutableList.copyOf((Collection) list);
            this.startIndex = i;
            this.startPositionMs = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemsWithStartPosition)) {
                return false;
            }
            MediaItemsWithStartPosition mediaItemsWithStartPosition = (MediaItemsWithStartPosition) obj;
            return this.mediaItems.equals(mediaItemsWithStartPosition.mediaItems) && this.startIndex == mediaItemsWithStartPosition.startIndex && this.startPositionMs == mediaItemsWithStartPosition.startPositionMs;
        }

        public int hashCode() {
            return (((this.mediaItems.hashCode() * 31) + this.startIndex) * 31) + Longs.hashCode(this.startPositionMs);
        }
    }

    public static final class ConnectionResult {
        public final Player.Commands availablePlayerCommands;
        public final SessionCommands availableSessionCommands;
        public final ImmutableList customLayout;
        public final boolean isAccepted;
        public final ImmutableList mediaButtonPreferences;
        public final PendingIntent sessionActivity;
        public final Bundle sessionExtras;
        public static final SessionCommands DEFAULT_SESSION_COMMANDS = new SessionCommands.Builder().addAllSessionCommands().build();
        public static final SessionCommands DEFAULT_SESSION_AND_LIBRARY_COMMANDS = new SessionCommands.Builder().addAllLibraryCommands().addAllSessionCommands().build();
        public static final Player.Commands DEFAULT_PLAYER_COMMANDS = new Player.Commands.Builder().addAllCommands().build();

        public static class AcceptedResultBuilder {
            private Player.Commands availablePlayerCommands = ConnectionResult.DEFAULT_PLAYER_COMMANDS;
            private SessionCommands availableSessionCommands = ConnectionResult.DEFAULT_SESSION_COMMANDS;
            private ImmutableList customLayout;
            private ImmutableList mediaButtonPreferences;
            private PendingIntent sessionActivity;
            private Bundle sessionExtras;

            public AcceptedResultBuilder(MediaSession mediaSession) {
            }

            public AcceptedResultBuilder setAvailableSessionCommands(SessionCommands sessionCommands) {
                this.availableSessionCommands = (SessionCommands) Assertions.checkNotNull(sessionCommands);
                return this;
            }

            public AcceptedResultBuilder setAvailablePlayerCommands(Player.Commands commands) {
                this.availablePlayerCommands = (Player.Commands) Assertions.checkNotNull(commands);
                return this;
            }

            public AcceptedResultBuilder setCustomLayout(List list) {
                this.customLayout = list == null ? null : ImmutableList.copyOf((Collection) list);
                return this;
            }

            public AcceptedResultBuilder setMediaButtonPreferences(List list) {
                this.mediaButtonPreferences = list == null ? null : ImmutableList.copyOf((Collection) list);
                return this;
            }

            public ConnectionResult build() {
                return new ConnectionResult(true, this.availableSessionCommands, this.availablePlayerCommands, this.customLayout, this.mediaButtonPreferences, this.sessionExtras, this.sessionActivity);
            }
        }

        private ConnectionResult(boolean z, SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, ImmutableList immutableList2, Bundle bundle, PendingIntent pendingIntent) {
            this.isAccepted = z;
            this.availableSessionCommands = sessionCommands;
            this.availablePlayerCommands = commands;
            this.customLayout = immutableList;
            this.mediaButtonPreferences = immutableList2;
            this.sessionExtras = bundle;
            this.sessionActivity = pendingIntent;
        }

        public static ConnectionResult accept(SessionCommands sessionCommands, Player.Commands commands) {
            return new ConnectionResult(true, sessionCommands, commands, null, null, null, null);
        }
    }

    static abstract class BuilderBase {
        BitmapLoader bitmapLoader;
        Callback callback;
        ImmutableList commandButtonsForMediaItems;
        final Context context;
        ImmutableList customLayout;
        String id;
        boolean isPeriodicPositionUpdateEnabled;
        ImmutableList mediaButtonPreferences;
        boolean playIfSuppressed;
        final Player player;
        PendingIntent sessionActivity;
        Bundle sessionExtras;
        Bundle tokenExtras;

        public BuilderBase(Context context, Player player, Callback callback) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.player = (Player) Assertions.checkNotNull(player);
            Assertions.checkArgument(player.canAdvertiseSession());
            this.id = "";
            this.callback = callback;
            this.tokenExtras = new Bundle();
            this.sessionExtras = new Bundle();
            this.customLayout = ImmutableList.of();
            this.mediaButtonPreferences = ImmutableList.of();
            this.playIfSuppressed = true;
            this.isPeriodicPositionUpdateEnabled = true;
            this.commandButtonsForMediaItems = ImmutableList.of();
        }

        public BuilderBase setId(String str) {
            this.id = (String) Assertions.checkNotNull(str);
            return this;
        }
    }
}
