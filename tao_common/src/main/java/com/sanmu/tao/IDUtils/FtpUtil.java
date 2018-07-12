package com.sanmu.tao.IDUtils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-12 13:29
 **/
public class FtpUtil {

    public static boolean uploadFile(String host, int port, String username, String password, String basePath, String filePath, String fileName, InputStream input) throws IOException {
        boolean result = false;

        FTPClient ftpClient = new FTPClient();

        int reply;

        try {
            ftpClient.connect(host,port);
            ftpClient.login(username,password);
            reply = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply)){
                ftpClient.disconnect();
                return result;
            }
            if(!ftpClient.changeWorkingDirectory(basePath+filePath)){
               String[] dirs = filePath.split("/");
               String tempPath = basePath;
               for(String dir : dirs){
                   if(null == dir || "".equals(dir)){
                       continue;
                   }
                   tempPath += "/" + dir;

                   if(!ftpClient.changeWorkingDirectory(tempPath)){
                       if(!ftpClient.makeDirectory(tempPath)){
                           return result;
                       }else{
                           ftpClient.changeWorkingDirectory(tempPath);
                       }
                   }
               }
            }
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            if(!ftpClient.storeFile(fileName,input)){
                return result;
            }
            input.close();
            ftpClient.logout();
            result = true;

        } catch (IOException e) {
            throw e;
        }finally {
            if(ftpClient.isConnected()){
                ftpClient.disconnect();
            }
        }
        return result;
    }
}
