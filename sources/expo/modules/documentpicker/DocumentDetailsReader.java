package expo.modules.documentpicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentDetailsReader {
    private final Context context;

    public DocumentDetailsReader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final DocumentInfo read(Uri uri) throws IOException {
        long jCurrentTimeMillis;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Cursor cursorQuery = this.context.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            try {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                int columnIndex = cursorQuery.getColumnIndex("_size");
                Long lValueOf = !cursorQuery.isNull(columnIndex) ? Long.valueOf(cursorQuery.getLong(columnIndex)) : null;
                String type = this.context.getContentResolver().getType(uri);
                try {
                    int columnIndex2 = cursorQuery.getColumnIndex("last_modified");
                    if (columnIndex2 != -1 && !cursorQuery.isNull(columnIndex2)) {
                        jCurrentTimeMillis = cursorQuery.getLong(columnIndex2);
                    } else {
                        String path = uri.getPath();
                        if (path == null) {
                            path = "";
                        }
                        File file = new File(path);
                        if (file.exists()) {
                            jCurrentTimeMillis = file.lastModified();
                        } else {
                            jCurrentTimeMillis = System.currentTimeMillis();
                        }
                    }
                } catch (Exception unused) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                Intrinsics.checkNotNull(string);
                DocumentInfo documentInfo = new DocumentInfo(uri, string, type, lValueOf, jCurrentTimeMillis);
                CloseableKt.closeFinally(cursorQuery, null);
                return documentInfo;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
        throw new IOException("Failed to read document details for URI: " + uri);
    }
}
