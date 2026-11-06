package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class RNCAndroidDialogPickerManagerDelegate extends BaseViewManagerDelegate {
    public RNCAndroidDialogPickerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "dropdownIconColor":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setDropdownIconColor(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "dropdownIconRippleColor":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setDropdownIconRippleColor(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "numberOfLines":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setNumberOfLines(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "prompt":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setPrompt(view, obj == null ? null : (String) obj);
                break;
            case "color":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "items":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setItems(view, (ReadableArray) obj);
                break;
            case "selected":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setSelected(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "backgroundColor":
                this.mViewManager.setBackgroundColor(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray) {
        str.getClass();
        switch (str) {
            case "blur":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).blur(view);
                break;
            case "focus":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).focus(view);
                break;
            case "setNativeSelected":
                ((RNCAndroidDialogPickerManagerInterface) this.mViewManager).setNativeSelected(view, readableArray.getInt(0));
                break;
        }
    }
}
