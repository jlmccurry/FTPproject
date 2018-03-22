package ftpproject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author jlmcc
 */
public class FtpRetrieve {
    
    private String serverName;
    private int portNum;
    private String userName;
    private String passWord;
    private String remoteFile;
    private String downloadFile;
    private boolean ftpSuccess;
    
    FTPClient ftpClient = new FTPClient();
    
    public void getFile(){
        
        try{
            this.serverName = serverName;
            this.portNum = portNum;
            this.ftpSuccess = ftpSuccess;
            
            ftpClient.connect(serverName, portNum);
            ftpClient.login(userName, passWord);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            String remoteFile = "/test/testFile.txt";
            File downloadFile = new File("C:/testFile.txt");
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
            boolean victory = ftpClient.retrieveFile(remoteFile, outputStream);
            ftpSuccess = victory;
            outputStream.close();
        }
        catch(IOException ex){
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally {
            try {
                if(ftpClient.isConnected()){
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            }
                catch (IOException ex){
                    ex.printStackTrace();
                }
        }
    }  
    
    public String getServerName(){
        return serverName;
    }
    
    public int getPortNum(){
        return portNum;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassWord(){
        return passWord;
    }
    
    public String getRemoteFile(){
        return remoteFile;
    }
    
    public String getDownloadFile(){
        return downloadFile;
    }
    
    public boolean getSuccess(){
        return ftpSuccess;
    }
    
    
    public void setServerName(String server){
        this.serverName = server;
    }
    
    public void setPortNum(int port){
        this.portNum = port;
    }
    
    public void setUserName(String user){
        this.userName = user;
    }
    
    public void setPassWord(String pass){
        this.passWord = pass;
    }
    
    public void setRemoteFile(String rFile){
        this.remoteFile = rFile;
    }
    
    public void setDownloadFile(String dFile){
        this.downloadFile = dFile;
    }
}
