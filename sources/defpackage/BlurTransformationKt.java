package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BlurTransformationKt {
    public static /* synthetic */ Bitmap blur$default(Bitmap bitmap, Context context, float f, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return blur(bitmap, context, f, z);
    }

    public static final Bitmap blur(Bitmap bitmap, Context context, float f, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (f < 1.0f) {
            return bitmap;
        }
        double dMin = Math.min(f, 25.0d);
        Bitmap bitmapScaledDown = z ? scaledDown(bitmap) : bitmap;
        RenderScript renderScriptCreate = RenderScript.create(context);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapScaledDown);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        scriptIntrinsicBlurCreate.setRadius((float) dMin);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        Bitmap.Config config = bitmap.getConfig();
        Bitmap bitmapCreateBitmap = config != null ? Bitmap.createBitmap(bitmapScaledDown.getWidth(), bitmapScaledDown.getHeight(), config) : null;
        allocationCreateTyped.copyTo(bitmapCreateBitmap);
        allocationCreateFromBitmap.destroy();
        allocationCreateTyped.destroy();
        scriptIntrinsicBlurCreate.destroy();
        renderScriptCreate.destroy();
        return bitmapCreateBitmap == null ? bitmapScaledDown : bitmapCreateBitmap;
    }

    private static final Bitmap scaledDown(Bitmap bitmap) {
        float fMin = Math.min(400.0f / bitmap.getWidth(), 400.0f / bitmap.getHeight());
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, MathKt.roundToInt(bitmap.getWidth() * fMin), MathKt.roundToInt(fMin * bitmap.getHeight()), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, true)");
        return bitmapCreateScaledBitmap;
    }
}
