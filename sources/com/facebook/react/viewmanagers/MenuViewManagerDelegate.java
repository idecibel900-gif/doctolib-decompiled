package com.facebook.react.viewmanagers;

import android.view.View;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class MenuViewManagerDelegate extends BaseViewManagerDelegate {
    public MenuViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1161803523:
                if (str.equals("actions")) {
                    b = 0;
                }
                break;
            case -391065988:
                if (str.equals("themeVariant")) {
                    b = 1;
                }
                break;
            case 110371416:
                if (str.equals(b.S)) {
                    b = 2;
                }
                break;
            case 926871597:
                if (str.equals("hitSlop")) {
                    b = 3;
                }
                break;
            case 1187876139:
                if (str.equals("shouldOpenOnLongPress")) {
                    b = 4;
                }
                break;
            case 1600894891:
                if (str.equals("actionsHash")) {
                    b = 5;
                }
                break;
        }
        switch (b) {
            case 0:
                ((MenuViewManagerInterface) this.mViewManager).setActions(view, (ReadableArray) obj);
                break;
            case 1:
                ((MenuViewManagerInterface) this.mViewManager).setThemeVariant(view, obj != null ? (String) obj : null);
                break;
            case 2:
                ((MenuViewManagerInterface) this.mViewManager).setTitle(view, obj != null ? (String) obj : null);
                break;
            case 3:
                ((MenuViewManagerInterface) this.mViewManager).setHitSlop(view, (ReadableMap) obj);
                break;
            case 4:
                ((MenuViewManagerInterface) this.mViewManager).setShouldOpenOnLongPress(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((MenuViewManagerInterface) this.mViewManager).setActionsHash(view, obj != null ? (String) obj : null);
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}
