package com.swmansion.enriched.markdown.utils.common;

import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import com.amazon.device.iap.internal.c.b;
import com.swmansion.enriched.markdown.styles.CodeBlockStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/swmansion/enriched/markdown/utils/common/CodeBlockHighlighter;", "", "<init>", "()V", "nativeHighlightCode", "", ResponseTypeValues.CODE, "", "language", "highlight", "", "target", "Landroid/text/Spannable;", "style", "Lcom/swmansion/enriched/markdown/styles/CodeBlockStyle;", b.as, "", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockHighlighter {
    public static final CodeBlockHighlighter INSTANCE = new CodeBlockHighlighter();

    private final native int[] nativeHighlightCode(String code, String language);

    private CodeBlockHighlighter() {
    }

    static {
        try {
            System.loadLibrary("react_codegen_EnrichedMarkdownTextSpec");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static /* synthetic */ void highlight$default(CodeBlockHighlighter codeBlockHighlighter, Spannable spannable, String str, String str2, CodeBlockStyle codeBlockStyle, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            i = 0;
        }
        codeBlockHighlighter.highlight(spannable, str, str2, codeBlockStyle, i);
    }

    public final void highlight(Spannable target, String code, String language, CodeBlockStyle style, int offset) {
        int[] iArrNativeHighlightCode;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(style, "style");
        if (language == null) {
            language = "";
        }
        try {
            iArrNativeHighlightCode = nativeHighlightCode(code, language);
        } catch (UnsatisfiedLinkError unused) {
            iArrNativeHighlightCode = null;
        }
        if (iArrNativeHighlightCode == null) {
            return;
        }
        List syntaxColors = style.getSyntaxColors();
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 >= iArrNativeHighlightCode.length) {
                return;
            }
            int i3 = iArrNativeHighlightCode[i] + offset;
            int i4 = iArrNativeHighlightCode[i + 1] + offset;
            HighlightTokenType highlightTokenType = (HighlightTokenType) CollectionsKt.getOrNull(HighlightTokenType.getEntries(), iArrNativeHighlightCode[i2]);
            if (highlightTokenType != null && highlightTokenType.ordinal() < syntaxColors.size() && iArrNativeHighlightCode[i] >= 0 && i4 > i3 && i4 <= target.length()) {
                target.setSpan(new ForegroundColorSpan(((Number) syntaxColors.get(highlightTokenType.ordinal())).intValue()), i3, i4, 33);
            }
            i += 3;
        }
    }
}
