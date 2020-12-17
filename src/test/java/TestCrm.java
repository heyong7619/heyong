import com.shanghai.crm.base.constants.CrmExceptionEnum;
import com.shanghai.crm.base.exception.CrmException;
import com.shanghai.crm.base.util.DateTimeUtil;
import com.shanghai.crm.base.util.MD5Util;
import com.shanghai.crm.base.util.UUIDUtil;
import org.junit.Test;

public class TestCrm {

    //测试自定义异常类的使用
    @Test
    public void test01() {
        int a = 1;
        try {
            if (a == 1) {
                throw new CrmException(CrmExceptionEnum.LOGIN_ACCOUNT_ERROR);
            }
        } catch (CrmException e) {
            System.out.println(e.getMessage());
        }
    }

    //测试主键生成UUID
    @Test
    public void test02(){
        String uuid = UUIDUtil.getUUID();
        System.out.println(uuid);

    }

    //测试MD5加密
    @Test
    public void test03(){
        String md5 = MD5Util.getMD5("heyong");
        System.out.println(md5);
    }

    //测试日期比较
    @Test
    public void test04(){
        String now = DateTimeUtil.getSysTime();
        String time = "2021-10-12";
        System.out.println(now.compareTo(time));
    }

}
