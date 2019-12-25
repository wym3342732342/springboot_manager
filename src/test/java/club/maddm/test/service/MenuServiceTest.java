package club.maddm.test.service;

import club.maddm.common.entity.Menu;
import club.maddm.common.entity.vo.ReactMenuNode;
import club.maddm.common.mapper.MenuMapper;
import club.maddm.common.service.IMenuService;


import club.maddm.config.IpConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.List;

/**
 * menu的方法测试
 * @author King
 * @version 1.0
 * @date 2019/12/14 13:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {


    @Autowired
    private IMenuService iMenuService;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    IpConfiguration ipConfiguration;



    @Test
    public void testAddMenu() {
        //用户管理
        Menu menu = new Menu();
        menu.setId(null);
        menu.setKey("/component/select");//路由
        menu.setTitle("选择器组件");//菜单名称
        menu.setIcon("check");//图标
        menu.setUpId("1205723820975456257");//上级id

        iMenuService.saveMenu(menu);
    }

    @Test
    public void testQueryMenu() {
        List<ReactMenuNode> reactMenuNodes =
                iMenuService.queryMenunodes();
        reactMenuNodes.forEach(System.out::println);
    }

    @Test
    public void testPath() {


    }
}
