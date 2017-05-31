package ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpFileTransferClient implements FileTransfer {

	private FTPClient ftp;

	private String url;
	
	private String user;
	
	private String passwd;
	
	private int port = 21;
	
	public FtpFileTransferClient(String url, String user, String passwd) {
		ftp = new FTPClient();
		this.url = url; 
		this.user = user;
		this.passwd = passwd;
    }

	public FtpFileTransferClient(String url, int port, String user, String passwd) {
		ftp = new FTPClient();
		this.url = url; 
		this.port = port;
		this.user = user;
		this.passwd = passwd;
    }
	
	private boolean login() throws IOException {
		boolean success = false;
		// Verifica se conectou com sucesso.
		if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
			// Autentica o usu�rio.
			success = ftp.login(user, passwd);
		}
		return success;
	}
	
	private void logout() throws IOException {
		ftp.logout();
	}
	
        @Override
	public boolean connect() throws CommunicationException {
		boolean success = false;
		try {
			ftp.connect(url, port);
			success = login();
		} catch (IOException e) {
			new CommunicationException(e);
		}
		return success;
	}
	
        @Override
	public void disconnect() throws CommunicationException {
		try {
                        logout();
                        if (ftp.isConnected()) {        	
	        	// Desconecta do servidor.
				ftp.disconnect();
        	}
		} catch (IOException e) {
			new CommunicationException(e);
		}
	}
	
        @Override
	public boolean send(File file) throws CommunicationException {
		boolean success = false;
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			// Transfere o arquivo.
			success = ftp.storeFile(file.getName(), fis);
		} catch (FileNotFoundException e) {
			throw new CommunicationException("File to be transfered not found.", e);
		} catch (IOException e) {
			throw new CommunicationException(e);
		}
		return success;
	}

        @Override
	public String[] list() throws CommunicationException {
		String[] files = null;
		try {
			files = ftp.listNames();
		} catch (IOException e) {
			throw new CommunicationException(e); 
		}
		return files;
	}

}