package com.swmansion.enriched.markdown.styles;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.text.ReactTypefaceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
public final class StyleConfig {
    private final AssetManager assetManager;
    private final Lazy blockquoteStyle$delegate;
    private final Lazy codeBlockStyle$delegate;
    private final Lazy codeStyle$delegate;
    private final Lazy emphasisStyle$delegate;
    private final Lazy headingStyles$delegate;
    private final Lazy headingTypefaces$delegate;
    private final Lazy highlightStyle$delegate;
    private Map imageRequestHeaders;
    private final Lazy imageStyle$delegate;
    private final Lazy inlineImageStyle$delegate;
    private final Lazy inlineMathStyle$delegate;
    private final Lazy linkStyle$delegate;
    private final Lazy linkVariants$delegate;
    private final Lazy listStyle$delegate;
    private final Lazy mathStyle$delegate;
    private final Lazy needsJustify$delegate;
    private final Lazy paragraphStyleDefault$delegate;
    private ParagraphStyle paragraphStyleOverride;
    private final Lazy spoilerStyle$delegate;
    private final Lazy strikethroughStyle$delegate;
    private final Lazy strongStyle$delegate;
    private final ReadableMap style;
    private final StyleParser styleParser;
    private final Lazy subscriptStyle$delegate;
    private final Lazy superscriptStyle$delegate;
    private final Lazy tableHeaderTypeface$delegate;
    private final Lazy tableStyle$delegate;
    private final Lazy tableTypeface$delegate;
    private final Lazy taskListStyle$delegate;
    private final Lazy thematicBreakStyle$delegate;
    private final Lazy underlineStyle$delegate;

