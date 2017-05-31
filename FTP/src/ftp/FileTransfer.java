package transfer.client;

import java.io.File;

public interface FileTransfer {

	boolean connect() throws CommunicationException;
	
	boolean send(File file) throws CommunicationException;

	String[] list() throws CommunicationException;
	
	void disconnect() throws CommunicationException;
	
}
