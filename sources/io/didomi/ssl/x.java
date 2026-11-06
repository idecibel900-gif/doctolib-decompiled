package io.didomi.ssl;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.amazon.device.iap.internal.c.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Lio/didomi/sdk/x;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/TextPaint;", "textPaint", "", "a", "", "updateMeasureState", "updateDrawState", "I", b.as, "<init>", "(I)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class x extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int offset;

    public x(int i) {
        this.offset = i;
    }

    private final int a(TextPaint textPaint) {
        return ((int) ((textPaint.ascent() + textPaint.descent()) / 2)) + this.offset;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            textPaint.baselineShift += a(textPaint);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.baselineShift += a(textPaint);
    }
}
