package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.media3.common.text.Cue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List cues;
    private float defaultTextSize;
    private int defaultTextSizeType;
    private View innerSubtitleView;
    private Output output;
    private CaptionStyleCompat style;
    private int viewType;

    interface Output {
        void update(List list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cues = Collections.EMPTY_LIST;
        this.style = CaptionStyleCompat.DEFAULT;
        this.defaultTextSizeType = 0;
        this.defaultTextSize = 0.0533f;
        this.bottomPaddingFraction = 0.08f;
        this.applyEmbeddedStyles = true;
        this.applyEmbeddedFontSizes = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.output = canvasSubtitleOutput;
        this.innerSubtitleView = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.viewType = 1;
    }

    public void setCues(List<Cue> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.cues = list;
        updateOutput();
    }

    public void setViewType(int i) {
        if (this.viewType == i) {
            return;
        }
        if (i == 1) {
            setView(new CanvasSubtitleOutput(getContext()));
        } else if (i == 2) {
            setView(new WebViewSubtitleOutput(getContext()));
        } else {
            throw new IllegalArgumentException();
        }
        this.viewType = i;
    }

    private <T extends View & Output> void setView(T t) {
        removeView(this.innerSubtitleView);
        View view = this.innerSubtitleView;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).destroy();
        }
        this.innerSubtitleView = t;
        this.output = t;
        addView(t);
    }

    public void setFixedTextSize(int i, float f) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setTextSize(2, TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setFractionalTextSize(float f, boolean z) {
        setTextSize(z ? 1 : 0, f);
    }

    private void setTextSize(int i, float f) {
        this.defaultTextSizeType = i;
        this.defaultTextSize = f;
        updateOutput();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.applyEmbeddedStyles = z;
        updateOutput();
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.applyEmbeddedFontSizes = z;
        updateOutput();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.style = captionStyleCompat;
        updateOutput();
    }

    public void setBottomPaddingFraction(float f) {
        this.bottomPaddingFraction = f;
        updateOutput();
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        if (isInEditMode()) {
            return CaptionStyleCompat.DEFAULT;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager != null && captioningManager.isEnabled()) {
            return CaptionStyleCompat.createFromCaptionStyle(captioningManager.getUserStyle());
        }
        return CaptionStyleCompat.DEFAULT;
    }

    private void updateOutput() {
        this.output.update(getCuesWithStylingPreferencesApplied(), this.style, this.defaultTextSize, this.defaultTextSizeType, this.bottomPaddingFraction);
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.applyEmbeddedStyles && this.applyEmbeddedFontSizes) {
            return this.cues;
        }
        ArrayList arrayList = new ArrayList(this.cues.size());
        for (int i = 0; i < this.cues.size(); i++) {
            arrayList.add(removeEmbeddedStyling((Cue) this.cues.get(i)));
        }
        return arrayList;
    }

    private Cue removeEmbeddedStyling(Cue cue) {
        Cue.Builder builderBuildUpon = cue.buildUpon();
        if (!this.applyEmbeddedStyles) {
            SubtitleViewUtils.removeAllEmbeddedStyling(builderBuildUpon);
        } else if (!this.applyEmbeddedFontSizes) {
            SubtitleViewUtils.removeEmbeddedFontSizes(builderBuildUpon);
        }
        return builderBuildUpon.build();
    }
}
