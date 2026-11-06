package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ForwardingRequestListener2 implements RequestListener2 {
    public static final Companion Companion = new Companion(null);
    private final List requestListeners;

    public ForwardingRequestListener2(Set set) {
        if (set == null) {
            this.requestListeners = new ArrayList();
            return;
        }
        ArrayList arrayList = new ArrayList(set.size());
        this.requestListeners = arrayList;
        CollectionsKt.filterNotNullTo(set, arrayList);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(ProducerContext producerContext, String producerName, String producerEventName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Intrinsics.checkNotNullParameter(producerEventName, "producerEventName");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerEvent(producerContext, producerName, producerEventName);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(ProducerContext producerContext, String str, Map map) {
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerFinishWithCancellation(producerContext, str, map);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(ProducerContext producerContext, String str, Throwable th, Map map) {
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerFinishWithFailure(producerContext, str, th, map);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(ProducerContext producerContext, String str, Map map) {
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerFinishWithSuccess(producerContext, str, map);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onProducerStart(producerContext, producerName);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestCancellation(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(ProducerContext producerContext, Throwable throwable) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestFailure(producerContext, throwable);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestStart(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onRequestSuccess(producerContext);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(ProducerContext producerContext, String producerName, boolean z) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).onUltimateProducerReached(producerContext, producerName, z);
            } catch (Exception e) {
                FLog.e("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        List list = this.requestListeners;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((RequestListener2) it.next()).requiresExtraMap(producerContext, producerName)) {
                return true;
            }
        }
        return false;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
