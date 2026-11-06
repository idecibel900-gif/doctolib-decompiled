package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.models.Mode;

/* JADX INFO: loaded from: classes4.dex */
public class ModeProp extends Prop {
    @Override // com.henninghall.date_picker.props.Prop
    public Mode toValue(Dynamic dynamic) {
        return Mode.valueOf(dynamic.asString());
    }
}
