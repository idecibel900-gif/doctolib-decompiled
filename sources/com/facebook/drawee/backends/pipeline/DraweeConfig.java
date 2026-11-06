package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.fresco.ui.common.ImagePerfDataListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DraweeConfig {
    private final ImmutableList mCustomDrawableFactories;
    private final Supplier mDebugOverlayEnabledSupplier;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public ImagePerfDataListener getImagePerfDataListener() {
        return null;
    }

    private DraweeConfig(Builder builder) {
        Supplier supplierOf;
        this.mCustomDrawableFactories = builder.mCustomDrawableFactories != null ? ImmutableList.copyOf(builder.mCustomDrawableFactories) : null;
        if (builder.mDebugOverlayEnabledSupplier != null) {
            supplierOf = builder.mDebugOverlayEnabledSupplier;
        } else {
            supplierOf = Suppliers.of(Boolean.FALSE);
        }
        this.mDebugOverlayEnabledSupplier = supplierOf;
        this.mPipelineDraweeControllerFactory = builder.mPipelineDraweeControllerFactory;
        Builder.m3226$$Nest$fgetmImagePerfDataListener(builder);
    }

    public ImmutableList getCustomDrawableFactories() {
        return this.mCustomDrawableFactories;
    }

    public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory() {
        return this.mPipelineDraweeControllerFactory;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Supplier getDebugOverlayEnabledSupplier() {
        return this.mDebugOverlayEnabledSupplier;
    }

    public static final class Builder {
        private List mCustomDrawableFactories;
        private Supplier mDebugOverlayEnabledSupplier;
        private PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

        /* JADX INFO: renamed from: -$$Nest$fgetmImagePerfDataListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ ImagePerfDataListener m3226$$Nest$fgetmImagePerfDataListener(Builder builder) {
            builder.getClass();
            return null;
        }

        public DraweeConfig build() {
            return new DraweeConfig(this);
        }
    }
}
