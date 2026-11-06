package coil.intercept;

import coil.request.ImageRequest;
import coil.size.Size;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface Interceptor {

    public interface Chain {
        ImageRequest getRequest();

        Size getSize();
    }

    Object intercept(Chain chain, Continuation continuation);
}
