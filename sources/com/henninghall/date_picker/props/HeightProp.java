package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

/* JADX INFO: loaded from: classes4.dex */
public class HeightProp extends Prop {
    @Override // com.henninghall.date_picker.props.Prop
    public Integer toValue(Dynamic dynamic) {
        return Integer.valueOf(dynamic.asInt());
    }
}
