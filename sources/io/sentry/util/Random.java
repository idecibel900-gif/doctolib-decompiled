package io.sentry.util;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class Random implements Serializable {
    static final AtomicLong UNIQUE_SEED = new AtomicLong(System.nanoTime());
    private long inc;
    private long state;

    public Random() {
        this(getRandomSeed(), getRandomSeed());
    }

    public Random(long j, long j2) {
        setSeed(j, j2);
    }

    public void setSeed(long j, long j2) {
        long j3 = (j2 << 1) | 1;
        this.inc = j3;
        this.state = j3 + j;
    }

    public void nextBytes(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            long j = (this.state * 6364136223846793005L) + this.inc;
            this.state = j;
            bArr[i] = (byte) ((((j >>> 22) ^ j) >>> ((int) ((j >>> 61) + 22))) >>> 24);
        }
    }

    public double nextDouble() {
        long j = this.state * 6364136223846793005L;
        long j2 = this.inc;
        long j3 = j + j2;
        long j4 = (((j3 >>> 22) ^ j3) >>> ((int) ((j3 >>> 61) + 22))) & 4294967295L;
        long j5 = (j3 * 6364136223846793005L) + j2;
        this.state = j5;
        return (((j4 >>> 6) << 27) + (((((j5 >>> 22) ^ j5) >>> ((int) ((j5 >>> 61) + 22))) & 4294967295L) >>> 5)) / 9.007199254740992E15d;
    }

    private static long getRandomSeed() {
        AtomicLong atomicLong;
        long j;
        long j2;
        do {
            atomicLong = UNIQUE_SEED;
            j = atomicLong.get();
            long j3 = (j >> 12) ^ j;
            long j4 = j3 ^ (j3 << 25);
            j2 = (j4 ^ (j4 >> 27)) * 2685821657736338717L;
        } while (!atomicLong.compareAndSet(j, j2));
        return j2;
    }
}
