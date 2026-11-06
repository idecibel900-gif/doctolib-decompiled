package androidx.media3.session.legacy;

import android.content.Context;
import android.media.session.MediaController;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.view.KeyEvent;
import androidx.versionedparcelable.ParcelUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {
    private final MediaControllerImpl impl;
    private final Set registeredCallbacks;
    private final MediaSessionCompat.Token token;

    interface MediaControllerImpl {
        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        CharSequence getQueueTitle();
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        this(context, mediaSessionCompat.getSessionToken());
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        this.registeredCallbacks = Collections.synchronizedSet(new HashSet());
        this.token = token;
        if (Build.VERSION.SDK_INT >= 29) {
            this.impl = new MediaControllerImplApi29(context, token);
        } else {
            this.impl = new MediaControllerImplApi21(context, token);
        }
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.impl.dispatchMediaButtonEvent(keyEvent);
    }

    public CharSequence getQueueTitle() {
        return this.impl.getQueueTitle();
    }

    public static abstract class Callback implements IBinder.DeathRecipient {

        private static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference callback;

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) {
            }

            StubCompat(Callback callback) {
                this.callback = new WeakReference(callback);
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.callback.get());
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.callback.get());
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.callback.get());
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onRepeatModeChanged(int i) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.callback.get());
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onShuffleModeChanged(int i) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.callback.get());
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onSessionReady() {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(this.callback.get());
            }
        }
    }

    static class MediaControllerImplApi21 implements MediaControllerImpl {
        protected final MediaController controllerFwk;
        final MediaSessionCompat.Token sessionToken;
        final Object lock = new Object();
        private final List pendingCallbacks = new ArrayList();
        private final HashMap callbackMap = new HashMap();

        MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.sessionToken = token;
            this.controllerFwk = new MediaController(context, token.getToken());
            if (token.getExtraBinder() == null) {
                requestExtraBinder();
            }
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return this.controllerFwk.dispatchMediaButtonEvent(keyEvent);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return this.controllerFwk.getQueueTitle();
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.controllerFwk.sendCommand(str, bundle, resultReceiver);
        }

        private void requestExtraBinder() {
            sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        void processPendingCallbacksLocked() {
            if (this.sessionToken.getExtraBinder() == null) {
                return;
            }
            Iterator it = this.pendingCallbacks.iterator();
            if (it.hasNext()) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
                this.callbackMap.put(null, new ExtraCallback(null));
                throw null;
            }
            this.pendingCallbacks.clear();
        }

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private final WeakReference mediaControllerImpl;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.mediaControllerImpl = new WeakReference(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.mediaControllerImpl.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.lock) {
                    mediaControllerImplApi21.sessionToken.setExtraBinder(IMediaSession.Stub.asInterface(bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.sessionToken.setSession2Token(ParcelUtils.getVersionedParcelable(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                    mediaControllerImplApi21.processPendingCallbacksLocked();
                }
            }
        }

        private static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onSessionDestroyed() {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onQueueChanged(List list) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // androidx.media3.session.legacy.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }
    }

    static class MediaControllerImplApi29 extends MediaControllerImplApi21 {
        MediaControllerImplApi29(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }
}
