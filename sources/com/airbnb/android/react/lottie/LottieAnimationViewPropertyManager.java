package com.airbnb.android.react.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.ImageView;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.util.RNLog;
import com.facebook.react.views.text.ReactFontManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class LottieAnimationViewPropertyManager {
    private final String TAG;
    private String animationJson;
    private String animationName;
    private boolean animationNameDirty;
    private String animationURL;
    private Boolean autoPlay;
    private ReadableArray colorFilters;
    private Boolean enableMergePaths;
    private Boolean enableSafeMode;
    private String imageAssetsFolder;
    private Integer layerType;
    private Boolean loop;
    private Float progress;
    private RenderMode renderMode;
    private ImageView.ScaleType scaleType;
    private String sourceDotLottie;
    private Float speed;
    private ReadableArray textFilters;
    private final WeakReference viewWeakReference;

    public LottieAnimationViewPropertyManager(final LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.TAG = "lottie-react-native";
        this.viewWeakReference = new WeakReference(view);
        view.setFontAssetDelegate(new FontAssetDelegate() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager.1
            @Override // com.airbnb.lottie.FontAssetDelegate
            public Typeface fetchFont(String fontFamily) {
                Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
                ReactFontManager companion = ReactFontManager.Companion.getInstance();
                AssetManager assets = view.getContext().getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
                return companion.getTypeface(fontFamily, -1, -1, assets);
            }

            /* JADX WARN: Code duplicated, block: B:26:0x0059  */
            @Override // com.airbnb.lottie.FontAssetDelegate
            public Typeface fetchFont(String fontFamily, String fontStyle, String fontName) {
                int i;
                Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
                Intrinsics.checkNotNullParameter(fontStyle, "fontStyle");
                Intrinsics.checkNotNullParameter(fontName, "fontName");
                switch (fontStyle) {
                    case "Medium":
                        i = 500;
                        break;
                    case "Normal":
                    case "Regular":
                        i = 400;
                        break;
                    case "Bold":
                        i = ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD;
                        break;
                    case "Thin":
                        i = 100;
                        break;
                    case "Black":
                        i = 900;
                        break;
                    case "Light":
                        i = 200;
                        break;
                    default:
                        i = -1;
                        break;
                }
                ReactFontManager companion = ReactFontManager.Companion.getInstance();
                AssetManager assets = view.getContext().getAssets();
                Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
                return companion.getTypeface(fontName, -1, i, assets);
            }
        });
    }

    public final void setAnimationName(String str) {
        this.animationName = str;
        this.animationNameDirty = true;
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public final void setImageAssetsFolder(String str) {
        this.imageAssetsFolder = str;
    }

    public final void setEnableMergePaths(Boolean bool) {
        this.enableMergePaths = bool;
    }

    public final void setEnableSafeMode(Boolean bool) {
        this.enableSafeMode = bool;
    }

    public final void setColorFilters(ReadableArray readableArray) {
        this.colorFilters = readableArray;
    }

    public final void setTextFilters(ReadableArray readableArray) {
        this.textFilters = readableArray;
    }

    public final void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
    }

    public final void setLayerType(Integer num) {
        this.layerType = num;
    }

    public final void setAnimationJson(String str) {
        this.animationJson = str;
    }

    public final void setAnimationURL(String str) {
        this.animationURL = str;
    }

    public final void setSourceDotLottie(String str) {
        this.sourceDotLottie = str;
    }

    public final void setProgress(Float f) {
        this.progress = f;
    }

    public final void setLoop(Boolean bool) {
        this.loop = bool;
    }

    public final void setAutoPlay(Boolean bool) {
        this.autoPlay = bool;
    }

    public final void setSpeed(Float f) {
        this.speed = f;
    }

    public final void commitChanges() {
        Object objM5243constructorimpl;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.viewWeakReference.get();
        if (lottieAnimationView == null) {
            return;
        }
        ReadableArray readableArray = this.textFilters;
        if (readableArray != null && readableArray.size() > 0) {
            TextDelegate textDelegate = new TextDelegate(lottieAnimationView);
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                ReadableMap map = readableArray.getMap(i);
                if (map != null) {
                    textDelegate.setText(map.getString("find"), map.getString("replace"));
                }
            }
            lottieAnimationView.setTextDelegate(textDelegate);
        }
        String str = this.animationJson;
        if (str != null) {
            lottieAnimationView.setAnimationFromJson(str, String.valueOf(str.hashCode()));
            this.animationJson = null;
        }
        String str2 = this.animationURL;
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                lottieAnimationView.setAnimation(new FileInputStream(file), String.valueOf(str2.hashCode()));
            } else {
                lottieAnimationView.setAnimationFromUrl(str2, String.valueOf(str2.hashCode()));
            }
            this.animationURL = null;
        }
        String str3 = this.sourceDotLottie;
        if (str3 != null) {
            File file2 = new File(str3);
            if (file2.exists()) {
                lottieAnimationView.setAnimation(new ZipInputStream(new FileInputStream(file2)), String.valueOf(str3.hashCode()));
                this.sourceDotLottie = null;
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                objM5243constructorimpl = Result.m5243constructorimpl(Uri.parse(str3).getScheme());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
                objM5243constructorimpl = null;
            }
            String str4 = (String) objM5243constructorimpl;
            if (str4 != null) {
                if (Intrinsics.areEqual(str4, "file")) {
                    String path = Uri.parse(str3).getPath();
                    if (path != null) {
                        lottieAnimationView.setAnimation(new ZipInputStream(new FileInputStream(new File(path))), String.valueOf(str3.hashCode()));
                    }
                } else {
                    lottieAnimationView.setAnimationFromUrl(str3);
                }
                this.sourceDotLottie = null;
                return;
            }
            int identifier = lottieAnimationView.getResources().getIdentifier(str3, "raw", lottieAnimationView.getContext().getPackageName());
            if (identifier == 0) {
                RNLog.e("Animation for " + str3 + " was not found in raw resources");
                return;
            }
            lottieAnimationView.setAnimation(identifier);
            this.animationNameDirty = false;
            this.sourceDotLottie = null;
        }
        if (this.animationNameDirty) {
            lottieAnimationView.setAnimation(this.animationName);
            this.animationNameDirty = false;
        }
        Float f = this.progress;
        if (f != null) {
            lottieAnimationView.setProgress(f.floatValue());
            this.progress = null;
        }
        Boolean bool = this.loop;
        if (bool != null) {
            lottieAnimationView.setRepeatCount(bool.booleanValue() ? -1 : 0);
            this.loop = null;
        }
        Boolean bool2 = this.autoPlay;
        if (bool2 != null && bool2.booleanValue() && !lottieAnimationView.isAnimating()) {
            lottieAnimationView.playAnimation();
        }
        Float f2 = this.speed;
        if (f2 != null) {
            lottieAnimationView.setSpeed(f2.floatValue());
            this.speed = null;
        }
        ImageView.ScaleType scaleType = this.scaleType;
        if (scaleType != null) {
            lottieAnimationView.setScaleType(scaleType);
            this.scaleType = null;
        }
        RenderMode renderMode = this.renderMode;
        if (renderMode != null) {
            lottieAnimationView.setRenderMode(renderMode);
            this.renderMode = null;
        }
        Integer num = this.layerType;
        if (num != null) {
            lottieAnimationView.setLayerType(num.intValue(), null);
        }
        String str5 = this.imageAssetsFolder;
        if (str5 != null) {
            lottieAnimationView.setImageAssetsFolder(str5);
            this.imageAssetsFolder = null;
        }
        Boolean bool3 = this.enableMergePaths;
        if (bool3 != null) {
            lottieAnimationView.enableMergePathsForKitKatAndAbove(bool3.booleanValue());
            this.enableMergePaths = null;
        }
        Boolean bool4 = this.enableSafeMode;
        if (bool4 != null) {
            lottieAnimationView.setSafeMode(bool4.booleanValue());
            this.enableSafeMode = null;
        }
        ReadableArray readableArray2 = this.colorFilters;
        if (readableArray2 == null || readableArray2.size() <= 0) {
            return;
        }
        int size2 = readableArray2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ReadableMap map2 = readableArray2.getMap(i2);
            if (map2 != null) {
                parseColorFilter(map2, lottieAnimationView);
            }
        }
    }

    private final void parseColorFilter(ReadableMap readableMap, LottieAnimationView lottieAnimationView) {
        int iIntValue;
        List listEmptyList;
        if (readableMap.getType("color") == ReadableType.Map) {
            ReadableMap map = readableMap.getMap("color");
            Context context = lottieAnimationView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Integer color = ColorPropConverter.getColor(map, context);
            iIntValue = color != null ? color.intValue() : 0;
        } else {
            iIntValue = readableMap.getInt("color");
        }
        String str = readableMap.getString("keypath") + ".**";
        String strQuote = Pattern.quote(".");
        Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
        List listSplit = new Regex(strQuote).split(str, 0);
        if (!listSplit.isEmpty()) {
            ListIterator listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        lottieAnimationView.addValueCallback(new KeyPath((String[]) Arrays.copyOf(strArr, strArr.length)), LottieProperty.COLOR_FILTER, new LottieValueCallback(new SimpleColorFilter(iIntValue)));
    }
}
