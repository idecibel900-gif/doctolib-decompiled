package com.facebook.react.views.image;

import android.graphics.Bitmap;
import com.amazon.a.a.o.b.f;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MultiPostprocessor implements Postprocessor {
    public static final Companion Companion = new Companion(null);
    private final List postprocessors;

    public /* synthetic */ MultiPostprocessor(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    private MultiPostprocessor(List list) {
        this.postprocessors = new LinkedList(list);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "MultiPostProcessor (" + CollectionsKt.joinToString$default(this.postprocessors, f.a, null, null, 0, null, null, 62, null) + ")";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        List list = this.postprocessors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Postprocessor) it.next()).getPostprocessorCacheKey());
        }
        return new MultiCacheKey(arrayList);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
        CloseableReference closeableReferenceProcess = null;
        try {
            CloseableReference closeableReferenceM3216clone = null;
            for (Postprocessor postprocessor : this.postprocessors) {
                if (closeableReferenceM3216clone == null || (bitmap = (Bitmap) closeableReferenceM3216clone.get()) == null) {
                    bitmap = sourceBitmap;
                }
                closeableReferenceProcess = postprocessor.process(bitmap, bitmapFactory);
                CloseableReference.closeSafely(closeableReferenceM3216clone);
                closeableReferenceM3216clone = closeableReferenceProcess.m3216clone();
            }
            if (closeableReferenceProcess == null) {
                throw new IllegalStateException(("MultiPostprocessor returned null bitmap - Number of Postprocessors: " + this.postprocessors.size()).toString());
            }
            CloseableReference closeableReferenceM3216clone2 = closeableReferenceProcess.m3216clone();
            Intrinsics.checkNotNullExpressionValue(closeableReferenceM3216clone2, "clone(...)");
            CloseableReference.closeSafely(closeableReferenceProcess);
            return closeableReferenceM3216clone2;
        } catch (Throwable th) {
            CloseableReference.closeSafely(null);
            throw th;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Postprocessor from(List postprocessors) {
            Intrinsics.checkNotNullParameter(postprocessors, "postprocessors");
            int size = postprocessors.size();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                return (Postprocessor) postprocessors.get(0);
            }
            return new MultiPostprocessor(postprocessors, defaultConstructorMarker);
        }
    }
}
