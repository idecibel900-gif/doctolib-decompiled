package app.screeb.sdk.internal;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends ByteArrayOutputStream {
    public w0() {
        super(Http2.INITIAL_MAX_FRAME_SIZE);
    }

    public final void a(O dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        dst.b(((ByteArrayOutputStream) this).count);
        byte[] b = ((ByteArrayOutputStream) this).buf;
        Intrinsics.checkNotNullExpressionValue(b, "buf");
        int i = ((ByteArrayOutputStream) this).count;
        Intrinsics.checkNotNullParameter(b, "b");
        dst.a(i);
        dst.a.put(b, 0, i);
    }
}
