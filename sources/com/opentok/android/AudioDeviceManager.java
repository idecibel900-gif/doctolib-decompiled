package com.opentok.android;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class AudioDeviceManager {
    private static final OtLog.LogToken log = new OtLog.LogToken();
    private static BaseAudioDevice mBaseAudioDevice;
    private BaseAudioDevice.AudioFocusManager audioFocusManager;
    private Context context;

    public AudioDeviceManager() {
        this.context = null;
    }

    public static BaseAudioDevice getAudioDevice() {
        log.d("getAudioDevice() called", new Object[0]);
        return mBaseAudioDevice;
    }

    public static void setAudioDevice(BaseAudioDevice baseAudioDevice) {
        log.d("setAudioDevice() called", new Object[0]);
        if (mBaseAudioDevice != null) {
            throw new IllegalStateException("AudioDevice can only be changed before initialization.");
        }
        if (baseAudioDevice != null && baseAudioDevice.getAudioBus() == null) {
            baseAudioDevice.setAudioBus(new BaseAudioDevice.AudioBus(baseAudioDevice));
        }
        mBaseAudioDevice = baseAudioDevice;
    }

    public BaseAudioDevice.AudioFocusManager getAudioFocusManager() {
        log.d("getAudioFocusManager() called", new Object[0]);
        Context context = this.context;
        if (context == null) {
            return null;
        }
        if (mBaseAudioDevice == null) {
            DefaultAudioDevice defaultAudioDevice = new DefaultAudioDevice(context.getApplicationContext());
            defaultAudioDevice.setAudioBus(new BaseAudioDevice.AudioBus(defaultAudioDevice));
            setAudioDevice(defaultAudioDevice);
        }
        Object audioDevice = getAudioDevice();
        if (audioDevice instanceof BaseAudioDevice.AudioFocusManager) {
            return (BaseAudioDevice.AudioFocusManager) audioDevice;
        }
        return null;
    }

    public AudioDeviceManager(Context context) {
        this.context = context;
    }
}
