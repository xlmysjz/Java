package webdriverupload;
import webdriverupload.EmailUpload;;

public class Run
{

    
    public static void main(String[] args)
    {
	EmailUpload uploadImage = new EmailUpload();
	uploadImage.InitBrowser();
	uploadImage.Login();
	uploadImage.UploadImage();

    }

}
