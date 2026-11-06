package app.screeb.sdk.internal;

import java.util.Arrays;
import java.util.BitSet;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {
    public int a;
    public int b;
    public int e;
    public long[] c = new long[0];
    public long[] d = new long[0];
    public int[] f = new int[0];
    public final BitSet g = new BitSet();

    public static long a(short[] pixels, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        long j = -3750763034362895579L;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = ((i2 + i6) * i5) + i;
            int i8 = 0;
            while (i8 + 3 < i3) {
                int i9 = i7 + i8;
                j = (j ^ (((((((long) pixels[i9 + 1]) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | (((long) pixels[i9]) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) | ((((long) pixels[i9 + 2]) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32)) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) pixels[i9 + 3])) << 48))) * 1099511628211L;
                i8 += 4;
            }
            while (i8 < i3) {
                j = (j ^ (((long) pixels[i7 + i8]) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) * 1099511628211L;
                i8++;
            }
        }
        return j;
    }

    public final void a() {
        int i = this.a * this.b;
        Arrays.fill(this.c, 0, i, 0L);
        Arrays.fill(this.d, 0, i, 0L);
        this.e = 0;
        Arrays.fill(this.f, 0, i, 0);
    }

    public final void a(int i, int i2) {
        if (i == this.a && i2 == this.b) {
            return;
        }
        this.a = i;
        this.b = i2;
        int i3 = i * i2;
        if (i3 > this.c.length) {
            this.c = new long[i3];
            this.d = new long[i3];
            this.f = new int[i3];
        }
        Arrays.fill(this.c, 0, i3, 0L);
        Arrays.fill(this.d, 0, i3, 0L);
        Arrays.fill(this.f, 0, i3, 0);
    }

    public final BitSet b() {
        this.g.clear();
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.a;
            int i4 = i2 * i3;
            for (int i5 = 0; i5 < i3; i5++) {
                if (this.e - this.f[i4 + i5] > 3) {
                    this.g.set(i2);
                    break;
                }
            }
        }
        return this.g;
    }
}
