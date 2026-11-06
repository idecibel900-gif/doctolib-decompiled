package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.modules.fresco.ImageCacheControl;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ImageSource {
    public static final Companion Companion = new Companion(null);
    private boolean _isResource;
    private final ImageCacheControl cacheControl;
    private final double size;
    private final String source;
    private final Uri uri;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageSource(Context context, String str) {
        this(context, str, 0.0d, 0.0d, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageSource(Context context, String str, double d, double d2) {
        this(context, str, d, d2, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public ImageSource(Context context, String str, double d, double d2, ImageCacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
        this.source = str;
        this.cacheControl = cacheControl;
        this.uri = computeUri(context);
        this.size = d * d2;
    }

    public final String getSource() {
        return this.source;
    }

    public /* synthetic */ ImageSource(Context context, String str, double d, double d2, ImageCacheControl imageCacheControl, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? 0.0d : d2, (i & 16) != 0 ? ImageCacheControl.DEFAULT : imageCacheControl);
    }

    public final ImageCacheControl getCacheControl() {
        return this.cacheControl;
    }

    public Uri getUri() {
        return this.uri;
    }

    public final double getSize() {
        return this.size;
    }

    public boolean isResource() {
        return this._isResource;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.areEqual(getClass(), obj.getClass())) {
            ImageSource imageSource = (ImageSource) obj;
            if (Double.compare(imageSource.size, this.size) == 0 && isResource() == imageSource.isResource() && Intrinsics.areEqual(getUri(), imageSource.getUri()) && Intrinsics.areEqual(this.source, imageSource.source) && this.cacheControl == imageSource.cacheControl) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(getUri(), this.source, Double.valueOf(this.size), Boolean.valueOf(isResource()), this.cacheControl);
    }

    private final Uri computeUri(Context context) {
        try {
            Uri uriComputeLocalUri = Uri.parse(this.source);
            if (uriComputeLocalUri.getScheme() == null) {
                uriComputeLocalUri = computeLocalUri(context);
            }
            Intrinsics.checkNotNull(uriComputeLocalUri);
            return uriComputeLocalUri;
        } catch (NullPointerException unused) {
            return computeLocalUri(context);
        }
    }

    private final Uri computeLocalUri(Context context) {
        this._isResource = true;
        return ResourceDrawableIdHelper.getResourceDrawableUri(context, this.source);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageSource getTransparentBitmapImageSource(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new ImageSource(context, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=", 0.0d, 0.0d, ImageCacheControl.DEFAULT, 12, null);
        }
    }
}
