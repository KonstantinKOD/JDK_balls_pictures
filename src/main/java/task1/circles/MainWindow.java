package task1.circles;


import task1.circles.common.CanvasRepaintListener;
import task1.circles.common.Interactable;
import task1.circles.common.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener/*можно прописать интерфейс(их может быть сколь угодно) и переопределить нужный метод*/ {
    private static final int P_X = 400;
    private static final int P_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGTH = 600;
    private static final int DEFAULT_SPR = 10;
    private static final int MAX_SPR = 15;
    private static final Interactable[] sprites = new Interactable[MAX_SPR];
    private int countSprites;

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(P_X, P_Y, WIDTH, HEIGTH);
        setTitle("Circles");
        sprites[0] = new Background();
        countSprites = 1;
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball(getX(), getY());
        }
        MainCanvas canvas = new MainCanvas(this);
        addMouseListener(new MouseListener(this)/*сюда передаем ссылку на самого себя, если был имплементирован интерфейс адаптера*/); //(new MouseAdapter) { //можно добавить в аргумент адаптер и прееопределить один из методов
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
//            }
//        });
        add(canvas);
        setVisible(true);
    }

    public void addBall(int x, int y) {
        if (countSprites >= MAX_SPR) {
            System.out.println("Максимум шаров");
        }
        sprites[countSprites++] = new Ball(x, y);
    }

    public void delBall() {
        if (countSprites <= 1){
            return;
        }
//        countSprites--;
        sprites[countSprites] = int
    }


    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }


    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    //преопледеленные методы адаптера(переопределить нужный), они возникают при наследовании интерфейса адапрета(см. строку 14)
}
