package io.legere.pdfiumandroid.util;

import com.google.firebase.messaging.Constants;
import io.legere.pdfiumandroid.Logger;
import io.legere.pdfiumandroid.PdfiumSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/legere/pdfiumandroid/util/PdfiumNativeSourceBridge;", "", Constants.ScionAnalytics.PARAM_SOURCE, "Lio/legere/pdfiumandroid/PdfiumSource;", "<init>", "(Lio/legere/pdfiumandroid/PdfiumSource;)V", "buffer", "", "read", "", "position", "", "size", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PdfiumNativeSourceBridge {
    private byte[] buffer;
    private final PdfiumSource source;

    public PdfiumNativeSourceBridge(PdfiumSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public final int read(long position, long size) {
        try {
            if (size > 2147483647L) {
                throw new IllegalArgumentException("size is too large");
            }
            int i = (int) size;
            byte[] bArr = this.buffer;
            if (bArr == null || bArr.length < size) {
                bArr = new byte[i];
                this.buffer = bArr;
            }
            int i2 = this.source.read(position, bArr, i);
            if (i2 <= 0) {
                return 0;
            }
            return i2;
        } catch (Throwable th) {
            Logger.INSTANCE.e("PdfiumNativeSourceBridge", th, "read failed");
            return 0;
        }
    }
}
