package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Prop {
    private Object value;

    abstract Object toValue(Dynamic dynamic);

    public Prop() {
    }

    public Prop(Object obj) {
        this.value = obj;
    }

    public void setValue(Dynamic dynamic) {
        this.value = toValue(dynamic);
    }

    public Object getValue() {
        return this.value;
    }
}
