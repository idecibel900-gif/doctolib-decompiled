package expo.modules.image.blurhash;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashHelpers {
    public static final BlurhashHelpers INSTANCE = new BlurhashHelpers();

    private BlurhashHelpers() {
    }

    public final float srgbToLinear(int i) {
        float f = i / 255.0f;
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4f);
    }

    public final int linearTosRGB(float f) {
        double d;
        double dMax = Math.max(0.0f, Math.min(1.0f, f));
        if (dMax <= 0.0031308d) {
            d = 12.92d;
        } else {
            dMax = ((double) ((float) Math.pow(dMax, 0.41666666f))) - 0.055d;
            d = 1.055d;
        }
        return (int) ((dMax * d * ((double) 255)) + 0.5d);
    }

    public final float signPow(float f, float f2) {
        return ((float) Math.pow(Math.abs(f), f2)) * Math.signum(f);
    }
}
