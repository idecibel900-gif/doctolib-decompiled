package com.swmansion.enriched.markdown.input.styles;

import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.spans.InputBulletSpan;
import com.swmansion.enriched.markdown.input.spans.InputListItemSpacingSpan;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class UnorderedListBlockHandler implements BlockHandler {
    private final BlockType blockType = BlockType.UNORDERED_LIST_ITEM;
    private final boolean continuesOnNewline = true;
    private final float density;

    public UnorderedListBlockHandler(float f) {
        this.density = f;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public boolean getContinuesOnNewline() {
        return this.continuesOnNewline;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public List createSpans(BlockRange blockRange, InputFormatterStyle style) {
        Intrinsics.checkNotNullParameter(blockRange, "blockRange");
        Intrinsics.checkNotNullParameter(style, "style");
        List listMutableListOf = CollectionsKt.mutableListOf(new InputBulletSpan(blockRange.getLevel(), this.density));
        int listItemSpacing = (int) (style.getListItemSpacing() * this.density);
        if (listItemSpacing > 0) {
            listMutableListOf.add(new InputListItemSpacingSpan(listItemSpacing));
        }
        return listMutableListOf;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public List spanClasses() {
        return CollectionsKt.listOf((Object[]) new Class[]{InputBulletSpan.class, InputListItemSpacingSpan.class});
    }

    @Override // com.swmansion.enriched.markdown.input.styles.BlockHandler
    public String markdownLinePrefix(BlockRange blockRange) {
        Intrinsics.checkNotNullParameter(blockRange, "blockRange");
        return StringsKt.repeat("   ", RangesKt.coerceAtLeast(blockRange.getLevel(), 0)) + "- ";
    }
}
