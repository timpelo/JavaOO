package W10.E01;

import java.awt.*;

/**
 * Created by Jani on 4/11/2015.
 */
public class Wall extends Rectangle {

    private String tag;

    public Wall(int x, int y, int width, int height, String tag) {
        super(x, y, width, height);
        this.tag = tag;

    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
