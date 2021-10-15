import com.tuling.javaconfig.controller.TulingTestModelAttributeController;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class ReflectTest {

    public static void main(String[] args) {
        List<String> paramterNames = getParameterNameJava8(
                TulingTestModelAttributeController.class, "updateUser2");
        paramterNames.forEach((x) -> System.out.println(x));
    }

    public static List<String> getParameterNameJava8(Class clazz, String methodName) {
        List<String> paramterList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                //直接通过method就能拿到所有的参数
                Parameter[] params = method.getParameters();
                for (Parameter parameter : params) {
                    paramterList.add(parameter.getName());
                }
            }
        }
        return paramterList;
    }
}
