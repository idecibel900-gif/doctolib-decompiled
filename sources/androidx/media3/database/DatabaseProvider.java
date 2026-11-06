package androidx.media3.database;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public interface DatabaseProvider {
    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
