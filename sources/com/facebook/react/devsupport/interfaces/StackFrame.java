package com.facebook.react.devsupport.interfaces;

/* JADX INFO: loaded from: classes3.dex */
public interface StackFrame {
    int getColumn();

    String getFile();

    String getFileName();

    int getLine();

    String getMethod();

    boolean isCollapsed();
}
