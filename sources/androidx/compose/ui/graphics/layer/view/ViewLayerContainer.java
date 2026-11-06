package androidx.compose.ui.graphics.layer.view;

import android.content.Context;
import android.graphics.Canvas;

/* JADX INFO: loaded from: classes.dex */
public final class ViewLayerContainer extends DrawChildContainer {
    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    public ViewLayerContainer(Context context) {
        super(context);
    }
}
