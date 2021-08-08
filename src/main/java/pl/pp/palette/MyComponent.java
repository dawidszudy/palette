package pl.pp.palette;

import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {

    int points = 0;
    Ball ball = Ball.getBall();
    Coin[][] coins = new Coin[5][10];

    public MyComponent() {
        Timer timer = new Timer(25, e -> {
            ball.updatePosition();
            for (Coin[] coinsRow : coins) {
                for (Coin coin : coinsRow) {
                    if ( ball.checkCollision(coin) ) {
                        coin.setShow(false);
                        win2();
                    }
                }
            }
            repaint();
        });

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins[i].length; j++) {
                coins[i][j] = new Coin(150 + 50 * j, 20 + 50 * i);
            }
        }
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        Graphics2D graphics2d = (Graphics2D) g;

        Rectangle limit = new Rectangle(0, 0, Utils.maxWidth, Utils.maxHeight);
        Rectangle limit2 = new Rectangle(0, 0, Utils.maxWidth * 2, Utils.maxHeight * 2);
        graphics2d.setPaint(new Color(60, 235, 232));
        graphics2d.fill(limit);

        graphics2d.setPaint(Color.ORANGE);
        for (Coin[] coinsRow : coins) {
            for (Coin coin : coinsRow) {
                if ( coin.isShow() ) {
                    graphics2d.fill(coin.getShape());
                }
            }
        }

        graphics2d.setPaint(Color.BLUE);
        graphics2d.fill(ball.getShape());

        graphics2d.setPaint(Color.GRAY);
        graphics2d.fill(Palette.getShape());

        graphics2d.setPaint(Color.BLACK);
        graphics2d.drawString("Ilość żyć: ", Utils.maxWidth + 10, 20);
        graphics2d.setFont(graphics2d.getFont().deriveFont(50.0F));
        graphics2d.drawString(String.valueOf(Utils.lives), Utils.maxWidth + 20, 70);

        graphics2d.setPaint(Color.BLACK);
        graphics2d.setFont(graphics2d.getFont().deriveFont(30.0F));
        graphics2d.drawString("Punkty: ", Utils.maxWidth + 10, 200);
        graphics2d.drawString(String.valueOf(points), Utils.maxWidth + 40, 240);


        if ( Utils.lives == 0 ) {
            graphics2d.setPaint(new Color(183, 176, 187));
            graphics2d.fill(limit2);
            graphics2d.setPaint(Color.BLACK);
            graphics2d.setFont(graphics2d.getFont().deriveFont(50.0F));
            graphics2d.drawString("Przegrałeś, koniec gry", 30, 100);
        }

        if ( win() ) {
            graphics2d.setPaint(new Color(11, 165, 25));
            graphics2d.fill(limit2);
            graphics2d.setPaint(Color.BLACK);
            graphics2d.setFont(graphics2d.getFont().deriveFont(50.0F));
            graphics2d.drawString("Wygrałeś, koniec gry", 30, 100);
        }

    }

    public boolean win() {
        for (Coin[] coinsRow : coins) {
            for (Coin coin : coinsRow) {
                if ( coin.isShow() ) {
                    return false;
                }
            }
        }
        return true;
    }

    public void win2() {
        points = 0;
        for (Coin[] coinsRow : coins) {
            for (Coin coin : coinsRow) {
                if ( !coin.isShow() ) {
                    points++;
                }
            }
        }
    }

}
