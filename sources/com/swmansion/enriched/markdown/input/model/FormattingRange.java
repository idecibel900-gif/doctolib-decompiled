package com.swmansion.enriched.markdown.input.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FormattingRange implements MutableRangeBounds {
    private int end;
    private int start;
    private final StyleType type;
    private String url;

    public FormattingRange(StyleType type, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.start = i;
        this.end = i2;
        this.url = str;
    }

    public /* synthetic */ FormattingRange(StyleType styleType, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(styleType, i, i2, (i3 & 8) != 0 ? null : str);
    }

    public final StyleType getType() {
        return this.type;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public int getStart() {
        return this.start;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public void setStart(int i) {
        this.start = i;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public int getEnd() {
        return this.end;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public void setEnd(int i) {
        this.end = i;
    }

    public final String getUrl() {
        return this.url;
    }
}
