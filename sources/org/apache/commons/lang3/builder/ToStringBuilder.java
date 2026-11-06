package org.apache.commons.lang3.builder;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ToStringBuilder {
    private static volatile ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
    private final StringBuffer buffer;
    private final Object object;
    private final ToStringStyle style;

    public static ToStringStyle getDefaultStyle() {
        return defaultStyle;
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        toStringStyle = toStringStyle == null ? getDefaultStyle() : toStringStyle;
        stringBuffer = stringBuffer == null ? new StringBuffer(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) : stringBuffer;
        this.buffer = stringBuffer;
        this.style = toStringStyle;
        this.object = obj;
        toStringStyle.appendStart(stringBuffer, obj);
    }

    public ToStringBuilder append(String str, Object obj, boolean z) {
        this.style.append(this.buffer, str, obj, Boolean.valueOf(z));
        return this;
    }

    public Object getObject() {
        return this.object;
    }

    public StringBuffer getStringBuffer() {
        return this.buffer;
    }

    public ToStringStyle getStyle() {
        return this.style;
    }

    public String toString() {
        if (getObject() == null) {
            getStringBuffer().append(getStyle().getNullText());
        } else {
            this.style.appendEnd(getStringBuffer(), getObject());
        }
        return getStringBuffer().toString();
    }
}
