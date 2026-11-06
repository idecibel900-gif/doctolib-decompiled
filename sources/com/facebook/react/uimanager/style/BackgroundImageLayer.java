package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Shader;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundImageLayer {
    public static final Companion Companion = new Companion(null);
    private Gradient gradient;

    public /* synthetic */ BackgroundImageLayer(Gradient gradient, DefaultConstructorMarker defaultConstructorMarker) {
        this(gradient);
    }

    public BackgroundImageLayer() {
    }

    private BackgroundImageLayer(Gradient gradient) {
        this();
        this.gradient = gradient;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackgroundImageLayer parse(ReadableMap readableMap, Context context) {
            Gradient gradient;
            Intrinsics.checkNotNullParameter(context, "context");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (readableMap == null || (gradient = parseGradient(readableMap, context)) == null) {
                return null;
            }
            return new BackgroundImageLayer(gradient, defaultConstructorMarker);
        }

        private final Gradient parseGradient(ReadableMap readableMap, Context context) {
            if (readableMap.hasKey("type") && readableMap.getType("type") == ReadableType.String) {
                String string = readableMap.getString("type");
                if (Intrinsics.areEqual(string, "linear-gradient")) {
                    return LinearGradient.Companion.parse(readableMap, context);
                }
                if (Intrinsics.areEqual(string, "radial-gradient")) {
                    return RadialGradient.Companion.parse(readableMap, context);
                }
            }
            return null;
        }
    }

    public final Shader getShader(float f, float f2) {
        Gradient gradient = this.gradient;
        if (gradient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradient");
            gradient = null;
        }
        return gradient.getShader(f, f2);
    }
}
