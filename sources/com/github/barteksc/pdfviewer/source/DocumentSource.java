package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.PdfiumCore;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentSource {
    PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str);
}
