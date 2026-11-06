package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryError {
    public final HeapObject heap;
    public final Tool tool;
    public final Type type;

    public enum Tool {
        GWP_ASAN(0),
        SCUDO(1);

        private final int value;

        Tool(int i) {
            this.value = i;
        }

        public static Tool fromValue(int i) {
            for (Tool tool : values()) {
                if (tool.value == i) {
                    return tool;
                }
            }
            return GWP_ASAN;
        }
    }

    public enum Type {
        UNKNOWN(0),
        USE_AFTER_FREE(1),
        DOUBLE_FREE(2),
        INVALID_FREE(3),
        BUFFER_OVERFLOW(4),
        BUFFER_UNDERFLOW(5);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type fromValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return UNKNOWN;
        }
    }

    public MemoryError(Tool tool, Type type, HeapObject heapObject) {
        this.tool = tool;
        this.type = type;
        this.heap = heapObject;
    }
}