    public StyleConfig(ReadableMap style, Context context, boolean z, float f) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(context, "context");
        this.style = style;
        this.styleParser = new StyleParser(context, z, f);
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        this.assetManager = assets;
        this.paragraphStyleDefault$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.paragraphStyleDefault_delegate$lambda$1(this.f$0);
            }
        });
        this.headingStyles$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.headingStyles_delegate$lambda$3(this.f$0);
            }
        });
        this.headingTypefaces$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.headingTypefaces_delegate$lambda$5(this.f$0);
            }
        });
        this.linkStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.linkStyle_delegate$lambda$7(this.f$0);
            }
        });
        this.linkVariants$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.linkVariants_delegate$lambda$10(this.f$0);
            }
        });
        this.strongStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.strongStyle_delegate$lambda$12(this.f$0);
            }
        });
        this.emphasisStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.emphasisStyle_delegate$lambda$14(this.f$0);
            }
        });
        this.strikethroughStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.strikethroughStyle_delegate$lambda$16(this.f$0);
            }
        });
        this.underlineStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.underlineStyle_delegate$lambda$18(this.f$0);
            }
        });
        this.codeStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.codeStyle_delegate$lambda$20(this.f$0);
            }
        });
        this.imageStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.imageStyle_delegate$lambda$22(this.f$0);
            }
        });
        this.imageRequestHeaders = MapsKt.emptyMap();
        this.inlineImageStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.inlineImageStyle_delegate$lambda$24(this.f$0);
            }
        });
        this.blockquoteStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.blockquoteStyle_delegate$lambda$26(this.f$0);
            }
        });
        this.listStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.listStyle_delegate$lambda$28(this.f$0);
            }
        });
        this.codeBlockStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.codeBlockStyle_delegate$lambda$30(this.f$0);
            }
        });
        this.thematicBreakStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.thematicBreakStyle_delegate$lambda$32(this.f$0);
            }
        });
        this.tableStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.tableStyle_delegate$lambda$34(this.f$0);
            }
        });
        this.taskListStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.taskListStyle_delegate$lambda$36(this.f$0);
            }
        });
        this.mathStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.mathStyle_delegate$lambda$38(this.f$0);
            }
        });
        this.inlineMathStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.inlineMathStyle_delegate$lambda$40(this.f$0);
            }
        });
        this.spoilerStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.spoilerStyle_delegate$lambda$42(this.f$0);
            }
        });
        this.superscriptStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.superscriptStyle_delegate$lambda$44(this.f$0);
            }
        });
        this.subscriptStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.subscriptStyle_delegate$lambda$46(this.f$0);
            }
        });
        this.highlightStyle$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.highlightStyle_delegate$lambda$48(this.f$0);
            }
        });
        this.tableTypeface$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.tableTypeface_delegate$lambda$50(this.f$0);
            }
        });
        this.tableHeaderTypeface$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StyleConfig.tableHeaderTypeface_delegate$lambda$53(this.f$0);
            }
        });
        this.needsJustify$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.styles.StyleConfig$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StyleConfig.needsJustify_delegate$lambda$55(this.f$0));
            }
        });
    }

    public final AssetManager getAssetManager$react_native_enriched_markdown_release() {
        return this.assetManager;
    }

    private final AssetManager getAssets() {
        return this.assetManager;
    }

    public final ParagraphStyle getParagraphStyle() {
        ParagraphStyle paragraphStyle = this.paragraphStyleOverride;
        return paragraphStyle == null ? getParagraphStyleDefault() : paragraphStyle;
    }

    private final ParagraphStyle getParagraphStyleDefault() {
        return (ParagraphStyle) this.paragraphStyleDefault$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParagraphStyle paragraphStyleDefault_delegate$lambda$1(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("paragraph");
        if (map == null) {
            throw new IllegalArgumentException("Paragraph style not found. JS should always provide defaults.");
        }
        return ParagraphStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final Object withParagraphOverride(ParagraphStyle override, Function0 block) {
        Intrinsics.checkNotNullParameter(override, "override");
        Intrinsics.checkNotNullParameter(block, "block");
        this.paragraphStyleOverride = override;
        try {
            return block.invoke();
        } finally {
            this.paragraphStyleOverride = null;
        }
    }

    public final ParagraphStyle tableCellParagraphStyle(TableStyle tableStyle, boolean z) {
        Intrinsics.checkNotNullParameter(tableStyle, "tableStyle");
        return ParagraphStyle.copy$default(getParagraphStyleDefault(), tableStyle.getFontSize(), (!z || tableStyle.getHeaderFontFamily().length() <= 0) ? tableStyle.getFontFamily() : tableStyle.getHeaderFontFamily(), z ? "bold" : tableStyle.getFontWeight(), z ? tableStyle.getHeaderTextColor() : tableStyle.getColor(), 0.0f, 0.0f, tableStyle.getLineHeight(), null, 128, null);
    }

    public final HeadingStyle[] getHeadingStyles() {
        return (HeadingStyle[]) this.headingStyles$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeadingStyle[] headingStyles_delegate$lambda$3(StyleConfig styleConfig) {
        HeadingStyle headingStyleFromReadableMap;
        HeadingStyle[] headingStyleArr = new HeadingStyle[7];
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                headingStyleFromReadableMap = null;
            } else {
                String str = "h" + i;
                ReadableMap map = styleConfig.style.getMap(str);
                if (map == null) {
                    throw new IllegalArgumentException(("Style for " + str + " not found. JS should always provide defaults.").toString());
                }
                headingStyleFromReadableMap = HeadingStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
            }
            headingStyleArr[i] = headingStyleFromReadableMap;
        }
        return headingStyleArr;
    }

    public final Typeface[] getHeadingTypefaces() {
        return (Typeface[]) this.headingTypefaces$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface[] headingTypefaces_delegate$lambda$5(StyleConfig styleConfig) {
        String fontFamily;
        Typeface[] typefaceArr = new Typeface[7];
        for (int i = 0; i < 7; i++) {
            Typeface typefaceApplyStyles = null;
            if (i != 0) {
                HeadingStyle headingStyle = styleConfig.getHeadingStyles()[i];
                if (headingStyle == null || (fontFamily = headingStyle.getFontFamily()) == null || fontFamily.length() <= 0) {
                    fontFamily = null;
                }
                int fontWeight = ReactTypefaceUtils.parseFontWeight(headingStyle != null ? headingStyle.getFontWeight() : null);
                if (fontFamily != null) {
                    typefaceApplyStyles = ReactTypefaceUtils.applyStyles(ReactTypefaceUtils.applyStyles(null, -1, -1, fontFamily, styleConfig.getAssets()), -1, fontWeight, null, styleConfig.getAssets());
                }
            }
            typefaceArr[i] = typefaceApplyStyles;
        }
        return typefaceArr;
    }

    public final LinkStyle getLinkStyle() {
        return (LinkStyle) this.linkStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkStyle linkStyle_delegate$lambda$7(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("link");
        if (map == null) {
            throw new IllegalArgumentException("Link style not found. JS should always provide defaults.");
        }
        return LinkStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final List getLinkVariants() {
        return (List) this.linkVariants$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List linkVariants_delegate$lambda$10(StyleConfig styleConfig) {
        ReadableArray array = styleConfig.style.getArray("linkVariants");
        if (array == null) {
            return CollectionsKt.emptyList();
        }
        IntRange intRangeUntil = RangesKt.until(0, array.size());
        ArrayList arrayList = new ArrayList();
        Iterator it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ReadableMap map = array.getMap(((IntIterator) it).nextInt());
            LinkVariantEntry linkVariantEntryFromReadableMap = map != null ? LinkVariantEntry.Companion.fromReadableMap(map, styleConfig.styleParser) : null;
            if (linkVariantEntryFromReadableMap != null) {
                arrayList.add(linkVariantEntryFromReadableMap);
            }
        }
        return arrayList;
    }

    public final StrongStyle getStrongStyle() {
        return (StrongStyle) this.strongStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrongStyle strongStyle_delegate$lambda$12(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("strong");
        if (map == null) {
            throw new IllegalArgumentException("Strong style not found. JS should always provide defaults.");
        }
        return StrongStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final EmphasisStyle getEmphasisStyle() {
        return (EmphasisStyle) this.emphasisStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmphasisStyle emphasisStyle_delegate$lambda$14(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("em");
        if (map == null) {
            throw new IllegalArgumentException("Emphasis style not found. JS should always provide defaults.");
        }
        return EmphasisStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final StrikethroughStyle getStrikethroughStyle() {
        return (StrikethroughStyle) this.strikethroughStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrikethroughStyle strikethroughStyle_delegate$lambda$16(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("strikethrough");
        if (map == null) {
            throw new IllegalArgumentException("Strikethrough style not found. JS should always provide defaults.");
        }
        return StrikethroughStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final UnderlineStyle getUnderlineStyle() {
        return (UnderlineStyle) this.underlineStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnderlineStyle underlineStyle_delegate$lambda$18(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("underline");
        if (map == null) {
            throw new IllegalArgumentException("Underline style not found. JS should always provide defaults.");
        }
        return UnderlineStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final CodeStyle getCodeStyle() {
        return (CodeStyle) this.codeStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CodeStyle codeStyle_delegate$lambda$20(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap(ResponseTypeValues.CODE);
        if (map == null) {
            throw new IllegalArgumentException("Code style not found. JS should always provide defaults.");
        }
        return CodeStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final ImageStyle getImageStyle() {
        return (ImageStyle) this.imageStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageStyle imageStyle_delegate$lambda$22(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("image");
        if (map == null) {
            throw new IllegalArgumentException("Image style not found. JS should always provide defaults.");
        }
        return ImageStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final Map getImageRequestHeaders() {
        return this.imageRequestHeaders;
    }

    public final void setImageRequestHeaders(Map map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.imageRequestHeaders = map;
    }

    public final InlineImageStyle getInlineImageStyle() {
        return (InlineImageStyle) this.inlineImageStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InlineImageStyle inlineImageStyle_delegate$lambda$24(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("inlineImage");
        if (map == null) {
            throw new IllegalArgumentException("InlineImage style not found. JS should always provide defaults.");
        }
        return InlineImageStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final BlockquoteStyle getBlockquoteStyle() {
        return (BlockquoteStyle) this.blockquoteStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BlockquoteStyle blockquoteStyle_delegate$lambda$26(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("blockquote");
        if (map == null) {
            throw new IllegalArgumentException("Blockquote style not found. JS should always provide defaults.");
        }
        return BlockquoteStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final ListStyle getListStyle() {
        return (ListStyle) this.listStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ListStyle listStyle_delegate$lambda$28(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("list");
        if (map == null) {
            throw new IllegalArgumentException("List style not found. JS should always provide defaults.");
        }
        return ListStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final CodeBlockStyle getCodeBlockStyle() {
        return (CodeBlockStyle) this.codeBlockStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CodeBlockStyle codeBlockStyle_delegate$lambda$30(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("codeBlock");
        if (map == null) {
            throw new IllegalArgumentException("CodeBlock style not found. JS should always provide defaults.");
        }
        return CodeBlockStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final ThematicBreakStyle getThematicBreakStyle() {
        return (ThematicBreakStyle) this.thematicBreakStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThematicBreakStyle thematicBreakStyle_delegate$lambda$32(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("thematicBreak");
        if (map == null) {
            throw new IllegalArgumentException("ThematicBreak style not found. JS should always provide defaults.");
        }
        return ThematicBreakStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final TableStyle getTableStyle() {
        return (TableStyle) this.tableStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TableStyle tableStyle_delegate$lambda$34(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("table");
        if (map == null) {
            throw new IllegalArgumentException("Table style not found. JS should always provide defaults.");
        }
        return TableStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final TaskListStyle getTaskListStyle() {
        return (TaskListStyle) this.taskListStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskListStyle taskListStyle_delegate$lambda$36(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("taskList");
        if (map == null) {
            throw new IllegalArgumentException("TaskList style not found. JS should always provide defaults.");
        }
        return TaskListStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final MathStyle getMathStyle() {
        return (MathStyle) this.mathStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MathStyle mathStyle_delegate$lambda$38(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("math");
        if (map == null) {
            throw new IllegalArgumentException("Math style not found. JS should always provide defaults.");
        }
        return MathStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final InlineMathStyle getInlineMathStyle() {
        return (InlineMathStyle) this.inlineMathStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InlineMathStyle inlineMathStyle_delegate$lambda$40(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("inlineMath");
        if (map == null) {
            throw new IllegalArgumentException("InlineMath style not found. JS should always provide defaults.");
        }
        return InlineMathStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final SpoilerStyle getSpoilerStyle() {
        return (SpoilerStyle) this.spoilerStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SpoilerStyle spoilerStyle_delegate$lambda$42(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("spoiler");
        if (map == null) {
            throw new IllegalArgumentException("Spoiler style not found. JS should always provide defaults.");
        }
        return SpoilerStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final SuperscriptStyle getSuperscriptStyle() {
        return (SuperscriptStyle) this.superscriptStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperscriptStyle superscriptStyle_delegate$lambda$44(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("superscript");
        if (map == null) {
            throw new IllegalArgumentException("Superscript style not found. JS should always provide defaults.");
        }
        return SuperscriptStyle.Companion.fromReadableMap(map);
    }

    public final SubscriptStyle getSubscriptStyle() {
        return (SubscriptStyle) this.subscriptStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptStyle subscriptStyle_delegate$lambda$46(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("subscript");
        if (map == null) {
            throw new IllegalArgumentException("Subscript style not found. JS should always provide defaults.");
        }
        return SubscriptStyle.Companion.fromReadableMap(map);
    }

    public final HighlightStyle getHighlightStyle() {
        return (HighlightStyle) this.highlightStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HighlightStyle highlightStyle_delegate$lambda$48(StyleConfig styleConfig) {
        ReadableMap map = styleConfig.style.getMap("highlight");
        if (map == null) {
            throw new IllegalArgumentException("Highlight style not found. JS should always provide defaults.");
        }
        return HighlightStyle.Companion.fromReadableMap(map, styleConfig.styleParser);
    }

    public final Typeface getTableTypeface() {
        return (Typeface) this.tableTypeface$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface tableTypeface_delegate$lambda$50(StyleConfig styleConfig) {
        String fontFamily = styleConfig.getTableStyle().getFontFamily();
        if (fontFamily.length() <= 0) {
            fontFamily = null;
        }
        int fontWeight = ReactTypefaceUtils.parseFontWeight(styleConfig.getTableStyle().getFontWeight());
        if (fontFamily != null) {
            return ReactTypefaceUtils.applyStyles(null, -1, fontWeight, fontFamily, styleConfig.getAssets());
        }
        return null;
    }

    public final Typeface getTableHeaderTypeface() {
        return (Typeface) this.tableHeaderTypeface$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface tableHeaderTypeface_delegate$lambda$53(StyleConfig styleConfig) {
        String headerFontFamily = styleConfig.getTableStyle().getHeaderFontFamily();
        if (headerFontFamily.length() <= 0) {
            headerFontFamily = null;
        }
        String fontFamily = styleConfig.getTableStyle().getFontFamily();
        if (fontFamily.length() <= 0) {
            fontFamily = null;
        }
        if (headerFontFamily != null) {
            return ReactTypefaceUtils.applyStyles(null, -1, ReactTypefaceUtils.parseFontWeight(Constants.NORMAL), headerFontFamily, styleConfig.getAssets());
        }
        if (fontFamily != null) {
            return ReactTypefaceUtils.applyStyles(null, -1, ReactTypefaceUtils.parseFontWeight("bold"), fontFamily, styleConfig.getAssets());
        }
        return Typeface.DEFAULT_BOLD;
    }

    public final boolean getNeedsJustify() {
        return ((Boolean) this.needsJustify$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean needsJustify_delegate$lambda$55(StyleConfig styleConfig) {
        if (styleConfig.getParagraphStyle().getTextAlign().getNeedsJustify()) {
            return true;
        }
        List listFilterNotNull = ArraysKt.filterNotNull(styleConfig.getHeadingStyles());
        if ((listFilterNotNull instanceof Collection) && listFilterNotNull.isEmpty()) {
            return false;
        }
        Iterator it = listFilterNotNull.iterator();
        while (it.hasNext()) {
            if (((HeadingStyle) it.next()).getTextAlign().getNeedsJustify()) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StyleConfig)) {
            return false;
        }
        StyleConfig styleConfig = (StyleConfig) obj;
        return Intrinsics.areEqual(getParagraphStyle(), styleConfig.getParagraphStyle()) && Arrays.equals(getHeadingStyles(), styleConfig.getHeadingStyles()) && Intrinsics.areEqual(getLinkStyle(), styleConfig.getLinkStyle()) && Intrinsics.areEqual(getLinkVariants(), styleConfig.getLinkVariants()) && Intrinsics.areEqual(getStrongStyle(), styleConfig.getStrongStyle()) && Intrinsics.areEqual(getEmphasisStyle(), styleConfig.getEmphasisStyle()) && Intrinsics.areEqual(getStrikethroughStyle(), styleConfig.getStrikethroughStyle()) && Intrinsics.areEqual(getUnderlineStyle(), styleConfig.getUnderlineStyle()) && Intrinsics.areEqual(getCodeStyle(), styleConfig.getCodeStyle()) && Intrinsics.areEqual(getImageStyle(), styleConfig.getImageStyle()) && Intrinsics.areEqual(getInlineImageStyle(), styleConfig.getInlineImageStyle()) && Intrinsics.areEqual(getBlockquoteStyle(), styleConfig.getBlockquoteStyle()) && Intrinsics.areEqual(getListStyle(), styleConfig.getListStyle()) && Intrinsics.areEqual(getCodeBlockStyle(), styleConfig.getCodeBlockStyle()) && Intrinsics.areEqual(getThematicBreakStyle(), styleConfig.getThematicBreakStyle()) && Intrinsics.areEqual(getTableStyle(), styleConfig.getTableStyle()) && Intrinsics.areEqual(getTaskListStyle(), styleConfig.getTaskListStyle()) && Intrinsics.areEqual(getMathStyle(), styleConfig.getMathStyle()) && Intrinsics.areEqual(getInlineMathStyle(), styleConfig.getInlineMathStyle()) && Intrinsics.areEqual(getSpoilerStyle(), styleConfig.getSpoilerStyle()) && Intrinsics.areEqual(getSuperscriptStyle(), styleConfig.getSuperscriptStyle()) && Intrinsics.areEqual(getSubscriptStyle(), styleConfig.getSubscriptStyle()) && Intrinsics.areEqual(getHighlightStyle(), styleConfig.getHighlightStyle()) && Intrinsics.areEqual(this.imageRequestHeaders, styleConfig.imageRequestHeaders);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((getParagraphStyle().hashCode() * 31) + Arrays.hashCode(getHeadingStyles())) * 31) + getLinkStyle().hashCode()) * 31) + getLinkVariants().hashCode()) * 31) + getStrongStyle().hashCode()) * 31) + getEmphasisStyle().hashCode()) * 31) + getStrikethroughStyle().hashCode()) * 31) + getUnderlineStyle().hashCode()) * 31) + getCodeStyle().hashCode()) * 31) + getImageStyle().hashCode()) * 31) + getInlineImageStyle().hashCode()) * 31) + getBlockquoteStyle().hashCode()) * 31) + getListStyle().hashCode()) * 31) + getCodeBlockStyle().hashCode()) * 31) + getThematicBreakStyle().hashCode()) * 31) + getTableStyle().hashCode()) * 31) + getTaskListStyle().hashCode()) * 31) + getMathStyle().hashCode()) * 31) + getInlineMathStyle().hashCode()) * 31) + getSpoilerStyle().hashCode()) * 31) + getSuperscriptStyle().hashCode()) * 31) + getSubscriptStyle().hashCode()) * 31) + getHighlightStyle().hashCode()) * 31) + this.imageRequestHeaders.hashCode();
    }
}
