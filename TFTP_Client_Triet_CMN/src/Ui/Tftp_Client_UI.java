package Ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Tftp_Client_M;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Tftp_Client_UI extends JFrame {

	private JPanel contentPane;
	private JTextField txtHostName;
	private JTextField txtPort;
	private JTextField txtServerStatus;
	private JTextField txtFilenameGet;
	private JTextField txtFileNamePut;
	private JTextField txtStatusGet;
	private JTextField txtStatusPut;

	/* private JFileChooser jFileChooser1; */

	Tftp_Client_M tftp = new Tftp_Client_M();
	private JTextField txtSaveFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tftp_Client_UI frame = new Tftp_Client_UI();
					frame.setLocationRelativeTo(null);
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
	public Tftp_Client_UI() {
		setTitle("TFTP_Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * jFileChooser1.setDialogTitle("Choose File");
		 * 
		 * setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		 * setMinimumSize(new java.awt.Dimension(500, 300));
		 */
		txtHostName = new JTextField();
		txtHostName.setText("localhost");
		txtHostName.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtHostName.setBounds(185, 26, 318, 33);
		contentPane.add(txtHostName);
		txtHostName.setColumns(10);

		JLabel lblHostname_1 = new JLabel("HostName:");
		lblHostname_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHostname_1.setBounds(25, 25, 96, 34);
		contentPane.add(lblHostname_1);

		JLabel lblHostname_1_1 = new JLabel("Port:");
		lblHostname_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHostname_1_1.setBounds(25, 67, 96, 34);
		contentPane.add(lblHostname_1_1);

		txtPort = new JTextField();
		txtPort.setText("69");
		txtPort.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtPort.setColumns(10);
		txtPort.setBounds(185, 68, 318, 33);
		contentPane.add(txtPort);

		JLabel lblHostname_1_1_1 = new JLabel("Server Status:");
		lblHostname_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHostname_1_1_1.setBounds(25, 113, 142, 34);
		contentPane.add(lblHostname_1_1_1);

		txtServerStatus = new JTextField();
		txtServerStatus.setEditable(false);
		txtServerStatus.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtServerStatus.setColumns(10);
		txtServerStatus.setBounds(185, 116, 318, 33);
		contentPane.add(txtServerStatus);

		JLabel label = new JLabel(
				"________________________________________________________________________________________________________________________________________________________________________________");
		label.setBounds(12, 159, 789, 25);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(25, 196, 354, 335);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblGet = new JLabel("GET");
		lblGet.setBounds(12, 12, 26, 15);
		panel.add(lblGet);

		txtFilenameGet = new JTextField();
		txtFilenameGet.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtFilenameGet.setColumns(10);
		txtFilenameGet.setBounds(12, 73, 330, 33);
		panel.add(txtFilenameGet);

		JButton btnGet = new JButton("GET");
		btnGet.setEnabled(false);
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					evtBtnGet(arg0);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGet.setBounds(187, 283, 155, 25);
		panel.add(btnGet);

		JLabel lblHostname_1_1_1_1 = new JLabel("Enter File Name :");
		lblHostname_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHostname_1_1_1_1.setBounds(12, 46, 142, 15);
		panel.add(lblHostname_1_1_1_1);

		JLabel lblStatus1 = new JLabel("Status:");
		lblStatus1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStatus1.setBounds(12, 192, 142, 34);
		panel.add(lblStatus1);

		txtStatusGet = new JTextField();
		txtStatusGet.setEditable(false);
		txtStatusGet.setText("Status");
		txtStatusGet.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtStatusGet.setColumns(10);
		txtStatusGet.setBounds(12, 238, 330, 33);
		panel.add(txtStatusGet);

		JLabel lblHostname_1_1_1_1_3 = new JLabel("Save to : ");
		lblHostname_1_1_1_1_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHostname_1_1_1_1_3.setBounds(12, 107, 105, 34);
		panel.add(lblHostname_1_1_1_1_3);

		txtSaveFile = new JTextField();
		txtSaveFile.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtSaveFile.setColumns(10);
		txtSaveFile.setBounds(12, 147, 330, 33);
		panel.add(txtSaveFile);

		JButton btnSave = new JButton("Direction");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("Choose file");
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				jFileChooser.getSelectedFile();
				int userSelection = jFileChooser.showSaveDialog(null);
				txtSaveFile.setText(jFileChooser.getSelectedFile().getAbsolutePath());
			}
		}

		);
		btnSave.setBounds(187, 112, 155, 25);
		panel.add(btnSave);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(417, 196, 354, 335);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPut = new JLabel("PUT");
		lblPut.setBounds(12, 12, 27, 15);
		panel_1.add(lblPut);

		JLabel lblHostname_1_1_1_1_1 = new JLabel("Choose File:");
		lblHostname_1_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHostname_1_1_1_1_1.setBounds(12, 40, 142, 15);
		panel_1.add(lblHostname_1_1_1_1_1);

		txtFileNamePut = new JTextField();
		txtFileNamePut.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtFileNamePut.setColumns(10);
		txtFileNamePut.setBounds(12, 74, 330, 33);
		panel_1.add(txtFileNamePut);

		JButton btnSelect = new JButton("Choose");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("Choose file");
				int result = jFileChooser.showSaveDialog(null);
				txtFileNamePut.setText(jFileChooser.getSelectedFile().getAbsolutePath());
			}
		});
		btnSelect.setBounds(187, 115, 155, 25);
		panel_1.add(btnSelect);

		JButton btnPut = new JButton("PUT");
		btnPut.setEnabled(false);
		btnPut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					evtBtnPut(arg0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnPut.setBounds(187, 281, 155, 25);
		panel_1.add(btnPut);

		JLabel lblHostname_1_1_1_1_2 = new JLabel("Status:");
		lblHostname_1_1_1_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHostname_1_1_1_1_2.setBounds(12, 190, 142, 34);
		panel_1.add(lblHostname_1_1_1_1_2);

		txtStatusPut = new JTextField();
		txtStatusPut.setEditable(false);
		txtStatusPut.setText("Status");
		txtStatusPut.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtStatusPut.setColumns(10);
		txtStatusPut.setBounds(12, 236, 330, 33);
		panel_1.add(txtStatusPut);
		JButton btnCheckServer = new JButton("Check Server");
		btnCheckServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evtBtnCheckServer(arg0);
				if (tftp.isCanConnect) {
					btnGet.setEnabled(true);
					btnPut.setEnabled(true);
				} else {
					btnGet.setEnabled(false);
					btnPut.setEnabled(false);
				}
			}
		});
		btnCheckServer.setBounds(596, 30, 155, 25);
		contentPane.add(btnCheckServer);
	}

	private void evtBtnCheckServer(ActionEvent e) {
		String hostname = txtHostName.getText();
		System.out.println(hostname);
		int port = Integer.parseInt(txtPort.getText());
		System.out.println(port);
		tftp.setTFTP_HostIP(hostname);
		tftp.setTFTP_Port(port);
		tftp.checkServerStatus();
		String stas = tftp.serverStatus;
		txtServerStatus.setText(stas);
	}

	private void evtBtnGet(ActionEvent e) throws FileNotFoundException {
		// check input, if wrong notice Error and don't do anything
		if (txtFilenameGet.getText() != null && !txtFilenameGet.getText().isEmpty()&& !txtSaveFile.getText().isEmpty()&& !txtSaveFile.getText().isEmpty()) {
			String fileName = txtFilenameGet.getText();
			String fullDirectionFileName = txtSaveFile.getText() + "/" + fileName;
			// check if the file has Exists and overwrite it if you want
			if (tftp.isFileExist(fullDirectionFileName)) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "File already exists. Do you want to overwrite?",
						"Warning", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					tftp.get(fullDirectionFileName, fileName);
					String stas = tftp.getStatus;
					txtStatusGet.setText(stas);
				}
			} else {
				tftp.get(fullDirectionFileName, fileName);
				String stas = tftp.getStatus;
				txtStatusGet.setText(stas);
			}
		}
		else {
			txtStatusGet.setText("Please enter available input :( ");
		}
	}

	private void evtBtnPut(ActionEvent e) throws IOException {
		String DirectionfileName = txtFileNamePut.getText();
		tftp.put(DirectionfileName);
		String stas = tftp.putStatus;
		txtStatusPut.setText(stas);
	}
}
