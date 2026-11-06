package com.facebook.react.views.text.frescosupport;

import android.content.res.Resources;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.widget.TextView;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FrescoBasedReactTextInlineImageSpan extends TextInlineImageSpan {
    private final int _height;
    private final Uri _uri;
    private final int _width;
    private final Object callerContext;
    private Drawable drawable;
    private final AbstractDraweeControllerBuilder draweeControllerBuilder;
    private final DraweeHolder draweeHolder;
    private final ReadableMap headers;
    private final String resizeMode;
    private TextView textView;
    private final int tintColor;

    public FrescoBasedReactTextInlineImageSpan(Resources resources, int i, int i2, int i3, Uri EMPTY, ReadableMap readableMap, AbstractDraweeControllerBuilder draweeControllerBuilder, Object obj, String str) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(draweeControllerBuilder, "draweeControllerBuilder");
        this.tintColor = i3;
        this.headers = readableMap;
        this.draweeControllerBuilder = draweeControllerBuilder;
        this.callerContext = obj;
        this.resizeMode = str;
        if (EMPTY == null) {
            EMPTY = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        }
        this._uri = EMPTY;
        this._width = (int) PixelUtil.toPixelFromDIP(i2);
        this._height = (int) PixelUtil.toPixelFromDIP(i);
        this.draweeHolder = new DraweeHolder(GenericDraweeHierarchyBuilder.newInstance(resources).build());
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public int getHeight() {
        return this._height;
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public void onDetachedFromWindow() {
        this.draweeHolder.onDetach();
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public void onStartTemporaryDetach() {
        this.draweeHolder.onDetach();
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public void onAttachedToWindow() {
        this.draweeHolder.onAttach();
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public void onFinishTemporaryDetach() {
        this.draweeHolder.onAttach();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        if (fontMetricsInt != null) {
            int i3 = -this._height;
            fontMetricsInt.ascent = i3;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i3;
            fontMetricsInt.bottom = 0;
        }
        return this._width;
    }

    @Override // com.facebook.react.views.text.internal.span.TextInlineImageSpan
    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (getDrawable() == null) {
            ImageRequestBuilder imageRequestBuilderNewBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(this._uri);
            ReactNetworkImageRequest.Companion companion = ReactNetworkImageRequest.Companion;
            Intrinsics.checkNotNull(imageRequestBuilderNewBuilderWithSource);
            ReactNetworkImageRequest reactNetworkImageRequestFromBuilderWithHeaders$default = ReactNetworkImageRequest.Companion.fromBuilderWithHeaders$default(companion, imageRequestBuilderNewBuilderWithSource, this.headers, null, 4, null);
            ((GenericDraweeHierarchy) this.draweeHolder.getHierarchy()).setActualImageScaleType(ImageResizeMode.toScaleType(this.resizeMode));
            this.draweeControllerBuilder.reset();
            this.draweeControllerBuilder.setOldController(this.draweeHolder.getController());
            Object obj = this.callerContext;
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(this.draweeControllerBuilder.setCallerContext(obj), "setCallerContext(...)");
            }
            this.draweeControllerBuilder.setImageRequest(reactNetworkImageRequestFromBuilderWithHeaders$default);
            AbstractDraweeController abstractDraweeControllerBuild = this.draweeControllerBuilder.build();
            Intrinsics.checkNotNullExpressionValue(abstractDraweeControllerBuild, "build(...)");
            this.draweeHolder.setController(abstractDraweeControllerBuild);
            this.draweeControllerBuilder.reset();
            Drawable topLevelDrawable = this.draweeHolder.getTopLevelDrawable();
            if (topLevelDrawable == null) {
                throw new IllegalStateException("Required value was null.");
            }
            topLevelDrawable.setBounds(0, 0, this._width, this._height);
            if (this.tintColor != 0) {
                if (Build.VERSION.SDK_INT >= 29) {
                    BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1.m();
                    topLevelDrawable.setColorFilter(BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0.m(this.tintColor, BlendMode.SRC_IN));
                } else {
                    topLevelDrawable.setColorFilter(new PorterDuffColorFilter(this.tintColor, PorterDuff.Mode.SRC_IN));
                }
            }
            topLevelDrawable.setCallback(this.textView);
            this.drawable = topLevelDrawable;
        }
        canvas.save();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            throw new IllegalStateException("Required value was null.");
        }
        canvas.translate(f, ((i4 + ((int) paint.descent())) - (((int) (paint.descent() - paint.ascent())) / 2)) - (drawable.getBounds().height() / 2));
        drawable.draw(canvas);
        canvas.restore();
    }
}
