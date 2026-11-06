package io.sentry;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SentryMaskingOptions {
    protected Set maskViewClasses = new CopyOnWriteArraySet();
    protected Set unmaskViewClasses = new CopyOnWriteArraySet();
    protected String maskViewContainerClass = null;
    protected String unmaskViewContainerClass = null;

    public abstract void trackCustomMasking();

    public void setMaskAllText(boolean z) {
        if (z) {
            this.maskViewClasses.add("android.widget.TextView");
            this.unmaskViewClasses.remove("android.widget.TextView");
        } else {
            this.unmaskViewClasses.add("android.widget.TextView");
            this.maskViewClasses.remove("android.widget.TextView");
        }
    }

    public void setMaskAllImages(boolean z) {
        if (z) {
            this.maskViewClasses.add("android.widget.ImageView");
            this.unmaskViewClasses.remove("android.widget.ImageView");
        } else {
            this.unmaskViewClasses.add("android.widget.ImageView");
            this.maskViewClasses.remove("android.widget.ImageView");
        }
    }

    public Set getMaskViewClasses() {
        return this.maskViewClasses;
    }

    public void addMaskViewClass(String str) {
        this.maskViewClasses.add(str);
        this.unmaskViewClasses.remove(str);
    }

    public Set getUnmaskViewClasses() {
        return this.unmaskViewClasses;
    }

    public void addUnmaskViewClass(String str) {
        this.unmaskViewClasses.add(str);
        this.maskViewClasses.remove(str);
    }

    public String getMaskViewContainerClass() {
        return this.maskViewContainerClass;
    }

    public void setMaskViewContainerClass(String str) {
        this.maskViewClasses.add(str);
        this.maskViewContainerClass = str;
    }

    public String getUnmaskViewContainerClass() {
        return this.unmaskViewContainerClass;
    }

    public void setUnmaskViewContainerClass(String str) {
        this.unmaskViewContainerClass = str;
    }
}
