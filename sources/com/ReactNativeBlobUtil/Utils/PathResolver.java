package com.ReactNativeBlobUtil.Utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.common.Constants;
import com.vonage.webrtc.MediaStreamTrack;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PathResolver {
    public static String getRealPathFromURI(Context context, Uri uri) {
        Long lValueOf;
        String contentName;
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    File externalFilesDir = context.getExternalFilesDir(null);
                    if (externalFilesDir != null) {
                        return externalFilesDir + "/" + strArrSplit[1];
                    }
                    return "";
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    try {
                        String documentId = DocumentsContract.getDocumentId(uri);
                        if (documentId != null && documentId.startsWith("raw:/")) {
                            return Uri.parse(documentId).getPath();
                        }
                        if (documentId != null && documentId.startsWith("msf:")) {
                            lValueOf = Long.valueOf(documentId.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)[1]);
                        } else {
                            lValueOf = Long.valueOf(documentId);
                        }
                        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), lValueOf.longValue()), null, null);
                    } catch (Exception unused) {
                        return null;
                    }
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (MediaStreamTrack.VIDEO_TRACK_KIND.equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (MediaStreamTrack.AUDIO_TRACK_KIND.equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    if (isGooglePhotosUri(uri)) {
                        return uri.getLastPathSegment();
                    }
                    return getDataColumn(context, uri, null, null);
                }
                try {
                    InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    if (inputStreamOpenInputStream != null && (contentName = getContentName(context.getContentResolver(), uri)) != null) {
                        File file = new File(context.getCacheDir(), contentName);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET];
                        while (inputStreamOpenInputStream.read(bArr) > 0) {
                            fileOutputStream.write(bArr);
                        }
                        fileOutputStream.close();
                        inputStreamOpenInputStream.close();
                        return file.getAbsolutePath();
                    }
                } catch (Exception e) {
                    ReactNativeBlobUtilUtils.emitWarningEvent(e.toString());
                    return null;
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    private static String getContentName(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        cursorQuery.moveToFirst();
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        if (columnIndex < 0) {
            return null;
        }
        String string = cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0042  */
    /* JADX WARN: Code duplicated, block: B:31:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Throwable th;
        Exception exc;
        Cursor cursorQuery;
        ?? r7 = 0;
        string = null;
        String string = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        }
                    } catch (Exception e) {
                        exc = e;
                        exc.printStackTrace();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
                r7 = context;
                if (r7 != 0) {
                    r7.close();
                    throw th;
                }
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r7 != 0) {
                r7.close();
                throw th;
            }
            throw th;
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
