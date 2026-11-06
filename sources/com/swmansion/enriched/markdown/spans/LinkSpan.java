package com.swmansion.enriched.markdown.spans;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.swmansion.enriched.markdown.EnrichedMarkdownText;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.renderer.SpanStyleCache;
import com.swmansion.enriched.markdown.styles.LinkVariantEntry;
import com.swmansion.enriched.markdown.utils.text.extensions.TextPaintExtensionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkSpan extends ClickableSpan {
    private final BlockStyle blockStyle;
    private final Context context;
    private volatile boolean longPressTriggered;
    private final Function1 onLinkLongPress;
    private final Function1 onLinkPress;
    private final SpanStyleCache styleCache;
    private final String url;

    public final String getUrl() {
        return this.url;
    }

    public LinkSpan(String url, Function1 function1, Function1 function2, SpanStyleCache styleCache, BlockStyle blockStyle, Context context) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(styleCache, "styleCache");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        this.url = url;
        this.onLinkPress = function1;
        this.onLinkLongPress = function2;
        this.styleCache = styleCache;
        this.blockStyle = blockStyle;
        this.context = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        if (this.longPressTriggered) {
            this.longPressTriggered = false;
            return;
        }
        Function1 function1 = this.onLinkPress;
        if (function1 != null) {
            function1.invoke(this.url);
            return;
        }
        EnrichedMarkdownText enrichedMarkdownText = widget instanceof EnrichedMarkdownText ? (EnrichedMarkdownText) widget : null;
        if (enrichedMarkdownText != null) {
            enrichedMarkdownText.emitOnLinkPress(this.url);
        }
    }

    public final boolean onLongClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.longPressTriggered = true;
        EnrichedMarkdownText enrichedMarkdownText = widget instanceof EnrichedMarkdownText ? (EnrichedMarkdownText) widget : null;
        if (enrichedMarkdownText != null) {
            enrichedMarkdownText.emitOnLinkLongPress(this.url);
        }
        Function1 function1 = this.onLinkLongPress;
        if (function1 != null) {
            function1.invoke(this.url);
        }
        return true;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        super.updateDrawState(textPaint);
        textPaint.setTextSize(this.blockStyle.getFontSize());
        LinkVariantEntry linkVariantEntryResolvedVariantForUrl = this.styleCache.resolvedVariantForUrl(this.url);
        String linkFontFamily = this.styleCache.getLinkFontFamily();
        if (linkFontFamily.length() > 0) {
            TextPaintExtensionsKt.applyBlockStyleFont(textPaint, BlockStyle.copy$default(this.blockStyle, 0.0f, linkFontFamily, null, 0, 13, null), this.context);
        } else {
            TextPaintExtensionsKt.applyBlockStyleFont(textPaint, this.blockStyle, this.context);
        }
        textPaint.setColor(linkVariantEntryResolvedVariantForUrl != null ? linkVariantEntryResolvedVariantForUrl.getColor() : this.styleCache.getLinkColor());
        textPaint.setUnderlineText(linkVariantEntryResolvedVariantForUrl != null ? linkVariantEntryResolvedVariantForUrl.getUnderline() : this.styleCache.getLinkUnderline());
        int backgroundColor = linkVariantEntryResolvedVariantForUrl != null ? linkVariantEntryResolvedVariantForUrl.getBackgroundColor() : this.styleCache.getLinkBackgroundColor();
        if (Color.alpha(backgroundColor) > 0) {
            textPaint.bgColor = backgroundColor;
        }
    }
}
