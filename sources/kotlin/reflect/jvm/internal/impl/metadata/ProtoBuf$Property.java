package kotlin.reflect.jvm.internal.impl.metadata;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.utils.EventsFileHelper;
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
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage implements MessageLiteOrBuilder {
    public static Parser PARSER = new AbstractParser() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Property parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Property(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Property defaultInstance;
    private int bitField0_;
    private List compilerPluginData_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List contextReceiverTypeId_;
    private List contextReceiverType_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private int setterFlags_;
    private ProtoBuf$ValueParameter setterValueParameter_;
    private List typeParameter_;
    private final ByteString unknownFields;
    private List versionRequirement_;

    private ProtoBuf$Property(GeneratedMessageLite.ExtendableBuilder extendableBuilder) {
        super(extendableBuilder);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Property(boolean z) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public static ProtoBuf$Property getDefaultInstance() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Property getDefaultInstanceForType() {
        return defaultInstance;
    }

    private ProtoBuf$Property(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
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
                            this.bitField0_ |= 2;
                            this.oldFlags_ = codedInputStream.readInt32();
                            continue;
                        case 16:
                            this.bitField0_ |= 4;
                            this.name_ = codedInputStream.readInt32();
                            continue;
                        case 26:
                            ProtoBuf$Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.returnType_ = protoBuf$Type;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type);
                                this.returnType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue;
                        case 34:
                            int i2 = (i == true ? 1 : 0) & 32;
                            i = i;
                            if (i2 != 32) {
                                this.typeParameter_ = new ArrayList();
                                i = (i == true ? 1 : 0) | 32;
                            }
                            this.typeParameter_.add(codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                            continue;
                        case 42:
                            ProtoBuf$Type.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.receiverType_ = protoBuf$Type2;
                            if (builder2 != null) {
                                builder2.mergeFrom(protoBuf$Type2);
                                this.receiverType_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 32;
                            continue;
                        case 50:
                            ProtoBuf$ValueParameter.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                            ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite);
                            this.setterValueParameter_ = protoBuf$ValueParameter;
                            if (builder3 != null) {
                                builder3.mergeFrom(protoBuf$ValueParameter);
                                this.setterValueParameter_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            continue;
                        case 56:
                            this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                            this.getterFlags_ = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                            this.setterFlags_ = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = codedInputStream.readInt32();
                            continue;
                        case EventsFileHelper.MAX_EVENT_PROPERTY_SIZE /* 80 */:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 88:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            continue;
                        case 98:
                            int i3 = (i == true ? 1 : 0) & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                            i = i;
                            if (i3 != 256) {
                                this.contextReceiverType_ = new ArrayList();
                                i = (i == true ? 1 : 0) | IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                            }
                            this.contextReceiverType_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                            continue;
                        case 104:
                            int i4 = (i == true ? 1 : 0) & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                            i = i;
                            if (i4 != 512) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i = (i == true ? 1 : 0) | IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                            }
                            this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 106:
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i5 = (i == true ? 1 : 0) & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                            i = i;
                            if (i5 != 512 && codedInputStream.getBytesUntilLimit() > 0) {
                                i = i;
                                this.contextReceiverTypeId_ = new ArrayList();
                                i = (i == true ? 1 : 0) | IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                            }
                            i = i;
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit);
                            continue;
                        case 248:
                            int i6 = (i == true ? 1 : 0) & 8192;
                            i = i;
                            if (i6 != 8192) {
                                this.versionRequirement_ = new ArrayList();
                                i = (i == true ? 1 : 0) | 8192;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            int i7 = (i == true ? 1 : 0) & 8192;
                            i = i;
                            if (i7 != 8192 && codedInputStream.getBytesUntilLimit() > 0) {
                                i = i;
                                this.versionRequirement_ = new ArrayList();
                                i = (i == true ? 1 : 0) | 8192;
                            }
                            i = i;
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit2);
                            continue;
                        case 258:
                            int i8 = (i == true ? 1 : 0) & Http2.INITIAL_MAX_FRAME_SIZE;
                            i = i;
                            if (i8 != 16384) {
                                this.compilerPluginData_ = new ArrayList();
                                i = (i == true ? 1 : 0) | Http2.INITIAL_MAX_FRAME_SIZE;
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (((i == true ? 1 : 0) & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if (((i == true ? 1 : 0) & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if (((i == true ? 1 : 0) & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if (((i == true ? 1 : 0) & 8192) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if (((i == true ? 1 : 0) & Http2.INITIAL_MAX_FRAME_SIZE) == 16384) {
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
        }
        if (((i == true ? 1 : 0) & 32) == 32) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if (((i == true ? 1 : 0) & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        }
        if (((i == true ? 1 : 0) & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        }
        if (((i == true ? 1 : 0) & 8192) == 8192) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        if (((i == true ? 1 : 0) & Http2.INITIAL_MAX_FRAME_SIZE) == 16384) {
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
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(true);
        defaultInstance = protoBuf$Property;
        protoBuf$Property.initFields();
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public int getFlags() {
        return this.flags_;
    }

    public boolean hasOldFlags() {
        return (this.bitField0_ & 2) == 2;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 4) == 4;
    }

    public int getName() {
        return this.name_;
    }

    public boolean hasReturnType() {
        return (this.bitField0_ & 8) == 8;
    }

    public ProtoBuf$Type getReturnType() {
        return this.returnType_;
    }

    public boolean hasReturnTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
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

    public boolean hasReceiverType() {
        return (this.bitField0_ & 32) == 32;
    }

    public ProtoBuf$Type getReceiverType() {
        return this.receiverType_;
    }

    public boolean hasReceiverTypeId() {
        return (this.bitField0_ & 64) == 64;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public List getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    public ProtoBuf$Type getContextReceiverType(int i) {
        return (ProtoBuf$Type) this.contextReceiverType_.get(i);
    }

    public List getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public boolean hasSetterValueParameter() {
        return (this.bitField0_ & 128) == 128;
    }

    public ProtoBuf$ValueParameter getSetterValueParameter() {
        return this.setterValueParameter_;
    }

    public boolean hasGetterFlags() {
        return (this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256;
    }

    public int getGetterFlags() {
        return this.getterFlags_;
    }

    public boolean hasSetterFlags() {
        return (this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512;
    }

    public int getSetterFlags() {
        return this.setterFlags_;
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
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        List list = Collections.EMPTY_LIST;
        this.typeParameter_ = list;
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = list;
        this.contextReceiverTypeId_ = list;
        this.setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
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
        if (hasReturnType() && !getReturnType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasReceiverType() && !getReceiverType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
            if (!getContextReceiverType(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
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
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(3, this.returnType_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(4, (MessageLite) this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeMessage(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
            codedOutputStream.writeInt32(7, this.getterFlags_);
        }
        if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
            codedOutputStream.writeInt32(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(11, this.flags_);
        }
        for (int i2 = 0; i2 < this.contextReceiverType_.size(); i2++) {
            codedOutputStream.writeMessage(12, (MessageLite) this.contextReceiverType_.get(i2));
        }
        if (getContextReceiverTypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(106);
            codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i3 = 0; i3 < this.contextReceiverTypeId_.size(); i3++) {
            codedOutputStream.writeInt32NoTag(((Integer) this.contextReceiverTypeId_.get(i3)).intValue());
        }
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            codedOutputStream.writeInt32(31, ((Integer) this.versionRequirement_.get(i4)).intValue());
        }
        for (int i5 = 0; i5 < this.compilerPluginData_.size(); i5++) {
            codedOutputStream.writeMessage(32, (MessageLite) this.compilerPluginData_.get(i5));
        }
        extensionWriterNewExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) : 0;
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, (MessageLite) this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        }
        if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
        }
        for (int i3 = 0; i3 < this.contextReceiverType_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(12, (MessageLite) this.contextReceiverType_.get(i3));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < this.contextReceiverTypeId_.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.contextReceiverTypeId_.get(i4)).intValue());
        }
        int iComputeInt32SizeNoTag2 = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getContextReceiverTypeIdList().isEmpty()) {
            iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        int iComputeInt32SizeNoTag3 = 0;
        for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
            iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.versionRequirement_.get(i5)).intValue());
        }
        int size = iComputeInt32SizeNoTag2 + iComputeInt32SizeNoTag3 + (getVersionRequirementList().size() * 2);
        for (int i6 = 0; i6 < this.compilerPluginData_.size(); i6++) {
            size += CodedOutputStream.computeMessageSize(32, (MessageLite) this.compilerPluginData_.get(i6));
        }
        int iExtensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = iExtensionsSerializedSize;
        return iExtensionsSerializedSize;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder(ProtoBuf$Property protoBuf$Property) {
        return newBuilder().mergeFrom(protoBuf$Property);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder implements MessageLiteOrBuilder {
        private int bitField0_;
        private List compilerPluginData_;
        private List contextReceiverTypeId_;
        private List contextReceiverType_;
        private int getterFlags_;
        private int name_;
        private int receiverTypeId_;
        private ProtoBuf$Type receiverType_;
        private int returnTypeId_;
        private int setterFlags_;
        private ProtoBuf$ValueParameter setterValueParameter_;
        private List typeParameter_;
        private List versionRequirement_;
        private int flags_ = 518;
        private int oldFlags_ = 2054;
        private ProtoBuf$Type returnType_ = ProtoBuf$Type.getDefaultInstance();

        private void maybeForceBuilderInitialization() {
        }

        private Builder() {
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
            this.contextReceiverType_ = list;
            this.contextReceiverTypeId_ = list;
            this.setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
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
        public ProtoBuf$Property build() {
            ProtoBuf$Property protoBuf$PropertyBuildPartial = buildPartial();
            if (protoBuf$PropertyBuildPartial.isInitialized()) {
                return protoBuf$PropertyBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$PropertyBuildPartial);
        }

        public ProtoBuf$Property buildPartial() {
            ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 1 ? 0 : 1;
            protoBuf$Property.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Property.oldFlags_ = this.oldFlags_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Property.name_ = this.name_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Property.returnType_ = this.returnType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Property.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Property.typeParameter_ = this.typeParameter_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Property.receiverType_ = this.receiverType_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Property.receiverTypeId_ = this.receiverTypeId_;
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            }
            protoBuf$Property.contextReceiverType_ = this.contextReceiverType_;
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -513;
            }
            protoBuf$Property.contextReceiverTypeId_ = this.contextReceiverTypeId_;
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 1024) {
                i2 |= 128;
            }
            protoBuf$Property.setterValueParameter_ = this.setterValueParameter_;
            if ((i & 2048) == 2048) {
                i2 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            }
            protoBuf$Property.getterFlags_ = this.getterFlags_;
            if ((i & 4096) == 4096) {
                i2 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
            }
            protoBuf$Property.setterFlags_ = this.setterFlags_;
            if ((this.bitField0_ & 8192) == 8192) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -8193;
            }
            protoBuf$Property.versionRequirement_ = this.versionRequirement_;
            if ((this.bitField0_ & Http2.INITIAL_MAX_FRAME_SIZE) == 16384) {
                this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                this.bitField0_ &= -16385;
            }
            protoBuf$Property.compilerPluginData_ = this.compilerPluginData_;
            protoBuf$Property.bitField0_ = i2;
            return protoBuf$Property;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Property protoBuf$Property) {
            if (protoBuf$Property == ProtoBuf$Property.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Property.hasFlags()) {
                setFlags(protoBuf$Property.getFlags());
            }
            if (protoBuf$Property.hasOldFlags()) {
                setOldFlags(protoBuf$Property.getOldFlags());
            }
            if (protoBuf$Property.hasName()) {
                setName(protoBuf$Property.getName());
            }
            if (protoBuf$Property.hasReturnType()) {
                mergeReturnType(protoBuf$Property.getReturnType());
            }
            if (protoBuf$Property.hasReturnTypeId()) {
                setReturnTypeId(protoBuf$Property.getReturnTypeId());
            }
            if (!protoBuf$Property.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Property.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Property.typeParameter_);
                }
            }
            if (protoBuf$Property.hasReceiverType()) {
                mergeReceiverType(protoBuf$Property.getReceiverType());
            }
            if (protoBuf$Property.hasReceiverTypeId()) {
                setReceiverTypeId(protoBuf$Property.getReceiverTypeId());
            }
            if (!protoBuf$Property.contextReceiverType_.isEmpty()) {
                if (this.contextReceiverType_.isEmpty()) {
                    this.contextReceiverType_ = protoBuf$Property.contextReceiverType_;
                    this.bitField0_ &= -257;
                } else {
                    ensureContextReceiverTypeIsMutable();
                    this.contextReceiverType_.addAll(protoBuf$Property.contextReceiverType_);
                }
            }
            if (!protoBuf$Property.contextReceiverTypeId_.isEmpty()) {
                if (this.contextReceiverTypeId_.isEmpty()) {
                    this.contextReceiverTypeId_ = protoBuf$Property.contextReceiverTypeId_;
                    this.bitField0_ &= -513;
                } else {
                    ensureContextReceiverTypeIdIsMutable();
                    this.contextReceiverTypeId_.addAll(protoBuf$Property.contextReceiverTypeId_);
                }
            }
            if (protoBuf$Property.hasSetterValueParameter()) {
                mergeSetterValueParameter(protoBuf$Property.getSetterValueParameter());
            }
            if (protoBuf$Property.hasGetterFlags()) {
                setGetterFlags(protoBuf$Property.getGetterFlags());
            }
            if (protoBuf$Property.hasSetterFlags()) {
                setSetterFlags(protoBuf$Property.getSetterFlags());
            }
            if (!protoBuf$Property.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Property.versionRequirement_;
                    this.bitField0_ &= -8193;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Property.versionRequirement_);
                }
            }
            if (!protoBuf$Property.compilerPluginData_.isEmpty()) {
                if (this.compilerPluginData_.isEmpty()) {
                    this.compilerPluginData_ = protoBuf$Property.compilerPluginData_;
                    this.bitField0_ &= -16385;
                } else {
                    ensureCompilerPluginDataIsMutable();
                    this.compilerPluginData_.addAll(protoBuf$Property.compilerPluginData_);
                }
            }
            mergeExtensionFields(protoBuf$Property);
            setUnknownFields(getUnknownFields().concat(protoBuf$Property.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$Property protoBuf$Property = null;
            try {
                try {
                    ProtoBuf$Property protoBuf$Property2 = (ProtoBuf$Property) ProtoBuf$Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (protoBuf$Property2 != null) {
                        mergeFrom(protoBuf$Property2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$Property protoBuf$Property3 = (ProtoBuf$Property) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Property = protoBuf$Property3;
                        if (protoBuf$Property != null) {
                            mergeFrom(protoBuf$Property);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Property != null) {
                    mergeFrom(protoBuf$Property);
                }
                throw th;
            }
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setOldFlags(int i) {
            this.bitField0_ |= 2;
            this.oldFlags_ = i;
            return this;
        }

        public Builder setName(int i) {
            this.bitField0_ |= 4;
            this.name_ = i;
            return this;
        }

        public Builder mergeReturnType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) == 8 && this.returnType_ != ProtoBuf$Type.getDefaultInstance()) {
                this.returnType_ = ProtoBuf$Type.newBuilder(this.returnType_).mergeFrom(protoBuf$Type).buildPartial();
            } else {
                this.returnType_ = protoBuf$Type;
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder setReturnTypeId(int i) {
            this.bitField0_ |= 16;
            this.returnTypeId_ = i;
            return this;
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
            }
        }

        public Builder mergeReceiverType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 64) == 64 && this.receiverType_ != ProtoBuf$Type.getDefaultInstance()) {
                this.receiverType_ = ProtoBuf$Type.newBuilder(this.receiverType_).mergeFrom(protoBuf$Type).buildPartial();
            } else {
                this.receiverType_ = protoBuf$Type;
            }
            this.bitField0_ |= 64;
            return this;
        }

        public Builder setReceiverTypeId(int i) {
            this.bitField0_ |= 128;
            this.receiverTypeId_ = i;
            return this;
        }

        private void ensureContextReceiverTypeIsMutable() {
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 256) {
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            }
        }

        private void ensureContextReceiverTypeIdIsMutable() {
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 512) {
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
            }
        }

        public Builder mergeSetterValueParameter(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 1024 && this.setterValueParameter_ != ProtoBuf$ValueParameter.getDefaultInstance()) {
                this.setterValueParameter_ = ProtoBuf$ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(protoBuf$ValueParameter).buildPartial();
            } else {
                this.setterValueParameter_ = protoBuf$ValueParameter;
            }
            this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
            return this;
        }

        public Builder setGetterFlags(int i) {
            this.bitField0_ |= 2048;
            this.getterFlags_ = i;
            return this;
        }

        public Builder setSetterFlags(int i) {
            this.bitField0_ |= 4096;
            this.setterFlags_ = i;
            return this;
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 8192) != 8192) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 8192;
            }
        }

        private void ensureCompilerPluginDataIsMutable() {
            if ((this.bitField0_ & Http2.INITIAL_MAX_FRAME_SIZE) != 16384) {
                this.compilerPluginData_ = new ArrayList(this.compilerPluginData_);
                this.bitField0_ |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
        }
    }
}
