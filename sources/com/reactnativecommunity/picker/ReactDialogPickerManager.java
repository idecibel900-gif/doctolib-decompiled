package com.reactnativecommunity.picker;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerDelegate;
import com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = ReactDialogPickerManager.REACT_CLASS)
public class ReactDialogPickerManager extends ReactPickerManager implements RNCAndroidDialogPickerManagerInterface {
    public static final String REACT_CLASS = "RNCAndroidDialogPicker";
    private final ViewManagerDelegate mDelegate = new RNCAndroidDialogPickerManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    public /* bridge */ /* synthetic */ void blur(View view) {
        super.blur((ReactPicker) view);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    public /* bridge */ /* synthetic */ void focus(View view) {
        super.focus((ReactPicker) view);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
        super.setColor((ReactPicker) view, num);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(name = "dropdownIconColor")
    public /* bridge */ /* synthetic */ void setDropdownIconColor(View view, int i) {
        super.setDropdownIconColor((ReactPicker) view, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(name = "dropdownIconRippleColor")
    public /* bridge */ /* synthetic */ void setDropdownIconRippleColor(View view, int i) {
        super.setDropdownIconRippleColor((ReactPicker) view, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(defaultBoolean = true, name = "enabled")
    public /* bridge */ /* synthetic */ void setEnabled(View view, boolean z) {
        super.setEnabled((ReactPicker) view, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(name = "items")
    public /* bridge */ /* synthetic */ void setItems(View view, ReadableArray readableArray) {
        super.setItems((ReactPicker) view, readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    public /* bridge */ /* synthetic */ void setNativeSelected(View view, int i) {
        super.setNativeSelected((ReactPicker) view, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public /* bridge */ /* synthetic */ void setNumberOfLines(View view, int i) {
        super.setNumberOfLines((ReactPicker) view, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(name = "prompt")
    public /* bridge */ /* synthetic */ void setPrompt(View view, String str) {
        super.setPrompt((ReactPicker) view, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface
    @ReactProp(name = "selected")
    public /* bridge */ /* synthetic */ void setSelected(View view, int i) {
        super.setSelected((ReactPicker) view, i);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactPicker createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactPicker(themedReactContext, 0);
    }
}
