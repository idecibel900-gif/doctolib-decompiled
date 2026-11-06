package kotlin.reflect.jvm.internal.impl.metadata;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoBuf$Annotation extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser PARSER = new AbstractParser() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Annotation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Annotation(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Annotation defaultInstance;
    private List argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    private ProtoBuf$Annotation(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Annotation(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    public static ProtoBuf$Annotation getDefaultInstance() {
        return defaultInstance;
    }

    private ProtoBuf$Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output outputNewOutput = ByteString.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
        boolean z = false;
        char c = 0;
        while (!z) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.id_ = codedInputStream.readInt32();
                        } else if (tag != 18) {
                            if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                            }
                        } else {
                            if ((c & 2) != 2) {
                                this.argument_ = new ArrayList();
                                c = 2;
                            }
                            this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if ((c & 2) == 2) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
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
        if ((c & 2) == 2) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
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
        ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(true);
        defaultInstance = protoBuf$Annotation;
        protoBuf$Annotation.initFields();
    }

    public static final class Argument extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser PARSER = new AbstractParser() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new Argument(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Argument defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final ByteString unknownFields;
        private Value value_;

        private Argument(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Argument(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Argument getDefaultInstance() {
            return defaultInstance;
        }

        private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output outputNewOutput = ByteString.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.nameId_ = codedInputStream.readInt32();
                            } else if (tag != 18) {
                                if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                }
                            } else {
                                Value.Builder builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                Value value = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                                this.value_ = value;
                                if (builder != null) {
                                    builder.mergeFrom(value);
                                    this.value_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            }
                        }
                        z = true;
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
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
            Argument argument = new Argument(true);
            defaultInstance = argument;
            argument.initFields();
        }

        public static final class Value extends GeneratedMessageLite implements MessageLiteOrBuilder {
            public static Parser PARSER = new AbstractParser() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.1
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return new Value(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Value defaultInstance;
            private ProtoBuf$Annotation annotation_;
            private int arrayDimensionCount_;
            private List arrayElement_;
            private int bitField0_;
            private int classId_;
            private double doubleValue_;
            private int enumValueId_;
            private int flags_;
            private float floatValue_;
            private long intValue_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int stringValue_;
            private Type type_;
            private final ByteString unknownFields;

            private Value(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Value(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            public static Value getDefaultInstance() {
                return defaultInstance;
            }

            private Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output outputNewOutput = ByteString.newOutput();
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
                boolean z = false;
                char c = 0;
                while (!z) {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            switch (tag) {
                                case 0:
                                    break;
                                case 8:
                                    int i = codedInputStream.readEnum();
                                    Type typeValueOf = Type.valueOf(i);
                                    if (typeValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.type_ = typeValueOf;
                                        continue;
                                    }
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.intValue_ = codedInputStream.readSInt64();
                                    continue;
                                case 29:
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = codedInputStream.readFloat();
                                    continue;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = codedInputStream.readDouble();
                                    continue;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = codedInputStream.readInt32();
                                    continue;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.classId_ = codedInputStream.readInt32();
                                    continue;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.enumValueId_ = codedInputStream.readInt32();
                                    continue;
                                case 66:
                                    Builder builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                    ProtoBuf$Annotation protoBuf$Annotation = (ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite);
                                    this.annotation_ = protoBuf$Annotation;
                                    if (builder != null) {
                                        builder.mergeFrom(protoBuf$Annotation);
                                        this.annotation_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    continue;
                                case 74:
                                    if ((c & 256) != 256) {
                                        this.arrayElement_ = new ArrayList();
                                        c = 256;
                                    }
                                    this.arrayElement_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                    continue;
                                case EventsFileHelper.MAX_EVENT_PROPERTY_SIZE /* 80 */:
                                    this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                                    this.flags_ = codedInputStream.readInt32();
                                    continue;
                                case 88:
                                    this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                                    this.arrayDimensionCount_ = codedInputStream.readInt32();
                                    continue;
                                default:
                                    if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                        break;
                                    }
                                    break;
                            }
                            z = true;
                        } catch (Throwable th) {
                            if ((c & 256) == 256) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                if ((c & 256) == 256) {
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                Value value = new Value(true);
                defaultInstance = value;
                value.initFields();
            }

            public enum Type implements Internal.EnumLite {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);

                private static Internal.EnumLiteMap internalValueMap = new Internal.EnumLiteMap() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.1
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                    public Type findValueByNumber(int i) {
                        return Type.valueOf(i);
                    }
                };
                private final int value;

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Type valueOf(int i) {
                    switch (i) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case BaseVideoCapturer.RGBA /* 11 */:
                            return ANNOTATION;
                        case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                            return ARRAY;
                        default:
                            return null;
                    }
                }

                Type(int i, int i2) {
                    this.value = i2;
                }
            }

            public boolean hasType() {
                return (this.bitField0_ & 1) == 1;
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasIntValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public long getIntValue() {
                return this.intValue_;
            }

            public boolean hasFloatValue() {
                return (this.bitField0_ & 4) == 4;
            }

            public float getFloatValue() {
                return this.floatValue_;
            }

            public boolean hasDoubleValue() {
                return (this.bitField0_ & 8) == 8;
            }

            public double getDoubleValue() {
                return this.doubleValue_;
            }

            public boolean hasStringValue() {
                return (this.bitField0_ & 16) == 16;
            }

            public int getStringValue() {
                return this.stringValue_;
            }

            public boolean hasClassId() {
                return (this.bitField0_ & 32) == 32;
            }

            public int getClassId() {
                return this.classId_;
            }

            public boolean hasEnumValueId() {
                return (this.bitField0_ & 64) == 64;
            }

            public int getEnumValueId() {
                return this.enumValueId_;
            }

            public boolean hasAnnotation() {
                return (this.bitField0_ & 128) == 128;
            }

            public ProtoBuf$Annotation getAnnotation() {
                return this.annotation_;
            }

            public List getArrayElementList() {
                return this.arrayElement_;
            }

            public int getArrayElementCount() {
                return this.arrayElement_.size();
            }

            public Value getArrayElement(int i) {
                return (Value) this.arrayElement_.get(i);
            }

            public boolean hasArrayDimensionCount() {
                return (this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256;
            }

            public int getArrayDimensionCount() {
                return this.arrayDimensionCount_;
            }

            public boolean hasFlags() {
                return (this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512;
            }

            public int getFlags() {
                return this.flags_;
            }

            private void initFields() {
                this.type_ = Type.BYTE;
                this.intValue_ = 0L;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                this.arrayElement_ = Collections.EMPTY_LIST;
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
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
                if (hasAnnotation() && !getAnnotation().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i = 0; i < getArrayElementCount(); i++) {
                    if (!getArrayElement(i).isInitialized()) {
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
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.type_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeSInt64(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeFloat(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeDouble(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.annotation_);
                }
                for (int i = 0; i < this.arrayElement_.size(); i++) {
                    codedOutputStream.writeMessage(9, (MessageLite) this.arrayElement_.get(i));
                }
                if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
                    codedOutputStream.writeInt32(10, this.flags_);
                }
                if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
                    codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i != -1) {
                    return i;
                }
                int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iComputeEnumSize += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    iComputeEnumSize += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iComputeEnumSize += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    iComputeEnumSize += CodedOutputStream.computeMessageSize(8, this.annotation_);
                }
                for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
                    iComputeEnumSize += CodedOutputStream.computeMessageSize(9, (MessageLite) this.arrayElement_.get(i2));
                }
                if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(10, this.flags_);
                }
                if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
                    iComputeEnumSize += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                }
                int size = iComputeEnumSize + this.unknownFields.size();
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

            public static Builder newBuilder(Value value) {
                return newBuilder().mergeFrom(value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            public static final class Builder extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
                private int arrayDimensionCount_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private int stringValue_;
                private Type type_ = Type.BYTE;
                private ProtoBuf$Annotation annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                private List arrayElement_ = Collections.EMPTY_LIST;

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
                public Value build() {
                    Value valueBuildPartial = buildPartial();
                    if (valueBuildPartial.isInitialized()) {
                        return valueBuildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(valueBuildPartial);
                }

                public Value buildPartial() {
                    Value value = new Value(this);
                    int i = this.bitField0_;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    value.type_ = this.type_;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    value.intValue_ = this.intValue_;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    value.floatValue_ = this.floatValue_;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    value.doubleValue_ = this.doubleValue_;
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    value.stringValue_ = this.stringValue_;
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    value.classId_ = this.classId_;
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    value.enumValueId_ = this.enumValueId_;
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    value.annotation_ = this.annotation_;
                    if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 256) {
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    }
                    value.arrayElement_ = this.arrayElement_;
                    if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 512) {
                        i2 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                    }
                    value.arrayDimensionCount_ = this.arrayDimensionCount_;
                    if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 1024) {
                        i2 |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                    }
                    value.flags_ = this.flags_;
                    value.bitField0_ = i2;
                    return value;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(Value value) {
                    if (value == Value.getDefaultInstance()) {
                        return this;
                    }
                    if (value.hasType()) {
                        setType(value.getType());
                    }
                    if (value.hasIntValue()) {
                        setIntValue(value.getIntValue());
                    }
                    if (value.hasFloatValue()) {
                        setFloatValue(value.getFloatValue());
                    }
                    if (value.hasDoubleValue()) {
                        setDoubleValue(value.getDoubleValue());
                    }
                    if (value.hasStringValue()) {
                        setStringValue(value.getStringValue());
                    }
                    if (value.hasClassId()) {
                        setClassId(value.getClassId());
                    }
                    if (value.hasEnumValueId()) {
                        setEnumValueId(value.getEnumValueId());
                    }
                    if (value.hasAnnotation()) {
                        mergeAnnotation(value.getAnnotation());
                    }
                    if (!value.arrayElement_.isEmpty()) {
                        if (this.arrayElement_.isEmpty()) {
                            this.arrayElement_ = value.arrayElement_;
                            this.bitField0_ &= -257;
                        } else {
                            ensureArrayElementIsMutable();
                            this.arrayElement_.addAll(value.arrayElement_);
                        }
                    }
                    if (value.hasArrayDimensionCount()) {
                        setArrayDimensionCount(value.getArrayDimensionCount());
                    }
                    if (value.hasFlags()) {
                        setFlags(value.getFlags());
                    }
                    setUnknownFields(getUnknownFields().concat(value.unknownFields));
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                    Value value = null;
                    try {
                        try {
                            Value value2 = (Value) Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (value2 != null) {
                                mergeFrom(value2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Value value3 = (Value) e.getUnfinishedMessage();
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                value = value3;
                                if (value != null) {
                                    mergeFrom(value);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (value != null) {
                            mergeFrom(value);
                        }
                        throw th;
                    }
                }

                public Builder setType(Type type) {
                    type.getClass();
                    this.bitField0_ |= 1;
                    this.type_ = type;
                    return this;
                }

                public Builder setIntValue(long j) {
                    this.bitField0_ |= 2;
                    this.intValue_ = j;
                    return this;
                }

                public Builder setFloatValue(float f) {
                    this.bitField0_ |= 4;
                    this.floatValue_ = f;
                    return this;
                }

                public Builder setDoubleValue(double d) {
                    this.bitField0_ |= 8;
                    this.doubleValue_ = d;
                    return this;
                }

                public Builder setStringValue(int i) {
                    this.bitField0_ |= 16;
                    this.stringValue_ = i;
                    return this;
                }

                public Builder setClassId(int i) {
                    this.bitField0_ |= 32;
                    this.classId_ = i;
                    return this;
                }

                public Builder setEnumValueId(int i) {
                    this.bitField0_ |= 64;
                    this.enumValueId_ = i;
                    return this;
                }

                public Builder mergeAnnotation(ProtoBuf$Annotation protoBuf$Annotation) {
                    if ((this.bitField0_ & 128) == 128 && this.annotation_ != ProtoBuf$Annotation.getDefaultInstance()) {
                        this.annotation_ = ProtoBuf$Annotation.newBuilder(this.annotation_).mergeFrom(protoBuf$Annotation).buildPartial();
                    } else {
                        this.annotation_ = protoBuf$Annotation;
                    }
                    this.bitField0_ |= 128;
                    return this;
                }

                private void ensureArrayElementIsMutable() {
                    if ((this.bitField0_ & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 256) {
                        this.arrayElement_ = new ArrayList(this.arrayElement_);
                        this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                    }
                }

                public Builder setArrayDimensionCount(int i) {
                    this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                    this.arrayDimensionCount_ = i;
                    return this;
                }

                public Builder setFlags(int i) {
                    this.bitField0_ |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                    this.flags_ = i;
                    return this;
                }
            }
        }

        public boolean hasNameId() {
            return (this.bitField0_ & 1) == 1;
        }

        public int getNameId() {
            return this.nameId_;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public Value getValue() {
            return this.value_;
        }

        private void initFields() {
            this.nameId_ = 0;
            this.value_ = Value.getDefaultInstance();
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
            if (!hasNameId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasValue()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!getValue().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.value_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.nameId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.value_);
            }
            int size = iComputeInt32Size + this.unknownFields.size();
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

        public static Builder newBuilder(Argument argument) {
            return newBuilder().mergeFrom(argument);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static final class Builder extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
            private int bitField0_;
            private int nameId_;
            private Value value_ = Value.getDefaultInstance();

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
            public Argument build() {
                Argument argumentBuildPartial = buildPartial();
                if (argumentBuildPartial.isInitialized()) {
                    return argumentBuildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(argumentBuildPartial);
            }

            public Argument buildPartial() {
                Argument argument = new Argument(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 1 ? 0 : 1;
                argument.nameId_ = this.nameId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                argument.value_ = this.value_;
                argument.bitField0_ = i2;
                return argument;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Argument argument) {
                if (argument == Argument.getDefaultInstance()) {
                    return this;
                }
                if (argument.hasNameId()) {
                    setNameId(argument.getNameId());
                }
                if (argument.hasValue()) {
                    mergeValue(argument.getValue());
                }
                setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                Argument argument = null;
                try {
                    try {
                        Argument argument2 = (Argument) Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (argument2 != null) {
                            mergeFrom(argument2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Argument argument3 = (Argument) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            argument = argument3;
                            if (argument != null) {
                                mergeFrom(argument);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (argument != null) {
                        mergeFrom(argument);
                    }
                    throw th;
                }
            }

            public Builder setNameId(int i) {
                this.bitField0_ |= 1;
                this.nameId_ = i;
                return this;
            }

            public Builder mergeValue(Value value) {
                if ((this.bitField0_ & 2) == 2 && this.value_ != Value.getDefaultInstance()) {
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                } else {
                    this.value_ = value;
                }
                this.bitField0_ |= 2;
                return this;
            }
        }
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) == 1;
    }

    public int getId() {
        return this.id_;
    }

    public List getArgumentList() {
        return this.argument_;
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public Argument getArgument(int i) {
        return (Argument) this.argument_.get(i);
    }

    private void initFields() {
        this.id_ = 0;
        this.argument_ = Collections.EMPTY_LIST;
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
        if (!hasId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getArgumentCount(); i++) {
            if (!getArgument(i).isInitialized()) {
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.id_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.writeMessage(2, (MessageLite) this.argument_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.argument_.get(i2));
        }
        int size = iComputeInt32Size + this.unknownFields.size();
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

    public static Builder newBuilder(ProtoBuf$Annotation protoBuf$Annotation) {
        return newBuilder().mergeFrom(protoBuf$Annotation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static final class Builder extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        private List argument_ = Collections.EMPTY_LIST;
        private int bitField0_;
        private int id_;

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
        public ProtoBuf$Annotation build() {
            ProtoBuf$Annotation protoBuf$AnnotationBuildPartial = buildPartial();
            if (protoBuf$AnnotationBuildPartial.isInitialized()) {
                return protoBuf$AnnotationBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$AnnotationBuildPartial);
        }

        public ProtoBuf$Annotation buildPartial() {
            ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(this);
            int i = (this.bitField0_ & 1) != 1 ? 0 : 1;
            protoBuf$Annotation.id_ = this.id_;
            if ((this.bitField0_ & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            }
            protoBuf$Annotation.argument_ = this.argument_;
            protoBuf$Annotation.bitField0_ = i;
            return protoBuf$Annotation;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Annotation protoBuf$Annotation) {
            if (protoBuf$Annotation == ProtoBuf$Annotation.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Annotation.hasId()) {
                setId(protoBuf$Annotation.getId());
            }
            if (!protoBuf$Annotation.argument_.isEmpty()) {
                if (this.argument_.isEmpty()) {
                    this.argument_ = protoBuf$Annotation.argument_;
                    this.bitField0_ &= -3;
                } else {
                    ensureArgumentIsMutable();
                    this.argument_.addAll(protoBuf$Annotation.argument_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$Annotation.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$Annotation protoBuf$Annotation = null;
            try {
                try {
                    ProtoBuf$Annotation protoBuf$Annotation2 = (ProtoBuf$Annotation) ProtoBuf$Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (protoBuf$Annotation2 != null) {
                        mergeFrom(protoBuf$Annotation2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$Annotation protoBuf$Annotation3 = (ProtoBuf$Annotation) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Annotation = protoBuf$Annotation3;
                        if (protoBuf$Annotation != null) {
                            mergeFrom(protoBuf$Annotation);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Annotation != null) {
                    mergeFrom(protoBuf$Annotation);
                }
                throw th;
            }
        }

        public Builder setId(int i) {
            this.bitField0_ |= 1;
            this.id_ = i;
            return this;
        }

        private void ensureArgumentIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 2;
            }
        }
    }
}
