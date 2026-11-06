package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import com.vonage.webrtc.MediaStreamTrack;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MediaStoreUtil {
    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean isMediaStoreOpenFileApisAvailable() {
        return Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) >= 17;
    }

    public static AssetFileDescriptor openAssetFileDescriptor(Uri uri, ContentResolver contentResolver) {
        return MediaStore.openAssetFileDescriptor(contentResolver, uri, "r", null);
    }

    public static boolean isAndroidPickerUri(Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("picker");
    }

    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains(MediaStreamTrack.VIDEO_TRACK_KIND);
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }
}
