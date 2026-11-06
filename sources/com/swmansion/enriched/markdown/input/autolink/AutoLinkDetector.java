package com.swmansion.enriched.markdown.input.autolink;

import android.text.Spannable;
import com.swmansion.enriched.markdown.input.detection.TextDetector;
import com.swmansion.enriched.markdown.input.detection.WordResult;
import com.swmansion.enriched.markdown.input.formatting.FormattingStore;
import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.model.StyleType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoLinkDetector implements TextDetector {
    public static final Companion Companion = new Companion(null);
    private static final Pattern DEFAULT_PATTERN;
    private Pattern compiledPattern;
    private LinkRegexConfig config;
    private final FormattingStore formattingStore;
    private Function4 onLinkDetected;
    private InputFormatterStyle style;

    public AutoLinkDetector(FormattingStore formattingStore) {
        Intrinsics.checkNotNullParameter(formattingStore, "formattingStore");
        this.formattingStore = formattingStore;
    }

    public final void setStyle(InputFormatterStyle inputFormatterStyle) {
        this.style = inputFormatterStyle;
    }

    public final void setOnLinkDetected(Function4 function4) {
        this.onLinkDetected = function4;
    }

    public final void setRegexConfig(LinkRegexConfig newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (Intrinsics.areEqual(newConfig, this.config)) {
            return;
        }
        this.config = newConfig;
        Pattern patternCompile = null;
        this.compiledPattern = null;
        if (newConfig.isDefault() || newConfig.isDisabled() || newConfig.getPattern().length() <= 0) {
            return;
        }
        int i = newConfig.getCaseInsensitive() ? 2 : 0;
        if (newConfig.getDotAll()) {
            i |= 32;
        }
        try {
            patternCompile = Pattern.compile(newConfig.getPattern(), i);
        } catch (Exception unused) {
        }
        this.compiledPattern = patternCompile;
    }

    @Override // com.swmansion.enriched.markdown.input.detection.TextDetector
    public void processWord(Spannable spannable, WordResult wordResult) {
        Function4 function4;
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(wordResult, "wordResult");
        String strDetectNewLinkInWord = detectNewLinkInWord(spannable, wordResult);
        if (strDetectNewLinkInWord == null || (function4 = this.onLinkDetected) == null) {
            return;
        }
        function4.invoke(wordResult.getWord(), strDetectNewLinkInWord, Integer.valueOf(wordResult.getStart()), Integer.valueOf(wordResult.getEnd()));
    }

    @Override // com.swmansion.enriched.markdown.input.detection.TextDetector
    public List transientFormattingRanges(Spannable spannable) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        AutoDetectedLinkMarkerSpan[] autoDetectedLinkMarkerSpanArr = (AutoDetectedLinkMarkerSpan[]) spannable.getSpans(0, spannable.length(), AutoDetectedLinkMarkerSpan.class);
        Intrinsics.checkNotNull(autoDetectedLinkMarkerSpanArr);
        ArrayList arrayList = new ArrayList(autoDetectedLinkMarkerSpanArr.length);
        for (AutoDetectedLinkMarkerSpan autoDetectedLinkMarkerSpan : autoDetectedLinkMarkerSpanArr) {
            arrayList.add(new FormattingRange(StyleType.LINK, spannable.getSpanStart(autoDetectedLinkMarkerSpan), spannable.getSpanEnd(autoDetectedLinkMarkerSpan), autoDetectedLinkMarkerSpan.getUrl()));
        }
        return arrayList;
    }

    public final void clearAutoLinkInRange(Spannable spannable, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        removeAutoLinkSpans(spannable, i, i2);
    }

    private final String detectNewLinkInWord(Spannable spannable, WordResult wordResult) {
        Object obj;
        LinkRegexConfig linkRegexConfig = this.config;
        if (linkRegexConfig != null && linkRegexConfig.isDisabled()) {
            return null;
        }
        String strComponent1 = wordResult.component1();
        int iComponent2 = wordResult.component2();
        int iComponent3 = wordResult.component3();
        if (this.formattingStore.rangeOfType(StyleType.LINK, iComponent2) != null) {
            removeAutoLinkSpans(spannable, iComponent2, iComponent3);
            return null;
        }
        String strMatchWord = matchWord(strComponent1);
        Object[] spans = spannable.getSpans(iComponent2, iComponent3, AutoDetectedLinkMarkerSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        int length = spans.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                obj = null;
                break;
            }
            obj = spans[i];
            AutoDetectedLinkMarkerSpan autoDetectedLinkMarkerSpan = (AutoDetectedLinkMarkerSpan) obj;
            if (spannable.getSpanStart(autoDetectedLinkMarkerSpan) == iComponent2 && spannable.getSpanEnd(autoDetectedLinkMarkerSpan) == iComponent3) {
                break;
            }
            i++;
        }
        AutoDetectedLinkMarkerSpan autoDetectedLinkMarkerSpan2 = (AutoDetectedLinkMarkerSpan) obj;
        if (strMatchWord == null) {
            if (autoDetectedLinkMarkerSpan2 != null) {
                removeAutoLinkSpans(spannable, iComponent2, iComponent3);
            }
            return null;
        }
        if (Intrinsics.areEqual(autoDetectedLinkMarkerSpan2 != null ? autoDetectedLinkMarkerSpan2.getUrl() : null, strMatchWord)) {
            return null;
        }
        removeAutoLinkSpans(spannable, iComponent2, iComponent3);
        spannable.setSpan(new AutoDetectedLinkMarkerSpan(strMatchWord), iComponent2, iComponent3, 33);
        InputFormatterStyle inputFormatterStyle = this.style;
        if (inputFormatterStyle != null) {
            applyVisualStyling(spannable, iComponent2, iComponent3, inputFormatterStyle);
        }
        return strMatchWord;
    }

    private final String matchWord(String str) {
        if (str.length() == 0) {
            return null;
        }
        Pattern pattern = this.compiledPattern;
        if (pattern != null) {
            if (pattern.matcher(str).matches()) {
                return Companion.normalizeUrl(str);
            }
            return null;
        }
        if (DEFAULT_PATTERN.matcher(str).matches()) {
            return Companion.normalizeUrl(str);
        }
        return null;
    }

    private final void removeAutoLinkSpans(Spannable spannable, int i, int i2) {
        Iterator it = ArrayIteratorKt.iterator(spannable.getSpans(i, i2, AutoDetectedLinkMarkerSpan.class));
        while (it.hasNext()) {
            spannable.removeSpan((AutoDetectedLinkMarkerSpan) it.next());
        }
        Iterator it2 = ArrayIteratorKt.iterator(spannable.getSpans(i, i2, AutoDetectedLinkColorSpan.class));
        while (it2.hasNext()) {
            spannable.removeSpan((AutoDetectedLinkColorSpan) it2.next());
        }
        Iterator it3 = ArrayIteratorKt.iterator(spannable.getSpans(i, i2, AutoDetectedLinkUnderlineSpan.class));
        while (it3.hasNext()) {
            spannable.removeSpan((AutoDetectedLinkUnderlineSpan) it3.next());
        }
    }

    private final void applyVisualStyling(Spannable spannable, int i, int i2, InputFormatterStyle inputFormatterStyle) {
        spannable.setSpan(new AutoDetectedLinkColorSpan(inputFormatterStyle.getLinkColor()), i, i2, 33);
        if (inputFormatterStyle.getLinkUnderline()) {
            spannable.setSpan(new AutoDetectedLinkUnderlineSpan(), i, i2, 33);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String normalizeUrl(String str) {
            if (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
                return str;
            }
            return "https://" + str;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("(?:https?://[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-z]{2,6}\\b[-a-zA-Z0-9@:%_+.~#?&//=]*|www\\.[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-z]{2,6}\\b[-a-zA-Z0-9@:%_+.~#?&//=]*|[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-z]{2,6}\\b[-a-zA-Z0-9@:%_+.~#?&//=]*)", 2);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        DEFAULT_PATTERN = patternCompile;
    }
}
