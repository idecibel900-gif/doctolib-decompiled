package jp.wasabeef.glide.transformations.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.BaseObj;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RSBlur {
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:21:0x0057  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0061  */
    public static Bitmap blur(Context context, Bitmap bitmap, int i) throws Throwable {
        BaseObj baseObj;
        Allocation allocationCreateFromBitmap;
        Allocation allocationCreateTyped;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = null;
        try {
            RenderScript renderScriptCreate = RenderScript.create(context);
            try {
                renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
                allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                try {
                    allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
                    try {
                        scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                        scriptIntrinsicBlurCreate.setRadius(i);
                        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
                        allocationCreateTyped.copyTo(bitmap);
                        RenderScript.releaseAllContexts();
                        allocationCreateFromBitmap.destroy();
                        allocationCreateTyped.destroy();
                        scriptIntrinsicBlurCreate.destroy();
                        return bitmap;
                    } catch (Throwable th) {
                        th = th;
                        BaseObj baseObj2 = scriptIntrinsicBlurCreate;
                        renderScript = renderScriptCreate;
                        baseObj = baseObj2;
                        if (renderScript != null) {
                            RenderScript.releaseAllContexts();
                        }
                        if (allocationCreateFromBitmap != null) {
                            allocationCreateFromBitmap.destroy();
                        }
                        if (allocationCreateTyped != null) {
                            allocationCreateTyped.destroy();
                        }
                        if (baseObj != null) {
                            baseObj.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    allocationCreateTyped = null;
                    renderScript = renderScriptCreate;
                    baseObj = allocationCreateTyped;
                    if (renderScript != null) {
                        RenderScript.releaseAllContexts();
                    }
                    if (allocationCreateFromBitmap != null) {
                        allocationCreateFromBitmap.destroy();
                    }
                    if (allocationCreateTyped != null) {
                        allocationCreateTyped.destroy();
                    }
                    if (baseObj != null) {
                        baseObj.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                allocationCreateFromBitmap = null;
                allocationCreateTyped = null;
            }
        } catch (Throwable th4) {
            th = th4;
            baseObj = null;
            allocationCreateFromBitmap = null;
            allocationCreateTyped = null;
        }
    }
}
