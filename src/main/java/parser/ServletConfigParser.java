package parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import context.Constants;
import servlet.ServletWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServletConfigParser {

    public Map<String, ServletWrapper> parseConfig(String configRaw) throws Exception {
        Map<String, Object> configMap;
        if (configRaw != null && !configRaw.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            configMap = objectMapper.readValue(configRaw, new TypeReference<HashMap<String, Object>>() {
            });
            return parseConfigMap(configMap);
        }
        return null;
    }

    private Map<String, ServletWrapper> parseConfigMap(Map<String, Object> configMap){
        List<Map<String, Object>> servletConfigList = cast(configMap.get(Constants.SERVLET));
        Map<String , ServletWrapper> router = new HashMap<>();
        servletConfigList.forEach(map -> {
            String name = cast(map.get(Constants.SERVLET_NAME));
            String className = cast(map.get(Constants.SERVLET_CLASS));
            String mapping = cast(map.get(Constants.SERVLET_MAPPING));
            router.put(mapping, new ServletWrapper(name, className));
        });
        return router;
    }

    @SuppressWarnings("unchecked")
    public <T> T cast(Object object){
        return (T) object;
    }
}
