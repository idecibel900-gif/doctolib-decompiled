package app.screeb.sdk;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Keep;
import app.screeb.sdk.internal.Z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class ScreebInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri p0, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri p0, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext;
        try {
            Context context = getContext();
            if (context != null && (applicationContext = context.getApplicationContext()) != null) {
                Screeb.INSTANCE.initSdkWithContextOnly(applicationContext);
                return true;
            }
            Z.a("ScreebInitProvider", "context is null", null, 12);
            return false;
        } catch (Exception e) {
            Z.a("ScreebInitProvider", "unable to init sdk", e, 8);
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri p0, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri p0, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return 0;
    }
}
