package com.facebook.react.views.textinput;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextContentSizeWatcher implements ContentSizeWatcher {
    private final ReactEditText editText;
    private final EventDispatcher eventDispatcher;
    private int previousContentHeight;
    private int previousContentWidth;
    private final int surfaceId;

    public ReactTextContentSizeWatcher(ReactEditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
        ReactContext reactContext = UIManagerHelper.getReactContext(editText);
        this.eventDispatcher = UIManagerHelper.getEventDispatcherForReactTag(reactContext, editText.getId());
        this.surfaceId = UIManagerHelper.getSurfaceId(reactContext);
    }

    @Override // com.facebook.react.views.textinput.ContentSizeWatcher
    public void onLayout() {
        int width = this.editText.getWidth();
        int height = this.editText.getHeight();
        if (this.editText.getLayout() != null) {
            width = this.editText.getCompoundPaddingLeft() + this.editText.getLayout().getWidth() + this.editText.getCompoundPaddingRight();
            height = this.editText.getCompoundPaddingTop() + this.editText.getLayout().getHeight() + this.editText.getCompoundPaddingBottom();
        }
        if (width == this.previousContentWidth && height == this.previousContentHeight) {
            return;
        }
        this.previousContentHeight = height;
        this.previousContentWidth = width;
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new ReactContentSizeChangedEvent(this.surfaceId, this.editText.getId(), PixelUtil.toDIPFromPixel(width), PixelUtil.toDIPFromPixel(height)));
        }
    }
}
