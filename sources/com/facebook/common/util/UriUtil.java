package com.facebook.common.util;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.adjust.sdk.Constants;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Assertions;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UriUtil {
    private static final Uri LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath((Uri) Assertions.assumeNotNull(ContactsContract.AUTHORITY_URI), "display_photo");

    public static URL uriToUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isNetworkUri(Uri uri) {
        String schemeOrNull = getSchemeOrNull(uri);
        return Constants.SCHEME.equals(schemeOrNull) || "http".equals(schemeOrNull);
    }

    public static boolean isLocalFileUri(Uri uri) {
        return "file".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContentUri(Uri uri) {
        return "content".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalContactUri(Uri uri) {
        return uri.getPath() != null && isLocalContentUri(uri) && "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith((String) Assertions.assumeNotNull(LOCAL_CONTACT_IMAGE_URI.getPath()));
    }

    public static boolean isLocalCameraUri(Uri uri) {
        String string = uri.toString();
        return string.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || string.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean isLocalAssetUri(Uri uri) {
        return "asset".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalResourceUri(Uri uri) {
        return "res".equals(getSchemeOrNull(uri));
    }

    public static boolean isQualifiedResourceUri(Uri uri) {
        return "android.resource".equals(getSchemeOrNull(uri));
    }

    public static boolean isDataUri(Uri uri) {
        return com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE.equals(getSchemeOrNull(uri));
    }

    public static String getSchemeOrNull(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static String getRealPathFromUri(ContentResolver contentResolver, Uri uri) {
        Uri uri2;
        String str;
        String[] strArr;
        int columnIndexOrThrow;
        String type = contentResolver.getType(uri);
        String string = null;
        if (isLocalContentUri(uri)) {
            boolean z = type != null && type.startsWith("video/");
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(uri);
                Preconditions.checkNotNull(documentId);
                uri2 = (Uri) Preconditions.checkNotNull(getExternalContentUri(z));
                str = getMediaIdString(z) + "=?";
                strArr = new String[]{documentId.split(com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)[1]};
            } else {
                uri2 = uri;
                str = null;
                strArr = null;
            }
            Cursor cursorQuery = contentResolver.query(uri2, new String[]{getDataPathString(z)}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst() && (columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(getDataPathString(z))) != -1) {
                        string = cursorQuery.getString(columnIndexOrThrow);
                    }
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        }
        if (isLocalFileUri(uri)) {
            return uri.getPath();
        }
        return null;
    }

    private static Uri getExternalContentUri(boolean z) {
        if (z) {
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    private static String getMediaIdString(boolean z) {
        return "_id";
    }

    private static String getDataPathString(boolean z) {
        return "_data";
    }

    public static AssetFileDescriptor getAssetFileDescriptor(ContentResolver contentResolver, Uri uri) {
        if (isLocalContentUri(uri)) {
            try {
                return contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
