package com.zakaria;

import java.util.HashMap;
import java.util.Map;

public class MaFactory {
    
    private Map<String, String> map;

    public MaFactory() {
        // Use our simple Parser class to read from config.xml
        Parser xmlParser = new Parser();
        map = xmlParser.parseConfig("config.xml");
    }

    public Action getMonAction(String provonce) {
        String monClass = map.get(provonce);
        
        if (monClass != null) {
            try {
                Class<?> c = Class.forName(monClass);
                return (Action) c.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
}
