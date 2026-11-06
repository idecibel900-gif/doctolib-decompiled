package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Shader;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LengthPercentage;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
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
public final class LinearGradient implements Gradient {
    public static final Companion Companion = new Companion(null);
    private final List colorStops;
    private final Direction direction;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Direction.KeywordType.values().length];
            try {
                iArr[Direction.KeywordType.TO_TOP_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.KeywordType.TO_BOTTOM_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.KeywordType.TO_TOP_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.KeywordType.TO_BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LinearGradient(Direction direction, List colorStops) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        this.direction = direction;
        this.colorStops = colorStops;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0054  */
        public final Gradient parse(ReadableMap gradientMap, Context context) {
            Direction keyword;
            ArrayList arrayList;
            Integer numValueOf;
            Direction.KeywordType keywordTypeFromString;
            Intrinsics.checkNotNullParameter(gradientMap, "gradientMap");
            Intrinsics.checkNotNullParameter(context, "context");
            ReadableMap readableMap = gradientMap.hasKey("direction") ? gradientMap : null;
            if (readableMap == null) {
                keyword = null;
            } else {
                ReadableMap map = readableMap.getMap("direction");
                if (map == null) {
                    return null;
                }
                String string = map.getString("type");
                if (Intrinsics.areEqual(string, LinearGradientManager.PROP_ANGLE)) {
                    keyword = new Direction.Angle(map.getDouble("value"));
                } else if (!Intrinsics.areEqual(string, "keyword") || (keywordTypeFromString = Direction.KeywordType.Companion.fromString(map.getString("value"))) == null) {
                    keyword = null;
                } else {
                    keyword = new Direction.Keyword(keywordTypeFromString);
                }
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
                for (int i = 0; i < size; i++) {
                    ReadableMap map2 = array.getMap(i);
                    if (map2 != null) {
                        if (!map2.hasKey("color") || map2.isNull("color")) {
                            numValueOf = null;
                        } else if (map2.getType("color") == ReadableType.Map) {
                            numValueOf = ColorPropConverter.getColor(map2.getMap("color"), context);
                        } else {
                            numValueOf = Integer.valueOf(map2.getInt("color"));
                        }
                        arrayList.add(new ColorStop(numValueOf, LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.Companion, map2.getDynamic("position"), false, 2, null)));
                    }
                }
            } else {
                arrayList = null;
            }
            if (keyword == null || arrayList == null) {
                return null;
            }
            return new LinearGradient(keyword, arrayList);
        }
    }

    public static abstract class Direction {
        public /* synthetic */ Direction(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final class Angle extends Direction {
            private final double angle;

            public Angle(double d) {
                super(null);
                this.angle = d;
            }

            public final double getAngle() {
                return this.angle;
            }
        }

        private Direction() {
        }

        public static final class Keyword extends Direction {
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

        public enum KeywordType {
            TO_TOP_RIGHT("to top right"),
            TO_BOTTOM_RIGHT("to bottom right"),
            TO_TOP_LEFT("to top left"),
            TO_BOTTOM_LEFT("to bottom left");

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

    @Override // com.facebook.react.uimanager.style.Gradient
    public Shader getShader(float f, float f2) {
        LinearGradient linearGradient;
        double angleForKeyword;
        Direction direction = this.direction;
        if (direction instanceof Direction.Angle) {
            angleForKeyword = ((Direction.Angle) direction).getAngle();
            linearGradient = this;
        } else {
            if (!(direction instanceof Direction.Keyword)) {
                throw new NoWhenBranchMatchedException();
            }
            linearGradient = this;
            angleForKeyword = linearGradient.getAngleForKeyword(((Direction.Keyword) direction).getKeyword(), f, f2);
        }
        Pair pairEndPointsFromAngle = endPointsFromAngle(angleForKeyword, f2, f);
        float[] fArr = (float[]) pairEndPointsFromAngle.getFirst();
        float[] fArr2 = (float[]) pairEndPointsFromAngle.getSecond();
        float f3 = fArr2[0] - fArr[0];
        float f4 = fArr2[1] - fArr[1];
        List fixedColorStops = ColorStopUtils.INSTANCE.getFixedColorStops(linearGradient.colorStops, (float) Math.sqrt((f3 * f3) + (f4 * f4)));
        int[] iArr = new int[fixedColorStops.size()];
        float[] fArr3 = new float[fixedColorStops.size()];
        int i = 0;
        for (Object obj : fixedColorStops) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProcessedColorStop processedColorStop = (ProcessedColorStop) obj;
            Integer color = processedColorStop.getColor();
            if (color != null && processedColorStop.getPosition() != null) {
                iArr[i] = color.intValue();
                fArr3[i] = processedColorStop.getPosition().floatValue();
            }
            i = i2;
        }
        return new android.graphics.LinearGradient(fArr[0], fArr[1], fArr2[0], fArr2[1], iArr, fArr3, Shader.TileMode.CLAMP);
    }

    private final double getAngleForKeyword(Direction.KeywordType keywordType, double d, double d2) {
        double degrees;
        double d3;
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[keywordType.ordinal()];
        if (i2 == 1) {
            return ((double) 90) - Math.toDegrees(Math.atan(d / d2));
        }
        if (i2 != 2) {
            if (i2 == 3) {
                degrees = Math.toDegrees(Math.atan(d / d2));
                i = 270;
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                degrees = Math.toDegrees(Math.atan(d2 / d));
                i = SensibleDefaults.X_OFFSET;
            }
            d3 = i;
        } else {
            degrees = Math.toDegrees(Math.atan(d / d2));
            d3 = 90;
        }
        return degrees + d3;
    }

    private final Pair endPointsFromAngle(double d, float f, float f2) {
        float[] fArr;
        double d2 = 360;
        double d3 = d % d2;
        if (d3 < 0.0d) {
            d3 += d2;
        }
        if (d3 == 0.0d) {
            return new Pair(new float[]{0.0f, f}, new float[]{0.0f, 0.0f});
        }
        if (d3 == 90.0d) {
            return new Pair(new float[]{0.0f, 0.0f}, new float[]{f2, 0.0f});
        }
        if (d3 == 180.0d) {
            return new Pair(new float[]{0.0f, 0.0f}, new float[]{0.0f, f});
        }
        if (d3 == 270.0d) {
            return new Pair(new float[]{f2, 0.0f}, new float[]{0.0f, 0.0f});
        }
        float fTan = (float) Math.tan(Math.toRadians(((double) 90) - d3));
        float f3 = (-1) / fTan;
        float f4 = 2;
        float f5 = f / f4;
        float f6 = f2 / f4;
        if (d3 < 90.0d) {
            fArr = new float[]{f6, f5};
        } else if (d3 < 180.0d) {
            fArr = new float[]{f6, -f5};
        } else if (d3 < 270.0d) {
            fArr = new float[]{-f6, -f5};
        } else {
            fArr = new float[]{-f6, f5};
        }
        float f7 = fArr[1] - (fArr[0] * f3);
        float f8 = f7 / (fTan - f3);
        float f9 = (f3 * f8) + f7;
        return new Pair(new float[]{f6 - f8, f5 + f9}, new float[]{f6 + f8, f5 - f9});
    }
}
