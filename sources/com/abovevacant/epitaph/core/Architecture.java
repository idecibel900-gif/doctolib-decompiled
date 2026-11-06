package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public enum Architecture {
    ARM32(0),
    ARM64(1),
    X86(2),
    X86_64(3),
    RISCV64(4),
    NONE(5);

    private final int value;

    Architecture(int i) {
        this.value = i;
    }

    public static Architecture fromValue(int i) {
        for (Architecture architecture : values()) {
            if (architecture.value == i) {
                return architecture;
            }
        }
        return NONE;
    }
}
