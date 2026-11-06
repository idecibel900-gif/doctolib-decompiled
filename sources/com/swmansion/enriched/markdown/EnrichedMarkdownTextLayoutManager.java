package com.swmansion.enriched.markdown;

import android.text.TextPaint;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EnrichedMarkdownTextLayoutManager {
    private int forceHeightRecalculationCounter;
    private final EnrichedMarkdownText view;

    public EnrichedMarkdownTextLayoutManager(EnrichedMarkdownText view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final void invalidateLayout() {
        StateWrapper stateWrapper;
        CharSequence text = this.view.getText();
        TextPaint paint = this.view.getPaint();
        MeasurementStore measurementStore = MeasurementStore.INSTANCE;
        int id = this.view.getId();
        Intrinsics.checkNotNull(paint);
        if (measurementStore.store(id, text, paint, this.view.trailingMarginBottomPx()) && (stateWrapper = this.view.getStateWrapper()) != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            int i = this.forceHeightRecalculationCounter + 1;
            this.forceHeightRecalculationCounter = i;
            writableMapCreateMap.putInt("forceHeightRecalculationCounter", i);
            stateWrapper.updateState(writableMapCreateMap);
        }
    }

    public final void releaseMeasurementStore() {
        MeasurementStore.INSTANCE.release(this.view.getId());
    }
}
