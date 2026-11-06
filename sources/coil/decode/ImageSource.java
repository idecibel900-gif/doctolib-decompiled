package coil.decode;

import java.io.Closeable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageSource implements Closeable {

    public static abstract class Metadata {
    }

    public /* synthetic */ ImageSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Metadata getMetadata();

    public abstract BufferedSource source();

    private ImageSource() {
    }
}
