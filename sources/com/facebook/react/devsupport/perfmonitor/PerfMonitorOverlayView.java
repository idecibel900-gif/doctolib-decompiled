package com.facebook.react.devsupport.perfmonitor;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.R$style;
import com.facebook.react.devsupport.inspector.TracingState;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PerfMonitorOverlayView {
    private final Context context;
    private final Dialog dialog;
    private TextView issueCountLabel;
    private LinearLayout issuesContainer;
    private final Function0 onButtonPress;
    private TextView statusIndicator;
    private TextView statusLabel;
    private TextView tooltipLabel;
    public static final Companion Companion = new Companion(null);
    private static final int COLOR_OVERLAY_BORDER = Color.parseColor("#6C6C6C");
    private static final float TEXT_SIZE_PRIMARY = 12.0f;
    private static final float TEXT_SIZE_ACCESSORY = 10.0f;
    private static final Typeface TYPEFACE_BOLD = Typeface.create("sans-serif", 1);

    public PerfMonitorOverlayView(Context context, Function0 onButtonPress) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onButtonPress, "onButtonPress");
        this.context = context;
        this.onButtonPress = onButtonPress;
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.dialog = createToolbarDialog();
    }

    public final void show() {
        this.dialog.show();
    }

    public final void hide() {
        this.dialog.hide();
    }

    public final void updateRecordingState(TracingState state) {
        String str;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == TracingState.ENABLED_IN_CDP_MODE) {
            this.dialog.hide();
            return;
        }
        TextView textView = null;
        if (state == TracingState.ENABLED_IN_BACKGROUND_MODE) {
            TextView textView2 = this.statusIndicator;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusIndicator");
                textView2 = null;
            }
            Drawable background = textView2.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) background).setColor(-65536);
            TextView textView3 = this.statusLabel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusLabel");
                textView3 = null;
            }
            textView3.setText("Profiling Active");
            TextView textView4 = this.tooltipLabel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tooltipLabel");
            } else {
                textView = textView4;
            }
            textView.setText(this.context.getPackageManager().hasSystemFeature("android.hardware.touchscreen") ? "Tap to open" : "Press ☰ to open");
        } else {
            TextView textView5 = this.statusIndicator;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusIndicator");
                textView5 = null;
            }
            Drawable background2 = textView5.getBackground();
            Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) background2).setColor(-7829368);
            TextView textView6 = this.statusLabel;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusLabel");
                textView6 = null;
            }
            textView6.setText("Profiling Stopped");
            TextView textView7 = this.tooltipLabel;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tooltipLabel");
            } else {
                textView = textView7;
            }
            if (this.context.getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
                str = "Tap to restart";
            } else {
                str = "Press ☰ to restart";
            }
            textView.setText(str);
        }
        this.dialog.show();
    }

    public final void updatePerfIssueCount(int i) {
        TextView textView = this.issueCountLabel;
        LinearLayout linearLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("issueCountLabel");
            textView = null;
        }
        textView.setText(String.valueOf(i));
        LinearLayout linearLayout2 = this.issuesContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("issuesContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(i == 0 ? 8 : 0);
    }

    private final Dialog createToolbarDialog() {
        TextView textView = new TextView(this.context);
        textView.setWidth((int) dpToPx(12.0f));
        textView.setHeight((int) dpToPx(12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-65536);
        textView.setBackground(gradientDrawable);
        this.statusIndicator = textView;
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding((int) dpToPx(2.0f), 0, 0, 0);
        TextView textView2 = new TextView(this.context);
        float f = TEXT_SIZE_PRIMARY;
        textView2.setTextSize(f);
        textView2.setTextColor(-1);
        Typeface typeface = TYPEFACE_BOLD;
        textView2.setTypeface(typeface);
        this.statusLabel = textView2;
        TextView textView3 = new TextView(this.context);
        textView3.setTextSize(TEXT_SIZE_ACCESSORY);
        textView3.setTextColor(-1);
        textView3.setTypeface(typeface);
        this.tooltipLabel = textView3;
        TextView textView4 = this.statusLabel;
        WindowManager.LayoutParams layoutParams = null;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusLabel");
            textView4 = null;
        }
        linearLayout.addView(textView4);
        TextView textView5 = this.tooltipLabel;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tooltipLabel");
            textView5 = null;
        }
        linearLayout.addView(textView5);
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setPadding((int) dpToPx(8.0f), 0, 0, 0);
        linearLayout2.setVisibility(8);
        this.issuesContainer = linearLayout2;
        TextView textView6 = new TextView(this.context);
        textView6.setTextSize(f);
        textView6.setTextColor(-1);
        textView6.setTypeface(typeface);
        Drawable drawable = textView6.getContext().getDrawable(R.drawable.ic_dialog_alert);
        if (drawable != null) {
            drawable.setBounds(0, 1, (int) dpToPx(f), ((int) dpToPx(f)) + 1);
        } else {
            drawable = null;
        }
        textView6.setCompoundDrawables(drawable, null, null, null);
        textView6.setCompoundDrawablePadding((int) dpToPx(6.0f));
        this.issueCountLabel = textView6;
        LinearLayout linearLayout3 = this.issuesContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("issuesContainer");
            linearLayout3 = null;
        }
        TextView textView7 = this.issueCountLabel;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("issueCountLabel");
            textView7 = null;
        }
        linearLayout3.addView(textView7);
        LinearLayout linearLayoutCreateInnerLayout = createInnerLayout();
        linearLayoutCreateInnerLayout.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.perfmonitor.PerfMonitorOverlayView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PerfMonitorOverlayView.createToolbarDialog$lambda$8(this.f$0, view);
            }
        });
        TextView textView8 = this.statusIndicator;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusIndicator");
            textView8 = null;
        }
        linearLayoutCreateInnerLayout.addView(textView8);
        linearLayoutCreateInnerLayout.addView(linearLayout);
        LinearLayout linearLayout4 = this.issuesContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("issuesContainer");
            linearLayout4 = null;
        }
        linearLayoutCreateInnerLayout.addView(linearLayout4);
        Dialog dialogCreateAnchoredDialog = createAnchoredDialog(dpToPx(12.0f), dpToPx(12.0f));
        dialogCreateAnchoredDialog.setContentView(linearLayoutCreateInnerLayout);
        Window window = dialogCreateAnchoredDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.flags |= 8;
                layoutParams = attributes;
            }
            window.setAttributes(layoutParams);
        }
        return dialogCreateAnchoredDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createToolbarDialog$lambda$8(PerfMonitorOverlayView perfMonitorOverlayView, View view) {
        perfMonitorOverlayView.onButtonPress.invoke();
    }

    private final Dialog createAnchoredDialog(float f, final float f2) {
        View decorView;
        final Dialog dialog = new Dialog(this.context, R$style.NoAnimationDialog);
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.0f);
        }
        dialog.setCancelable(false);
        Window window3 = dialog.getWindow();
        if (window3 != null) {
            WindowManager.LayoutParams attributes = window3.getAttributes();
            if (attributes != null) {
                attributes.width = -2;
                attributes.height = -2;
                attributes.gravity = 8388661;
                attributes.x = (int) f;
                attributes.y = (int) f2;
            } else {
                attributes = null;
            }
            window3.setAttributes(attributes);
        }
        Window window4 = dialog.getWindow();
        if (window4 != null && (decorView = window4.getDecorView()) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: com.facebook.react.devsupport.perfmonitor.PerfMonitorOverlayView$$ExternalSyntheticLambda1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return PerfMonitorOverlayView.createAnchoredDialog$lambda$16$lambda$15(f2, dialog, view, windowInsetsCompat);
                }
            });
        }
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat createAnchoredDialog$lambda$16$lambda$15(float f, Dialog dialog, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        layoutParams2.y = insets.top + ((int) f);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setAttributes(layoutParams2);
        }
        return WindowInsetsCompat.CONSUMED;
    }

    private final LinearLayout createInnerLayout() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int iDpToPx = (int) dpToPx(14.0f);
        int iDpToPx2 = (int) dpToPx(7.0f);
        linearLayout.setPadding(iDpToPx, iDpToPx2, iDpToPx, iDpToPx2);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(dpToPx(14.5f));
        gradientDrawable.setAlpha(102);
        gradientDrawable.setStroke((int) dpToPx(1.0f), COLOR_OVERLAY_BORDER);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setShowDividers(2);
        linearLayout.setDividerDrawable(new ColorDrawable() { // from class: com.facebook.react.devsupport.perfmonitor.PerfMonitorOverlayView$createInnerLayout$1$2
            {
                super(0);
            }

            @Override // android.graphics.drawable.Drawable
            public int getIntrinsicWidth() {
                return (int) this.this$0.dpToPx(10.0f);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float dpToPx(float f) {
        return PixelUtil.toPixelFromDIP(f);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
