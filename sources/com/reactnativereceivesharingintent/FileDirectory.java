package com.reactnativereceivesharingintent;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.revenuecat.purchases.common.Constants;
import com.vonage.webrtc.MediaStreamTrack;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class FileDirectory {
    public static final FileDirectory INSTANCE = new FileDirectory();

    private FileDirectory() {
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0147  */
    public final String getAbsolutePath(Context context, Uri uri) {
        List listEmptyList;
        Uri uri2;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                Intrinsics.checkNotNull(documentId);
                List listSplit = new Regex(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR).split(documentId, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator listIterator = listSplit.listIterator(listSplit.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            if (((String) listIterator.previous()).length() != 0) {
                                listEmptyList2 = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                                break;
                            }
                        } else {
                            listEmptyList2 = CollectionsKt.emptyList();
                            break;
                        }
                    }
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                    break;
                }
                String[] strArr = (String[]) listEmptyList2.toArray(new String[0]);
                if (StringsKt.equals("primary", strArr[0], true)) {
                    return Environment.getExternalStorageDirectory() + "/" + strArr[1];
                }
                return getDataColumn(context, uri, null, null);
            }
            if (isDownloadsDocument(uri)) {
                try {
                    String documentId2 = DocumentsContract.getDocumentId(uri);
                    Uri uri3 = Uri.parse("content://downloads/public_downloads");
                    Long lValueOf = Long.valueOf(documentId2);
                    Intrinsics.checkNotNullExpressionValue(lValueOf, "valueOf(...)");
                    Uri uriWithAppendedId = ContentUris.withAppendedId(uri3, lValueOf.longValue());
                    Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                    return getDataColumn(context, uriWithAppendedId, null, null);
                } catch (Exception unused) {
                    return getDataColumn(context, uri, null, null);
                }
            }
            if (isMediaDocument(uri)) {
                String documentId3 = DocumentsContract.getDocumentId(uri);
                Intrinsics.checkNotNull(documentId3);
                List listSplit2 = new Regex(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR).split(documentId3, 0);
                if (!listSplit2.isEmpty()) {
                    ListIterator listIterator2 = listSplit2.listIterator(listSplit2.size());
                    while (true) {
                        if (listIterator2.hasPrevious()) {
                            if (((String) listIterator2.previous()).length() != 0) {
                                listEmptyList = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                            break;
                        }
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
                String[] strArr2 = (String[]) listEmptyList.toArray(new String[0]);
                String str = strArr2[0];
                int iHashCode = str.hashCode();
                if (iHashCode != 93166550) {
                    if (iHashCode != 100313435) {
                        if (iHashCode == 112202875 && str.equals(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = null;
                        }
                    } else if (str.equals("image")) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else {
                        uri2 = null;
                    }
                } else if (str.equals(MediaStreamTrack.AUDIO_TRACK_KIND)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                } else {
                    uri2 = null;
                }
                if (uri2 == null) {
                    return null;
                }
                return getDataColumn(context, uri2, "_id=?", new String[]{strArr2[1]});
            }
        } else if (StringsKt.equals("content", uri.getScheme(), true)) {
            return getDataColumn(context, uri, null, null);
        }
        return uri.getPath();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0038  */
    private final String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Throwable th;
        Throwable th2;
        File file;
        String str2;
        Cursor cursor = null;
        if (uri.getAuthority() != null) {
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, str, strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            file = new File(context.getCacheDir(), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name")));
                        } else {
                            file = null;
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        cursor = cursorQuery;
                        if (cursor == null) {
                            throw th2;
                        }
                        cursor.close();
                        throw th2;
                    }
                } else {
                    file = null;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (file == null) {
                    String type = context.getContentResolver().getType(uri);
                    String str3 = type == null ? "" : type;
                    if (StringsKt.startsWith$default(str3, "image", false, 2, (Object) null)) {
                        str2 = "IMG";
                    } else {
                        str2 = StringsKt.startsWith$default(str3, MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, (Object) null) ? "VID" : "FILE";
                    }
                    String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(type);
                    file = new File(context.getCacheDir(), str2 + "_" + new Date().getTime() + "." + extensionFromMimeType);
                }
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                            CloseableKt.closeFinally(fileOutputStream, null);
                            CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                CloseableKt.closeFinally(fileOutputStream, th4);
                                throw th5;
                            }
                        }
                    } catch (Throwable th6) {
                        try {
                            throw th6;
                        } catch (Throwable th7) {
                            CloseableKt.closeFinally(inputStreamOpenInputStream, th6);
                            throw th7;
                        }
                    }
                }
                return file.getPath();
            } catch (Throwable th8) {
                th2 = th8;
            }
        } else {
            try {
                Cursor cursorQuery2 = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursorQuery2 != null) {
                    try {
                        if (cursorQuery2.moveToFirst()) {
                            String string = cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("_data"));
                            cursorQuery2.close();
                            return string;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        cursor = cursorQuery2;
                        if (cursor == null) {
                            throw th;
                        }
                        cursor.close();
                        throw th;
                    }
                }
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
                return null;
            } catch (Throwable th10) {
                th = th10;
            }
        }
    }

    public final boolean isExternalStorageDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final boolean isDownloadsDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.providers.downloads.documents", uri.getAuthority());
    }

    public final boolean isMediaDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.providers.media.documents", uri.getAuthority());
    }
}
