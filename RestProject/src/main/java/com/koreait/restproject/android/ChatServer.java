package com.koreait.restproject.android;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame{
	JPanel p_north; 
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	Thread thread; //서버 가동 쓰레드, 메인쓰레드가 서버소켓의 accept() 에 의해 대기상태에 빠지면 안되므로.. 
	ServerSocket server;//접속 감지목적의 소켓
	
	public ChatServer() {
		p_north = new JPanel();
		t_port = new JTextField("9999", 20);
		bt_start = new JButton("가동");
		area = new JTextArea();
		scroll= new JScrollPane(area);
		
		p_north.add(t_port);
		p_north.add(bt_start);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startServer();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				stopServer();
			}
		});
		
		setSize(300, 400);
		setVisible(true);
	}
	
	public void startServer() {
		thread = new Thread() {
			public void run() {
				try {
					server = new ServerSocket(Integer.parseInt(t_port.getText()));
					Socket client = server.accept(); //클라이언트 접속할때까지 대기
					
					System.out.println("접속 감지!!");
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();//쓰레드 가동
	}
	
	public void stopServer() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
