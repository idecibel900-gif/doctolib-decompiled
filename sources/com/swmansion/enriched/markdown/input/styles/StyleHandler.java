package com.swmansion.enriched.markdown.input.styles;

import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.model.StyleType;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface StyleHandler {
    List createSpans(FormattingRange formattingRange, InputFormatterStyle inputFormatterStyle);

    StyleMergingConfig getMergingConfig();

    StyleType getStyleType();

    List spanClasses();
}
