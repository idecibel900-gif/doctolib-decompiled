package com.facebook.debug.holder;

/* JADX INFO: loaded from: classes3.dex */
public final class PrinterHolder {
    public static final PrinterHolder INSTANCE = new PrinterHolder();
    private static Printer printer = NoopPrinter.INSTANCE;

    private PrinterHolder() {
    }

    public static final Printer getPrinter() {
        return printer;
    }
}
