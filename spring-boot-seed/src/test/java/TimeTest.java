import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/6/11 13:45
 */
public class TimeTest {
    public static void main(String[] args) {
        System.out.println(getMessageExpireTime());
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        System.out.println(dt.getSecond());
    }

    private static int getMessageExpireTime() {
        String resetTimeS = "23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Integer resultTime = 0;
        try {
            Long nowTime = sdf.parse(sdf.format(new Date())).getTime() / 1000;
            Long resetTime = sdf.parse(resetTimeS).getTime() / 1000;
            resetTime = resetTime - nowTime;
            resultTime = Integer.parseInt(String.valueOf(resetTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultTime;
    }
}
