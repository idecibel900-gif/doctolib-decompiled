package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapPainterKt {
    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY$default, reason: not valid java name */
    public static /* synthetic */ BitmapPainter m1642BitmapPainterQZhYCtY$default(ImageBitmap imageBitmap, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = IntOffset.Companion.m2598getZeronOccac();
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            i = FilterQuality.Companion.m1409getLowfv9h1I();
        }
        return m1641BitmapPainterQZhYCtY(imageBitmap, j3, j4, i);
    }

    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY, reason: not valid java name */
    public static final BitmapPainter m1641BitmapPainterQZhYCtY(ImageBitmap imageBitmap, long j, long j2, int i) {
        BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, j, j2, null);
        bitmapPainter.m1640setFilterQualityvDHp3xo$ui_graphics_release(i);
        return bitmapPainter;
    }
}
