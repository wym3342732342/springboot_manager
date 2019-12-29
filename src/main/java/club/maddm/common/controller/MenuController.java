package club.maddm.common.controller;


import club.maddm.common.entity.vo.ReactMenuNode;
import club.maddm.common.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author king
 * @since 2019-12-14
 */
@Api(value = "菜单Controller",tags = {"返回用户菜单的相关信息","根据权限返回"})
@RestController
@RequestMapping("/common/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    @ApiOperation(value = "根据权限返回菜单",notes = "提示内容")
    @GetMapping("query")
    public ResponseEntity<List<ReactMenuNode>> queryMenu() {
        return ResponseEntity.ok(iMenuService.queryMenunodes());
    }

    @ApiOperation(value = "返回菜单选择树所需数组",notes = "提示内容")
    @GetMapping("querySelectTree")
    public ResponseEntity<List<ReactMenuNode>> queryMenuSelectTree() {
        ReactMenuNode reactMenuNode = new ReactMenuNode();
        reactMenuNode.setId("0");
        reactMenuNode.setIcon("home");
        reactMenuNode.setTitle(" -- 天玺科技 -- ");
        reactMenuNode.setChildren(iMenuService.queryMenunodes());
        return ResponseEntity.ok(Collections.singletonList(reactMenuNode));
    }

    @ApiOperation(value = "根据id查询菜单")
    @GetMapping("{id}")
    public ResponseEntity<ReactMenuNode> queryById(@ApiParam("菜单id") @PathVariable("id") String id) {
        return ResponseEntity.ok(iMenuService.queryById(id));
    }

    @ApiOperation(value = "根据id删除菜单")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@ApiParam("菜单id") @PathVariable("id") String id) {
        iMenuService.removeById(id);
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value = "保存或更新菜单，有id就是更新")
    @PostMapping
    public ResponseEntity<Void> save(@ApiParam("菜单vo") @Validated ReactMenuNode reactMenuNode) {
        iMenuService.save(reactMenuNode);
        return ResponseEntity.ok().build();
    }
}

