package servlet;

import javax.servlet.Servlet;

public class ServletWrapper {
    private String name;
    private String className;
    private Class<? extends Servlet> servletClass;
    private Servlet servlet;

    public ServletWrapper(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class<? extends Servlet> getServletClass() {
        return servletClass;
    }

    public void setServletClass(Class<? extends Servlet> servletClass) {
        this.servletClass = servletClass;
    }

    public Servlet getServlet() {
        return servlet;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}
