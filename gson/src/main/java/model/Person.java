package model;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chaoshuai.li on 2017/11/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private Date birth;
    private String name;
}
