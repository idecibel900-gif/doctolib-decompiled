package com.reactnativereceivesharingintent;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.vonage.webrtc.MediaStreamTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class ReceiveSharingIntentHelper {
    private Context context;

    public ReceiveSharingIntentHelper(Application application) {
        this.context = application;
    }

    public void sendFileNames(Context context, Intent intent, Promise promise) {
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        try {
            String action = intent.getAction();
            String type = intent.getType();
            if (type == null) {
                return;
            }
            if (type.startsWith("text") || (!Objects.equals(action, "android.intent.action.SEND") && !Objects.equals(action, "android.intent.action.SEND_MULTIPLE"))) {
                if (type.startsWith("text") && Objects.equals(action, "android.intent.action.SEND")) {
                    try {
                        stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
                        try {
                            stringExtra3 = intent.getStringExtra("android.intent.extra.SUBJECT");
                        } catch (Exception unused) {
                            stringExtra3 = null;
                        }
                    } catch (Exception unused2) {
                        stringExtra2 = null;
                    }
                    if (stringExtra2 == null) {
                        Object mediaUris = getMediaUris(intent, context);
                        if (mediaUris == null) {
                            return;
                        }
                        promise.resolve(mediaUris);
                        return;
                    }
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putString("contentUri", null);
                    writableNativeMap2.putString("filePath", null);
                    writableNativeMap2.putString("fileName", null);
                    writableNativeMap2.putString("extension", null);
                    if (stringExtra2.startsWith("http")) {
                        writableNativeMap2.putString("weblink", stringExtra2);
                        writableNativeMap2.putString("text", null);
                    } else {
                        writableNativeMap2.putString("weblink", null);
                        writableNativeMap2.putString("text", stringExtra2);
                    }
                    writableNativeMap2.putString("subject", stringExtra3);
                    writableNativeMap.putMap("0", writableNativeMap2);
                    promise.resolve(writableNativeMap);
                    return;
                }
                if (Objects.equals(action, "android.intent.action.VIEW")) {
                    String dataString = intent.getDataString();
                    WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                    WritableNativeMap writableNativeMap4 = new WritableNativeMap();
                    writableNativeMap4.putString("contentUri", null);
                    writableNativeMap4.putString("filePath", null);
                    writableNativeMap4.putString("mimeType", null);
                    writableNativeMap4.putString("text", null);
                    writableNativeMap4.putString("weblink", dataString);
                    writableNativeMap4.putString("fileName", null);
                    writableNativeMap4.putString("extension", null);
                    writableNativeMap3.putMap("0", writableNativeMap4);
                    promise.resolve(writableNativeMap3);
                    return;
                }
                if (!Objects.equals(action, "android.intent.action.PROCESS_TEXT")) {
                    promise.reject("error", "Invalid file type.");
                    return;
                }
                try {
                    stringExtra = intent.getStringExtra("android.intent.extra.PROCESS_TEXT");
                } catch (Exception unused3) {
                    stringExtra = null;
                }
                WritableNativeMap writableNativeMap5 = new WritableNativeMap();
                WritableNativeMap writableNativeMap6 = new WritableNativeMap();
                writableNativeMap6.putString("contentUri", null);
                writableNativeMap6.putString("filePath", null);
                writableNativeMap6.putString("fileName", null);
                writableNativeMap6.putString("extension", null);
                writableNativeMap6.putString("weblink", null);
                writableNativeMap6.putString("text", stringExtra);
                writableNativeMap5.putMap("0", writableNativeMap6);
                promise.resolve(writableNativeMap5);
                return;
            }
            Object mediaUris2 = getMediaUris(intent, context);
            if (mediaUris2 == null) {
                return;
            }
            promise.resolve(mediaUris2);
        } catch (Exception e) {
            promise.reject("error", e.toString());
        }
    }

    public WritableMap getMediaUris(Intent intent, Context context) {
        String stringExtra;
        ArrayList parcelableArrayListExtra;
        Context context2 = context;
        if (intent == null) {
            return null;
        }
        try {
            stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        } catch (Exception unused) {
            stringExtra = null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (Objects.equals(intent.getAction(), "android.intent.action.SEND")) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri == null) {
                return null;
            }
            String absolutePath = FileDirectory.INSTANCE.getAbsolutePath(context2, uri);
            ContentResolver contentResolver = context2.getContentResolver();
            writableNativeMap2.putString("mimeType", contentResolver.getType(uri));
            Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
            cursorQuery.moveToFirst();
            writableNativeMap2.putString("fileName", cursorQuery.getString(cursorQuery.getColumnIndex("_display_name")));
            writableNativeMap2.putString("filePath", absolutePath);
            writableNativeMap2.putString("contentUri", uri.toString());
            writableNativeMap2.putString("text", null);
            writableNativeMap2.putString("weblink", null);
            writableNativeMap2.putString("subject", stringExtra);
            writableNativeMap.putMap("0", writableNativeMap2);
        } else if (Objects.equals(intent.getAction(), "android.intent.action.SEND_MULTIPLE") && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM")) != null) {
            Iterator it = parcelableArrayListExtra.iterator();
            int i = 0;
            while (it.hasNext()) {
                Uri uri2 = (Uri) it.next();
                WritableNativeMap writableNativeMap3 = new WritableNativeMap();
                ContentResolver contentResolver2 = context2.getContentResolver();
                Iterator it2 = it;
                String absolutePath2 = FileDirectory.INSTANCE.getAbsolutePath(context2, uri2);
                writableNativeMap3.putString("mimeType", contentResolver2.getType(uri2));
                Cursor cursorQuery2 = contentResolver2.query(uri2, null, null, null, null);
                cursorQuery2.moveToFirst();
                writableNativeMap3.putString("fileName", cursorQuery2.getString(cursorQuery2.getColumnIndex("_display_name")));
                writableNativeMap3.putString("filePath", absolutePath2);
                writableNativeMap3.putString("contentUri", uri2.toString());
                writableNativeMap3.putString("text", null);
                writableNativeMap3.putString("weblink", null);
                writableNativeMap3.putString("subject", stringExtra);
                writableNativeMap.putMap(Integer.toString(i), writableNativeMap3);
                i++;
                context2 = context;
                it = it2;
            }
        }
        return writableNativeMap;
    }

    public void clearFileNames(Intent intent) {
        String type = intent.getType();
        if (type == null) {
            return;
        }
        if (type.startsWith("text")) {
            intent.removeExtra("android.intent.extra.TEXT");
        } else if (type.startsWith("image") || type.startsWith(MediaStreamTrack.VIDEO_TRACK_KIND) || type.startsWith("application")) {
            intent.removeExtra("android.intent.extra.STREAM");
        }
    }
}
