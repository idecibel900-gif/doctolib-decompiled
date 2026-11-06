package com.swmansion.enriched.markdown.input.layout;

import android.text.Editable;
import android.text.TextPaint;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;
import com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InputLayoutManager {
    private int forceHeightRecalculationCounter;
    private final EnrichedMarkdownTextInputView view;

    public InputLayoutManager(EnrichedMarkdownTextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final void invalidateLayout() {
        if (this.view.getStateWrapper() == null) {
            return;
        }
        Editable text = this.view.getText();
        TextPaint paint = this.view.getPaint();
        InputMeasurementStore inputMeasurementStore = InputMeasurementStore.INSTANCE;
        int id = this.view.getId();
        Intrinsics.checkNotNull(paint);
        if (inputMeasurementStore.store(id, text, paint)) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            int i = this.forceHeightRecalculationCounter;
            this.forceHeightRecalculationCounter = i + 1;
            writableMapCreateMap.putInt("forceHeightRecalculationCounter", i);
            StateWrapper stateWrapper = this.view.getStateWrapper();
            if (stateWrapper != null) {
                stateWrapper.updateState(writableMapCreateMap);
            }
        }
    }

    public final void release() {
        InputMeasurementStore.INSTANCE.release(this.view.getId());
    }
}
