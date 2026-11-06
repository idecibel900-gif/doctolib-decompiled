package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.RenderEffect;

/* JADX INFO: loaded from: classes.dex */
final class ViewLayerVerificationHelper31 {
    public static final ViewLayerVerificationHelper31 INSTANCE = new ViewLayerVerificationHelper31();

    private ViewLayerVerificationHelper31() {
    }

    public final void setRenderEffect(View view, RenderEffect renderEffect) {
        view.setRenderEffect(renderEffect != null ? renderEffect.asAndroidRenderEffect() : null);
    }
}
