package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private Shader internalShader;

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo1352createShaderuvyYCjk(long j);

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m1266getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo1347applyToPq9zytI(long j, Paint paint, float f) {
        Shader shaderMo1352createShaderuvyYCjk = this.internalShader;
        if (shaderMo1352createShaderuvyYCjk == null || !Size.m1258equalsimpl0(this.createdSize, j)) {
            if (Size.m1263isEmptyimpl(j)) {
                shaderMo1352createShaderuvyYCjk = null;
                this.internalShader = null;
                this.createdSize = Size.Companion.m1266getUnspecifiedNHjbRc();
            } else {
                shaderMo1352createShaderuvyYCjk = mo1352createShaderuvyYCjk(j);
                this.internalShader = shaderMo1352createShaderuvyYCjk;
                this.createdSize = j;
            }
        }
        long jMo1287getColor0d7_KjU = paint.mo1287getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1367equalsimpl0(jMo1287getColor0d7_KjU, companion.m1376getBlack0d7_KjU())) {
            paint.mo1292setColor8_81llA(companion.m1376getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual(paint.getShader(), shaderMo1352createShaderuvyYCjk)) {
            paint.setShader(shaderMo1352createShaderuvyYCjk);
        }
        if (paint.getAlpha() == f) {
            return;
        }
        paint.setAlpha(f);
    }
}
