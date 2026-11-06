package com.facebook.imagepipeline.xml;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.DefaultCloseableXml;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class XmlFormatDecoder implements ImageDecoder {
    public static final Companion Companion = new Companion(null);
    private final Map resourceIdCache;
    private final Resources resources;

    public XmlFormatDecoder(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.resources = resources;
        this.resourceIdCache = new ConcurrentHashMap();
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions options) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        Intrinsics.checkNotNullParameter(qualityInfo, "qualityInfo");
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            String source = encodedImage.getSource();
            if (source == null) {
                throw new IllegalStateException("No source in encoded image");
            }
            Drawable drawable = ResourcesCompat.getDrawable(this.resources, getXmlResourceId(source), null);
            if (drawable != null) {
                return new DefaultCloseableXml(drawable);
            }
            return null;
        } catch (Throwable th) {
            FLog.e("XmlFormatDecoder", "Cannot decode xml", th);
            return null;
        }
    }

    private final int getXmlResourceId(String str) {
        Map map = this.resourceIdCache;
        Object objValueOf = map.get(str);
        if (objValueOf == null) {
            Uri uri = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            objValueOf = Integer.valueOf(parseImageSourceResourceId(uri));
            map.put(str, objValueOf);
        }
        return ((Number) objValueOf).intValue();
    }

    private final int parseImageSourceResourceId(Uri uri) {
        Integer intOrNull;
        if (UriUtil.isLocalResourceUri(uri) || UriUtil.isQualifiedResourceUri(uri)) {
            List<String> pathSegments = uri.getPathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
            String str = (String) CollectionsKt.lastOrNull((List) pathSegments);
            if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                return intOrNull.intValue();
            }
            throw new IllegalStateException(("Unable to read resource ID from " + uri.getPath()).toString());
        }
        throw new IllegalStateException(("Unsupported uri " + uri).toString());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
