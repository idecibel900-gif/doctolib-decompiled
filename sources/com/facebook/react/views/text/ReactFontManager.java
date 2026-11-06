package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactFontManager {
    public static final Companion Companion = new Companion(null);
    private static ReactFontManager instance;
    private final com.facebook.react.common.assets.ReactFontManager delegate;

    public /* synthetic */ ReactFontManager(com.facebook.react.common.assets.ReactFontManager reactFontManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactFontManager);
    }

    public static final ReactFontManager getInstance() {
        return Companion.getInstance();
    }

    private ReactFontManager(com.facebook.react.common.assets.ReactFontManager reactFontManager) {
        this.delegate = reactFontManager;
    }

    public final Typeface getTypeface(String fontFamilyName, int i, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        return this.delegate.getTypeface(fontFamilyName, i, assetManager);
    }

    public final Typeface getTypeface(String fontFamilyName, int i, int i2, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        return this.delegate.getTypeface(fontFamilyName, i, i2, assetManager);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReactFontManager getInstance() {
            ReactFontManager reactFontManager = ReactFontManager.instance;
            if (reactFontManager != null) {
                return reactFontManager;
            }
            ReactFontManager reactFontManager2 = new ReactFontManager(com.facebook.react.common.assets.ReactFontManager.Companion.getInstance(), null);
            ReactFontManager.instance = reactFontManager2;
            return reactFontManager2;
        }
    }
}
