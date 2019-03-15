package com.bigcoach.fpu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BasePn extends JPanel implements ActionListener {
	private Frame frame;
	
	private SerialReader reader;
	private SerialWriter writer;
	private Serial serial;
	
	private RoundButton arriveBtn, departureBtn;
	private ImageButton setupBtn;

	// set button icon
	private ImageIcon baseIcon = new ImageIcon("img/baseIcon.png");
	private ImageIcon pressedIcon = new ImageIcon("img/pressedIcon.png");
	
	public BasePn(Frame frame, Serial serial) {
		this.frame = frame;
		this.serial = serial;
		
		this.reader = serial.getReader();
		this.writer = serial.getWriter();
		
		arriveBtn = new RoundButton("등교");
		departureBtn = new RoundButton("하교");

		setLayout(null);
		setBackground(new Color(245, 245, 245));

		// arriveBtn
		arriveBtn.setFont(new Font(Final.FONT, Font.BOLD, 24));
		arriveBtn.setBounds(Final.ARRIVE_BTN[0], Final.ARRIVE_BTN[1], Final.ARRIVE_BTN[2], Final.ARRIVE_BTN[3]);
		arriveBtn.addActionListener(this);
		this.add(arriveBtn);

		// departureBtn
		departureBtn.setFont(new Font(Final.FONT, Font.BOLD, 24));
		departureBtn.setBounds(Final.DEPARTURE_BTN[0], Final.DEPARTURE_BTN[1], Final.DEPARTURE_BTN[2], Final.DEPARTURE_BTN[3]);
		departureBtn.addActionListener(this);
		this.add(departureBtn);

		// setupBtn
		setupBtn = new ImageButton(baseIcon, pressedIcon);
		setupBtn.setBounds(Final.CHANGE[0], Final.CHANGE[1], Final.CHANGE[2], Final.CHANGE[3]);
		setupBtn.addActionListener(this);
		this.add(setupBtn);
		// end Buttons
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == setupBtn) {
			frame.cards.show(frame.backPn, "setupPn");
		} else if(e.getSource() == arriveBtn) {
			try {
				writer.out.write(50);
				writer.out.write(10);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else if(e.getSource() == departureBtn) {
			try {
				writer.out.write(50);
				writer.out.write(10);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}
}
