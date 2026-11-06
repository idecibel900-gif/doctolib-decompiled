package com.datadog.reactnative;

/* JADX INFO: loaded from: classes3.dex */
public final class DdSdkSynthetics {
    public static final DdSdkSynthetics INSTANCE = new DdSdkSynthetics();
    private static String resultId;
    private static String testId;

    private DdSdkSynthetics() {
    }

    public final String getTestId() {
        return testId;
    }

    public final void setTestId(String str) {
        testId = str;
    }

    public final String getResultId() {
        return resultId;
    }

    public final void setResultId(String str) {
        resultId = str;
    }
}
