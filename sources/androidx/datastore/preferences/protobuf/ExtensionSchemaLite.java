package androidx.datastore.preferences.protobuf;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class ExtensionSchemaLite extends ExtensionSchema {
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    boolean hasExtensions(MessageLite messageLite) {
        return false;
    }

    ExtensionSchemaLite() {
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    FieldSet getExtensions(Object obj) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    FieldSet getMutableExtensions(Object obj) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    Object parseExtension(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet, Object obj3, UnknownFieldSchema unknownFieldSchema) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj2);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    int extensionNumber(Map.Entry entry) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(entry.getKey());
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void serializeExtension(Writer writer, Map.Entry entry) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(entry.getKey());
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        extensionRegistryLite.findLiteExtensionByNumber(messageLite, i);
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }
}
