package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.ViewParent;
import android.widget.TextView;
import com.adjust.sdk.Constants;
import com.swmansion.enriched.markdown.EnrichedMarkdown;
import com.swmansion.enriched.markdown.EnrichedMarkdownText;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import com.swmansion.enriched.markdown.utils.text.ImageCache;
import com.swmansion.enriched.markdown.utils.text.ImageDownloader;
import com.swmansion.enriched.markdown.utils.text.LocalImageLoader;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageSpan extends android.text.style.ImageSpan implements android.text.style.LineHeightSpan {
    private final String altText;
    private final float aspectRatio;
    private final int borderRadiusPx;
    private int boxHeight;
    private int cachedWidth;
    private final Context context;
    private final boolean dynamicBoxHeight;
    private final int height;
    private final String imageUrl;
    private final boolean isInline;
    private final boolean legacySizing;
    private Drawable loadedDrawable;
    private final int maxHeightPx;
    private final Map requestHeaders;
    private final String requestKey;
    private final String resizeMode;
    private Drawable sourceDrawable;
    private WeakReference viewRef;
    public static final Companion Companion = new Companion(null);
    private static final Lazy transparentDrawable$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.spans.ImageSpan$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ImageSpan.transparentDrawable_delegate$lambda$9();
        }
    });
    private static final ExecutorService cacheExecutor = Executors.newSingleThreadExecutor();

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean isInline() {
        return this.isInline;
    }

    public final String getAltText() {
        return this.altText;
    }

    private final Pair intrinsicImageSize() {
        Drawable drawable = this.sourceDrawable;
        if (drawable != null) {
            return TuplesKt.to(Integer.valueOf(drawable.getIntrinsicWidth()), Integer.valueOf(drawable.getIntrinsicHeight()));
        }
        Bitmap original = ImageCache.INSTANCE.getOriginal(this.imageUrl);
        if (original == null) {
            return TuplesKt.to(0, 0);
        }
        return TuplesKt.to(Integer.valueOf(original.getWidth()), Integer.valueOf(original.getHeight()));
    }

    private final int resolveBoxHeight(int i) {
        if (this.isInline) {
            return this.height;
        }
        float f = this.aspectRatio;
        if (f > 0.0f && i > 0) {
            return RangesKt.coerceAtLeast((int) (i / f), 1);
        }
        if (this.maxHeightPx > 0) {
            Pair pairIntrinsicImageSize = intrinsicImageSize();
            int iIntValue = ((Number) pairIntrinsicImageSize.getFirst()).intValue();
            int iIntValue2 = ((Number) pairIntrinsicImageSize.getSecond()).intValue();
            if (i > 0 && iIntValue > 0 && iIntValue2 > 0) {
                return RangesKt.coerceAtLeast((int) Math.min(this.maxHeightPx, (i * iIntValue2) / iIntValue), 1);
            }
            return this.maxHeightPx;
        }
        return this.height;
    }

    public final void prepareForMeasurement(Spanned text, int i) {
        int iAvailableWidthIn;
        Intrinsics.checkNotNullParameter(text, "text");
        if (!this.dynamicBoxHeight || i <= 0 || (iAvailableWidthIn = availableWidthIn(text, i)) <= 0) {
            return;
        }
        this.boxHeight = resolveBoxHeight(iAvailableWidthIn);
    }

    private final void loadImage() {
        String lowerCase;
        String scheme = Uri.parse(this.imageUrl).getScheme();
        if (scheme != null) {
            lowerCase = scheme.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (Intrinsics.areEqual(lowerCase, "http") || Intrinsics.areEqual(lowerCase, Constants.SCHEME)) {
            ImageDownloader.INSTANCE.download(this.context, this.imageUrl, this.requestHeaders, new Function1() { // from class: com.swmansion.enriched.markdown.spans.ImageSpan$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ImageSpan.loadImage$lambda$1(this.f$0, (Bitmap) obj);
                }
            });
            return;
        }
        ImageCache imageCache = ImageCache.INSTANCE;
        Bitmap original = imageCache.getOriginal(this.imageUrl);
        Bitmap bitmapLoad = original == null ? LocalImageLoader.INSTANCE.load(this.context, this.imageUrl) : original;
        if (bitmapLoad != null) {
            if (original == null) {
                imageCache.putOriginal(this.imageUrl, bitmapLoad);
            }
            Resources resources = this.context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            this.sourceDrawable = new BitmapDrawable(resources, bitmapLoad);
            wrapAndAssignDrawable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadImage$lambda$1(ImageSpan imageSpan, Bitmap bitmap) {
        if (bitmap != null) {
            Resources resources = imageSpan.context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            imageSpan.sourceDrawable = new BitmapDrawable(resources, bitmap);
            imageSpan.wrapAndAssignDrawable();
        }
        return Unit.INSTANCE;
    }

    private final void wrapAndAssignDrawable() {
        int iCoerceAtLeast;
        TextView textView;
        Drawable drawable = this.sourceDrawable;
        if (drawable == null) {
            return;
        }
        if (this.isInline) {
            iCoerceAtLeast = this.height;
        } else {
            WeakReference weakReference = this.viewRef;
            iCoerceAtLeast = RangesKt.coerceAtLeast((weakReference == null || (textView = (TextView) weakReference.get()) == null) ? this.cachedWidth : getAvailableWidth(textView), 0);
        }
        int i = iCoerceAtLeast;
        int iResolveBoxHeight = resolveBoxHeight(i);
        this.boxHeight = iResolveBoxHeight;
        Bitmap processed = ImageCache.INSTANCE.getProcessed(this.requestKey, i, iResolveBoxHeight, this.borderRadiusPx, this.resizeMode);
        if (processed != null) {
            Resources resources = this.context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, processed);
            bitmapDrawable.setBounds(0, 0, i, this.boxHeight);
            this.loadedDrawable = bitmapDrawable;
        } else {
            int i2 = this.boxHeight;
            int i3 = this.borderRadiusPx;
            boolean z = !this.isInline;
            String str = this.resizeMode;
            this.loadedDrawable = new ScaledImageDrawable(drawable, i, i2, i3, z, str, this.legacySizing, new CacheKey(this.requestKey, i, i2, i3, str));
        }
        requestReflow();
    }

    private final void requestReflow() {
        TextView textView;
        WeakReference weakReference = this.viewRef;
        if (weakReference == null || (textView = (TextView) weakReference.get()) == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            int spanStart = spannable.getSpanStart(this);
            int spanEnd = spannable.getSpanEnd(this);
            if (spanStart != -1 && spanEnd != -1) {
                spannable.setSpan(this, spanStart, spanEnd, 33);
            }
        } else {
            textView.invalidate();
            textView.requestLayout();
        }
        notifyBoxHeightMayHaveChanged(textView);
    }

    private final void notifyBoxHeightMayHaveChanged(TextView textView) {
        if (this.dynamicBoxHeight) {
            if (textView instanceof EnrichedMarkdownText) {
                ((EnrichedMarkdownText) textView).getLayoutManager().invalidateLayout();
                return;
            }
            ViewParent parent = textView.getParent();
            while (parent != null && !(parent instanceof EnrichedMarkdown)) {
                parent = parent.getParent();
            }
            EnrichedMarkdown enrichedMarkdown = (EnrichedMarkdown) parent;
            if (enrichedMarkdown != null) {
                enrichedMarkdown.onImageLayoutChanged();
            }
        }
    }

    public final void registerTextView(final TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewRef = new WeakReference(view);
        if (this.isInline) {
            return;
        }
        int availableWidth = getAvailableWidth(view);
        if (availableWidth > 0) {
            updateWidthAndRecreate(availableWidth);
        }
        view.post(new Runnable() { // from class: com.swmansion.enriched.markdown.spans.ImageSpan$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ImageSpan.registerTextView$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerTextView$lambda$4(ImageSpan imageSpan, TextView textView) {
        int availableWidth = imageSpan.getAvailableWidth(textView);
        if (availableWidth != imageSpan.cachedWidth) {
            imageSpan.updateWidthAndRecreate(availableWidth);
        }
    }

    private final void updateWidthAndRecreate(int i) {
        int iResolveBoxHeight;
        if (i <= 0 || this.cachedWidth == i) {
            return;
        }
        this.cachedWidth = i;
        if (this.sourceDrawable != null) {
            wrapAndAssignDrawable();
        } else {
            if (!this.dynamicBoxHeight || (iResolveBoxHeight = resolveBoxHeight(i)) == this.boxHeight) {
                return;
            }
            this.boxHeight = iResolveBoxHeight;
            requestReflow();
        }
    }

    private final int getAvailableWidth(TextView textView) {
        Layout layout = textView.getLayout();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(layout != null ? layout.getWidth() : textView.getWidth(), 0);
        CharSequence text = textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        return spanned == null ? iCoerceAtLeast : availableWidthIn(spanned, iCoerceAtLeast);
    }

    private final int availableWidthIn(Spanned spanned, int i) {
        Integer numValueOf = Integer.valueOf(spanned.getSpanStart(this));
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return i;
        }
        int iIntValue = numValueOf.intValue();
        Object[] spans = spanned.getSpans(iIntValue, RangesKt.coerceAtLeast(spanned.getSpanEnd(this), iIntValue), LeadingMarginSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        int leadingMargin = 0;
        for (Object obj : spans) {
            leadingMargin += ((LeadingMarginSpan) obj).getLeadingMargin(true);
        }
        return RangesKt.coerceAtLeast(i - leadingMargin, 0);
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        int iIntValue;
        Drawable transparentDrawable = this.loadedDrawable;
        if (transparentDrawable == null) {
            transparentDrawable = Companion.getTransparentDrawable();
        }
        if (!(transparentDrawable instanceof ScaledImageDrawable)) {
            if (this.isInline) {
                iIntValue = this.height;
            } else {
                Integer numValueOf = Integer.valueOf(this.cachedWidth);
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : transparentDrawable.getIntrinsicWidth();
            }
            transparentDrawable.setBounds(0, 0, RangesKt.coerceAtLeast(iIntValue, 0), RangesKt.coerceAtLeast(this.boxHeight, 0));
        }
        return transparentDrawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return getDrawable().getBounds().right;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5;
        int i6;
        int i7;
        if (fontMetricsInt == null || this.isInline || (i7 = this.boxHeight) <= (i6 = (i5 = fontMetricsInt.descent) - fontMetricsInt.ascent)) {
            return;
        }
        int i8 = i7 - i6;
        fontMetricsInt.descent = i5 + i8;
        fontMetricsInt.bottom += i8;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        int iSave = canvas.save();
        try {
            if (this.isInline) {
                int iHeight = drawable.getBounds().height();
                canvas.translate(f, (i4 - iHeight) + (iHeight * 0.1f));
            } else {
                canvas.translate(f, i3);
            }
            drawable.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CacheKey {
        private final int borderRadius;
        private final int height;
        private final String resizeMode;
        private final String url;
        private final int width;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            return Intrinsics.areEqual(this.url, cacheKey.url) && this.width == cacheKey.width && this.height == cacheKey.height && this.borderRadius == cacheKey.borderRadius && Intrinsics.areEqual(this.resizeMode, cacheKey.resizeMode);
        }

        public int hashCode() {
            return (((((((this.url.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.borderRadius)) * 31) + this.resizeMode.hashCode();
        }

        public String toString() {
            return "CacheKey(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", borderRadius=" + this.borderRadius + ", resizeMode=" + this.resizeMode + ")";
        }

        public CacheKey(String url, int i, int i2, int i3, String resizeMode) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(resizeMode, "resizeMode");
            this.url = url;
            this.width = i;
            this.height = i2;
            this.borderRadius = i3;
            this.resizeMode = resizeMode;
        }

        public final String getUrl() {
            return this.url;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getBorderRadius() {
            return this.borderRadius;
        }

        public final String getResizeMode() {
            return this.resizeMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ScaledImageDrawable extends Drawable {
        private final int borderRadius;
        private final CacheKey cacheKey;
        private final Path clipPath;
        private boolean hasCached;
        private final Drawable imageDrawable;
        private final boolean legacySizing;
        private final String resizeMode;
        private final int targetHeight;
        private final int targetWidth;

        public ScaledImageDrawable(Drawable imageDrawable, int i, int i2, int i3, boolean z, String resizeMode, boolean z2, CacheKey cacheKey) {
            Pair pairResizeModeSize;
            Path path;
            Intrinsics.checkNotNullParameter(imageDrawable, "imageDrawable");
            Intrinsics.checkNotNullParameter(resizeMode, "resizeMode");
            this.imageDrawable = imageDrawable;
            this.targetWidth = i;
            this.targetHeight = i2;
            this.borderRadius = i3;
            this.resizeMode = resizeMode;
            this.legacySizing = z2;
            this.cacheKey = cacheKey;
            setBounds(0, 0, i, i2);
            int intrinsicWidth = imageDrawable.getIntrinsicWidth();
            int intrinsicHeight = imageDrawable.getIntrinsicHeight();
            boolean z3 = z && !z2;
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                pairResizeModeSize = TuplesKt.to(Integer.valueOf(i), Integer.valueOf(i2));
            } else if (!z) {
                float f = intrinsicWidth;
                float f2 = intrinsicHeight;
                float fMin = Math.min(i / f, i2 / f2);
                pairResizeModeSize = TuplesKt.to(Integer.valueOf((int) (f * fMin)), Integer.valueOf((int) (f2 * fMin)));
            } else if (z2) {
                pairResizeModeSize = TuplesKt.to(Integer.valueOf(i), Integer.valueOf((int) (intrinsicHeight * (i / intrinsicWidth))));
            } else {
                pairResizeModeSize = resizeModeSize(intrinsicWidth, intrinsicHeight);
            }
            int iIntValue = ((Number) pairResizeModeSize.getFirst()).intValue();
            int iIntValue2 = ((Number) pairResizeModeSize.getSecond()).intValue();
            int i4 = (i - iIntValue) / 2;
            int i5 = (i2 - iIntValue2) / 2;
            int i6 = iIntValue + i4;
            int i7 = iIntValue2 + i5;
            imageDrawable.setBounds(i4, i5, i6, i7);
            float fMax = Math.max(0, i4);
            float fMax2 = Math.max(0, i5);
            float fMin2 = Math.min(i, i6);
            float fMin3 = Math.min(i2, i7);
            if (i3 > 0) {
                path = new Path();
                path.addRoundRect(fMax, fMax2, fMin2, fMin3, i3, i3, Path.Direction.CW);
            } else if (z3) {
                Path path2 = new Path();
                path2.addRect(fMax, fMax2, fMin2, fMin3, Path.Direction.CW);
                path = path2;
            } else {
                path = null;
            }
            this.clipPath = path;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x005c  */
        private final Pair resizeModeSize(int i, int i2) {
            if (Intrinsics.areEqual(this.resizeMode, "stretch")) {
                return TuplesKt.to(Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight));
            }
            float f = i;
            float f2 = this.targetWidth / f;
            float f3 = i2;
            float f4 = this.targetHeight / f3;
            String str = this.resizeMode;
            int iHashCode = str.hashCode();
            float fMin = 1.0f;
            if (iHashCode != -1364013995) {
                if (iHashCode != 3387192) {
                    if (iHashCode == 951526612 && str.equals("contain")) {
                        fMin = Math.min(f2, f4);
                    } else {
                        fMin = Math.max(f2, f4);
                    }
                } else if (!str.equals("none")) {
                    fMin = Math.max(f2, f4);
                }
            } else if (str.equals("center")) {
                fMin = Math.min(1.0f, Math.min(f2, f4));
            } else {
                fMin = Math.max(f2, f4);
            }
            return TuplesKt.to(Integer.valueOf((int) (f * fMin)), Integer.valueOf((int) (f3 * fMin)));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.clipPath == null) {
                this.imageDrawable.draw(canvas);
            } else {
                int iSave = canvas.save();
                try {
                    canvas.clipPath(this.clipPath);
                    this.imageDrawable.draw(canvas);
                    canvas.restoreToCount(iSave);
                } catch (Throwable th) {
                    canvas.restoreToCount(iSave);
                    throw th;
                }
            }
            scheduleCacheBitmap();
        }

        private final void scheduleCacheBitmap() {
            final CacheKey cacheKey;
            final int i;
            final int i2;
            if (this.hasCached || (cacheKey = this.cacheKey) == null || (i = this.targetWidth) <= 0 || (i2 = this.targetHeight) <= 0) {
                return;
            }
            this.hasCached = true;
            final Path path = this.clipPath;
            final Drawable drawable = this.imageDrawable;
            ImageSpan.cacheExecutor.execute(new Runnable() { // from class: com.swmansion.enriched.markdown.spans.ImageSpan$ScaledImageDrawable$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ImageSpan.ScaledImageDrawable.scheduleCacheBitmap$lambda$4(i, i2, path, drawable, cacheKey);
                }
            });
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.imageDrawable.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.imageDrawable.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.imageDrawable.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.targetWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.targetHeight;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void scheduleCacheBitmap$lambda$4(int i, int i2, Path path, Drawable drawable, CacheKey cacheKey) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (path == null) {
                    drawable.draw(canvas);
                } else {
                    int iSave = canvas.save();
                    canvas.clipPath(path);
                    try {
                        drawable.draw(canvas);
                        canvas.restoreToCount(iSave);
                    } catch (Throwable th) {
                        canvas.restoreToCount(iSave);
                        throw th;
                    }
                }
                ImageCache.INSTANCE.putProcessed(cacheKey.getUrl(), cacheKey.getWidth(), cacheKey.getHeight(), cacheKey.getBorderRadius(), cacheKey.getResizeMode(), bitmapCreateBitmap);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ColorDrawable getTransparentDrawable() {
            return (ColorDrawable) ImageSpan.transparentDrawable$delegate.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageSpan(Context context, String imageUrl, StyleConfig styleConfig, boolean z, String altText) {
        super(new ColorDrawable(0), imageUrl, Build.VERSION.SDK_INT >= 29 ? 2 : 1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(styleConfig, "styleConfig");
        Intrinsics.checkNotNullParameter(altText, "altText");
        boolean z2 = false;
        this.context = context;
        this.imageUrl = imageUrl;
        this.isInline = z;
        this.altText = altText;
        int size = (int) (z ? styleConfig.getInlineImageStyle().getSize() : styleConfig.getImageStyle().getHeight());
        this.height = size;
        this.borderRadiusPx = (int) styleConfig.getImageStyle().getBorderRadius();
        int maxHeight = z ? 0 : (int) styleConfig.getImageStyle().getMaxHeight();
        this.maxHeightPx = maxHeight;
        float aspectRatio = z ? 0.0f : styleConfig.getImageStyle().getAspectRatio();
        this.aspectRatio = aspectRatio;
        String resizeMode = z ? "" : styleConfig.getImageStyle().getResizeMode();
        this.resizeMode = resizeMode;
        this.legacySizing = resizeMode.length() == 0;
        if (!z && (maxHeight > 0 || aspectRatio > 0.0f)) {
            z2 = true;
        }
        this.dynamicBoxHeight = z2;
        if (!z && maxHeight > 0) {
            size = maxHeight;
        }
        this.boxHeight = size;
        Map imageRequestHeaders = styleConfig.getImageRequestHeaders();
        this.requestHeaders = imageRequestHeaders;
        this.requestKey = ImageCache.INSTANCE.requestKey(imageUrl, imageRequestHeaders);
        loadImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorDrawable transparentDrawable_delegate$lambda$9() {
        return new ColorDrawable(0);
    }
}
