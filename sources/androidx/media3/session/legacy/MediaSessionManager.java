package androidx.media3.session.legacy;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager {
    static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
    private static final Object lock = new Object();
    private static volatile MediaSessionManager sessionManager;
    MediaSessionManagerImpl impl;

    interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    public static MediaSessionManager getSessionManager(Context context) {
        MediaSessionManager mediaSessionManager;
        synchronized (lock) {
            try {
                if (sessionManager == null) {
                    sessionManager = new MediaSessionManager(context.getApplicationContext());
                }
                mediaSessionManager = sessionManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaSessionManager;
    }

    private MediaSessionManager(Context context) {
        this.impl = new MediaSessionManagerImpl(context);
    }

    public boolean isTrustedForMediaControl(RemoteUserInfo remoteUserInfo) {
        return this.impl.isTrustedForMediaControl(remoteUserInfo.impl);
    }

    public static final class RemoteUserInfo {
        RemoteUserInfoImpl impl;

        public RemoteUserInfo(String str, int i, int i2) {
            if (str == null) {
                throw new NullPointerException("package shouldn't be null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                this.impl = new RemoteUserInfoImplApi28(str, i, i2);
            } else {
                this.impl = new RemoteUserInfoImplBase(str, i, i2);
            }
        }

        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            String packageName = RemoteUserInfoImplApi28.getPackageName(remoteUserInfo);
            if (packageName == null) {
                throw new NullPointerException("package shouldn't be null");
            }
            if (TextUtils.isEmpty(packageName)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            this.impl = new RemoteUserInfoImplApi28(remoteUserInfo);
        }

        public String getPackageName() {
            return this.impl.getPackageName();
        }

        public int getPid() {
            return this.impl.getPid();
        }

        public int getUid() {
            return this.impl.getUid();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.impl.equals(((RemoteUserInfo) obj).impl);
            }
            return false;
        }

        public int hashCode() {
            return this.impl.hashCode();
        }
    }

    private static class MediaSessionManagerImpl {
        private static final boolean DEBUG = MediaSessionManager.DEBUG;
        ContentResolver contentResolver;
        Context context;

        MediaSessionManagerImpl(Context context) {
            this.context = context;
            this.contentResolver = context.getContentResolver();
        }

        public boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl) {
            if (hasMediaControlPermission(remoteUserInfoImpl)) {
                return true;
            }
            try {
                if (this.context.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0) == null) {
                    return false;
                }
                return isPermissionGranted(remoteUserInfoImpl, "android.permission.STATUS_BAR_SERVICE") || isPermissionGranted(remoteUserInfoImpl, "android.permission.MEDIA_CONTENT_CONTROL") || remoteUserInfoImpl.getUid() == 1000 || isEnabledNotificationListener(remoteUserInfoImpl);
            } catch (PackageManager.NameNotFoundException unused) {
                if (DEBUG) {
                    remoteUserInfoImpl.getPackageName();
                }
                return false;
            }
        }

        private boolean hasMediaControlPermission(RemoteUserInfoImpl remoteUserInfoImpl) {
            return this.context.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
        }

        private boolean isPermissionGranted(RemoteUserInfoImpl remoteUserInfoImpl, String str) {
            if (remoteUserInfoImpl.getPid() < 0) {
                return this.context.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0;
            }
            return this.context.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
        }

        boolean isEnabledNotificationListener(RemoteUserInfoImpl remoteUserInfoImpl) {
            String string = Settings.Secure.getString(this.contentResolver, "enabled_notification_listeners");
            if (string != null) {
                for (String str : string.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                    if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private static class RemoteUserInfoImplBase implements RemoteUserInfoImpl {
        private final String packageName;
        private final int pid;
        private final int uid;

        RemoteUserInfoImplBase(String str, int i, int i2) {
            this.packageName = str;
            this.pid = i;
            this.uid = i2;
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.packageName;
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.pid;
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.uid;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
            if (this.pid < 0 || remoteUserInfoImplBase.pid < 0) {
                return TextUtils.equals(this.packageName, remoteUserInfoImplBase.packageName) && this.uid == remoteUserInfoImplBase.uid;
            }
            return TextUtils.equals(this.packageName, remoteUserInfoImplBase.packageName) && this.pid == remoteUserInfoImplBase.pid && this.uid == remoteUserInfoImplBase.uid;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.packageName, Integer.valueOf(this.uid));
        }
    }

    private static final class RemoteUserInfoImplApi28 extends RemoteUserInfoImplBase {
        RemoteUserInfoImplApi28(String str, int i, int i2) {
            super(str, i, i2);
        }

        RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        }

        static String getPackageName(android.media.session.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            return remoteUserInfo.getPackageName();
        }
    }
}
