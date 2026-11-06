package cl.json;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import androidx.loader.content.CursorLoader;
import com.facebook.react.bridge.ReactContext;
import com.revenuecat.purchases.common.Constants;
import com.vonage.webrtc.MediaStreamTrack;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RNSharePathUtil {
    private static final ArrayList authorities = new ArrayList();

    public static void compileAuthorities(ReactContext reactContext) {
        ArrayList arrayList = authorities;
        if (arrayList.size() == 0) {
            arrayList.add(reactContext.getPackageName() + ".rnshare.fileprovider");
        }
    }

    public static Uri compatUriFromFile(ReactContext reactContext, File file) {
        compileAuthorities(reactContext);
        String authority = Uri.fromFile(file).getAuthority();
        if (!TextUtils.isEmpty(authority) && authorities.contains(authority)) {
            return Uri.fromFile(file);
        }
        if (file.getAbsolutePath().startsWith("content://")) {
            return Uri.fromFile(file);
        }
        Uri uriForFile = null;
        int i = 0;
        while (true) {
            ArrayList arrayList = authorities;
            if (i >= arrayList.size()) {
                break;
            }
            try {
                uriForFile = FileProvider.getUriForFile(reactContext, (String) arrayList.get(i), file);
                if (uriForFile != null) {
                    break;
                }
                i++;
            } catch (Exception e) {
                System.out.println("RNSharePathUtil::compatUriFromFile ERROR " + e.getMessage());
            }
        }
        return uriForFile;
    }

    public static String getRealPathFromURI(Context context, Uri uri, Boolean bool) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                String str = strArrSplit[0];
                if ("primary".equalsIgnoreCase(str) || "0".equalsIgnoreCase(str)) {
                    return "" + (bool.booleanValue() ? context.getCacheDir() : context.getExternalCacheDir()) + "/" + strArrSplit[1];
                }
                if ("raw".equalsIgnoreCase(str)) {
                    return "" + strArrSplit[1];
                }
                if (!TextUtils.isEmpty(str)) {
                    return "/storage/" + str + "/" + strArrSplit[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (documentId.startsWith("raw:")) {
                        return "" + documentId.replaceFirst("raw:", "");
                    }
                    return "" + getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                    String str2 = strArrSplit2[0];
                    if ("image".equals(str2)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (MediaStreamTrack.VIDEO_TRACK_KIND.equals(str2)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (MediaStreamTrack.AUDIO_TRACK_KIND.equals(str2)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    } else if ("raw".equalsIgnoreCase(str2)) {
                        return "" + strArrSplit2[1];
                    }
                    return "" + getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return "" + getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0047  */
    /* JADX WARN: Code duplicated, block: B:33:? A[SYNTHETIC] */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Throwable th;
        Exception exc;
        Cursor cursorLoadInBackground;
        Cursor cursor = null;
        try {
            cursorLoadInBackground = new CursorLoader(context, uri, new String[]{"_data"}, str, strArr, null).loadInBackground();
            if (cursorLoadInBackground != null) {
                try {
                    try {
                        if (cursorLoadInBackground.moveToFirst()) {
                            String string = cursorLoadInBackground.getString(cursorLoadInBackground.getColumnIndexOrThrow("_data"));
                            cursorLoadInBackground.close();
                            return string;
                        }
                    } catch (Exception e) {
                        exc = e;
                        exc.printStackTrace();
                        if (cursorLoadInBackground != null) {
                            cursorLoadInBackground.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorLoadInBackground;
                    if (cursor != null) {
                        cursor.close();
                        throw th;
                    }
                    throw th;
                }
            }
            if (cursorLoadInBackground != null) {
                cursorLoadInBackground.close();
            }
            return null;
        } catch (Exception e2) {
            exc = e2;
            cursorLoadInBackground = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
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
