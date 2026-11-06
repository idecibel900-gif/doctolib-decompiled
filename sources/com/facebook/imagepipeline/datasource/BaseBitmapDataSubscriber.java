package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber {
    protected abstract void onNewResultImpl(Bitmap bitmap);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource dataSource) {
        if (dataSource.isFinished()) {
            CloseableReference closeableReference = (CloseableReference) dataSource.getResult();
            try {
                onNewResultImpl((closeableReference == null || !(closeableReference.get() instanceof CloseableBitmap)) ? null : ((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap());
            } finally {
                CloseableReference.closeSafely(closeableReference);
            }
        }
    }
}
