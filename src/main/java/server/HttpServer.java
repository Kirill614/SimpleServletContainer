package server;

import context.Configuration;
import context.ContextLoader;
import context.MainContext;
import lifecycle.LifeCycle;
import servlet.ServletWrapper;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HttpServer implements LifeCycle {
    private Set<MainContext> contexts = new HashSet<>();
    private ContextLoader contextLoader;

    public void addContext(MainContext context){
        contexts.add(context);
    }

    public HttpServer(){
        contextLoader = new ContextLoader(this);
        init();
    }

    @Override
    public void init(){
        try {
            contextLoader.loadContext();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(){
        contexts.forEach(context -> {
//            Map<String, ServletWrapper> router = context.getConfiguration().getRouter();
//            router.forEach((key, value) -> {
//                System.out.println(key);
//                System.out.println(value.getClassName() + "   " + value.getName());
//            });
            context.init();
            context.start();
        });
        System.out.println("server starts!");
    }

    @Override
    public void destroy(){

    }
}
