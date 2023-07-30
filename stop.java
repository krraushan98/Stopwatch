import java.awt.*;
import java.awt.event.*;
class Stopwatch extends Frame implements Runnable,ActionListener
{
	Label l=new Label("Stop Watch");
	Label l1=new Label("H");
	Label l2=new Label("M");
	Label l3=new Label("S");
	Thread t;
	
	Label f=new Label();
	Label f1=new Label();
	Label f2=new Label();
	Button b1=new Button("Start");
	Button b2=new Button("Stop");
	Button b3=new Button("Reset");
	Button b4=new Button("Cancel");
	long i;
	int j,h,m;
	Stopwatch()
	{
		setLayout(null);
		setFont(new Font("Arial",Font.BOLD,20));
		l.setBounds(150,50,160,40);
		l1.setBounds(130,105,25,30);
		l2.setBounds(185,105,25,30);
		l3.setBounds(240,105,25,30);
		f.setBounds(130,145,50,30);
		f1.setBounds(185,145,50,30);
		f2.setBounds(240,145,50,30);
		b1.setBounds(130,190,55,30);
		b2.setBounds(200,190,55,30);
		b3.setBounds(127,230,60,30);
		b4.setBounds(201,230,65,30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		add(l);add(f);add(l1);add(l2);add(l3);add(f1);add(f2);
		add(b1);add(b2);add(b3);add(b4);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setSize(400,400);
		setVisible(true);
		f.setText("0");
		f1.setText("0");
		f2.setText("0");
		setBackground(Color.black);
		l.setBackground(Color.black);
		l1.setBackground(Color.black);
		l2.setBackground(Color.black);
		l3.setBackground(Color.black);
		f.setBackground(Color.black);
		f2.setBackground(Color.black);
		f1.setBackground(Color.black);
		b1.setBackground(Color.black);
		b2.setBackground(Color.black);
		b3.setBackground(Color.black);
		b4.setBackground(Color.black);
		l.setForeground(Color.blue);
		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		f.setForeground(Color.blue);
		f1.setForeground(Color.blue);
		f2.setForeground(Color.blue);
		b1.setForeground(Color.blue);
		b2.setForeground(Color.blue);
		b3.setForeground(Color.blue);
		b4.setForeground(Color.blue);
	}
		public void run()
		{
			while(true)
			{
				f2.setText(String.valueOf(i));
				i++;
				if(i>60)
				{
					i=0;
					m++;
					f1.setText(String.valueOf(m));
				}
				else if(m>60)
				{
					m=0;
					h++;
					f.setText(String.valueOf(h));
				}
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{}
			}
		}
	
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getSource()==b1)
			{
				t=new Thread(this);
				t.start();
				j=1;
				if(j==1)
				b1.setVisible(false);
			}
			else if(e.getSource()==b2)
			{
				t.stop();
				b1.setVisible(true);
			}
			else if(e.getSource()==b3)
			{
				t.stop();
				i=0;m=0;h=0;
				f.setText("0");
				f1.setText("0");
				f2.setText("0");
				b1.setVisible(true);
			}
			else if(e.getSource()==b4)
			{
				System.exit(0);
			}
			
		}
	
	}
	class stop 
	{
		public static void main(String args[])
		{
			new Stopwatch();
		}
	}
	
	
			