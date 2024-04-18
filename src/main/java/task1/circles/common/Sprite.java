package task1.circles.common;

import java.awt.*;

public abstract class Sprite implements Interactable {
    protected float x;
    protected float y;
    protected float halfWigth;
    protected float halfHeight;

    protected float getLeft() {
        return x - halfWigth;
    }
    protected void setleft(float left) {
        x = left + halfWigth;
    }
    protected float getRight() {
        return x + halfWigth;
    }
    protected void setRight(float right){
        x = right - halfWigth;
    }
    protected float getTop() {
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }

    protected float getWidth() {
        return 2f * halfWigth;
    }
    protected float getHeight() {
        return 2f * halfHeight;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {

    }
}
