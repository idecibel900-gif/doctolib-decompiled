package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapPoolBackend extends LruBucketsPoolBackend {
    public static final Companion Companion = new Companion(null);

    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public void put(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (isReusable(bitmap)) {
            super.put((Object) bitmap);
        }
    }

    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public Bitmap get(int i) {
        Bitmap bitmap = (Bitmap) super.get(i);
        if (bitmap == null || !isReusable(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public int getSize(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return BitmapUtil.getSizeInBytes(bitmap);
    }

    protected final boolean isReusable(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            FLog.wtf("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        }
        if (bitmap.isMutable()) {
            return true;
        }
        FLog.wtf("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
        return false;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
