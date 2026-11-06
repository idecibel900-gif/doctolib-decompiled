package com.caverock.androidsvg;

/* JADX INFO: loaded from: classes3.dex */
public class RenderOptions {
    CSSParser.Ruleset css;
    PreserveAspectRatio preserveAspectRatio;
    String targetId;
    SVG.Box viewBox;
    String viewId;
    SVG.Box viewPort;

    public RenderOptions() {
        this.css = null;
        this.preserveAspectRatio = null;
        this.targetId = null;
        this.viewBox = null;
        this.viewId = null;
        this.viewPort = null;
    }

    public RenderOptions(RenderOptions renderOptions) {
        this.css = null;
        this.preserveAspectRatio = null;
        this.targetId = null;
        this.viewBox = null;
        this.viewId = null;
        this.viewPort = null;
        if (renderOptions == null) {
            return;
        }
        this.css = renderOptions.css;
        this.preserveAspectRatio = renderOptions.preserveAspectRatio;
        this.viewBox = renderOptions.viewBox;
        this.viewId = renderOptions.viewId;
        this.viewPort = renderOptions.viewPort;
    }

    public boolean hasCss() {
        CSSParser.Ruleset ruleset = this.css;
        return ruleset != null && ruleset.ruleCount() > 0;
    }

    public boolean hasPreserveAspectRatio() {
        return this.preserveAspectRatio != null;
    }

    public boolean hasView() {
        return this.viewId != null;
    }

    public boolean hasViewBox() {
        return this.viewBox != null;
    }

    public RenderOptions viewPort(float f, float f2, float f3, float f4) {
        this.viewPort = new SVG.Box(f, f2, f3, f4);
        return this;
    }

    public boolean hasViewPort() {
        return this.viewPort != null;
    }

    public boolean hasTarget() {
        return this.targetId != null;
    }
}
