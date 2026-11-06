package com.swmansion.enriched.markdown.utils.text.interaction;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CheckboxTouchHelper {
    private boolean isEnabled;
    private Function3 onCheckboxTap;
    private TaskListHitTestResult pendingHit;
    private final TextView textView;
    private float touchDownX;
    private float touchDownY;
    private final Lazy touchSlop$delegate;

    public CheckboxTouchHelper(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.isEnabled = true;
        this.touchSlop$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.utils.text.interaction.CheckboxTouchHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CheckboxTouchHelper.touchSlop_delegate$lambda$0(this.f$0));
            }
        });
    }

    public final Function3 getOnCheckboxTap() {
        return this.onCheckboxTap;
    }

    public final void setOnCheckboxTap(Function3 function3) {
        this.onCheckboxTap = function3;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    private final int getTouchSlop() {
        return ((Number) this.touchSlop$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int touchSlop_delegate$lambda$0(CheckboxTouchHelper checkboxTouchHelper) {
        return ViewConfiguration.get(checkboxTouchHelper.textView.getContext()).getScaledTouchSlop();
    }

    public final boolean onTouchEvent(MotionEvent event) {
        Function3 function3;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.isEnabled) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            TaskListHitTestResult taskListHitTestResultHitTest = TaskListTapUtils.INSTANCE.hitTest(this.textView, event.getX(), event.getY());
            if (taskListHitTestResultHitTest == null) {
                return false;
            }
            this.touchDownX = event.getX();
            this.touchDownY = event.getY();
            this.pendingHit = taskListHitTestResultHitTest;
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 3) {
                    this.pendingHit = null;
                }
            } else if (this.pendingHit != null && isExceedingSlop(event)) {
                this.pendingHit = null;
            }
            return this.pendingHit != null;
        }
        TaskListHitTestResult taskListHitTestResult = this.pendingHit;
        if (taskListHitTestResult == null) {
            return false;
        }
        this.pendingHit = null;
        if (!isExceedingSlop(event) && (function3 = this.onCheckboxTap) != null) {
            function3.invoke(Integer.valueOf(taskListHitTestResult.getTaskIndex()), Boolean.valueOf(taskListHitTestResult.getChecked()), taskListHitTestResult.getItemText());
        }
        return true;
    }

    private final boolean isExceedingSlop(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX() - this.touchDownX) > ((float) getTouchSlop()) || Math.abs(motionEvent.getY() - this.touchDownY) > ((float) getTouchSlop());
    }
}
