import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.JButton;
import java.util.Random;

// Feito por: Matheus Herminio Da Silva RA: 201027747
// e Lucas Mendes Mussato Fernandes RA: 211022195

class JogoBase extends JFrame{
  Image img;
  Desenho des = new Desenho();
  Integer i = -1;


  class Desenho extends JPanel {
    public JButton ok;
    public JLabel texto, pontos;
    Random random = new Random();      


    private final int BUTTON_WIDTH = 36;
    private final int BUTTON_HEIGHT = 50;

    Desenho() {       
      
     
      Icon icon = new ImageIcon("alvo-red.png");
      JButton ok = new JButton(icon);
      add(ok);
     
     ok.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
          ok.setBounds(random.nextInt(getContentPane().getWidth() - BUTTON_WIDTH),
                        random.nextInt(getContentPane().getHeight() - BUTTON_HEIGHT), BUTTON_WIDTH,
                        BUTTON_HEIGHT);      
                        i++;
                        JLabel texto = new JLabel(""+i); 
                     //texto.setText(String.valueOf(i));
                         texto.setLocation(100,40);
                         System.out.println(i); 
                         add(texto);
                        if (i == 10){
                          
                          JOptionPane.showMessageDialog(null, "VC FEZ: "+ i +" pontos", "FIM DE JOGO", 1);
                          dispose();
                        }
      }
  });
  
      try{
       
             setCursor(Toolkit.getDefaultToolkit() .createCustomCursor(
                         new ImageIcon("mira.png").getImage(),
                         new Point(0,0),
                         "Cursor"
                  )
             );
        }catch(Exception e){}

        setSize(400, 400);
        setVisible(true);

      
      try {
        setPreferredSize(new Dimension(1000, 600));
        img = ImageIO.read(new File("aaa.jpg"));
      } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "A imagem não pode ser carregada!\n" + e, "Erro", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
      pontos = new JLabel("Pontos: ");
      pontos.setLocation(100,30);
      add(pontos);
    }


    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, getSize().width, getSize().height, this);
      Toolkit.getDefaultToolkit().sync();
    }
    
  }

         

  JogoBase() {
    super("Tiroteio III");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(des);
    pack();
    setVisible(true);
  }

  static public void main(String[] args) {
    JogoBase f = new JogoBase();
  }
}
