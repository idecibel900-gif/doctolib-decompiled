package com.henninghall.date_picker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.ui.Accessibility;
import com.henninghall.date_picker.ui.SpinnerStateListener;
import com.henninghall.date_picker.ui.UIManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class PickerView extends RelativeLayout {
    private final Runnable measureAndLayout;
    private State state;
    private UIManager uiManager;
    private ArrayList updatedProps;

    public PickerView(ViewGroup.LayoutParams layoutParams) {
        super(DatePickerPackage.context);
        this.state = new State();
        this.updatedProps = new ArrayList();
        this.measureAndLayout = new Runnable() { // from class: com.henninghall.date_picker.PickerView.1
            @Override // java.lang.Runnable
            public void run() {
                PickerView pickerView = PickerView.this;
                pickerView.measure(View.MeasureSpec.makeMeasureSpec(pickerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(PickerView.this.getHeight(), 1073741824));
                PickerView pickerView2 = PickerView.this;
                pickerView2.layout(pickerView2.getLeft(), PickerView.this.getTop(), PickerView.this.getRight(), PickerView.this.getBottom());
            }
        };
        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutInflater.from(getContext()).inflate(this.state.derived.getRootLayout(), linearLayout);
        addView(linearLayout, layoutParams);
        this.uiManager = new UIManager(this.state, this);
    }

    public void update() {
        if (didUpdate("textColor")) {
            this.uiManager.updateTextColor();
        }
        if (didUpdate("mode", "is24hourSource")) {
            this.uiManager.updateWheelVisibility();
        }
        if (didUpdate("mode", "locale", "is24hourSource")) {
            this.uiManager.updateWheelOrder();
        }
        if (didUpdate("date", "locale", "maximumDate", "minimumDate", "minuteInterval", "mode", "timezoneOffsetInMinutes")) {
            this.uiManager.updateDisplayValues();
        }
        if (didUpdate("locale")) {
            Accessibility.setLocale(this.state.getLocale());
        }
        if (didUpdate("dividerColor")) {
            this.uiManager.setDividerColor(this.state.getDividerColor());
        }
        this.uiManager.setWheelsToDate();
        this.updatedProps = new ArrayList();
    }

    private boolean didUpdate(String... strArr) {
        for (String str : strArr) {
            if (this.updatedProps.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public void updateProp(String str, Dynamic dynamic) {
        this.state.setProp(str, dynamic);
        this.updatedProps.add(str);
    }

    public void addSpinnerStateListener(SpinnerStateListener spinnerStateListener) {
        this.uiManager.addStateListener(spinnerStateListener);
    }

    public String getDate() {
        return this.state.derived.getLastDate();
    }

    public String getPickerId() {
        return this.state.getId();
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }
}
