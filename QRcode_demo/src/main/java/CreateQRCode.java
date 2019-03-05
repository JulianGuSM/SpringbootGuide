import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author : Julian
 * @date : 2019/3/5 16:03
 */
public class CreateQRCode {
    public static void main(String[] args) throws WriterException {
        int width = 300;
        int height = 300;
        String format = "png";
        String content = "www.baidu.com";

        //定义二维码参数
        HashMap hashMap = new HashMap(16);
        hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hashMap.put(EncodeHintType.MARGIN, 2);

        try {

            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hashMap);
            Path filePath = new File("C:/Users/Administrator/Pictures/img.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
