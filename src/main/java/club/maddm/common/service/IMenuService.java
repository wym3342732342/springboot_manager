package club.maddm.common.service;

import club.maddm.common.entity.Menu;
import club.maddm.common.entity.vo.ReactMenuNode;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 查询菜单【权限】
     * @return
     */
    List<ReactMenuNode> queryMenunodes();

    /**
     * 保存菜单
     * @param menu
     */
    void saveMenu(Menu menu);

    /**
     * 根据id查询菜单信息
     * @param menuId
     * @return
     */
    ReactMenuNode queryById(String menuId);

    /**
     * 新增或保存菜单
     * @param reactMenuNode
     */
    void save(ReactMenuNode reactMenuNode);
}
