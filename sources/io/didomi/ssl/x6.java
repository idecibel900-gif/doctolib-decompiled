package io.didomi.ssl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.opentok.android.PublisherKit;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0013\b\u0007\u0012\b\b\u0001\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/x6;", "Lio/didomi/sdk/p;", "Lio/didomi/sdk/x6$a;", "Landroid/graphics/Bitmap;", "param", "Lio/didomi/sdk/a0;", "a", "(Lio/didomi/sdk/x6$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "url", "Ljava/io/InputStream;", "inputStream", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class x6 extends p<Param, Bitmap> {

    /* JADX INFO: renamed from: io.didomi.sdk.x6$a, reason: from toString */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/x6$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "url", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Param {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String url;

        public Param(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && Intrinsics.areEqual(this.url, ((Param) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "Param(url=" + this.url + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x6(CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.didomi.ssl.p
    public Object a(Param param, Continuation continuation) {
        if (StringsKt.isBlank(param.getUrl())) {
            return a0.INSTANCE.a("Url is empty");
        }
        InputStream inputStreamA = a(param.getUrl());
        if (inputStreamA == null) {
            return a0.INSTANCE.a("Unable to load " + param.getUrl());
        }
        Bitmap bitmapA = a(inputStreamA);
        if (bitmapA != null) {
            return a0.INSTANCE.a(bitmapA);
        }
        return a0.INSTANCE.a("Unable to decode " + param.getUrl());
    }

    public final InputStream a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            return new URL(url).openStream();
        } catch (Exception unused) {
            return null;
        }
    }

    public final Bitmap a(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return BitmapFactory.decodeStream(inputStream);
    }
}
