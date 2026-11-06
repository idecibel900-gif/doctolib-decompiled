package kotlin.reflect.jvm.internal.impl.metadata;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.IOException;
import java.io.InputStream;
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
public final class ProtoBuf$TypeAlias extends GeneratedMessageLite.ExtendableMessage implements MessageLiteOrBuilder {
    public static Parser PARSER = new AbstractParser() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$TypeAlias parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$TypeAlias(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$TypeAlias defaultInstance;
    private List annotation_;
    private int bitField0_;
    private List compilerPluginData_;
    private int expandedTypeId_;
    private ProtoBuf$Type expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List typeParameter_;
    private int underlyingTypeId_;
    private ProtoBuf$Type underlyingType_;
    private final ByteString unknownFields;
    private List versionRequirement_;

    private ProtoBuf$TypeAlias(GeneratedMessageLite.ExtendableBuilder extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$TypeAlias(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public static ProtoBuf$TypeAlias getDefaultInstance() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeAlias getDefaultInstanceForType() {
        return defaultInstance;
    }

    private ProtoBuf$TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoBuf$Type.Builder builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output outputNewOutput = ByteString.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
        boolean z = false;
        int i = 0;
        while (!z) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            continue;
                        case 16:
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                            continue;
                        case 26:
                            if ((i & 4) != 4) {
                                this.typeParameter_ = new ArrayList();
                                i |= 4;
                            }
                            this.typeParameter_.add(codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                            continue;
                        case 34:
                            builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.underlyingType_ = protoBuf$Type;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type);
                                this.underlyingType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue;
                        case 40:
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 50:
                            builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.expandedType_ = protoBuf$Type2;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type2);
                                this.expandedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            continue;
                        case 56:
                            this.bitField0_ |= 32;
                            this.expandedTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 66:
                            if ((i & 128) != 128) {
                                this.annotation_ = new ArrayList();
                                i |= 128;
                            }
                            this.annotation_.add(codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            continue;
                        case 248:
                            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 256) {
                                this.versionRequirement_ = new ArrayList();
                                i |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 256 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit);
                            continue;
                        case 258:
                            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 512) {
                                this.compilerPluginData_ = new ArrayList();
                                i |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                            }
                            this.compilerPluginData_.add(codedInputStream.readMessage(ProtoBuf$CompilerPluginData.PARSER, extensionRegistryLite));
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                break;
                            }
                            break;
                    }
                    z = true;
                } catch (Throwable th) {
                    if ((i & 4) == 4) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i & 128) == 128) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
                        this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
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
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((i & 4) == 4) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i & 128) == 128) {
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
            this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
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
        ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(true);
        defaultInstance = protoBuf$TypeAlias;
        protoBuf$TypeAlias.initFields();
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public int getFlags() {
        return this.flags_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public int getName() {
        return this.name_;
    }

    public List getTypeParameterList() {
        return this.typeParameter_;
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public ProtoBuf$TypeParameter getTypeParameter(int i) {
        return (ProtoBuf$TypeParameter) this.typeParameter_.get(i);
    }

    public boolean hasUnderlyingType() {
        return (this.bitField0_ & 4) == 4;
    }

    public ProtoBuf$Type getUnderlyingType() {
        return this.underlyingType_;
    }

    public boolean hasUnderlyingTypeId() {
        return (this.bitField0_ & 8) == 8;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
    }

    public boolean hasExpandedType() {
        return (this.bitField0_ & 16) == 16;
    }

    public ProtoBuf$Type getExpandedType() {
        return this.expandedType_;
    }

    public boolean hasExpandedTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    public int getExpandedTypeId() {
        return this.expandedTypeId_;
    }

    public List getAnnotationList() {
        return this.annotation_;
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public ProtoBuf$Annotation getAnnotation(int i) {
        return (ProtoBuf$Annotation) this.annotation_.get(i);
    }

    public List getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public int getCompilerPluginDataCount() {
        return this.compilerPluginData_.size();
    }

    public ProtoBuf$CompilerPluginData getCompilerPluginData(int i) {
        return (ProtoBuf$CompilerPluginData) this.compilerPluginData_.get(i);
    }

    private void initFields() {
        this.flags_ = 6;
        this.name_ = 0;
        List list = Collections.EMPTY_LIST;
        this.typeParameter_ = list;
        this.underlyingType_ = ProtoBuf$Type.getDefaultInstance();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = ProtoBuf$Type.getDefaultInstance();
        this.expandedTypeId_ = 0;
        this.annotation_ = list;
        this.versionRequirement_ = list;
        this.compilerPluginData_ = list;
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasExpandedType() && !getExpandedType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
            if (!getAnnotation(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getCompilerPluginDataCount(); i3++) {
            if (!getCompilerPluginData(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
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
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(3, (MessageLite) this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.expandedTypeId_);
        }
        for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
            codedOutputStream.writeMessage(8, (MessageLite) this.annotation_.get(i2));
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.writeInt32(31, ((Integer) this.versionRequirement_.get(i3)).intValue());
        }
        for (int i4 = 0; i4 < this.compilerPluginData_.size(); i4++) {
            codedOutputStream.writeMessage(32, (MessageLite) this.compilerPluginData_.get(i4));
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
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, (MessageLite) this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        }
        for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(8, (MessageLite) this.annotation_.get(i3));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.versionRequirement_.get(i4)).intValue());
        }
        int size = iComputeInt32Size + iComputeInt32SizeNoTag + (getVersionRequirementList().size() * 2);
        for (int i5 = 0; i5 < this.compilerPluginData_.size(); i5++) {
            size += CodedOutputStream.computeMessageSize(32, (MessageLite) this.compilerPluginData_.get(i5));
        }
        int iExtensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = iExtensionsSerializedSize;
        return iExtensionsSerializedSize;
    }

    public static ProtoBuf$TypeAlias parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ProtoBuf$TypeAlias) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        return newBuilder().mergeFrom(protoBuf$TypeAlias);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder implements MessageLiteOrBuilder {
        private List annotation_;
        private int bitField0_;
        private List compilerPluginData_;
        private int expandedTypeId_;
        private ProtoBuf$Type expandedType_;
        private int flags_ = 6;
        private int name_;
        private List typeParameter_;
        private int underlyingTypeId_;
        private ProtoBuf$Type underlyingType_;
        private List versionRequirement_;

        private void maybeForceBuilderInitialization() {
        }

        private Builder() {
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.underlyingType_ = ProtoBuf$Type.getDefaultInstance();
            this.expandedType_ = ProtoBuf$Type.getDefaultInstance();
            this.annotation_ = list;
            this.versionRequirement_ = list;
            this.compilerPluginData_ = list;
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
        public ProtoBuf$TypeAlias build() {
            ProtoBuf$TypeAlias protoBuf$TypeAliasBuildPartial = buildPartial();
            if (protoBuf$TypeAliasBuildPartial.isInitialized()) {
                return protoBuf$TypeAliasBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$TypeAliasBuildPartial);
        }

        public ProtoBuf$TypeAlias buildPartial() {
            ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 1 ? 0 : 1;
            protoBuf$TypeAlias.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$TypeAlias.name_ = this.name_;
            if ((this.bitField0_ & 4) == 4) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            }
            protoBuf$TypeAlias.typeParameter_ = this.typeParameter_;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            protoBuf$TypeAlias.underlyingType_ = this.underlyingType_;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            protoBuf$TypeAlias.underlyingTypeId_ = this.underlyingTypeId_;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            protoBuf$TypeAlias.expandedType_ = this.expandedType_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$TypeAlias.expandedTypeId_ = this.expandedTypeId_;
            if ((this.bitField0_ & 128) == 128) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            }
            protoBuf$TypeAlias.annotation_ = this.annotation_;
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            }
            protoBuf$TypeAlias.versionRequirement_ = this.versionRequirement_;
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
                this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                this.bitField0_ &= -513;
            }
            protoBuf$TypeAlias.compilerPluginData_ = this.compilerPluginData_;
            protoBuf$TypeAlias.bitField0_ = i2;
            return protoBuf$TypeAlias;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
            if (protoBuf$TypeAlias == ProtoBuf$TypeAlias.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$TypeAlias.hasFlags()) {
                setFlags(protoBuf$TypeAlias.getFlags());
            }
            if (protoBuf$TypeAlias.hasName()) {
                setName(protoBuf$TypeAlias.getName());
            }
            if (!protoBuf$TypeAlias.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$TypeAlias.typeParameter_;
                    this.bitField0_ &= -5;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$TypeAlias.typeParameter_);
                }
            }
            if (protoBuf$TypeAlias.hasUnderlyingType()) {
                mergeUnderlyingType(protoBuf$TypeAlias.getUnderlyingType());
            }
            if (protoBuf$TypeAlias.hasUnderlyingTypeId()) {
                setUnderlyingTypeId(protoBuf$TypeAlias.getUnderlyingTypeId());
            }
            if (protoBuf$TypeAlias.hasExpandedType()) {
                mergeExpandedType(protoBuf$TypeAlias.getExpandedType());
            }
            if (protoBuf$TypeAlias.hasExpandedTypeId()) {
                setExpandedTypeId(protoBuf$TypeAlias.getExpandedTypeId());
            }
            if (!protoBuf$TypeAlias.annotation_.isEmpty()) {
                if (this.annotation_.isEmpty()) {
                    this.annotation_ = protoBuf$TypeAlias.annotation_;
                    this.bitField0_ &= -129;
                } else {
                    ensureAnnotationIsMutable();
                    this.annotation_.addAll(protoBuf$TypeAlias.annotation_);
                }
            }
            if (!protoBuf$TypeAlias.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$TypeAlias.versionRequirement_;
                    this.bitField0_ &= -257;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$TypeAlias.versionRequirement_);
                }
            }
            if (!protoBuf$TypeAlias.compilerPluginData_.isEmpty()) {
                if (this.compilerPluginData_.isEmpty()) {
                    this.compilerPluginData_ = protoBuf$TypeAlias.compilerPluginData_;
                    this.bitField0_ &= -513;
                } else {
                    ensureCompilerPluginDataIsMutable();
                    this.compilerPluginData_.addAll(protoBuf$TypeAlias.compilerPluginData_);
                }
            }
            mergeExtensionFields(protoBuf$TypeAlias);
            setUnknownFields(getUnknownFields().concat(protoBuf$TypeAlias.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$TypeAlias protoBuf$TypeAlias = null;
            try {
                try {
                    ProtoBuf$TypeAlias protoBuf$TypeAlias2 = (ProtoBuf$TypeAlias) ProtoBuf$TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (protoBuf$TypeAlias2 != null) {
                        mergeFrom(protoBuf$TypeAlias2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$TypeAlias protoBuf$TypeAlias3 = (ProtoBuf$TypeAlias) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$TypeAlias = protoBuf$TypeAlias3;
                        if (protoBuf$TypeAlias != null) {
                            mergeFrom(protoBuf$TypeAlias);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$TypeAlias != null) {
                    mergeFrom(protoBuf$TypeAlias);
                }
                throw th;
            }
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setName(int i) {
            this.bitField0_ |= 2;
            this.name_ = i;
            return this;
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 4) != 4) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 4;
            }
        }

        public Builder mergeUnderlyingType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) == 8 && this.underlyingType_ != ProtoBuf$Type.getDefaultInstance()) {
                this.underlyingType_ = ProtoBuf$Type.newBuilder(this.underlyingType_).mergeFrom(protoBuf$Type).buildPartial();
            } else {
                this.underlyingType_ = protoBuf$Type;
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder setUnderlyingTypeId(int i) {
            this.bitField0_ |= 16;
            this.underlyingTypeId_ = i;
            return this;
        }

        public Builder mergeExpandedType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 32) == 32 && this.expandedType_ != ProtoBuf$Type.getDefaultInstance()) {
                this.expandedType_ = ProtoBuf$Type.newBuilder(this.expandedType_).mergeFrom(protoBuf$Type).buildPartial();
            } else {
                this.expandedType_ = protoBuf$Type;
            }
            this.bitField0_ |= 32;
            return this;
        }

        public Builder setExpandedTypeId(int i) {
            this.bitField0_ |= 64;
            this.expandedTypeId_ = i;
            return this;
        }

        private void ensureAnnotationIsMutable() {
            if ((this.bitField0_ & 128) != 128) {
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= 128;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 256) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            }
        }

        private void ensureCompilerPluginDataIsMutable() {
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 512) {
                this.compilerPluginData_ = new ArrayList(this.compilerPluginData_);
                this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
            }
        }
    }
}
