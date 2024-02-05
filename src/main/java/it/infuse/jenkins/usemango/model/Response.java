package it.infuse.jenkins.usemango.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

import java.util.List;

public class Response<T> extends GenericJson {
    @Key("Items")
    private List<T> items;
    @Key("FullCount")
    private int fullCount;
    @Key("Offset")
    private int offset;
    @Key("Info")
    private ResponseInfo info;

    /**
     * @return the items
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * @return the fullCount
     */
    public int getFullCount() {
        return fullCount;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return the info
     */
    public ResponseInfo getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Response)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
