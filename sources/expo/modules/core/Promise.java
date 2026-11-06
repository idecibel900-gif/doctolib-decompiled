package expo.modules.core;

/* JADX INFO: loaded from: classes4.dex */
public interface Promise {
    void reject(String str, String str2, Throwable th);

    void resolve(Object obj);

    default void reject(String str, String str2) {
        reject(str, str2, null);
    }
}
