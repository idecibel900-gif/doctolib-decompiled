package com.abovevacant.epitaph.wire;

import com.abovevacant.epitaph.core.Architecture;
import com.abovevacant.epitaph.core.ArmMTEMetadata;
import com.abovevacant.epitaph.core.BacktraceFrame;
import com.abovevacant.epitaph.core.Cause;
import com.abovevacant.epitaph.core.CrashDetail;
import com.abovevacant.epitaph.core.FD;
import com.abovevacant.epitaph.core.HeapObject;
import com.abovevacant.epitaph.core.LogBuffer;
import com.abovevacant.epitaph.core.LogMessage;
import com.abovevacant.epitaph.core.MemoryDump;
import com.abovevacant.epitaph.core.MemoryError;
import com.abovevacant.epitaph.core.MemoryMapping;
import com.abovevacant.epitaph.core.Register;
import com.abovevacant.epitaph.core.Signal;
import com.abovevacant.epitaph.core.StackHistoryBuffer;
import com.abovevacant.epitaph.core.StackHistoryBufferEntry;
import com.abovevacant.epitaph.core.Tombstone;
import com.abovevacant.epitaph.core.TombstoneThread;
import com.abovevacant.epitaph.io.WireReader;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TombstoneDecoder {
    private static void expectVarint(int i, int i2) throws IOException {
        WireReader.expectWireType(i, 0, i2);
    }

    private static void expectBytes(int i, int i2) throws IOException {
        WireReader.expectWireType(i, 2, i2);
    }

    public static Tombstone decode(InputStream inputStream) {
        return decode(WireReader.fromInputStream(inputStream));
    }

    private static Tombstone decode(WireReader wireReader) throws IOException {
        String string;
        Architecture architectureFromValue = Architecture.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        String string2 = "";
        String string3 = string2;
        String string4 = string3;
        int varInt32 = 0;
        int varInt33 = 0;
        int varInt34 = 0;
        int varInt35 = 0;
        int varInt36 = 0;
        boolean bool = false;
        Signal signalDecodeSignal = null;
        StackHistoryBuffer stackHistoryBufferDecodeStackHistoryBuffer = null;
        Architecture architectureFromValue2 = architectureFromValue;
        String str = string4;
        String string5 = str;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                Architecture architecture = architectureFromValue;
                int fieldNumber = WireReader.getFieldNumber(tag);
                Architecture architecture2 = architectureFromValue2;
                int wireType = WireReader.getWireType(tag);
                switch (fieldNumber) {
                    case 1:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        architectureFromValue = Architecture.fromValue(wireReader.readVarInt32());
                        architectureFromValue2 = architecture2;
                        break;
                    case 2:
                        expectBytes(fieldNumber, wireType);
                        string = wireReader.readString();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 3:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        string5 = wireReader.readString();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 4:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        string2 = wireReader.readString();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 5:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        varInt32 = wireReader.readVarInt32();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 6:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        varInt33 = wireReader.readVarInt32();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 7:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        varInt34 = wireReader.readVarInt32();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 8:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        string3 = wireReader.readString();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 9:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        arrayList.add(wireReader.readString());
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 10:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        signalDecodeSignal = decodeSignal(wireReader.readMessage());
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    case 13:
                    default:
                        string = str;
                        wireReader.skipField(wireType);
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 14:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        string4 = wireReader.readString();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        arrayList3.add(decodeCause(wireReader.readMessage()));
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 16:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        decodeThreadMapEntry(wireReader.readMessage(), map);
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 17:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        arrayList4.add(decodeMemoryMapping(wireReader.readMessage()));
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 18:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        arrayList5.add(decodeLogBuffer(wireReader.readMessage()));
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 19:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        arrayList6.add(decodeFD(wireReader.readMessage()));
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 20:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        varInt35 = wireReader.readVarInt32();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 21:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        arrayList2.add(decodeCrashDetail(wireReader.readMessage()));
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 22:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        varInt36 = wireReader.readVarInt32();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 23:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        bool = wireReader.readBool();
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                        string = str;
                        expectVarint(fieldNumber, wireType);
                        architectureFromValue2 = Architecture.fromValue(wireReader.readVarInt32());
                        architectureFromValue = architecture;
                        break;
                    case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        decodeThreadMapEntry(wireReader.readMessage(), map2);
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                    case 26:
                        string = str;
                        expectBytes(fieldNumber, wireType);
                        stackHistoryBufferDecodeStackHistoryBuffer = decodeStackHistoryBuffer(wireReader.readMessage());
                        architectureFromValue = architecture;
                        architectureFromValue2 = architecture2;
                        break;
                }
                str = string;
            } else {
                return new Tombstone(architectureFromValue, architectureFromValue2, str, string5, string2, varInt32, varInt33, varInt34, string3, arrayList, varInt35, signalDecodeSignal, string4, arrayList2, arrayList3, map, map2, arrayList4, arrayList5, arrayList6, varInt36, bool, stackHistoryBufferDecodeStackHistoryBuffer);
            }
        }
    }

    static Signal decodeSignal(WireReader wireReader) throws IOException {
        int varInt32 = 0;
        int varInt33 = 0;
        boolean bool = false;
        int varInt34 = 0;
        int varInt35 = 0;
        boolean bool2 = false;
        String string = "";
        String string2 = string;
        long varInt = 0;
        MemoryDump memoryDumpDecodeMemoryDump = null;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                switch (fieldNumber) {
                    case 1:
                        expectVarint(fieldNumber, wireType);
                        varInt32 = wireReader.readVarInt32();
                        break;
                    case 2:
                        expectBytes(fieldNumber, wireType);
                        string = wireReader.readString();
                        break;
                    case 3:
                        expectVarint(fieldNumber, wireType);
                        varInt33 = wireReader.readVarInt32();
                        break;
                    case 4:
                        expectBytes(fieldNumber, wireType);
                        string2 = wireReader.readString();
                        break;
                    case 5:
                        expectVarint(fieldNumber, wireType);
                        bool = wireReader.readBool();
                        break;
                    case 6:
                        expectVarint(fieldNumber, wireType);
                        varInt34 = wireReader.readVarInt32();
                        break;
                    case 7:
                        expectVarint(fieldNumber, wireType);
                        varInt35 = wireReader.readVarInt32();
                        break;
                    case 8:
                        expectVarint(fieldNumber, wireType);
                        bool2 = wireReader.readBool();
                        break;
                    case 9:
                        expectVarint(fieldNumber, wireType);
                        varInt = wireReader.readVarInt();
                        break;
                    case 10:
                        expectBytes(fieldNumber, wireType);
                        memoryDumpDecodeMemoryDump = decodeMemoryDump(wireReader.readMessage());
                        break;
                    default:
                        wireReader.skipField(wireType);
                        break;
                }
            } else {
                return new Signal(varInt32, string, varInt33, string2, bool, varInt34, varInt35, bool2, varInt, memoryDumpDecodeMemoryDump);
            }
        }
    }

    static void decodeThreadMapEntry(WireReader wireReader, Map map) throws IOException {
        int varInt32 = 0;
        TombstoneThread tombstoneThreadDecodeThread = null;
        while (true) {
            int tag = wireReader.readTag();
            if (tag == 0) {
                break;
            }
            int fieldNumber = WireReader.getFieldNumber(tag);
            int wireType = WireReader.getWireType(tag);
            if (fieldNumber == 1) {
                expectVarint(fieldNumber, wireType);
                varInt32 = wireReader.readVarInt32();
            } else if (fieldNumber == 2) {
                expectBytes(fieldNumber, wireType);
                tombstoneThreadDecodeThread = decodeThread(wireReader.readMessage());
            } else {
                wireReader.skipField(wireType);
            }
        }
        if (tombstoneThreadDecodeThread != null) {
            map.put(Integer.valueOf(varInt32), tombstoneThreadDecodeThread);
        }
    }

    static TombstoneThread decodeThread(WireReader wireReader) throws IOException {
        int fieldNumber;
        int wireType;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int varInt32 = 0;
        long varInt = 0;
        String string = "";
        long varInt2 = 0;
        while (true) {
            int i = varInt32;
            while (true) {
                int tag = wireReader.readTag();
                if (tag != 0) {
                    fieldNumber = WireReader.getFieldNumber(tag);
                    wireType = WireReader.getWireType(tag);
                    switch (fieldNumber) {
                        case 1:
                            break;
                        case 2:
                            expectBytes(fieldNumber, wireType);
                            string = wireReader.readString();
                            break;
                        case 3:
                            expectBytes(fieldNumber, wireType);
                            arrayList.add(decodeRegister(wireReader.readMessage()));
                            break;
                        case 4:
                            expectBytes(fieldNumber, wireType);
                            arrayList4.add(decodeBacktraceFrame(wireReader.readMessage()));
                            break;
                        case 5:
                            expectBytes(fieldNumber, wireType);
                            arrayList5.add(decodeMemoryDump(wireReader.readMessage()));
                            break;
                        case 6:
                            expectVarint(fieldNumber, wireType);
                            varInt = wireReader.readVarInt();
                            break;
                        case 7:
                            expectBytes(fieldNumber, wireType);
                            arrayList2.add(wireReader.readString());
                            break;
                        case 8:
                            expectVarint(fieldNumber, wireType);
                            varInt2 = wireReader.readVarInt();
                            break;
                        case 9:
                            expectBytes(fieldNumber, wireType);
                            arrayList3.add(wireReader.readString());
                            break;
                        default:
                            wireReader.skipField(wireType);
                            break;
                    }
                } else {
                    return new TombstoneThread(i, string, arrayList, arrayList2, arrayList3, arrayList4, arrayList5, varInt, varInt2);
                }
            }
            expectVarint(fieldNumber, wireType);
            varInt32 = wireReader.readVarInt32();
        }
    }

    static BacktraceFrame decodeBacktraceFrame(WireReader wireReader) throws IOException {
        long varInt = 0;
        long varInt2 = 0;
        long varInt3 = 0;
        long varInt4 = 0;
        long varInt5 = 0;
        String string = "";
        String string2 = string;
        String string3 = string2;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                switch (fieldNumber) {
                    case 1:
                        expectVarint(fieldNumber, wireType);
                        varInt = wireReader.readVarInt();
                        break;
                    case 2:
                        expectVarint(fieldNumber, wireType);
                        varInt2 = wireReader.readVarInt();
                        break;
                    case 3:
                        expectVarint(fieldNumber, wireType);
                        varInt3 = wireReader.readVarInt();
                        break;
                    case 4:
                        expectBytes(fieldNumber, wireType);
                        string = wireReader.readString();
                        break;
                    case 5:
                        expectVarint(fieldNumber, wireType);
                        varInt4 = wireReader.readVarInt();
                        break;
                    case 6:
                        expectBytes(fieldNumber, wireType);
                        string2 = wireReader.readString();
                        break;
                    case 7:
                        expectVarint(fieldNumber, wireType);
                        varInt5 = wireReader.readVarInt();
                        break;
                    case 8:
                        expectBytes(fieldNumber, wireType);
                        string3 = wireReader.readString();
                        break;
                    default:
                        wireReader.skipField(wireType);
                        break;
                }
            } else {
                return new BacktraceFrame(varInt, varInt2, varInt3, string, varInt4, string2, varInt5, string3);
            }
        }
    }

    static Register decodeRegister(WireReader wireReader) throws IOException {
        String string = "";
        long varInt = 0;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectBytes(fieldNumber, wireType);
                    string = wireReader.readString();
                } else if (fieldNumber == 2) {
                    expectVarint(fieldNumber, wireType);
                    varInt = wireReader.readVarInt();
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new Register(string, varInt);
            }
        }
    }

    static MemoryMapping decodeMemoryMapping(WireReader wireReader) throws IOException {
        long varInt = 0;
        long varInt2 = 0;
        long varInt3 = 0;
        long varInt4 = 0;
        boolean bool = false;
        boolean bool2 = false;
        boolean bool3 = false;
        String string = "";
        String string2 = string;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                switch (fieldNumber) {
                    case 1:
                        expectVarint(fieldNumber, wireType);
                        varInt = wireReader.readVarInt();
                        break;
                    case 2:
                        expectVarint(fieldNumber, wireType);
                        varInt2 = wireReader.readVarInt();
                        break;
                    case 3:
                        expectVarint(fieldNumber, wireType);
                        varInt3 = wireReader.readVarInt();
                        break;
                    case 4:
                        expectVarint(fieldNumber, wireType);
                        bool = wireReader.readBool();
                        break;
                    case 5:
                        expectVarint(fieldNumber, wireType);
                        bool2 = wireReader.readBool();
                        break;
                    case 6:
                        expectVarint(fieldNumber, wireType);
                        bool3 = wireReader.readBool();
                        break;
                    case 7:
                        expectBytes(fieldNumber, wireType);
                        string = wireReader.readString();
                        break;
                    case 8:
                        expectBytes(fieldNumber, wireType);
                        string2 = wireReader.readString();
                        break;
                    case 9:
                        expectVarint(fieldNumber, wireType);
                        varInt4 = wireReader.readVarInt();
                        break;
                    default:
                        wireReader.skipField(wireType);
                        break;
                }
            } else {
                return new MemoryMapping(varInt, varInt2, varInt3, bool, bool2, bool3, string, string2, varInt4);
            }
        }
    }

    static MemoryDump decodeMemoryDump(WireReader wireReader) throws IOException {
        byte[] bytes = new byte[0];
        String string = "";
        String string2 = string;
        long varInt = 0;
        ArmMTEMetadata armMTEMetadataDecodeArmMTEMetadata = null;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectBytes(fieldNumber, wireType);
                    string = wireReader.readString();
                } else if (fieldNumber == 2) {
                    expectBytes(fieldNumber, wireType);
                    string2 = wireReader.readString();
                } else if (fieldNumber == 3) {
                    expectVarint(fieldNumber, wireType);
                    varInt = wireReader.readVarInt();
                } else if (fieldNumber == 4) {
                    expectBytes(fieldNumber, wireType);
                    bytes = wireReader.readBytes();
                } else if (fieldNumber == 6) {
                    expectBytes(fieldNumber, wireType);
                    armMTEMetadataDecodeArmMTEMetadata = decodeArmMTEMetadata(wireReader.readMessage());
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new MemoryDump(string, string2, varInt, bytes, armMTEMetadataDecodeArmMTEMetadata);
            }
        }
    }

    static ArmMTEMetadata decodeArmMTEMetadata(WireReader wireReader) throws IOException {
        byte[] bytes = new byte[0];
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectBytes(fieldNumber, wireType);
                    bytes = wireReader.readBytes();
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new ArmMTEMetadata(bytes);
            }
        }
    }

    static Cause decodeCause(WireReader wireReader) throws IOException {
        String string = "";
        MemoryError memoryErrorDecodeMemoryError = null;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectBytes(fieldNumber, wireType);
                    string = wireReader.readString();
                } else if (fieldNumber == 2) {
                    expectBytes(fieldNumber, wireType);
                    memoryErrorDecodeMemoryError = decodeMemoryError(wireReader.readMessage());
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new Cause(string, memoryErrorDecodeMemoryError);
            }
        }
    }

    static MemoryError decodeMemoryError(WireReader wireReader) throws IOException {
        MemoryError.Tool toolFromValue = MemoryError.Tool.GWP_ASAN;
        MemoryError.Type typeFromValue = MemoryError.Type.UNKNOWN;
        HeapObject heapObjectDecodeHeapObject = null;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectVarint(fieldNumber, wireType);
                    toolFromValue = MemoryError.Tool.fromValue(wireReader.readVarInt32());
                } else if (fieldNumber == 2) {
                    expectVarint(fieldNumber, wireType);
                    typeFromValue = MemoryError.Type.fromValue(wireReader.readVarInt32());
                } else if (fieldNumber == 3) {
                    expectBytes(fieldNumber, wireType);
                    heapObjectDecodeHeapObject = decodeHeapObject(wireReader.readMessage());
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new MemoryError(toolFromValue, typeFromValue, heapObjectDecodeHeapObject);
            }
        }
    }

    static HeapObject decodeHeapObject(WireReader wireReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long varInt = 0;
        long varInt2 = 0;
        long varInt3 = 0;
        long varInt4 = 0;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                switch (fieldNumber) {
                    case 1:
                        expectVarint(fieldNumber, wireType);
                        varInt4 = wireReader.readVarInt();
                        break;
                    case 2:
                        expectVarint(fieldNumber, wireType);
                        varInt = wireReader.readVarInt();
                        break;
                    case 3:
                        expectVarint(fieldNumber, wireType);
                        varInt2 = wireReader.readVarInt();
                        break;
                    case 4:
                        expectBytes(fieldNumber, wireType);
                        arrayList.add(decodeBacktraceFrame(wireReader.readMessage()));
                        break;
                    case 5:
                        expectVarint(fieldNumber, wireType);
                        varInt3 = wireReader.readVarInt();
                        break;
                    case 6:
                        expectBytes(fieldNumber, wireType);
                        arrayList2.add(decodeBacktraceFrame(wireReader.readMessage()));
                        break;
                    default:
                        wireReader.skipField(wireType);
                        break;
                }
            } else {
                return new HeapObject(varInt4, varInt, varInt2, arrayList, varInt3, arrayList2);
            }
        }
    }

    static FD decodeFD(WireReader wireReader) throws IOException {
        int varInt32 = 0;
        String string = "";
        String string2 = string;
        long varInt = 0;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectVarint(fieldNumber, wireType);
                    varInt32 = wireReader.readVarInt32();
                } else if (fieldNumber == 2) {
                    expectBytes(fieldNumber, wireType);
                    string = wireReader.readString();
                } else if (fieldNumber == 3) {
                    expectBytes(fieldNumber, wireType);
                    string2 = wireReader.readString();
                } else if (fieldNumber == 4) {
                    expectVarint(fieldNumber, wireType);
                    varInt = wireReader.readVarInt();
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new FD(varInt32, string, string2, varInt);
            }
        }
    }

    static LogBuffer decodeLogBuffer(WireReader wireReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        String string = "";
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectBytes(fieldNumber, wireType);
                    string = wireReader.readString();
                } else if (fieldNumber == 2) {
                    expectBytes(fieldNumber, wireType);
                    arrayList.add(decodeLogMessage(wireReader.readMessage()));
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new LogBuffer(string, arrayList);
            }
        }
    }

    static LogMessage decodeLogMessage(WireReader wireReader) throws IOException {
        String string = "";
        String string2 = string;
        String string3 = string2;
        int varInt32 = 0;
        int varInt33 = 0;
        int varInt34 = 0;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                switch (fieldNumber) {
                    case 1:
                        expectBytes(fieldNumber, wireType);
                        string = wireReader.readString();
                        break;
                    case 2:
                        expectVarint(fieldNumber, wireType);
                        varInt32 = wireReader.readVarInt32();
                        break;
                    case 3:
                        expectVarint(fieldNumber, wireType);
                        varInt33 = wireReader.readVarInt32();
                        break;
                    case 4:
                        expectVarint(fieldNumber, wireType);
                        varInt34 = wireReader.readVarInt32();
                        break;
                    case 5:
                        expectBytes(fieldNumber, wireType);
                        string2 = wireReader.readString();
                        break;
                    case 6:
                        expectBytes(fieldNumber, wireType);
                        string3 = wireReader.readString();
                        break;
                    default:
                        wireReader.skipField(wireType);
                        break;
                }
            } else {
                return new LogMessage(string, varInt32, varInt33, varInt34, string2, string3);
            }
        }
    }

    static CrashDetail decodeCrashDetail(WireReader wireReader) throws IOException {
        byte[] bytes = new byte[0];
        byte[] bytes2 = new byte[0];
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectBytes(fieldNumber, wireType);
                    bytes = wireReader.readBytes();
                } else if (fieldNumber == 2) {
                    expectBytes(fieldNumber, wireType);
                    bytes2 = wireReader.readBytes();
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new CrashDetail(bytes, bytes2);
            }
        }
    }

    static StackHistoryBuffer decodeStackHistoryBuffer(WireReader wireReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        long varInt = 0;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectVarint(fieldNumber, wireType);
                    varInt = wireReader.readVarInt();
                } else if (fieldNumber == 2) {
                    expectBytes(fieldNumber, wireType);
                    arrayList.add(decodeStackHistoryBufferEntry(wireReader.readMessage()));
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new StackHistoryBuffer(varInt, arrayList);
            }
        }
    }

    static StackHistoryBufferEntry decodeStackHistoryBufferEntry(WireReader wireReader) throws IOException {
        BacktraceFrame backtraceFrameDecodeBacktraceFrame = null;
        long varInt = 0;
        long varInt2 = 0;
        while (true) {
            int tag = wireReader.readTag();
            if (tag != 0) {
                int fieldNumber = WireReader.getFieldNumber(tag);
                int wireType = WireReader.getWireType(tag);
                if (fieldNumber == 1) {
                    expectBytes(fieldNumber, wireType);
                    backtraceFrameDecodeBacktraceFrame = decodeBacktraceFrame(wireReader.readMessage());
                } else if (fieldNumber == 2) {
                    expectVarint(fieldNumber, wireType);
                    varInt = wireReader.readVarInt();
                } else if (fieldNumber == 3) {
                    expectVarint(fieldNumber, wireType);
                    varInt2 = wireReader.readVarInt();
                } else {
                    wireReader.skipField(wireType);
                }
            } else {
                return new StackHistoryBufferEntry(backtraceFrameDecodeBacktraceFrame, varInt, varInt2);
            }
        }
    }
}
