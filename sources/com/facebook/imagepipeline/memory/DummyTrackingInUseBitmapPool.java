package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Sets;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DummyTrackingInUseBitmapPool implements BitmapPool {
    private final Set inUseValues;

    public DummyTrackingInUseBitmapPool() {
        Set setNewIdentityHashSet = Sets.newIdentityHashSet();
        Intrinsics.checkNotNullExpressionValue(setNewIdentityHashSet, "newIdentityHashSet(...)");
        this.inUseValues = setNewIdentityHashSet;
    }

    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        this.inUseValues.add(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.inUseValues.remove(value);
        value.recycle();
    }
}
