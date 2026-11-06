package com.facebook.react.views.textinput;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextSelectionWatcher implements SelectionWatcher {
    private final ReactEditText editText;
    private final EventDispatcher eventDispatcher;
    private int previousSelectionEnd;
    private int previousSelectionStart;
    private final int surfaceId;

    public ReactTextSelectionWatcher(ReactEditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
        ReactContext reactContext = UIManagerHelper.getReactContext(editText);
        this.eventDispatcher = UIManagerHelper.getEventDispatcherForReactTag(reactContext, editText.getId());
        this.surfaceId = UIManagerHelper.getSurfaceId(reactContext);
    }

    @Override // com.facebook.react.views.textinput.SelectionWatcher
    public void onSelectionChanged(int i, int i2) {
        double d = i;
        double d2 = i2;
        int iMin = (int) Math.min(d, d2);
        int iMax = (int) Math.max(d, d2);
        if (this.previousSelectionStart == iMin && this.previousSelectionEnd == iMax) {
            return;
        }
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new ReactTextInputSelectionEvent(this.surfaceId, this.editText.getId(), iMin, iMax));
        }
        this.previousSelectionStart = iMin;
        this.previousSelectionEnd = iMax;
    }
}
