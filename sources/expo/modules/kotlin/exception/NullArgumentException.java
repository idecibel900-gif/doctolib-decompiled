package expo.modules.kotlin.exception;

/* JADX INFO: loaded from: classes4.dex */
public final class NullArgumentException extends CodedException {
    public NullArgumentException() {
        super("Cannot assigned null to not nullable type.", null, 2, null);
    }
}
