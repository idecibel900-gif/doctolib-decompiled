package com.caverock.androidsvg;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SVGStylerKt {
    public static final void replaceColor(SVG.SvgPaint svgPaint, int i) {
        if (!(svgPaint instanceof SVG.Colour) || svgPaint == SVG.Colour.TRANSPARENT) {
            return;
        }
        ((SVG.Colour) svgPaint).colour = i;
    }

    public static final void replaceStyles(SVG.Style style, int i) {
        if (style == null) {
            return;
        }
        replaceColor(style.color, i);
        replaceColor(style.fill, i);
        replaceColor(style.stroke, i);
        replaceColor(style.stopColor, i);
        replaceColor(style.solidColor, i);
        replaceColor(style.viewportFill, i);
    }

    public static final boolean hasStyle(SVG.SvgElementBase element) {
        SVG.SvgPaint svgPaint;
        Intrinsics.checkNotNullParameter(element, "element");
        SVG.Style style = element.style;
        if (style == null && element.baseStyle == null) {
            return false;
        }
        if (style != null && (style.color != null || style.fill != null || (svgPaint = style.stroke) != null || svgPaint != null || style.stopColor != null || style.solidColor != null)) {
            return true;
        }
        SVG.Style style2 = element.baseStyle;
        if (style2 == null) {
            return false;
        }
        return (style2.color == null && style2.fill == null && style2.stroke == null && style2.viewportFill == null && style2.stopColor == null && style2.solidColor == null) ? false : true;
    }

    public static final void defineStyles(SVG.SvgElementBase element, int i, boolean z) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (z) {
            return;
        }
        SVG.Style style = element.style;
        if (style == null) {
            style = new SVG.Style();
            element.style = style;
        }
        SVG.Colour colour = new SVG.Colour(i);
        if ((element instanceof SVG.Path) || (element instanceof SVG.Circle) || (element instanceof SVG.Ellipse) || (element instanceof SVG.Rect) || (element instanceof SVG.SolidColor) || (element instanceof SVG.Line) || (element instanceof SVG.Polygon) || (element instanceof SVG.PolyLine)) {
            style.fill = colour;
            style.specifiedFlags = 1L;
        } else if (element instanceof SVG.TextPath) {
            style.color = colour;
            style.specifiedFlags = 4096L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void applyTintColor(SVG.SvgObject element, int i, boolean z) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (element instanceof SVG.Mask) {
            return;
        }
        if (element instanceof SVG.SvgElementBase) {
            z = z || hasStyle((SVG.SvgElementBase) element);
            SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) element;
            replaceStyles(svgElementBase.baseStyle, i);
            replaceStyles(svgElementBase.style, i);
            defineStyles(svgElementBase, i, z);
        }
        if (element instanceof SVG.SvgContainer) {
            for (SVG.SvgObject svgObject : ((SVG.SvgContainer) element).getChildren()) {
                Intrinsics.checkNotNull(svgObject);
                applyTintColor(svgObject, i, z);
            }
        }
    }

    public static final void applyTintColor(SVG svg, int i) {
        Intrinsics.checkNotNullParameter(svg, "svg");
        SVG.Svg rootElement = svg.getRootElement();
        List cSSRules = svg.getCSSRules();
        if (cSSRules != null) {
            Iterator it = cSSRules.iterator();
            while (it.hasNext()) {
                replaceStyles(((CSSParser.Rule) it.next()).style, i);
            }
        }
        replaceStyles(rootElement.baseStyle, i);
        replaceStyles(rootElement.style, i);
        Intrinsics.checkNotNull(rootElement);
        boolean zHasStyle = hasStyle(rootElement);
        for (SVG.SvgObject svgObject : rootElement.children) {
            Intrinsics.checkNotNull(svgObject);
            applyTintColor(svgObject, i, zHasStyle);
        }
    }
}
