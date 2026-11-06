package com.henninghall.date_picker;

/* JADX INFO: loaded from: classes4.dex */
public class HourDisplayBugWorkaround {
    private final State state;

    public HourDisplayBugWorkaround(State state) {
        this.state = state;
    }

    private boolean shouldApply(String str) {
        return str.length() == 1;
    }

    private String adjust(String str) {
        return " " + str + " ";
    }

    public String adjustValueIfNecessary(String str) {
        return !shouldApply(str) ? str : adjust(str);
    }
}
