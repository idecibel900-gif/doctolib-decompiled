package app.screeb.sdk;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import app.screeb.sdk.internal.Y;
import app.screeb.sdk.internal.Z;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ScreebFilePickerActivity extends Activity {
    public static volatile ValueCallback a;
    public static final ExecutorService b;

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: app.screeb.sdk.ScreebFilePickerActivity$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return ScreebFilePickerActivity.a(runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        b = executorServiceNewSingleThreadExecutor;
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "screeb-file-picker");
        thread.setDaemon(true);
        return thread;
    }

    public static final void a(ValueCallback valueCallback, List list, ScreebFilePickerActivity screebFilePickerActivity) {
        if (valueCallback != null) {
            Object[] array = list.toArray(new Uri[0]);
            if (array.length == 0) {
                array = null;
            }
            valueCallback.onReceiveValue(array);
        }
        screebFilePickerActivity.finish();
    }

    public static final void a(ScreebFilePickerActivity screebFilePickerActivity) {
        try {
            File[] fileArrListFiles = new File(screebFilePickerActivity.getCacheDir(), "screeb_uploads").listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static final void a(List list, final ScreebFilePickerActivity screebFilePickerActivity, final ValueCallback valueCallback) throws Throwable {
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uriA = screebFilePickerActivity.a((Uri) it.next());
            if (uriA != null) {
                arrayList.add(uriA);
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: app.screeb.sdk.ScreebFilePickerActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ScreebFilePickerActivity.a(valueCallback, arrayList, screebFilePickerActivity);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0054 A[Catch: Exception -> 0x0034, TryCatch #7 {Exception -> 0x0034, blocks: (B:3:0x0003, B:15:0x0030, B:33:0x0054, B:34:0x0069, B:38:0x0089, B:50:0x009e, B:51:0x00a1, B:30:0x004b, B:31:0x004e, B:26:0x0044, B:27:0x0047, B:37:0x0086, B:46:0x0098, B:47:0x009b, B:36:0x0083, B:44:0x0096, B:48:0x009c), top: B:64:0x0003, inners: #1, #8 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x0054, please report this as an issue */
    public final Uri a(Uri uri) throws Throwable {
        Cursor cursorQuery;
        Uri uri2;
        String lastPathSegment;
        FileOutputStream fileOutputStream;
        int columnIndex;
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            try {
                try {
                    uri2 = uri;
                    try {
                        try {
                            try {
                                cursorQuery = getContentResolver().query(uri2, new String[]{"_display_name"}, null, null, null);
                                if (cursorQuery != null) {
                                    try {
                                        if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_display_name")) >= 0) {
                                            lastPathSegment = cursorQuery.getString(columnIndex);
                                            cursorQuery.close();
                                        }
                                    } catch (Exception unused) {
                                        if (cursorQuery != null) {
                                        }
                                        lastPathSegment = uri2.getLastPathSegment();
                                        if (lastPathSegment == null) {
                                            lastPathSegment = "screeb_upload_" + System.currentTimeMillis();
                                        }
                                        File file = new File(getCacheDir(), "screeb_uploads");
                                        file.mkdirs();
                                        File file2 = new File(file, lastPathSegment);
                                        fileOutputStream = new FileOutputStream(file2);
                                        ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                                        CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                                        CloseableKt.closeFinally(fileOutputStream, null);
                                        return Uri.fromFile(file2);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        throw th;
                                    }
                                    if (lastPathSegment == null) {
                                        lastPathSegment = "screeb_upload_" + System.currentTimeMillis();
                                    }
                                    File file3 = new File(getCacheDir(), "screeb_uploads");
                                    file3.mkdirs();
                                    File file4 = new File(file3, lastPathSegment);
                                    fileOutputStream = new FileOutputStream(file4);
                                    ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                                    CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    return Uri.fromFile(file4);
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            } catch (Exception unused2) {
                                cursorQuery = null;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                lastPathSegment = uri2.getLastPathSegment();
                                if (lastPathSegment == null) {
                                    lastPathSegment = "screeb_upload_" + System.currentTimeMillis();
                                }
                                File file5 = new File(getCacheDir(), "screeb_uploads");
                                file5.mkdirs();
                                File file6 = new File(file5, lastPathSegment);
                                fileOutputStream = new FileOutputStream(file6);
                                ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                                CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                                CloseableKt.closeFinally(fileOutputStream, null);
                                return Uri.fromFile(file6);
                            }
                            ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                            CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                            CloseableKt.closeFinally(fileOutputStream, null);
                            return Uri.fromFile(file6);
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                CloseableKt.closeFinally(inputStreamOpenInputStream, th2);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(fileOutputStream, th4);
                            throw th5;
                        }
                    }
                } catch (Exception unused3) {
                    uri2 = uri;
                }
                lastPathSegment = uri2.getLastPathSegment();
                if (lastPathSegment == null) {
                    lastPathSegment = "screeb_upload_" + System.currentTimeMillis();
                }
                File file7 = new File(getCacheDir(), "screeb_uploads");
                file7.mkdirs();
                File file8 = new File(file7, lastPathSegment);
                fileOutputStream = new FileOutputStream(file8);
            } catch (Throwable th6) {
                th = th6;
                cursorQuery = null;
            }
        } catch (Exception e) {
            Z z = Z.b;
            Y.a();
            Z.a("FilePicker", "error while copying file to cache", e, 8);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        final List listEmptyList;
        super.onActivityResult(i, i2, intent);
        if (i != 1001) {
            finish();
            return;
        }
        final ValueCallback valueCallback = a;
        a = null;
        if (i2 != -1 || intent == null) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            Uri data = intent.getData();
            if (data != null) {
                listEmptyList = CollectionsKt.listOf(data);
            } else {
                ClipData clipData = intent.getClipData();
                if (clipData == null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    IntRange intRangeUntil = RangesKt.until(0, clipData.getItemCount());
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                    Iterator it = intRangeUntil.iterator();
                    while (it.hasNext()) {
                        arrayList.add(clipData.getItemAt(((IntIterator) it).nextInt()).getUri());
                    }
                    listEmptyList = arrayList;
                }
            }
        }
        if (!listEmptyList.isEmpty()) {
            b.execute(new Runnable() { // from class: app.screeb.sdk.ScreebFilePickerActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    ScreebFilePickerActivity.a(listEmptyList, this, valueCallback);
                }
            });
            return;
        }
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
        finish();
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000a A[PHI: r5
      0x000a: PHI (r5v11 android.webkit.ValueCallback) = (r5v7 android.webkit.ValueCallback), (r5v8 android.webkit.ValueCallback), (r5v12 android.webkit.ValueCallback) binds: [B:23:0x005a, B:16:0x0035, B:5:0x0008] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        ValueCallback valueCallback;
        super.onCreate(bundle);
        if (bundle != null) {
            valueCallback = a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        } else {
            Intent intent = (Intent) (Build.VERSION.SDK_INT >= 33 ? getIntent().getParcelableExtra("screeb_file_chooser_intent", Intent.class) : getIntent().getParcelableExtra("screeb_file_chooser_intent"));
            if (intent == null) {
                valueCallback = a;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                b.execute(new Runnable() { // from class: app.screeb.sdk.ScreebFilePickerActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreebFilePickerActivity.a(this.f$0);
                    }
                });
                try {
                    startActivityForResult(intent, 1001);
                    return;
                } catch (Exception e) {
                    Z z = Z.b;
                    Z z2 = Z.b;
                    Z z3 = Z.b;
                    Z.a("FilePicker", "error while launching file picker", e, 8);
                    valueCallback = a;
                    if (valueCallback != null) {
                    }
                }
            }
        }
        a = null;
        finish();
    }
}
