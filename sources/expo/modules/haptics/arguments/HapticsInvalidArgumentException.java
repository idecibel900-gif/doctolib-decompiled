package expo.modules.haptics.arguments;

import expo.modules.core.errors.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class HapticsInvalidArgumentException extends CodedException {
    public HapticsInvalidArgumentException(String str) {
        super(str);
    }

    @Override // expo.modules.core.errors.CodedException
    public String getCode() {
        return "E_HAPTICS_INVALID_ARGUMENT";
    }
}
