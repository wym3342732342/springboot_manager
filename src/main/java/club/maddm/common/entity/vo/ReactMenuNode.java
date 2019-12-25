package club.maddm.common.entity.vo;

import club.maddm.common.entity.Menu;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author King
 * @version 1.0
 * @date 2019/12/14 11:52
 */
@Data
public class ReactMenuNode {
    private String id;
    @NotNull(message = "菜单名称不能为空！")
    private String title;
    private String icon;
    @NotNull(message = "菜单路由不能为空！")
    private String key;
    private String isClick;//是否可点击
    @NotNull(message = "菜单不能没有上级！")
    private String upId;
    private List<ReactMenuNode> children;

    public ReactMenuNode(){}

    public ReactMenuNode(Menu menu) {
        this();
        if (menu == null) {
            return;
        }
        this.id = menu.getId();
        this.title = menu.getTitle();
        this.icon = menu.getIcon();
        this.key = menu.getKey();
        this.isClick = menu.getHavingClick();
        this.upId = menu.getUpId();
    }
}
