package expo.modules.haptics.arguments;

import expo.modules.core.errors.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class HapticsNotSupportedException extends CodedException {
    public HapticsNotSupportedException() {
        super("A haptics engine is not available on this device");
    }
}
