package com.iabtcf.decoder;

import com.iabtcf.utils.function.Supplier;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
class LazySegmentFactory {
    private final String src;
    private SegmentSupplier sup = new SegmentSupplier();

    private static class EmptyInputStream extends SegmentInputStream {
        public static EmptyInputStream INSTANCE = new EmptyInputStream();

        private EmptyInputStream() {
            super("", 0);
        }

        @Override // com.iabtcf.decoder.SegmentInputStream
        protected boolean hasNextSegment() {
            return false;
        }

        @Override // com.iabtcf.decoder.SegmentInputStream
        protected int segmentEnd() {
            return -1;
        }
    }

    class SegmentSupplier implements Supplier<InputStream> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SegmentInputStream current;
        private final SegmentSupplier prev;

        public SegmentSupplier() {
            this.prev = null;
            this.current = new SegmentInputStream(LazySegmentFactory.this.src, 0);
        }

        private SegmentInputStream getCurrent() {
            if (this.current == null) {
                SegmentInputStream current = this.prev.getCurrent();
                EmptyInputStream emptyInputStream = EmptyInputStream.INSTANCE;
                if (current == emptyInputStream) {
                    this.current = emptyInputStream;
                } else {
                    this.current = new SegmentInputStream(LazySegmentFactory.this.src, current.segmentEnd() + 1);
                }
            }
            return this.current;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.iabtcf.utils.function.Supplier
        public InputStream get() {
            return getCurrent();
        }

        public SegmentSupplier(SegmentSupplier segmentSupplier) {
            this.prev = segmentSupplier;
        }
    }

    public LazySegmentFactory(String str) {
        this.src = str;
    }

    public Supplier<InputStream> next() {
        SegmentSupplier segmentSupplier = this.sup;
        this.sup = new SegmentSupplier(segmentSupplier);
        return segmentSupplier;
    }
}
