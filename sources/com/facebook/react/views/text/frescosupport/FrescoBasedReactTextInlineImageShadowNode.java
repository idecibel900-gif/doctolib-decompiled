package com.facebook.react.views.text.frescosupport;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.internal.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import com.facebook.yoga.YogaConstants;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class FrescoBasedReactTextInlineImageShadowNode extends ReactTextInlineImageShadowNode {
    public static final Companion Companion = new Companion(null);
    private final Object callerContext;
    private final AbstractDraweeControllerBuilder draweeControllerBuilder;
    private ReadableMap headers;
    private float height;
    private String resizeMode;
    private int tintColor;
    private Uri uri;
    private float width;

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return true;
    }

    public FrescoBasedReactTextInlineImageShadowNode(AbstractDraweeControllerBuilder draweeControllerBuilder, Object obj) {
        Intrinsics.checkNotNullParameter(draweeControllerBuilder, "draweeControllerBuilder");
        this.draweeControllerBuilder = draweeControllerBuilder;
        this.callerContext = obj;
        float f = YogaConstants.UNDEFINED;
        this.width = f;
        this.height = f;
    }

    @ReactProp(name = "src")
    public final void setSource(ReadableArray readableArray) {
        String string;
        Uri resourceDrawableUri = null;
        if (readableArray == null || readableArray.size() == 0 || readableArray.getType(0) != ReadableType.Map) {
            string = null;
        } else {
            ReadableMap map = readableArray.getMap(0);
            if (map == null) {
                throw new IllegalStateException("Required value was null.");
            }
            string = map.getString("uri");
        }
        if (string != null) {
            try {
                Uri uri = Uri.parse(string);
                try {
                    if (uri.getScheme() != null) {
                        resourceDrawableUri = uri;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
            if (resourceDrawableUri == null) {
                Companion companion = Companion;
                ThemedReactContext themedContext = getThemedContext();
                Intrinsics.checkNotNullExpressionValue(themedContext, "getThemedContext(...)");
                resourceDrawableUri = companion.getResourceDrawableUri(themedContext, string);
            }
        }
        if (!Intrinsics.areEqual(resourceDrawableUri, this.uri)) {
            markUpdated();
        }
        this.uri = resourceDrawableUri;
    }

    @ReactProp(name = "headers")
    public final void setHeaders(ReadableMap readableMap) {
        this.headers = readableMap;
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public final void setTintColor(int i) {
        this.tintColor = i;
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    public void setWidth(Dynamic newWidth) {
        Intrinsics.checkNotNullParameter(newWidth, "newWidth");
        if (newWidth.getType() == ReadableType.Number) {
            this.width = (float) newWidth.asDouble();
        } else {
            FLog.w("ReactNative", "Inline images must not have percentage based width");
            this.width = YogaConstants.UNDEFINED;
        }
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    public void setHeight(Dynamic newHeight) {
        Intrinsics.checkNotNullParameter(newHeight, "newHeight");
        if (newHeight.getType() == ReadableType.Number) {
            this.height = (float) newHeight.asDouble();
        } else {
            FLog.w("ReactNative", "Inline images must not have percentage based height");
            this.height = YogaConstants.UNDEFINED;
        }
    }

    @ReactProp(name = "resizeMode")
    public final void setResizeMode(String str) {
        this.resizeMode = str;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final ReadableMap getHeaders() {
        return this.headers;
    }

    @Override // com.facebook.react.views.text.internal.ReactTextInlineImageShadowNode
    public TextInlineImageSpan buildInlineImageSpan() {
        Resources resources = getThemedContext().getResources();
        int iCeil = (int) Math.ceil(this.width);
        int iCeil2 = (int) Math.ceil(this.height);
        Intrinsics.checkNotNull(resources);
        return new FrescoBasedReactTextInlineImageSpan(resources, iCeil2, iCeil, this.tintColor, getUri(), getHeaders(), getDraweeControllerBuilder(), getCallerContext(), this.resizeMode);
    }

    public final AbstractDraweeControllerBuilder getDraweeControllerBuilder() {
        return this.draweeControllerBuilder;
    }

    public final Object getCallerContext() {
        return this.callerContext;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uri getResourceDrawableUri(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (str == null || str.length() == 0) {
                return null;
            }
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return new Uri.Builder().scheme("res").path(String.valueOf(context.getResources().getIdentifier(StringsKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null), "drawable", context.getPackageName()))).build();
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("FrescoBasedReactTextInlineImageShadowNode", LegacyArchitectureLogLevel.ERROR);
    }
}
