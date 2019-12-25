package club.maddm;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * 代码开始生成,id雪花算法，默认使用lombok
 * @author King
 * @version 1.0
 * @date 2019/12/10 17:36
 */
public class GenerateBoot {
    private static final String URL
            = "jdbc:mysql://127.0.0.1:33306/universal_manage?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private static final String DRIVERNAME
            = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final String PARENTPACKAGE = "club.maddm";//基础包名
    private static final String MODELNAME = "common";//模块名称,可没有直接生成到club.maddm
    private static final String TABLEPREFIX = "common";//可以与模块名相同，如果有前缀必须添加

    //需要生成的表名数组
    private static final String[] TABLENAME = {
            "common_user_role",
    };

    public static void main(String[] args) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DRIVERNAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        dsc.setDbType(DbType.MYSQL);//数据库类型
        dsc.setTypeConvert(new MySqlTypeConvert(){

            //自定义数据库表字段类型转换【可选】
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String t = fieldType.toLowerCase();
                if (t.contains("date")) {
                    return DbColumnType.DATE;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        });//设置类型转换


        CodeGenerator.generate(dsc,MODELNAME,TABLENAME,TABLEPREFIX,PARENTPACKAGE);
    }
}
