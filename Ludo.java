import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class Ludo extends JFrame implements ActionListener
{
 Button button;
 
 Button a[] = new Button[18];
 Button c[] = new Button[18];
 Button d[] = new Button[18];
 Button e[] = new Button[18];
 
 Label win,left,right;
 
 Button r[] = new Button[4];
 Button g[] = new Button[4];
 Button b[] = new Button[4];
 Button y[] = new Button[4];
 
 Button winBtn[] = new Button[36];
 
 Button roll;
 TextField rollRes;
 
 Random random = new Random();
 int rr;
 
 public static int PlayerTurn = 0;
 
	public Ludo()
	{
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.setFont(new Font("Arial",Font.BOLD,20));
		ct.setBackground(Color.black);
		
		Label ludo = new Label("!!!...Ludo...!!!",Label.CENTER);
		ludo.setForeground(Color.white);
		ct.add(ludo,BorderLayout.NORTH);
		
		Panel south = new Panel();
		south.setLayout(new FlowLayout());
		
				roll = new Button("ROLL");
				roll.setBackground(Color.cyan);
				roll.addActionListener(this);
				rollRes = new TextField(15);
				rollRes.setFont(new Font("Arial",Font.BOLD,30));
				rollRes.setEditable(false);
		
				south.add(roll);
				south.add(rollRes);
				
		ct.add(south,BorderLayout.SOUTH);
		
		left = new Label("   ",Label.CENTER);
		left.setForeground(Color.white);
		ct.add(left,BorderLayout.EAST);
		
		right = new Label("   ",Label.CENTER);
		right.setForeground(Color.white);
		ct.add(right,BorderLayout.WEST);
		
		
		Panel main = new Panel();
		main.setLayout(new GridLayout(3,3));
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2,2));
		{
				for(int i=0;i<4;i++)
				{
					r[i] = new Button();
					r[i].setEnabled(false);
					r[i].setBackground(Color.red);
					
					r[i].setLabel("R" + (i+1));
					
					p1.add(r[i]);
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		Panel p3 = new Panel();
		p3.setLayout(new GridLayout(2,2));
		{
				for(int i=0;i<4;i++)
				{
					g[i] = new Button();
					g[i].setEnabled(false);
					g[i].setBackground(Color.green);
					
					g[i].setLabel("G" + (i+1));
					
					p3.add(g[i]);
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		Panel p7 = new Panel();
		p7.setLayout(new GridLayout(2,2));
		{
				for(int i=0;i<4;i++)
				{
					b[i] = new Button();
					b[i].setEnabled(false);
					b[i].setBackground(Color.blue);
					
					b[i].setLabel("B" + (i+1));
					
					p7.add(b[i]);
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		Panel p9 = new Panel();
		p9.setLayout(new GridLayout(2,2));
		{
				for(int i=0;i<4;i++)
				{
					y[i] = new Button();
					y[i].setEnabled(false);
					y[i].setBackground(Color.yellow);
					
					y[i].setLabel("Y" + (i+1));
					
					p9.add(y[i]);					
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(6,3));
		
		for(int i=0;i<18;i++)
		{
				a[i] = new Button();
				a[i].setEnabled(false);
				p2.add(a[i]);
				
				if(i==4 || i==5 || i==6 || i==7 || i==10 || i==13 || i==16 )
				{
						a[i].setBackground(Color.green);
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		Panel p4 = new Panel();
		p4.setLayout(new GridLayout(3,6));
		
		for(int i=0;i<18;i++)
		{
				c[i] = new Button();
				c[i].setEnabled(false);
				p4.add(c[i]);
				
				if(i==1 || i==7 || i==8 || i==9 || i==10 || i==11 || i==14)
				{
						c[i].setBackground(Color.red);
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		Panel p5 = new Panel();
		p5.setLayout(new GridLayout(6,6));
		{
			for(int i=0;i<36;i++)
				{
				winBtn[i] = new Button();
				winBtn[i].setEnabled(false);
				winBtn[i].setBackground(Color.black);
				p5.add(winBtn[i]);
				
						if(i==12 || i==13 || i==18 || i==19)
						{
							winBtn[i].setBackground(Color.red);
						}
						else if(i==2 || i==3 || i==8 || i==9)
						{
							winBtn[i].setBackground(Color.green);
						}
						else if(i==16 || i==17 || i==22 || i==23)
						{
							winBtn[i].setBackground(Color.yellow);
						}
						else if(i==26 || i==27 || i==32 || i==33)
						{
							winBtn[i].setBackground(Color.blue);
						}
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		Panel p6 = new Panel();
		p6.setLayout(new GridLayout(3,6));
		
		for(int i=0;i<18;i++)
		{
				d[i] = new Button();
				d[i].setEnabled(false);
				p6.add(d[i]);
				
				if(i==3 || i==6 || i==7 || i==8 || i==9 || i==10 || i==16)
				{
						d[i].setBackground(Color.yellow);
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		Panel p8 = new Panel();
		p8.setLayout(new GridLayout(6,3));
		
		for(int i=0;i<18;i++)
		{
				e[i] = new Button();
				e[i].setEnabled(false);
				p8.add(e[i]);
				
				if(i==1 || i==4 || i==7 || i==10 || i==11 || i==12 || i==13 )
				{
						e[i].setBackground(Color.blue);
				}
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		main.add(p1);
		main.add(p2);
		main.add(p3);
		main.add(p4);
		main.add(p5);
		main.add(p6);
		main.add(p7);
		main.add(p8);
		main.add(p9);
		
		
		ct.add(main);
	}
///////////////////////////////////////////////////////////////!!1...GUI COMPLETED...!!!////////////////////////////////////////////////////////////////	
	public void Player1(int rr)
		{
						if(rr == 6)
							{
								for(int i=0;i<4;i++)
								{	
												if(i==0)
												{
													String s = r[i].getLabel();
													
																if(s=="R1")
																{
																	c[1].setLabel("R1");
																	r[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==1)
												{
													String s = r[i].getLabel();
													
																if(s=="R2")
																{
																	c[1].setLabel("R2");
																	r[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==2)
												{
													String s = r[i].getLabel();
										
																if(s=="R3")
																{
																	c[1].setLabel("R3");
																	r[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==3)
												{
													String s = r[i].getLabel();
													
																if(s=="R4")
																{
																	c[1].setLabel("R4");
																	r[i].setLabel(null);
																	break;
																}
												}	
								}
							}
		}
		
		public void Player2(int rr)
		{
							if(rr == 6)
							{
								for(int i=0;i<4;i++)
								{	
												if(i==0)
												{
													String s = g[i].getLabel();
													
																if(s=="G1")
																{
																	a[5].setLabel("G1");
																	g[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==1)
												{
													String s = g[i].getLabel();
													
																if(s=="G2")
																{
																	a[5].setLabel("G2");
																	g[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==2)
												{
													String s = g[i].getLabel();
										
																if(s=="G3")
																{
																	a[5].setLabel("G3");
																	g[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==3)
												{
													String s = g[i].getLabel();
													
																if(s=="G4")
																{
																	a[5].setLabel("G4");
																	g[i].setLabel(null);
																	break;
																}
												}	
								}
							}
		}	
		
		public void Player3(int rr)
		{
				
							if(rr == 6)
							{
								for(int i=0;i<4;i++)
								{	
												if(i==0)
												{
													String s = y[i].getLabel();
													
																if(s=="Y1")
																{
																	d[16].setLabel("Y1");
																	y[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==1)
												{
													String s = y[i].getLabel();
													
																if(s=="Y2")
																{
																	d[16].setLabel("Y2");
																	y[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==2)
												{
													String s = y[i].getLabel();
										
																if(s=="Y3")
																{
																	d[16].setLabel("Y3");
																	y[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==3)
												{
													String s = y[i].getLabel();
													
																if(s=="Y4")
																{
																	d[16].setLabel("Y4");
																	y[i].setLabel(null);
																	break;
																}
												}
								}
							}
		}
	
	public void Player4(int rr)
	{
		
							if(rr == 6)
							{
								for(int i=0;i<4;i++)
								{	
												if(i==0)
												{
													String s = b[i].getLabel();
													
																if(s=="B1")
																{
																	e[12].setLabel("B1");
																	b[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==1)
												{
													String s = b[i].getLabel();
													
																if(s=="B2")
																{
																	e[12].setLabel("B2");
																	b[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==2)
												{
													String s = b[i].getLabel();
										
																if(s=="B3")
																{
																	e[12].setLabel("B3");
																	b[i].setLabel(null);
																	break;
																}
												}
												
												else if(i==3)
												{
													String s = b[i].getLabel();
													
																if(s=="B4")
																{
																	e[12].setLabel("B4");
																	b[i].setLabel(null);
																	break;
																}
												}
								}
							}				
	}

	
	public void win()
	{
		
		for(int i=0;i<36;i++)
		{
							
			String s1 = winBtn[12].getLabel();
			String t1 = winBtn[13].getLabel();
			String u1 = winBtn[18].getLabel();
			String v1 = winBtn[19].getLabel();
			
			String s2 = winBtn[2].getLabel();
			String t2 = winBtn[3].getLabel();
			String u2 = winBtn[8].getLabel();
			String v2 = winBtn[9].getLabel();
														
			String s3 = winBtn[16].getLabel();
			String t3 = winBtn[17].getLabel();
			String u3 = winBtn[22].getLabel();
			String v3 = winBtn[23].getLabel();
							
			String s4 = winBtn[26].getLabel();
			String t4 = winBtn[27].getLabel();
			String u4 = winBtn[32].getLabel();
			String v4 = winBtn[33].getLabel();
								
			if(s1== "R1" && t1=="R2" && u1=="R3" && v1=="R4")
				{
					String win = "Player 1 Wins"; 
					rollRes.setText(win);
					roll.setEnabled(false);
					break;
				}
				
			else if(s2== "G1" && t2=="G2" && u2=="G3" && v2=="G4")
				{
					String win = "Player 2 Wins"; 
					rollRes.setText(win);
					roll.setEnabled(false);
					break;
				}
				
			else if(s3== "Y1" && t3=="Y2" && u3=="Y3" && v3=="Y4")
				{
					String win = "Player 3 Wins"; 
					rollRes.setText(win);
					roll.setEnabled(false);
					break;
				}
			
			else if(s4== "B1" && t4=="B2" && u4=="B3" && v4=="B4")
				{
					String win = "Player 4 Wins"; 
					rollRes.setText(win);
					roll.setEnabled(false);
					break;
				}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Object ob = ae.getSource();
		int rr = random.nextInt(6)+1;
	
		
		if(PlayerTurn == "P")
		{
			rollRes.setText("               "+rr + "");
			rollRes.setBackground(Color.red);
			
			win();
			Player1(rr);
			PlayerTurn = "PP";
		}
		
		else if(PlayerTurn == "PP")
		{
			rollRes.setText("               "+rr + "");
			rollRes.setBackground(Color.green);
			
			win();
			Player2(rr);
			PlayerTurn = "PPP";
		}
		
		else if(PlayerTurn == "PPP")
		{
			rollRes.setText("               "+rr + "");
			rollRes.setBackground(Color.yellow);
					
			win();
			Player3(rr);
			PlayerTurn = "PPPP";
		}
		
		else if(PlayerTurn== "PPPP")
		{
			rollRes.setText("               "+rr + "");
			rollRes.setBackground(Color.blue);
		
			win();
			Player4(rr);
			PlayerTurn = "P";
		}	
		
	}
	
	public void move()
	{
		// To be continued
		
		
	}
	
	public static void main(String args[])
	{
	  Ludo l = new Ludo();
	  l.setSize(600,600);
	  l.setVisible(true);
	  l.setTitle("!!..Game Or What..!!");
	}
}