package coil;

import android.graphics.Bitmap;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.transition.Transition;

/* JADX INFO: loaded from: classes3.dex */
public interface EventListener extends ImageRequest.Listener {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final EventListener NONE = new EventListener() { // from class: coil.EventListener$Companion$NONE$1
    };

    default void decodeEnd(ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
    }

    default void decodeStart(ImageRequest imageRequest, Decoder decoder, Options options) {
    }

    default void fetchEnd(ImageRequest imageRequest, Fetcher fetcher, Options options, FetchResult fetchResult) {
    }

    default void fetchStart(ImageRequest imageRequest, Fetcher fetcher, Options options) {
    }

    default void keyEnd(ImageRequest imageRequest, String str) {
    }

    default void keyStart(ImageRequest imageRequest, Object obj) {
    }

    default void mapEnd(ImageRequest imageRequest, Object obj) {
    }

    default void mapStart(ImageRequest imageRequest, Object obj) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onCancel(ImageRequest imageRequest) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onError(ImageRequest imageRequest, ErrorResult errorResult) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onStart(ImageRequest imageRequest) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
    }

    default void resolveSizeEnd(ImageRequest imageRequest, Size size) {
    }

    default void resolveSizeStart(ImageRequest imageRequest) {
    }

    default void transformEnd(ImageRequest imageRequest, Bitmap bitmap) {
    }

    default void transformStart(ImageRequest imageRequest, Bitmap bitmap) {
    }

    default void transitionEnd(ImageRequest imageRequest, Transition transition) {
    }

    default void transitionStart(ImageRequest imageRequest, Transition transition) {
    }

    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Factory NONE = new Factory() { // from class: coil.EventListener$Factory$$ExternalSyntheticLambda0
            @Override // coil.EventListener.Factory
            public final EventListener create(ImageRequest imageRequest) {
                return EventListener.Factory.NONE$lambda$0(imageRequest);
            }
        };

        EventListener create(ImageRequest imageRequest);

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static EventListener NONE$lambda$0(ImageRequest imageRequest) {
            return EventListener.NONE;
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
