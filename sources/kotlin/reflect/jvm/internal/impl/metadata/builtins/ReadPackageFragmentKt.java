package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ReadPackageFragmentKt {
    public static final Pair readBuiltinsPackageFragment(InputStream inputStream) throws IOException {
        ProtoBuf$PackageFragment from;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        try {
            BuiltInsBinaryVersion from2 = BuiltInsBinaryVersion.Companion.readFrom(inputStream);
            if (from2.isCompatibleWithCurrentCompilerVersion()) {
                ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
                BuiltInsProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
                from = ProtoBuf$PackageFragment.parseFrom(inputStream, extensionRegistryLiteNewInstance);
            } else {
                from = null;
            }
            Pair pair = TuplesKt.to(from, from2);
            CloseableKt.closeFinally(inputStream, null);
            return pair;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }
}
