package com.practice.sms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.practice.sms.bean.*;
import com.practice.sms.service.VipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * zyd 2023 07
 */
@Controller
@RequestMapping("/vip")
public class VipController {
    @Resource
    private VipService vipService;

    /**
     * 查询所有会员信息(这里用到了PageHelper分页插件)
     *
     * @param pn 传入要查询的页码(要查询第几页的数据)
     * @param model 为了将数据传入到cookie域中方便取出数据
     * @return 返回vip.jsp页面
     */
    @RequestMapping("/vipList")
    public String getAllVip(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                 Model model) {
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Vip> products = vipService.getAllVip();
        // 使用PageInfo包装查询后的结果, 只需要将PageInfo交给页面就行了(param2:表示分页条显示的页数)
        PageInfo<Vip> pageInfo = new PageInfo<>(products, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "vip/vip";
    }

    /**
     * ===> 携带选中条目的id查询出的商品信息跳转到添加修改页面
     *
     * @param vipId 从按钮上得到的会员id
     * @param model 用于表单提交时传给updateProductByProductId()方法id, 便于根据id修改
     * @return vipUpdate.jsp
     */
    @RequestMapping("/toUpdateVipPage")
    public String toUpdateVipPage(@RequestParam("vipId") Integer vipId, Model model) {
//        model.addAttribute("productId", productId);
//        productService.getProductSalePriceByProductId()
        System.out.println("**********表单得到的id = " + vipId);
        Vip selectedVip = vipService.getVipByVipId(vipId);
       System.out.println("===> " + selectedVip);
        model.addAttribute("selectedVip", selectedVip);
        return "vip/vipUpdate";
    }

    /**
     * ===> 执行更新会员信息逻辑
     * 根据会员id(表单提交封装后获取id)更新商品信息
     *
     * @param vip 表单封装的vip实体类
     * @return forward:/vip/vipList
     */
    @RequestMapping("/updateVipByVipId")
    public String updateViptByVipId(Vip vip) {
        System.out.println("******FORM:" + vip);
        int row = vipService.updateVipByVipId(vip);
        System.out.println("影响的行数：" + row);
        return "forward:/vip/vipList";
    }

    /**
     * ===> 删除选中条目的会员
     * 按照会员id删除会员
     *
     * @param vipId 会员id
     * @return forward:/vip/vipList
     */
    @RequestMapping("/deleteVip")
    public String deleteVipByVipId(@RequestParam("vipId") Integer vipId) {
        int row = vipService.deleteVipByVipId(vipId);
        System.out.println("删除操作影响的行数：" + row);
        return "forward:/vip/vipList";
    }


    /**
     * ===> 携带系统分组信息及供应商信息跳转到添加会员页面
     *
     * (Pre)仅仅是跳转到添加会员页面
     *
     * @return vip.jsp
     */
    @RequestMapping("/toAddVipPage")
    public String toAddVipPage(Model model) {
        return "vip/vipAdd";
    }


    /**
     * ===> 执行新增会员逻辑
     *
     * 执行添加数据操作, 之后返回到查询界面
     *     - 这里有报错 org.apache.ibatis.reflection.ReflectionException:
     *       There is no getter for property named 'product' in 'class com.wxl.sms.bean.Product'
     *     - 当时仅仅考虑到了是SpringMVC没有自动封装成JavaBean, 一直在表单上找原因, 搜了一些帖子后发现, 是
     *       mybatis方面的报错信息, 并且在这里先打印参数product的值, 也排除了不是没有封装成功的原因,
     *       所以呀, 看报错信息去精准定位!!!
     *
     * @param vip vip
     * @return forward:/vip/vipList
     */
    @RequestMapping("/addVip")
    public String addVip(@ModelAttribute("vipAddForm") Vip vip) {
        System.out.println(vip);
        int row = vipService.addVip(vip);
        System.out.println("影响的行数：" + row);
        return "forward:/vip/vipList";
    }

    /**
     * “用于搜索显示, 根据商品名称查询后显示” 的Pro版
     *      1、原先的方法, 按照商品类别搜索后, 点击该类别下的第二页时, 页面实际显示结果为所有商品列表的第二页 --> BUG
     *      2、之前未解决的原因: 一直在想着怎么在点击超链接的时候提交表单
     *      3、解决思路: 想要点击超链接的时候提交表单, 也就是为了获取表单里的groupId数据, 这里将点击搜索时用的groupId
     *         以Model的格式传递到页面中(searchVip.jsp), 下一次点击类似第二页的操作时, 获取到该分类的id号, 去取代
     *         从表单中获取的值
     *              - 前提条件: 做了优化, 默认分类不是食品(遍历第一项), 而是提示信息, 并且值为 0, 后端处理时, 若值为0
     *                则赋值productId为null, 此时MyBatis后端代码, 将不带有此条件(动态SQL);
     *              - 取代表单中获取的productId, 是有条件的, 如果用户什么也不填, 那Model返回的值就是null, 在方法处理时
     *                添加了postGroupId默认值也为0, 如果为0, 那么就不接管替代表单值;
     *
     * @param pn 传入要查询的页码(要查询第几页的数据)
     * @param request 用于获取表单中填写的值
     * @param model 为了将数据传入到cookie域中方便取出数据
     * @return searchVip.jsp
     */
    @RequestMapping("/searchPro")
    public String getVipInfoBySearchPro(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                            HttpServletRequest request, Model model) {
        String vipName = "";
        // 表单输入的会员名称
        if (request.getParameter("vipNameInForm") != null) {
            vipName = request.getParameter("vipNameInForm");
        }

        PageHelper.startPage(pn, 5);
        List<Vip> vip = vipService.getVipByVipName(vipName);
//        System.out.println("*********" + products);
        PageInfo<Vip> pageInfo = new PageInfo<>(vip, 5);
        model.addAttribute("pageInfo", pageInfo);

        // 2021年4月30日03:21:12(测试用)
        return "vip/searchVip";
    }
}
