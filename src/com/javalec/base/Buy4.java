package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.util.ShareVar;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class Buy4 extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblhello;
	private JLabel lblMainLogo;
	private JLabel lblokLogo;
	private JLabel lbla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy4 frame = new Buy4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Buy4() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblName.setText(ShareVar.u_name+"님!");
			}
		});
		setBackground(UIManager.getColor("Button.background"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getLblhello());
		contentPane.add(getLblMainLogo());
		contentPane.add(getLblokLogo());
		contentPane.add(getLbla());
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setBounds(338, 89, 75, 37);
		}
		return lblName;
	}

	// hello 로고
	private JLabel getLblhello() {
		if (lblhello == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/hello.png");
			lblhello = new JLabel("");
			lblhello.setBounds(268, 81, 64, 33);
			lblhello.setIcon(icon);
		}
		return lblhello;
	}

	// 메인로고 이미지
	private JLabel getLblMainLogo() {
		if (lblMainLogo == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/MyCardMainLogo.png");
			lblMainLogo = new JLabel("");
			lblMainLogo.setBounds(162, 6, 139, 75);
			lblMainLogo.setIcon(icon);
		}
		return lblMainLogo;
	}

	// 구매 완료 이미지
	private JLabel getLblokLogo() {
		if (lblokLogo == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/assets/Buy4text.png");
			lblokLogo = new JLabel("");
			lblokLogo.setBounds(36, 544, 321, 113);
			lblokLogo.setIcon(icon);
		}
		return lblokLogo;
	}
	private JLabel getLbla() {
		if (lbla == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/assets/aCard.png");
			lbla = new JLabel("");
			lbla.setBounds(72, 155, 301, 338);
			lbla.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					changepage();
				}
			});
			lbla.setIcon(icon);
		}
		return lbla;
	}
	
	private void changepage() {
		setVisible(false);
		MainView mainview = new MainView();
		mainview.setVisible(true);
	}
}
