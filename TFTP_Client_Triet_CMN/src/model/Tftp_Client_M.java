package model;

import org.apache.commons.net.tftp.TFTPClient;
import org.apache.commons.net.tftp.TFTPPacket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.commons.net.tftp.TFTP;

public class Tftp_Client_M {
	private InetAddress inetAddress = null;
	private String TFTP_HostIP;
	private int TFTP_Port;
	private int TFTP_OCTET_MODE;
	TFTPClient tftp_c = new TFTPClient();
	public String serverStatus;
	public String getStatus;
	public String putStatus;
	public boolean isCanConnect = false;

	public static void main(String[] args) {
		/*
		 * Tftp_Client_M obj = new Tftp_Client_M(); if(!obj.isFileExist("test")) { try {
		 * 
		 * obj.get("test"); } catch (FileNotFoundException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }} try { obj.put("haha", "haha"); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	public void checkServerStatus() {
		try {
			inetAddress = InetAddress.getByName(getTFTP_HostIP());
		} catch (UnknownHostException e1) {
			isCanConnect = false;
			serverStatus = "Wrong type of HostIP! Try again!";
			System.out.println(serverStatus);
			e1.printStackTrace();
			return;
		}
		try {
			if (!inetAddress.isReachable(2000)) {
				isCanConnect = false;
				serverStatus = "Server is not responding. Try Again!";
				System.out.println(serverStatus);
			} else {
				isCanConnect = true;
				serverStatus = "Server is running.";
				System.out.println(serverStatus);
			}
		} catch (IOException e1) {
			isCanConnect = false;
			serverStatus = "Error check connect!";
			System.out.println(serverStatus);
			e1.printStackTrace();
		}
	}

	public void get(String direcfileName, String fileName) {
		// Step 0 Prepared to connect server
		checkServerStatus();
		// Step 1 sending request RRQ to TFTP server for a file
		// Step 2 receive file from TFTP server
		// Step 3 write file to local direction
		File outFile = new File(direcfileName);
		OutputStream ops = null;
		try {
			ops = new FileOutputStream(outFile);
		} catch (FileNotFoundException e1) {
			getStatus = "Wrong direction!!!!";
			System.out.println(getStatus);
			outFile.delete();
			e1.printStackTrace();
			return;
		}
		try {
			tftp_c.setDefaultTimeout(60000);
			tftp_c.open();
			tftp_c.setSoTimeout(5000);
			int bytereceive = tftp_c.receiveFile(fileName, TFTP_OCTET_MODE, ops, inetAddress, getTFTP_Port());
			getStatus = "Get File Success! File received: " + bytereceive + " bytes";
			System.out.println(getStatus);
		} catch (IOException e) {
			getStatus = "File not found!";
			outFile.delete();
			System.out.println(getStatus);
			e.printStackTrace();
		}
	}

	public boolean isFileExist(String directfileName) {
		File file;
		file = new File(directfileName);
		// If file exists, don't overwrite it.
		if (file.exists()) {
			System.err.println("File: " + directfileName + " already exists.");
			return true;
		}
		file.delete();
		return false;
	}

	public void put(String directionFile) throws IOException {
		// step 0 prepared to connect
		checkServerStatus();
		// send file to server
		FileInputStream input = null;
		File file = new File(directionFile);
		String[] arrayFileName = directionFile.split("/");
		String fileName = arrayFileName[arrayFileName.length - 1];
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			tftp_c.close();
			putStatus = "Could not open file to put!";
			System.out.println(putStatus);
			return;
		}
		try {
			tftp_c.setDefaultTimeout(10000);
			tftp_c.open();
			tftp_c.setSoTimeout(4000);
			tftp_c.sendFile(fileName, TFTP_OCTET_MODE, input, inetAddress, getTFTP_Port());
			putStatus = "Put File Success!";
			System.out.println(putStatus);
		} catch (IOException e) {
			putStatus = "Something Errors.Check a Port and try again!";
			System.out.println(putStatus);
			e.printStackTrace();
		}
	}

	public String getTFTP_HostIP() {
		return TFTP_HostIP;
	}

	public void setTFTP_HostIP(String tFTP_HostIP) {
		TFTP_HostIP = tFTP_HostIP;
	}

	public int getTFTP_Port() {
		return TFTP_Port;
	}

	public void setTFTP_Port(int tFTP_Port) {
		TFTP_Port = tFTP_Port;
	}
}
