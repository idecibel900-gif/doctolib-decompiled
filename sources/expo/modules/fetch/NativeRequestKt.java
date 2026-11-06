package expo.modules.fetch;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRequestKt {
    private static final String[] METHODS_REQUIRING_BODY = {"POST", "PUT", "PATCH"};

    public static final String[] getMETHODS_REQUIRING_BODY() {
        return METHODS_REQUIRING_BODY;
    }
}
