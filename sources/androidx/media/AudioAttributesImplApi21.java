package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public AudioAttributes mAudioAttributes;
    public int mLegacyStreamType = -1;

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.mAudioAttributes.equals(((AudioAttributesImplApi21) obj).mAudioAttributes);
        }
        return false;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }
}
