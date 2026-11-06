package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.facebook.react.R$drawable;
import com.facebook.react.R$id;
import com.facebook.react.R$layout;
import com.facebook.react.R$style;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PausedInDebuggerOverlayDialogManager implements PausedInDebuggerOverlayManager {
    private final Supplier contextSupplier;
    private Dialog pausedInDebuggerDialog;

    public PausedInDebuggerOverlayDialogManager(Supplier contextSupplier) {
        Intrinsics.checkNotNullParameter(contextSupplier, "contextSupplier");
        this.contextSupplier = contextSupplier;
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void showPausedInDebuggerOverlay(final String message, final DevSupportManager.PausedInDebuggerOverlayCommandListener listener) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(listener, "listener");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PausedInDebuggerOverlayDialogManager.showPausedInDebuggerOverlay$lambda$3(this.f$0, message, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPausedInDebuggerOverlay$lambda$3(PausedInDebuggerOverlayDialogManager pausedInDebuggerOverlayDialogManager, String str, final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        Dialog dialog = pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Context context = (Context) pausedInDebuggerOverlayDialogManager.contextSupplier.get();
        if (context == null) {
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.paused_in_debugger_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        viewInflate.findViewById(R$id.button).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pausedInDebuggerOverlayCommandListener.onResume();
            }
        });
        ((TextView) viewInflate.findViewById(R$id.button_text)).setText(str);
        Dialog dialog2 = new Dialog(context, R$style.NoAnimationDialog);
        dialog2.setContentView(viewInflate);
        dialog2.setCancelable(false);
        pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog = dialog2;
        Window window = dialog2.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
            attributes.dimAmount = 0.2f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setGravity(48);
            window.setElevation(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setBackgroundDrawableResource(R$drawable.paused_in_debugger_background);
        }
        Dialog dialog3 = pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog;
        if (dialog3 != null) {
            dialog3.show();
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void hidePausedInDebuggerOverlay() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PausedInDebuggerOverlayDialogManager.hidePausedInDebuggerOverlay$lambda$4(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hidePausedInDebuggerOverlay$lambda$4(PausedInDebuggerOverlayDialogManager pausedInDebuggerOverlayDialogManager) {
        Dialog dialog = pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog = null;
    }
}
