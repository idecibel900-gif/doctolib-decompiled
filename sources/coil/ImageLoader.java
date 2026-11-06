package coil;

import android.content.Context;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.util.ImageLoaderOptions;
import coil.util.Requests;
import coil.util.SingletonDiskCache;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public interface ImageLoader {
    Disposable enqueue(ImageRequest imageRequest);

    Object execute(ImageRequest imageRequest, Continuation continuation);

    ComponentRegistry getComponents();

    DefaultRequestOptions getDefaults();

    MemoryCache getMemoryCache();

    public static final class Builder {
        private final Context applicationContext;
        private DefaultRequestOptions defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
        private Lazy memoryCache = null;
        private Lazy diskCache = null;
        private Lazy callFactory = null;
        private EventListener.Factory eventListenerFactory = null;
        private ComponentRegistry componentRegistry = null;
        private ImageLoaderOptions options = new ImageLoaderOptions(false, false, false, 0, null, 31, null);

        public Builder(Context context) {
            this.applicationContext = context.getApplicationContext();
        }

        public final Builder components(ComponentRegistry componentRegistry) {
            this.componentRegistry = componentRegistry;
            return this;
        }

        public final Builder diskCache(Function0 function0) {
            this.diskCache = LazyKt.lazy(function0);
            return this;
        }

        public final ImageLoader build() {
            Context context = this.applicationContext;
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            Lazy lazy = this.memoryCache;
            if (lazy == null) {
                lazy = LazyKt.lazy(new Function0() { // from class: coil.ImageLoader$Builder$build$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final MemoryCache invoke() {
                        return new MemoryCache.Builder(this.this$0.applicationContext).build();
                    }
                });
            }
            Lazy lazy2 = this.diskCache;
            if (lazy2 == null) {
                lazy2 = LazyKt.lazy(new Function0() { // from class: coil.ImageLoader$Builder$build$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final DiskCache invoke() {
                        return SingletonDiskCache.INSTANCE.get(this.this$0.applicationContext);
                    }
                });
            }
            Lazy lazy3 = this.callFactory;
            if (lazy3 == null) {
                lazy3 = LazyKt.lazy(new Function0() { // from class: coil.ImageLoader$Builder$build$3
                    @Override // kotlin.jvm.functions.Function0
                    public final OkHttpClient invoke() {
                        return new OkHttpClient();
                    }
                });
            }
            EventListener.Factory factory = this.eventListenerFactory;
            if (factory == null) {
                factory = EventListener.Factory.NONE;
            }
            ComponentRegistry componentRegistry = this.componentRegistry;
            if (componentRegistry == null) {
                componentRegistry = new ComponentRegistry();
            }
            return new RealImageLoader(context, defaultRequestOptions, lazy, lazy2, lazy3, factory, componentRegistry, this.options, null);
        }
    }
}
