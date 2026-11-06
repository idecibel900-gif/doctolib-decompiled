package coil.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import coil.util.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface MemoryCache {
    Value get(Key key);

    void set(Key key, Value value);

    void trimMemory(int i);

    public static final class Key implements Parcelable {
        private final Map extras;
        private final String key;
        private static final Companion Companion = new Companion(null);

        @Deprecated
        public static final Parcelable.Creator<Key> CREATOR = new Parcelable.Creator() { // from class: coil.memory.MemoryCache$Key$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public MemoryCache.Key createFromParcel(Parcel parcel) {
                String string = parcel.readString();
                Intrinsics.checkNotNull(string);
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 < i; i2++) {
                    String string2 = parcel.readString();
                    Intrinsics.checkNotNull(string2);
                    String string3 = parcel.readString();
                    Intrinsics.checkNotNull(string3);
                    linkedHashMap.put(string2, string3);
                }
                return new MemoryCache.Key(string, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            public MemoryCache.Key[] newArray(int i) {
                return new MemoryCache.Key[i];
            }
        };

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Key(String str, Map map) {
            this.key = str;
            this.extras = map;
        }

        public /* synthetic */ Key(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map getExtras() {
            return this.extras;
        }

        public static /* synthetic */ Key copy$default(Key key, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = key.key;
            }
            if ((i & 2) != 0) {
                map = key.extras;
            }
            return key.copy(str, map);
        }

        public final Key copy(String str, Map map) {
            return new Key(str, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual(this.key, key.key) && Intrinsics.areEqual(this.extras, key.extras);
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.key);
            parcel.writeInt(this.extras.size());
            for (Map.Entry entry : this.extras.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                parcel.writeString(str);
                parcel.writeString(str2);
            }
        }

        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public static final class Value {
        private final Bitmap bitmap;
        private final Map extras;

        public Value(Bitmap bitmap, Map map) {
            this.bitmap = bitmap;
            this.extras = map;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Map getExtras() {
            return this.extras;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            return Intrinsics.areEqual(this.bitmap, value.bitmap) && Intrinsics.areEqual(this.extras, value.extras);
        }

        public int hashCode() {
            return (this.bitmap.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.bitmap + ", extras=" + this.extras + ')';
        }
    }

    public static final class Builder {
        private final Context context;
        private int maxSizeBytes;
        private double maxSizePercent;
        private boolean strongReferencesEnabled = true;
        private boolean weakReferencesEnabled = true;

        public Builder(Context context) {
            this.context = context;
            this.maxSizePercent = Utils.defaultMemoryCacheSizePercent(context);
        }

        public final MemoryCache build() {
            WeakMemoryCache emptyWeakMemoryCache;
            StrongMemoryCache emptyStrongMemoryCache;
            int iCalculateMemoryCacheSize;
            if (this.weakReferencesEnabled) {
                emptyWeakMemoryCache = new RealWeakMemoryCache();
            } else {
                emptyWeakMemoryCache = new EmptyWeakMemoryCache();
            }
            if (this.strongReferencesEnabled) {
                double d = this.maxSizePercent;
                if (d > 0.0d) {
                    iCalculateMemoryCacheSize = Utils.calculateMemoryCacheSize(this.context, d);
                } else {
                    iCalculateMemoryCacheSize = this.maxSizeBytes;
                }
                if (iCalculateMemoryCacheSize > 0) {
                    emptyStrongMemoryCache = new RealStrongMemoryCache(iCalculateMemoryCacheSize, emptyWeakMemoryCache);
                } else {
                    emptyStrongMemoryCache = new EmptyStrongMemoryCache(emptyWeakMemoryCache);
                }
            } else {
                emptyStrongMemoryCache = new EmptyStrongMemoryCache(emptyWeakMemoryCache);
            }
            return new RealMemoryCache(emptyStrongMemoryCache, emptyWeakMemoryCache);
        }
    }
}
