package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditingBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class HandwritingGesture_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: adjustHandwritingDeleteGestureRange-72CqOWE, reason: not valid java name */
    public static final long m583adjustHandwritingDeleteGestureRange72CqOWE(long j, CharSequence charSequence) {
        int iM2217getStartimpl = TextRange.m2217getStartimpl(j);
        int iM2212getEndimpl = TextRange.m2212getEndimpl(j);
        int iCodePointBefore = iM2217getStartimpl > 0 ? Character.codePointBefore(charSequence, iM2217getStartimpl) : 10;
        int iCodePointAt = iM2212getEndimpl < charSequence.length() ? Character.codePointAt(charSequence, iM2212getEndimpl) : 10;
        if (isWhitespaceExceptNewline(iCodePointBefore) && (isWhitespace(iCodePointAt) || isPunctuation(iCodePointAt))) {
            do {
                iM2217getStartimpl -= Character.charCount(iCodePointBefore);
                if (iM2217getStartimpl == 0) {
                    break;
                }
                iCodePointBefore = Character.codePointBefore(charSequence, iM2217getStartimpl);
            } while (isWhitespaceExceptNewline(iCodePointBefore));
            return TextRangeKt.TextRange(iM2217getStartimpl, iM2212getEndimpl);
        }
        if (!isWhitespaceExceptNewline(iCodePointAt)) {
            return j;
        }
        if (!isWhitespace(iCodePointBefore) && !isPunctuation(iCodePointBefore)) {
            return j;
        }
        do {
            iM2212getEndimpl += Character.charCount(iCodePointAt);
            if (iM2212getEndimpl == charSequence.length()) {
                break;
            }
            iCodePointAt = Character.codePointAt(charSequence, iM2212getEndimpl);
        } while (isWhitespaceExceptNewline(iCodePointAt));
        return TextRangeKt.TextRange(iM2217getStartimpl, iM2212getEndimpl);
    }

    private static final boolean isNewline(int i) {
        int type = Character.getType(i);
        return type == 14 || type == 13 || i == 10;
    }

    private static final boolean isWhitespace(int i) {
        return Character.isWhitespace(i) || i == 160;
    }

    private static final boolean isWhitespaceExceptNewline(int i) {
        return isWhitespace(i) && !isNewline(i);
    }

    private static final boolean isPunctuation(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toOffset(PointF pointF) {
        return OffsetKt.Offset(pointF.x, pointF.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m592getRangeForScreenRectOH9lIzo(TextLayoutState textLayoutState, Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m594getRangeForScreenRectsO048IG0(TextLayoutState textLayoutState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long jM592getRangeForScreenRectOH9lIzo = m592getRangeForScreenRectOH9lIzo(textLayoutState, rect, i, textInclusionStrategy);
        if (TextRange.m2211getCollapsedimpl(jM592getRangeForScreenRectOH9lIzo)) {
            return TextRange.Companion.m2222getZerod9O1mEE();
        }
        long jM592getRangeForScreenRectOH9lIzo2 = m592getRangeForScreenRectOH9lIzo(textLayoutState, rect2, i, textInclusionStrategy);
        return TextRange.m2211getCollapsedimpl(jM592getRangeForScreenRectOH9lIzo2) ? TextRange.Companion.m2222getZerod9O1mEE() : m584enclosurepWDy79M(jM592getRangeForScreenRectOH9lIzo, jM592getRangeForScreenRectOH9lIzo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m591getRangeForScreenRectOH9lIzo(LegacyTextFieldState legacyTextFieldState, Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult value;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        return m590getRangeForScreenRectO048IG0((layoutResult == null || (value = layoutResult.getValue()) == null) ? null : value.getMultiParagraph(), rect, legacyTextFieldState.getLayoutCoordinates(), i, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m593getRangeForScreenRectsO048IG0(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long jM591getRangeForScreenRectOH9lIzo = m591getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect, i, textInclusionStrategy);
        if (TextRange.m2211getCollapsedimpl(jM591getRangeForScreenRectOH9lIzo)) {
            return TextRange.Companion.m2222getZerod9O1mEE();
        }
        long jM591getRangeForScreenRectOH9lIzo2 = m591getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect2, i, textInclusionStrategy);
        return TextRange.m2211getCollapsedimpl(jM591getRangeForScreenRectOH9lIzo2) ? TextRange.Companion.m2222getZerod9O1mEE() : m584enclosurepWDy79M(jM591getRangeForScreenRectOH9lIzo, jM591getRangeForScreenRectOH9lIzo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long rangeOfWhitespaces(CharSequence charSequence, int i) {
        int iCharCount = i;
        while (iCharCount > 0) {
            int iCodePointBefore = CodepointHelpers_jvmKt.codePointBefore(charSequence, iCharCount);
            if (!isWhitespace(iCodePointBefore)) {
                break;
            }
            iCharCount -= Character.charCount(iCodePointBefore);
        }
        while (i < charSequence.length()) {
            int iCodePointAt = CodepointHelpers_jvmKt.codePointAt(charSequence, i);
            if (!isWhitespace(iCodePointAt)) {
                break;
            }
            i += CodepointHelpers_jvmKt.charCount(iCodePointAt);
        }
        return TextRangeKt.TextRange(iCharCount, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m587getOffsetForHandwritingGestured4ec7I(TextLayoutState textLayoutState, long j, ViewConfiguration viewConfiguration) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m586getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState legacyTextFieldState, long j, ViewConfiguration viewConfiguration) {
        TextLayoutResult value;
        MultiParagraph multiParagraph;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult == null || (value = layoutResult.getValue()) == null || (multiParagraph = value.getMultiParagraph()) == null) {
            return -1;
        }
        return m588getOffsetForHandwritingGestureubNVwUQ(multiParagraph, j, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBiDiBoundary(TextLayoutResult textLayoutResult, int i) {
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        if (i == textLayoutResult.getLineStart(lineForOffset) || i == TextLayoutResult.getLineEnd$default(textLayoutResult, lineForOffset, false, 2, null)) {
            return textLayoutResult.getParagraphDirection(i) != textLayoutResult.getBidiRunDirection(i);
        }
        return textLayoutResult.getBidiRunDirection(i) != textLayoutResult.getBidiRunDirection(i - 1);
    }

    /* JADX INFO: renamed from: getRangeForScreenRect-O048IG0, reason: not valid java name */
    private static final long m590getRangeForScreenRectO048IG0(MultiParagraph multiParagraph, Rect rect, LayoutCoordinates layoutCoordinates, int i, TextInclusionStrategy textInclusionStrategy) {
        if (multiParagraph == null || layoutCoordinates == null) {
            return TextRange.Companion.m2222getZerod9O1mEE();
        }
        return multiParagraph.m2151getRangeForRect86BmAI(rect.m1245translatek4lQ0M(layoutCoordinates.mo1850screenToLocalMKHz9U(Offset.Companion.m1235getZeroF1C5BW0())), i, textInclusionStrategy);
    }

    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-ubNVwUQ, reason: not valid java name */
    private static final int m588getOffsetForHandwritingGestureubNVwUQ(MultiParagraph multiParagraph, long j, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        long jMo1850screenToLocalMKHz9U;
        int iM585getLineForHandwritingGestured4ec7I;
        if (layoutCoordinates == null || (iM585getLineForHandwritingGestured4ec7I = m585getLineForHandwritingGestured4ec7I(multiParagraph, (jMo1850screenToLocalMKHz9U = layoutCoordinates.mo1850screenToLocalMKHz9U(j)), viewConfiguration)) == -1) {
            return -1;
        }
        return multiParagraph.m2150getOffsetForPositionk4lQ0M(Offset.m1217copydBAh8RU$default(jMo1850screenToLocalMKHz9U, 0.0f, (multiParagraph.getLineTop(iM585getLineForHandwritingGestured4ec7I) + multiParagraph.getLineBottom(iM585getLineForHandwritingGestured4ec7I)) / 2.0f, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForRemoveSpaceGesture-5iVPX68, reason: not valid java name */
    public static final long m589getRangeForRemoveSpaceGesture5iVPX68(TextLayoutResult textLayoutResult, long j, long j2, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        if (textLayoutResult == null || layoutCoordinates == null) {
            return TextRange.Companion.m2222getZerod9O1mEE();
        }
        long jMo1850screenToLocalMKHz9U = layoutCoordinates.mo1850screenToLocalMKHz9U(j);
        long jMo1850screenToLocalMKHz9U2 = layoutCoordinates.mo1850screenToLocalMKHz9U(j2);
        int iM585getLineForHandwritingGestured4ec7I = m585getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), jMo1850screenToLocalMKHz9U, viewConfiguration);
        int iM585getLineForHandwritingGestured4ec7I2 = m585getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), jMo1850screenToLocalMKHz9U2, viewConfiguration);
        if (iM585getLineForHandwritingGestured4ec7I != -1) {
            if (iM585getLineForHandwritingGestured4ec7I2 != -1) {
                iM585getLineForHandwritingGestured4ec7I = Math.min(iM585getLineForHandwritingGestured4ec7I, iM585getLineForHandwritingGestured4ec7I2);
            }
            iM585getLineForHandwritingGestured4ec7I2 = iM585getLineForHandwritingGestured4ec7I;
        } else if (iM585getLineForHandwritingGestured4ec7I2 == -1) {
            return TextRange.Companion.m2222getZerod9O1mEE();
        }
        float lineTop = (textLayoutResult.getLineTop(iM585getLineForHandwritingGestured4ec7I2) + textLayoutResult.getLineBottom(iM585getLineForHandwritingGestured4ec7I2)) / 2;
        return textLayoutResult.getMultiParagraph().m2151getRangeForRect86BmAI(new Rect(Math.min(Offset.m1223getXimpl(jMo1850screenToLocalMKHz9U), Offset.m1223getXimpl(jMo1850screenToLocalMKHz9U2)), lineTop - 0.1f, Math.max(Offset.m1223getXimpl(jMo1850screenToLocalMKHz9U), Offset.m1223getXimpl(jMo1850screenToLocalMKHz9U2)), lineTop + 0.1f), TextGranularity.Companion.m2196getCharacterDRrd7Zo(), TextInclusionStrategy.Companion.getAnyOverlap());
    }

    /* JADX INFO: renamed from: getLineForHandwritingGesture-d-4ec7I, reason: not valid java name */
    private static final int m585getLineForHandwritingGestured4ec7I(MultiParagraph multiParagraph, long j, ViewConfiguration viewConfiguration) {
        float handwritingGestureLineMargin = viewConfiguration != null ? viewConfiguration.getHandwritingGestureLineMargin() : 0.0f;
        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition(Offset.m1224getYimpl(j));
        if (Offset.m1224getYimpl(j) < multiParagraph.getLineTop(lineForVerticalPosition) - handwritingGestureLineMargin || Offset.m1224getYimpl(j) > multiParagraph.getLineBottom(lineForVerticalPosition) + handwritingGestureLineMargin || Offset.m1223getXimpl(j) < (-handwritingGestureLineMargin) || Offset.m1223getXimpl(j) > multiParagraph.getWidth() + handwritingGestureLineMargin) {
            return -1;
        }
        return lineForVerticalPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditCommand compoundEditCommand(final EditCommand... editCommandArr) {
        return new EditCommand() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.compoundEditCommand.1
            @Override // androidx.compose.ui.text.input.EditCommand
            public void applyTo(EditingBuffer editingBuffer) {
                for (EditCommand editCommand : editCommandArr) {
                    editCommand.applyTo(editingBuffer);
                }
            }
        };
    }

    /* JADX INFO: renamed from: enclosure-pWDy79M, reason: not valid java name */
    private static final long m584enclosurepWDy79M(long j, long j2) {
        return TextRangeKt.TextRange(Math.min(TextRange.m2217getStartimpl(j), TextRange.m2217getStartimpl(j)), Math.max(TextRange.m2212getEndimpl(j2), TextRange.m2212getEndimpl(j2)));
    }
}
