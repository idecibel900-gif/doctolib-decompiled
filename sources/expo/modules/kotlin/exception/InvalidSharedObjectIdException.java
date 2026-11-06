package expo.modules.kotlin.exception;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidSharedObjectIdException extends CodedException {
    public InvalidSharedObjectIdException() {
        super("Cannot convert provided JavaScriptObject to the SharedObject, because it doesn't contain valid id", null, 2, null);
    }
}
