package com.google.zxing.aztec.encoder;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP;
    static final int[][] SHIFT_TABLE;
    private final Charset charset;
    private final byte[] text;
    static final String[] MODE_NAMES = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] LATCH_TABLE = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    static {
        int[] iArr = {5, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER};
        Class cls = Integer.TYPE;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, iArr);
        CHAR_MAP = iArr2;
        iArr2[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            CHAR_MAP[0][i] = i - 63;
        }
        CHAR_MAP[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            CHAR_MAP[1][i2] = i2 - 95;
        }
        CHAR_MAP[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            CHAR_MAP[2][i3] = i3 - 46;
        }
        int[] iArr3 = CHAR_MAP[2];
        iArr3[44] = 12;
        iArr3[46] = 13;
        int[] iArr4 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, WebSocketProtocol.PAYLOAD_SHORT, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            CHAR_MAP[3][iArr4[i4]] = i4;
        }
        int[] iArr5 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            int i6 = iArr5[i5];
            if (i6 > 0) {
                CHAR_MAP[4][i6] = i5;
            }
        }
        int[][] iArr6 = (int[][]) Array.newInstance((Class<?>) cls, 6, 6);
        SHIFT_TABLE = iArr6;
        for (int[] iArr7 : iArr6) {
            Arrays.fill(iArr7, -1);
        }
        int[][] iArr8 = SHIFT_TABLE;
        iArr8[0][4] = 0;
        int[] iArr9 = iArr8[1];
        iArr9[4] = 0;
        iArr9[0] = 28;
        iArr8[3][4] = 0;
        int[] iArr10 = iArr8[2];
        iArr10[4] = 0;
        iArr10[0] = 15;
    }

    public HighLevelEncoder(byte[] bArr, Charset charset) {
        this.text = bArr;
        this.charset = charset;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0056  */
    public BitArray encode() {
        int i;
        State stateAppendFLGn = State.INITIAL_STATE;
        Charset charset = this.charset;
        if (charset != null) {
            CharacterSetECI characterSetECI = CharacterSetECI.getCharacterSetECI(charset);
            if (characterSetECI == null) {
                throw new IllegalArgumentException("No ECI code for character set " + this.charset);
            }
            stateAppendFLGn = stateAppendFLGn.appendFLGn(characterSetECI.getValue());
        }
        Collection collectionSingletonList = Collections.singletonList(stateAppendFLGn);
        int i2 = 0;
        while (true) {
            byte[] bArr = this.text;
            if (i2 < bArr.length) {
                int i3 = i2 + 1;
                byte b = i3 < bArr.length ? bArr[i3] : (byte) 0;
                byte b2 = bArr[i2];
                if (b2 != 13) {
                    if (b2 != 44) {
                        if (b2 != 46) {
                            if (b2 == 58 && b == 32) {
                                i = 5;
                            } else {
                                i = 0;
                            }
                        } else if (b == 32) {
                            i = 3;
                        } else {
                            i = 0;
                        }
                    } else if (b == 32) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                } else if (b == 10) {
                    i = 2;
                } else {
                    i = 0;
                }
                if (i > 0) {
                    collectionSingletonList = updateStateListForPair(collectionSingletonList, i2, i);
                    i2 = i3;
                } else {
                    collectionSingletonList = updateStateListForChar(collectionSingletonList, i2);
                }
                i2++;
            } else {
                return ((State) Collections.min(collectionSingletonList, new Comparator() { // from class: com.google.zxing.aztec.encoder.HighLevelEncoder.1
                    @Override // java.util.Comparator
                    public int compare(State state, State state2) {
                        return state.getBitCount() - state2.getBitCount();
                    }
                })).toBitArray(this.text);
            }
        }
    }

    private Collection updateStateListForChar(Iterable iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForChar((State) it.next(), i, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private void updateStateForChar(State state, int i, Collection collection) {
        char c = (char) (this.text[i] & 255);
        boolean z = CHAR_MAP[state.getMode()][c] > 0;
        State stateEndBinaryShift = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = CHAR_MAP[i2][c];
            if (i3 > 0) {
                if (stateEndBinaryShift == null) {
                    stateEndBinaryShift = state.endBinaryShift(i);
                }
                if (!z || i2 == state.getMode() || i2 == 2) {
                    collection.add(stateEndBinaryShift.latchAndAppend(i2, i3));
                }
                if (!z && SHIFT_TABLE[state.getMode()][i2] >= 0) {
                    collection.add(stateEndBinaryShift.shiftAndAppend(i2, i3));
                }
            }
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c] == 0) {
            collection.add(state.addBinaryShiftChar(i));
        }
    }

    private static Collection updateStateListForPair(Iterable iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForPair((State) it.next(), i, i2, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private static void updateStateForPair(State state, int i, int i2, Collection collection) {
        State stateEndBinaryShift = state.endBinaryShift(i);
        collection.add(stateEndBinaryShift.latchAndAppend(4, i2));
        if (state.getMode() != 4) {
            collection.add(stateEndBinaryShift.shiftAndAppend(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(stateEndBinaryShift.latchAndAppend(2, 16 - i2).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i).addBinaryShiftChar(i + 1));
        }
    }

    private static Collection simplifyStates(Iterable iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            State state = (State) it.next();
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    State state2 = (State) it2.next();
                    if (state2.isBetterThanOrEqualTo(state)) {
                        break;
                    }
                    if (state.isBetterThanOrEqualTo(state2)) {
                        it2.remove();
                    }
                } else {
                    linkedList.addFirst(state);
                    break;
                }
            }
        }
        return linkedList;
    }
}
