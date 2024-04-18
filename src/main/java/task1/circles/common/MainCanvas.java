package task1.circles.common;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final CanvasRepaintListener controller;
    private long lastFrameTime;


    public MainCanvas(CanvasRepaintListener controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    // переопределение перерисовки панели JPanel
    protected void paintComponent(Graphics g) { // do {
        super.paintComponent(g);                // something // перерисовывает панель JPanel. Вызывается тогда, когда надо перерисовать.
        // такой метод снимает нагрузку с процессора при отрисовке,
        // тем что засталяет метод орисовки поспать 16млс
        try { // sleep
            Thread.sleep(16); // 16 ms
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван во время сна");
            ;
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f; // перевод из наносекунд в секунды
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint(); // while (true)
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBotton() {
        return getHeight() - 1;
    }
}
