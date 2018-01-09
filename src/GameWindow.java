import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame{

    GameCanvas gameCanvas;
    private long lastTime=0;

    public GameWindow(){
        this.setSize(400,600);

        this.setVisible(true);

        this.setupGameCanvas();
        this.event();
    }

    //CT chay lien tuc
    public void gameLoop()  {
        while (true)    {
            //time now
            long currentTime = System.nanoTime();
            if(currentTime-this.lastTime>= 17_000_000){
                this.gameCanvas.renderAll();
                this.gameCanvas.runAll();
//                }
                this.lastTime=currentTime;
            }

        }
    }

    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(gameCanvas);
    }

    private void event(){
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.positionPlayer.set(e.getX(),e.getY());
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
}
