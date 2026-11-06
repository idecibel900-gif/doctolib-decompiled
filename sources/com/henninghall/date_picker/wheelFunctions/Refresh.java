package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.wheels.Wheel;

/* JADX INFO: loaded from: classes4.dex */
public class Refresh implements WheelFunction {
    @Override // com.henninghall.date_picker.wheelFunctions.WheelFunction
    public void apply(Wheel wheel) {
        wheel.refresh();
    }
}
