package com.swmansion.enriched.markdown.input.styles;

import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface BlockHandler {

    public static final class DefaultImpls {
        public static boolean getContinuesOnNewline(BlockHandler blockHandler) {
            return false;
        }
    }

    List createSpans(BlockRange blockRange, InputFormatterStyle inputFormatterStyle);

    boolean getContinuesOnNewline();

    String markdownLinePrefix(BlockRange blockRange);

    List spanClasses();
}
