package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

/* JADX INFO: loaded from: classes4.dex */
public class TimezoneOffsetInMinutesProp extends Prop {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.henninghall.date_picker.props.Prop
    public String toValue(Dynamic dynamic) {
        if (dynamic.isNull()) {
            return null;
        }
        return dynamic.asString();
    }
}
