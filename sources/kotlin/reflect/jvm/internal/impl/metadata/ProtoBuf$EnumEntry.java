package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoBuf$EnumEntry extends GeneratedMessageLite.ExtendableMessage implements MessageLiteOrBuilder {
    public static Parser PARSER = new AbstractParser() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$EnumEntry parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$EnumEntry(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$EnumEntry defaultInstance;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private final ByteString unknownFields;

    private ProtoBuf$EnumEntry(GeneratedMessageLite.ExtendableBuilder extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$EnumEntry(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public static ProtoBuf$EnumEntry getDefaultInstance() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$EnumEntry getDefaultInstanceForType() {
        return defaultInstance;
    }

    private ProtoBuf$EnumEntry(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output outputNewOutput = ByteString.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag != 8) {
                                if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.name_ = codedInputStream.readInt32();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = outputNewOutput.toByteString();
                }
                makeExtensionsImmutable();
                throw th;
            }
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = outputNewOutput.toByteString();
        }
        makeExtensionsImmutable();
    }

    static {
        ProtoBuf$EnumEntry protoBuf$EnumEntry = new ProtoBuf$EnumEntry(true);
        defaultInstance = protoBuf$EnumEntry;
        protoBuf$EnumEntry.initFields();
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) == 1;
    }

    public int getName() {
        return this.name_;
    }

    private void initFields() {
        this.name_ = 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!extensionsAreInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.name_);
        }
        extensionWriterNewExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = ((this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.name_) : 0) + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = iComputeInt32Size;
        return iComputeInt32Size;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder(ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        return newBuilder().mergeFrom(protoBuf$EnumEntry);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder implements MessageLiteOrBuilder {
        private int bitField0_;
        private int name_;

        private void maybeForceBuilderInitialization() {
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$EnumEntry build() {
            ProtoBuf$EnumEntry protoBuf$EnumEntryBuildPartial = buildPartial();
            if (protoBuf$EnumEntryBuildPartial.isInitialized()) {
                return protoBuf$EnumEntryBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$EnumEntryBuildPartial);
        }

        public ProtoBuf$EnumEntry buildPartial() {
            ProtoBuf$EnumEntry protoBuf$EnumEntry = new ProtoBuf$EnumEntry(this);
            int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
            protoBuf$EnumEntry.name_ = this.name_;
            protoBuf$EnumEntry.bitField0_ = i;
            return protoBuf$EnumEntry;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$EnumEntry protoBuf$EnumEntry) {
            if (protoBuf$EnumEntry == ProtoBuf$EnumEntry.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$EnumEntry.hasName()) {
                setName(protoBuf$EnumEntry.getName());
            }
            mergeExtensionFields(protoBuf$EnumEntry);
            setUnknownFields(getUnknownFields().concat(protoBuf$EnumEntry.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$EnumEntry protoBuf$EnumEntry = null;
            try {
                try {
                    ProtoBuf$EnumEntry protoBuf$EnumEntry2 = (ProtoBuf$EnumEntry) ProtoBuf$EnumEntry.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (protoBuf$EnumEntry2 != null) {
                        mergeFrom(protoBuf$EnumEntry2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$EnumEntry protoBuf$EnumEntry3 = (ProtoBuf$EnumEntry) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$EnumEntry = protoBuf$EnumEntry3;
                        if (protoBuf$EnumEntry != null) {
                            mergeFrom(protoBuf$EnumEntry);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$EnumEntry != null) {
                    mergeFrom(protoBuf$EnumEntry);
                }
                throw th;
            }
        }

        public Builder setName(int i) {
            this.bitField0_ |= 1;
            this.name_ = i;
            return this;
        }
    }
}
