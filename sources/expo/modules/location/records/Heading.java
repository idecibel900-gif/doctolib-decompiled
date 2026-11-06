package expo.modules.location.records;

import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
public final class Heading {
    private int accuracy;
    private float magHeading;
    private float trueHeading;

    public Heading(float f, float f2, int i) {
        this.trueHeading = f;
        this.magHeading = f2;
        this.accuracy = i;
    }

    public final Bundle toBundle$expo_location_release() {
        Bundle bundle = new Bundle();
        bundle.putFloat("trueHeading", this.trueHeading);
        bundle.putFloat("magHeading", this.magHeading);
        bundle.putInt("accuracy", this.accuracy);
        return bundle;
    }
}
