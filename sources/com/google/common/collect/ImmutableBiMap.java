package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmutableBiMap extends ImmutableMap implements Map {
    public abstract ImmutableBiMap inverse();

    public static ImmutableBiMap of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ImmutableMap.Builder {
        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder put(Object obj, Object obj2) {
            super.put(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder put(Map.Entry entry) {
            super.put(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public Builder putAll(Iterable iterable) {
            super.putAll(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap buildOrThrow() {
            int i = this.size;
            if (i == 0) {
                return ImmutableBiMap.of();
            }
            if (this.valueComparator != null) {
                if (this.entriesUsed) {
                    this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, i * 2);
                }
                ImmutableMap.Builder.sortEntries(this.alternatingKeysAndValues, this.size, this.valueComparator);
            }
            this.entriesUsed = true;
            return new RegularImmutableBiMap(this.alternatingKeysAndValues, this.size);
        }
    }

    ImmutableBiMap() {
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet values() {
        return inverse().keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet createValues() {
        throw new AssertionError("should never be called");
    }
}
