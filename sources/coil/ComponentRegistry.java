package coil;

import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.key.Keyer;
import coil.map.Mapper;
import coil.request.Options;
import coil.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ComponentRegistry {
    private final List decoderFactories;
    private final List fetcherFactories;
    private final List interceptors;
    private final List keyers;
    private final List mappers;

    public /* synthetic */ ComponentRegistry(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    private ComponentRegistry(List list, List list2, List list3, List list4, List list5) {
        this.interceptors = list;
        this.mappers = list2;
        this.keyers = list3;
        this.fetcherFactories = list4;
        this.decoderFactories = list5;
    }

    public final List getInterceptors() {
        return this.interceptors;
    }

    public final List getMappers() {
        return this.mappers;
    }

    public final List getKeyers() {
        return this.keyers;
    }

    public final List getFetcherFactories() {
        return this.fetcherFactories;
    }

    public final List getDecoderFactories() {
        return this.decoderFactories;
    }

    public ComponentRegistry() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final Object map(Object obj, Options options) {
        List list = this.mappers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) list.get(i);
            Mapper mapper = (Mapper) pair.getFirst();
            if (((Class) pair.getSecond()).isAssignableFrom(obj.getClass())) {
                Intrinsics.checkNotNull(mapper, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object map = mapper.map(obj, options);
                if (map != null) {
                    obj = map;
                }
            }
        }
        return obj;
    }

    public final String key(Object obj, Options options) {
        List list = this.keyers;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) list.get(i);
            Keyer keyer = (Keyer) pair.getFirst();
            if (((Class) pair.getSecond()).isAssignableFrom(obj.getClass())) {
                Intrinsics.checkNotNull(keyer, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String strKey = keyer.key(obj, options);
                if (strKey != null) {
                    return strKey;
                }
            }
        }
        return null;
    }

    public final Pair newFetcher(Object obj, Options options, ImageLoader imageLoader, int i) {
        int size = this.fetcherFactories.size();
        while (i < size) {
            Pair pair = (Pair) this.fetcherFactories.get(i);
            Fetcher.Factory factory = (Fetcher.Factory) pair.getFirst();
            if (((Class) pair.getSecond()).isAssignableFrom(obj.getClass())) {
                Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                Fetcher fetcherCreate = factory.create(obj, options, imageLoader);
                if (fetcherCreate != null) {
                    return TuplesKt.to(fetcherCreate, Integer.valueOf(i));
                }
            }
            i++;
        }
        return null;
    }

    public final Pair newDecoder(SourceResult sourceResult, Options options, ImageLoader imageLoader, int i) {
        int size = this.decoderFactories.size();
        while (i < size) {
            Decoder decoderCreate = ((Decoder.Factory) this.decoderFactories.get(i)).create(sourceResult, options, imageLoader);
            if (decoderCreate != null) {
                return TuplesKt.to(decoderCreate, Integer.valueOf(i));
            }
            i++;
        }
        return null;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        private final List decoderFactories;
        private final List fetcherFactories;
        private final List interceptors;
        private final List keyers;
        private final List mappers;

        public final List getFetcherFactories$coil_base_release() {
            return this.fetcherFactories;
        }

        public final List getDecoderFactories$coil_base_release() {
            return this.decoderFactories;
        }

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.fetcherFactories = new ArrayList();
            this.decoderFactories = new ArrayList();
        }

        public Builder(ComponentRegistry componentRegistry) {
            this.interceptors = CollectionsKt.toMutableList((Collection) componentRegistry.getInterceptors());
            this.mappers = CollectionsKt.toMutableList((Collection) componentRegistry.getMappers());
            this.keyers = CollectionsKt.toMutableList((Collection) componentRegistry.getKeyers());
            this.fetcherFactories = CollectionsKt.toMutableList((Collection) componentRegistry.getFetcherFactories());
            this.decoderFactories = CollectionsKt.toMutableList((Collection) componentRegistry.getDecoderFactories());
        }

        public final Builder add(Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public final Builder add(Mapper mapper, Class cls) {
            this.mappers.add(TuplesKt.to(mapper, cls));
            return this;
        }

        public final Builder add(Keyer keyer, Class cls) {
            this.keyers.add(TuplesKt.to(keyer, cls));
            return this;
        }

        public final Builder add(Fetcher.Factory factory, Class cls) {
            this.fetcherFactories.add(TuplesKt.to(factory, cls));
            return this;
        }

        public final Builder add(Decoder.Factory factory) {
            this.decoderFactories.add(factory);
            return this;
        }

        public final ComponentRegistry build() {
            return new ComponentRegistry(Collections.toImmutableList(this.interceptors), Collections.toImmutableList(this.mappers), Collections.toImmutableList(this.keyers), Collections.toImmutableList(this.fetcherFactories), Collections.toImmutableList(this.decoderFactories), null);
        }
    }
}
