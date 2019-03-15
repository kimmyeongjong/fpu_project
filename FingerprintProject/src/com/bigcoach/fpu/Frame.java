package com.bigcoach.fpu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame implements ActionListener {
	JFrame mainFrame;
	JPanel backPn;
	BasePn basePn;
	SetupPn setupPn;
	
	CardLayout cards;
	
	private Serial serial = new Serial();
	
	public Frame() {
		mainFrame = new JFrame("Attendance");
		backPn = new JPanel();			// 기본 패널
		try {
            serial.connect("/dev/ttyUSB0");
        } catch (Exception e) {
            e.printStackTrace();
        }
		basePn = new BasePn(this, serial);		// 등교 하교가 있는 패널
		setupPn = new SetupPn(this);	// 등록 삭제가 있는 패널
		
		cards = new CardLayout(0, 0);	// 카드 레이아웃 생성
		backPn.setLayout(cards);
		
		// set Frame
		mainFrame.setSize(800, 480);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		
		// add component to the backPn
		backPn.add(basePn, "basePn");
		backPn.add(setupPn, "setupPn");
		
		// show mainFrame
		mainFrame.add(backPn);
		mainFrame.setUndecorated(true);
		mainFrame.setVisible(true);
		
		cards.show(backPn, "basePn");
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		
	}
}
