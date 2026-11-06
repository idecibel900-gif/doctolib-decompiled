package com.facebook.react.devsupport;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$layout;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDevLoadingViewImplementation implements DevLoadingViewManager {
    public static final Companion Companion = new Companion(null);
    private static boolean isEnabled = true;
    private PopupWindow devLoadingPopup;
    private TextView devLoadingView;
    private final ReactInstanceDevHelper reactInstanceDevHelper;

    public DefaultDevLoadingViewImplementation(ReactInstanceDevHelper reactInstanceDevHelper) {
        Intrinsics.checkNotNullParameter(reactInstanceDevHelper, "reactInstanceDevHelper");
        this.reactInstanceDevHelper = reactInstanceDevHelper;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public void showMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        showMessage(message, null, null);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public void showMessage(final String message, final Double d, final Double d2) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (isEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DefaultDevLoadingViewImplementation$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.showInternal(message, d, d2);
                }
            });
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public void updateProgress(final String str, final Integer num, final Integer num2) {
        if (isEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DefaultDevLoadingViewImplementation$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDevLoadingViewImplementation.updateProgress$lambda$1(num, num2, this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateProgress$lambda$1(Integer num, Integer num2, DefaultDevLoadingViewImplementation defaultDevLoadingViewImplementation, String str) {
        String str2;
        if (num != null && num2 != null && num2.intValue() > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str2 = String.format(Locale.getDefault(), " %.1f%%", Arrays.copyOf(new Object[]{Float.valueOf((num.intValue() / num2.intValue()) * 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        } else {
            str2 = "";
        }
        TextView textView = defaultDevLoadingViewImplementation.devLoadingView;
        if (textView != null) {
            if (str == null) {
                str = "Loading";
            }
            textView.setText(str + str2 + "…");
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public void hide() {
        if (isEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DefaultDevLoadingViewImplementation$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hideInternal();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInternal(String str, Double d, Double d2) {
        PopupWindow popupWindow = this.devLoadingPopup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            Activity currentActivity = this.reactInstanceDevHelper.getCurrentActivity();
            if (currentActivity == null) {
                FLog.e("ReactNative", "Unable to display loading message because react activity isn't available");
                return;
            }
            try {
                Rect rect = new Rect();
                currentActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int i = rect.top;
                Object systemService = currentActivity.getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewInflate = ((LayoutInflater) systemService).inflate(R$layout.dev_loading_view, (ViewGroup) null);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) viewInflate;
                textView.setText(str);
                if (d != null) {
                    textView.setTextColor((int) d.doubleValue());
                }
                if (d2 != null) {
                    textView.setBackgroundColor((int) d2.doubleValue());
                }
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.DefaultDevLoadingViewImplementation$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.hideInternal();
                    }
                });
                PopupWindow popupWindow2 = new PopupWindow(textView, -1, -2);
                popupWindow2.showAtLocation(currentActivity.getWindow().getDecorView(), 0, 0, i);
                this.devLoadingView = textView;
                this.devLoadingPopup = popupWindow2;
            } catch (WindowManager.BadTokenException unused) {
                FLog.e("ReactNative", "Unable to display loading message because react activity isn't active, message: " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideInternal() {
        PopupWindow popupWindow = this.devLoadingPopup;
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            this.devLoadingPopup = null;
            this.devLoadingView = null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
