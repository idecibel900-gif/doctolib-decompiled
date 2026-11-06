package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class XmlVectorParser_androidKt {
    private static final int FILL_TYPE_WINDING = 0;

    /* JADX INFO: renamed from: getStrokeLineCap-CSYIeUk, reason: not valid java name */
    private static final int m1672getStrokeLineCapCSYIeUk(int i, int i2) {
        if (i == 0) {
            return StrokeCap.Companion.m1500getButtKaPHkGw();
        }
        if (i != 1) {
            return i != 2 ? i2 : StrokeCap.Companion.m1502getSquareKaPHkGw();
        }
        return StrokeCap.Companion.m1501getRoundKaPHkGw();
    }

    /* JADX INFO: renamed from: getStrokeLineJoin-kLtJ_vA, reason: not valid java name */
    private static final int m1673getStrokeLineJoinkLtJ_vA(int i, int i2) {
        if (i == 0) {
            return StrokeJoin.Companion.m1508getMiterLxFBmk8();
        }
        if (i != 1) {
            return i != 2 ? i2 : StrokeJoin.Companion.m1507getBevelLxFBmk8();
        }
        return StrokeJoin.Companion.m1509getRoundLxFBmk8();
    }

    public static final boolean isAtEnd(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 1 || (xmlPullParser.getDepth() < 1 && xmlPullParser.getEventType() == 3);
    }

    public static final int parseCurrentVectorNode(AndroidVectorParser androidVectorParser, Resources resources, AttributeSet attributeSet, Resources.Theme theme, ImageVector.Builder builder, int i) throws XmlPullParserException {
        int eventType = androidVectorParser.getXmlParser().getEventType();
        if (eventType == 2) {
            String name = androidVectorParser.getXmlParser().getName();
            if (name == null) {
                return i;
            }
            int iHashCode = name.hashCode();
            if (iHashCode == -1649314686) {
                if (!name.equals("clip-path")) {
                    return i;
                }
                parseClipPath(androidVectorParser, resources, theme, attributeSet, builder);
                return i + 1;
            }
            if (iHashCode == 3433509) {
                if (!name.equals("path")) {
                    return i;
                }
                parsePath(androidVectorParser, resources, theme, attributeSet, builder);
                return i;
            }
            if (iHashCode != 98629247 || !name.equals("group")) {
                return i;
            }
            parseGroup(androidVectorParser, resources, theme, attributeSet, builder);
            return i;
        }
        if (eventType != 3 || !Intrinsics.areEqual("group", androidVectorParser.getXmlParser().getName())) {
            return i;
        }
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            builder.clearGroup();
        }
        return 0;
    }

    public static final XmlPullParser seekToStartTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static final ImageVector.Builder createVectorImageBuilder(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet) throws XmlPullParserException {
        long jM1385getUnspecified0d7_KjU;
        int iM1341getSrcIn0nO6VwU;
        ColorStateList namedColorStateList;
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(resources, theme, attributeSet, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY());
        boolean namedBoolean = androidVectorParser.getNamedBoolean(typedArrayObtainAttributes, "autoMirrored", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_AUTO_MIRRORED(), false);
        float namedFloat = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "viewportWidth", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_WIDTH(), 0.0f);
        float namedFloat2 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "viewportHeight", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_HEIGHT(), 0.0f);
        if (namedFloat <= 0.0f) {
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        }
        if (namedFloat2 <= 0.0f) {
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
        float dimension = androidVectorParser.getDimension(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_WIDTH(), 0.0f);
        float dimension2 = androidVectorParser.getDimension(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_HEIGHT(), 0.0f);
        if (typedArrayObtainAttributes.hasValue(androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) {
            TypedValue typedValue = new TypedValue();
            typedArrayObtainAttributes.getValue(androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT(), typedValue);
            if (typedValue.type != 2 && (namedColorStateList = androidVectorParser.getNamedColorStateList(typedArrayObtainAttributes, theme, "tint", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) != null) {
                jM1385getUnspecified0d7_KjU = ColorKt.Color(namedColorStateList.getDefaultColor());
            } else {
                jM1385getUnspecified0d7_KjU = Color.Companion.m1385getUnspecified0d7_KjU();
            }
        } else {
            jM1385getUnspecified0d7_KjU = Color.Companion.m1385getUnspecified0d7_KjU();
        }
        long j = jM1385getUnspecified0d7_KjU;
        int i = androidVectorParser.getInt(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT_MODE(), -1);
        if (i == -1) {
            iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1341getSrcIn0nO6VwU();
        } else if (i == 3) {
            iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1343getSrcOver0nO6VwU();
        } else if (i == 5) {
            iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1341getSrcIn0nO6VwU();
        } else if (i == 9) {
            iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1340getSrcAtop0nO6VwU();
        } else {
            switch (i) {
                case 14:
                    iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1332getModulate0nO6VwU();
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1337getScreen0nO6VwU();
                    break;
                case 16:
                    iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1335getPlus0nO6VwU();
                    break;
                default:
                    iM1341getSrcIn0nO6VwU = BlendMode.Companion.m1341getSrcIn0nO6VwU();
                    break;
            }
        }
        int i2 = iM1341getSrcIn0nO6VwU;
        float fM2551constructorimpl = Dp.m2551constructorimpl(dimension / resources.getDisplayMetrics().density);
        float fM2551constructorimpl2 = Dp.m2551constructorimpl(dimension2 / resources.getDisplayMetrics().density);
        typedArrayObtainAttributes.recycle();
        return new ImageVector.Builder(null, fM2551constructorimpl, fM2551constructorimpl2, namedFloat, namedFloat2, j, i2, namedBoolean, 1, null);
    }

    public static final void parsePath(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        List listPathStringToNodes$default;
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(resources, theme, attributeSet, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH());
        if (!TypedArrayUtils.hasAttribute(androidVectorParser.getXmlParser(), "pathData")) {
            throw new IllegalArgumentException("No path data available");
        }
        String string = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_NAME());
        if (string == null) {
            string = "";
        }
        String str = string;
        String string2 = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_PATH_DATA());
        if (string2 == null) {
            listPathStringToNodes$default = VectorKt.getEmptyPath();
        } else {
            listPathStringToNodes$default = PathParser.pathStringToNodes$default(androidVectorParser.pathParser, string2, null, 2, null);
        }
        List list = listPathStringToNodes$default;
        ComplexColorCompat namedComplexColor = androidVectorParser.getNamedComplexColor(typedArrayObtainAttributes, theme, "fillColor", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_COLOR(), 0);
        float namedFloat = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "fillAlpha", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_ALPHA(), 1.0f);
        int iM1672getStrokeLineCapCSYIeUk = m1672getStrokeLineCapCSYIeUk(androidVectorParser.getNamedInt(typedArrayObtainAttributes, "strokeLineCap", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_CAP(), -1), StrokeCap.Companion.m1500getButtKaPHkGw());
        int iM1673getStrokeLineJoinkLtJ_vA = m1673getStrokeLineJoinkLtJ_vA(androidVectorParser.getNamedInt(typedArrayObtainAttributes, "strokeLineJoin", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_JOIN(), -1), StrokeJoin.Companion.m1507getBevelLxFBmk8());
        float namedFloat2 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "strokeMiterLimit", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_MITER_LIMIT(), 1.0f);
        ComplexColorCompat namedComplexColor2 = androidVectorParser.getNamedComplexColor(typedArrayObtainAttributes, theme, "strokeColor", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_COLOR(), 0);
        float namedFloat3 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "strokeAlpha", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_ALPHA(), 1.0f);
        float namedFloat4 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "strokeWidth", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_WIDTH(), 1.0f);
        float namedFloat5 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "trimPathEnd", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_END(), 1.0f);
        float namedFloat6 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "trimPathOffset", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_OFFSET(), 0.0f);
        float namedFloat7 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "trimPathStart", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_START(), 0.0f);
        int namedInt = androidVectorParser.getNamedInt(typedArrayObtainAttributes, "fillType", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_FILLTYPE(), FILL_TYPE_WINDING);
        typedArrayObtainAttributes.recycle();
        builder.m1652addPathoIyEayM(list, namedInt == 0 ? PathFillType.Companion.m1468getNonZeroRgk1Os() : PathFillType.Companion.m1467getEvenOddRgk1Os(), str, obtainBrushFromComplexColor(namedComplexColor), namedFloat, obtainBrushFromComplexColor(namedComplexColor2), namedFloat3, namedFloat4, iM1672getStrokeLineCapCSYIeUk, iM1673getStrokeLineJoinkLtJ_vA, namedFloat2, namedFloat7, namedFloat5, namedFloat6);
    }

    private static final Brush obtainBrushFromComplexColor(ComplexColorCompat complexColorCompat) {
        if (!complexColorCompat.willDraw()) {
            return null;
        }
        Shader shader = complexColorCompat.getShader();
        if (shader != null) {
            return BrushKt.ShaderBrush(shader);
        }
        return new SolidColor(ColorKt.Color(complexColorCompat.getColor()), null);
    }

    public static final void parseClipPath(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(resources, theme, attributeSet, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH());
        String string = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_NAME());
        if (string == null) {
            string = "";
        }
        String str = string;
        String string2 = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_PATH_DATA());
        List emptyPath = string2 == null ? VectorKt.getEmptyPath() : PathParser.pathStringToNodes$default(androidVectorParser.pathParser, string2, null, 2, null);
        typedArrayObtainAttributes.recycle();
        ImageVector.Builder.addGroup$default(builder, str, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, emptyPath, 254, null);
    }

    public static final void parseGroup(AndroidVectorParser androidVectorParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ImageVector.Builder builder) {
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray typedArrayObtainAttributes = androidVectorParser.obtainAttributes(resources, theme, attributeSet, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP());
        float namedFloat = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "rotation", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_ROTATION(), 0.0f);
        float f = androidVectorParser.getFloat(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_X(), 0.0f);
        float f2 = androidVectorParser.getFloat(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_Y(), 0.0f);
        float namedFloat2 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "scaleX", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_X(), 1.0f);
        float namedFloat3 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "scaleY", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_Y(), 1.0f);
        float namedFloat4 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "translateX", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_X(), 0.0f);
        float namedFloat5 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "translateY", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_Y(), 0.0f);
        String string = androidVectorParser.getString(typedArrayObtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_NAME());
        if (string == null) {
            string = "";
        }
        typedArrayObtainAttributes.recycle();
        builder.addGroup(string, namedFloat, f, f2, namedFloat2, namedFloat3, namedFloat4, namedFloat5, VectorKt.getEmptyPath());
    }
}
