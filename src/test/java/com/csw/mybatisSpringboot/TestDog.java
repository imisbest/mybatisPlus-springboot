package com.csw.mybatisSpringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csw.mybatisSpringboot.entity.Dog;
import com.csw.mybatisSpringboot.entity.DogLeash;
import com.csw.mybatisSpringboot.entity.User;
import com.csw.mybatisSpringboot.service.DogCollarService;
import com.csw.mybatisSpringboot.service.DogLeashService;
import com.csw.mybatisSpringboot.service.DogService;
import com.csw.mybatisSpringboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDog {
    @Autowired
    private DogService dogService;
    @Autowired
    private DogLeashService dogLeashService;
    @Autowired
    private DogCollarService dogCollarService;
    @Autowired
    private UserService userService;
    /*@Autowired
    private HttpServletRequest request;*/
   /* @Test
    public void Test() throws Exception {
        System.out.println("测试成功");


            String username = request.getParameter("username");
            String userName2 = AesUtil.decrypt(username);//对比

    }*/

    @Test
    public void insertDog() {//添加狗mybatis-plus
        Dog dog = new Dog();
        dog.setName("小绿");
        dog.setAge(1);
        dog.setId(UUID.randomUUID().toString().replace("-", ""));
        dogService.insertDog(dog);
    }

    @Test
    public void insertDogForeach() {//批量插入用foreach标签，效率比for循环和mybatisPlus的insertBatch效率要高
        List<Dog> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Dog dog = new Dog();
            dog.setName("小明" + i);
            dog.setAge(i);
            dog.setId(UUID.randomUUID().toString().replace("-", ""));
            list.add(dog);
        }
        if (list.size() > 0) {
            dogService.insertDogForeach(list);
        }

    }

    @Test/*批量插入狗链*/
    public void insertDogLeashForeach() {//批量插入用foreach标签，效率比for循环和mybatisPlus的insertBatch效率要高
        List<Dog> dogList = dogService.selectAllDog();
        List<DogLeash> list = new ArrayList<>();
        for (int i = 0; i < dogList.size(); i++) {
            String dogId = dogList.get(i).getId();
            DogLeash dogLeash = new DogLeash();
            dogLeash.setDogId(dogId);
            dogLeash.setId(UUID.randomUUID().toString().replace("-", ""));
            dogLeash.setColor("银白色" + i);
            dogLeash.setVariety("莫高窟" + i);
            list.add(dogLeash);
        }
        if (list.size() > 0) {
            dogLeashService.insertDogLeashForeach(list);
        }

    }

    @Test
    public void updateDogForeach() {//批量更新用foreach标签，效率比for循环和mybatisPlusinsertBatch效率要高
        List<Dog> dogList = dogService.selectAllDog();
        List<Dog> dogs = new ArrayList<>();
        for (Object o : dogList) {
            Dog dog = (Dog) o;
            dog.setName("小明" + (0));
            dog.setAge(17);
            dogs.add(dog);
        }
        if (dogs.size() > 0) {
            dogService.updateDogForeach(dogs);
        }
    }

    @Test
    public void deleteDogForeach() {//批量更删除用foreach标签，效率比for循环和mybatisPlus的insertBatch效率要高
        List<Dog> list = dogService.selectAllDog();
        String string = "小";
        if (list.size() > 0) {
            dogService.deleteDogForeach(list, string);
        }
    }

    @Test
    public void updateDog() {//更新狗mybatis-plus
        Dog dog = dogService.selectDogById("7f2195eb0fe1403ab33eec0cf5abb197");
        dog.setName("小绿2");
        dogService.updateDog(dog);
    }

    @Test
    public void deleteDog() {//删除狗mybatis-plus
        dogService.deleteById("673c23ed136a415bbca087e793296d49");
    }

    @Test
    public void selectAllDog() {//查询所有狗mybatis-plus
        List<Dog> dogList = dogService.selectAllDog();
        System.out.println(dogList);
    }

    @Test
    public void insertDogLeash() {//添加狗链mybatis-plus
        String dogId = "939ef4945f1b43d9ad986b4843b2c416";
        DogLeash dogLeash = new DogLeash();
        dogLeash.setDogId(dogId);
        dogLeash.setId(UUID.randomUUID().toString().replace("-", ""));
        dogLeash.setColor("银白色");
        dogLeash.setVariety("莫高窟");
        dogLeashService.insertDogLeash(dogLeash);
    }

    @Test
    public void selectDogLeashDogs() {
        List<DogLeash> dogList = dogLeashService.selectDogLeashDogs();
        System.out.println(dogList);
    }

    /*eq	=	eq(“real_name”,“王昭君”)
    ne	<>	ne(“nick_name”,“空想 4”)
    gt	>	gt(“age”,21)
    ge	>=	ge(“age”,22)
    lt	<	lt(“age”,22)
    le	<=	le(“age”,21")
    between	cloum between ? and ?	between(“age”,0,21)
    notBetween	cloum between ? and ?	notBetween(“age”,0,21)
    like	cloum like ‘% 王 %’	like(“real_name”,“王”)
    notLike	not like ‘% 王 %’	notLike(“real_name”,“王”)
    likeLeft	like ‘% 王’	likeLeft(“real_name”,“昭”)
    likeRight	like ‘王 %’	likeRight(“real_name”,“昭”)
    isNull	is null	isNull(“gender”)
    isNotNull	is not null	isNotNull(“gender”)
    in	in (1,2,3)	in(“nick_name”,lists)
    notIn	age not in (1,2,3)	notIn(“nick_name”,lists)
    inSql	age in (1,2,3,4,5,6)	inSql(“nick_name”,"‘空想 4’,‘空想 5’,‘空想 6’")
    notInSql	age not in (1,2,3,4,5,6)	notInSql(“nick_name”,"‘空想 4’,‘空想 5’,‘空想 6’")
    groupBy	group by id,name	groupBy(“nick_name”,“age”)
    orderByAsc	order by id ASC,name ASC	orderByAsc(“nick_name”,“age”)
    orderByDesc	order by id DESC,name DESC	orderByDesc(“age”)
    orderBy	order by id ASC,name ASC	orderBy(true,true,“age”)
    having	having sum(age) > 10	having(“sum(age) > 10”)
    or	id = 1 or name = ‘老王’	eq(“nick_name”,“空想 4”).or(i->i.eq(“age”,21) eq(“nick_name”,“空想 4”).or().eq(“nick_name”,“空想 5”)
    and	and (name = ‘李白’ and status <> ‘活着’)	and(i->i.eq(“age”,21))
    nested	(name = ‘李白’ and status <> ‘活着’)	nested(i->i.eq(“age”,21).eq(“nick_name”,“空想 4”))
    apply	id = 1	apply(“nick_name = ‘空想 4’”)
    last	最后添加多个以最后的为准，有 sql 注入风险	last(“limit 1”)
    exists	拼接 EXISTS (sql 语句)	exists(“select id from table where age = 1”)
    notExists	拼接 NOT EXISTS (sql 语句)	notExists(“select id from table where age = 1”)*/
    @Test
    public void pagetable() {//单表分页mybatis-plus
        int currentPage = 1;//1,0,都是第一页
        int pageSize = 3;
        Page<Dog> page = new Page<>(currentPage, pageSize);
        // page.setDesc("name");
        QueryWrapper<Dog> queryWrapper = new QueryWrapper<>();
        Map<String, Object> map = dogService.selectPage(page, queryWrapper);
        for (String obj : map.keySet()) {
            System.out.println("键：" + obj);
            System.out.println("键" + map.get(obj));
        }
    }

    @Test
    public void selectTables() {//多表查询(一对多)（需要手动写sql）
        Map<String, Object> map = dogService.selectTables();
        for (String obj : map.keySet()) {
            System.out.println("键：" + obj);
            System.out.println("键" + map.get(obj));
        }
    }

    @Test/*反例*//*可以正常查询封装，每页的条数不对*/
    public void selectPageTables() {//多表查询分页（一对多）（需要手动写sql，先分页查询再封装（适合一对一联表））
        /*用limit分页，首页从0开始*/
        int currentPage = 0;
        int pageSize = 3;
        Map<String, Object> map = dogService.selectpageTables(currentPage, pageSize);
        for (String obj : map.keySet()) {
            System.out.println("键：" + obj);
            System.out.println("键" + map.get(obj));
        }
    }

    @Test/*反例*//*可以正常查询封装，每页的条数不对*/
    public void selectTablePage() {//多表查询分页（一对多）（需要手动写sql,mybatis-plus,先分页查询再封装（适合一对一联表））
        /*用mybatis-plus分页，0就是1，1还是1*/
        int currentPage = 1;
        int pageSize = 3;
        Page<Dog> page0 = new Page<>(currentPage, pageSize);
        Page<Dog> dogPage = dogService.selectTablePage(page0);
        System.out.println(dogPage.getRecords());
    }

    /*真正的一对多分页，后续的*/
    @Test
    public void selectTablesByLast() {//多表查询(一对多)（需要手动写sql,需要先查询出所有结果并且后续分装）
        /*第一页从1开始算*/
        int currentPage = 1;
        int pageSize = 3;
        Map<String, Object> map = dogService.selectTablesByLast(currentPage, pageSize);
        for (String obj : map.keySet()) {
            System.out.println("键：" + obj);
            System.out.println("键" + map.get(obj));
        }
    }

    @Test
    public void selectOneToOneByMybatisPlusPage() {//多表查询(一对一)（需要手动写sql
        /*第一页从1开始算*/
        int currentPage = 1;
        int pageSize = 3;
        Map<String, Object> map = dogLeashService.selectOneToOneByMybatisPlusPage(currentPage, pageSize);
        for (String obj : map.keySet()) {
            System.out.println("键：" + obj);
            System.out.println("键" + map.get(obj));
        }
    }

    @Test
    public void uuid() {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString().replace("-", ""));
        }
    }

    /*真正的多对多分页，后续的*/
    @Test/*一个狗圈多个狗链*/
    public void selectCollarLeashByLast() {//多表查询(多对多)（需要手动写sql,需要先查询出所有结果并且后续分装）
        /*第一页从1开始算*/
        int currentPage = 1;
        int pageSize = 1;
        Map<String, Object> map = dogCollarService.selectCollarLeashByLast(currentPage, pageSize);
        for (String obj : map.keySet()) {
            System.out.println("键：" + obj);
            System.out.println("键" + map.get(obj));
        }
    }

    @Test
    public void insertUser() {//添加用户mybatis-plus
        //数据库里面的id可以不是,id如（user_id）
        User user = new User();
        user.setUsername("aaa");
        user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        userService.insertUser(user);
    }

}
