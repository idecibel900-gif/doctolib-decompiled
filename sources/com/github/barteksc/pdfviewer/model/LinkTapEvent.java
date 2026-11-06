package com.github.barteksc.pdfviewer.model;

import android.graphics.RectF;
import io.legere.pdfiumandroid.PdfDocument;

/* JADX INFO: loaded from: classes3.dex */
public class LinkTapEvent {
    private float documentX;
    private float documentY;
    private PdfDocument.Link link;
    private RectF mappedLinkRect;
    private float originalX;
    private float originalY;

    public LinkTapEvent(float f, float f2, float f3, float f4, RectF rectF, PdfDocument.Link link) {
        this.originalX = f;
        this.originalY = f2;
        this.documentX = f3;
        this.documentY = f4;
        this.mappedLinkRect = rectF;
        this.link = link;
    }

    public PdfDocument.Link getLink() {
        return this.link;
    }
}
