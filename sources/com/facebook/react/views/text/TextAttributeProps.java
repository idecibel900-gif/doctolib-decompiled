package com.facebook.react.views.text;

import android.os.Build;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class TextAttributeProps {
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_JUSTIFICATION_MODE = 0;
    private ReactAccessibilityDelegate.AccessibilityRole accessibilityRole;
    private boolean allowFontScaling;
    private Integer backgroundColor;
    private Integer color;
    private String fontFamily;
    private String fontFeatureSettings;
    private int fontSize;
    private float fontSizeInput;
    private int fontStyle;
    private int fontWeight;
    private boolean includeFontPadding;
    private boolean isBackgroundColorSet;
    private boolean isColorSet;
    private boolean isLineThroughTextDecorationSet;
    private boolean isUnderlineTextDecorationSet;
    private int layoutDirection;
    private float letterSpacingInput;
    private float lineHeight;
    private float lineHeightInput;
    private float maxFontSizeMultiplier;
    private int numberOfLines;
    private float opacity;
    private ReactAccessibilityDelegate.Role role;
    private int textShadowColor;
    private float textShadowOffsetDx;
    private float textShadowOffsetDy;
    private float textShadowRadius;
    private TextTransform textTransform;

    public /* synthetic */ TextAttributeProps(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TextAttributeProps() {
        this.lineHeight = Float.NaN;
        this.allowFontScaling = true;
        this.maxFontSizeMultiplier = Float.NaN;
        this.opacity = Float.NaN;
        this.numberOfLines = -1;
        this.fontSize = -1;
        this.fontSizeInput = -1.0f;
        this.lineHeightInput = -1.0f;
        this.letterSpacingInput = Float.NaN;
        this.layoutDirection = -1;
        this.textTransform = TextTransform.NONE;
        this.includeFontPadding = true;
        this.fontStyle = -1;
        this.fontWeight = -1;
        this.backgroundColor = 0;
        this.textShadowColor = 1426063360;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLineHeight(float f) {
        float pixelFromSP$default;
        this.lineHeightInput = f;
        if (f == -1.0f) {
            pixelFromSP$default = Float.NaN;
        } else {
            pixelFromSP$default = this.allowFontScaling ? PixelUtil.toPixelFromSP$default(f, 0.0f, 2, null) : PixelUtil.toPixelFromDIP(f);
        }
        this.lineHeight = pixelFromSP$default;
    }

    public final boolean isColorSet() {
        return this.isColorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAllowFontScaling(boolean z) {
        if (z != this.allowFontScaling) {
            this.allowFontScaling = z;
            setFontSize(this.fontSizeInput);
            setLineHeight(this.lineHeightInput);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMaxFontSizeMultiplier(float f) {
        if (f == this.maxFontSizeMultiplier) {
            return;
        }
        this.maxFontSizeMultiplier = f;
        setFontSize(this.fontSizeInput);
        setLineHeight(this.lineHeightInput);
    }

    public final boolean isBackgroundColorSet() {
        return this.isBackgroundColorSet;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final TextTransform getTextTransform$ReactAndroid_release() {
        return this.textTransform;
    }

    public final boolean isUnderlineTextDecorationSet() {
        return this.isUnderlineTextDecorationSet;
    }

    public final boolean isLineThroughTextDecorationSet() {
        return this.isLineThroughTextDecorationSet;
    }

    public final ReactAccessibilityDelegate.AccessibilityRole getAccessibilityRole() {
        return this.accessibilityRole;
    }

    public final ReactAccessibilityDelegate.Role getRole() {
        return this.role;
    }

    public final int getFontStyle() {
        return this.fontStyle;
    }

    public final int getFontWeight() {
        return this.fontWeight;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final float getLetterSpacing() {
        float pixelFromSP$default = this.allowFontScaling ? PixelUtil.toPixelFromSP$default(this.letterSpacingInput, 0.0f, 2, null) : PixelUtil.toPixelFromDIP(this.letterSpacingInput);
        int i = this.fontSize;
        if (i > 0) {
            return pixelFromSP$default / i;
        }
        throw new IllegalArgumentException(("FontSize should be a positive value. Current value: " + i).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLetterSpacing(float f) {
        this.letterSpacingInput = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFontSize(float f) {
        double dCeil;
        this.fontSizeInput = f;
        if (f != -1.0f) {
            if (this.allowFontScaling) {
                dCeil = Math.ceil(PixelUtil.toPixelFromSP(f, this.maxFontSizeMultiplier));
            } else {
                dCeil = Math.ceil(PixelUtil.toPixelFromDIP(f));
            }
            f = (float) dCeil;
        }
        this.fontSize = (int) f;
    }

    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setColor(Integer num) {
        this.isColorSet = num != null;
        if (num != null) {
            this.color = num;
        }
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBackgroundColor(Integer num) {
        this.isBackgroundColorSet = num != null;
        if (num != null) {
            this.backgroundColor = num;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void setFontVariant(MapBuffer mapBuffer) {
        if (mapBuffer == null || mapBuffer.getCount() == 0) {
            this.fontFeatureSettings = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            String stringValue = ((MapBuffer.Entry) it.next()).getStringValue();
            if (stringValue != null) {
                switch (stringValue.hashCode()) {
                    case -1983120972:
                        if (stringValue.equals("stylistic-thirteen")) {
                            arrayList.add("'ss13'");
                        }
                        break;
                    case -1933522176:
                        if (stringValue.equals("stylistic-fifteen")) {
                            arrayList.add("'ss15'");
                        }
                        break;
                    case -1534462052:
                        if (stringValue.equals("stylistic-eighteen")) {
                            arrayList.add("'ss18'");
                        }
                        break;
                    case -1195362251:
                        if (stringValue.equals("proportional-nums")) {
                            arrayList.add("'pnum'");
                        }
                        break;
                    case -1061392823:
                        if (stringValue.equals("lining-nums")) {
                            arrayList.add("'lnum'");
                        }
                        break;
                    case -771984547:
                        if (stringValue.equals("tabular-nums")) {
                            arrayList.add("'tnum'");
                        }
                        break;
                    case -659678800:
                        if (stringValue.equals("oldstyle-nums")) {
                            arrayList.add("'onum'");
                        }
                        break;
                    case 296506098:
                        if (stringValue.equals("stylistic-eight")) {
                            arrayList.add("'ss08'");
                        }
                        break;
                    case 309330544:
                        if (stringValue.equals("stylistic-seven")) {
                            arrayList.add("'ss07'");
                        }
                        break;
                    case 310339585:
                        if (stringValue.equals("stylistic-three")) {
                            arrayList.add("'ss03'");
                        }
                        break;
                    case 604478526:
                        if (stringValue.equals("stylistic-eleven")) {
                            arrayList.add("'ss11'");
                        }
                        break;
                    case 979426287:
                        if (stringValue.equals("stylistic-five")) {
                            arrayList.add("'ss05'");
                        }
                        break;
                    case 979432035:
                        if (stringValue.equals("stylistic-four")) {
                            arrayList.add("'ss04'");
                        }
                        break;
                    case 979664367:
                        if (stringValue.equals("stylistic-nine")) {
                            arrayList.add("'ss09'");
                        }
                        break;
                    case 1001434505:
                        if (stringValue.equals("stylistic-one")) {
                            arrayList.add("'ss01'");
                        }
                        break;
                    case 1001438213:
                        if (stringValue.equals("stylistic-six")) {
                            arrayList.add("'ss06'");
                        }
                        break;
                    case 1001439040:
                        if (stringValue.equals("stylistic-ten")) {
                            arrayList.add("'ss10'");
                        }
                        break;
                    case 1001439599:
                        if (stringValue.equals("stylistic-two")) {
                            arrayList.add("'ss02'");
                        }
                        break;
                    case 1030714463:
                        if (stringValue.equals("stylistic-sixteen")) {
                            arrayList.add("'ss16'");
                        }
                        break;
                    case 1044065430:
                        if (stringValue.equals("stylistic-twelve")) {
                            arrayList.add("'ss12'");
                        }
                        break;
                    case 1044067310:
                        if (stringValue.equals("stylistic-twenty")) {
                            arrayList.add("'ss20'");
                        }
                        break;
                    case 1183323111:
                        if (stringValue.equals("small-caps")) {
                            arrayList.add("'smcp'");
                        }
                        break;
                    case 1463562569:
                        if (stringValue.equals("stylistic-nineteen")) {
                            arrayList.add("'ss19'");
                        }
                        break;
                    case 1648446397:
                        if (stringValue.equals("stylistic-fourteen")) {
                            arrayList.add("'ss14'");
                        }
                        break;
                    case 2097122634:
                        if (stringValue.equals("stylistic-seventeen")) {
                            arrayList.add("'ss17'");
                        }
                        break;
                }
            }
        }
        this.fontFeatureSettings = TextUtils.join(", ", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFontWeight(String str) {
        this.fontWeight = ReactTypefaceUtils.parseFontWeight(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFontStyle(String str) {
        this.fontStyle = ReactTypefaceUtils.parseFontStyle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextDecorationLine(String str) {
        List listEmptyList;
        this.isUnderlineTextDecorationSet = false;
        this.isLineThroughTextDecorationSet = false;
        if (str != null) {
            List listSplit = new Regex("-").split(str, 0);
            if (!listSplit.isEmpty()) {
                ListIterator listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            for (String str2 : (String[]) listEmptyList.toArray(new String[0])) {
                if (Intrinsics.areEqual("underline", str2)) {
                    this.isUnderlineTextDecorationSet = true;
                } else if (Intrinsics.areEqual("strikethrough", str2)) {
                    this.isLineThroughTextDecorationSet = true;
                }
            }
        }
    }

    public final float getTextShadowOffsetDx() {
        return this.textShadowOffsetDx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextShadowOffsetDx(float f) {
        this.textShadowOffsetDx = PixelUtil.toPixelFromDIP(f);
    }

    public final float getTextShadowOffsetDy() {
        return this.textShadowOffsetDy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextShadowOffsetDy(float f) {
        this.textShadowOffsetDy = PixelUtil.toPixelFromDIP(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLayoutDirection(String str) {
        this.layoutDirection = Companion.getLayoutDirection(str);
    }

    public final float getTextShadowRadius() {
        return this.textShadowRadius;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextShadowRadius(float f) {
        if (f == this.textShadowRadius) {
            return;
        }
        this.textShadowRadius = f;
    }

    public final int getTextShadowColor() {
        return this.textShadowColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextShadowColor(int i) {
        if (i != this.textShadowColor) {
            this.textShadowColor = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:21:0x004f  */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x0033, please report this as an issue */
    public final void setTextTransform(String str) {
        TextTransform textTransform;
        if (str != null) {
            switch (str) {
                case "capitalize":
                    textTransform = TextTransform.CAPITALIZE;
                    break;
                case "lowercase":
                    textTransform = TextTransform.LOWERCASE;
                    break;
                case "none":
                    textTransform = TextTransform.NONE;
                    break;
                case "uppercase":
                    textTransform = TextTransform.UPPERCASE;
                    break;
                default:
                    FLog.w("ReactNative", "Invalid textTransform: " + str);
                    textTransform = TextTransform.NONE;
                    break;
            }
        } else {
            textTransform = TextTransform.NONE;
        }
        this.textTransform = textTransform;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAccessibilityRole(String str) {
        this.accessibilityRole = str == null ? null : ReactAccessibilityDelegate.AccessibilityRole.Companion.fromValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRole(ReactAccessibilityDelegate.Role role) {
        this.role = role;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextAttributeProps fromMapBuffer(MapBuffer props) {
            Intrinsics.checkNotNullParameter(props, "props");
            TextAttributeProps textAttributeProps = new TextAttributeProps(null);
            Iterator it = props.iterator();
            while (it.hasNext()) {
                MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
                switch (entry.getKey()) {
                    case 0:
                        textAttributeProps.setColor(Integer.valueOf(entry.getIntValue()));
                        break;
                    case 1:
                        textAttributeProps.setBackgroundColor(Integer.valueOf(entry.getIntValue()));
                        break;
                    case 2:
                        textAttributeProps.opacity = (float) entry.getDoubleValue();
                        break;
                    case 3:
                        textAttributeProps.fontFamily = entry.getStringValue();
                        break;
                    case 4:
                        textAttributeProps.setFontSize((float) entry.getDoubleValue());
                        break;
                    case 6:
                        textAttributeProps.setFontWeight(entry.getStringValue());
                        break;
                    case 7:
                        textAttributeProps.setFontStyle(entry.getStringValue());
                        break;
                    case 8:
                        textAttributeProps.setFontVariant(entry.getMapBufferValue());
                        break;
                    case 9:
                        textAttributeProps.setAllowFontScaling(entry.getBooleanValue());
                        break;
                    case 10:
                        textAttributeProps.setLetterSpacing((float) entry.getDoubleValue());
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        textAttributeProps.setLineHeight((float) entry.getDoubleValue());
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        textAttributeProps.setTextDecorationLine(entry.getStringValue());
                        break;
                    case 18:
                        textAttributeProps.setTextShadowRadius((float) entry.getDoubleValue());
                        break;
                    case 19:
                        textAttributeProps.setTextShadowColor(entry.getIntValue());
                        break;
                    case 20:
                        textAttributeProps.setTextShadowOffsetDx((float) entry.getDoubleValue());
                        break;
                    case 21:
                        textAttributeProps.setTextShadowOffsetDy((float) entry.getDoubleValue());
                        break;
                    case 23:
                        textAttributeProps.setLayoutDirection(entry.getStringValue());
                        break;
                    case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                        textAttributeProps.setAccessibilityRole(entry.getStringValue());
                        break;
                    case 26:
                        textAttributeProps.setRole((ReactAccessibilityDelegate.Role) ReactAccessibilityDelegate.Role.getEntries().get(entry.getIntValue()));
                        break;
                    case 27:
                        textAttributeProps.setTextTransform(entry.getStringValue());
                        break;
                    case 29:
                        textAttributeProps.setMaxFontSizeMultiplier((float) entry.getDoubleValue());
                        break;
                }
            }
            return textAttributeProps;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
        
            if (r4.equals("auto") == false) goto L31;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int getTextAlignment(com.facebook.react.uimanager.ReactStylesDiffMap r4, boolean r5, int r6) {
            /*
                r3 = this;
                java.lang.String r0 = "props"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "textAlign"
                boolean r1 = r4.hasKey(r0)
                if (r1 != 0) goto Le
                return r6
            Le:
                java.lang.String r4 = r4.getString(r0)
                r6 = 0
                if (r4 == 0) goto L6d
                int r0 = r4.hashCode()
                r1 = 5
                r2 = 3
                switch(r0) {
                    case -1364013995: goto L4c;
                    case -1249482096: goto L42;
                    case 3005871: goto L39;
                    case 3317767: goto L2c;
                    case 108511772: goto L1f;
                    default: goto L1e;
                }
            L1e:
                goto L54
            L1f:
                java.lang.String r0 = "right"
                boolean r0 = r4.equals(r0)
                if (r0 != 0) goto L28
                goto L54
            L28:
                if (r5 == 0) goto L2b
                return r2
            L2b:
                return r1
            L2c:
                java.lang.String r0 = "left"
                boolean r0 = r4.equals(r0)
                if (r0 != 0) goto L35
                goto L54
            L35:
                if (r5 == 0) goto L38
                return r1
            L38:
                return r2
            L39:
                java.lang.String r5 = "auto"
                boolean r5 = r4.equals(r5)
                if (r5 != 0) goto L6d
                goto L54
            L42:
                java.lang.String r5 = "justify"
                boolean r5 = r4.equals(r5)
                if (r5 != 0) goto L4b
                goto L54
            L4b:
                return r2
            L4c:
                java.lang.String r5 = "center"
                boolean r5 = r4.equals(r5)
                if (r5 != 0) goto L6b
            L54:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r0 = "Invalid textAlign: "
                r5.append(r0)
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                java.lang.String r5 = "ReactNative"
                com.facebook.common.logging.FLog.w(r5, r4)
                return r6
            L6b:
                r4 = 1
                return r4
            L6d:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextAttributeProps.Companion.getTextAlignment(com.facebook.react.uimanager.ReactStylesDiffMap, boolean, int):int");
        }

        public final int getJustificationMode(ReactStylesDiffMap props, int i) {
            Intrinsics.checkNotNullParameter(props, "props");
            if (!props.hasKey("textAlign")) {
                return i;
            }
            if (!Intrinsics.areEqual("justify", props.getString("textAlign")) || Build.VERSION.SDK_INT < 26) {
                return TextAttributeProps.DEFAULT_JUSTIFICATION_MODE;
            }
            return 1;
        }

        public final int getLayoutDirection(String str) {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1038130864) {
                    if (iHashCode != 107498) {
                        if (iHashCode == 113258 && str.equals("rtl")) {
                            return 1;
                        }
                    } else if (str.equals("ltr")) {
                        return 0;
                    }
                } else if (!str.equals("undefined")) {
                }
                FLog.w("ReactNative", "Invalid layoutDirection: " + str);
            }
            return -1;
        }

        public final int getTextBreakStrategy(String str) {
            if (str == null) {
                return 1;
            }
            if (Intrinsics.areEqual(str, "simple")) {
                return 0;
            }
            return Intrinsics.areEqual(str, "balanced") ? 2 : 1;
        }

        public final int getHyphenationFrequency(String str) {
            if (str == null || Intrinsics.areEqual(str, "none")) {
                return 0;
            }
            return Intrinsics.areEqual(str, Constants.NORMAL) ? 1 : 2;
        }

        public final TextUtils.TruncateAt getEllipsizeMode(String str) {
            if (str == null) {
                return null;
            }
            switch (str.hashCode()) {
                case -1074341483:
                    if (str.equals("middle")) {
                        return TextUtils.TruncateAt.MIDDLE;
                    }
                    return null;
                case 3056464:
                    str.equals("clip");
                    return null;
                case 3198432:
                    if (str.equals("head")) {
                        return TextUtils.TruncateAt.START;
                    }
                    return null;
                case 3552336:
                    if (str.equals("tail")) {
                        return TextUtils.TruncateAt.END;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }
}
