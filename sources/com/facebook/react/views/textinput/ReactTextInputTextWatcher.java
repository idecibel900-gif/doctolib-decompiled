package com.facebook.react.views.textinput;

import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextInputTextWatcher implements TextWatcher {
    private final ReactEditText editText;
    private final EventDispatcher eventDispatcher;
    private String previousText;
    private final int surfaceId;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    public ReactTextInputTextWatcher(ReactContext reactContext, ReactEditText editText) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
        this.eventDispatcher = UIManagerHelper.getEventDispatcherForReactTag(reactContext, editText.getId());
        this.surfaceId = UIManagerHelper.getSurfaceId(reactContext);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.previousText = s.toString();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(s, "s");
        if (this.editText.getDisableTextDiffing$ReactAndroid_release()) {
            return;
        }
        if (i3 == 0 && i2 == 0) {
            return;
        }
        String strSubstring = s.toString().substring(i, i + i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String str = this.previousText;
        if (str == null) {
            throw new IllegalStateException("Required value was null.");
        }
        String strSubstring2 = str.substring(i, i + i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        if (i3 == i2 && Intrinsics.areEqual(strSubstring, strSubstring2)) {
            return;
        }
        StateWrapper stateWrapper = this.editText.getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putInt("mostRecentEventCount", this.editText.incrementAndGetEventCounter());
            writableNativeMap.putInt("opaqueCacheId", this.editText.getId());
            stateWrapper.updateState(writableNativeMap);
        }
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.surfaceId, this.editText.getId(), s.toString(), this.editText.incrementAndGetEventCounter()));
        }
    }
}
