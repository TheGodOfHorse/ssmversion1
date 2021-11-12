package com.dqdwd.controller;

import com.dqdwd.pojo.ProductInfo;
import com.dqdwd.service.ProductInfoService;
import com.dqdwd.utils.FileNameUtil;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductAction {
    @Autowired
    private ProductInfoService productInfoService;
    public static final Integer PAGE_SIZE=5;
    String saveFileName="";
    //获取全部商品
    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<ProductInfo> list = productInfoService.getAll();
        model.addAttribute("list",list);
        return "product";
    }
   //分页操作
    @RequestMapping("/split")
    public String split(Model model){
        PageInfo info = productInfoService.splitPage(1, PAGE_SIZE);
        model.addAttribute("info",info);
        return "product";
    }
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void split(int page, HttpSession session){
        PageInfo info = productInfoService.splitPage(page, PAGE_SIZE);
        session.setAttribute("info",info);
    }
    @ResponseBody
    @RequestMapping("/ajaxImg")
    public Object split(MultipartFile pimage,HttpSession session){
        //得到文件名
      String saveName= FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());
      //获取路径
        String path=session.getServletContext().getRealPath("/image_big");
        //转存
        try {
            pimage.transferTo(new File(path+File.separator+saveName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object=new JSONObject();
        object.put("imgurl",saveName);
        return object.toString();
    }
    @RequestMapping("/save")
    public String save(Model model,ProductInfo productInfo){
        productInfo.setpImage(saveFileName);
        productInfo.setpDate(new Date());
        productInfoService.addProductInfo(productInfo);
        if(productInfo==null){
            model.addAttribute("msg","添加失败");
        }else{
            model.addAttribute("msg","添加成功");
        }
          return "forward:/prod/split.action";
    }
}
