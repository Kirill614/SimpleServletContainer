package servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.lang.reflect.Constructor;
import java.util.Map;
import static utils.Cast.cast;

public class ServletLoader {
    private Map<String, ServletWrapper> router;
    private ClassLoader classLoader;

    public ServletLoader(Map<String, ServletWrapper> router){
        this.router = router;
        classLoader = ClassLoader.getSystemClassLoader();
    }

    public Servlet loadServlet(String path) throws Exception{
        ServletWrapper wrapper = router.get(path);
        if(wrapper == null) throw new Exception("servlet doesnot exists");
        Servlet servlet = wrapper.getServlet();

        if (servlet == null){
            Class<? extends Servlet> servletClass = cast(classLoader.loadClass(wrapper.getClassName()));
            Constructor<? extends Servlet> constructor = servletClass.getConstructor();
            servlet = constructor.newInstance();
            wrapper.setServlet(servlet);
            wrapper.setServletClass(servletClass);
        }
        return servlet;
    }

}
