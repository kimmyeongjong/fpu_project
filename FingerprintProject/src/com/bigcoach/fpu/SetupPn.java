package com.bigcoach.fpu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SetupPn extends JPanel implements ActionListener {
private Frame frame;
	
	private RoundButton enrollBtn, deleteBtn;
	private ImageButton exitBtn;
	private JPanel tablePn;
	
	private JTable userTable;
	private JScrollPane scrollpane;

	// set button icon
	private ImageIcon baseIcon = new ImageIcon("img/baseLogout.png");
	private ImageIcon pressedIcon = new ImageIcon("img/pressedLogout.png");
	
	String header[] = {"1", "2", "3"};
	String data[][] = {{"1-1", "1-2", "1-3"}};

	public SetupPn(Frame frame) {
		this.frame = frame;
		
		enrollBtn = new RoundButton("지문 등록");
		deleteBtn = new RoundButton("지문 삭제");
		
		setLayout(null);
		setBackground(new Color(245, 245, 245));

		// enrollBtn
		enrollBtn.setFont(new Font(Final.FONT, Font.BOLD, 24));
		enrollBtn.setBounds(Final.ARRIVE_BTN[0], Final.ARRIVE_BTN[1], Final.ARRIVE_BTN[2], Final.ARRIVE_BTN[3]);
		enrollBtn.addActionListener(this);
		this.add(enrollBtn);

		// deleteBtn
		deleteBtn.setFont(new Font(Final.FONT, Font.BOLD, 24));
		deleteBtn.setBounds(Final.DEPARTURE_BTN[0], Final.DEPARTURE_BTN[1], Final.DEPARTURE_BTN[2], Final.DEPARTURE_BTN[3]);
		deleteBtn.addActionListener(this);
		this.add(deleteBtn);

		// exitBtn
		exitBtn = new ImageButton(baseIcon, pressedIcon);
		exitBtn.setBounds(Final.CHANGE[0], Final.CHANGE[1], Final.CHANGE[2], Final.CHANGE[3]);
		exitBtn.addActionListener(this);
		this.add(exitBtn);
		// end Buttons
		
		tablePn = new JPanel();
		userTable = new JTable(data, header);
		scrollpane = new JScrollPane(userTable);
		tablePn.add(scrollpane);
		tablePn.setBounds(400, 0, 400, 480);
		this.add(tablePn);
		tablePn.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitBtn) {
			frame.cards.show(frame.backPn, "basePn");
			tablePn.setVisible(false);
			if(!deleteBtn.isVisible()) {
				deleteBtn.setVisible(true);
			}
		} else if(e.getSource() == enrollBtn) {
			if(tablePn.isVisible()) {
				tablePn.setVisible(false);
				deleteBtn.setVisible(true);
			} else {
				tablePn.setVisible(true);
				deleteBtn.setVisible(false);
			}
		} else if(e.getSource() == deleteBtn) {
			
		}
	}
	
	// int가 주어지면 char값으로 변환해주고 배열을 만듬
	public static byte[] setChar(int input) {		
		String str = Integer.toString(input);
		char[] charArr = str.toCharArray();
		byte[] byteArr = new byte[charArr.length + 1];
		
		for(int i = 0; i < byteArr.length; i++) {
			if(i == byteArr.length - 1) {
				byteArr[i] = 10;
			} else {
				byteArr[i] = (byte)charArr[i];
			}
		}
		return byteArr;
	}
}
