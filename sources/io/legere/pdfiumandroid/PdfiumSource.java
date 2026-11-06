package io.legere.pdfiumandroid;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lio/legere/pdfiumandroid/PdfiumSource;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "length", "", "getLength", "()J", "read", "", "position", "buffer", "", "size", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PdfiumSource extends AutoCloseable {
    long getLength();

    int read(long position, byte[] buffer, int size);
}
