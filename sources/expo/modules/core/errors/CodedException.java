package expo.modules.core.errors;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CodedException extends Exception {
    public CodedException(String str) {
        super(str);
    }

    public String getCode() {
        return "ERR_UNSPECIFIED_ANDROID_EXCEPTION";
    }
}
