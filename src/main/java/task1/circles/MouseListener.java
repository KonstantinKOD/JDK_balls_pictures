
package task1.circles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private MainWindow mainWindow;

    public MouseListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            mainWindow.addBall(e.getX(),e.getY());
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mainWindow.delBall();
        }
    }
}
