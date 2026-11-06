package com.swmansion.enriched.markdown.input.styles;

import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.spans.InputHeadingSpan;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class HeadingBlockHandler implements BlockHandler {
    private final BlockType blockType = BlockType.HEADING_1;

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public boolean getContinuesOnNewline() {
        return BlockHandler.DefaultImpls.getContinuesOnNewline(this);
    }

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public List createSpans(BlockRange blockRange, InputFormatterStyle style) {
        Intrinsics.checkNotNullParameter(blockRange, "blockRange");
        Intrinsics.checkNotNullParameter(style, "style");
        return CollectionsKt.listOf(new InputHeadingSpan(blockRange.getLevel(), style));
    }

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public List spanClasses() {
        return CollectionsKt.listOf(InputHeadingSpan.class);
    }

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public String markdownLinePrefix(BlockRange blockRange) {
        Intrinsics.checkNotNullParameter(blockRange, "blockRange");
        return StringsKt.repeat("#", RangesKt.coerceIn(blockRange.getLevel(), 1, 6)) + " ";
    }
}
