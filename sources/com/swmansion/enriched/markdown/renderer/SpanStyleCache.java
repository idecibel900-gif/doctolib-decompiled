package com.swmansion.enriched.markdown.renderer;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.amazon.a.a.o.b.f;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.enriched.markdown.styles.LinkVariantEntry;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public final class SpanStyleCache {
    public static final Companion Companion = new Companion(null);
    private static final Map typefaceCache = new LinkedHashMap();
    private final AssetManager assetManager;
    private final int codeColor;
    private final String codeFontFamily;
    private final float codeFontSize;
    private final int[] colorsToPreserve;
    private final List compiledVariantPatterns;
    private final Integer emphasisColor;
    private final String emphasisFontFamily;
    private final String emphasisFontStyle;
    private final int highlightBackgroundColor;
    private final int highlightColor;
    private final int linkBackgroundColor;
    private final int linkColor;
    private final String linkFontFamily;
    private final boolean linkUnderline;
    private final List linkVariants;
    private final int paragraphColor;
    private final int spoilerColor;
    private final float spoilerParticleDensity;
    private final float spoilerParticleSpeed;
    private final float spoilerSolidBorderRadius;
    private final int strikethroughColor;
    private final Integer strongColor;
    private final String strongFontFamily;
    private final String strongFontWeight;
    private final float subscriptBaselineOffsetScale;
    private final float subscriptFontScale;
    private final float superscriptBaselineOffsetScale;
    private final float superscriptFontScale;

    public SpanStyleCache(StyleConfig style) {
        Pair pair;
        Intrinsics.checkNotNullParameter(style, "style");
        this.assetManager = style.getAssetManager$react_native_enriched_markdown_release();
        this.colorsToPreserve = buildColorsToPreserve(style);
        this.strongFontFamily = style.getStrongStyle().getFontFamily();
        this.strongFontWeight = style.getStrongStyle().getFontWeight();
        this.strongColor = style.getStrongStyle().getColor();
        this.emphasisFontFamily = style.getEmphasisStyle().getFontFamily();
        this.emphasisFontStyle = style.getEmphasisStyle().getFontStyle();
        this.emphasisColor = style.getEmphasisStyle().getColor();
        this.strikethroughColor = style.getStrikethroughStyle().getColor();
        this.linkFontFamily = style.getLinkStyle().getFontFamily();
        this.linkColor = style.getLinkStyle().getColor();
        this.linkUnderline = style.getLinkStyle().getUnderline();
        this.linkBackgroundColor = style.getLinkStyle().getBackgroundColor();
        List<LinkVariantEntry> linkVariants = style.getLinkVariants();
        this.linkVariants = linkVariants;
        ArrayList arrayList = new ArrayList();
        for (LinkVariantEntry linkVariantEntry : linkVariants) {
            try {
                pair = TuplesKt.to(new Regex(linkVariantEntry.getPattern()), linkVariantEntry);
            } catch (Exception unused) {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        this.compiledVariantPatterns = arrayList;
        this.codeFontFamily = style.getCodeStyle().getFontFamily();
        this.codeFontSize = style.getCodeStyle().getFontSize();
        this.codeColor = style.getCodeStyle().getColor();
        this.spoilerColor = style.getSpoilerStyle().getColor();
        this.spoilerParticleDensity = style.getSpoilerStyle().getParticleDensity();
        this.spoilerParticleSpeed = style.getSpoilerStyle().getParticleSpeed();
        this.spoilerSolidBorderRadius = style.getSpoilerStyle().getSolidBorderRadius();
        this.superscriptFontScale = style.getSuperscriptStyle().getFontScale();
        this.superscriptBaselineOffsetScale = style.getSuperscriptStyle().getBaselineOffsetScale();
        this.subscriptFontScale = style.getSubscriptStyle().getFontScale();
        this.subscriptBaselineOffsetScale = style.getSubscriptStyle().getBaselineOffsetScale();
        this.highlightColor = style.getHighlightStyle().getColor();
        this.highlightBackgroundColor = style.getHighlightStyle().getBackgroundColor();
        this.paragraphColor = style.getParagraphStyle().getColor();
    }

    public final int[] getColorsToPreserve() {
        return this.colorsToPreserve;
    }

    public final String getStrongFontFamily() {
        return this.strongFontFamily;
    }

    public final String getStrongFontWeight() {
        return this.strongFontWeight;
    }

    public final String getEmphasisFontFamily() {
        return this.emphasisFontFamily;
    }

    public final String getEmphasisFontStyle() {
        return this.emphasisFontStyle;
    }

    public final int getStrikethroughColor() {
        return this.strikethroughColor;
    }

    public final String getLinkFontFamily() {
        return this.linkFontFamily;
    }

    public final int getLinkColor() {
        return this.linkColor;
    }

    public final boolean getLinkUnderline() {
        return this.linkUnderline;
    }

    public final int getLinkBackgroundColor() {
        return this.linkBackgroundColor;
    }

    public final String getCodeFontFamily() {
        return this.codeFontFamily;
    }

    public final float getCodeFontSize() {
        return this.codeFontSize;
    }

    public final int getCodeColor() {
        return this.codeColor;
    }

    public final int getSpoilerColor() {
        return this.spoilerColor;
    }

    public final float getSpoilerParticleDensity() {
        return this.spoilerParticleDensity;
    }

    public final float getSpoilerParticleSpeed() {
        return this.spoilerParticleSpeed;
    }

    public final float getSpoilerSolidBorderRadius() {
        return this.spoilerSolidBorderRadius;
    }

    public final float getSuperscriptFontScale() {
        return this.superscriptFontScale;
    }

    public final float getSuperscriptBaselineOffsetScale() {
        return this.superscriptBaselineOffsetScale;
    }

    public final float getSubscriptFontScale() {
        return this.subscriptFontScale;
    }

    public final float getSubscriptBaselineOffsetScale() {
        return this.subscriptBaselineOffsetScale;
    }

    public final int getHighlightBackgroundColor() {
        return this.highlightBackgroundColor;
    }

    private final int[] buildColorsToPreserve(StyleConfig styleConfig) {
        int color = styleConfig.getParagraphStyle().getColor();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Integer color2 = styleConfig.getStrongStyle().getColor();
        Integer num = null;
        if (color2 != null) {
            int iIntValue = color2.intValue();
            if (iIntValue == 0 || iIntValue == color) {
                color2 = null;
            }
            if (color2 != null) {
                listCreateListBuilder.add(Integer.valueOf(color2.intValue()));
            }
        }
        Integer color3 = styleConfig.getEmphasisStyle().getColor();
        if (color3 != null) {
            int iIntValue2 = color3.intValue();
            if (iIntValue2 == 0 || iIntValue2 == color) {
                color3 = null;
            }
            if (color3 != null) {
                listCreateListBuilder.add(Integer.valueOf(color3.intValue()));
            }
        }
        Integer numValueOf = Integer.valueOf(styleConfig.getLinkStyle().getColor());
        int iIntValue3 = numValueOf.intValue();
        if (iIntValue3 == 0 || iIntValue3 == color) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            listCreateListBuilder.add(Integer.valueOf(numValueOf.intValue()));
        }
        Iterator it = styleConfig.getLinkVariants().iterator();
        while (it.hasNext()) {
            Integer numValueOf2 = Integer.valueOf(((LinkVariantEntry) it.next()).getColor());
            int iIntValue4 = numValueOf2.intValue();
            if (iIntValue4 == 0 || iIntValue4 == color) {
                numValueOf2 = null;
            }
            if (numValueOf2 != null) {
                listCreateListBuilder.add(Integer.valueOf(numValueOf2.intValue()));
            }
        }
        Integer numValueOf3 = Integer.valueOf(styleConfig.getCodeStyle().getColor());
        int iIntValue5 = numValueOf3.intValue();
        if (iIntValue5 == 0 || iIntValue5 == color) {
            numValueOf3 = null;
        }
        if (numValueOf3 != null) {
            listCreateListBuilder.add(Integer.valueOf(numValueOf3.intValue()));
        }
        Integer numValueOf4 = Integer.valueOf(styleConfig.getTaskListStyle().getCheckedTextColor());
        int iIntValue6 = numValueOf4.intValue();
        if (iIntValue6 != 0 && iIntValue6 != color) {
            num = numValueOf4;
        }
        if (num != null) {
            listCreateListBuilder.add(Integer.valueOf(num.intValue()));
        }
        return CollectionsKt.toIntArray(CollectionsKt.build(listCreateListBuilder));
    }

    public final int getStrongColorFor(int i) {
        Integer num = this.strongColor;
        return num != null ? num.intValue() : i;
    }

    public final int getHighlightColorFor(int i) {
        int i2 = this.highlightColor;
        return i2 == this.paragraphColor ? i : i2;
    }

    public final int getEmphasisColorFor(int i, int i2) {
        if (i2 != i) {
            return i2;
        }
        Integer num = this.emphasisColor;
        return num != null ? num.intValue() : i;
    }

    public final LinkVariantEntry resolvedVariantForUrl(String url) {
        Object next;
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.compiledVariantPatterns.isEmpty()) {
            return null;
        }
        Iterator it = this.compiledVariantPatterns.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((Regex) ((Pair) next).getFirst()).containsMatchIn(url));
        Pair pair = (Pair) next;
        if (pair != null) {
            return (LinkVariantEntry) pair.getSecond();
        }
        return null;
    }

    public final Typeface getTypeface(String fontFamily, int i) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Map map = typefaceCache;
        String str = "family|" + fontFamily + f.c + i;
        Object obj = map.get(str);
        if (obj == null) {
            if (fontFamily.length() <= 0) {
                fontFamily = null;
            }
            Typeface typefaceApplyStyles = ReactTypefaceUtils.applyStyles(null, -1, -1, fontFamily, this.assetManager);
            if (i != 0) {
                typefaceApplyStyles = Typeface.create(typefaceApplyStyles, i);
            }
            obj = typefaceApplyStyles;
            Intrinsics.checkNotNull(obj);
            map.put(str, obj);
        }
        return (Typeface) obj;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Typeface getMonospaceTypeface(int i) {
            Map map = SpanStyleCache.typefaceCache;
            String str = "monospace|" + i;
            Object objCreate = map.get(str);
            if (objCreate == null) {
                objCreate = Typeface.create(Typeface.MONOSPACE, i);
                Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
                map.put(str, objCreate);
            }
            return (Typeface) objCreate;
        }
    }
}
