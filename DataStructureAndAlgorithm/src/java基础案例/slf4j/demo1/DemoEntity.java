package java基础案例.slf4j.demo1;

import java.util.Date;

/**
 * @author dou_zhenjun
 * @date 2023/2/16
 */
public class DemoEntity {
    public String name;
    public String address;
    public Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
