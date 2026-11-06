package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.models.Is24HourSource;

/* JADX INFO: loaded from: classes4.dex */
public class Is24hourSourceProp extends Prop {
    @Override // com.henninghall.date_picker.props.Prop
    public Is24HourSource toValue(Dynamic dynamic) {
        return Is24HourSource.valueOf(dynamic.asString());
    }
}
