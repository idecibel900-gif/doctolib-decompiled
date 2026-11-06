package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class Options implements Key {
    private final ArrayMap values = new CachedHashCodeArrayMap();

    public void putAll(Options options) {
        this.values.putAll((SimpleArrayMap) options.values);
    }

    public Options set(Option option, Object obj) {
        this.values.put(option, obj);
        return this;
    }

    public Object get(Option option) {
        return this.values.containsKey(option) ? this.values.get(option) : option.getDefaultValue();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.values.equals(((Options) obj).values);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.values.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.values.size(); i++) {
            updateDiskCacheKey((Option) this.values.keyAt(i), this.values.valueAt(i), messageDigest);
        }
    }

    public String toString() {
        return "Options{values=" + this.values + '}';
    }

    private static void updateDiskCacheKey(Option option, Object obj, MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }
}
