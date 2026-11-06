package expo.modules.image;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GlideExtensionsKt {
    public static final RequestBuilder customize(RequestBuilder requestBuilder, boolean z, Function1 block) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return !z ? requestBuilder : (RequestBuilder) block.invoke(requestBuilder);
    }

    public static final RequestBuilder apply(RequestBuilder requestBuilder, RequestOptions requestOptions) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        if (requestOptions == null) {
            return requestBuilder;
        }
        RequestBuilder requestBuilderApply = requestBuilder.apply((BaseRequestOptions) requestOptions);
        Intrinsics.checkNotNullExpressionValue(requestBuilderApply, "apply(...)");
        return requestBuilderApply;
    }
}
