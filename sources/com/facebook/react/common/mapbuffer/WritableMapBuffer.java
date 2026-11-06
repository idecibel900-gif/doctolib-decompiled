package com.facebook.react.common.mapbuffer;

import android.util.SparseArray;
import com.facebook.proguard.annotations.DoNotStrip;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096\u0002¢\u0006\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/facebook/react/common/mapbuffer/WritableMapBuffer;", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "<init>", "()V", "", "", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "dataType", "(Ljava/lang/Object;I)Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "", "getKeys", "()[I", "", "getValues", "()[Ljava/lang/Object;", "", "contains", "(I)Z", "getBoolean", "getInt", "(I)I", "", "getDouble", "(I)D", "", "getString", "(I)Ljava/lang/String;", "getMapBuffer", "(I)Lcom/facebook/react/common/mapbuffer/MapBuffer;", "", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "iterator", "()Ljava/util/Iterator;", "Landroid/util/SparseArray;", "values", "Landroid/util/SparseArray;", "getCount", "()I", "count", "MapBufferEntry", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WritableMapBuffer implements MapBuffer {
    private final SparseArray values = new SparseArray();

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getCount() {
        return this.values.size();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean contains(int key) {
        return this.values.get(key) != null;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean getBoolean(int key) {
        Object obj = this.values.get(key);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        if (!(obj instanceof Boolean)) {
            throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + key + ", found " + obj.getClass() + " instead.").toString());
        }
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getInt(int key) {
        Object obj = this.values.get(key);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        if (!(obj instanceof Integer)) {
            throw new IllegalStateException(("Expected " + Integer.class + " for key: " + key + ", found " + obj.getClass() + " instead.").toString());
        }
        return ((Number) obj).intValue();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public double getDouble(int key) {
        Object obj = this.values.get(key);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        if (!(obj instanceof Double)) {
            throw new IllegalStateException(("Expected " + Double.class + " for key: " + key + ", found " + obj.getClass() + " instead.").toString());
        }
        return ((Number) obj).doubleValue();
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public String getString(int key) {
        Object obj = this.values.get(key);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        if (!(obj instanceof String)) {
            throw new IllegalStateException(("Expected " + String.class + " for key: " + key + ", found " + obj.getClass() + " instead.").toString());
        }
        return (String) obj;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public MapBuffer getMapBuffer(int key) {
        Object obj = this.values.get(key);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        if (!(obj instanceof MapBuffer)) {
            throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + key + ", found " + obj.getClass() + " instead.").toString());
        }
        return (MapBuffer) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MapBuffer.DataType dataType(Object obj, int i) {
        if (obj instanceof Boolean) {
            return MapBuffer.DataType.BOOL;
        }
        if (obj instanceof Integer) {
            return MapBuffer.DataType.INT;
        }
        if (obj instanceof Long) {
            return MapBuffer.DataType.LONG;
        }
        if (obj instanceof Double) {
            return MapBuffer.DataType.DOUBLE;
        }
        if (obj instanceof String) {
            return MapBuffer.DataType.STRING;
        }
        if (obj instanceof MapBuffer) {
            return MapBuffer.DataType.MAP;
        }
        throw new IllegalStateException("Key " + i + " has value of unknown type: " + obj.getClass());
    }

    /* JADX INFO: renamed from: com.facebook.react.common.mapbuffer.WritableMapBuffer$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator, KMappedMarker {
        private int count;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.count < WritableMapBuffer.this.values.size();
        }

        @Override // java.util.Iterator
        public MapBuffer.Entry next() {
            WritableMapBuffer writableMapBuffer = WritableMapBuffer.this;
            int i = this.count;
            this.count = i + 1;
            return writableMapBuffer.new MapBufferEntry(i);
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    private final class MapBufferEntry implements MapBuffer.Entry {
        private final int index;
        private final int key;
        private final MapBuffer.DataType type;

        public MapBufferEntry(int i) {
            this.index = i;
            this.key = WritableMapBuffer.this.values.keyAt(i);
            Object objValueAt = WritableMapBuffer.this.values.valueAt(i);
            Intrinsics.checkNotNullExpressionValue(objValueAt, "valueAt(...)");
            this.type = WritableMapBuffer.this.dataType(objValueAt, getKey());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getKey() {
            return this.key;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer.DataType getType() {
            return this.type;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public boolean getBooleanValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Boolean)) {
                throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Boolean) objValueAt).booleanValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getIntValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Integer)) {
                throw new IllegalStateException(("Expected " + Integer.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Number) objValueAt).intValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public long getLongValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Long)) {
                throw new IllegalStateException(("Expected " + Long.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Number) objValueAt).longValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public double getDoubleValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof Double)) {
                throw new IllegalStateException(("Expected " + Double.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return ((Number) objValueAt).doubleValue();
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public String getStringValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof String)) {
                throw new IllegalStateException(("Expected " + String.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return (String) objValueAt;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer getMapBufferValue() {
            int key = getKey();
            Object objValueAt = WritableMapBuffer.this.values.valueAt(this.index);
            if (objValueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            }
            if (!(objValueAt instanceof MapBuffer)) {
                throw new IllegalStateException(("Expected " + MapBuffer.class + " for key: " + key + ", found " + objValueAt.getClass() + " instead.").toString());
            }
            return (MapBuffer) objValueAt;
        }
    }

    @DoNotStrip
    private final int[] getKeys() {
        int size = this.values.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.values.keyAt(i);
        }
        return iArr;
    }

    @DoNotStrip
    private final Object[] getValues() {
        int size = this.values.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            Object objValueAt = this.values.valueAt(i);
            Intrinsics.checkNotNullExpressionValue(objValueAt, "valueAt(...)");
            objArr[i] = objValueAt;
        }
        return objArr;
    }
}
