package com.facebook.react.common.assets;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.util.SparseArray;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactFontManager {
    public static final Companion Companion = new Companion(null);
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final ReactFontManager _instance = new ReactFontManager();
    private final Map fontCache = new LinkedHashMap();
    private final Map customTypefaceCache = new LinkedHashMap();

    public final Typeface getTypeface(String fontFamilyName, int i, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(i, 0, 2, null), assetManager);
    }

    public final Typeface getTypeface(String fontFamilyName, int i, boolean z, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(i, z), assetManager);
    }

    public final Typeface getTypeface(String fontFamilyName, int i, int i2, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(i, i2), assetManager);
    }

    public final Typeface getTypeface(String fontFamilyName, TypefaceStyle typefaceStyle, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(typefaceStyle, "typefaceStyle");
        if (this.customTypefaceCache.containsKey(fontFamilyName)) {
            return typefaceStyle.apply((Typeface) this.customTypefaceCache.get(fontFamilyName));
        }
        Map map = this.fontCache;
        Object assetFontFamily = map.get(fontFamilyName);
        if (assetFontFamily == null) {
            assetFontFamily = new AssetFontFamily();
            map.put(fontFamilyName, assetFontFamily);
        }
        AssetFontFamily assetFontFamily2 = (AssetFontFamily) assetFontFamily;
        int nearestStyle = typefaceStyle.getNearestStyle();
        Typeface typefaceForStyle = assetFontFamily2.getTypefaceForStyle(nearestStyle);
        if (typefaceForStyle != null) {
            return typefaceForStyle;
        }
        Typeface typefaceCreateAssetTypeface = Companion.createAssetTypeface(fontFamilyName, nearestStyle, assetManager);
        assetFontFamily2.setTypefaceForStyle(nearestStyle, typefaceCreateAssetTypeface);
        return typefaceCreateAssetTypeface;
    }

    public final void setTypeface(String fontFamilyName, int i, Typeface typeface) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        if (typeface != null) {
            Map map = this.fontCache;
            Object assetFontFamily = map.get(fontFamilyName);
            if (assetFontFamily == null) {
                assetFontFamily = new AssetFontFamily();
                map.put(fontFamilyName, assetFontFamily);
            }
            ((AssetFontFamily) assetFontFamily).setTypefaceForStyle(i, typeface);
        }
    }

    public static final class TypefaceStyle {
        public static final Companion Companion = new Companion(null);
        private final boolean italic;
        private final int weight;

        public TypefaceStyle(int i, boolean z) {
            this.italic = z;
            this.weight = i == -1 ? 400 : i;
        }

        public /* synthetic */ TypefaceStyle(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? -1 : i2);
        }

        public TypefaceStyle(int i, int i2) {
            i = i == -1 ? 0 : i;
            this.italic = (i & 2) != 0;
            this.weight = i2 == -1 ? (i & 1) != 0 ? ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD : 400 : i2;
        }

        public final int getNearestStyle() {
            if (this.weight < 700) {
                return this.italic ? 2 : 0;
            }
            return this.italic ? 3 : 1;
        }

        public final Typeface apply(Typeface typeface) {
            if (Build.VERSION.SDK_INT < 28) {
                Typeface typefaceCreate = Typeface.create(typeface, getNearestStyle());
                Intrinsics.checkNotNull(typefaceCreate);
                return typefaceCreate;
            }
            Typeface typefaceCreate2 = Typeface.create(typeface, this.weight, this.italic);
            Intrinsics.checkNotNull(typefaceCreate2);
            return typefaceCreate2;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReactFontManager getInstance() {
            return ReactFontManager._instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Typeface createAssetTypeface(String str, int i, AssetManager assetManager) {
            if (assetManager != null) {
                String str2 = ReactFontManager.EXTENSIONS[i];
                for (String str3 : ReactFontManager.FILE_EXTENSIONS) {
                    try {
                        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(assetManager, "fonts/" + str + str2 + str3);
                        Intrinsics.checkNotNullExpressionValue(typefaceCreateFromAsset, "createFromAsset(...)");
                        return typefaceCreateFromAsset;
                    } catch (RuntimeException unused) {
                    }
                }
            }
            Typeface typefaceCreate = Typeface.create(str, i);
            Intrinsics.checkNotNullExpressionValue(typefaceCreate, "create(...)");
            return typefaceCreate;
        }
    }

    private static final class AssetFontFamily {
        private final SparseArray typefaceSparseArray = new SparseArray(4);

        public final Typeface getTypefaceForStyle(int i) {
            return (Typeface) this.typefaceSparseArray.get(i);
        }

        public final void setTypefaceForStyle(int i, Typeface typeface) {
            this.typefaceSparseArray.put(i, typeface);
        }
    }
}
