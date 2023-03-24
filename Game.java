import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y; 
	private Board b;
	private int mouseClicks;
	private Player p;
	
	
	
	
	
	
	
	
	
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		x=0;
		y=0;
		b= new Board();	
		mouseClicks= 0;
		p=new Player();

	}
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		//g2d.drawImage(background.getImage(), 0, 0, getSize().width, getSize().height, this);
		
		
            Color color= new Color(255,255,255);
            g2d.setColor(color);
			g2d.setFont(new Font("Times New Roman", Font.BOLD, 70));
		for (int i=0; i<3;i++) {
			for(int j=0; j<3; j++) {
				g2d.drawString(b.getBoard(i,j), 200*i+30, 200*j+50);
			}
		}
		
		if(b.gameBoard[2][2].equals("x")&&b.gameBoard[1][2].equals("x")&& b.gameBoard[0][2].equals("x")||b.gameBoard[2][1].equals("x")&&b.gameBoard[1][1].equals("x")&&b.gameBoard[0][1].equals("x")||b.gameBoard[2][0].equals("x")&&b.gameBoard[1][0].equals("x")&&b.gameBoard[0][0].equals("x")||b.gameBoard[0][0].equals("x")&&b.gameBoard[0][1].equals("x")&&b.gameBoard[0][2].equals("x")||b.gameBoard[1][0].equals("x")&&b.gameBoard[1][1].equals("x")&&b.gameBoard[1][2].equals("x")||b.gameBoard[2][0].equals("x")&&b.gameBoard[2][1].equals("x")&&b.gameBoard[2][2].equals("x")||b.gameBoard[0][0].equals("x")&&b.gameBoard[1][1].equals("x")&&b.gameBoard[2][2].equals("x")||b.gameBoard[2][0].equals("x")&&b.gameBoard[1][1].equals("x")&&b.gameBoard[0][2].equals("x")) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, 800, 600);
			g2d.setColor(Color.CYAN);
			g2d.drawString("X WON!", 265, 200);
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("Times New Roman", Font.BOLD, 50));
			g2d.drawString("RESTART TO PLAY AGAIN", 80, 400);
		}
			if(b.gameBoard[2][2].equals("o")&&b.gameBoard[1][2].equals("o")&& b.gameBoard[0][2].equals("o")||b.gameBoard[2][1].equals("o")&&b.gameBoard[1][1].equals("o")&&b.gameBoard[0][1].equals("o")||b.gameBoard[2][0].equals("o")&&b.gameBoard[1][0].equals("o")&&b.gameBoard[0][0].equals("o")||b.gameBoard[0][0].equals("o")&&b.gameBoard[0][1].equals("o")&&b.gameBoard[0][2].equals("o")||b.gameBoard[1][0].equals("o")&&b.gameBoard[1][1].equals("o")&&b.gameBoard[1][2].equals("o")||b.gameBoard[2][0].equals("o")&&b.gameBoard[2][1].equals("o")&&b.gameBoard[2][2].equals("o")||b.gameBoard[0][0].equals("o")&&b.gameBoard[1][1].equals("o")&&b.gameBoard[2][2].equals("o")||b.gameBoard[2][0].equals("o")&&b.gameBoard[1][1].equals("o")&&b.gameBoard[0][2].equals("o")) {
				g2d.setColor(Color.BLACK);
				g2d.fillRect(0, 0, 800, 600);
				g2d.setColor(Color.CYAN);
				g2d.drawString("O WON!", 265, 200);
				g2d.setColor(Color.WHITE);
				g2d.setFont(new Font("Times New Roman", Font.BOLD, 50));
				g2d.drawString("RESTART TO PLAY AGAIN", 80, 400);
				
		}
		

		g2d.setColor(Color.WHITE);
		//g2d.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//g2d.drawString("KEY "+ key, 600, 30);
		
	
			
			

		twoDgraph.drawImage(back, null, 0, 0);
		

	}
	
@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		p.playmusic("startsound.wav");
		System.out.println("x="+e.getX());
		System.out.println("y="+e.getY());
		if (e.getX()<490 && e.getY()<486 && e.getX()>355 && e.getY()>304) {
			if(mouseClicks%2==0) {
				b.changeSpot(2, 2, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(2, 2, "x");
				}
	          mouseClicks++;
			}
		if (e.getX()<355 && e.getY()<486 && e.getX()>139 && e.getY()>304) {
			if(mouseClicks%2==0) {
				b.changeSpot(1, 2, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(1, 2, "x");
				}
	          mouseClicks++;
			}
		if (e.getX()<139 && e.getY()<486 && e.getY()>304) {
			if(mouseClicks%2==0) {
				b.changeSpot(0, 2, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(0, 2, "x");
				}
	          mouseClicks++;
			}
		if (e.getX()<490 && e.getY()<304 && e.getX()>355 && e.getY()>159) {
			if(mouseClicks%2==0) {
				b.changeSpot(2, 1, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(2, 1, "x");
				}
	          mouseClicks++;
			}
		if (e.getX()<355 && e.getY()<304 && e.getX()>139 && e.getY()>159) {
			if(mouseClicks%2==0) {
				b.changeSpot(1, 1, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(1, 1, "x");
				}
	          mouseClicks++;
			}
		if (e.getX()<139 && e.getY()<304 && e.getY()>159) {
			if(mouseClicks%2==0) {
				b.changeSpot(0, 1, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(0, 1, "x");
				}
	          mouseClicks++;
			}
		if (e.getX()<490 && e.getY()<159 && e.getX()>355 && e.getY()>0) {
			if(mouseClicks%2==0) {
				b.changeSpot(2, 0, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(2, 0, "x");
				}
	          mouseClicks++;
			}
		if (e.getX()<355 && e.getY()<159 && e.getX()>139 && e.getY()>0) {
			if(mouseClicks%2==0) {
				b.changeSpot(1, 0, "o");
			}
				if(mouseClicks%2!=0) {
					b.changeSpot(1, 0, "x");
				}
	          mouseClicks++;
			}
	if (e.getX()<139 && e.getY()<159 && e.getY()>0) {
		if(mouseClicks%2==0) {
			b.changeSpot(0, 0, "o");
		}
			if(mouseClicks%2!=0) {
				b.changeSpot(0, 0, "x");
			}
          mouseClicks++;
		}
		}
	
		
		
	



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
 
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}




		



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		

		
		
		}
		
	
		
  
		
	
	
	
		
	
		
		
	
		
		
		
		
		
		



	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}
	
	
	

	
}


