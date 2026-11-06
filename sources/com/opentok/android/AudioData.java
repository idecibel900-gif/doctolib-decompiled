package com.opentok.android;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class AudioData {
    private final int bitsPerSample;
    private final int numberOfChannels;
    private final int numberOfSamples;
    private final ByteBuffer sampleBuffer;
    private final int sampleRate;

    public AudioData(long j, int i, int i2, int i3, int i4) {
        this.sampleBuffer = get_samples_byte_buffer(j, i3 * i4 * (i / 8));
        this.bitsPerSample = i;
        this.sampleRate = i2;
        this.numberOfChannels = i3;
        this.numberOfSamples = i4;
    }

    private native ByteBuffer get_samples_byte_buffer(long j, int i);

    public int getBitsPerSample() {
        return this.bitsPerSample;
    }

    public int getNumberOfChannels() {
        return this.numberOfChannels;
    }

    public int getNumberOfSamples() {
        return this.numberOfSamples;
    }

    public ByteBuffer getSampleBuffer() {
        return this.sampleBuffer;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }
}
