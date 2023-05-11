package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import com.javalec.dao.ViewCollectionDao_KMJ;
import com.javalec.dto.ViewCollectionDto_KMJ;
import com.javalec.function.ViewCollectionRoundButton_KMJ;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;

public class ViewCollectionMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel lbMc;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCollectionMain frame = new ViewCollectionMain();
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
	public ViewCollectionMain() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextField());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 428, 20);
		contentPane.add(panel);
		contentPane.add(getScrollPane());
		contentPane.add(getLbMc());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setFont(new Font("LG Smart UI SemiBold", Font.PLAIN, 16));
			textField.setText("구매한 컬렉션 목록");
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setBackground(new Color(143, 126, 173));
			textField.setBounds(37, 155, 350, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(37, 175, 350, 428);
			scrollPane.setViewportView(getPanel_1());
			
			
			
			
		}
		return scrollPane;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			//JPanel panel_2 = new JPanel();
			panel_1.setBounds(37, 175, 350, 428);
			panel_1.setLayout(new GridLayout(0,3,0,0));
			ViewCollectionDao_KMJ dao = new ViewCollectionDao_KMJ("ajw2002","tutor002_001");
			
			ArrayList<ViewCollectionDto_KMJ> dto = dao.selectAction();
			ArrayList<String> menu = new ArrayList<String>();
			
			for(int i=0; i<dto.size();i++) {
				System.out.println(dto.get(i).getConame());
			}
			
			//DB값 넣기
			
			int num = dto.size();
			if(dto.size()<20)
			num = 20;
			
			for(int i=0;i<num;i++) {
				if(i<dto.size()) {
					menu.add(dto.get(i).getConame());					
				}else {
					menu.add(" ");
				}
			}
			
			int m_Size = menu.size();
			JPanel lb_Coll[] = new JPanel[m_Size];
			JLabel lb_Name[] = new JLabel[m_Size];
			JLabel lb_Coll2[] = new JLabel[m_Size];
			for(int i=0;i<m_Size;i++) {
				String a = Integer.toString(i);
				if(i<dto.size()) {
					
					lb_Coll[i] = new JPanel();
					lb_Coll2[i] = new JLabel(a);
					lb_Coll[i].add(lb_Coll2[i]);
					lb_Name[i] = new JLabel(menu.get(i));
					lb_Coll2[i].setHorizontalAlignment(JLabel.CENTER);
					lb_Name[i].setHorizontalAlignment(JLabel.CENTER);
				}else {
					lb_Coll[i] = new JPanel();
					lb_Coll2[i] = new JLabel(" ");
					lb_Coll[i].add(lb_Coll2[i]);
					lb_Name[i] = new JLabel(" ");
					lb_Coll[i].add(lb_Coll2[i]);
					lb_Coll2[i].setHorizontalAlignment(JLabel.CENTER);
					lb_Name[i].setHorizontalAlignment(JLabel.CENTER);
				}
				
			}
			
			for(int i=0;i<m_Size;i++) {
				JPanel collPanel = new JPanel(new BorderLayout());
				collPanel.setPreferredSize(new Dimension(100,150));
				lb_Coll[i].setPreferredSize(new Dimension(100,150));
				lb_Coll2[i].setPreferredSize(new Dimension(100,150));
				collPanel.add(lb_Coll[i],BorderLayout.CENTER);
				collPanel.add(lb_Name[i],BorderLayout.SOUTH);
				
				panel_1.add(collPanel);
			}
			
			
		}
		return panel_1;
	}
	private JLabel getLbMc() {
		if (lbMc == null) {
			lbMc = new JLabel("");
			lbMc.setIcon(new ImageIcon(ViewCollectionMain.class.getResource("/com/javalec/assets/101 Logo.png")));
			lbMc.setBounds(167, 27, 101, 48);
		}
		return lbMc;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ViewCollectionMain.class.getResource("/com/javalec/assets/Back.png")));
			lblNewLabel.setBounds(48, 79, 48, 48);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("안재원님!");
			lblNewLabel_1.setFont(new Font("LG Smart UI Bold", Font.PLAIN, 16));
			lblNewLabel_1.setIcon(new ImageIcon(ViewCollectionMain.class.getResource("/com/javalec/assets/hello.png")));
			lblNewLabel_1.setBounds(268, 79, 145, 48);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setIcon(new ImageIcon(ViewCollectionMain.class.getResource("/com/javalec/assets/Group 33.png")));
			btnNewButton.setBounds(41, 693, 346, 102);
		}
		return btnNewButton;
	}
}

