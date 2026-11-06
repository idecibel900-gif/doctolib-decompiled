package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Shader;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RadialGradient implements Gradient {
    public static final Companion Companion = new Companion(null);
    private final List colorStops;
    private final Position position;
    private final Shape shape;
    private final GradientSize size;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GradientSize.KeywordType.values().length];
            try {
                iArr[GradientSize.KeywordType.CLOSEST_SIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GradientSize.KeywordType.FARTHEST_SIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GradientSize.KeywordType.CLOSEST_CORNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GradientSize.KeywordType.FARTHEST_CORNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RadialGradient(Shape shape, GradientSize size, Position position, List colorStops) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        this.shape = shape;
        this.size = size;
        this.position = position;
        this.colorStops = colorStops;
    }

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.String.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:37:0x0094  */
        public final Gradient parse(ReadableMap readableMap, Context context) {
            GradientSize keyword;
            Position position;
            ArrayList arrayList;
            Integer numValueOf;
            LengthPercentage fromDynamic$default;
            LengthPercentage fromDynamic$default2;
            LengthPercentage fromDynamic$default3;
            LengthPercentage fromDynamic$default4;
            ReadableMap map;
            String string;
            ReadableMap gradientMap = readableMap;
            Intrinsics.checkNotNullParameter(gradientMap, "gradientMap");
            Intrinsics.checkNotNullParameter(context, "context");
            ReadableMap readableMap2 = gradientMap.hasKey("shape") ? gradientMap : null;
            Shape shapeFromString = (readableMap2 == null || (string = readableMap2.getString("shape")) == null) ? null : Shape.Companion.fromString(string);
            ReadableMap readableMap3 = gradientMap.hasKey("size") ? gradientMap : null;
            if (readableMap3 != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[readableMap3.getType("size").ordinal()];
                if (i == 1) {
                    GradientSize.KeywordType keywordTypeFromString = GradientSize.KeywordType.Companion.fromString(readableMap3.getString("size"));
                    if (keywordTypeFromString != null) {
                        keyword = new GradientSize.Keyword(keywordTypeFromString);
                    } else {
                        keyword = null;
                    }
                } else if (i == 2 && (map = readableMap3.getMap("size")) != null) {
                    if (!map.hasKey("x") || !map.hasKey("y")) {
                        map = null;
                    }
                    if (map != null) {
                        LengthPercentage.Companion companion = LengthPercentage.Companion;
                        LengthPercentage fromDynamic$default5 = LengthPercentage.Companion.setFromDynamic$default(companion, map.getDynamic("x"), false, 2, null);
                        LengthPercentage fromDynamic$default6 = LengthPercentage.Companion.setFromDynamic$default(companion, map.getDynamic("y"), false, 2, null);
                        if (fromDynamic$default5 == null || fromDynamic$default6 == null) {
                            keyword = null;
                        } else {
                            keyword = new GradientSize.Dimensions(fromDynamic$default5, fromDynamic$default6);
                        }
                    } else {
                        keyword = null;
                    }
                } else {
                    keyword = null;
                }
            } else {
                keyword = null;
            }
            ReadableMap readableMap4 = gradientMap.hasKey("position") ? gradientMap : null;
            if (readableMap4 != null) {
                ReadableMap map2 = readableMap4.getMap("position");
                if (map2 == null) {
                    return null;
                }
                if (map2.hasKey("top")) {
                    fromDynamic$default2 = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, map2.getDynamic("top"), false, 2, null);
                    fromDynamic$default = null;
                } else {
                    if (map2.hasKey("bottom")) {
                        fromDynamic$default = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, map2.getDynamic("bottom"), false, 2, null);
                        fromDynamic$default2 = null;
                    }
                    return null;
                }
                if (map2.hasKey("left")) {
                    fromDynamic$default4 = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, map2.getDynamic("left"), false, 2, null);
                    fromDynamic$default3 = null;
                } else {
                    if (map2.hasKey("right")) {
                        fromDynamic$default3 = LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, map2.getDynamic("right"), false, 2, null);
                        fromDynamic$default4 = null;
                    }
                    return null;
                }
                position = new Position(fromDynamic$default2, fromDynamic$default4, fromDynamic$default3, fromDynamic$default);
            } else {
                position = null;
            }
            if (!gradientMap.hasKey("colorStops")) {
                gradientMap = null;
            }
            if (gradientMap != null) {
                ReadableArray array = gradientMap.getArray("colorStops");
                if (array == null) {
                    return null;
                }
                arrayList = new ArrayList(array.size());
                int size = array.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ReadableMap map3 = array.getMap(i2);
                    if (map3 != null) {
                        if (!map3.hasKey("color") || map3.isNull("color")) {
                            numValueOf = null;
                        } else if (map3.getType("color") == ReadableType.Map) {
                            numValueOf = ColorPropConverter.getColor(map3.getMap("color"), context);
                        } else {
                            numValueOf = Integer.valueOf(map3.getInt("color"));
                        }
                        arrayList.add(new ColorStop(numValueOf, LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, map3.getDynamic("position"), false, 2, null)));
                    }
                }
            } else {
                arrayList = null;
            }
            if (shapeFromString == null || keyword == null || position == null || arrayList == null) {
                return null;
            }
            return new RadialGradient(shapeFromString, keyword, position, arrayList);
        }
    }

    public enum Shape {
        CIRCLE,
        ELLIPSE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        public static final Companion Companion = new Companion(null);

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Shape fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, "circle")) {
                    return Shape.CIRCLE;
                }
                if (Intrinsics.areEqual(value, "ellipse")) {
                    return Shape.ELLIPSE;
                }
                return null;
            }
        }
    }

    public static abstract class GradientSize {
        public /* synthetic */ GradientSize(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final class Keyword extends GradientSize {
            private final KeywordType keyword;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Keyword(KeywordType keyword) {
                super(null);
                Intrinsics.checkNotNullParameter(keyword, "keyword");
                this.keyword = keyword;
            }

            public final KeywordType getKeyword() {
                return this.keyword;
            }
        }

        private GradientSize() {
        }

        public static final class Dimensions extends GradientSize {
            private final LengthPercentage x;
            private final LengthPercentage y;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Dimensions(LengthPercentage x, LengthPercentage y) {
                super(null);
                Intrinsics.checkNotNullParameter(x, "x");
                Intrinsics.checkNotNullParameter(y, "y");
                this.x = x;
                this.y = y;
            }

            public final LengthPercentage getX() {
                return this.x;
            }

            public final LengthPercentage getY() {
                return this.y;
            }
        }

        public enum KeywordType {
            CLOSEST_SIDE("closest-side"),
            FARTHEST_SIDE("farthest-side"),
            CLOSEST_CORNER("closest-corner"),
            FARTHEST_CORNER("farthest-corner");

            private final String value;
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
            public static final Companion Companion = new Companion(null);

            KeywordType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }

            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KeywordType fromString(String str) {
                    for (KeywordType keywordType : KeywordType.values()) {
                        if (Intrinsics.areEqual(keywordType.getValue(), str)) {
                            return keywordType;
                        }
                    }
                    return null;
                }
            }
        }
    }

    public static final class Position {
        private final LengthPercentage bottom;
        private final LengthPercentage left;
        private final LengthPercentage right;
        private final LengthPercentage top;

        public Position(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2, LengthPercentage lengthPercentage3, LengthPercentage lengthPercentage4) {
            this.top = lengthPercentage;
            this.left = lengthPercentage2;
            this.right = lengthPercentage3;
            this.bottom = lengthPercentage4;
        }

        public final LengthPercentage getTop() {
            return this.top;
        }

        public final LengthPercentage getLeft() {
            return this.left;
        }

        public final LengthPercentage getRight() {
            return this.right;
        }

        public final LengthPercentage getBottom() {
            return this.bottom;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0113  */
    /* JADX WARN: Code duplicated, block: B:36:0x011b  */
    @Override // com.facebook.react.uimanager.style.Gradient
    public Shader getShader(float f, float f2) {
        float fDpToPx;
        float fDpToPx2;
        float fResolve;
        float f3;
        float fFloatValue;
        float fFloatValue2;
        int i;
        android.graphics.RadialGradient radialGradient;
        Integer color;
        float f4 = f / 2.0f;
        float fResolve2 = f2 / 2.0f;
        if (this.position.getTop() != null) {
            fResolve2 = this.position.getTop().getType() == LengthPercentageType.PERCENT ? this.position.getTop().resolve(f2) : PixelUtil.INSTANCE.dpToPx(this.position.getTop().resolve(f2));
        } else if (this.position.getBottom() != null) {
            if (this.position.getBottom().getType() == LengthPercentageType.PERCENT) {
                fDpToPx = this.position.getBottom().resolve(f2);
            } else {
                fDpToPx = PixelUtil.INSTANCE.dpToPx(this.position.getBottom().resolve(f2));
            }
            fResolve2 = f2 - fDpToPx;
        }
        float f5 = fResolve2;
        if (this.position.getLeft() != null) {
            fResolve = this.position.getLeft().getType() == LengthPercentageType.PERCENT ? this.position.getLeft().resolve(f) : PixelUtil.INSTANCE.dpToPx(this.position.getLeft().resolve(f));
        } else {
            if (this.position.getRight() != null) {
                if (this.position.getRight().getType() == LengthPercentageType.PERCENT) {
                    fDpToPx2 = this.position.getRight().resolve(f);
                } else {
                    fDpToPx2 = PixelUtil.INSTANCE.dpToPx(this.position.getRight().resolve(f));
                }
                fResolve = f - fDpToPx2;
            }
            f3 = f4;
            Pair pairCalculateRadius = calculateRadius(f3, f5, f, f2);
            fFloatValue = ((Number) pairCalculateRadius.getFirst()).floatValue();
            fFloatValue2 = ((Number) pairCalculateRadius.getSecond()).floatValue();
            List fixedColorStops = ColorStopUtils.INSTANCE.getFixedColorStops(this.colorStops, Math.max(fFloatValue, fFloatValue2));
            int[] iArr = new int[fixedColorStops.size()];
            float[] fArr = new float[fixedColorStops.size()];
            i = 0;
            for (Object obj : fixedColorStops) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ProcessedColorStop processedColorStop = (ProcessedColorStop) obj;
                color = processedColorStop.getColor();
                if (color == null && processedColorStop.getPosition() != null) {
                    iArr[i] = color.intValue();
                    fArr[i] = processedColorStop.getPosition().floatValue();
                }
                i = i2;
            }
            radialGradient = new android.graphics.RadialGradient(f3, f5, Math.max(fFloatValue, 1.0E-5f), iArr, fArr, Shader.TileMode.CLAMP);
            if (this.shape == Shape.CIRCLE && !FloatUtil.floatsEqual(fFloatValue, fFloatValue2)) {
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, fFloatValue2 / fFloatValue, f3, f5);
                radialGradient.setLocalMatrix(matrix);
            }
            return radialGradient;
        }
        f4 = fResolve;
        f3 = f4;
        Pair pairCalculateRadius2 = calculateRadius(f3, f5, f, f2);
        fFloatValue = ((Number) pairCalculateRadius2.getFirst()).floatValue();
        fFloatValue2 = ((Number) pairCalculateRadius2.getSecond()).floatValue();
        List fixedColorStops2 = ColorStopUtils.INSTANCE.getFixedColorStops(this.colorStops, Math.max(fFloatValue, fFloatValue2));
        int[] iArr2 = new int[fixedColorStops2.size()];
        float[] fArr2 = new float[fixedColorStops2.size()];
        i = 0;
        while (r0.hasNext()) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProcessedColorStop processedColorStop2 = (ProcessedColorStop) obj;
            color = processedColorStop2.getColor();
            if (color == null) {
            }
            i = i3;
        }
        radialGradient = new android.graphics.RadialGradient(f3, f5, Math.max(fFloatValue, 1.0E-5f), iArr2, fArr2, Shader.TileMode.CLAMP);
        if (this.shape == Shape.CIRCLE) {
            return radialGradient;
        }
        Matrix matrix2 = new Matrix();
        matrix2.setScale(1.0f, fFloatValue2 / fFloatValue, f3, f5);
        radialGradient.setLocalMatrix(matrix2);
        return radialGradient;
    }

    private final Pair radiusToSide(float f, float f2, float f3, float f4, GradientSize.KeywordType keywordType) {
        float fMax;
        float fMax2;
        float fMax3;
        float f5 = f3 - f;
        float f6 = f4 - f2;
        GradientSize.KeywordType keywordType2 = GradientSize.KeywordType.CLOSEST_SIDE;
        if (keywordType == keywordType2) {
            fMax = Math.min(f, f5);
            fMax2 = Math.min(f2, f6);
        } else {
            fMax = Math.max(f, f5);
            fMax2 = Math.max(f2, f6);
        }
        if (this.shape == Shape.CIRCLE) {
            if (keywordType == keywordType2) {
                fMax3 = Math.min(fMax, fMax2);
            } else {
                fMax3 = Math.max(fMax, fMax2);
            }
            return new Pair(Float.valueOf(fMax3), Float.valueOf(fMax3));
        }
        return new Pair(Float.valueOf(fMax), Float.valueOf(fMax2));
    }

    private final Pair calculateEllipseRadius(float f, float f2, float f3) {
        Float fValueOf = Float.valueOf(0.0f);
        if (f3 == 0.0f || Math.abs(f3) > Float.MAX_VALUE) {
            return new Pair(fValueOf, fValueOf);
        }
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2 * f3 * f3));
        return new Pair(Float.valueOf(fSqrt), Float.valueOf(fSqrt / f3));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00a4  */
    private final Pair radiusToCorner(float f, float f2, float f3, float f4, GradientSize.KeywordType keywordType) {
        GradientSize.KeywordType keywordType2;
        Float fValueOf = Float.valueOf(0.0f);
        Pair[] pairArr = {new Pair(fValueOf, fValueOf), new Pair(Float.valueOf(f3), fValueOf), new Pair(Float.valueOf(f3), Float.valueOf(f4)), new Pair(fValueOf, Float.valueOf(f4))};
        int i = 0;
        double d = 2;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(f - ((Number) pairArr[0].getFirst()).floatValue(), d)) + ((float) Math.pow(f2 - ((Number) pairArr[0].getSecond()).floatValue(), d)));
        boolean z = keywordType == GradientSize.KeywordType.CLOSEST_CORNER;
        for (int i2 = 1; i2 < 4; i2++) {
            float fSqrt2 = (float) Math.sqrt(((float) Math.pow(f - ((Number) pairArr[i2].getFirst()).floatValue(), d)) + ((float) Math.pow(f2 - ((Number) pairArr[i2].getSecond()).floatValue(), d)));
            if (z) {
                if (fSqrt2 < fSqrt) {
                    fSqrt = fSqrt2;
                    i = i2;
                }
            } else if (fSqrt2 > fSqrt) {
                fSqrt = fSqrt2;
                i = i2;
            }
        }
        if (this.shape == Shape.CIRCLE) {
            return new Pair(Float.valueOf(fSqrt), Float.valueOf(fSqrt));
        }
        if (z) {
            keywordType2 = GradientSize.KeywordType.CLOSEST_SIDE;
        } else {
            keywordType2 = GradientSize.KeywordType.FARTHEST_SIDE;
        }
        Pair pairRadiusToSide = radiusToSide(f, f2, f3, f4, keywordType2);
        return calculateEllipseRadius(((Number) pairArr[i].getFirst()).floatValue() - f, ((Number) pairArr[i].getSecond()).floatValue() - f2, ((Number) pairRadiusToSide.getFirst()).floatValue() / ((Number) pairRadiusToSide.getSecond()).floatValue());
    }

    private final Pair calculateRadius(float f, float f2, float f3, float f4) {
        GradientSize gradientSize = this.size;
        if (gradientSize instanceof GradientSize.Keyword) {
            GradientSize.KeywordType keyword = ((GradientSize.Keyword) gradientSize).getKeyword();
            int i = WhenMappings.$EnumSwitchMapping$0[keyword.ordinal()];
            if (i == 1 || i == 2) {
                return radiusToSide(f, f2, f3, f4, keyword);
            }
            if (i == 3 || i == 4) {
                return radiusToCorner(f, f2, f3, f4, keyword);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (gradientSize instanceof GradientSize.Dimensions) {
            LengthPercentageType type = ((GradientSize.Dimensions) gradientSize).getX().getType();
            LengthPercentageType lengthPercentageType = LengthPercentageType.PERCENT;
            float fResolve = type == lengthPercentageType ? ((GradientSize.Dimensions) this.size).getX().resolve(f3) : PixelUtil.INSTANCE.dpToPx(((GradientSize.Dimensions) this.size).getX().resolve(f3));
            float fResolve2 = ((GradientSize.Dimensions) this.size).getY().getType() == lengthPercentageType ? ((GradientSize.Dimensions) this.size).getY().resolve(f4) : PixelUtil.INSTANCE.dpToPx(((GradientSize.Dimensions) this.size).getY().resolve(f4));
            if (this.shape == Shape.CIRCLE) {
                float fMax = Math.max(fResolve, fResolve2);
                return new Pair(Float.valueOf(fMax), Float.valueOf(fMax));
            }
            return new Pair(Float.valueOf(fResolve), Float.valueOf(fResolve2));
        }
        return radiusToCorner(f, f2, f3, f4, GradientSize.KeywordType.FARTHEST_CORNER);
    }
}
