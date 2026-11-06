package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LayerParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");
    private static final JsonReader.Options TEXT_NAMES = JsonReader.Options.of("d", "a");
    private static final JsonReader.Options EFFECTS_NAMES = JsonReader.Options.of("ty", "nm");

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        List list = Collections.EMPTY_LIST;
        return new Layer(list, lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, list, new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, list, Layer.MatteType.NONE, null, false, null, null, LBlendMode.NORMAL);
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.parser.LayerParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        float f;
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        Layer.MatteType matteType = Layer.MatteType.NONE;
        LBlendMode lBlendMode = LBlendMode.NORMAL;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        boolean z = false;
        Layer.MatteType matteType2 = matteType;
        LBlendMode lBlendMode2 = lBlendMode;
        float fNextDouble = 0.0f;
        float endFrame = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        String strNextString = null;
        AnimatableTextFrame documentData = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        BlurEffect blurEffect = null;
        DropShadowEffect dropShadowEffect = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        long jNextInt2 = -1;
        float fNextDouble5 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        AnimatableTransform animatableTransform = null;
        Layer.LayerType layerType = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    strNextString2 = jsonReader.nextString();
                    z = false;
                    break;
                case 1:
                    jNextInt = jsonReader.nextInt();
                    z = false;
                    break;
                case 2:
                    strNextString = jsonReader.nextString();
                    z = false;
                    break;
                case 3:
                    f = fNextDouble5;
                    int iNextInt3 = jsonReader.nextInt();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (iNextInt3 < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iNextInt3];
                    }
                    fNextDouble5 = f;
                    z = false;
                    break;
                case 4:
                    jNextInt2 = jsonReader.nextInt();
                    z = false;
                    break;
                case 5:
                    iNextInt = (int) (jsonReader.nextInt() * Utils.dpScale());
                    z = false;
                    break;
                case 6:
                    iNextInt2 = (int) (jsonReader.nextInt() * Utils.dpScale());
                    z = false;
                    break;
                case 7:
                    color = Color.parseColor(jsonReader.nextString());
                    z = false;
                    break;
                case 8:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    z = false;
                    break;
                case 9:
                    f = fNextDouble5;
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= Layer.MatteType.values().length) {
                        lottieComposition.addWarning("Unsupported matte type: " + iNextInt4);
                    } else {
                        matteType2 = Layer.MatteType.values()[iNextInt4];
                        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[matteType2.ordinal()];
                        if (i == 1) {
                            lottieComposition.addWarning("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            lottieComposition.addWarning("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition.incrementMatteOrMaskCount(1);
                    }
                    fNextDouble5 = f;
                    z = false;
                    break;
                case 10:
                    f = fNextDouble5;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    lottieComposition.incrementMatteOrMaskCount(arrayList.size());
                    jsonReader.endArray();
                    fNextDouble5 = f;
                    z = false;
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    f = fNextDouble5;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (contentModel != null) {
                            arrayList2.add(contentModel);
                        }
                    }
                    jsonReader.endArray();
                    fNextDouble5 = f;
                    z = false;
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    f = fNextDouble5;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int iSelectName = jsonReader.selectName(TEXT_NAMES);
                        if (iSelectName == 0) {
                            documentData = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                        } else if (iSelectName == 1) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    fNextDouble5 = f;
                    z = false;
                    break;
                case 13:
                    f = fNextDouble5;
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            int iSelectName2 = jsonReader.selectName(EFFECTS_NAMES);
                            if (iSelectName2 == 0) {
                                int iNextInt5 = jsonReader.nextInt();
                                if (iNextInt5 == 29) {
                                    blurEffect = BlurEffectParser.parse(jsonReader, lottieComposition);
                                } else if (iNextInt5 == 25) {
                                    dropShadowEffect = new DropShadowEffectParser().parse(jsonReader, lottieComposition);
                                }
                            } else if (iSelectName2 == 1) {
                                arrayList3.add(jsonReader.nextString());
                            } else {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    fNextDouble5 = f;
                    z = false;
                    break;
                case 14:
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    z = false;
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    z = false;
                    break;
                case 16:
                    f = fNextDouble5;
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) Utils.dpScale()));
                    fNextDouble5 = f;
                    z = false;
                    break;
                case 17:
                    f = fNextDouble5;
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) Utils.dpScale()));
                    fNextDouble5 = f;
                    z = false;
                    break;
                case 18:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 19:
                    endFrame = (float) jsonReader.nextDouble();
                    break;
                case 20:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                    break;
                case 21:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 22:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 23:
                    z2 = jsonReader.nextInt() != 1 ? z : true;
                    break;
                case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                    int iNextInt6 = jsonReader.nextInt();
                    if (iNextInt6 >= LBlendMode.values().length) {
                        lottieComposition.addWarning("Unsupported Blend Mode: " + iNextInt6);
                        lBlendMode2 = LBlendMode.NORMAL;
                    } else {
                        lBlendMode2 = LBlendMode.values()[iNextInt6];
                    }
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    f = fNextDouble5;
                    fNextDouble5 = f;
                    z = false;
                    break;
            }
        }
        float f2 = fNextDouble5;
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble > 0.0f) {
            arrayList4.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble)));
        }
        if (endFrame <= 0.0f) {
            endFrame = lottieComposition.getEndFrame();
        }
        arrayList4.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, fNextDouble, Float.valueOf(endFrame)));
        arrayList4.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, endFrame, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        if (z2 != 0) {
            if (animatableTransform == null) {
                animatableTransform = new AnimatableTransform();
            }
            animatableTransform.setAutoOrient(z2);
        }
        return new Layer(arrayList2, lottieComposition, strNextString2, jNextInt, layerType, jNextInt2, strNextString, arrayList, animatableTransform, iNextInt, iNextInt2, color, f2, fNextDouble4, fNextDouble2, fNextDouble3, documentData, animatableTextProperties, arrayList4, matteType2, animatableFloatValue, zNextBoolean, blurEffect, dropShadowEffect, lBlendMode2);
    }
}
