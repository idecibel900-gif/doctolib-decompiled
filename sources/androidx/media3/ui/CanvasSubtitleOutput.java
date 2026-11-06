package androidx.media3.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.common.text.Cue;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CanvasSubtitleOutput extends View implements SubtitleView.Output {
    private float bottomPaddingFraction;
    private List cues;
    private final List painters;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;

    public CanvasSubtitleOutput(Context context) {
        this(context, null);
    }

    public CanvasSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.painters = new ArrayList();
        this.cues = Collections.EMPTY_LIST;
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        this.style = CaptionStyleCompat.DEFAULT;
        this.bottomPaddingFraction = 0.08f;
    }

    @Override // androidx.media3.ui.SubtitleView.Output
    public void update(List list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.cues = list;
        this.style = captionStyleCompat;
        this.textSize = f;
        this.textSizeType = i;
        this.bottomPaddingFraction = f2;
        while (this.painters.size() < list.size()) {
            this.painters.add(new SubtitlePainter(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.cues;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float fResolveTextSize = SubtitleViewUtils.resolveTextSize(this.textSizeType, this.textSize, height, i);
        if (fResolveTextSize <= 0.0f) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Cue cueRepositionVerticalCue = (Cue) list.get(i2);
            if (cueRepositionVerticalCue.verticalType != Integer.MIN_VALUE) {
                cueRepositionVerticalCue = repositionVerticalCue(cueRepositionVerticalCue);
            }
            ((SubtitlePainter) this.painters.get(i2)).draw(cueRepositionVerticalCue, this.style, fResolveTextSize, SubtitleViewUtils.resolveTextSize(cueRepositionVerticalCue.textSizeType, cueRepositionVerticalCue.textSize, height, i), this.bottomPaddingFraction, canvas, paddingLeft, paddingTop, width, paddingBottom);
        }
    }

    private static Cue repositionVerticalCue(Cue cue) {
        Cue.Builder textAlignment = cue.buildUpon().setPosition(-3.4028235E38f).setPositionAnchor(LinearLayoutManager.INVALID_OFFSET).setTextAlignment(null);
        if (cue.lineType == 0) {
            textAlignment.setLine(1.0f - cue.line, 0);
        } else {
            textAlignment.setLine((-cue.line) - 1.0f, 1);
        }
        int i = cue.lineAnchor;
        if (i == 0) {
            textAlignment.setLineAnchor(2);
        } else if (i == 2) {
            textAlignment.setLineAnchor(0);
        }
        return textAlignment.build();
    }
}
