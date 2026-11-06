package expo.modules.kotlin.exception;

/* JADX INFO: loaded from: classes4.dex */
public final class UsingReleasedSharedObjectException extends CodedException {
    public UsingReleasedSharedObjectException() {
        super("Cannot use shared object that was already released", null, 2, null);
    }
}
