package com.swmansion.enriched.markdown.input.styles;

import android.text.style.CharacterStyle;
import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.model.StyleType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SpoilerStyleHandler implements StyleHandler {
    private final StyleType styleType = StyleType.SPOILER;
    private final StyleMergingConfig mergingConfig = new StyleMergingConfig(null, null, 3, null);

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public StyleType getStyleType() {
        return this.styleType;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public StyleMergingConfig getMergingConfig() {
        return this.mergingConfig;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public List createSpans(FormattingRange range, InputFormatterStyle style) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(style, "style");
        return CollectionsKt.listOf((Object[]) new CharacterStyle[]{new MarkdownSpoilerColorSpan(style.getSpoilerColor()), new MarkdownSpoilerBackgroundSpan(style.getSpoilerBackgroundColor())});
    }

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public List spanClasses() {
        return CollectionsKt.listOf((Object[]) new Class[]{MarkdownSpoilerColorSpan.class, MarkdownSpoilerBackgroundSpan.class});
    }
}
