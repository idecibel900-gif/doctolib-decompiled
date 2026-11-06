package com.swmansion.rnscreens.safearea;

/* JADX INFO: loaded from: classes4.dex */
public interface SafeAreaProvider {
    EdgeInsets getInterfaceInsets();

    void removeOnInterfaceInsetsChangeListener(SafeAreaView safeAreaView);

    void setOnInterfaceInsetsChangeListener(SafeAreaView safeAreaView);
}
