package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    private final float alpha;
    private final ShaderBrush shaderBrush;
    private final MutableState size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1255boximpl(Size.Companion.m1266getUnspecifiedNHjbRc()), null, 2, null);
    private final State shaderState = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.ui.text.platform.style.ShaderBrushSpan$shaderState$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Shader invoke() {
            if (this.this$0.m2406getSizeNHjbRc() == 9205357640488583168L || Size.m1263isEmptyimpl(this.this$0.m2406getSizeNHjbRc())) {
                return null;
            }
            return this.this$0.getShaderBrush().mo1352createShaderuvyYCjk(this.this$0.m2406getSizeNHjbRc());
        }
    });

    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    public ShaderBrushSpan(ShaderBrush shaderBrush, float f) {
        this.shaderBrush = shaderBrush;
        this.alpha = f;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m2406getSizeNHjbRc() {
        return ((Size) this.size$delegate.getValue()).m1265unboximpl();
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
    public final void m2407setSizeuvyYCjk(long j) {
        this.size$delegate.setValue(Size.m1255boximpl(j));
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        textPaint.setShader((Shader) this.shaderState.getValue());
    }
}
