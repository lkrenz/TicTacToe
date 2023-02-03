import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private Square[][] board;
    private static final int    WINDOW_WIDTH = 500,
                                WINDOW_HEIGHT = 500;
    private static final int BOX_SIZE = 100;
    private int height;

    private boolean isGameOver;
    private Image[] images;

    private String winner;


    public TicTacToeViewer(Square[][] board)
    {
        this.isGameOver = false;
        this.board = board;
        images = new Image[2];
        this.images[0] = new ImageIcon("Resources/X.png").getImage();
        this.images[1] = new ImageIcon("Resources/O.png").getImage();
        for(int row = 0; row < this.board.length; row++) {
            for(int col = 0; col< this.board[row].length; col++) {
                this.board[row][col] = new Square(row, col, this);
            }
        }
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return images;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public void setWinner(String winner)
    {
        this.winner = winner;
    }

    public void drawGrid(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Times", Font.PLAIN, 30));
        for (int i = 0; i < 3; i++)
        {
            g.drawString("" + i, 150 + i * 95, 75);
            g.drawString("" + i, 53, 172 + i * 95);
        }
        g.setColor(Color.BLACK);
        g.drawLine(100, 100, 400, 100);
        g.drawLine(100, 100, 100, 400);
        g.drawLine(400, 100, 400, 400);
        g.drawLine(100, 400, 400, 400);
        g.drawLine(200, 100, 200, 400);
        g.drawLine(300, 100, 300, 400);
        g.drawLine(100, 200, 400, 200);
        g.drawLine(100, 300, 400, 300);
    }

    public void paint(Graphics g)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j].draw(g);
            }
        }
        drawGrid(g);
        if (isGameOver)
        {
            g.setFont(new Font("Times", Font.PLAIN, 40));
            g.setColor(Color.BLACK);
            g.drawString(winner + " Wins!", 175, 450);
        }
    }

}
