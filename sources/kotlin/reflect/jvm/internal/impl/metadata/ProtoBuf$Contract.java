package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoBuf$Contract extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser PARSER = new AbstractParser() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Contract parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Contract(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Contract defaultInstance;
    private List effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    private ProtoBuf$Contract(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Contract(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public static ProtoBuf$Contract getDefaultInstance() {
        return defaultInstance;
    }

    private ProtoBuf$Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output outputNewOutput = ByteString.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag != 10) {
                                if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                }
                            } else {
                                if (!z2) {
                                    this.effect_ = new ArrayList();
                                    z2 = true;
                                }
                                this.effect_.add(codedInputStream.readMessage(ProtoBuf$Effect.PARSER, extensionRegistryLite));
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
                if (z2) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                }
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
        if (z2) {
            this.effect_ = Collections.unmodifiableList(this.effect_);
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
        ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(true);
        defaultInstance = protoBuf$Contract;
        protoBuf$Contract.initFields();
    }

    public int getEffectCount() {
        return this.effect_.size();
    }

    public ProtoBuf$Effect getEffect(int i) {
        return (ProtoBuf$Effect) this.effect_.get(i);
    }

    private void initFields() {
        this.effect_ = Collections.EMPTY_LIST;
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
        for (int i = 0; i < getEffectCount(); i++) {
            if (!getEffect(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.effect_.size(); i++) {
            codedOutputStream.writeMessage(1, (MessageLite) this.effect_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.effect_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, (MessageLite) this.effect_.get(i2));
        }
        int size = iComputeMessageSize + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder(ProtoBuf$Contract protoBuf$Contract) {
        return newBuilder().mergeFrom(protoBuf$Contract);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static final class Builder extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        private int bitField0_;
        private List effect_ = Collections.EMPTY_LIST;

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
        public ProtoBuf$Contract build() {
            ProtoBuf$Contract protoBuf$ContractBuildPartial = buildPartial();
            if (protoBuf$ContractBuildPartial.isInitialized()) {
                return protoBuf$ContractBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$ContractBuildPartial);
        }

        public ProtoBuf$Contract buildPartial() {
            ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(this);
            if ((this.bitField0_ & 1) == 1) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
                this.bitField0_ &= -2;
            }
            protoBuf$Contract.effect_ = this.effect_;
            return protoBuf$Contract;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Contract protoBuf$Contract) {
            if (protoBuf$Contract == ProtoBuf$Contract.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$Contract.effect_.isEmpty()) {
                if (this.effect_.isEmpty()) {
                    this.effect_ = protoBuf$Contract.effect_;
                    this.bitField0_ &= -2;
                } else {
                    ensureEffectIsMutable();
                    this.effect_.addAll(protoBuf$Contract.effect_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$Contract.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$Contract protoBuf$Contract = null;
            try {
                try {
                    ProtoBuf$Contract protoBuf$Contract2 = (ProtoBuf$Contract) ProtoBuf$Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (protoBuf$Contract2 != null) {
                        mergeFrom(protoBuf$Contract2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$Contract protoBuf$Contract3 = (ProtoBuf$Contract) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Contract = protoBuf$Contract3;
                        if (protoBuf$Contract != null) {
                            mergeFrom(protoBuf$Contract);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Contract != null) {
                    mergeFrom(protoBuf$Contract);
                }
                throw th;
            }
        }

        private void ensureEffectIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.effect_ = new ArrayList(this.effect_);
                this.bitField0_ |= 1;
            }
        }
    }
}
