package com.opentok.android;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class Subscriber extends SubscriberKit {

    public static class Builder extends SubscriberKit.Builder {
        public Builder(Context context, Stream stream) {
            super(context, stream);
        }

        @Override // com.opentok.android.SubscriberKit.Builder
        public Subscriber build() {
            if (this.renderer == null) {
                renderer(VideoRenderFactory.constructRenderer(this.context));
            }
            return new Subscriber(this);
        }

        @Override // com.opentok.android.SubscriberKit.Builder
        public Builder renderer(BaseVideoRenderer baseVideoRenderer) {
            this.renderer = baseVideoRenderer;
            return this;
        }
    }

    protected Subscriber(Builder builder) {
        super(builder);
    }
}
