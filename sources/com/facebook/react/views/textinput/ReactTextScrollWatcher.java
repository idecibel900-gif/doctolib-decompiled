package com.facebook.react.views.textinput;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextScrollWatcher implements ScrollWatcher {
    private final ReactEditText editText;
    private final EventDispatcher eventDispatcher;
    private int previousHorizontal;
    private int previousVert;
    private final int surfaceId;

    public ReactTextScrollWatcher(ReactEditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
        ReactContext reactContext = UIManagerHelper.getReactContext(editText);
        this.eventDispatcher = UIManagerHelper.getEventDispatcherForReactTag(reactContext, editText.getId());
        this.surfaceId = UIManagerHelper.getSurfaceId(reactContext);
    }

    @Override // com.facebook.react.views.textinput.ScrollWatcher
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.previousHorizontal == i && this.previousVert == i2) {
            return;
        }
        ScrollEvent scrollEventObtain = ScrollEvent.Companion.obtain(this.surfaceId, this.editText.getId(), ScrollEventType.SCROLL, i, i2, 0.0f, 0.0f, 0, 0, this.editText.getWidth(), this.editText.getHeight());
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(scrollEventObtain);
        }
        this.previousHorizontal = i;
        this.previousVert = i2;
    }
}
