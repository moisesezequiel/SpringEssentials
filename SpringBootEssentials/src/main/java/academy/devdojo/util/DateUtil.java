package academy.devdojo.util;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public String formatLocalDate(LocalDateTime dateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dateTime);
    }
}
