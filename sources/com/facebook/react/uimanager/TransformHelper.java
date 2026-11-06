package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJA\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ:\u0010\u001f\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001eH\u0083 ¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/facebook/react/uimanager/TransformHelper;", "", "<init>", "()V", "Lcom/facebook/react/bridge/ReadableMap;", "transformMap", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "convertToRadians", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/lang/String;)D", "Lcom/facebook/react/bridge/ReadableArray;", "transforms", "", "result", "", "viewWidth", "viewHeight", "transformOrigin", "", "allowPercentageResolution", "", "processTransform", "(Lcom/facebook/react/bridge/ReadableArray;[DFFLcom/facebook/react/bridge/ReadableArray;Z)V", "stringValue", "dimension", "parseTranslateValue", "(Ljava/lang/String;D)D", "getTranslateForTransformOrigin", "(FFLcom/facebook/react/bridge/ReadableArray;Z)[D", "Lcom/facebook/react/bridge/NativeArray;", "nativeProcessTransform", "(Lcom/facebook/react/bridge/NativeArray;[DFFLcom/facebook/react/bridge/NativeArray;)V", "Ljava/lang/ThreadLocal;", "helperMatrix", "Ljava/lang/ThreadLocal;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransformHelper {
    public static final TransformHelper INSTANCE = new TransformHelper();
    private static final ThreadLocal helperMatrix = new ThreadLocal() { // from class: com.facebook.react.uimanager.TransformHelper$helperMatrix$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public double[] initialValue() {
            return new double[16];
        }
    };

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final native void nativeProcessTransform(NativeArray transforms, double[] result, float viewWidth, float viewHeight, NativeArray transformOrigin);

    private TransformHelper() {
    }

    private final double convertToRadians(ReadableMap transformMap, String key) {
        double d;
        boolean z = true;
        if (transformMap.getType(key) == ReadableType.String) {
            String string = transformMap.getString(key);
            Intrinsics.checkNotNull(string);
            if (StringsKt.endsWith$default(string, "rad", false, 2, (Object) null)) {
                string = StringsKt.dropLast(string, 3);
            } else if (StringsKt.endsWith$default(string, "deg", false, 2, (Object) null)) {
                string = StringsKt.dropLast(string, 3);
                z = false;
            }
            d = Double.parseDouble(string);
        } else {
            d = transformMap.getDouble(key);
        }
        return z ? d : MatrixMathHelper.degreesToRadians(d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:108:0x024a A[PHI: r6 r7
      0x024a: PHI (r6v24 int) = 
      (r6v4 int)
      (r6v5 int)
      (r6v6 int)
      (r6v7 int)
      (r6v8 int)
      (r6v9 int)
      (r6v10 int)
      (r6v11 int)
      (r6v12 int)
      (r6v13 int)
      (r6v25 int)
     binds: [B:107:0x0248, B:97:0x0218, B:91:0x01f9, B:87:0x01e1, B:83:0x01cb, B:79:0x01b5, B:75:0x019c, B:71:0x0184, B:67:0x016c, B:63:0x0156, B:29:0x00a5] A[DONT_GENERATE, DONT_INLINE]
      0x024a: PHI (r7v25 char) = 
      (r7v4 char)
      (r7v5 char)
      (r7v6 char)
      (r7v7 char)
      (r7v8 char)
      (r7v9 char)
      (r7v10 char)
      (r7v11 char)
      (r7v12 char)
      (r7v13 char)
      (r7v26 char)
     binds: [B:107:0x0248, B:97:0x0218, B:91:0x01f9, B:87:0x01e1, B:83:0x01cb, B:79:0x01b5, B:75:0x019c, B:71:0x0184, B:67:0x016c, B:63:0x0156, B:29:0x00a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
    /* JADX WARN: Instruction removed from duplicated block: B:108:0x024a, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void processTransform(ReadableArray transforms, double[] result, float viewWidth, float viewHeight, ReadableArray transformOrigin, boolean allowPercentageResolution) {
        int i;
        char c;
        double translateValue;
        double translateValue2;
        double translateValue3;
        double translateValue4;
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        Intrinsics.checkNotNullParameter(result, "result");
        int i2 = 1;
        if (allowPercentageResolution && ReactNativeFeatureFlags.useNativeTransformHelperAndroid() && (transforms instanceof NativeArray)) {
            if (transformOrigin == 0 ? true : transformOrigin instanceof NativeArray) {
                nativeProcessTransform((NativeArray) transforms, result, viewWidth, viewHeight, (NativeArray) transformOrigin);
                return;
            }
        }
        Object obj = helperMatrix.get();
        Intrinsics.checkNotNull(obj);
        double[] dArr = (double[]) obj;
        MatrixMathHelper.resetIdentityMatrix(result);
        double[] translateForTransformOrigin = INSTANCE.getTranslateForTransformOrigin(viewWidth, viewHeight, transformOrigin, allowPercentageResolution);
        if (translateForTransformOrigin != null) {
            MatrixMathHelper.resetIdentityMatrix(dArr);
            MatrixMathHelper.applyTranslate3D(dArr, translateForTransformOrigin[0], translateForTransformOrigin[1], translateForTransformOrigin[2]);
            MatrixMathHelper.multiplyInto(result, result, dArr);
        }
        if (transforms.size() == 16 && transforms.getType(0) == ReadableType.Number) {
            MatrixMathHelper.resetIdentityMatrix(dArr);
            int size = transforms.size();
            for (int i3 = 0; i3 < size; i3++) {
                dArr[i3] = transforms.getDouble(i3);
            }
            MatrixMathHelper.multiplyInto(result, result, dArr);
        } else {
            int size2 = transforms.size();
            int i4 = 0;
            while (i4 < size2) {
                ReadableMap map = transforms.getMap(i4);
                Intrinsics.checkNotNull(map);
                String strNextKey = map.keySetIterator().nextKey();
                MatrixMathHelper.resetIdentityMatrix(dArr);
                int i5 = i4;
                switch (strNextKey.hashCode()) {
                    case -1721943862:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("translateX")) {
                            if (map.getType(strNextKey) == ReadableType.String && allowPercentageResolution) {
                                TransformHelper transformHelper = INSTANCE;
                                String string = map.getString(strNextKey);
                                Intrinsics.checkNotNull(string);
                                translateValue = transformHelper.parseTranslateValue(string, viewWidth);
                            } else {
                                translateValue = map.getDouble(strNextKey);
                            }
                            MatrixMathHelper.applyTranslate2D(dArr, translateValue, 0.0d);
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -1721943861:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("translateY")) {
                            if (map.getType(strNextKey) == ReadableType.String && allowPercentageResolution) {
                                TransformHelper transformHelper2 = INSTANCE;
                                String string2 = map.getString(strNextKey);
                                Intrinsics.checkNotNull(string2);
                                translateValue2 = transformHelper2.parseTranslateValue(string2, viewHeight);
                            } else {
                                translateValue2 = map.getDouble(strNextKey);
                            }
                            MatrixMathHelper.applyTranslate2D(dArr, 0.0d, translateValue2);
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -1081239615:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("matrix")) {
                            ReadableArray array = map.getArray(strNextKey);
                            Intrinsics.checkNotNull(array);
                            for (int i6 = 0; i6 < 16; i6++) {
                                dArr[i6] = array.getDouble(i6);
                            }
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -925180581:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("rotate")) {
                            MatrixMathHelper.applyRotateZ(dArr, INSTANCE.convertToRadians(map, strNextKey));
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -908189618:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("scaleX")) {
                            MatrixMathHelper.applyScaleX(dArr, map.getDouble(strNextKey));
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -908189617:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("scaleY")) {
                            MatrixMathHelper.applyScaleY(dArr, map.getDouble(strNextKey));
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 109250890:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("scale")) {
                            double d = map.getDouble(strNextKey);
                            MatrixMathHelper.applyScaleX(dArr, d);
                            MatrixMathHelper.applyScaleY(dArr, d);
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 109493390:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("skewX")) {
                            MatrixMathHelper.applySkewX(dArr, INSTANCE.convertToRadians(map, strNextKey));
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 109493391:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("skewY")) {
                            MatrixMathHelper.applySkewY(dArr, INSTANCE.convertToRadians(map, strNextKey));
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 207960636:
                        i = size2;
                        c = 16;
                        if (strNextKey.equals("perspective")) {
                            MatrixMathHelper.applyPerspective(dArr, map.getDouble(strNextKey));
                        } else {
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 1052832078:
                        if (strNextKey.equals("translate")) {
                            ReadableArray array2 = map.getArray(strNextKey);
                            Intrinsics.checkNotNull(array2);
                            ReadableType type = array2.getType(0);
                            ReadableType readableType = ReadableType.String;
                            if (type == readableType && allowPercentageResolution) {
                                TransformHelper transformHelper3 = INSTANCE;
                                String string3 = array2.getString(0);
                                Intrinsics.checkNotNull(string3);
                                translateValue3 = transformHelper3.parseTranslateValue(string3, viewWidth);
                            } else {
                                translateValue3 = array2.getDouble(0);
                            }
                            if (array2.getType(i2) == readableType && allowPercentageResolution) {
                                TransformHelper transformHelper4 = INSTANCE;
                                String string4 = array2.getString(i2);
                                Intrinsics.checkNotNull(string4);
                                translateValue4 = transformHelper4.parseTranslateValue(string4, viewHeight);
                            } else {
                                translateValue4 = array2.getDouble(i2);
                            }
                            dArr = dArr;
                            double d2 = translateValue4;
                            i = size2;
                            double d3 = translateValue3;
                            c = 16;
                            MatrixMathHelper.applyTranslate3D(dArr, d3, d2, array2.size() > 2 ? array2.getDouble(2) : 0.0d);
                        } else {
                            i = size2;
                            c = 16;
                            FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 1384173149:
                        if (strNextKey.equals("rotateX")) {
                            MatrixMathHelper.applyRotateX(dArr, INSTANCE.convertToRadians(map, strNextKey));
                            i = size2;
                            c = 16;
                        }
                        i = size2;
                        c = 16;
                        FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        break;
                    case 1384173150:
                        if (strNextKey.equals("rotateY")) {
                            MatrixMathHelper.applyRotateY(dArr, INSTANCE.convertToRadians(map, strNextKey));
                            i = size2;
                            c = 16;
                        }
                        i = size2;
                        c = 16;
                        FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        break;
                    case 1384173151:
                        if (strNextKey.equals("rotateZ")) {
                            i = size2;
                            c = 16;
                            MatrixMathHelper.applyRotateZ(dArr, INSTANCE.convertToRadians(map, strNextKey));
                        }
                        i = size2;
                        c = 16;
                        FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        break;
                    default:
                        i = size2;
                        c = 16;
                        FLog.w("ReactNative", "Unsupported transform type: " + strNextKey);
                        break;
                }
                MatrixMathHelper.multiplyInto(result, result, dArr);
                i4 = i5 + 1;
                size2 = i;
                i2 = 1;
            }
        }
        if (translateForTransformOrigin != null) {
            MatrixMathHelper.resetIdentityMatrix(dArr);
            MatrixMathHelper.applyTranslate3D(dArr, -translateForTransformOrigin[0], -translateForTransformOrigin[1], -translateForTransformOrigin[2]);
            MatrixMathHelper.multiplyInto(result, result, dArr);
        }
    }

    private final double parseTranslateValue(String stringValue, double dimension) {
        try {
            if (StringsKt.endsWith$default(stringValue, "%", false, 2, (Object) null)) {
                return (Double.parseDouble(StringsKt.dropLast(stringValue, 1)) * dimension) / 100.0d;
            }
            return Double.parseDouble(stringValue);
        } catch (NumberFormatException unused) {
            FLog.w("ReactNative", "Invalid translate value: " + stringValue);
            return 0.0d;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0043  */
    private final double[] getTranslateForTransformOrigin(float viewWidth, float viewHeight, ReadableArray transformOrigin, boolean allowPercentageResolution) {
        if (transformOrigin == null || (viewHeight == 0.0f && viewWidth == 0.0f)) {
            return null;
        }
        double d = ((double) viewWidth) / 2.0d;
        double d2 = ((double) viewHeight) / 2.0d;
        double[] dArr = new double[3];
        boolean z = false;
        dArr[0] = d;
        int i = 1;
        dArr[1] = d2;
        dArr[2] = 0.0d;
        int iMin = Math.min(transformOrigin.size(), 3);
        int i2 = 0;
        while (i2 < iMin) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[transformOrigin.getType(i2).ordinal()];
            if (i3 == i) {
                dArr[i2] = transformOrigin.getDouble(i2);
            } else if (i3 == 2 && allowPercentageResolution) {
                String string = transformOrigin.getString(i2);
                Intrinsics.checkNotNull(string);
                if (StringsKt.endsWith$default(string, "%", z, 2, (Object) null)) {
                    dArr[i2] = (((double) (i2 == 0 ? viewWidth : viewHeight)) * Double.parseDouble(StringsKt.dropLast(string, i))) / 100.0d;
                }
            }
            i2++;
            z = z;
            i = i;
        }
        boolean z2 = z;
        int i4 = i;
        double d3 = (-d) + dArr[z2 ? 1 : 0];
        double d4 = (-d2) + dArr[i4];
        double d5 = dArr[2];
        double[] dArr2 = new double[3];
        dArr2[z2 ? 1 : 0] = d3;
        dArr2[i4] = d4;
        dArr2[2] = d5;
        return dArr2;
    }
}
