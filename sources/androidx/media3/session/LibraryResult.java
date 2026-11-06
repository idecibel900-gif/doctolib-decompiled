package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.util.Util;

/* JADX INFO: loaded from: classes.dex */
public final class LibraryResult {
    public final long completionTimeMs;
    public final MediaLibraryService$LibraryParams params;
    public final int resultCode;
    public final SessionError sessionError;
    public final Object value;
    private final int valueType;
    private static final String FIELD_RESULT_CODE = Util.intToStringMaxRadix(0);
    private static final String FIELD_COMPLETION_TIME_MS = Util.intToStringMaxRadix(1);
    private static final String FIELD_PARAMS = Util.intToStringMaxRadix(2);
    private static final String FIELD_VALUE = Util.intToStringMaxRadix(3);
    private static final String FIELD_VALUE_TYPE = Util.intToStringMaxRadix(4);
    private static final String FIELD_SESSION_ERROR = Util.intToStringMaxRadix(5);

    public static LibraryResult ofError(int i) {
        return ofError(new SessionError(i, "no error message provided", Bundle.EMPTY));
    }

    public static LibraryResult ofError(SessionError sessionError) {
        return new LibraryResult(sessionError.code, SystemClock.elapsedRealtime(), null, sessionError, null, 4);
    }

    private LibraryResult(int i, long j, MediaLibraryService$LibraryParams mediaLibraryService$LibraryParams, SessionError sessionError, Object obj, int i2) {
        this.resultCode = i;
        this.completionTimeMs = j;
        this.params = mediaLibraryService$LibraryParams;
        this.sessionError = sessionError;
        this.value = obj;
        this.valueType = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r2 != 4) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle toBundle() {
        /*
            r5 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_RESULT_CODE
            int r2 = r5.resultCode
            r0.putInt(r1, r2)
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_COMPLETION_TIME_MS
            long r2 = r5.completionTimeMs
            r0.putLong(r1, r2)
            androidx.media3.session.MediaLibraryService$LibraryParams r1 = r5.params
            if (r1 == 0) goto L20
            java.lang.String r2 = androidx.media3.session.LibraryResult.FIELD_PARAMS
            android.os.Bundle r1 = r1.toBundle()
            r0.putBundle(r2, r1)
        L20:
            androidx.media3.session.SessionError r1 = r5.sessionError
            if (r1 == 0) goto L2d
            java.lang.String r2 = androidx.media3.session.LibraryResult.FIELD_SESSION_ERROR
            android.os.Bundle r1 = r1.toBundle()
            r0.putBundle(r2, r1)
        L2d:
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_VALUE_TYPE
            int r2 = r5.valueType
            r0.putInt(r1, r2)
            java.lang.Object r1 = r5.value
            if (r1 != 0) goto L39
            goto L47
        L39:
            int r2 = r5.valueType
            r3 = 1
            if (r2 == r3) goto L6c
            r3 = 2
            if (r2 == r3) goto L60
            r1 = 3
            if (r2 == r1) goto L48
            r1 = 4
            if (r2 == r1) goto L6c
        L47:
            return r0
        L48:
            java.lang.String r1 = androidx.media3.session.LibraryResult.FIELD_VALUE
            androidx.media3.common.BundleListRetriever r2 = new androidx.media3.common.BundleListRetriever
            java.lang.Object r3 = r5.value
            com.google.common.collect.ImmutableList r3 = (com.google.common.collect.ImmutableList) r3
            androidx.media3.session.LibraryResult$$ExternalSyntheticLambda0 r4 = new androidx.media3.session.LibraryResult$$ExternalSyntheticLambda0
            r4.<init>()
            com.google.common.collect.ImmutableList r3 = androidx.media3.common.util.BundleCollectionUtil.toBundleList(r3, r4)
            r2.<init>(r3)
            androidx.core.app.BundleCompat.putBinder(r0, r1, r2)
            return r0
        L60:
            java.lang.String r2 = androidx.media3.session.LibraryResult.FIELD_VALUE
            androidx.media3.common.MediaItem r1 = (androidx.media3.common.MediaItem) r1
            android.os.Bundle r1 = r1.toBundle()
            r0.putBundle(r2, r1)
            return r0
        L6c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.LibraryResult.toBundle():android.os.Bundle");
    }
}
