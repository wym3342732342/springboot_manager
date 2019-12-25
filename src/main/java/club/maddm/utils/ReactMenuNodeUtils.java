package club.maddm.utils;

import club.maddm.common.entity.Menu;
import club.maddm.common.entity.vo.ReactMenuNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author King
 * @version 1.0
 * @date 2019/12/14 14:03
 */
public class ReactMenuNodeUtils {
    /**
     * 分类
     * @param menus
     * @return
     */
    public static Map<String, List<ReactMenuNode>> classification(List<Menu> menus) {
        HashMap<String, List<ReactMenuNode>> map = new HashMap<>();

        menus.forEach(menu->{//转换为ReactMenu并分类放入map
            ReactMenuNode node = new ReactMenuNode(menu);
            if (map.containsKey(node.getUpId())) {
                map.get(node.getUpId()).add(node);
            }else {
                List<ReactMenuNode> nodes = new ArrayList<>();
                nodes.add(node);
                map.put(node.getUpId(), nodes);
            }
        });

        return map;
    }


    /**
     * 拼装成树
     * @return
     */
    public static List<ReactMenuNode> assemble(Map<String,List<ReactMenuNode>> map,String upId) {
        if (map.containsKey(upId)) {
            List<ReactMenuNode> reactMenuNodes = map.get(upId);
            reactMenuNodes.forEach(reactMenuNode -> {
                reactMenuNode.setChildren(assemble(map, reactMenuNode.getId()));
            });
            return reactMenuNodes;
        }
        return null;
    }
}
