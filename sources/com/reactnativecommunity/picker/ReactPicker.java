package com.reactnativecommunity.picker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.i18nmanager.I18nUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ReactPicker extends FabricEnabledPicker {
    private boolean mIsOpen;
    private final AdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mMode;
    private int mOldElementSize;
    private OnFocusListener mOnFocusListener;
    private OnSelectListener mOnSelectListener;
    private Integer mPrimaryColor;
    private Integer mStagedSelection;
    private final Runnable measureAndLayout;

    public interface OnFocusListener {
        void onPickerBlur();

        void onPickerFocus();
    }

    public interface OnSelectListener {
        void onItemSelected(int i);
    }

    public void setDropdownIconColor(int i) {
    }

    public void setDropdownIconRippleColor(int i) {
    }

    @Override // android.widget.AbsSpinner
    public void setSelection(int i, boolean z) {
        super.setSelection(i, z);
    }

    @Override // android.widget.AbsSpinner, android.widget.AdapterView
    public void setSelection(int i) {
        OnSelectListener onSelectListener;
        super.setSelection(i);
        if (!this.mIsOpen || (onSelectListener = this.mOnSelectListener) == null) {
            return;
        }
        onSelectListener.onItemSelected(i);
    }

    public ReactPicker(Context context) {
        super(context);
        this.mMode = 0;
        this.mOldElementSize = LinearLayoutManager.INVALID_OFFSET;
        this.mIsOpen = false;
        this.mItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.reactnativecommunity.picker.ReactPicker.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView adapterView) {
                if (ReactPicker.this.mOnSelectListener == null || !ReactPicker.this.mIsOpen) {
                    return;
                }
                ReactPicker.this.mOnSelectListener.onItemSelected(-1);
            }
        };
        this.measureAndLayout = new Runnable() { // from class: com.reactnativecommunity.picker.ReactPicker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        handleRTL(context);
        setSpinnerBackground();
    }

    public ReactPicker(Context context, int i) {
        super(context, i);
        this.mMode = 0;
        this.mOldElementSize = LinearLayoutManager.INVALID_OFFSET;
        this.mIsOpen = false;
        this.mItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.reactnativecommunity.picker.ReactPicker.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView adapterView, View view, int i2, long j) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView adapterView) {
                if (ReactPicker.this.mOnSelectListener == null || !ReactPicker.this.mIsOpen) {
                    return;
                }
                ReactPicker.this.mOnSelectListener.onItemSelected(-1);
            }
        };
        this.measureAndLayout = new Runnable() { // from class: com.reactnativecommunity.picker.ReactPicker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.mMode = i;
        handleRTL(context);
        setSpinnerBackground();
    }

    private void setSpinnerBackground() {
        setBackgroundResource(R$drawable.spinner_dropdown_background);
        setBackgroundColor(0);
        setPadding(0, 0, 0, 0);
    }

    private void handleRTL(Context context) {
        if (I18nUtil.getInstance().isRTL(context)) {
            setLayoutDirection(1);
            setTextDirection(4);
        } else {
            setLayoutDirection(0);
            setTextDirection(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // android.widget.AbsSpinner, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.view.View
    public boolean performClick() {
        this.mIsOpen = true;
        OnFocusListener onFocusListener = this.mOnFocusListener;
        if (onFocusListener != null) {
            onFocusListener.onPickerFocus();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.mIsOpen && z) {
            this.mIsOpen = false;
            OnFocusListener onFocusListener = this.mOnFocusListener;
            if (onFocusListener != null) {
                onFocusListener.onPickerBlur();
            }
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getOnItemSelectedListener() == null) {
            setOnItemSelectedListener(this.mItemSelectedListener);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        int iApplyDimension;
        super.onMeasure(i, i2);
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition < 0 || getAdapter() == null || selectedItemPosition >= getAdapter().getCount()) {
            iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            View view = getAdapter().getView(selectedItemPosition, null, this);
            measureChild(view, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            iApplyDimension = view.getMeasuredHeight();
        }
        if (iApplyDimension != this.mOldElementSize) {
            this.mOldElementSize = iApplyDimension;
            setMeasuredHeight(iApplyDimension);
        }
    }

    public void measureItem(View view, int i, int i2) {
        measureChild(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.setFocusableInTouchMode(true);
        super.setFocusable(true);
        super.onDetachedFromWindow();
    }

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.mOnSelectListener = onSelectListener;
    }

    public void setOnFocusListener(OnFocusListener onFocusListener) {
        this.mOnFocusListener = onFocusListener;
    }

    public OnSelectListener getOnSelectListener() {
        return this.mOnSelectListener;
    }

    public OnFocusListener getOnFocusListener() {
        return this.mOnFocusListener;
    }

    public void setStagedSelection(int i) {
        this.mStagedSelection = Integer.valueOf(i);
    }

    public void updateStagedSelection() {
        Integer num = this.mStagedSelection;
        if (num != null) {
            setSelectionWithSuppressEvent(num.intValue());
            this.mStagedSelection = null;
        }
    }

    private void setSelectionWithSuppressEvent(int i) {
        if (i != getSelectedItemPosition()) {
            setOnItemSelectedListener(null);
            setSelection(i, false);
            setOnItemSelectedListener(this.mItemSelectedListener);
        }
    }

    public Integer getPrimaryColor() {
        return this.mPrimaryColor;
    }

    public void setPrimaryColor(Integer num) {
        this.mPrimaryColor = num;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(R$id.dropdown_background)).setColor(i);
    }

    public int getMode() {
        return this.mMode;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }
}
