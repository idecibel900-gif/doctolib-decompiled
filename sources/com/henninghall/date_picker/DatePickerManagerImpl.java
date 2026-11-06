package com.henninghall.date_picker;

import android.widget.LinearLayout;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DatePickerManagerImpl {
    public static PickerView createViewInstance(ThemedReactContext themedReactContext) {
        return new PickerView(new LinearLayout.LayoutParams(-1, -1));
    }

    public static Map getCommandsMap() {
        return MapBuilder.of("scroll", 1);
    }

    protected static void onAfterUpdateTransaction(PickerView pickerView) {
        try {
            pickerView.update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateProp(String str, PickerView pickerView, int i, Dynamic dynamic, Class cls) {
        pickerView.updateProp(getMethodAnnotation(str, cls).names()[i], dynamic);
    }

    private static ReactPropGroup getMethodAnnotation(String str, Class cls) {
        Method method = null;
        for (Method method2 : cls.getMethods()) {
            if (method2.getName().equals(str)) {
                method = method2;
            }
        }
        return (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
    }
}
