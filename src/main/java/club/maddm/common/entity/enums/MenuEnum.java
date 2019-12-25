package club.maddm.common.entity.enums;

/**
 * @author King
 * @version 1.0
 * @date 2019/12/14 11:56
 */
public enum MenuEnum{
    HAVE_KIDS("1","有子节点"),
    NOT_HAVE_KIDS("0","没有子节点"),
    ;

    public String value;
    private String title;

    MenuEnum(String value,String title) {
        this.value = value;
        this.title = title;
    }
}
