package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m2130toLayoutAlignaXe7zB0(int i) {
        TextAlign.Companion companion = TextAlign.Companion;
        if (TextAlign.m2477equalsimpl0(i, companion.m2484getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m2477equalsimpl0(i, companion.m2485getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m2477equalsimpl0(i, companion.m2481getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m2477equalsimpl0(i, companion.m2486getStarte0LSkKk()) && TextAlign.m2477equalsimpl0(i, companion.m2482getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m2132toLayoutHyphenationFrequency3fSNIE(int i) {
        Hyphens.Companion companion = Hyphens.Companion;
        if (Hyphens.m2421equalsimpl0(i, companion.m2425getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m2421equalsimpl0(i, companion.m2426getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m2131toLayoutBreakStrategyxImikfE(int i) {
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.Companion;
        if (LineBreak.Strategy.m2441equalsimpl0(i, companion.m2445getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m2441equalsimpl0(i, companion.m2444getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m2441equalsimpl0(i, companion.m2443getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m2133toLayoutLineBreakStylehpcqdu8(int i) {
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.Companion;
        if (LineBreak.Strictness.m2447equalsimpl0(i, companion.m2449getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m2447equalsimpl0(i, companion.m2450getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m2447equalsimpl0(i, companion.m2451getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m2447equalsimpl0(i, companion.m2452getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m2134toLayoutLineBreakWordStylewPN0Rpw(int i) {
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.Companion;
        return (!LineBreak.WordBreak.m2454equalsimpl0(i, companion.m2456getDefaultjp8hJ3c()) && LineBreak.WordBreak.m2454equalsimpl0(i, companion.m2457getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (z && !TextUnit.m2619equalsimpl0(textStyle.m2237getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) && !TextUnit.m2619equalsimpl0(textStyle.m2237getLetterSpacingXSAIIZE(), TextUnit.Companion.m2626getUnspecifiedXSAIIZE())) {
            int iM2240getTextAligne0LSkKk = textStyle.m2240getTextAligne0LSkKk();
            TextAlign.Companion companion = TextAlign.Companion;
            if (!TextAlign.m2477equalsimpl0(iM2240getTextAligne0LSkKk, companion.m2487getUnspecifiede0LSkKk()) && !TextAlign.m2477equalsimpl0(textStyle.m2240getTextAligne0LSkKk(), companion.m2486getStarte0LSkKk()) && !TextAlign.m2477equalsimpl0(textStyle.m2240getTextAligne0LSkKk(), companion.m2483getJustifye0LSkKk())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m2135toLayoutTextGranularityduNsdkg(int i) {
        TextGranularity.Companion companion = TextGranularity.Companion;
        return (!TextGranularity.m2195equalsimpl0(i, companion.m2196getCharacterDRrd7Zo()) && TextGranularity.m2195equalsimpl0(i, companion.m2197getWordDRrd7Zo())) ? 1 : 0;
    }
}
