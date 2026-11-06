package com.facebook.react.animated;

import androidx.core.graphics.ColorUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InterpolationAnimatedNode extends ValueAnimatedNode {
    public static final Companion Companion = new Companion(null);
    private static final Pattern numericPattern;
    private final String extrapolateLeft;
    private final String extrapolateRight;
    private final double[] inputRange;
    private Object objectValue;
    private Object outputRange;
    private OutputType outputType;
    private ValueAnimatedNode parent;
    private String pattern;

    private enum OutputType {
        Number,
        Color,
        String;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputType.values().length];
            try {
                iArr[OutputType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputType.Color.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutputType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterpolationAnimatedNode(ReadableMap config) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Companion companion = Companion;
        this.inputRange = companion.fromDoubleArray(config.getArray("inputRange"));
        this.extrapolateLeft = config.getString("extrapolateLeft");
        this.extrapolateRight = config.getString("extrapolateRight");
        ReadableArray array = config.getArray("outputRange");
        if (Intrinsics.areEqual("color", config.getString("outputType"))) {
            this.outputType = OutputType.Color;
            this.outputRange = companion.fromIntArray(array);
            return;
        }
        if ((array != null ? array.getType(0) : null) == ReadableType.String) {
            this.outputType = OutputType.String;
            this.outputRange = companion.fromStringPattern(array);
            this.pattern = array.getString(0);
        } else {
            this.outputType = OutputType.Number;
            this.outputRange = companion.fromDoubleArray(array);
        }
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void onAttachedToNode$ReactAndroid_release(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.parent != null) {
            throw new IllegalStateException("Parent already attached");
        }
        if (!(parent instanceof ValueAnimatedNode)) {
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
        this.parent = (ValueAnimatedNode) parent;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void onDetachedFromNode$ReactAndroid_release(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent != this.parent) {
            throw new IllegalArgumentException("Invalid parent node provided");
        }
        this.parent = null;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update$ReactAndroid_release() {
        String str;
        ValueAnimatedNode valueAnimatedNode = this.parent;
        if (valueAnimatedNode != null) {
            double value = valueAnimatedNode.getValue();
            OutputType outputType = this.outputType;
            int i = outputType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[outputType.ordinal()];
            if (i == 1) {
                Companion companion = Companion;
                double[] dArr = this.inputRange;
                Object obj = this.outputRange;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.DoubleArray");
                this.nodeValue = companion.interpolate(value, dArr, (double[]) obj, this.extrapolateLeft, this.extrapolateRight);
                return;
            }
            if (i == 2) {
                Companion companion2 = Companion;
                double[] dArr2 = this.inputRange;
                Object obj2 = this.outputRange;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.IntArray");
                this.objectValue = Integer.valueOf(companion2.interpolateColor(value, dArr2, (int[]) obj2));
                return;
            }
            if (i == 3 && (str = this.pattern) != null) {
                Companion companion3 = Companion;
                double[] dArr3 = this.inputRange;
                Object obj3 = this.outputRange;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.DoubleArray>");
                this.objectValue = companion3.interpolateString(str, value, dArr3, (double[][]) obj3, this.extrapolateLeft, this.extrapolateRight);
            }
        }
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode
    public Object getAnimatedObject() {
        return this.objectValue;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "InterpolationAnimatedNode[" + this.tag + "] super: " + super.prettyPrint$ReactAndroid_release();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double[] fromDoubleArray(ReadableArray readableArray) {
            if (readableArray != null) {
                int size = readableArray.size();
                double[] dArr = new double[size];
                for (int i = 0; i < size; i++) {
                    dArr[i] = readableArray.getDouble(i);
                }
                return dArr;
            }
            return new double[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] fromIntArray(ReadableArray readableArray) {
            if (readableArray != null) {
                int size = readableArray.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = readableArray.getInt(i);
                }
                return iArr;
            }
            return new int[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double[][] fromStringPattern(ReadableArray readableArray) {
            int size = readableArray.size();
            double[][] dArr = new double[size][];
            Pattern pattern = InterpolationAnimatedNode.numericPattern;
            String string = readableArray.getString(0);
            if (string == null) {
                string = "";
            }
            Matcher matcher = pattern.matcher(string);
            ArrayList arrayList = new ArrayList();
            while (matcher.find()) {
                String strGroup = matcher.group();
                Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                arrayList.add(Double.valueOf(Double.parseDouble(strGroup)));
            }
            int size2 = arrayList.size();
            double[] dArr2 = new double[size2];
            int size3 = arrayList.size();
            for (int i = 0; i < size3; i++) {
                dArr2[i] = ((Number) arrayList.get(i)).doubleValue();
            }
            dArr[0] = dArr2;
            for (int i2 = 1; i2 < size; i2++) {
                double[] dArr3 = new double[size2];
                Pattern pattern2 = InterpolationAnimatedNode.numericPattern;
                String string2 = readableArray.getString(i2);
                if (string2 == null) {
                    string2 = "";
                }
                Matcher matcher2 = pattern2.matcher(string2);
                for (int i3 = 0; matcher2.find() && i3 < size2; i3++) {
                    String strGroup2 = matcher2.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "group(...)");
                    dArr3[i3] = Double.parseDouble(strGroup2);
                }
                dArr[i2] = dArr3;
            }
            return dArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        
            if (r22.equals("extend") != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        
            if (r23.equals("extend") != false) goto L38;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final double interpolate(double r12, double r14, double r16, double r18, double r20, java.lang.String r22, java.lang.String r23) {
            /*
                r11 = this;
                r0 = r22
                r1 = r23
                int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                java.lang.String r3 = "Invalid extrapolation type "
                java.lang.String r4 = "extend"
                java.lang.String r5 = "identity"
                java.lang.String r6 = "clamp"
                r7 = 94742715(0x5a5a8bb, float:1.5578507E-35)
                r8 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
                r9 = -1289044198(0xffffffffb32abf1a, float:-3.9755015E-8)
                if (r2 >= 0) goto L55
                if (r0 == 0) goto L3b
                int r10 = r0.hashCode()
                if (r10 == r9) goto L34
                if (r10 == r8) goto L2d
                if (r10 != r7) goto L3b
                boolean r12 = r0.equals(r6)
                if (r12 == 0) goto L3b
                r12 = r14
                goto L55
            L2d:
                boolean r1 = r0.equals(r5)
                if (r1 == 0) goto L3b
                return r12
            L34:
                boolean r10 = r0.equals(r4)
                if (r10 == 0) goto L3b
                goto L55
            L3b:
                com.facebook.react.bridge.JSApplicationIllegalArgumentException r12 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r3)
                r13.append(r0)
                java.lang.String r0 = "for left extrapolation"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            L55:
                int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
                if (r0 <= 0) goto L96
                if (r1 == 0) goto L7c
                int r0 = r1.hashCode()
                if (r0 == r9) goto L75
                if (r0 == r8) goto L6e
                if (r0 != r7) goto L7c
                boolean r12 = r1.equals(r6)
                if (r12 == 0) goto L7c
                r12 = r16
                goto L96
            L6e:
                boolean r0 = r1.equals(r5)
                if (r0 == 0) goto L7c
                return r12
            L75:
                boolean r0 = r1.equals(r4)
                if (r0 == 0) goto L7c
                goto L96
            L7c:
                com.facebook.react.bridge.JSApplicationIllegalArgumentException r12 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r3)
                r13.append(r1)
                java.lang.String r0 = "for right extrapolation"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            L96:
                int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
                if (r0 != 0) goto L9b
                return r18
            L9b:
                int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r0 != 0) goto La3
                if (r2 > 0) goto La2
                return r18
            La2:
                return r20
            La3:
                double r0 = r20 - r18
                double r12 = r12 - r14
                double r0 = r0 * r12
                double r12 = r16 - r14
                double r0 = r0 / r12
                double r12 = r18 + r0
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.InterpolationAnimatedNode.Companion.interpolate(double, double, double, double, double, java.lang.String, java.lang.String):double");
        }

        public final double interpolate(double d, double[] inputRange, double[] outputRange, String str, String str2) {
            Intrinsics.checkNotNullParameter(inputRange, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            int iFindRangeIndex = findRangeIndex(d, inputRange);
            int i = iFindRangeIndex + 1;
            return interpolate(d, inputRange[iFindRangeIndex], inputRange[i], outputRange[iFindRangeIndex], outputRange[i], str, str2);
        }

        public final int interpolateColor(double d, double[] inputRange, int[] outputRange) {
            Intrinsics.checkNotNullParameter(inputRange, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            int iFindRangeIndex = findRangeIndex(d, inputRange);
            int i = outputRange[iFindRangeIndex];
            int i2 = iFindRangeIndex + 1;
            int i3 = outputRange[i2];
            if (i != i3) {
                double d2 = inputRange[iFindRangeIndex];
                double d3 = inputRange[i2];
                if (d2 != d3) {
                    return ColorUtils.blendARGB(i, i3, (float) ((d - d2) / (d3 - d2)));
                }
                if (d > d2) {
                    return i3;
                }
            }
            return i;
        }

        public final String interpolateString(String pattern, double d, double[] dArr, double[][] outputRange, String str, String str2) {
            double[] inputRange = dArr;
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(inputRange, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            Companion companion = this;
            double d2 = d;
            int iFindRangeIndex = companion.findRangeIndex(d2, inputRange);
            StringBuffer stringBuffer = new StringBuffer(pattern.length());
            Matcher matcher = InterpolationAnimatedNode.numericPattern.matcher(pattern);
            int i = 0;
            while (matcher.find()) {
                double[] dArr2 = outputRange[iFindRangeIndex];
                if (i >= dArr2.length) {
                    break;
                }
                int i2 = iFindRangeIndex + 1;
                StringBuffer stringBuffer2 = stringBuffer;
                int i3 = i;
                double dInterpolate = companion.interpolate(d2, inputRange[iFindRangeIndex], inputRange[i2], dArr2[i], outputRange[i2][i], str, str2);
                int i4 = (int) dInterpolate;
                matcher.appendReplacement(stringBuffer2, ((double) i4) == dInterpolate ? String.valueOf(i4) : String.valueOf(dInterpolate));
                i = i3 + 1;
                companion = this;
                d2 = d;
                stringBuffer = stringBuffer2;
                inputRange = dArr;
            }
            StringBuffer stringBuffer3 = stringBuffer;
            matcher.appendTail(stringBuffer3);
            String string = stringBuffer3.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        private final int findRangeIndex(double d, double[] dArr) {
            int i = 1;
            while (i < dArr.length - 1 && dArr[i] < d) {
                i++;
            }
            return i - 1;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        numericPattern = patternCompile;
    }
}
