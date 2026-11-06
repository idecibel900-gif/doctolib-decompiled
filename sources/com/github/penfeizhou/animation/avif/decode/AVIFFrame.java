package com.github.penfeizhou.animation.avif.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import com.github.penfeizhou.animation.avif.io.AVIFReader;
import com.github.penfeizhou.animation.avif.io.AVIFWriter;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public class AVIFFrame extends Frame {
    public int index;

    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, AVIFWriter aVIFWriter) {
        return null;
    }

    @Override // com.github.penfeizhou.animation.decode.Frame
    public /* bridge */ /* synthetic */ Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, Writer writer) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(writer);
        return draw(canvas, paint, i, bitmap, (AVIFWriter) null);
    }

    public AVIFFrame(AVIFReader aVIFReader) {
        super(aVIFReader);
        this.index = 0;
    }
}
