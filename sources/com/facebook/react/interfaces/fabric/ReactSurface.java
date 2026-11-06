package com.facebook.react.interfaces.fabric;

import android.view.ViewGroup;
import com.facebook.react.interfaces.TaskInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface ReactSurface {
    ViewGroup getView();

    TaskInterface start();

    TaskInterface stop();
}
