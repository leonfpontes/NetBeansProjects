package ftp;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.WindowsFakeFileSystem;

public class FTP {

	public static void main(String[] args) {
		String path = "c:\\data";
		
		FakeFtpServer fakeFtpServer = new FakeFtpServer();
		fakeFtpServer.setServerControlPort(5000);
		fakeFtpServer.addUserAccount(new UserAccount("xpto", "123456", path));

		FileSystem fileSystem = new WindowsFakeFileSystem();
		fileSystem.add(new DirectoryEntry(path));
		fileSystem.add(new FileEntry(path + "\\file1.txt", "abcdef 1234567890"));
		fileSystem.add(new FileEntry(path + "\\run.exe"));
		fakeFtpServer.setFileSystem(fileSystem);

		fakeFtpServer.start();
		
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}