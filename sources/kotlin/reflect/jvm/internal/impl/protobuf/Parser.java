package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface Parser {
    Object parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);
}
