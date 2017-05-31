package transfer.client;

import java.io.File;

public class TesteFtpClient {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir") + File.separator;
		
		FileTransfer ft = new FtpFileTransferClient("localhost", 5000, "xpto", "123456");
		try {
			ft.connect();
			
			ft.send(new File(path + "duke.png"));

			String[] files = ft.list();
			if (files != null) {
				for (String file : files) {
					System.out.println(file);
				}
			}
			
			ft.disconnect();
			
		} catch (CommunicationException e) {
			e.printStackTrace();
		}
	}
	
}
