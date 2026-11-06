package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawableUtils {
    public static final DrawableUtils INSTANCE = new DrawableUtils();

    private DrawableUtils() {
    }

    public final Bitmap convertToBitmap(Drawable drawable, Bitmap.Config config, Size size, Scale scale, boolean z) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (isConfigValid(bitmap, config) && isSizeValid(z, bitmap, size, scale)) {
                return bitmap;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        int width = Utils.getWidth(drawableMutate);
        int i = IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
        if (width <= 0) {
            width = 512;
        }
        int height = Utils.getHeight(drawableMutate);
        if (height > 0) {
            i = height;
        }
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, i, Sizes.isOriginal(size) ? width : Utils.toPx(size.getWidth(), scale), Sizes.isOriginal(size) ? i : Utils.toPx(size.getHeight(), scale), scale);
        int iRoundToInt = MathKt.roundToInt(((double) width) * dComputeSizeMultiplier);
        int iRoundToInt2 = MathKt.roundToInt(dComputeSizeMultiplier * ((double) i));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRoundToInt, iRoundToInt2, Bitmaps.toSoftware(config));
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
        Rect bounds = drawableMutate.getBounds();
        int i2 = bounds.left;
        int i3 = bounds.top;
        int i4 = bounds.right;
        int i5 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iRoundToInt, iRoundToInt2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i2, i3, i4, i5);
        return bitmapCreateBitmap;
    }

    private final boolean isConfigValid(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == Bitmaps.toSoftware(config);
    }

    private final boolean isSizeValid(boolean z, Bitmap bitmap, Size size, Scale scale) {
        int px;
        int px2;
        if (z) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (Sizes.isOriginal(size)) {
            px = bitmap.getWidth();
        } else {
            px = Utils.toPx(size.getWidth(), scale);
        }
        if (Sizes.isOriginal(size)) {
            px2 = bitmap.getHeight();
        } else {
            px2 = Utils.toPx(size.getHeight(), scale);
        }
        return DecodeUtils.computeSizeMultiplier(width, height, px, px2, scale) == 1.0d;
    }
}
