package section13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Win1 extends JFrame{
	
	JFrame fr1;
	
	JButton jb1 = new JButton("새 창");
	
	
	Win1(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jb1);
		this.setSize(400, 300);
		this.setLocation(500, 500);
		this.setVisible(true);
		
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jb1.setEnabled(false);
				fr1 = new JFrame("새 창");
				JButton bt1 = new JButton("닫기");
				Container c = fr1.getContentPane();
				c.setLayout(new FlowLayout());
				c.add(bt1);
				fr1.setSize(400, 300);
				fr1.setLocation(500, 500);
				fr1.setVisible(true);
				bt1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						fr1.setVisible(false);
						jb1.setEnabled(true);

					}
				});
				
			}
		});
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Win1();
	}
	
	
}
