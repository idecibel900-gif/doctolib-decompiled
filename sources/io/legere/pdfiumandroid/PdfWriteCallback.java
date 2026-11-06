package io.legere.pdfiumandroid;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lio/legere/pdfiumandroid/PdfWriteCallback;", "", "WriteBlock", "", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PdfWriteCallback {
    int WriteBlock(byte[] data);
}
