package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class MultiParagraph {
    private final boolean didExceedMaxLines;
    private final float height;
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List paragraphInfoList;
    private final List placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, i, z);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z) {
        boolean z2;
        int iM2529getMaxHeightimpl;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = i;
        if (Constraints.m2532getMinWidthimpl(j) != 0 || Constraints.m2531getMinHeightimpl(j) != 0) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        List infoList$ui_text_release = multiParagraphIntrinsics.getInfoList$ui_text_release();
        int size = infoList$ui_text_release.size();
        int i2 = 0;
        float f = 0.0f;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z2 = false;
                break;
            }
            ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) infoList$ui_text_release.get(i3);
            ParagraphIntrinsics intrinsics = paragraphIntrinsicInfo.getIntrinsics();
            int iM2530getMaxWidthimpl = Constraints.m2530getMaxWidthimpl(j);
            if (Constraints.m2525getHasBoundedHeightimpl(j)) {
                iM2529getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m2529getMaxHeightimpl(j) - ParagraphKt.ceilToInt(f), 0);
            } else {
                iM2529getMaxHeightimpl = Constraints.m2529getMaxHeightimpl(j);
            }
            Paragraph paragraphM2163Paragraph_EkL_Y = ParagraphKt.m2163Paragraph_EkL_Y(intrinsics, ConstraintsKt.Constraints$default(0, iM2530getMaxWidthimpl, 0, iM2529getMaxHeightimpl, 5, null), this.maxLines - i2, z);
            float height = f + paragraphM2163Paragraph_EkL_Y.getHeight();
            int lineCount = i2 + paragraphM2163Paragraph_EkL_Y.getLineCount();
            arrayList.add(new ParagraphInfo(paragraphM2163Paragraph_EkL_Y, paragraphIntrinsicInfo.getStartIndex(), paragraphIntrinsicInfo.getEndIndex(), i2, lineCount, f, height));
            if (paragraphM2163Paragraph_EkL_Y.getDidExceedMaxLines() || (lineCount == this.maxLines && i3 != CollectionsKt.getLastIndex(this.intrinsics.getInfoList$ui_text_release()))) {
                z2 = true;
                i2 = lineCount;
                f = height;
                break;
            } else {
                i3++;
                i2 = lineCount;
                f = height;
            }
        }
        this.height = f;
        this.lineCount = i2;
        this.didExceedMaxLines = z2;
        this.paragraphInfoList = arrayList;
        this.width = Constraints.m2530getMaxWidthimpl(j);
        List arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i4);
            List placeholderRects = paragraphInfo.getParagraph().getPlaceholderRects();
            ArrayList arrayList3 = new ArrayList(placeholderRects.size());
            int size3 = placeholderRects.size();
            for (int i5 = 0; i5 < size3; i5++) {
                Rect rect = (Rect) placeholderRects.get(i5);
                arrayList3.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        if (arrayList2.size() < this.intrinsics.getPlaceholders().size()) {
            int size4 = this.intrinsics.getPlaceholders().size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size4);
            for (int i6 = 0; i6 < size4; i6++) {
                arrayList4.add(null);
            }
            arrayList2 = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4);
        }
        this.placeholderRects = arrayList2;
    }

    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return ((ParagraphInfo) this.paragraphInfoList.get(0)).getParagraph().getFirstBaseline();
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last(this.paragraphInfoList);
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLastBaseline());
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final List getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final List getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    /* JADX INFO: renamed from: paint-LG529CI, reason: not valid java name */
    public final void m2153paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        canvas.save();
        List list = this.paragraphInfoList;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i2);
            paragraphInfo.getParagraph().mo2122paintLG529CI(canvas, j, shadow, textDecoration, drawStyle, i);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* JADX INFO: renamed from: paint-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m2148painthn5TExg$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = Float.NaN;
        }
        multiParagraph.m2154painthn5TExg(canvas, brush, f, (i2 & 8) != 0 ? null : shadow, (i2 & 16) != 0 ? null : textDecoration, (i2 & 32) != 0 ? null : drawStyle, (i2 & 64) != 0 ? DrawScope.Companion.m1600getDefaultBlendMode0nO6VwU() : i);
    }

    /* JADX INFO: renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m2154painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        AndroidMultiParagraphDraw_androidKt.m2384drawMultiParagraph7AXcY_I(this, canvas, brush, f, shadow, textDecoration, drawStyle, i);
    }

    public final Path getPathForRange(final int i, final int i2) {
        if (i >= 0 && i <= i2 && i2 <= getAnnotatedString().getText().length()) {
            if (i == i2) {
                return AndroidPath_androidKt.Path();
            }
            final Path Path = AndroidPath_androidKt.Path();
            MultiParagraphKt.m2155findParagraphsByRangeSbBc2M(this.paragraphInfoList, TextRangeKt.TextRange(i, i2), new Function1() { // from class: androidx.compose.ui.text.MultiParagraph.getPathForRange.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ParagraphInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ParagraphInfo paragraphInfo) {
                    Path.m1463addPathUv8p0NA$default(Path, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(i), paragraphInfo.toLocalIndex(i2))), 0L, 2, null);
                }
            });
            return Path;
        }
        throw new IllegalArgumentException(("Start(" + i + ") or End(" + i2 + ") is out of range [0.." + getAnnotatedString().getText().length() + "), or start > end!").toString());
    }

    public final int getLineForVerticalPosition(float f) {
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, f));
        if (paragraphInfo.getLength() == 0) {
            return paragraphInfo.getStartLineIndex();
        }
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForVerticalPosition(paragraphInfo.toLocalYPosition(f)));
    }

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m2150getOffsetForPositionk4lQ0M(long j) {
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.m1224getYimpl(j)));
        if (paragraphInfo.getLength() == 0) {
            return paragraphInfo.getStartIndex();
        }
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().mo2119getOffsetForPositionk4lQ0M(paragraphInfo.m2160toLocalMKHz9U(j)));
    }

    /* JADX INFO: renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m2151getRangeForRect86BmAI(Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        TextRange.Companion companion;
        TextRange.Companion companion2;
        int iFindParagraphByY = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getTop());
        if (((ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByY)).getBottom() >= rect.getBottom() || iFindParagraphByY == CollectionsKt.getLastIndex(this.paragraphInfoList)) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByY);
            return ParagraphInfo.m2158toGlobalxdX6G0$default(paragraphInfo, paragraphInfo.getParagraph().mo2120getRangeForRect86BmAI(paragraphInfo.toLocal(rect), i, textInclusionStrategy), false, 1, null);
        }
        int iFindParagraphByY2 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getBottom());
        long jM2222getZerod9O1mEE = TextRange.Companion.m2222getZerod9O1mEE();
        while (true) {
            companion = TextRange.Companion;
            if (!TextRange.m2210equalsimpl0(jM2222getZerod9O1mEE, companion.m2222getZerod9O1mEE()) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo2 = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByY);
            jM2222getZerod9O1mEE = ParagraphInfo.m2158toGlobalxdX6G0$default(paragraphInfo2, paragraphInfo2.getParagraph().mo2120getRangeForRect86BmAI(paragraphInfo2.toLocal(rect), i, textInclusionStrategy), false, 1, null);
            iFindParagraphByY++;
        }
        if (TextRange.m2210equalsimpl0(jM2222getZerod9O1mEE, companion.m2222getZerod9O1mEE())) {
            return companion.m2222getZerod9O1mEE();
        }
        long jM2222getZerod9O1mEE2 = companion.m2222getZerod9O1mEE();
        while (true) {
            companion2 = TextRange.Companion;
            if (!TextRange.m2210equalsimpl0(jM2222getZerod9O1mEE2, companion2.m2222getZerod9O1mEE()) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo3 = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByY2);
            jM2222getZerod9O1mEE2 = ParagraphInfo.m2158toGlobalxdX6G0$default(paragraphInfo3, paragraphInfo3.getParagraph().mo2120getRangeForRect86BmAI(paragraphInfo3.toLocal(rect), i, textInclusionStrategy), false, 1, null);
            iFindParagraphByY2--;
        }
        return TextRange.m2210equalsimpl0(jM2222getZerod9O1mEE2, companion2.m2222getZerod9O1mEE()) ? jM2222getZerod9O1mEE : TextRangeKt.TextRange(TextRange.m2217getStartimpl(jM2222getZerod9O1mEE), TextRange.m2212getEndimpl(jM2222getZerod9O1mEE2));
    }

    public final Rect getBoundingBox(int i) {
        requireIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getBoundingBox(paragraphInfo.toLocalIndex(i)));
    }

    /* JADX INFO: renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final float[] m2149fillBoundingBoxes8ffj60Q(final long j, final float[] fArr, int i) {
        requireIndexInRange(TextRange.m2215getMinimpl(j));
        requireIndexInRangeInclusiveEnd(TextRange.m2214getMaximpl(j));
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = i;
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        MultiParagraphKt.m2155findParagraphsByRangeSbBc2M(this.paragraphInfoList, j, new Function1() { // from class: androidx.compose.ui.text.MultiParagraph$fillBoundingBoxes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ParagraphInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ParagraphInfo paragraphInfo) {
                long j2 = j;
                float[] fArr2 = fArr;
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                long jTextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(paragraphInfo.getStartIndex() > TextRange.m2215getMinimpl(j2) ? paragraphInfo.getStartIndex() : TextRange.m2215getMinimpl(j2)), paragraphInfo.toLocalIndex(paragraphInfo.getEndIndex() < TextRange.m2214getMaximpl(j2) ? paragraphInfo.getEndIndex() : TextRange.m2214getMaximpl(j2)));
                paragraphInfo.getParagraph().mo2118fillBoundingBoxes8ffj60Q(jTextRange, fArr2, ref$IntRef2.element);
                int iM2213getLengthimpl = ref$IntRef2.element + (TextRange.m2213getLengthimpl(jTextRange) * 4);
                for (int i2 = ref$IntRef2.element; i2 < iM2213getLengthimpl; i2 += 4) {
                    int i3 = i2 + 1;
                    float f = fArr2[i3];
                    float f2 = ref$FloatRef2.element;
                    fArr2[i3] = f + f2;
                    int i4 = i2 + 3;
                    fArr2[i4] = fArr2[i4] + f2;
                }
                ref$IntRef2.element = iM2213getLengthimpl;
                ref$FloatRef2.element += paragraphInfo.getParagraph().getHeight();
            }
        });
        return fArr;
    }

    public final float getHorizontalPosition(int i, boolean z) {
        int iFindParagraphByIndex;
        requireIndexInRangeInclusiveEnd(i);
        if (i == getAnnotatedString().length()) {
            iFindParagraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            iFindParagraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByIndex);
        return paragraphInfo.getParagraph().getHorizontalPosition(paragraphInfo.toLocalIndex(i), z);
    }

    public final ResolvedTextDirection getParagraphDirection(int i) {
        int iFindParagraphByIndex;
        requireIndexInRangeInclusiveEnd(i);
        if (i == getAnnotatedString().length()) {
            iFindParagraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            iFindParagraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByIndex);
        return paragraphInfo.getParagraph().getParagraphDirection(paragraphInfo.toLocalIndex(i));
    }

    public final ResolvedTextDirection getBidiRunDirection(int i) {
        int iFindParagraphByIndex;
        requireIndexInRangeInclusiveEnd(i);
        if (i == getAnnotatedString().length()) {
            iFindParagraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            iFindParagraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByIndex);
        return paragraphInfo.getParagraph().getBidiRunDirection(paragraphInfo.toLocalIndex(i));
    }

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m2152getWordBoundaryjx7JFs(int i) {
        int iFindParagraphByIndex;
        requireIndexInRangeInclusiveEnd(i);
        if (i == getAnnotatedString().length()) {
            iFindParagraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            iFindParagraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByIndex);
        return paragraphInfo.m2159toGlobalxdX6G0(paragraphInfo.getParagraph().mo2121getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(i)), false);
    }

    public final Rect getCursorRect(int i) {
        int iFindParagraphByIndex;
        requireIndexInRangeInclusiveEnd(i);
        if (i == getAnnotatedString().length()) {
            iFindParagraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            iFindParagraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByIndex);
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getCursorRect(paragraphInfo.toLocalIndex(i)));
    }

    public final int getLineForOffset(int i) {
        int iFindParagraphByIndex;
        if (i >= getAnnotatedString().length()) {
            iFindParagraphByIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            iFindParagraphByIndex = i < 0 ? 0 : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(iFindParagraphByIndex);
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForOffset(paragraphInfo.toLocalIndex(i)));
    }

    public final float getLineLeft(int i) {
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getLineLeft(paragraphInfo.toLocalLineIndex(i));
    }

    public final float getLineRight(int i) {
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getLineRight(paragraphInfo.toLocalLineIndex(i));
    }

    public final float getLineTop(int i) {
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineTop(paragraphInfo.toLocalLineIndex(i)));
    }

    public final float getLineBottom(int i) {
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBottom(paragraphInfo.toLocalLineIndex(i)));
    }

    public final float getLineWidth(int i) {
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.getParagraph().getLineWidth(paragraphInfo.toLocalLineIndex(i));
    }

    public final int getLineStart(int i) {
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineStart(paragraphInfo.toLocalLineIndex(i)));
    }

    public final int getLineEnd(int i, boolean z) {
        requireLineIndexInRange(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineEnd(paragraphInfo.toLocalLineIndex(i), z));
    }

    private final void requireIndexInRange(int i) {
        if (i < 0 || i >= getAnnotatedString().getText().length()) {
            throw new IllegalArgumentException(("offset(" + i + ") is out of bounds [0, " + getAnnotatedString().length() + ')').toString());
        }
    }

    private final void requireIndexInRangeInclusiveEnd(int i) {
        if (i < 0 || i > getAnnotatedString().getText().length()) {
            throw new IllegalArgumentException(("offset(" + i + ") is out of bounds [0, " + getAnnotatedString().length() + ']').toString());
        }
    }

    private final void requireLineIndexInRange(int i) {
        if (i < 0 || i >= this.lineCount) {
            throw new IllegalArgumentException(("lineIndex(" + i + ") is out of bounds [0, " + this.lineCount + ')').toString());
        }
    }
}
