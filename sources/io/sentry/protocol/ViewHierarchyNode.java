package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewHierarchyNode implements JsonSerializable {
    private Double alpha;
    private List children;
    private Double height;
    private String identifier;
    private String renderingSystem;
    private String tag;
    private String type;
    private Map unknown;
    private String visibility;
    private Double width;
    private Double x;
    private Double y;

    public void setType(String str) {
        this.type = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setWidth(Double d) {
        this.width = d;
    }

    public void setHeight(Double d) {
        this.height = d;
    }

    public void setX(Double d) {
        this.x = d;
    }

    public void setY(Double d) {
        this.y = d;
    }

    public void setVisibility(String str) {
        this.visibility = str;
    }

    public void setAlpha(Double d) {
        this.alpha = d;
    }

    public void setChildren(List list) {
        this.children = list;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.renderingSystem != null) {
            objectWriter.name("rendering_system").value(this.renderingSystem);
        }
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.identifier != null) {
            objectWriter.name("identifier").value(this.identifier);
        }
        if (this.tag != null) {
            objectWriter.name("tag").value(this.tag);
        }
        if (this.width != null) {
            objectWriter.name("width").value(this.width);
        }
        if (this.height != null) {
            objectWriter.name("height").value(this.height);
        }
        if (this.x != null) {
            objectWriter.name("x").value(this.x);
        }
        if (this.y != null) {
            objectWriter.name("y").value(this.y);
        }
        if (this.visibility != null) {
            objectWriter.name("visibility").value(this.visibility);
        }
        if (this.alpha != null) {
            objectWriter.name("alpha").value(this.alpha);
        }
        List list = this.children;
        if (list != null && !list.isEmpty()) {
            objectWriter.name("children").value(iLogger, this.children);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public ViewHierarchyNode deserialize(ObjectReader objectReader, ILogger iLogger) {
            ViewHierarchyNode viewHierarchyNode = new ViewHierarchyNode();
            objectReader.beginObject();
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "rendering_system":
                        viewHierarchyNode.renderingSystem = objectReader.nextStringOrNull();
                        break;
                    case "identifier":
                        viewHierarchyNode.identifier = objectReader.nextStringOrNull();
                        break;
                    case "height":
                        viewHierarchyNode.height = objectReader.nextDoubleOrNull();
                        break;
                    case "x":
                        viewHierarchyNode.x = objectReader.nextDoubleOrNull();
                        break;
                    case "y":
                        viewHierarchyNode.y = objectReader.nextDoubleOrNull();
                        break;
                    case "tag":
                        viewHierarchyNode.tag = objectReader.nextStringOrNull();
                        break;
                    case "type":
                        viewHierarchyNode.type = objectReader.nextStringOrNull();
                        break;
                    case "alpha":
                        viewHierarchyNode.alpha = objectReader.nextDoubleOrNull();
                        break;
                    case "width":
                        viewHierarchyNode.width = objectReader.nextDoubleOrNull();
                        break;
                    case "children":
                        viewHierarchyNode.children = objectReader.nextListOrNull(iLogger, this);
                        break;
                    case "visibility":
                        viewHierarchyNode.visibility = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.nextUnknown(iLogger, map, strNextName);
                        break;
                }
            }
            objectReader.endObject();
            viewHierarchyNode.setUnknown(map);
            return viewHierarchyNode;
        }
    }
}
